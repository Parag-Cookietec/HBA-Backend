package gov.ifms.gst.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import gov.ifms.gst.util.GSTUtility;
import gov.ifms.gst.workflow.service.GstWfActionConfigService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.gst.accounting.dto.CinEpy;
import gov.ifms.gst.accounting.dto.CinNer;
import gov.ifms.gst.accounting.dto.CinOtc;
import gov.ifms.gst.accounting.dto.EodDataCinFile;
import gov.ifms.gst.converter.GSTCINFileDataConvertor;
import gov.ifms.gst.dto.Dtos;
import gov.ifms.gst.dto.EODCINFileDataDto;
import gov.ifms.gst.dto.EODCINFileReportDto;
import gov.ifms.gst.dto.VoucherDto;
import gov.ifms.gst.entity.EODCINFileData;
import gov.ifms.gst.entity.FileAccountingProcessed;
import gov.ifms.gst.entity.GSTFileProcess;
import gov.ifms.gst.pagination.GstSearchCriteria;
import gov.ifms.gst.pagination.SpecificationImpl;
import gov.ifms.gst.repository.FileAccountingProcessedRepository;
import gov.ifms.gst.repository.FileTypeHdrRepository;
import gov.ifms.gst.repository.GSTCINFileDataRepository;
import gov.ifms.gst.repository.GSTFileProcessRepository;
import gov.ifms.gst.util.DateUtil;
import gov.ifms.gst.util.GSTConstant;

@Service
public class EODCINFileDataServiceImpl {

	@Autowired
	private GSTCINFileDataConvertor convertor;

	@Autowired
	private GSTCINFileDataRepository repository;
	@Autowired
	private FileTypeHdrRepository hdrRepository;
	@Autowired
	private FileAccountingProcessedRepository processRepository;

	@Autowired
	private GSTFileProcessRepository fileRepository;

	@Autowired
	private GstWfActionConfigService gstWfActionConfigService;

	public EODCINFileDataDto getById(Long id) {
		return convertor.toDTO(repository.getOne(id));
	}

	public EODCINFileDataDto create(EODCINFileDataDto dto) {
		return convertor.toDTO(repository.save(convertor.toEntity(dto)));
	}

	public EODCINFileDataDto update(EODCINFileDataDto dto) {
		return convertor.toDTO(repository.save(convertor.toEntity(dto)));
	}

