package gov.ifms.common.controller;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.*;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.service.NotificationService;
import gov.ifms.common.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * @author IFMS 2.0
 *
 */
@RestController
@RequestMapping(URLConstant.URL_NOTIFICATION)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NotificationController {
	
	private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);
	
	@Autowired
	private NotificationService notificationService;

	/**
	 * @param notificationFetchDTO : listOfPOUId and listOfMenu
	 * @return ResponseEntity with API Response with Notification(SN list and Todo_Count).
	 */
	@Trace
	@PostMapping(URLConstant.GET_NOTIFICATION)
	public ResponseEntity<ApiResponse> getNotificationDetails(@Valid @RequestBody NotificationFatchDTO notificationFetchDTO) {
		//fetch Data From SP.
		//fetch Base on Notification Preference Table.
		//fetch Data From Todo Table.
		//fetch Data From SN Table.
		logger.info("Inside getNotificationDetails Method");
		Map<String, Object> notificationDetails = notificationService.getNotification(notificationFetchDTO);
		logger.info("Notification Fetch Service class getNotification method Output: {}", notificationDetails);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, notificationDetails);
	}
	
	/**
	 * @param notificationPostDTO : trnId,menuId,eventCategory,eventName,createdBy
	 * @param token
	 * @return ResponseEntity with API Response with status(200 Ok) and Message.
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.POST_NOTIFICATION)
	public ResponseEntity<ApiResponse> postNotificationDetails(@Valid @RequestBody NotificationPostDTO notificationPostDTO,
			@RequestHeader (name="Authorization") String token) throws CustomException, UnsupportedEncodingException, NoSuchAlgorithmException {
		//fetch Data from Template Table as per Menu_ID,Event_Category,Event_Name
		//call Sp with notification post Dto.
		//Call SMS and Email Services.
		//Stored Data in Todo,System Notification Table.
		//Store Data in Notification Transaction Table.
		logger.info("Inside postNotificationDetails Method",token);
		notificationService.postNotification(notificationPostDTO,token);
		logger.info("postNotificationDetails Method Complited Sucessfully",token);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE);
	}
	
	/**
	 * @param preferenceFatchDTO : userId,listOfMenu
	 * @return ResponseEntity with API Response with Preference.
	 */
	@Trace
	@PostMapping(URLConstant.GET_PREFERENCE)
	public ResponseEntity<ApiResponse> getPreferenceDetails(@Valid @RequestBody PreferenceFatchDTO preferenceFatchDTO) {
		//Pass Menu_id and user_id
		logger.info("Inside getPreferenceDetails Method");
		Map<String, Object> notificationDetails = notificationService.getPreference(preferenceFatchDTO);
		logger.info("Notification fetch Service class getPreference method Output: {}", notificationDetails);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, notificationDetails);
	}
	
	/**
	 * @param preferencePostDTO : userId,preferenceForMenu
	 * @return ResponseEntity with API Response with status(200 Ok) and Message.
	 */
	@Trace
	@PostMapping(URLConstant.POST_PREFERENCE)
	public ResponseEntity<ApiResponse> postPreferenceDetails(@Valid @RequestBody PreferencePostDTO preferencePostDTO) {
		logger.info("Inside postPreferenceDetails Method");
		logger.info("Notification Preference Details {}",preferencePostDTO);
		notificationService.postPreference(preferencePostDTO);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE);
	}
	
	/**
	 * @param templateFatchDTO
	 * @return ResponseEntity with API Response with Template.
	 */
	@Trace

	@PostMapping(URLConstant.GET_TEMPLATE)
	public ResponseEntity<ApiResponse> getTemplateDetails(@Valid @RequestBody TemplateFatchDTO templateFatchDTO) {
		logger.info("Inside getTemplateDetails Method");
		Map<String, Object> notificationDetails = notificationService.getTemplate(templateFatchDTO);
		logger.info("Notification Service class getTemplate method Output: {}", notificationDetails);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, notificationDetails);
	}
	
	/**
	 * @param templatePostDTO
	 * @return ResponseEntity with API Response with status(200 Ok) and Message.
	 */
	@Trace
	@PostMapping(URLConstant.POST_TEMPLATE)
	public ResponseEntity<ApiResponse> postTemplateDetails(@Valid @RequestBody TemplatePostDTO templatePostDTO) {
		logger.info("Inside postTemplateDetails Method");
		logger.info("Notification Template {}",templatePostDTO);
		notificationService.postTemplate(templatePostDTO);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE);
	}


	@Trace
	@PostMapping(URLConstant.POST_NOTIFICATION_V2)
	public ResponseEntity<ApiResponse> postNotificationDetailsV2(@Valid @RequestBody NotificationPostDTO notificationPostDTO) throws Exception {
		logger.info("Inside postNotificationDetails Method");
		notificationService.v2PostNotificationRequestParam(notificationPostDTO);
		logger.info("postNotificationDetails Method Completed Successfully");
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE);
	}


	@Trace
	@PostMapping(URLConstant.POST_NOTIFICATION_V3)
	public ResponseEntity<ApiResponse> postNotificationDetailsV3(@Valid @RequestBody NotificationDto notificationDto) throws Exception {
		logger.info("Inside postNotificationDetails Method");
		notificationService.v3postNotificationRequestParam(notificationDto);
		logger.info("postNotificationDetails Method Completed Successfully");
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE);
	}


	@Trace
	@PostMapping(URLConstant.GET_TO_DO_COUNT)
	public ResponseEntity<ApiResponse> getToDoCount(@Valid @RequestBody IdDto idDto) throws Exception {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,notificationService.getToDoCount(idDto));
	}

	@Trace
	@PostMapping(URLConstant.GET_SN_LIST)
	public ResponseEntity<ApiResponse> getSystemNotification(@RequestBody PageDetails pageDetail) throws Exception {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,notificationService.getSystemNotification(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.GET_SN_COUNT)
	public ResponseEntity<ApiResponse> getSystemNotificationCount(@RequestBody NotificationDto notificationDto) throws Exception {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,notificationService.getSystemNotificationCount(notificationDto));
	}
}
