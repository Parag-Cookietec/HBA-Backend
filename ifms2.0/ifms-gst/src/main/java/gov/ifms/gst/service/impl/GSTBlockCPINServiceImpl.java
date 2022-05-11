package gov.ifms.gst.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
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
import org.springframework.http.HttpStatus;
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
import gov.ifms.common.util.Utils;
import gov.ifms.gst.converter.GSTBlockCPINConvertor;
import gov.ifms.gst.dto.DTO;
import gov.ifms.gst.dto.GSTBlockCPINDto;
import gov.ifms.gst.dto.GSTBlockCpinListingDto;
import gov.ifms.gst.dto.ListingDto;
import gov.ifms.gst.entity.EODCINFileData;
import gov.ifms.gst.entity.GSTBlockCPIN;
import gov.ifms.gst.repository.EodCpinFileDataRepository;
import gov.ifms.gst.repository.GSTAccountHdrRepository;
import gov.ifms.gst.repository.GSTBlockCPINRepository;
import gov.ifms.gst.repository.GSTCINFileDataRepository;
import gov.ifms.gst.util.GSTConstant;
import gov.ifms.gst.util.GSTUtility;
import gov.ifms.gst.util.GstDBConstants;
import gov.ifms.gst.workflow.service.GstWfActionConfigService;

@Service
public class GSTBlockCPINServiceImpl {
	@Autowired
	private GSTBlockCPINConvertor convertor;
	@Autowired
	private GSTBlockCPINRepository repository;
	@Autowired
	private GSTCINFileDataRepository cinRespository;
	@Autowired
	private GSTAccountHdrRepository accountRepository;
	@Autowired
	private EodCpinFileDataRepository filerRepository;
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private GstWfActionConfigService gstWfActionConfigService;

	public GSTBlockCPINDto getById(Long id) {
		return convertor.toDTO(repository.getOne(id));
	}

