package gov.ifms.doi.jpa.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;

import gov.ifms.doi.jpa.converter.DoiJPASchemeMasterConverter;
import gov.ifms.doi.jpa.dto.DoiJpaSchemeMasterDTO;
import gov.ifms.doi.jpa.entity.DoiJPASchemeMaster;
import gov.ifms.doi.jpa.pagination.PageDetails;
import gov.ifms.doi.jpa.pagination.SearchCriteria;
import gov.ifms.doi.jpa.pagination.SpecificationImplimentation;
import gov.ifms.doi.jpa.pagination.Utility;
import gov.ifms.doi.jpa.repository.DoiJPASchemeMasterRepository;
import gov.ifms.doi.jpa.service.DoiJPASchemeMasterService;

/**
 * 
 * @author Sagar Patil
 *
 */
@Service
public class DoiJPASchemeMasterServiceImpl implements DoiJPASchemeMasterService {

	@Autowired
	private DoiJPASchemeMasterRepository jpaRepository;
	@Autowired
	DoiJPASchemeMasterConverter converter;

	@Autowired
	EntityManager em;

	@Autowired
	Utility utility;

	/**
	 * Convert given DMOMarketLoanDto to DMOMarketLoanEntity Saves a given
	 * DMOMarketLoanEntity. Use the returned instance for further operations as the
	 * save operation might have changed the entity instance completely.
	 *
	 * @param dto the dto
	 * @return the saved DMOMarketLoanEntity
	 */
	@Override
	public List<DoiJpaSchemeMasterDTO> saveOrUpdate(List<DoiJpaSchemeMasterDTO> jpaDataList) {
		for (DoiJpaSchemeMasterDTO jpaData : jpaDataList) {
			if (StringUtils.isEmpty(jpaData.getReferenceNo())) {
				jpaData.setReferenceNo(utility.getRefrenceNumber());
			}
			if (jpaData.getSchemeId() != null) {
				jpaRepository.softDeleteBySchemeId(jpaData.getSchemeId());
				jpaData.setSchemeId(null);
			   }
			 jpaRepository.save(converter.toEntity(jpaData));
		}
		return jpaDataList ; 
	}


	@Override
	public List<DoiJpaSchemeMasterDTO> getAllSchemes(DoiJpaSchemeMasterDTO jpaData) {
		List<DoiJPASchemeMaster> a = jpaRepository.findAllByStatus();
		if (jpaData != null) {
			List<DoiJPASchemeMaster> b = a.stream().filter(entity -> filterData(jpaData, entity))
					.collect(Collectors.toList());
			return converter.toDTOList(b);
		}
		
		return converter.toDTOList(a);
	}

	private boolean filterData(DoiJpaSchemeMasterDTO jpaData, DoiJPASchemeMaster entity) {
		try {
			return ((jpaData.getSchemeName() == null || entity.getSchemeName().contains(jpaData.getSchemeName())
					|| jpaData.getSchemeName().isEmpty())
					&& (jpaData.getSchemeShortname() == null
							|| entity.getSchemeShortname().contains(jpaData.getSchemeShortname())
							|| jpaData.getSchemeShortname().equals(""))
					&& (jpaData.getNodalOffice() == null || entity.getNodalOffice().contains(jpaData.getNodalOffice())
							|| jpaData.getNodalOffice().equals(""))
					&& (jpaData.getStatus() == null || entity.getStatus().equals(jpaData.getStatus())
							|| jpaData.getStatus().equals("")));
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public List<DoiJpaSchemeMasterDTO> softDeleteBySchemeId(Long schemeId) {
		jpaRepository.softDeleteBySchemeId(schemeId);
		return getAllSchemes(new DoiJpaSchemeMasterDTO());
	}

	@Override
	public int updateSchemeStatusBySchemeId(Long schemeId, String status) {
		return jpaRepository.updateSchemeStatusBySchemeId(schemeId, status);
	}


	@Override
	public List<DoiJpaSchemeMasterDTO> getAllActiveSchemes() {
		// TODO Auto-generated method stub
		List<DoiJPASchemeMaster> entitylist = jpaRepository.findAllActive();
		return converter.toDTO(entitylist);
	}

	
	@Override
	public PagebleDTO<DoiJpaSchemeMasterDTO> getAllActiveSchemes(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImplimentation<DoiJPASchemeMaster> spec = new SpecificationImplimentation<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<DoiJPASchemeMaster> dataSpec = searchCriteria.getSpecificationDetailsDynamic(spec, pageDetail.getJsonArr());
	        Page<DoiJPASchemeMaster> page = jpaRepository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toDTO(page.getContent()));
		}
		catch (Exception ex) {
	
				throw new CustomException(HttpStatus.BAD_REQUEST, ex.toString());
		}
	}

	@Override
	public DoiJpaSchemeMasterDTO getSchemeBySchemeId(Long schemeId) throws CustomException {
	   Optional<DoiJPASchemeMaster> schemeMasterEntity = jpaRepository.findById(schemeId);
		if(schemeMasterEntity.isPresent())
		{
			return converter.toDTO(schemeMasterEntity.get());
		}
		else
		{
			throw new CustomException(HttpStatus.BAD_REQUEST, "Scheme master Record is not for this ID");
		}

	}
}
