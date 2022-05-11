package gov.ifms.doi.jpa.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.doi.jpa.converter.DoiJPAMasterPolicyConverter;
import gov.ifms.doi.jpa.dto.DoiCommonLookUpInfoDTO;
import gov.ifms.doi.jpa.dto.DoiJpaMasterPolicyDTO;
import gov.ifms.doi.jpa.dto.DoiJpaSchemeMasterDTO;
import gov.ifms.doi.jpa.entity.DoiCommonLookUpInfo;
import gov.ifms.doi.jpa.entity.DoiJPAMasterPolicy;
import gov.ifms.doi.jpa.entity.DoiJPASchemeMaster;
import gov.ifms.doi.jpa.pagination.PageDetails;
import gov.ifms.doi.jpa.pagination.SearchCriteria;
import gov.ifms.doi.jpa.pagination.SpecificationImplimentation;
import gov.ifms.doi.jpa.pagination.Utility;
import gov.ifms.doi.jpa.repository.DoiCommonLookupInfoRepository;
import gov.ifms.doi.jpa.repository.DoiJPAMasterPolicyRepository;
import gov.ifms.doi.jpa.repository.DoiJPASchemeMasterRepository;
import gov.ifms.doi.jpa.service.DoiJPAMasterPolicyService;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@Service
public class DoiJPAMasterPolicyServiceImpl implements DoiJPAMasterPolicyService {

	@Autowired
	private DoiJPAMasterPolicyRepository doiJPAMasterPolicyRepository;
	@Autowired
	DoiJPAMasterPolicyConverter converter;
	@Autowired
	DoiCommonLookupInfoRepository doiCommonLookupInfoRepository;
	@Autowired
	DoiJPASchemeMasterRepository doiJPASchemeMasterRepository;
	
	@Autowired
	Utility utility;

	/**
	 * Convert given DoiJpaMasterPolicyDTO to DoiJPAMasterPolicy Saves a given
	 * DoiJPAMasterPolicy. Use the returned instance for further operations as the
	 * save operation might have changed the entity instance completely.
	 *
	 * @param dto the dto
	 * @return the saved DoiJPAMasterPolicy
	 */
	@Override
	public List<DoiJpaMasterPolicyDTO> saveOrUpdate(List<DoiJpaMasterPolicyDTO> dtoList) {
	  for(DoiJpaMasterPolicyDTO dto : dtoList)
	  {
		if (StringUtils.isEmpty(dto.getReferenceNo())) {
			dto.setReferenceNo(utility.getRefrenceNumber());
		}
		if (dto.getEndorsementSrNo()<=0 && !StringUtils.isEmpty(dto.getPolicyNum())) {
			dto.setEndorsementSrNo(utility.getEndorsementSrNo());
		}
		if (StringUtils.isEmpty(dto.getPolicyNum())) {
			dto.setPolicyNum(utility.getPolicyNumber());
		}
	
		 doiJPAMasterPolicyRepository.save(converter.toEntity(dto));
	  }	
		return dtoList;
	}

	/**
	 * 
	 */
	@Override
	public List<DoiJpaMasterPolicyDTO> findAll(DoiJpaMasterPolicyDTO dto) {
		List<DoiJPAMasterPolicy> list = doiJPAMasterPolicyRepository.findAllByStatus();
		if (dto != null) {
			List<DoiJPAMasterPolicy> filtered = list.stream().filter(entity -> filterData(dto, entity))
					.collect(Collectors.toList());
			return converter.toDTOList(filtered);
		}
		return converter.toDTOList(list);
	}

	@Override
	public List<DoiJpaMasterPolicyDTO> deleteByPolicyId(Long policyId) {
		doiJPAMasterPolicyRepository.softDeleteById(policyId);
		return this.findAll(null);
	}

	private boolean filterData(DoiJpaMasterPolicyDTO jpaData, DoiJPAMasterPolicy entity) {
		return ((jpaData.getPolicyTypeId() == null || entity.getPolicyTypeId().equals(jpaData.getPolicyTypeId()))
				&& (jpaData.getPolicyId() == null || entity.getPolicyId().equals(jpaData.getPolicyId()))
				&& (jpaData.getBeneficiaryNum() == 0 || entity.getBeneficiaryNum() == jpaData.getBeneficiaryNum())
				&& (jpaData.getSchemeName() == null || entity.getSchemeName().contains(jpaData.getSchemeName()))
				&& (jpaData.getPolicyStatus() == null || entity.getPolicyStatus().equals(jpaData.getPolicyStatus())));

	}

	@Override
	public List<DoiJpaMasterPolicyDTO> findBySchemeId(Long schemeId) {
		return converter.toDTO(doiJPAMasterPolicyRepository.findBySchemeId(schemeId));
	}
	
