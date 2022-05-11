package gov.ifms.gst.service.impl;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;
import static java.util.Objects.nonNull;

import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.gst.pagination.SearchParam;
import gov.ifms.gst.dto.GSTBankRateMasterListingDto;
import gov.ifms.gst.util.GSTUtility;
import gov.ifms.gst.util.GstDBConstants;
import gov.ifms.gst.workflow.service.GstWfActionConfigService;
import gov.ifms.gst.workflow.util.GstQueryConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.gst.converter.GSTBankRateMasterConverter;
import gov.ifms.gst.dto.GSTBankRateMasterDto;
import gov.ifms.gst.entity.GSTBankRateMaster;
import gov.ifms.gst.pagination.GstSearchCriteria;
import gov.ifms.gst.repository.GSTBankRateMasterRepository;
import gov.ifms.gst.service.GSTBankRateMasterService;
import gov.ifms.gst.util.GSTConstant;

@Service
public class GSTBankRateMasterServiceImpl implements GSTBankRateMasterService{
	
	@Autowired
	private GSTBankRateMasterConverter bankRateMasterConverter;
	
	@Autowired
	private GSTBankRateMasterRepository bankRateMasterRepository;

	@Autowired
	private GstWfActionConfigService gstWfActionConfigService;

	@Autowired
	private GstSearchCriteria searchCriteria;

	/**
	 * Fetch Bank Rate GST Master by given  id
	 * 
	 * @param id
	 * @return dto
	 */
	@Override
	public GSTBankRateMasterDto getBankRateMaster(Long id) {
		return  bankRateMasterConverter.toDTO(bankRateMasterRepository.getOne(id));
	}

	/**
	 * creates a new Bank Rate GST Master
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Override
	public GSTBankRateMasterDto createBankRateMaster(GSTBankRateMasterDto dto) throws CustomException {
		Double penaltyRate = Double.sum(dto.getBankRate(),dto.getAdditionalRate());
		if(penaltyRate > 100) {
			throw new CustomException(ErrorResponse.RATE_MUST_BE_LESS_THAN_100);
		}
		if(dto.getId()!=null){
            return updateBankRateMaster(dto);
        }else {
            dto.setPanaltyRate(penaltyRate);
            try {
                dto.setReferenceNumber(getTransactionNumber());
            } catch (CustomException e) {
                e.printStackTrace();
            }
            dto.setReferenceDate(LocalDate.now());
            GSTBankRateMaster bankRateMaster = bankRateMasterRepository.findTopByOrderByIdDesc();
            verifyBankRateDetail(bankRateMaster, dto.getEffectiveFromDate());
            if (bankRateMaster != null) {
                bankRateMaster.setEffectiveToDate(dto.getEffectiveFromDate().minusDays(1));
                bankRateMasterRepository.save(bankRateMaster);
            }
			GSTBankRateMasterDto savedDtoDetails = bankRateMasterConverter.toDTO(bankRateMasterRepository.save(bankRateMasterConverter.toEntity(dto)));
			gstWfActionConfigService.saveWfActConfigTrn(GSTUtility.getWfUserReqSDDto(dto.getMenuId(),savedDtoDetails.getId()));
			return savedDtoDetails;
        }
	}
	
	private void verifyBankRateDetail(final GSTBankRateMaster bankRateMaster, final LocalDate bankRateDate) throws CustomException {
		// Check that date should not be past date as of previous entry
		if(nonNull(bankRateMaster)) {
			if(bankRateDate.isBefore(bankRateMaster.getEffectiveFromDate()) ||
					bankRateDate.isEqual(bankRateMaster.getEffectiveFromDate())) {
				throw new CustomException(ErrorResponse.DATE_MUST_NOT_BE_PAST_DATE);
			}

			if(nonNull(bankRateMaster.getEffectiveToDate()) && (bankRateDate.isBefore(bankRateMaster.getEffectiveToDate()) ||
					bankRateDate.isEqual(bankRateMaster.getEffectiveToDate()))) {
				throw new CustomException(ErrorResponse.DATE_MUST_NOT_BE_PAST_DATE);
			}
		}
		// Check that no existing entry should be there apart from 'Approved' status
		Long countUnApprovedBankRates = bankRateMasterRepository.countNotApprovedBankRates();
		if(countUnApprovedBankRates > 0) {
			throw new CustomException(ErrorResponse.CANNOT_CREATE_ALREADY_RECORD_AVAILABLE);
		}
	}

	/**
	 * Update the new Bank Rate GST Master
	 * 
	 * @param dto
	 * @return the updated entity in dto type
	 */
	@Override
	public GSTBankRateMasterDto updateBankRateMaster(GSTBankRateMasterDto dto) {
		
		dto.setPanaltyRate(dto.getBankRate()+dto.getAdditionalRate());
		
		return bankRateMasterConverter.toDTO(bankRateMasterRepository.save(bankRateMasterConverter.toEntity(dto)));
	}

