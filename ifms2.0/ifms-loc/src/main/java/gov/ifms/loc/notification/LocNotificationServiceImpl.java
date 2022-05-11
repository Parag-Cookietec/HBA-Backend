package gov.ifms.loc.notification;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.repository.LocAccountOpeningReqHdrRepository;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.workflow.repository.LocWfActionConfigRepository;

@Service
public class LocNotificationServiceImpl implements LocNotificationService {

	/** The Notification Facade. */
	@Autowired
	LocNotificationFacade locNotificationFacade;

	/** The hdr repo. */
	@Autowired
	LocAccountOpeningReqHdrRepository hdrRepo;
	
	/** The wf action COnfig  repo. */
	@Autowired
	private LocWfActionConfigRepository wfActionConfigRepo;


	@Override
	public List<Long> getPouIdByWfRoleIdOffId(Long assignToOfficeId, Long assignTowfRoleId) {
		return hdrRepo.getUSersByWfRoleOfficeId(assignToOfficeId, assignTowfRoleId);
	}

	private Object[] getTableData(Long menuId) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT SCHEMA_NAME as c0, TRN_WF_TBL_NAME as c1, LK_WF_ATT_TBL_NAME as c2  FROM ");
		sb.append(Constant.EDP_MASTER_SCHEMA).append(".")
				.append("LK_MENU_TBL_INFO where MENU_ID =:menuId and active_status= 1 ");
		map.put("menuId", menuId);
		List<Object[]> objects = hdrRepo.executeSQLQuery(sb.toString(), map);
		if (!Utils.isEmpty(objects)) {
			return objects.get(0);
		}
		throw new CustomException(ErrorResponse.MENU_ID_EMPTY);
	}

	@Override
	public Set<Long> getAllUsersonTransaction(Long trnId, Long menuId) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		Object[] tableData = getTableData(menuId);
		StringBuilder stringQuery = new StringBuilder();
		stringQuery.append(" SELECT ASSIGN_TO_POU_ID FROM ");
		stringQuery.append(tableData[0]).append(".").append(tableData[1])
				.append(" WHERE TRN_ID = :trnId AND ASSIGN_TO_POU_ID is not NULL");
		map.put("trnId", trnId);
		List<Object> lst = hdrRepo.getSingleListOfObject(stringQuery.toString(), map);
		return lst.stream().map(e -> Long.valueOf(String.valueOf(e))).collect(Collectors.toSet());
	}


	@Async
	@Override
	public void sendNotification(LocSubmitWfDto dto) throws CustomException {
		NotificationPostDTO notificationDto = new NotificationPostDTO();
		notificationDto.setMenuId(dto.getMenuId());
		notificationDto.setOfficeId(dto.getAssignByOfficeId());
		notificationDto.setEventCategory(LocConstant.WORK_FLOW);
		notificationDto.setPouId(dto.getAssignToPouId());
		notificationDto.setExpiredDate(new Date());
		notificationDto.setTrnId(dto.getTrnId());
		notificationDto.setCreatedBy(OAuthUtility.getCurrentUserLkPOUId());
		notificationDto.setBranchId(0l);
		notificationDto.setEventName(wfActionConfigRepo.getWfAction(dto.getWfActionId(),Constant.ACTIVE_STATUS));

		List<Long> pouIds = new ArrayList<>();
		if (dto.getWfActionId().equals(LocConstant.APPROVED_ACTION)) {
			if (Objects.isNull(notificationDto.getPouId()) || notificationDto.getPouId()==0) {
				pouIds.addAll(getPouIdByWfRoleIdOffId(dto.getAssignToOfficeId(),
						dto.getAssignToWfRoleId()));
			} else {
				pouIds.add(notificationDto.getPouId());
			}
		}

		if (StringUtils.equals(LocConstant.AUTHORIZED, dto.getTrnStatus())) {
			notificationDto.setEventName(dto.getTrnStatus());
			pouIds.addAll(getAllUsersonTransaction(dto.getTrnId(), dto.getMenuId()));
		}
		if (!CollectionUtils.isEmpty(pouIds)) {
			notificationDto.setAssignToPOUId(StringUtils.join(pouIds, ","));
			locNotificationFacade.notificationRestAPI(notificationDto);
		}
	}
}