	@Override
	public List<DoiJpaSchemeMasterDTO> getAllSchemes() {
		List<DoiJPASchemeMaster> list = doiJPASchemeMasterRepository.findAllByStatusAsActive();
		List<DoiJpaSchemeMasterDTO> item = new ArrayList<DoiJpaSchemeMasterDTO>();
		DoiJpaSchemeMasterDTO data;
		for(DoiJPASchemeMaster i : list) {
			data = new DoiJpaSchemeMasterDTO();
			data.setActiveStatus(i.getActiveStatus());
			data.setClaimAmount(i.getClaimAmount());
			data.setCreatedBy(i.getCreatedBy());
			data.setCreatedByPost(i.getCreatedByPost());
			data.setCreatedDate(i.getCreatedDate());
			data.setMaximumAgeRange(i.getMaximumAgeRange());
			data.setMinimumAgeRange(i.getMinimumAgeRange());
			data.setNodalOffice(i.getNodalOffice());
			data.setNodelOfficeId(i.getNodelOfficeId());
			data.setReferenceDate(i.getReferenceDate());
			data.setReferenceNo(i.getReferenceNo());
			data.setRemarks(i.getRemarks());
			data.setSchemeId(i.getSchemeId());
			data.setSchemeName(i.getSchemeName());
			data.setSchemeNameGuj(i.getSchemeNameGuj());
			data.setSchemeShortname(i.getSchemeShortname());
			data.setSchemeStatusId(i.getSchemeStatusId());
			data.setUpdatedBy(i.getUpdatedBy());
			data.setUpdatedByPost(i.getUpdatedByPost());
			data.setUpdatedDate(i.getUpdatedDate());
			item.add(data);
		}
		return item;
	}

	@Override
	public List<DoiCommonLookUpInfoDTO> getAllPolicyTypes() {
		List<DoiCommonLookUpInfo> list = doiCommonLookupInfoRepository.getAllPolicyTypes();
		List<DoiCommonLookUpInfoDTO> lookUpInfoData = new ArrayList<DoiCommonLookUpInfoDTO>();
		DoiCommonLookUpInfoDTO item;
		for(DoiCommonLookUpInfo i : list) {
			item = new DoiCommonLookUpInfoDTO();
			item.setActiveStatus(i.getActiveStatus());
			item.setCreatedBy(i.getCreatedBy());
			item.setCreatedByPost(i.getCreatedByPost());
			item.setCreatedDate(i.getCreatedDate());
			item.setOrderId(i.getOrderId());
			item.setLookupInfoDescription(i.getLookupInfoDescription());
			item.setLookupInfoDescriptionGuj(i.getLookupInfoDescriptionGuj());
			item.setLookupInfoName(i.getLookupInfoName());
			item.setLookupInfoNameGuj(i.getLookupInfoNameGuj());
			item.setLookupInfoValue(i.getLookupInfoValue());
			item.setLookupInfoId(i.getLookupInfoId());
			item.setParentLookupId(i.getParentLookupId());
			item.setUpdatedBy(i.getUpdatedBy());
			item.setUpdatedByPost(i.getUpdatedByPost());
			item.setUpdatedDate(i.getUpdatedDate());
			lookUpInfoData.add(item);
		}
		return lookUpInfoData;
	}

	@Override
	public List<DoiCommonLookUpInfoDTO> getAllStatus() {
		List<DoiCommonLookUpInfo> list = doiCommonLookupInfoRepository.getAllStatus();
		List<DoiCommonLookUpInfoDTO> lookUpInfoData = new ArrayList<DoiCommonLookUpInfoDTO>();
		DoiCommonLookUpInfoDTO item;
		for(DoiCommonLookUpInfo i : list) {
			item = new DoiCommonLookUpInfoDTO();
			item.setActiveStatus(i.getActiveStatus());
			item.setCreatedBy(i.getCreatedBy());
			item.setCreatedByPost(i.getCreatedByPost());
			item.setCreatedDate(i.getCreatedDate());
			item.setOrderId(i.getOrderId());
			item.setLookupInfoDescription(i.getLookupInfoDescription());
			item.setLookupInfoDescriptionGuj(i.getLookupInfoDescriptionGuj());
			item.setLookupInfoName(i.getLookupInfoName());
			item.setLookupInfoNameGuj(i.getLookupInfoNameGuj());
			item.setLookupInfoValue(i.getLookupInfoValue());
			item.setLookupInfoId(i.getLookupInfoId());
			item.setParentLookupId(i.getParentLookupId());
			item.setUpdatedBy(i.getUpdatedBy());
			item.setUpdatedByPost(i.getUpdatedByPost());
			item.setUpdatedDate(i.getUpdatedDate());
			lookUpInfoData.add(item);
		}
		return lookUpInfoData;
	}

	@Override
	public PagebleDTO<DoiJpaMasterPolicyDTO> getJpaPolicyMasterPage(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImplimentation<DoiJPAMasterPolicy> spec = new SpecificationImplimentation<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<DoiJPAMasterPolicy> dataSpec = searchCriteria.getSpecificationDetailsDynamic(spec, pageDetail.getJsonArr());
	        Page<DoiJPAMasterPolicy> page = doiJPAMasterPolicyRepository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toDTO(page.getContent()));
		}
		catch (Exception ex) {
			 	throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	
}
