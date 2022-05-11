package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.pvu.converter.PVUEventRemarksConverter;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.entity.PVUEventRemarksEntity;
import gov.ifms.pvu.repository.PVUEventRemarksRepository;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * The Class PVUEventRemarksServiceImpl.
 */
@Service
public class PVUEventRemarksServiceImpl implements PVUEventRemarksService {

    /**
     * The logger.
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /**
     * The PVUEventRemarksEntityAsMethodName repository.
     */
    @Autowired
    private PVUEventRemarksRepository repository;

    /**
     * The PVUEventRemarksEntityAsMethodName helper.
     */
    @Autowired
    private PVUEventRemarksConverter converter;

    /**
     * Retrieves an PVUEventRemarksEntityEntity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the PVUEventRemarksEntityEntity with the given id or {@literal null}
     * if none found
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    @Override
    public PVUEventRemarksEntity getOne(Long id) {
        return repository.getOne(id);
    }

    /**
     * Saves a given PVUEventRemarksEntityEntity. Use the returned instance for
     * further operations as the save operation might have changed the entity
     * instance completely.
     *
     * @param entity the entity
     * @return the saved PVUEventRemarksEntityEntity
     */
    @Override
    public PVUEventRemarksEntity saveOrUpdateEventRemarks(PVUEventRemarksEntity entity) {
        return repository.save(entity);
    }

    /**
     * Fetch all the PVUEventRemarksEntity items with pagination.
     *
     * @param pageDetail the page detail
     * @return List<PVUEventRemarksEntityDto>
     */
    @Override
    public PagebleDTO<PVUEventRemarksDto> getOne(PageDetails pageDetail) throws CustomException {
        try {
            PageRequest pageable;
            SearchCriteria searchCriteria = new SearchCriteria();
            SpecificationImpl<PVUEventRemarksEntity> spec = new SpecificationImpl<>();
            pageable = pageDetail.getPageDetails(pageDetail);
            Specification<PVUEventRemarksEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
                    pageDetail.getJsonArr());
            Page<PVUEventRemarksEntity> page = repository.findAll(dataSpec, pageable);

            return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
                    converter.toDTO(page.getContent()));
        } catch (Exception ex) {
            logger.error(ex.toString());
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }

    @Override
    public void deactiveOldReason(Long eventId, Long id, int inActiveStatus) {
        repository.deactiveOldReason(eventId, id, inActiveStatus, OAuthUtility.getCurrentUserUserId(), new Date());
    }

    @Override
    public void saveOrUpdateRemarksAll(List<PVUEventRemarksEntity> lstRopRemarks) {
        repository.saveAll(lstRopRemarks);
    }

    @Override
    public void deActivateOldReason(Long trnId, Long eventId) {
        repository.deActivateOldReason(trnId, eventId, Constant.IN_ACTIVE_STATUS, OAuthUtility.getCurrentUserUserId(), new Date());
    }

    @Override
    public List<PVUEventRemarksEntity> saveAll(List<PVUEventRemarksEntity> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public List<PVUEventRemarksDto> getReturnRemarks(Long trnId, Long eventId) throws CustomException {
        Map<String, Object> map = new HashMap<>();
        map.put(PvuConstant.TRN_ID, trnId);
        map.put(PvuConstant.EVENT_ID, eventId);
        map.put(PvuConstant.ACTIVE_STATUS_VAR, Constant.ACTIVE_STATUS);
        List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getPVUReturnRemarks(), map);
        return !Utils.isEmpty(objects) ? NativeQueryResultsMapper.map(objects, PVUEventRemarksDto.class) : Collections.emptyList();
    }



}
