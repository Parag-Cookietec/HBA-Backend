package gov.ifms.pvu.service;

import java.util.Date;
import java.util.List;

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
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.pvu.converter.PVUAcpRemarksConverter;
import gov.ifms.pvu.dto.PVUAcpRemarksDto;
import gov.ifms.pvu.entity.PVUAcpRemarksEntity;
import gov.ifms.pvu.repository.PVUAcpRemarksRepository;

/**
 * The Class PVURopRemarksEntityController.
 * 
 * @version v 1.0
 * @created 2020/04/14 15:45:41
 */
@Service
public class PVUAcpRemarksServiceImpl implements PVUAcpRemarksService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The PVURopRemarksEntityAsMethodName repository. */
	@Autowired
	private PVUAcpRemarksRepository repository;

	/** The PVURopRemarksEntityAsMethodName helper. */
	@Autowired
	private PVUAcpRemarksConverter converter;

	/**
	 * Retrieves an PVURopRemarksEntityEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVURopRemarksEntityEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUAcpRemarksEntity getAcpRemarks(Long id) {
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
	public PVUAcpRemarksEntity saveOrUpdateAcpRemarks(PVUAcpRemarksEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the PVURopRemarksEntity items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVURopRemarksEntityDto>
	 */
	@Override
	public PagebleDTO<PVUAcpRemarksDto> getAcpRemarks(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUAcpRemarksEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<PVUAcpRemarksEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<PVUAcpRemarksEntity> page = repository.findAll(dataSpec, pageable);

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
	public void saveOrUpdateAcpRemarksAll(List<PVUAcpRemarksEntity> lstRopRemarks) {
		repository.saveAll(lstRopRemarks);
	}

}
