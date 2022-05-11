package gov.ifms.gst.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.pagination.SearchCriteria;
import gov.ifms.gst.pagination.SpecificationImpl;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.gst.converter.GSTCINFileDataConvertor;
import gov.ifms.gst.converter.GSTCPINStatusConvertor;
import gov.ifms.gst.dto.AmountDto;
import gov.ifms.gst.dto.GSTCPINStatusDto;
import gov.ifms.gst.dto.GetStatusDto;
import gov.ifms.gst.entity.EODCINFileData;
import gov.ifms.gst.entity.GSTCPINStatus;
import gov.ifms.gst.entity.RecordType;
import gov.ifms.gst.repository.GSTCINFileDataRepository;
import gov.ifms.gst.repository.GSTCPINStatusRepository;
import gov.ifms.gst.util.GSTConstant;

@Service
public class GSTCPINStatusServiceImpl {
	@Autowired
	private GSTCPINStatusConvertor convertor;

	@Autowired
	private GSTCPINStatusRepository repository;
	@Autowired
	private GSTCINFileDataRepository fileDataRepository;
	@Autowired
	private GSTCINFileDataConvertor convertors;
	@Autowired
	private EntityManager entityManager;

	public String QUERY = "SELECT tsd.SCROLL_NO , tsd.SCROLL_DT FROM EPAO.TPAO_SCROLL_DISTRIBUTE tsd \r\n"
			+ "JOIN EPAO.TPAO_SA_DA_CHALLAN_MAPPING tsdcm ON tsdcm.FILE_PROCESS_ID = tsd.FILE_PROCESS_ID \r\n"
			+ "JOIN EPAO.TPAO_RBI_FILES_TRANXN trft on trft.RBI_FILE_TRANXN_ID = tsdcm.RBI_FILE_TRANXN_ID WHERE trft.END_TO_END_ID = :cin";
	public String PARTYNAME = "SELECT mgp.FIRM_NAME FROM EPAO.MS_GST_PARTY mgp WHERE mgp.GSTIN = :gstin ";

	public GSTCPINStatusDto create(GSTCPINStatusDto dto) {
		dto.setRefrenceNo(createUniqueRefrenceNumber(repository.count() + 1,
				GSTConstant.GST_SCHEMA.concat("/").concat(GSTCPINStatus.TRN_SCREEN_CPIN_STATUS)));
		return convertor.toDTO(repository.save(convertor.toEntity(dto)));
	}

	public PagebleDTO<GSTCPINStatusDto> getAll(PageDetails pageDetail) throws CustomException {

		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<GSTCPINStatus> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<GSTCPINStatus> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<GSTCPINStatus> page = repository.findAll(dataSpec, pageable);
			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					convertor.toDTO(page.getContent()));
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	public GetStatusDto getCpinStatus(GSTCPINStatusDto dto) {
		GetStatusDto d = new GetStatusDto();
		if (dto.getRecordType().equals(RecordType.CPIN)) {
			Optional<EODCINFileData> cin = fileDataRepository.findByCpinNo(Long.parseLong(dto.getCinNo()));
			if (cin.isPresent()) {
				d.setResponse(true);
				getStatus(d, cin.get());
			}
		} else if (dto.getRecordType().equals(RecordType.CIN)) {
			Optional<EODCINFileData> cpin = fileDataRepository.findByCinNo(dto.getCinNo());
			if (cpin.isPresent()) {
				d.setResponse(true);
				getStatus(d, cpin.get());
			}
		}
		return d;
	}

	@SuppressWarnings("unchecked")
	private void getStatus(GetStatusDto d, EODCINFileData cpin) {
		d.setBankRefNum(cpin.getBankRefNum());
		d.setBrName(cpin.getBrName());
		d.setCinDt(cpin.getCreatedDate());
		d.setCinNo(cpin.getCinNo());
		d.setCpinNo(cpin.getCpinNo());
		d.setCpinDt(cpin.getCpinDt());
		d.setCpinDtTime(cpin.getCpinDtTime());
		d.setFileTypeCd(cpin.getFileTypeCd());
		d.setGstinTmpidNo(cpin.getGstinTmpidNo());
		d.setPaymentModeCd(cpin.getPaymentModeCd());
		d.setStateCd(cpin.getStateCd());
		d.setDto(amountMethod(cpin));
		d.setBankCd(cpin.getCinNo().trim().substring(0, 4));
		d.setStatus(getStatusForChallan(cpin));
		d.setLyingWith("NA");
		d.setAccountOn("NA");
		setGovAccountCreditDate(d, cpin);
		try {
			Query query1 = entityManager.createNativeQuery(PARTYNAME);
			query1.setParameter("gstin", cpin.getGstinTmpidNo());
			d.setPartyName((String) (query1.getSingleResult()));
		} catch (Exception ex) {
			d.setPartyName("NA");
		}
		try {
			Query query = entityManager.createNativeQuery(QUERY);
			query.setParameter("cin", cpin.getCinNo());
			Object[] object = (Object[]) query.getSingleResult();
			d.setScrollNo((String) (object[0]));
			d.setScrollDate(String.valueOf(object[1]).toString());
		} catch (Exception ex) {
			d.setScrollNo("NA");
			d.setScrollDate(null);
		}

	}