	public PagebleDTO<EODCINFileDataDto> getAll(PageDetails pageDetail) throws CustomException {

		try {
			PageRequest pageable = null;
			GstSearchCriteria searchCriteria = new GstSearchCriteria();
			SpecificationImpl<EODCINFileData> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<EODCINFileData> dataSpec = searchCriteria.getfile(spec, pageDetail.getJsonArr());
			Page<EODCINFileData> page = repository.findAll(dataSpec, pageable);
			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					convertor.toDTO(page.getContent()));
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	public VoucherDto voucherCreate(VoucherDto dto) throws CustomException {
		VoucherDto voucher = new VoucherDto();
		List<Dtos> dum = new ArrayList<>();
		String si = " ";
		fileRepository.findByFileName(dto.getFileName()).ifPresent(file -> {
			List<EODCINFileData> r = repository.findByCpinDt(dto.getFileDate());
			r.forEach(d -> {
				Dtos dums = new Dtos();
				try {
					voucher.setFileName(dto.getFileName());
					voucher.setFileDate(dto.getFileDate());
					voucher.setRefrenceNo(getTransactionNo());
					dums.setDescription(d.getBankCd());
					dums.setNoOfTransaction(repository.countByBankCd(d.getBankCd()));
					dums.setAmount(repository.findByBankCd(d.getBankCd()).getTotalAmt());
					dum.add(dums);
					voucher.setFileTypeCd(d.getFileTypeCd());
					LocalDate currentdate = LocalDate.now();
					voucher.setVoucherNo(generateVoucherNo(processRepository.count() + 1, currentdate.getYear(),
							currentdate.getMonthValue()));
					voucher.setTotalAmount(voucher.getTotalAmount() + dums.getAmount());
					voucher.setTotalNoOfTransaction(
							(short) (voucher.getTotalNoOfTransaction() + dums.getNoOfTransaction()));
					voucher.setStateCd(d.getStateCd());
					voucher.setMenuId(dto.getMenuId());
				} catch (CustomException e) {
					e.printStackTrace();
				}

			});
		});
		createEntry(voucher, si);
		voucher.setDtos(dum);
		return voucher;
	}

	private void createEntry(VoucherDto voucher, String si) throws CustomException {
		FileAccountingProcessed f = new FileAccountingProcessed();
		createFileProcess(voucher);
		GSTFileProcess file = fileRepository.findByFileName(voucher.getFileName()).get();
		if (!(processRepository.findByFileProcessId(file)).isPresent()) {
			f.setFileProcessId(fileRepository.findById(file.getId()).get());
			f.setNoOfChallans(voucher.getTotalNoOfTransaction());
			f.setReferenceNo(voucher.getRefrenceNo());
			f.setVoucherNo(voucher.getVoucherNo());
			f.setTotChallanAmt(voucher.getTotalAmount());
			f.setChallanDt(file.getFileRecvDt());
			f.setReferenceDt(new Date());
			//si = " Voucher Created SuccessFully!!";
			FileAccountingProcessed savedFile = processRepository.save(f);
			Long menuId = voucher.getMenuId();
			if(menuId!=null && savedFile.getId()!=0){
				voucher.setFileAccountingProcessedId(savedFile.getId());
				gstWfActionConfigService.saveWfActConfigTrn(GSTUtility.getWfUserReqSDDto(menuId, savedFile.getId()));
			}
			voucher.setMessage(" Voucher Created SuccessFully!!");
		} else {
			//si = " Voucher is already created for this file!!!";
			voucher.setMessage(" Voucher is already created for this file!!!");
		}
	}

	private void createFileProcess(VoucherDto v) {
		GSTFileProcess file = new GSTFileProcess();
		file.setPaoFileHdrId(hdrRepository.findByFileTypeCd(v.getFileTypeCd()).getId());
		if (!(fileRepository.findByFileName(v.getFileName()).isPresent())) {
			file.setFileName(v.getFileName());
			file.setFileFormatType(v.getFileTypeCd());
			file.setFileRecvDt(v.getFileDate());
			file.setStateCd(v.getStateCd());
			file.setCreatedBy(1);
			file.setCreatedDate(new Date());
			file.setFileGenerateDt(new Date());
			file.setActiveStatus(0);
			file.setFileProcessed('Y');
			file.setId(fileRepository.save(file).getId());
		}
	}

	private String getTransactionNo() throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();

		map.put(Constant.TRN_SCREEN, FileAccountingProcessed.TRN_SCREEN_BMS);
		String procName = GSTConstant.GST_SCHEMA.concat(Constant.DOT.concat(GSTConstant.P_GST_TRN_NO_GEN));
		List<Object[]> nextSequenceNumber = processRepository.callStoredProcedure(procName, map);
		if (!Utils.isEmpty(nextSequenceNumber)) {
			return (String) nextSequenceNumber.get(0)[0];
		} else {
			throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
		}
	}

	public static String generateVoucherNo(long total, int year, int monthValue) {
		String count = String.format("%5s", total).replace(' ', '0');
		String month = String.format("%2s", monthValue).replace(' ', '0');
		return String.format("%s/%s/%s", year, month, count).toUpperCase();
	}

