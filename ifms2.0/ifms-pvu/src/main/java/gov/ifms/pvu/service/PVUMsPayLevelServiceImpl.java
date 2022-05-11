package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.pvu.converter.PVUMsPayLevelConverter;
import gov.ifms.pvu.dto.PVUMsPayLevelDto;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;
import gov.ifms.pvu.repository.PVUMsPayLevelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


/**
 * The Class PVUMsPayLevelServiceImpl.
 *
 * @version v 1.0
 * @created 2019/12/23 17:19:51
 */
@Service
public class PVUMsPayLevelServiceImpl implements PVUMsPayLevelService {

    /**
     * The logger.
     */
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    /**
     * The PVUMsPayLevelRepository repository.
     */
    @Autowired
    private PVUMsPayLevelRepository repository;

    /**
     * The PVUMsPayLevelConverter converter.
     */
    @Autowired
    private PVUMsPayLevelConverter converter;

    /**
     * Retrieves an PVUMsPayLevelEntity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the PVUMsPayLevelEntity with the given id or {@literal null} if none found
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    @Override
    public PVUMsPayLevelEntity getMsPayLevel(Long id) {
        return repository.getOne(id);
    }

    /**
     * Saves a given PVUMsPayLevelEntity. Use the returned instance for further operations
     * as the save operation might have changed the entity instance completely.
     *
     * @param entity the entity
     * @return the saved PVUMsPayLevelEntity
     */
    @Override
    public PVUMsPayLevelEntity saveOrUpdateMsPayLevel(PVUMsPayLevelEntity entity) {
        return repository.save(entity);
    }

    /**
     * Deletes the PVUMsPayLevelEntity with the given id.
     *
     * @param id must not be {@literal null}.
     * @throws IllegalArgumentException in case the given {@code id} is
     *                                  {@literal null}
     */
	/* // uncomment method when require  delete api
	@Override
	public void deleteMsPayLevel(long id,int isDelete) {
		repository.deleteMsPayLevel(id, isDelete ,
				OAuthUtility.getCurrentUserUserId(),new java.util.Date());
	}
    */

    /**
     * Fetch all the PVUMsPayLevel items with pagination.
     *
     * @param pageDetail the page detail
     * @return List<PVUMsPayLevelDto>
     */
    @Override
    public PagebleDTO<PVUMsPayLevelDto> getMsPayLevels(PageDetails pageDetail) throws CustomException {
        try {
            PageRequest pageable = null;
            SearchCriteria searchCriteria = new SearchCriteria();
            SpecificationImpl<PVUMsPayLevelEntity> spec = new SpecificationImpl<>();
            pageable = pageDetail.getPageDetails(pageDetail);
            Specification<PVUMsPayLevelEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
            Page<PVUMsPayLevelEntity> page = repository.findAll(dataSpec, pageable);

            return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
                    converter.toDTO(page.getContent()));
        } catch (Exception ex) {
            LOGGER.error(ex.toString());
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }


}