	public GSTBlockCPIN create(GSTBlockCPIN dto) throws CustomException {
		String s = "Data Saved Successfully.";
		Optional<GSTBlockCPIN> entity = repository.findByCpinNo(dto.getCpinNo());
		if (dto.getRecStatus().equalsIgnoreCase("NOT_PAID")) {
			if(dto.getCreateService() != null && dto.getCreateService() == 1) {
			if (!entity.isPresent()) {
				dto.setFileName(generateFileName(dto));
				dto.setReferenceNo(getTransactionNo());
				dto.setReferenceDt(LocalDateTime.now());
				long menuId = dto.getMenuId();
				dto = repository.save(dto);
				gstWfActionConfigService.saveWfActConfigTrn(GSTUtility.getWfUserReqSDDto(menuId, dto.getId()));
			} else {
					  throw new CustomException(1005, "This CPIN is already blocked.");
					}
			}
			else {
				if (entity.isPresent()) {
						dto.setId(entity.get().getId());
						dto.setFileName(generateFileName(dto));
						dto.setReferenceNo(getTransactionNo());
						dto.setReferenceDt(LocalDateTime.now());
						long menuId = dto.getMenuId();
						dto = repository.save(dto);
						gstWfActionConfigService.saveWfActConfigTrn(GSTUtility.getWfUserReqSDDto(menuId, dto.getId()));
					} else {
						dto = entity.get();
					}
			}

		} else {
			throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
					"As CPIN status is PAID, this CPIN can not be blocked.");
		}
		return dto;
	}
	
	private void createBlockCpin(GSTBlockCPIN dto) throws CustomException {
		dto.setFileName(generateFileName(dto));
		dto.setReferenceNo(getTransactionNo());
		dto.setReferenceDt(LocalDateTime.now());
		long menuId = dto.getMenuId();
		dto = repository.save(dto);
		gstWfActionConfigService.saveWfActConfigTrn(GSTUtility.getWfUserReqSDDto(menuId, dto.getId()));
	}

	private String getTransactionNo() throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();

		map.put(Constant.TRN_SCREEN, GSTBlockCPIN.TRN_SCREEN_BMS);
		String procName = GSTConstant.GST_SCHEMA.concat(Constant.DOT.concat(GSTConstant.P_GST_TRN_NO_GEN));
		List<Object[]> nextSequenceNumber = repository.callStoredProcedure(procName, map);
		if (!Utils.isEmpty(nextSequenceNumber)) {
			return (String) nextSequenceNumber.get(0)[0];
		} else {
			throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
		}
	}


	public String generateFileName(GSTBlockCPIN dto) {
		String count = String.format("%6s", dto.getCpinNo());
		return String.format("%s%s", "CN", count).toUpperCase();
	}

	public PagebleDTO<GSTBlockCPINDto> getAll(PageDetails pageDetail) throws CustomException {

		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<GSTBlockCPIN> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<GSTBlockCPIN> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<GSTBlockCPIN> page = repository.findAll(dataSpec, pageable);
			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					convertor.toDTO(page.getContent()));
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	public PagebleDTO<GSTBlockCpinListingDto> getBlockCPINListing(PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(
					search -> map.put(GstDBConstants.getBlockCpinListing().get(search.getKey()), search.getValue()));
		}
		GstDBConstants.getBlockCpinListing().entrySet().stream().filter(e -> !map.containsKey(e.getValue()))
				.forEach(e -> map.put(e.getValue(), ""));

		String procName = GstDBConstants.GST_SCHEMA.concat(Constant.DOT.concat(GstDBConstants.SP_BLOCK_CPIN_LISTING));
		List<GSTBlockCpinListingDto> objectSp = this.callStoreProc(procName, map, GSTBlockCpinListingDto.class);
		long totalPages = !objectSp.isEmpty() ? objectSp.size() : 0;
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objectSp);
	}

	public DTO getCpinStatus(GSTBlockCPINDto dtos) {
		DTO dto = new DTO();
		EODCINFileData rs = cinRespository.findByCpinNo(dtos.getCpinNo()).get();
		filerRepository.findByCpinNo(dtos.getCpinNo()).ifPresent(r -> {
			dto.setStatus(dtos.getRecStatus());
			dto.setCinDtTime(r.getCpinDt());
			dto.setCpinNo(rs.getCpinNo());
			dto.setCinNo(rs.getCinNo());
			dto.setBankCd(r.getBankCd());
			dto.setStateCd(r.getStateCd());
			dto.setFileName(dtos.getFileName());
			dto.setTotalAmt(r.getTotalAmt());
			dto.setCpinAmount(dtos.getCpinAmount());
			dto.setInstrumentType(rs.getInstrumentType());
			dto.setPaymentModeCd(rs.getPaymentModeCd());
			dto.setGstinTmpidNo(rs.getGstinTmpidNo());
			dto.setBankRefNum(rs.getBankRefNum());
			dto.setCpinDtTime(rs.getCpinDt());
			dto.setTax(rs.getCessTax() + rs.getCgstTax() + rs.getIgstTax() + rs.getSgstTax());
			dto.setFee(rs.getCessFee() + rs.getCgstFee() + rs.getIgstFee() + rs.getSgstFee());
			dto.setPenalty(rs.getCessPenalty() + rs.getCgstPenalty() + rs.getIgstPenalty() + rs.getSgstPenalty());
			dto.setInterest(rs.getCessIntr() + rs.getCgstIntr() + rs.getIgstIntr() + rs.getSgstIntr());
			dto.setPartyName(accountRepository.findByCinNo(dto.getCinNo()).getPartyName());
		});
		return dto;

	}

	public ListingDto<GSTBlockCPIN> list(Integer pageNumber,Integer pageSize,GSTBlockCPINDto dtos) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<GSTBlockCPIN> query = cb.createQuery(GSTBlockCPIN.class);
		Root<GSTBlockCPIN> root = query.from(GSTBlockCPIN.class);
		List<Predicate> predicates = new ArrayList<>();

		if (StringUtils.isNotEmpty(dtos.getCinNo())) {
			Path<String> exp = root.get("cinNo");
			predicates.add(cb.like(cb.upper(exp), "%" + dtos.getCinNo() + "%"));
		}

		if (null != dtos.getGovtCreditDt()) {
			Path<Date> exp = root.get("govtCreditDt");
			predicates.add(cb.equal(exp, dtos.getGovtCreditDt()));
		}

		if (null != dtos.getCpinAmount()) {
			Path<String> exp = root.get("cpinAmount");
			predicates.add(cb.equal(exp, dtos.getCpinAmount()));
		}

		if (null != dtos.getCpinNo()) {
			Path<Long> exp = root.get("cpinNo");
			predicates.add(cb.equal(exp, dtos.getCpinNo()));
		}

		if (null != dtos.getCpinDt()) {
			Path<Date> exp = root.get("cpinDt");
			predicates.add(cb.equal(exp, dtos.getCpinDt()));
		}

		if (null != dtos.getReferenceDt()) {
			Path<Date> exp = root.get("referenceDt");
			predicates.add(cb.equal(exp, dtos.getReferenceDt()));
		}

		query.select(root).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
		List<GSTBlockCPIN> list =  entityManager.createQuery(query).setMaxResults(pageSize)
		.setFirstResult(pageNumber * pageSize).getResultList();
		int totalElement = entityManager.createQuery(query).getResultList().size();
		return new ListingDto<>(pageSize, totalElement, list);
	}

	public static boolean isNotEmpty(String value) {
		return !isEmpty(value);
	}

	public static boolean isEmpty(String value) {
		return (value == null || value.trim().length() == 0);
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
		return !objectSp.isEmpty() ? NativeQueryResultsMapper.map(objectSp, view) : Collections.emptyList();
	}
}
