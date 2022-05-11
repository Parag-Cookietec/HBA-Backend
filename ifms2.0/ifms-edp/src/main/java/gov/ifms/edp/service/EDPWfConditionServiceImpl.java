package gov.ifms.edp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.dto.ConditionDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.edp.repository.EDPUsrPoTrnsHeaderRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPNativeSQLUtil;
import gov.ifms.edp.util.EDPUtility;

@Service
public class EDPWfConditionServiceImpl implements EDPWfConditionService {

	/** The EDPMsDesignationAsMethodName repository. */
	@Autowired
	private EDPMsDesignationRepository edpMsDesignationrepository;

	/** The edp usr po trns header repository. */
	@Autowired
	private EDPUsrPoTrnsHeaderRepository edpUsrPoTrnsHeaderRepository;

	@Autowired
	private EDPMsOfficeRepository edpMsOfficeRepository;

	@Override
	public String getCommonCondition(ConditionDto conditionDto) {
		String wfTableName = edpUsrPoTrnsHeaderRepository.findWfTableForMenu(conditionDto.getMenuId()).get(0);
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(EDPConstant.TRN_ID, conditionDto.getTrnId());
		Object obj = edpUsrPoTrnsHeaderRepository
				.executeNativeSQLQuery(EDPNativeSQLUtil.getAssignByOfficeForWf(wfTableName), argMap).get(0);
		EDPMsOfficeEntity officeEntity = edpMsOfficeRepository.getOne(EDPUtility.convertObjectToLong(obj));

		if (conditionDto.getMenuId() != EDPConstant.CREATE_OFFICE_MENU_ID) {
			if ((null != officeEntity.getOfficeSubType())
					&& (officeEntity.getOfficeSubType().equals(EDPConstant.TO_LOOKUP_ID)
							|| officeEntity.getOfficeSubType().equals(EDPConstant.PAO_LOOKUP_ID))) {
				return EDPConstant.TOPAO_INIT;
			} else if (isOfficeDat(officeEntity)) {
				return EDPConstant.DAT_INIT;
			}
			return EDPConstant.DEFAULT_INIT;

		} else {
			EDPMsOfficeEntity offEntity = edpMsOfficeRepository.findByOfficeIdAndActiveStatus(conditionDto.getTrnId(),
					Constant.ACTIVE_STATUS);
			if (isOfficeDat(officeEntity) && (null!=offEntity.getTreasuryType() && offEntity.getTreasuryType() == 63) || (null!=offEntity.getTreasuryType() && offEntity.getTreasuryType() == 65))
				return EDPConstant.FWD_DAT;
			return EDPConstant.FWD_DEFAULT;
		}
	}

	private boolean isOfficeDat(EDPMsOfficeEntity officeEntity) {
		return (null != officeEntity.getOfficeDivision()
				&& officeEntity.getOfficeDivision().equalsIgnoreCase(EDPConstant.DAT_OFFICE));
	}

	@Override
	public String getConditionForAddNewDesignation(ConditionDto conditionDto) {
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(EDPConstant.TRN_ID, conditionDto.getTrnId());
		List<Object> obj = edpMsDesignationrepository.executeNativeSQLQuery(
				EDPNativeSQLUtil.getAssignByOfficeForWf(EDPConstant.T_EDP_DESIGNATION_WF), argMap);
		EDPMsOfficeEntity officeEntity = edpMsOfficeRepository.getOne(EDPUtility.convertObjectToLong(obj.get(0)));
		if (null != officeEntity.getOfficeDivision()
				&& officeEntity.getOfficeDivision().equalsIgnoreCase(EDPConstant.DAT_OFFICE)) {
			return EDPConstant.DAT_INIT;
		}
		return EDPConstant.DEFAULT_INIT;

	}

	@Override
	public String getConditionForRightsMapping(ConditionDto conditionDto) throws CustomException{
		EDPMsOfficeDto currentOffice = OAuthUtility.getCurrentUserOfficeFromToken();
		if(currentOffice.getOfficeTypeId().equals(EDPConstant.DDO_TYPE_ID) && 
				!(null != currentOffice.getOfficeSubType() && (currentOffice.getOfficeSubType().equals(EDPConstant.TO_LOOKUP_ID)
						|| currentOffice.getOfficeSubType().equals(EDPConstant.PAO_LOOKUP_ID)) )
				&& conditionDto.getAction().equals(EDPConstant.ACTION_APPROVE)){
				throw new CustomException(ErrorResponse.WF_ACTIONS_NOT_ALLOWED);
		}
		
		String wfTableName = edpUsrPoTrnsHeaderRepository.findWfTableForMenu(conditionDto.getMenuId()).get(0);
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(EDPConstant.TRN_ID, conditionDto.getTrnId());
		Object obj = edpUsrPoTrnsHeaderRepository
				.executeNativeSQLQuery(EDPNativeSQLUtil.getAssignByOfficeForWf(wfTableName), argMap).get(0);
		EDPMsOfficeEntity officeEntity = edpMsOfficeRepository.getOne(EDPUtility.convertObjectToLong(obj));

			if ((null != officeEntity.getOfficeSubType())
					&& (officeEntity.getOfficeSubType().equals(EDPConstant.TO_LOOKUP_ID)
							|| officeEntity.getOfficeSubType().equals(EDPConstant.PAO_LOOKUP_ID))) {
				return EDPConstant.TOPAO_INIT;
			} else if (isOfficeDat(officeEntity)) {
				return EDPConstant.DAT_INIT;
			}
			return EDPConstant.DEFAULT_INIT;

		}
}
