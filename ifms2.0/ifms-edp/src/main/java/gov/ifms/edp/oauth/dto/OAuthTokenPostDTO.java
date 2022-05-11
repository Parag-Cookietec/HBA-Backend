package gov.ifms.edp.oauth.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import gov.ifms.edp.dto.EDPMsDesignationDto;
import gov.ifms.edp.dto.EDPMsMenuDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;

/**
 * The Class OAuthTokenPostDTO.
 */
public class OAuthTokenPostDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The edp ms menu dto list. */
	private List<EDPMsMenuDto> edpMsMenuDtoList;

	/** The edp ms designation dto. */
	private EDPMsDesignationDto edpMsDesignationDto;

	/** The edp ms office dto. */
	private EDPMsOfficeDto edpMsOfficeDto;
	
	/** The is transaction allow. */
	private boolean isTransactionAllow;
	
	/** The transaction message. */
	private String transactionMessage;

	/**
	 * Gets the edp ms designation dto.
	 *
	 * @return the edp ms designation dto
	 */
	public EDPMsDesignationDto getEdpMsDesignationDto() {
		return edpMsDesignationDto;
	}

	/**
	 * Sets the edp ms designation dto.
	 *
	 * @param edpMsDesignationDto the new edp ms designation dto
	 */
	public void setEdpMsDesignationDto(EDPMsDesignationDto edpMsDesignationDto) {
		this.edpMsDesignationDto = edpMsDesignationDto;
	}

	/**
	 * Gets the edp ms menu dto list.
	 *
	 * @return the edpMsMenuDtoList
	 */
	public List<EDPMsMenuDto> getEdpMsMenuDtoList() {
		return edpMsMenuDtoList;
	}

	/**
	 * Sets the edp ms menu dto list.
	 *
	 * @param edpMsMenuDtoList the edpMsMenuDtoList to set
	 */
	public void setEdpMsMenuDtoList(List<EDPMsMenuDto> edpMsMenuDtoList) {
		this.edpMsMenuDtoList = edpMsMenuDtoList;
	}

	/**
	 * Gets the edp ms office dto.
	 *
	 * @return the edpMsOfficeDto
	 */
	public EDPMsOfficeDto getEdpMsOfficeDto() {
		return edpMsOfficeDto;
	}

	/**
	 * Sets the edp ms office dto.
	 *
	 * @param edpMsOfficeDto the edpMsOfficeDto to set
	 */
	public void setEdpMsOfficeDto(EDPMsOfficeDto edpMsOfficeDto) {
		this.edpMsOfficeDto = edpMsOfficeDto;
	}

	/**
	 * @return the isTransactionAllow
	 */
	public boolean isTransactionAllow() {
		return isTransactionAllow;
	}

	/**
	 * @param isTransactionAllow the isTransactionAllow to set
	 */
	public void setTransactionAllow(boolean isTransactionAllow) {
		this.isTransactionAllow = isTransactionAllow;
	}

	/**
	 * @return the transactionMessage
	 */
	public String getTransactionMessage() {
		return transactionMessage;
	}

	/**
	 * @param transactionMessage the transactionMessage to set
	 */
	public void setTransactionMessage(String transactionMessage) {
		this.transactionMessage = transactionMessage;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(edpMsDesignationDto, edpMsMenuDtoList, edpMsOfficeDto, isTransactionAllow,
				transactionMessage);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof OAuthTokenPostDTO)) {
			return false;
		}
		OAuthTokenPostDTO other = (OAuthTokenPostDTO) obj;
		return Objects.equals(edpMsDesignationDto, other.edpMsDesignationDto)
				&& Objects.equals(edpMsMenuDtoList, other.edpMsMenuDtoList)
				&& Objects.equals(edpMsOfficeDto, other.edpMsOfficeDto)
				&& isTransactionAllow == other.isTransactionAllow
				&& Objects.equals(transactionMessage, other.transactionMessage);
	}

}
