package gov.ifms.pvu.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.pvu.entity.PVUInwardEntity;
import gov.ifms.pvu.repository.PVUInwardRepository;

/**
 * The Class PVUEventInwardServiceImpl.
 */
@Service
@Transactional
public class PVUInwardServiceImpl implements PVUInwardService {

	@Autowired
	private PVUInwardRepository repository;

	@Override
	public PVUInwardEntity getOneById(long id) {
		return repository.getOne(id);
	}

	@Override
	public PVUInwardEntity save(PVUInwardEntity entity) {
		return repository.save(entity);
	}

	@Override
	public List<PVUInwardEntity> saveAll(List<PVUInwardEntity> entities) {
		return repository.saveAll(entities);
	}

	@Override
	public void setConsignmentNumber(Long trnId, Long eventId, String postConsignmentNo) {
		repository.setPostConsignmentNumber(trnId, eventId, OAuthUtility.getCurrentUserUserId(), postConsignmentNo,
				Constant.ACTIVE_STATUS);
	}

	@Override
	public void setAuthDate(Long trnId, Long eventId, LocalDateTime date) {
		repository.setAuthDate(trnId, eventId, OAuthUtility.getCurrentUserUserId(), date, Constant.ACTIVE_STATUS);
	}

	@Override
	public void setReturnDate(Long trnId, Long eventId, LocalDateTime date) {
		repository.setReturnDate(trnId, eventId, OAuthUtility.getCurrentUserUserId(), date, 1, Constant.ACTIVE_STATUS);
	}

	@Override
	public void setResetOutwardFlag(Long trnId, Long eventId) {
		repository.setResetOutWardFlag(trnId, eventId, OAuthUtility.getCurrentUserUserId(), 0, Constant.ACTIVE_STATUS);
	}

	@Override
	public void setOutwardFlag(Long trnId, Long eventId) {
		repository.setResetOutWardFlag(trnId, eventId, OAuthUtility.getCurrentUserUserId(), 1, Constant.ACTIVE_STATUS);
	}

	@Override
	public void setInwardNumberNull(Long trnId, Long eventId, LocalDateTime date) {
		repository.setInwardNumberNull(trnId, eventId, OAuthUtility.getCurrentUserUserId(), Constant.ACTIVE_STATUS);
	}
	
	@Override
	public void updateStatusId(int activeStatus, Long trnId, Date updatedDate, Long pvuEventId) {
		repository.updateSatus(activeStatus, trnId,  OAuthUtility.getCurrentUserUserId(), updatedDate, pvuEventId);
	}
}
