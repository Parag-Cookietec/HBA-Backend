package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.pvu.converter.PVURopRemarksConverter;
import gov.ifms.pvu.dto.PVURopRemarksDto;
import gov.ifms.pvu.entity.PVURopRemarksEntity;
import gov.ifms.pvu.repository.PVURopRemarksRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * The Class PVURopRemarksEntityController.
 * 
 * @version v 1.0
 * @created 2020/04/14 15:45:41
 */
@Service
public class PVURopRemarksServiceImpl implements PVURopRemarksService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The PVURopRemarksEntityAsMethodName repository. */
	@Autowired
	private PVURopRemarksRepository repository;

	/** The PVURopRemarksEntityAsMethodName helper. */
	@Autowired
	private PVURopRemarksConverter converter;

	/**
	 * Retrieves an PVURopRemarksEntityEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVURopRemarksEntityEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVURopRemarksEntity getRopRemarks(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVURopRemarksEntityEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVURopRemarksEntityEntity
	 */
	@Override
	public PVURopRemarksEntity saveOrUpdateRopRemarks(PVURopRemarksEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the PVURopRemarksEntity items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVURopRemarksEntityDto>
	 */
	@Override
	public PagebleDTO<PVURopRemarksDto> getRopRemarks(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVURopRemarksEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<PVURopRemarksEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<PVURopRemarksEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public void deactiveOldReason(Long id, int inActiveStatus) {
		repository.deactiveOldReason(id, inActiveStatus, OAuthUtility.getCurrentUserUserId(), new Date());
	}

	@Override
	public void saveOrUpdateRopRemarksAll(List<PVURopRemarksEntity> lstRopRemarks) {
		repository.saveAll(lstRopRemarks);
	}

}
