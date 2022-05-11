package gov.ifms.edp.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.converter.EDPMsStateConverter;
import gov.ifms.edp.dto.EDPMsStateDto;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsStateEntity;
import gov.ifms.edp.entity.EDPMsTalukaEntity;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.repository.EDPMsStateRepository;
import gov.ifms.edp.repository.EDPMsTalukaRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPMsStateServiceImpl.
 */
@Service
public class EDPMsStateServiceImpl implements EDPMsStateService {

    /** The logger. */
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /** The EDPMsStateAsMethodName repository. */
    @Autowired
    private EDPMsStateRepository repository;

    /** The EDPMsStateAsMethodName helper. */
    @Autowired
    private EDPMsStateConverter converter;

    /** The district repository. */
    @Autowired
    private EDPMsDistrictRepository districtRepository;

    /** The taluka repository. */
    @Autowired
    private EDPMsTalukaRepository talukaRepository;

    /**
     * Retrieves an EDPMsStateEntity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the EDPMsStateEntity with the given id or {@literal null} if none
     *         found
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    @Override
    public EDPMsStateEntity getMsState(Long id) {
        return repository.getOne(id);
    }

    /**
     * Saves a given EDPMsStateEntity. Use the returned instance for further
     * operations as the save operation might have changed the entity instance
     * completely.
     *
     * @param entity the entity
     * @return the saved EDPMsStateEntity
     */
    @Override
    public EDPMsStateEntity saveOrUpdateMsState(EDPMsStateEntity entity) {
        return repository.save(entity);
    }
    
    /**
     * Fetch all the EDPMsState items with pagination.
     *
     * @param pageDetail the page detail
     * @return List<EDPMsStateDto>
     * @throws CustomException the custom exception
     */
    @Override
    public PagebleDTO<EDPMsStateDto> getMsStates(PageDetails pageDetail) throws CustomException {
        try {
            PageRequest pageable = null;
            SearchCriteria searchCriteria = new SearchCriteria();
            SpecificationImpl<EDPMsStateEntity> spec = new SpecificationImpl<>();
            pageable = pageDetail.getPageDetails(pageDetail);
            Specification<EDPMsStateEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
                    pageDetail.getJsonArr());
            Page<EDPMsStateEntity> page = repository.findAll(dataSpec, pageable);

            return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
                    converter.toDTO(page.getContent()));
        } catch (Exception ex) {
            logger.error(ex.toString());
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }

    /**
     * Gets the SDT data.
     *
     * @return the SDT data
     */
    public List<EDPSDTDto> getSDTData() {
        List<EDPMsStateEntity> states = repository.findByActiveStatus(Constant.ACTIVE_STATUS,EDPUtility.getJpaSort(EDPConstant.STATE_NAME,EDPConstant.ORDER_ASC));
        List<EDPMsDistrictEntity> districs = districtRepository.findByActiveStatus(Constant.ACTIVE_STATUS,EDPUtility.getJpaSort(EDPConstant.DISTRICT_NAME,EDPConstant.ORDER_ASC));
        List<EDPMsTalukaEntity> talukas = talukaRepository.findByActiveStatus(Constant.ACTIVE_STATUS,
        		EDPUtility.getJpaSort(EDPConstant.TALUKA_NAME,EDPConstant.ORDER_ASC));
        return states.stream().map(e -> {
			List<EDPMsDistrictEntity> collect = districs.stream()
					.filter(d -> Objects.equals(e.getStateId(), (d.getStateId()))).collect(Collectors.toList());
			return convertToList(e, collect, talukas);
        }).collect(Collectors.toList());
    }

    /**
     * Convert to list.
     *
     * @param e the e
     * @param d the d
     * @param talukaList the taluka list
     * @return the EDPSDT dto
     */
    private EDPSDTDto convertToList(EDPMsStateEntity e, List<EDPMsDistrictEntity> d, List<EDPMsTalukaEntity> talukaList) {
        EDPSDTDto res = new EDPSDTDto(e.getStateId(), e.getStateName(), e.getStateCode());
        List<EDPSDTDto> collect1 = d.stream().map(a -> {
            EDPSDTDto dist = new EDPSDTDto(a.getDistrictId(), a.getDistrictName(), a.getDistrictCode());
            List<EDPMsTalukaEntity> collect = talukaList.stream().filter(tal -> a.getDistrictId().equals(tal.getDistrictId())).collect(Collectors.toList());
            List<EDPSDTDto> talukas = collect.stream()
                    .map(f -> new EDPSDTDto(f.getTalukaId(), f.getTalukaName(), f.getTalukaCode()))
                    .collect(Collectors.toList());
            dist.setTaluka(talukas);
            return dist;
        }).collect(Collectors.toList());
        res.setDistricts(collect1);
        return res;
    }
}
