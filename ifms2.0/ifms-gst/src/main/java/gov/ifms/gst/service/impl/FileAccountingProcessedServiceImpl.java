package gov.ifms.gst.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.pagination.SearchCriteria;
import gov.ifms.gst.pagination.SearchParam;
import gov.ifms.gst.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.gst.converter.FileAccountingProcessedConvertor;
import gov.ifms.gst.dto.CreditHeadDto;
import gov.ifms.gst.dto.Dtos;
import gov.ifms.gst.dto.FileAccountProcessedLstResDto;
import gov.ifms.gst.dto.FileAccountingProcessedDto;
import gov.ifms.gst.dto.FileDto;
import gov.ifms.gst.dto.ListingDto;
import gov.ifms.gst.dto.VoucherDto;
import gov.ifms.gst.entity.EODCINFileData;
import gov.ifms.gst.entity.FileAccountingProcessed;
import gov.ifms.gst.entity.GSTFileProcess;
import gov.ifms.gst.repository.FileAccountingProcessedRepository;
import gov.ifms.gst.repository.GSTCINFileDataRepository;
import gov.ifms.gst.repository.GSTFileProcessRepository;
import gov.ifms.gst.repository.GSTFileSummeryRepository;
import gov.ifms.gst.util.DateUtil;
import gov.ifms.gst.util.GSTUtility;
import gov.ifms.gst.util.GstDBConstants;
import gov.ifms.gst.workflow.service.GstWfActionConfigService;

@Service
public class FileAccountingProcessedServiceImpl {
	@Autowired
	private FileAccountingProcessedConvertor convertor;

	@Autowired
	private FileAccountingProcessedRepository repository;

	@Autowired
	private GSTCINFileDataRepository cinrepository;

	@Autowired
	private GSTFileProcessRepository fileRepository;
	@Autowired
	private GSTFileSummeryRepository summeryRepository;

	@Autowired
	private GstWfActionConfigService gstWfActionConfigService;

	@Autowired
	private EntityManager entityManager;
	public String QUERY_FOR_BANK_NAME = "SELECT BANK_NAME FROM EPAO.TPAO_TEMP_BANK_CODE_MAPP ttbcm JOIN MASTER_V1.MS_BANK mb ON ttbcm.MS_BANK_ID = mb.BANK_ID WHERE ttbcm.BANK_SHORT_CODE = :bankCd ";
	public String QUERY = "SELECT count(*) AS No_Of_Challan, sum(TOTAL_AMT) FROM EPAO.TPAO_EOD_CIN_FILE_DATA tecfd WHERE CPIN_DT >= :cpinDt AND CPIN_DT <= :cpinDt ";

	public FileAccountingProcessedDto update(FileAccountingProcessedDto dto) throws CustomException {
		dto.setMessage("Voucher is Updated Successfully!");
		FileAccountingProcessedDto savedDto = null;
		Optional<FileAccountingProcessed> savedEntity;
		Optional<GSTFileProcess> fileProcessEntity = fileRepository.findByFileName(dto.getFileName());
		if (fileProcessEntity.isPresent()) {
			savedEntity = repository.findById(dto.getId());
			if (savedEntity.isPresent()) {
				FileAccountingProcessed tempEntity = savedEntity.get();
				tempEntity.setFileProcessId(fileProcessEntity.get());
				tempEntity.setChallanDt(fileProcessEntity.get().getFileRecvDt());
				Query query = entityManager.createNativeQuery(QUERY);
				query.setParameter("cpinDt", DateUtil.setTimeToZero(tempEntity.getChallanDt()));
				Object[] object = (Object[]) query.getSingleResult();
				tempEntity.setNoOfChallans(Short.parseShort(String.valueOf(object[0])));
				tempEntity.setTotChallanAmt(Double.parseDouble(String.valueOf(object[1])));
				repository.save(tempEntity);
				savedDto = convertor.toDTO(savedEntity.get());
			}
		}
//		fileRepository.findByFileName(dto.getFileName()).ifPresent(file -> {
//			repository.findById(dto.getId()).ifPresent(fileprocessId -> {
//				fileprocessId.setFileProcessId(file);
//				fileprocessId.setChallanDt(file.getFileRecvDt());
//				Query query = entityManager.createNativeQuery(QUERY);
//				query.setParameter("cpinDt", DateUtil.setTimeToZero(fileprocessId.getChallanDt()));
//				Object[] object = (Object[]) query.getSingleResult();
//				fileprocessId.setNoOfChallans(Short.parseShort(String.valueOf(object[0])));
//				fileprocessId.setTotChallanAmt((Double) (object[1]));
//				repository.save(fileprocessId);
//			});
//		});
		Long menuId = dto.getMenuId();
		if (menuId != null && dto.getId() != 0) {
			gstWfActionConfigService.saveWfActConfigTrn(GSTUtility.getWfUserReqSDDto(menuId, dto.getId()));
		}
		return savedDto;
	}

	public PagebleDTO<FileAccountingProcessedDto> getAll(PageDetails pageDetail) throws CustomException {

		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<FileAccountingProcessed> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<FileAccountingProcessed> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<FileAccountingProcessed> page = repository.findAll(dataSpec, pageable);
			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					convertor.toDTO(page.getContent()));
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	public PagebleDTO<FileAccountProcessedLstResDto> getPenalInterestWfList(PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(
					search -> map.put(GstDBConstants.getGstnFileAccListing().get(search.getKey()), search.getValue()));
		}
		GstDBConstants.getGstnFileAccListing().entrySet().stream().filter(e -> !map.containsKey(e.getValue()))
				.forEach(e -> map.put(e.getValue(), ""));

