/**
 * 
 */
package gov.ifms.doi.legalentry.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.doi.jpa.converter.DoJpaClaimListingConverter;
import gov.ifms.doi.jpa.dto.DoiJpaClaimListingResponseDTO;
import gov.ifms.doi.jpa.entity.DoiJPAClaimEntryEntity;
import gov.ifms.doi.jpa.pagination.PageDetails;
import gov.ifms.doi.jpa.pagination.SearchCriteria;
import gov.ifms.doi.jpa.pagination.SearchParam;
import gov.ifms.doi.jpa.pagination.SpecificationImplimentation;
import gov.ifms.doi.jpa.repository.DoiJpaClaimListingRepository;
import gov.ifms.doi.legalentry.converter.DOIJPALegalConverter;
import gov.ifms.doi.legalentry.dto.DOIJPALegalDetailEntryDTO;
import gov.ifms.doi.legalentry.dto.DOIJPALegalDetailEntryResponseDTO;
import gov.ifms.doi.legalentry.dto.DOIJPALegalEntryForRequestDTO;
import gov.ifms.doi.legalentry.dto.DOIJPALegalEntryListingRespDTO;
import gov.ifms.doi.legalentry.dto.DOIJpaLegalDtlDTO;
import gov.ifms.doi.legalentry.entity.DOIJPALegalDetailEntryEntity;
import gov.ifms.doi.legalentry.entity.DOIJpaLegalDtlEntity;
import gov.ifms.doi.legalentry.entity.DOIJpaLegalOthrPaymentEntity;
import gov.ifms.doi.legalentry.repository.DOIJPALegalDetailsEntryRepository;
import gov.ifms.doi.legalentry.repository.DOIJPALegalDetlsRepository;
import gov.ifms.doi.legalentry.repository.DOIJPAOtherPaymentDetlsRepository;
import gov.ifms.doi.legalentry.service.DOIJPALegalDetailsEntryService;

/**
 * @author Rudra
 *
 */
@Service
public class DOIJPALegalDetailsEntryServiceImpl implements DOIJPALegalDetailsEntryService {

	/** The logger. */
	private Logger  logger =LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	DOIJPALegalDetailsEntryRepository jpaLegalRepo;

	@Autowired
	DOIJPALegalDetlsRepository jpaDtlsRepo;
	
	@Autowired
	DOIJPAOtherPaymentDetlsRepository jpaOtherPayDtlsRepo;

	@Autowired
	DOIJPALegalConverter converter;
	
	@Autowired
	private DoiJpaClaimListingRepository doiJPAClaimListingRepository;
	
	@Autowired
	private DoJpaClaimListingConverter claimListingconverter;

	/**
	 * Convert given DOIJPALegalDetailEntryDTO to DOIJPALegalDetailEntryEntity Saves
	 * a given DOIJPALegalDetailEntryEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the dto
	 * @return the saved DOIJPALegalDetailEntryEntity
	 */
	@Override
	public DOIJPALegalDetailEntryDTO saveOrUpdateDOIJPALegalEntry(DOIJPALegalDetailEntryDTO dto) {

		DOIJPALegalDetailEntryEntity entryEntity = converter.toLegalDetailEntryEntity(dto);
		entryEntity = jpaLegalRepo.save(entryEntity);
		
		for (DOIJpaLegalDtlDTO detailsDto : dto.getJpaLegalDtlDTO()) {
			DOIJpaLegalDtlEntity detailsEntity = converter.toLegalDetailsEntity(detailsDto);
			detailsEntity.setDoiJpaLegalEntry(entryEntity);
			detailsEntity = jpaDtlsRepo.save(detailsEntity);
			
			for (DOIJpaLegalOthrPaymentEntity otherDetailsEntity : converter.toOtherPaymentEntityList(detailsDto.getDoiJpaLegalOthrPaymentDTO())) {
				otherDetailsEntity.setDoiJpaLegalDtl(detailsEntity);
				jpaOtherPayDtlsRepo.save(otherDetailsEntity);
			}
		}

		return null;
	}

