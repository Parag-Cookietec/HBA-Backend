package gov.ifms.gst.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.pagination.SearchCriteria;
import gov.ifms.gst.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.gst.converter.ScrollDistributionConvertor;
import gov.ifms.gst.dto.ListingDto;
import gov.ifms.gst.dto.ScrollAccountDto;
import gov.ifms.gst.dto.ScrollDistributeDto;
import gov.ifms.gst.entity.RBIAccStmtHdr;
import gov.ifms.gst.entity.RBIFileHdr;
import gov.ifms.gst.entity.SADAChallanMapping;
import gov.ifms.gst.entity.ScrollDistribute;
import gov.ifms.gst.repository.GSTFileProcessRepository;
import gov.ifms.gst.repository.RBIAccStmtHdrRepository;
import gov.ifms.gst.repository.RBIFileHdrRepository;
import gov.ifms.gst.repository.RBIFileTranxnRepository;
import gov.ifms.gst.repository.SADAChallanMappingRepository;
import gov.ifms.gst.repository.ScrollDistributeRepository;
import gov.ifms.gst.util.GSTConstant;

@Service
public class ScrollDistributionServiceImpl {

	@Autowired
	private ScrollDistributionConvertor convertor;

	@Autowired
	private ScrollDistributeRepository repository;
	@Autowired
	private RBIFileTranxnRepository fileTranxnRepository;
	@Autowired
	private RBIFileHdrRepository fileHdrRepository;
	@Autowired
	private GSTFileProcessRepository fileProcesRepository;
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private SADAChallanMappingRepository mappingRepository;
	@Autowired
	private RBIAccStmtHdrRepository stmtRepository;

	public String QUERY = "SELECT tfp.FILE_PROCESS_ID, rft.RBI_FILE_TRANXN_ID, ttbcm.MS_BANK_ID \r\n"
			+ "FROM  EPAO.TPAO_FILE_PROCESS tfp \r\n"
			+ "JOIN EPAO.TPAO_RBI_FILES_HDR trfh ON tfp.FILE_NAME =trfh.FILE_NAME JOIN \r\n"
			+ "EPAO.TPAO_RBI_FILES_TRANXN rft ON trfh.RBI_FILE_HDR_ID  = rft.RBI_FILE_HDR_ID \r\n"
			+ "left join  EPAO.TPAO_TEMP_BANK_CODE_MAPP ttbcm on (substring(rft.END_TO_END_ID,1,4) = ttbcm.BANK_SHORT_CODE)  \r\n"
			+ "JOIN MASTER_V1.MS_BANK mb ON (ttbcm.MS_BANK_ID = mb.BANK_ID ) where rft.TRANSACTION_DTTM =:date AND "
			+ "	tfp.FILE_PROCESS_ID = :processId ";
	public String QUERY_FOR_HA = "SELECt  me.EMPLOYEE_NO AS empno" + "	 FROM MASTER_V1.MS_EMPLOYEE me"
			+ "	INNER JOIN MASTER_V1.MS_USER MSuser ON MSuser.USER_CODE = me.EMPLOYEE_NO"
			+ "	and MSuser.active_status = 1 INNER JOIN  MASTER_V1.LK_PO_OFF_USER pou"
			+ "	 ON pou.USER_ID = MSuser.USER_ID  and pou.active_status = 1"
			+ "	INNER JOIN  MASTER_V1.LK_POST_OFFICE poffice"
			+ "	ON POFFICE.LK_POST_OFFICE_ID = pou.LK_POST_OFFICE_ID and poffice.active_status = 1"
			+ "	inner join master_v1.ms_post post  on poffice.post_id = post.post_id"
			+ "	 and post.active_status = 1 left JOIN  MASTER_V1.TRN_POU_BR_MAP br"
			+ "	ON pou.LK_PO_OFF_USER_ID = br.LK_PO_OFF_USER_ID  AND  pou.LK_PO_OFF_USER_ID = BR.TR_FROM_POU_ID\r\n"
			+ "	and br.active_status = 1 "
			+ "	WHERE br.BRANCH_ID = :branchId AND (post.POST_NAME LIKE '%Head Accountant%' ) ";

	public String create(List<ScrollDistributeDto> dtos) {
		String s = "Scroll Distributed Successfully!";
		dtos.forEach(dto -> {
			try {
				if (!repository.findByScrollNo(dto.getScrollNo()).isPresent()) {
					dto.setReferenceDt(LocalDateTime.now());
					dto.setDistributeStatus("Distributed");
					dto.setFileProcessId(fileProcesRepository.findByFileName(dto.getScrollNo()).get().getId());
					dto.setReferenceNo(getTransactionNo());
					dto.setScrollDt(LocalDateTime.now());
					dto.setChallanDt(fileProcesRepository.findById(dto.getFileProcessId()).get().getFileRecvDt());
					repository.save(convertor.toEntity(dto));
					insertSADAMapping(dto);
				}
			} catch (CustomException e) {
				e.printStackTrace();
			}
		});
		return s;
	}

	@SuppressWarnings("unchecked")
	private void insertSADAMapping(ScrollDistributeDto dto) {
		Query querys = entityManager.createNativeQuery(QUERY_FOR_HA);
		querys.setParameter("branchId", dto.getBranchId());
		List<Object[]> arraStrings = querys.getResultList();
		Long haId = 1l;
		for (int i = 0; i < arraStrings.size(); i++) {
			haId = Long.parseLong(String.valueOf(arraStrings.get(0)));
		}
		Query query = entityManager.createNativeQuery(QUERY);
		query.setParameter("date", dto.getChallanDt());
		query.setParameter("processId", dto.getFileProcessId());
		List<SADAChallanMapping> saDaMapping = (BankMapper.mapperForMapping(query.getResultList()));
		for (SADAChallanMapping mappings : saDaMapping) {
			SADAChallanMapping mapping = new SADAChallanMapping();
			mapping.setBankId(mappings.getBankId());
			mapping.setFileProcessId(mappings.getFileProcessId());
			mapping.setRbiFileTranxnId(mappings.getRbiFileTranxnId());
			mapping.setSaDaId(haId);
			mappingRepository.save(mapping);
		}
	}

