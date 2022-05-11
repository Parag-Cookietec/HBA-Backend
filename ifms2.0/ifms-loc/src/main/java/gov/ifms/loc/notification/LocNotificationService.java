package gov.ifms.loc.notification;

import java.util.List;
import java.util.Set;

import gov.ifms.common.exception.CustomException;
import gov.ifms.loc.dto.LocSubmitWfDto;

public interface LocNotificationService {



	/**
	 * @param assignToOfficeId
	 * @param assignTowfRoleId 
	 * @return
	 */
	List<Long> getPouIdByWfRoleIdOffId(Long assignToOfficeId, Long assignTowfRoleId);

	/**
	 * @param trnId
	 * @param menuId
	 * @throws CustomException 
	 */
	Set<Long> getAllUsersonTransaction(Long trnId, Long menuId) throws CustomException;

	/**
	 * @param submitWfDto
	 * @throws CustomException 
	 */
	void sendNotification(LocSubmitWfDto submitWfDto) throws CustomException;

	
	
}