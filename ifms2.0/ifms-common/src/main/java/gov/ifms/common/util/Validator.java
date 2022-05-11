package gov.ifms.common.util;

import java.util.ArrayList;
import java.util.List;

import gov.ifms.common.util.EnumUtils.MessageType;
import gov.ifms.common.validation.MessageDTO;

public class Validator {

	final private static String EMPTY = "";

	final private static String SEPRATOR = ",";

	private List<MessageDTO> messageDTOs = null;

	public Validator() {
		messageDTOs = new ArrayList<>();
	}

	protected boolean addMessage(MessageType messageType, String messageKey, String... fields) {
		String message = EMPTY;
		if (fields != null && fields.length > 0) {
			message = MessageUtil.getMsg(messageKey, fields);
		} else {
			message = MessageUtil.getMsg(messageKey);
		}
		MessageDTO messageDTO = new MessageDTO(messageType, message);
		return messageDTOs.add(messageDTO);
	}

	private String getMessages(MessageType messageType) {
		return prepareMessage(messageType);
	}

	protected String getMessages() {
		return prepareMessage(null);
	}

	private String prepareMessage(MessageType messageType) {
		StringBuffer message = new StringBuffer();
		for (MessageDTO messageDTO : messageDTOs) {
			if (messageType == null) {
				message.append(messageDTO.getMessage() + SEPRATOR);
			} else if (messageType == messageDTO.getType()) {
				message.append(messageDTO.getMessage() + SEPRATOR);
			}
		}
		return message.toString();
	}

	private boolean hasMessageType(MessageType messageType) {
		return messageDTOs.contains(new MessageDTO(messageType, EMPTY));
	}

	public boolean hasErrors() {
		return hasMessageType(MessageType.ERROR);
	}

	public boolean hasWarnings() {
		return hasMessageType(MessageType.WARNING);
	}

	public boolean hasInfo() {
		return hasMessageType(MessageType.INFO);
	}

	public boolean hasSuccess() {
		return hasMessageType(MessageType.SUCCESS);
	}

	public String getErrors() {
		return getMessages(MessageType.ERROR);
	}

	public String getWarning() {
		return getMessages(MessageType.WARNING);
	}

	public String getInfo() {
		return getMessages(MessageType.INFO);
	}

	public String getSuccess() {
		return getMessages(MessageType.SUCCESS);
	}
}