	public List<EODCINFileReportDto> searchByfileDate(EODCINFileDataDto dto) {
		List<EODCINFileReportDto> eodcinFileDataDtos = new ArrayList<>();
		List<EODCINFileDataDto> eodcinFileDataDt = new ArrayList<>();
		Set<String> bankCd = new HashSet<>();
		repository.findByCpinDtOrderByBankCd(dto.getCpinDt()).forEach(rec -> {
			EODCINFileDataDto eodcinFileDataDto = new EODCINFileDataDto();
			bankCd.add(rec.getBankCd());
			eodcinFileDataDto.setBankCd(rec.getBankCd());
			eodcinFileDataDto.setGstinTmpidNo(rec.getGstinTmpidNo());
			eodcinFileDataDto.setPaymentDt(rec.getPaymentDt());
			eodcinFileDataDto.setCinNo(rec.getCinNo());
			eodcinFileDataDto.setSgstTax(rec.getSgstTax());
			eodcinFileDataDto.setSgstOth(rec.getSgstOth());
			eodcinFileDataDto.setSgstFee(rec.getSgstFee());
			eodcinFileDataDto.setSgstPenalty(rec.getSgstPenalty());
			eodcinFileDataDto.setSgstIntr(rec.getSgstIntr());
			eodcinFileDataDto.setSgstTotal(rec.getSgstTotal());
			eodcinFileDataDto.setCpinDt(rec.getCpinDt());
			eodcinFileDataDt.add(eodcinFileDataDto);
		});
		for (String bank : bankCd) {
			EODCINFileReportDto eodCinFileEntity = new EODCINFileReportDto();
			eodCinFileEntity.setBankCd(bank);
			List<EODCINFileDataDto> dataDtos = eodcinFileDataDt.stream().filter(a -> a.getBankCd().equals(bank))
					.collect(Collectors.toList());

			for (EODCINFileDataDto dt : dataDtos) {
				eodCinFileEntity.setEodCinFileData(eodcinFileDataDt);
				eodCinFileEntity.setTotalSgstTax(eodCinFileEntity.getTotalSgstTax() + dt.getSgstTax());
				eodCinFileEntity.setTotalSgstOth(eodCinFileEntity.getTotalSgstOth() + dt.getSgstOth());
				eodCinFileEntity.setTotalSgstFee(eodCinFileEntity.getTotalSgstFee() + dt.getSgstFee());
				eodCinFileEntity.setTotalSgstPenalty(eodCinFileEntity.getTotalSgstPenalty() + dt.getSgstPenalty());
				eodCinFileEntity.setTotalSgstIntr(eodCinFileEntity.getTotalSgstIntr() + dt.getSgstIntr());
				eodCinFileEntity.setTotalSgstTotal(eodCinFileEntity.getTotalSgstTotal() + dt.getSgstTotal());
			}

			eodCinFileEntity.setEodCinFileData(dataDtos);
			eodcinFileDataDtos.add(eodCinFileEntity);
		}

		return eodcinFileDataDtos;
	}

	public String loadEodCinData(EodDataCinFile dto) {

		createOtcsEODCINFileData(dto, dto.getCin().getOtc());
		createEpyEODCINFileData(dto, dto.getCin().getEpy());
		createNerEODCINFileData(dto, dto.getCin().getNer());

		return "Data is created";

	}