	@Override
	public PagebleDTO<DOIJPALegalEntryListingRespDTO> getJpaLegalEntryListing(PageDetails pageDetail) throws CustomException{
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImplimentation<DOIJpaLegalDtlEntity> spec = new SpecificationImplimentation<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			List<SearchParam> jsonArrList = pageDetail.getJsonArr();
			jsonArrList.add(SearchParam.create("activeStatus", "1"));
			pageDetail.setJsonArr(jsonArrList);
	        Specification<DOIJpaLegalDtlEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
	        Page<DOIJpaLegalDtlEntity> page = jpaDtlsRepo.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toEntryListingRespDTOList(page.getContent()));
		}
		catch (Exception ex) {
			    logger.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public PagebleDTO<DOIJPALegalEntryListingRespDTO> makeJpaLegalEntryforRequest(DOIJPALegalEntryForRequestDTO dto) throws CustomException {
		DOIJpaLegalDtlEntity detailsEntity = converter.toLegalDetailsEntity(dto);
		
		/*
		detailsEntity.setLegalDtlsId(legalDtlsId);
		detailsEntity.setDoiJpaLegalEntry(doiJpaLegalEntry);
		detailsEntity.setCommissionType("");
		*/
		
		detailsEntity.setDoiJpaLegalEntry(jpaLegalRepo.findByLegalEntryId(dto.getLegalEntryId()));
		
		detailsEntity = jpaDtlsRepo.save(detailsEntity);
		
		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(5);
		pageDetail.setPageIndex(0);
		pageDetail.setSortByColumn("doiJpaLegalEntry.inwardNo");
		pageDetail.setSortOrder("asc");
		List<SearchParam> searchParamList = new ArrayList<SearchParam>();
		SearchParam searchParam = new SearchParam();
		searchParam.setKey("activeStatus");
		searchParam.setValue("1");
		searchParamList.add(searchParam);
		pageDetail.setJsonArr(searchParamList);
		return makeJpaLegalEntryforRequestListing(pageDetail);
	}

	@Override
	public PagebleDTO<DOIJPALegalEntryListingRespDTO> makeJpaLegalEntryforRequestListing(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImplimentation<DOIJpaLegalDtlEntity> spec = new SpecificationImplimentation<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			List<SearchParam> jsonArrList = pageDetail.getJsonArr();
			jsonArrList.add(SearchParam.create("activeStatus", "1"));
			pageDetail.setJsonArr(jsonArrList);
	        Specification<DOIJpaLegalDtlEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
	        Page<DOIJpaLegalDtlEntity> page = jpaDtlsRepo.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toEntryListingRespDTOList(page.getContent()));
		}
		catch (Exception ex) {
			    logger.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public PagebleDTO<DoiJpaClaimListingResponseDTO> getJPALegalClaimListingPage(PageDetails pageDetail) throws CustomException{
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImplimentation<DoiJPAClaimEntryEntity> spec = new SpecificationImplimentation<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<DoiJPAClaimEntryEntity> dataSpec = searchCriteria.getSpecificationDetailsDynamic(spec, pageDetail.getJsonArr());
	        Page<DoiJPAClaimEntryEntity> page = doiJPAClaimListingRepository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), claimListingconverter.toDtoListFromEntityList(page.getContent()));
		}
		catch (Exception ex) {
			    logger.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public DOIJPALegalDetailEntryDTO getDOIJPALegalEntry(Long legalEntryId) {
		DOIJPALegalDetailEntryEntity jpaLegalDetailEntryEntity = jpaLegalRepo.findByLegalEntryId(legalEntryId);
		return converter.toJPALegalDetailEntryDTO(jpaLegalDetailEntryEntity);
	}

	@Override
	public DOIJPALegalDetailEntryResponseDTO deleteJpaLegalEntryforRequest(Long legalDtlsId) throws CustomException {
		 
		Optional<DOIJpaLegalDtlEntity> jpaLegalDetailEntryEntity = jpaDtlsRepo.findById(legalDtlsId);
			
		if(jpaLegalDetailEntryEntity!=null)
		{
			jpaDtlsRepo.softDeleteById(legalDtlsId);
		}
//		PageDetails pageDetail = new PageDetails();
//		pageDetail.setPageElement(5);
//		pageDetail.setPageIndex(0);
//		pageDetail.setSortByColumn("doiJpaLegalEntry.inwardNo");
//		pageDetail.setSortOrder("asc");
//		List<SearchParam> searchParamList = new ArrayList<SearchParam>();
//		SearchParam searchParam = new SearchParam();
//		searchParam.setKey("activeStatus");
//		searchParam.setValue("1");
//		searchParamList.add(searchParam);
//		pageDetail.setJsonArr(searchParamList);
//		return makeJpaLegalEntryforRequestListing(pageDetail);

		
	return  converter.toJpaLegalEntryDto(jpaLegalDetailEntryEntity.get());
	}

}
