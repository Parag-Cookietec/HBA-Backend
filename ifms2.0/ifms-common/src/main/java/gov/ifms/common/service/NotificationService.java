package gov.ifms.common.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.*;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Set;

public interface NotificationService {
	
	Map<String, Object> getNotification(NotificationFatchDTO notificationFatchDTO);

	void postNotification(NotificationPostDTO notificationPostDTO,String token) throws CustomException, UnsupportedEncodingException, NoSuchAlgorithmException;//Need to change For Tempory Perpose

	Map<String, Object> getPreference(PreferenceFatchDTO preferenceFatchDTO);

	void postPreference(PreferencePostDTO preferencePostDTO);

	Map<String, Object> getTemplate(TemplateFatchDTO templateFatchDTO);

	void postTemplate(TemplatePostDTO templatePostDTO);

	void v2PostNotificationRequestParam(NotificationPostDTO notificationPostDTO) throws Exception;

    void v3postNotificationRequestParam(NotificationDto notificationDto) throws Exception;

    Set<NotificationToDoDto> getToDoCount(IdDto idDto) throws CustomException;

	PagebleDTO<SystemNotificationDto> getSystemNotification(PageDetails details) throws CustomException;

    int getSystemNotificationCount(NotificationDto notificationDto);
}