	private void createOtcsEODCINFileData(EodDataCinFile dto, List<CinOtc> otcs) {

		otcs.forEach(otc -> {
			EODCINFileData eodCinFileData = new EODCINFileData();
			eodCinFileData.setStateCd(Short.parseShort(dto.getStateCd()));
			eodCinFileData.setPaymentModeCd("otc");
			eodCinFileData.setFileTypeCd("CIN");
			if (StringUtils.isEmpty(otc.getGstin())) {
				eodCinFileData.setGstinTmpidNo(String.format(otc.getTmpid()));
				// eodCinFileData.setIsGstinTmpid(true);
			} else {
				eodCinFileData.setGstinTmpidNo(String.format(otc.getGstin()));
				// eodCinFileData.setIsGstinTmpid(false);
			}

			eodCinFileData.setCpinDt(DateUtil.getDate(otc.getCpinDt(), DateUtil.DD_MM_YYYY));
			eodCinFileData.setCpinDtTime(LocalDateTime.parse(otc.getCpinTim()));
			eodCinFileData.setCpinNo(Long.valueOf(otc.getCpin()));
			eodCinFileData.setCinNo(String.format(otc.getCin()));
			eodCinFileData.setPaymentDt(DateUtil.getDate(otc.getPaymentDt(), DateUtil.DD_MM_YYYY));
			eodCinFileData.setBankRefNum(Long.parseLong(otc.getBankRefNum()));
			eodCinFileData.setInstrumentType(String.format(otc.getInstrumentTy()));
			eodCinFileData.setInstrumentNumber(Long.parseLong(otc.getInstrumentNum()));
			eodCinFileData.setInstrumentMicrCd(String.format(otc.getInstrumentMicrCd()));
			eodCinFileData.setBrIfscCd(String.format(otc.getBrIfscCd()));
			eodCinFileData.setBrLocation(otc.getBrLocation());
			eodCinFileData.setBrName(String.format(otc.getBrName()));
			eodCinFileData.setPaymentAckDt((DateUtil.getDate(otc.getPymntAckDt(), DateUtil.DD_MM_YYYY)));
			eodCinFileData.setPaymentAckDtTime((DateUtil.getDate(otc.getPaymentTim(), DateUtil.HH_MM_SS)));
			eodCinFileData.setAckNum(Short.parseShort(otc.getAckNum()));
			eodCinFileData.setStatus(String.format(otc.getStatus()));
			eodCinFileData.setBankCd(String.format(otc.getBankCd()));

			eodCinFileData.setCgstTax(Double.parseDouble(otc.getCgstTax()));
			eodCinFileData.setCgstIntr(Double.parseDouble(otc.getCgstIntr()));
			eodCinFileData.setCgstFee(Double.parseDouble(otc.getCgstFee()));
			eodCinFileData.setCgstPenalty(Double.parseDouble(otc.getCgstPnlty()));
			eodCinFileData.setCgstOth(Double.parseDouble(otc.getCgstOth()));
			eodCinFileData.setCgstTotal(Double.parseDouble(otc.getCgstTotal()));

			eodCinFileData.setIgstTax(Double.parseDouble(otc.getIgstTax()));
			eodCinFileData.setIgstIntr(Double.parseDouble(otc.getIgstIntr()));
			eodCinFileData.setIgstFee(Double.parseDouble(otc.getIgstFee()));
			eodCinFileData.setIgstPenalty(Double.parseDouble(otc.getIgstPnlty()));
			eodCinFileData.setIgstOth(Double.parseDouble(otc.getIgstOth()));
			eodCinFileData.setIgstTotal(Double.parseDouble(otc.getIgstTotal()));

			eodCinFileData.setSgstTax(Double.parseDouble(otc.getSgstTax()));
			eodCinFileData.setSgstIntr(Double.parseDouble(otc.getSgstIntr()));
			eodCinFileData.setSgstFee(Double.parseDouble(otc.getSgstFee()));
			eodCinFileData.setSgstPenalty(Double.parseDouble(otc.getSgstPnlty()));
			eodCinFileData.setSgstOth(Double.parseDouble(otc.getSgstOth()));
			eodCinFileData.setSgstTotal(Double.parseDouble(otc.getSgstTotal()));

			eodCinFileData.setCessTax(Double.parseDouble(otc.getCessTax()));
			eodCinFileData.setCessIntr(Double.parseDouble(otc.getCessIntr()));
			eodCinFileData.setCessFee(Double.parseDouble(otc.getCessFee()));
			eodCinFileData.setCessPenalty(Double.parseDouble(otc.getCessPnlty()));
			eodCinFileData.setCessOth(Double.parseDouble(otc.getCessOth()));
			eodCinFileData.setCessTotal(Double.parseDouble(otc.getCessTotal()));

			eodCinFileData.setTotalAmt(Double.parseDouble(otc.getTotalAmt()));

			eodCinFileData.setReportingDt(DateUtil.getDate(otc.getReportingDt(), DateUtil.DD_MM_YYYY));
			eodCinFileData.setReportingDtTime(DateUtil.getDate(otc.getReportingTim(), DateUtil.DD_MM_YYYY));
			// save eodCinFileData
			repository.save(eodCinFileData);
		});

	}

