package gov.ifms.pvu.service;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.pvu.converter.PVUEmployeeEventStatusConverter;
import gov.ifms.pvu.dto.PVUEmployeeEventStatusDto;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.repository.PVUEmployeeEventStatusRepository;

/**
 * The Class PVUEmployeeEventStatusController.
 *
 * @version v 1.0
 * @created 2020/02/15 14:20:18
 */
@Service
public class PVUEmployeeEventStatusServiceImpl implements PVUEmployeeEventStatusService {

    /**
     * The PVUEmployeeEventStatusAsMethodName repository.
     */
    @Autowired
    private PVUEmployeeEventStatusRepository repository;

    /**
     * The PVUEmployeeEventStatusAsMethodName helper.
     */
    @Autowired
    private PVUEmployeeEventStatusConverter converter;

	@Autowired
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;
	
    /**
     * Retrieves an PVUEmployeeEventStatusEntity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the PVUEmployeeEventStatusEntity with the given id or {@literal null}
     * if none found
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    @Override
    public PVUEmployeeEventStatusEntity getEmployeeEventStatus(Long id) {
        return repository.getOne(id);
    }

    /**
     * Saves a given PVUEmployeeEventStatusEntity. Use the returned instance for
     * further operations as the save operation might have changed the entity
     * instance completely.
     *
     * @param entity the entity
     * @return the saved PVUEmployeeEventStatusEntity
     */
    @Override
    public PVUEmployeeEventStatusEntity saveOrUpdateEmployeeEventStatus(PVUEmployeeEventStatusEntity entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<PVUEmployeeEventStatusEntity> findByEmpId(long empId) {
        return repository.findByEmpIdEmpId(empId);
    }

    @Override
    public PVUEmployeeEventStatusDto getEventStatus(PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity) {
        return getInProgressFlage(pvuEmployeeEventStatusEntity);
    }
    public PVUEmployeeEventStatusDto getSuspensionEventStatus(PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity) {
        PVUEmployeeEventStatusDto statusDto = converter.toDTO(pvuEmployeeEventStatusEntity);
        String transName = null;
         if (statusDto.getSuspension() == 1) {
            transName = "SUS";
        }
        if (transName != null) {
            statusDto.setInProgress(true);
            statusDto.setTransName(transName);
        }
        return statusDto;
    }


    public PVUEmployeeEventStatusDto getInProgressFlage(PVUEmployeeEventStatusEntity pvuEmployeeEventStatusEntity) {
        PVUEmployeeEventStatusDto statusDto = converter.toDTO(pvuEmployeeEventStatusEntity);
        String transName = null;
                
        if (statusDto.getEol() == 1) {
            transName = "EOL";
        } else if (statusDto.getSuspension() == 1) {
            transName = "SUS";
        } else if (statusDto.getPromotion() == 1) {
            transName = "PROMOTION";
        } else if (statusDto.getPromotionForgo() == 1) {
            transName = "PROMOTION_FORGO";
        } else if (statusDto.getDeemedDate() == 1) {
            transName = "DEEMED_DATE";
        } else if (statusDto.getSeniorScale() == 1) {
            transName = "SENIOR_SCALE";
        } else if (statusDto.getChangeScaleR13() == 1) {
            transName = "CHANGE_OF_SCALE";
        } else if (statusDto.getReversion() == 1) {
            transName = "REVERSION";
        } else if (statusDto.getSeniorScalePvu() == 1) {
            transName = "SENIOR_SCALE_PVU";
        } else if (statusDto.getChangeScale() == 1) {
            transName = "CHANGE_OF_SCALE_PVU";
        } else if (statusDto.getTransfer() == 1) {
            transName = "TRANSFER";
        } else if(statusDto.getIncrement() == 1) {
        	transName = "INCREMENT";
        } else if (statusDto.getSelectionGrade() == 1) {
            transName = "SELECTION_GRADE";
        }
        

        return getSecondInProgressFlage(statusDto,transName);
    }

	public PVUEmployeeEventStatusDto getSecondInProgressFlage(PVUEmployeeEventStatusDto statusDto, String transName) {
		if (statusDto.getHighPayScale() == 1) {
			transName = "HIGH_PAY_SCALE";
		} else if (statusDto.getSteppingUp() == 1) {
			transName = "STEPPING_UP";
		} else if (statusDto.getTikuPay() == 1) {
			transName = "TIKU_PAY";
		} else if (statusDto.getShettyPay() == 1) {
			transName = "SHETTY_PAY";
		} else if (statusDto.getCareerAdvancement() == 1) {
			transName = "CAREER_ADVANCEMENT";
		} else if (statusDto.getAssuredCareerProg() == 1) {
			transName = "Assured_Career_Progression";
		}
		if (transName != null) {
			statusDto.setInProgress(true);
			statusDto.setTransName(transName);
		}
		return statusDto;
	}
    @Override
    public void resetIncEmployeeEventStatus(Long trnId, Date updatedDate) {
        repository.resetIncEmployeeEventStatus(trnId, updatedDate, OAuthUtility.getCurrentUserUserId(), OAuthUtility.getCurrentUserLkPOUId());
    }


    @Override
    public List<PVUEmployeeEventStatusDto> getEmployeeInProcessByEmpIds(List<Long> lstEmpIncludeList) {
        return repository.findEmployeeInProgress(lstEmpIncludeList);
    }

    @Override
    public void updateEmployeeIncEventStatus(String trnNo, List<Long> lstEmpIncludeList) {
        repository.updateEmployeeIncEventStatus(trnNo, lstEmpIncludeList, OAuthUtility.getCurrentUserUserId(), OAuthUtility.getCurrentUserLkPOUId());
    }

    @Override
	public PVUEmployeeEventStatusEntity inProgressAnyEvent(Long employeeId) throws CustomException {
        Optional<PVUEmployeeEventStatusEntity> progress = repository.findByEmpIdEmpId(employeeId);
        if (progress.isPresent()) {
            PVUEmployeeEventStatusEntity statusEntity = progress.get();
            PVUEmployeeEventStatusDto eventStatus = getEventStatus(statusEntity);
            if (eventStatus.isInProgress()) {
                throw new CustomException(HttpStatus.CONFLICT, MessageFormat.format(MsgConstant.EVENT_IN_PROGRESS,
                        eventStatus.getTransId(), eventStatus.getEmployeeCode().toString()));
            }
            return statusEntity;
        }
        throw new CustomException(ErrorResponse.ERROR_PVU_VALID_EMP);  
    }
    @Override
    public PVUEmployeeEventStatusEntity inProgressSuspensionEvent(Long employeeId) throws CustomException {
        Optional<PVUEmployeeEventStatusEntity> progress = repository.findByEmpIdEmpId(employeeId);
        if (progress.isPresent()) {
            PVUEmployeeEventStatusEntity statusEntity = progress.get();
            PVUEmployeeEventStatusDto eventStatus = getSuspensionEventStatus(statusEntity);
            if (eventStatus.isInProgress()) {
                throw new CustomException(HttpStatus.CONFLICT, MessageFormat.format(MsgConstant.EVENT_IN_PROGRESS,
                        eventStatus.getTransId(), eventStatus.getEmployeeCode().toString()));
            }
            return statusEntity;
        }
        throw new CustomException(ErrorResponse.ERROR_PVU_VALID_EMP);
    }



    @Override
    public void updateEventInfo(PVUEmployeeEventStatusEntity statusEntry, String trnNo) {
        statusEntry.setTransId(trnNo);
        repository.save(statusEntry);
    }

    @Override
    public PVUEmployeeEventStatusDto findPVUEmployeeStatusDto(Long empId) {
        return repository.findPVUEmployeeStatusDto(empId);
    }

    @Override
    public void resetInProgressEmployeeEventStatus(Long empId, Long updateByPost) {
        repository.resetInProgressEmployeeEventStatus(empId, updateByPost);
    }

    @Override
    public PVUEmployeeEventStatusEntity findOneByEmpId(long empId) throws CustomException {
        return repository.findByEmpIdEmpId(empId).orElseThrow(() -> new CustomException(400, "This employee not created property!"));
    }

	@Override
	public void resetInProgressEventStatusByTransNo(String trnNo, long updatedBy) {
		 repository.resetInProgressEventStatusByTransNo(trnNo, updatedBy);
	}

	@Override
	public List<PVUEmployeeEventStatusDto> getEmployeeInProcessByEmpIdsInOtherTrans(List<Long> lstEmpIncludeList,
			String trnsNo) {
		return repository.findEmployeeInProgress(lstEmpIncludeList, trnsNo);
	}

	@Override
	public void resetEmployeeIncEventStatus(String trnNo, List<Long> lstEmpExcludeList) {
		repository.resetInProgressEventStatusByTransNo(lstEmpExcludeList, trnNo, OAuthUtility.getCurrentUserUserId(), OAuthUtility.getCurrentUserLkPOUId());
	}
	
	/**
	 * In progress any event by trn no.
	 *
	 * @param employeeId the employee id
	 * @param trnNo the trn no
	 * @return the PVU employee event status entity
	 * @throws CustomException the custom exception
	 */
	@Override
	public PVUEmployeeEventStatusEntity inProgressAnyEventByTrnNo(Long employeeId, String trnNo) throws CustomException {
		Optional<PVUEmployeeEventStatusEntity> progress = pvuEmployeeEventStatusService.findByEmpId(employeeId);
		if (!progress.isPresent())
			 throw new CustomException(ErrorResponse.ERROR_PVU_VALID_EMP);  
		if (trnNo.equalsIgnoreCase(progress.get().getTransId())) {
			return progress.get();
		}
		PVUEmployeeEventStatusDto eventStatus = pvuEmployeeEventStatusService.getEventStatus(progress.get());
		if (eventStatus.isInProgress()) {
			throw new CustomException(HttpStatus.CONFLICT, MessageFormat.format(MsgConstant.EVENT_IN_PROGRESS,
					eventStatus.getTransId(), eventStatus.getEmployeeCode().toString()));
		}
		return progress.get();

	}
}
