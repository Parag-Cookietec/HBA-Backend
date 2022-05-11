package gov.ifms.pvu.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.util.Constant;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.pvu.converter.PVUIncrementEventSummaryConverter;
import gov.ifms.pvu.dto.PVUIncrementEventSummaryDto;
import gov.ifms.pvu.entity.PVUIncrementEventSummaryEntity;
import gov.ifms.pvu.repository.PVUIncrementEventSummaryRepository;

/**
 * The Class PVUIncrementEventSummaryController.
 * 
 * @version v 1.0
 * @created 2020/01/10 15:30:02
 */
@Service("pvuIncSummaryService")
public class PVUIncrementEventSummaryServiceImpl implements PVUIncrementEventSummaryService {

	/** The PVUIncrementEventSummaryAsMethodName repository. */
	@Autowired
	private PVUIncrementEventSummaryRepository repository;

	/** The PVUIncrementEventSummaryAsMethodName helper. */
	@Autowired
	private PVUIncrementEventSummaryConverter converter;

	/**
	 * Retrieves an PVUIncrementEventSummaryEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUIncrementEventSummaryEntity with the given id or
	 *         {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUIncrementEventSummaryEntity getIncrementEventSummary(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUIncrementEventSummaryEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUIncrementEventSummaryEntity
	 */
	@Override
	public PVUIncrementEventSummaryEntity saveOrUpdateIncrementEventSummary(PVUIncrementEventSummaryEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Gets the inc count summary by in event id.
	 *
	 * @param inEventId the in event id
	 * @return the inc count summary by in event id
	 */
	@Override
	public PVUIncrementEventSummaryEntity getIncCountSummaryByInEventId(Long inEventId) {
		return repository.findFirstByInEventIdInEventIdAndActiveStatus(inEventId, Constant.ACTIVE_STATUS);
	}

	/**
	 * Save or update increment event summary.
	 *
	 * @param dto the dto
	 * @return the PVU increment event summary dto
	 */
	@Override
	public PVUIncrementEventSummaryDto saveOrUpdateIncrementEventSummary(PVUIncrementEventSummaryDto dto) {
		long inSmryId = 0;
		PVUIncrementEventSummaryEntity entity = getIncCountSummaryByInEventId(dto.getInEventId());
		if (!Utils.isEmpty(entity)) {
			inSmryId = entity.getInSmryId();
		}
		entity = converter.toEntity(dto);
		entity.setInSmryId(inSmryId);
		entity = saveOrUpdateIncrementEventSummary(entity);
		return converter.toDTO(entity);
	}

	/**
	 * Gets the inc count summary by in event id dto.
	 *
	 * @param inEventId the in event id
	 * @return the inc count summary by in event id dto
	 */
	@Override
	public PVUIncrementEventSummaryDto getIncCountSummaryByInEventIdDto(Long inEventId) {
		PVUIncrementEventSummaryEntity entity = repository.findFirstByInEventIdInEventIdAndActiveStatus(inEventId,
				Constant.ACTIVE_STATUS);
		return converter.toDTO(entity);
	}

	/**
	 * Delete increment summary id by event id.
	 *
	 * @param inActiveStatus the in active status
	 * @param inEventId      the in event id
	 * @param updateBy       the update by
	 * @param updatedDate    the updated date
	 */
	@Override
	public void deleteIncrementSummaryIdByEventId(int inActiveStatus, Long inEventId, Date updatedDate) {
		repository.deleteIncrementSummaryIdByEventId(inActiveStatus, inEventId, updatedDate, OAuthUtility.getCurrentUserUserId(), OAuthUtility.getCurrentUserLkPOUId());
	}

}