	private void createEpyEODCINFileData(EodDataCinFile dto, List<CinEpy> epys) {

		epys.forEach(epy -> {
			EODCINFileData eodCinFileData = new EODCINFileData();
			eodCinFileData.setPaymentModeCd("epy");
			eodCinFileData.setFileTypeCd("CIN");
			eodCinFileData.setStateCd(Short.parseShort(dto.getStateCd()));
			if (StringUtils.isEmpty(epy.getGstin())) {
				eodCinFileData.setGstinTmpidNo(String.format(epy.getTmpid()));
				// eodCinFileData.setIsGstinTmpid(true);
			} else {
				eodCinFileData.setGstinTmpidNo(String.format(epy.getGstin()));
				// eodCinFileData.setIsGstinTmpid(false);
			}

			eodCinFileData.setCpinDt(DateUtil.getDate(epy.getCpinDt(), DateUtil.DD_MM_YYYY));
			eodCinFileData.setCpinDt(DateUtil.getDate(epy.getCpinDt(), DateUtil.DD_MM_YYYY));
			eodCinFileData.setCpinDtTime(LocalDateTime.parse(epy.getCpinTim()));
			eodCinFileData.setCpinNo(Long.valueOf(epy.getCpin()));
			eodCinFileData.setCinNo(String.format(epy.getCin()));
			eodCinFileData.setPaymentDt(DateUtil.getDate(epy.getPaymentDt(), DateUtil.DD_MM_YYYY));
			eodCinFileData.setBankRefNum(Long.parseLong(epy.getBankRefNum()));
			eodCinFileData.setInstrumentType(String.format(epy.getInstrumentTy()));

			eodCinFileData.setPaymentAckDt((DateUtil.getDate(epy.getPymntAckDt(), DateUtil.DD_MM_YYYY)));
			eodCinFileData.setPaymentAckDtTime((DateUtil.getDate(epy.getPaymentTim(), DateUtil.HH_MM_SS)));

			eodCinFileData.setStatus(String.format(epy.getStatus()));
			eodCinFileData.setBankCd(String.format(epy.getBankCd()));

			eodCinFileData.setCgstTax(Double.parseDouble(epy.getCgstTax()));
			eodCinFileData.setCgstIntr(Double.parseDouble(epy.getCgstIntr()));
			eodCinFileData.setCgstFee(Double.parseDouble(epy.getCgstFee()));
			eodCinFileData.setCgstPenalty(Double.parseDouble(epy.getCgstPnlty()));
			eodCinFileData.setCgstOth(Double.parseDouble(epy.getCgstOth()));
			eodCinFileData.setCgstTotal(Double.parseDouble(epy.getCgstTotal()));

			eodCinFileData.setIgstTax(Double.parseDouble(epy.getIgstTax()));
			eodCinFileData.setIgstIntr(Double.parseDouble(epy.getIgstIntr()));
			eodCinFileData.setIgstFee(Double.parseDouble(epy.getIgstFee()));
			eodCinFileData.setIgstPenalty(Double.parseDouble(epy.getIgstPnlty()));
			eodCinFileData.setIgstOth(Double.parseDouble(epy.getIgstOth()));
			eodCinFileData.setIgstTotal(Double.parseDouble(epy.getIgstTotal()));

			eodCinFileData.setSgstTax(Double.parseDouble(epy.getSgstTax()));
			eodCinFileData.setSgstIntr(Double.parseDouble(epy.getSgstIntr()));
			eodCinFileData.setSgstFee(Double.parseDouble(epy.getSgstFee()));
			eodCinFileData.setSgstPenalty(Double.parseDouble(epy.getSgstPnlty()));
			eodCinFileData.setSgstOth(Double.parseDouble(epy.getSgstOth()));
			eodCinFileData.setSgstTotal(Double.parseDouble(epy.getSgstTotal()));

			eodCinFileData.setCessTax(Double.parseDouble(epy.getCessTax()));
			eodCinFileData.setCessIntr(Double.parseDouble(epy.getCessIntr()));
			eodCinFileData.setCessFee(Double.parseDouble(epy.getCessFee()));
			eodCinFileData.setCessPenalty(Double.parseDouble(epy.getCessPnlty()));
			eodCinFileData.setCessOth(Double.parseDouble(epy.getCessOth()));
			eodCinFileData.setCessTotal(Double.parseDouble(epy.getCessTotal()));

			eodCinFileData.setTotalAmt(Double.parseDouble(epy.getTotalAmt()));

			eodCinFileData.setReportingDt(DateUtil.getDate(epy.getReportingDt(), DateUtil.DD_MM_YYYY));
			eodCinFileData.setReportingDtTime(DateUtil.getDate(epy.getReportingTim(), DateUtil.DD_MM_YYYY));

			// save eodCinFileData
			repository.save(eodCinFileData);
		});

	}