		String procName = GstDBConstants.GST_SCHEMA
				.concat(Constant.DOT.concat(GstDBConstants.SP_FILE_ACCOUNT_PROCESSED_LISTING));
		List<FileAccountProcessedLstResDto> objectSp = this.callStoreProc(procName, map,
				FileAccountProcessedLstResDto.class);
		long totalPages = !objectSp.isEmpty() ? objectSp.size() : 0;
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objectSp);
	}

	public ListingDto<FileAccountingProcessed> getSearch(Integer pageNumber, Integer pageSize,
			FileAccountingProcessedDto dtos) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<FileAccountingProcessed> query = cb.createQuery(FileAccountingProcessed.class);
		Root<FileAccountingProcessed> root = query.from(FileAccountingProcessed.class);
		List<Predicate> predicates = new ArrayList<>();

		if (StringUtils.isNotEmpty(dtos.getReferenceNo())) {
			Path<String> exp = root.get("referenceNo");
			predicates.add(cb.like(cb.upper(exp), "%" + dtos.getReferenceNo() + "%"));
		}

		if (null != dtos.getFromDate()) {
			Path<Date> exp = root.get("challanDt");
			predicates.add(cb.greaterThanOrEqualTo(exp, dtos.getFromDate()));
		}

		if (null != dtos.getToDate()) {
			Path<Date> exp = root.get("challanDt");
			predicates.add(cb.lessThanOrEqualTo(exp, dtos.getToDate()));
		}
		if (StringUtils.isNotEmpty(dtos.getFileName()))
			fileRepository.findByFileNameContains(dtos.getFileName()).ifPresent(f -> {
				if (!(Objects.isNull(f.getId()))) {
					Path<String> exp = root.get("fileProcessId");
					predicates.add(cb.equal(cb.upper(exp), f.getId()));
				}
			});
		query.select(root).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
		List<FileAccountingProcessed> list = entityManager.createQuery(query).setMaxResults(pageSize)
				.setFirstResult(pageNumber * pageSize).getResultList();
		int totalElement = entityManager.createQuery(query).getResultList().size();
		return new ListingDto<>(pageSize, totalElement, list);
	}

	public VoucherDto search(FileAccountingProcessed dto) {
		VoucherDto vouchers = new VoucherDto();
		List<Dtos> dum = new ArrayList<>();
		List<FileDto> fileDtos = new ArrayList<>();
		List<CreditHeadDto> credithead = new ArrayList<>();
		Date fromDate = DateUtil.setTimeToZero(dto.getChallanDt());
		Date toDate = DateUtil.addDays(DateUtil.setTimeToZero(dto.getChallanDt()), 0);
		CreditHeadDto creditheads = new CreditHeadDto();
		FileDto fileDto = new FileDto();

		repository.findByVoucherNo(dto.getVoucherNo()).ifPresent(voucher -> {
			vouchers.setVoucherNo(voucher.getVoucherNo());
			vouchers.setRefrenceNo(voucher.getReferenceNo());
			vouchers.setFileName(voucher.getFileProcessId().getFileName());
			vouchers.setFileDate(voucher.getFileProcessId().getFileRecvDt());
			vouchers.setStateCd(voucher.getFileProcessId().getStateCd());
			vouchers.setRefrenceDt(voucher.getReferenceDt());
			vouchers.setFileTypeCd(voucher.getFileProcessId().getFileTypeCd());
			summeryRepository.findByFileName(vouchers.getFileName()).ifPresent(file -> {
				fileDto.setFileName(file.getFileName());
				fileDto.setTotalAmount(file.getTotAmt());
				fileDto.setNoOfTransaction((short) file.getTotRecCnt());
				fileDto.setFileDt(file.getFileDate());
				fileDtos.add(fileDto);
				creditheads.setDescription("STATE GOODS AND SERVICES TAX(SGST) TAX");
				creditheads.setAmount(file.getTotAmt());
				creditheads.setNoOfTransaction((short) 1);
				creditheads.setCreditHead("8658-00-138-01-04-0000");
				credithead.add(creditheads);
			});
		});
		List<EODCINFileData> r = cinrepository.findByFileTypeCdAndCpinDtBetween(vouchers.getFileTypeCd(), fromDate);
		r.forEach(d -> {
			Dtos dums = new Dtos();
			Query query = entityManager.createNativeQuery(QUERY_FOR_BANK_NAME);
			query.setParameter("bankCd", d.getBankCd());
			dums.setDescription((String) (query.getSingleResult()));
			dums.setNoOfTransaction(cinrepository.countByBankCd(d.getBankCd()));
			dums.setDebitedHead("8658-00-138-01-04-0000");
			dums.setAmount(d.getTotalAmt());
			vouchers.setTotalAmount(vouchers.getTotalAmount() + dums.getAmount());
			dum.add(dums);
		});

		vouchers.setCreditHead(credithead);
		vouchers.setDtos(dum);
		vouchers.setFileDto(fileDtos);
		return vouchers;
	}

	/**
	 * Call store proc.
	 *
	 * @param <T>      the generic type
	 * @param procName the proc name
	 * @param map      the map
	 * @param view     the view
	 *
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	private <T> List<T> callStoreProc(String procName, Map<String, Object> map, Class<T> view) throws CustomException {
		List<Object[]> objectSp = repository.callStoredProcedure(procName, map);
		return (objectSp != null && !objectSp.isEmpty()) ? NativeQueryResultsMapper.map(objectSp, view)
				: Collections.emptyList();
	}

}
