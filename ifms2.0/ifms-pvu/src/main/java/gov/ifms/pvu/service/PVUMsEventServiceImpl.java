package gov.ifms.pvu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.pvu.entity.PVUMsEventEntity;
import gov.ifms.pvu.repository.PVUMsEventRepository;

/**
 * The Class PVUGradePayServiceImpl.
 */
@Service
public class PVUMsEventServiceImpl implements PVUMsEventService {

	/**
	 * The PVUGradePayRepository repository.
	 */
	@Autowired
	private PVUMsEventRepository repository;

	/**
	 * Retrieves an PVUMsEventEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUMsEventEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUMsEventEntity getEventById(long id) throws CustomException {
		return repository.findById(id).orElseThrow(() -> new CustomException(500, "Event Not Found By Id : " + id));
	}

	/**
	 * Saves a given PVUMsEventEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUMsEventEntity
	 */
	@Override
	public PVUMsEventEntity saveOrUpdateMasterEvent(PVUMsEventEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Gets the all events.
	 *
	 * @return the all events
	 */
	@Override
	public List<PVUMsEventEntity> getAllEvents() {
		return repository.findAllByActiveStatus(Constant.ACTIVE_STATUS);
	}

	/**
	 * Gets the pay fixation events.
	 *
	 * @return the pay fixation events
	 */
	@Override
	public List<PVUMsEventEntity> getPayFixationEvents() {
		return repository.findAllByScreenTypeAndActiveStatus(Constant.SCREEN_TYPE_PAY_FIXATION, Constant.ACTIVE_STATUS);
	}

	/**
	 * Gets the pvu events.
	 *
	 * @return the pvu events
	 */
	@Override
	public List<PVUMsEventEntity> getPvuEvents() {
		return repository.findAllByScreenTypeAndActiveStatus(Constant.SCREEN_TYPE_PVU, Constant.ACTIVE_STATUS);
	}

	@Override
	public Optional<PVUMsEventEntity> getEventByEventCode(String eventCode) throws CustomException {
		// Auto-generated method stub
		return repository.findByEventCode(eventCode);
	}

}