	private void createNerEODCINFileData(EodDataCinFile dto, List<CinNer> ners) {

		ners.forEach(ner -> {
			EODCINFileData eodCinFileData = new EODCINFileData();
			eodCinFileData.setPaymentModeCd("ner");
			eodCinFileData.setFileTypeCd("CIN");
			eodCinFileData.setStateCd(Short.parseShort(dto.getStateCd()));
			if (StringUtils.isEmpty(ner.getGstin())) {
				eodCinFileData.setGstinTmpidNo(String.format(ner.getTmpid()));
				// eodCinFileData.setIsGstinTmpid(true);
			} else {
				eodCinFileData.setGstinTmpidNo(String.format(ner.getGstin()));
				// eodCinFileData.setIsGstinTmpid(false);
			}

			eodCinFileData.setCpinDt(DateUtil.getDate(ner.getCpinDt(), DateUtil.DD_MM_YYYY));
			eodCinFileData.setCpinDtTime(LocalDateTime.parse(ner.getCpinTim()));
			eodCinFileData.setCpinNo(Long.valueOf(ner.getCpin()));
			eodCinFileData.setCinNo(String.format(ner.getCin()));
			eodCinFileData.setPaymentDt(DateUtil.getDate(ner.getPaymentDt(), DateUtil.DD_MM_YYYY));
			eodCinFileData.setBankRefNum(Long.parseLong(ner.getBankRefNum()));

			eodCinFileData.setPaymentAckDtTime((DateUtil.getDate(ner.getPaymentTim(), DateUtil.HH_MM_SS)));

			eodCinFileData.setStatus(String.format(ner.getStatus()));
			eodCinFileData.setBankCd(String.format(ner.getBankCd()));

			eodCinFileData.setCgstTax(Double.parseDouble(ner.getCgstTax()));
			eodCinFileData.setCgstIntr(Double.parseDouble(ner.getCgstIntr()));
			eodCinFileData.setCgstFee(Double.parseDouble(ner.getCgstFee()));
			eodCinFileData.setCgstPenalty(Double.parseDouble(ner.getCgstPnlty()));
			eodCinFileData.setCgstOth(Double.parseDouble(ner.getCgstOth()));
			eodCinFileData.setCgstTotal(Double.parseDouble(ner.getCgstTotal()));

			eodCinFileData.setIgstTax(Double.parseDouble(ner.getIgstTax()));
			eodCinFileData.setIgstIntr(Double.parseDouble(ner.getIgstIntr()));
			eodCinFileData.setIgstFee(Double.parseDouble(ner.getIgstFee()));
			eodCinFileData.setIgstPenalty(Double.parseDouble(ner.getIgstPnlty()));
			eodCinFileData.setIgstOth(Double.parseDouble(ner.getIgstOth()));
			eodCinFileData.setIgstTotal(Double.parseDouble(ner.getIgstTotal()));

			eodCinFileData.setSgstTax(Double.parseDouble(ner.getSgstTax()));
			eodCinFileData.setSgstIntr(Double.parseDouble(ner.getSgstIntr()));
			eodCinFileData.setSgstFee(Double.parseDouble(ner.getSgstFee()));
			eodCinFileData.setSgstPenalty(Double.parseDouble(ner.getSgstPnlty()));
			eodCinFileData.setSgstOth(Double.parseDouble(ner.getSgstOth()));
			eodCinFileData.setSgstTotal(Double.parseDouble(ner.getSgstTotal()));

			eodCinFileData.setCessTax(Double.parseDouble(ner.getCessTax()));
			eodCinFileData.setCessIntr(Double.parseDouble(ner.getCessIntr()));
			eodCinFileData.setCessFee(Double.parseDouble(ner.getCessFee()));
			eodCinFileData.setCessPenalty(Double.parseDouble(ner.getCessPnlty()));
			eodCinFileData.setCessOth(Double.parseDouble(ner.getCessOth()));
			eodCinFileData.setCessTotal(Double.parseDouble(ner.getCessTotal()));

			eodCinFileData.setTotalAmt(Double.parseDouble(ner.getTotalAmt()));

			eodCinFileData.setReportingDt(DateUtil.getDate(ner.getReportingDt(), DateUtil.DD_MM_YYYY));
			eodCinFileData.setReportingDtTime(DateUtil.getDate(ner.getReportingTim(), DateUtil.DD_MM_YYYY));

			// save eodCinFileData
			repository.save(eodCinFileData);
		});

	}
}