	/**
	 * Gets the Bank Rate GST Master.
	 *
	 * @param pageDetail the page detail
	 * @return the Bank Rate GST Masters
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<GSTBankRateMasterDto> getBankRateMasters(PageDetails pageDetail) throws CustomException {
		
		try {
			PageRequest pageable = null;
			SpecificationImpl<GSTBankRateMaster> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<GSTBankRateMaster> dataSpec = searchCriteria.getGstSpecificationDetail(spec,
					pageDetail.getJsonArr());
			List<GSTBankRateMaster> bankRateMasterList = bankRateMasterRepository.findAll(dataSpec);
			//Page<GSTBankRateMaster> page = bankRateMasterRepository.findAll(dataSpec, pageable);
			Page<GSTBankRateMaster> page = new PageImpl<>(bankRateMasterList,pageable,bankRateMasterList.size());
			List<GSTBankRateMasterDto> dtos = bankRateMasterConverter.toDTO(page.getContent());
			dtos.stream().parallel().filter(br -> {
				try {
					String status = getWfStatusByTrnId(br.getId());
					if(status!=null){
						return status.equalsIgnoreCase("Rejected");
					}
				} catch (CustomException e) {
					e.printStackTrace();
				}
				return false;
			}).forEach(br -> br.setEffectiveToDate(null));
			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),dtos);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public PagebleDTO<GSTBankRateMasterListingDto> getBankRateMasterListing(PageDetails pageDetail)
			throws CustomException, ParseException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(GstDBConstants.getBankRateMasterListing().get(search.getKey()),
					search.getValue()));
		}
		GstDBConstants.getBankRateMasterListing()
				.entrySet().stream()
				.filter(e -> !map.containsKey(e.getValue()))
				.forEach(e -> map.put(e.getValue(),null));
//				.forEach(e -> {
//					if(map.containsKey(e.getKey()))
//				});
		String procName = GstDBConstants.GST_SCHEMA.concat(Constant.DOT.concat(GstDBConstants.SP_BANK_RATE_MASTER_LISTING));
		List<GSTBankRateMasterListingDto> objectSp = this.callStoreProc(procName, map, GSTBankRateMasterListingDto.class);
		long totalPages = !objectSp.isEmpty() ? objectSp.size() : 0;
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objectSp);
	}

//	public Page<GSTBankRateMaster> customFindAll(List<GSTBankRateMaster> findAllList, Pageable pageable) {
//		return (Page)(pageable.isUnpaged() ? new PageImpl(findAllList) : this.readPage(query, this.getDomainClass(), pageable, spec));
//	}
//
//	protected Page<S> readPage(List<GSTBankRateMaster> findAllList, Pageable pageable) {
//		if (pageable.isPaged()) {
//			query.setFirstResult((int)pageable.getOffset());
//			query.setMaxResults(pageable.getPageSize());
//		}
//
//		return PageableExecutionUtils.getPage(query.getResultList(), pageable, () -> {
//			return executeCountQuery(this.getCountQuery(spec, domainClass));
//		});
//	}
	
	/**
	 * Gets the transaction(Reference) number.
	 *
	 * @return the transaction number
	 * @throws CustomException the custom exception
	 */
	private String getTransactionNumber() throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.TRN_SCREEN, GSTBankRateMaster.TRN_SCREEN_BMS);
		String procName = GSTConstant.GST_SCHEMA.concat(Constant.DOT.concat(GSTConstant.P_GST_TRN_NO_GEN));
		List<Object[]> nextSequenceNumber = bankRateMasterRepository.callStoredProcedure(procName, map);
		if (!Utils.isEmpty(nextSequenceNumber)) {
			return (String) nextSequenceNumber.get(0)[0];
		} else {
			throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
		}
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
		List<Object[]> objectSp = bankRateMasterRepository.callStoredProcedure(procName, map);
		return !objectSp.isEmpty() ? NativeQueryResultsMapper.map(objectSp, view) : Collections.emptyList();
	}

	public String getWfStatusByTrnId(long trnId) throws CustomException {
		return bankRateMasterRepository.executeNativeSQLQuerySingle(GstQueryConstant.getBankRateMasterWfStatusFromTrnIdQrStr(),
				GstQueryConstant.getBankRateMasterWfStatusFromTrnIdQrMap(trnId));
	}

}