	private String getStatusForChallan(EODCINFileData cpin) {
		
		return "Pending";
	}

	private List<AmountDto> amountMethod(EODCINFileData resource) {
		List<AmountDto> amountDto = new ArrayList<>();
		AmountDto amountSGST = new AmountDto();
		amountSGST.setDesc("SGST");
		amountSGST.setFees(resource.getSgstFee());
		amountSGST.setInterest(resource.getSgstIntr());
		amountSGST.setOthers(resource.getSgstOth());
		amountSGST.setPenalty(resource.getSgstPenalty());
		amountSGST.setTax(resource.getSgstTax());
		amountSGST.setTotal(resource.getSgstTotal());
		amountDto.add(amountSGST);
		AmountDto amountCGST = new AmountDto();
		amountCGST.setDesc("CGST");
		amountCGST.setFees(resource.getCgstFee());
		amountCGST.setInterest(resource.getCgstIntr());
		amountCGST.setOthers(resource.getCgstOth());
		amountCGST.setPenalty(resource.getCgstPenalty());
		amountCGST.setTax(resource.getCgstTax());
		amountCGST.setTotal(resource.getCgstTotal());
		amountDto.add(amountCGST);
		AmountDto amountCess = new AmountDto();
		amountCess.setDesc("CESS");
		amountCess.setFees(resource.getCessFee());
		amountCess.setInterest(resource.getCessIntr());
		amountCess.setOthers(resource.getCessOth());
		amountCess.setPenalty(resource.getCessPenalty());
		amountCess.setTax(resource.getCessTax());
		amountCess.setTotal(resource.getCessTotal());
		amountDto.add(amountCess);
		AmountDto amountIGST = new AmountDto();
		amountIGST.setDesc("IGST");
		amountIGST.setFees(resource.getIgstFee());
		amountIGST.setInterest(resource.getIgstIntr());
		amountIGST.setOthers(resource.getIgstOth());
		amountIGST.setPenalty(resource.getIgstPenalty());
		amountIGST.setTax(resource.getIgstTax());
		amountIGST.setTotal(resource.getIgstTotal());
		amountDto.add(amountIGST);
		AmountDto amountTtl = new AmountDto();
		amountTtl.setDesc("Total");
		amountTtl
				.setFees(resource.getIgstFee() + resource.getSgstFee() + resource.getCgstFee() + resource.getCessFee());
		amountTtl.setInterest(
				resource.getIgstIntr() + resource.getCessIntr() + resource.getCgstIntr() + resource.getSgstIntr());
		amountTtl.setOthers(
				resource.getIgstOth() + resource.getCessOth() + resource.getCgstOth() + resource.getSgstOth());
		amountTtl.setPenalty(resource.getIgstPenalty() + resource.getCessPenalty() + resource.getCgstPenalty()
				+ resource.getSgstPenalty());
		amountTtl.setTax(resource.getIgstTax() + resource.getCessTax() + resource.getCgstTax() + resource.getSgstTax());
		amountTtl.setTotal(
				resource.getIgstTotal() + resource.getCessTotal() + resource.getCgstTotal() + resource.getSgstTotal());
		amountDto.add(amountTtl);
		return amountDto;
	}

	private String createUniqueRefrenceNumber(long l, String upperCase) {
		String date = String.format("%5s", "21-22");
		String count = String.format("%5s", l).replace(' ', '0');
		return String.format("%s/%s/%s", date, upperCase, count).toUpperCase();
	}

	public GSTCPINStatusDto getStatus(GSTCPINStatusDto dtos) {

		return convertor.toDTO(repository.findByCpinNo(dtos.getCpinNo()));
	}
	
	private void setGovAccountCreditDate(final GetStatusDto statusDto, final EODCINFileData cpin) {
	GSTCPINStatusDto cpinStatus = convertor.toDTO(repository.findByCpinNo(cpin.getCpinNo()));
	if(cpinStatus != null && cpinStatus.getGovtCreditDt() != null) {
		statusDto.setGovAccountCreditDate(cpinStatus.getGovtCreditDt());
	 }
	else {
		statusDto.setGovAccountCreditDate(statusDto.getCinDt());
		}
	}
}