	private String getTransactionNo() throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();

		map.put(Constant.TRN_SCREEN, ScrollDistribute.TRN_SCREEN_LBAO);
		String procName = GSTConstant.GST_SCHEMA.concat(Constant.DOT.concat(GSTConstant.P_GST_TRN_NO_GEN));
		List<Object[]> nextSequenceNumber = repository.callStoredProcedure(procName, map);
		if (!Utils.isEmpty(nextSequenceNumber)) {
			return (String) nextSequenceNumber.get(0)[0];
		} else {
			throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
		}
	}

	public PagebleDTO<ScrollDistributeDto> getAll(PageDetails pageDetail) throws CustomException {

		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<ScrollDistribute> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<ScrollDistribute> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<ScrollDistribute> page = repository.findAll(dataSpec, pageable);
			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					convertor.toDTO(page.getContent()));
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	public ListingDto<ScrollDistribute> search(Integer pageNumber, Integer pageSize, ScrollDistributeDto dtos) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ScrollDistribute> query = cb.createQuery(ScrollDistribute.class);
		Root<ScrollDistribute> root = query.from(ScrollDistribute.class);
		List<Predicate> predicates = new ArrayList<>();

		if (null != dtos.getFromDate()) {
			Path<Date> exp = root.get("challanDt");
			predicates.add(cb.greaterThanOrEqualTo(exp, dtos.getFromDate()));
		}
		if (null != dtos.getToDate()) {
			Path<Date> exp = root.get("challanDt");
			predicates.add(cb.lessThanOrEqualTo(exp, dtos.getToDate()));
		}
		if (StringUtils.isNotEmpty( dtos.getBranchName())) {
			Path<String> exp = root.get("branchName");
			predicates.add(cb.equal(exp, dtos.getBranchName()));
		}
		if (StringUtils.isNotEmpty(dtos.getDistributeStatus())) {
			Path<String> exp = root.get("distributeStatus");
			predicates.add(cb.equal(exp, dtos.getDistributeStatus()));
		}
		if (StringUtils.isNotEmpty(dtos.getScrollNo())) {
			Path<String> exp = root.get("scrollNo");
			predicates.add(cb.like(cb.upper(exp), "%" + dtos.getScrollNo() + "%"));
		}
		query.select(root).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
		List<ScrollDistribute> list = entityManager.createQuery(query).setMaxResults(pageSize)
				.setFirstResult(pageNumber * pageSize).getResultList();
		int totalElement = entityManager.createQuery(query).getResultList().size();
		return new ListingDto<>(pageSize, totalElement, list);
	}

	public List<ScrollDistributeDto> searchScroll(ScrollDistributeDto dtos) {
		List<ScrollDistributeDto> scroll = new ArrayList<>();
		fileHdrRepository.findByFileRecvDt(dtos.getScrollDt()).forEach(file -> {
			if (!(repository.findByScrollNo(file.getFileName()).isPresent())) {
				ScrollDistributeDto scrolls = new ScrollDistributeDto();
				fileTranxnRepository.findByRbiFileHdrId(file.getId()).forEach(files -> {
					scrolls.setTotChallanAmt(scrolls.getTotChallanAmt() + files.getTotalTransAmt());
					scrolls.setNoOfChallans((short) (scrolls.getNoOfChallans() + 1));
					scrolls.setScrollNo(file.getFileName());
					scrolls.setDistributeStatus("PENDING");
					scrolls.setDistributionDt(file.getFileRecvDt());
					scrolls.setFileHdrId(file.getId());
					scrolls.setFileProcessId(file.getId());
				});
				scroll.add(scrolls);
			}

		});
		return scroll;
	}

	public List<ScrollAccountDto> scrollReport(ScrollDistributeDto dtos) {
		List<ScrollAccountDto> scrollAccountDto = new ArrayList<>();
		ScrollAccountDto Dto = new ScrollAccountDto();
		Dto.setAmountEScroll(51801.00);
		Dto.setAmountAccounting(51801.00);
		Dto.setMonth(java.sql.Date.valueOf(LocalDate.parse("2021-09-07")));
		Dto.setNoOfEScroll(6);
		Dto.setNoOfNotification(6);
		Dto.setTotalEAmount(Dto.getTotalEAmount() + Dto.getAmountEScroll());
		Dto.setTotalAccountAmount(Dto.getTotalAccountAmount() + Dto.getAmountAccounting());
		Dto.setTotalNoOfEScroll(Dto.getTotalNoOfEScroll() + Dto.getNoOfEScroll());
		Dto.setTotalNoOfNotification(Dto.getTotalNoOfNotification() + Dto.getNoOfNotification());
		Dto.setDiffrenceInAmount(Dto.getTotalAccountAmount() - Dto.getTotalEAmount());
		scrollAccountDto.add(Dto);
		return scrollAccountDto;
	}

	public String scrollVerify(ScrollDistributeDto dto) {
		String s = "";
		RBIAccStmtHdr stst = stmtRepository.findByFileRecvDt(dto.getScrollDt()).get();
		RBIFileHdr hdr = fileHdrRepository.findById(dto.getFileHdrId()).get();
		if (stst.getTotCdtEntrySum().equals(hdr.getTotEntrySum())) {
			s = "Scroll Verified!!!";
		} else {
			s = "Scroll Not verified return Back to Verification To RBI";
		}

		return s;
	}

}
