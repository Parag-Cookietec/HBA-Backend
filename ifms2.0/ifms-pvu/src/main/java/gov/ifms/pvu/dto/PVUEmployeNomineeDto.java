/*
 * 
 */
package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotBlank;

import gov.ifms.common.attachment.dto.AttachmentMasterDto;
import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeNomineeDto.
 * 
 * @version v 1.0
 * @created 2019/11/27 03:02:40
 *
 */
public class PVUEmployeNomineeDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp nominee id. */
	private long empNomineeId;

	/** The relationship. */
	private long relationship;
	private String relationshipName;

	/** The nominee name. */
	@NotBlank
	private String nomineeName;

	/** The nominee address. */
	@NotBlank
	private String nomineeAddress;

	/** The nominee age. */
	private String nomineeAge;

	/** The nominee share. */
	private int nomineeShare;

	/** The emp id. */
	private long empId;

	/** The nominee photo. */
	@NotBlank
	private String nomineePhoto;

	/** The gen nominee photo. */
	private String genNomineePhoto;

	/** The nps nominee photo. */
	private String npsNomineePhoto;

	/** The status id. */
	private long statusId;

	/** The other relationship. */
	private String otherRelationship;

	/** The nominee photo attachment. */
	private AttachmentMasterDto nomineePhotoAttachment;

	/** The gen nominee photo. */
	private AttachmentMasterDto genNomineePhotoAttachment;

	/** The nps nominee photo. */
	private AttachmentMasterDto npsNomineePhotoAttachment;

	/** The nominee photo name. */
	private String nomineePhotoName;

	/** The gen nominee form name. */
	private String genNomineeFormName;

	/** The nps nominee form name. */
	private String npsNomineeFormName;

	// upatedRecord = 1, newRecord = 2 , RecordDelete =3
	private long changeType;

	/**
	 * @return the changeType
	 */
	public long getChangeType() {
		return changeType;
	}

	/**
	 * @param changeType the changeType to set
	 */
	public void setChangeType(long changeType) {
		this.changeType = changeType;
	}

	/**
	 * getter setter.
	 *
	 * @return the emp nominee id
	 */

	/**
	 * @return the empNomineeId
	 */
	public long getEmpNomineeId() {
		return empNomineeId;
	}

	/**
	 * Sets the emp nominee id.
	 *
	 * @param empNomineeId the empNomineeId to set
	 */
	public void setEmpNomineeId(long empNomineeId) {
		this.empNomineeId = empNomineeId;
	}

	/**
	 * Gets the relationship.
	 *
	 * @return the relationship
	 */
	public long getRelationship() {
		return relationship;
	}

	/**
	 * Sets the relationship.
	 *
	 * @param relationship the relationship to set
	 */
	public void setRelationship(long relationship) {
		this.relationship = relationship;
	}

	/**
	 * Gets the nominee name.
	 *
	 * @return the nomineeName
	 */
	public String getNomineeName() {
		return nomineeName;
	}

	/**
	 * Sets the nominee name.
	 *
	 * @param nomineeName the nomineeName to set
	 */
	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}

	/**
	 * Gets the nominee address.
	 *
	 * @return the nomineeAddress
	 */
	public String getNomineeAddress() {
		return nomineeAddress;
	}

	/**
	 * Sets the nominee address.
	 *
	 * @param nomineeAddress the nomineeAddress to set
	 */
	public void setNomineeAddress(String nomineeAddress) {
		this.nomineeAddress = nomineeAddress;
	}

	/**
	 * Gets the nominee share.
	 *
	 * @return the nomineeShare
	 */
	public int getNomineeShare() {
		return nomineeShare;
	}

	/**
	 * Sets the nominee share.
	 *
	 * @param nomineeShare the nomineeShare to set
	 */
	public void setNomineeShare(int nomineeShare) {
		this.nomineeShare = nomineeShare;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return empId
	 */
	public long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the new emp id
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the nominee photo.
	 *
	 * @return the nomineePhoto
	 */
	public String getNomineePhoto() {
		return nomineePhoto;
	}

	/**
	 * Sets the nominee photo.
	 *
	 * @param nomineePhoto the nomineePhoto to set
	 */
	public void setNomineePhoto(String nomineePhoto) {
		this.nomineePhoto = nomineePhoto;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the nominee age.
	 *
	 * @return the nominee age
	 */
	public String getNomineeAge() {
		return nomineeAge;
	}

	/**
	 * Sets the nominee age.
	 *
	 * @param nomineeAge the new nominee age
	 */
	public void setNomineeAge(String nomineeAge) {
		this.nomineeAge = nomineeAge;
	}

	/**
	 * Gets the gen nominee photo.
	 *
	 * @return the gen nominee photo
	 */
	public String getGenNomineePhoto() {
		return genNomineePhoto;
	}

	/**
	 * Sets the gen nominee photo.
	 *
	 * @param genNomineePhoto the new gen nominee photo
	 */
	public void setGenNomineePhoto(String genNomineePhoto) {
		this.genNomineePhoto = genNomineePhoto;
	}

	/**
	 * Gets the nps nominee photo.
	 *
	 * @return the nps nominee photo
	 */
	public String getNpsNomineePhoto() {
		return npsNomineePhoto;
	}

	/**
	 * Sets the nps nominee photo.
	 *
	 * @param npsNomineePhoto the new nps nominee photo
	 */
	public void setNpsNomineePhoto(String npsNomineePhoto) {
		this.npsNomineePhoto = npsNomineePhoto;
	}

	/**
	 * Gets the other relationship.
	 *
	 * @return the other relationship
	 */
	public String getOtherRelationship() {
		return otherRelationship;
	}

	/**
	 * Sets the other relationship.
	 *
	 * @param otherRelationship the new other relationship
	 */
	public void setOtherRelationship(String otherRelationship) {
		this.otherRelationship = otherRelationship;
	}

	/**
	 * Gets the nominee photo attachment.
	 *
	 * @return the nominee photo attachment
	 */
	public AttachmentMasterDto getNomineePhotoAttachment() {
		return nomineePhotoAttachment;
	}

	/**
	 * Sets the nominee photo attachment.
	 *
	 * @param nomineePhotoAttachment the new nominee photo attachment
	 */
	public void setNomineePhotoAttachment(AttachmentMasterDto nomineePhotoAttachment) {
		this.nomineePhotoAttachment = nomineePhotoAttachment;
	}

	/**
	 * Gets the nps nominee photo attachment.
	 *
	 * @return the nps nominee photo attachment
	 */
	public AttachmentMasterDto getNpsNomineePhotoAttachment() {
		return npsNomineePhotoAttachment;
	}

	/**
	 * Sets the nps nominee photo attachment.
	 *
	 * @param npsNomineePhotoAttachment the new nps nominee photo attachment
	 */
	public void setNpsNomineePhotoAttachment(AttachmentMasterDto npsNomineePhotoAttachment) {
		this.npsNomineePhotoAttachment = npsNomineePhotoAttachment;
	}

	/**
	 * Gets the gen nominee photo attachment.
	 *
	 * @return the gen nominee photo attachment
	 */
	public AttachmentMasterDto getGenNomineePhotoAttachment() {
		return genNomineePhotoAttachment;
	}

	/**
	 * @return the nomineePhotoName
	 */
	public String getNomineePhotoName() {
		return nomineePhotoName;
	}

	/**
	 * @param nomineePhotoName the nomineePhotoName to set
	 */
	public void setNomineePhotoName(String nomineePhotoName) {
		this.nomineePhotoName = nomineePhotoName;
	}

	/**
	 * @return the genNomineeFormName
	 */
	public String getGenNomineeFormName() {
		return genNomineeFormName;
	}

	/**
	 * @param genNomineeFormName the genNomineeFormName to set
	 */
	public void setGenNomineeFormName(String genNomineeFormName) {
		this.genNomineeFormName = genNomineeFormName;
	}

	/**
	 * @return the npsNomineeFormName
	 */
	public String getNpsNomineeFormName() {
		return npsNomineeFormName;
	}

	/**
	 * @param npsNomineeFormName the npsNomineeFormName to set
	 */
	public void setNpsNomineeFormName(String npsNomineeFormName) {
		this.npsNomineeFormName = npsNomineeFormName;
	}

	/**
	 * Sets the gen nominee photo attachment.
	 *
	 * @param genNomineePhotoAttachment the new gen nominee photo attachment
	 */
	public void setGenNomineePhotoAttachment(AttachmentMasterDto genNomineePhotoAttachment) {
		this.genNomineePhotoAttachment = genNomineePhotoAttachment;
	}

	/**
	 * @return the relationshipName
	 */
	public String getRelationshipName() {
		return relationshipName;
	}

	/**
	 * @param relationshipName the relationshipName to set
	 */
	public void setRelationshipName(String relationshipName) {
		this.relationshipName = relationshipName;
	}

	/**
	 * PVUEmployeNomineeDto Constructor.
	 */
	public PVUEmployeNomineeDto() {
		super();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(empId, empNomineeId, genNomineePhoto, genNomineePhotoAttachment, nomineeAddress, nomineeAge,
				nomineeName, nomineePhoto, nomineePhotoAttachment, nomineeShare, npsNomineePhoto,
				npsNomineePhotoAttachment, otherRelationship, relationship, statusId);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVUEmployeNomineeDto other = (PVUEmployeNomineeDto) obj;
		return empId == other.empId && empNomineeId == other.empNomineeId
				&& Objects.equals(genNomineePhoto, other.genNomineePhoto)
				&& Objects.equals(genNomineePhotoAttachment, other.genNomineePhotoAttachment)
				&& Objects.equals(nomineeAddress, other.nomineeAddress) && Objects.equals(nomineeAge, other.nomineeAge)
				&& Objects.equals(nomineeName, other.nomineeName) && Objects.equals(nomineePhoto, other.nomineePhoto)
				&& Objects.equals(nomineePhotoAttachment, other.nomineePhotoAttachment)
				&& nomineeShare == other.nomineeShare && Objects.equals(npsNomineePhoto, other.npsNomineePhoto)
				&& Objects.equals(npsNomineePhotoAttachment, other.npsNomineePhotoAttachment)
				&& Objects.equals(otherRelationship, other.otherRelationship) && relationship == other.relationship
				&& statusId == other.statusId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeNomineeDto [empNomineeId=" + empNomineeId + ", relationship=" + relationship
				+ ", nomineeName=" + nomineeName + ", nomineeAddress=" + nomineeAddress + ", nomineeAge=" + nomineeAge
				+ ", nomineeShare=" + nomineeShare + ", empId=" + empId + ", nomineePhoto=" + nomineePhoto
				+ ", genNomineePhoto=" + genNomineePhoto + ", npsNomineePhoto=" + npsNomineePhoto + ", statusId="
				+ statusId + ", otherRelationship=" + otherRelationship + ", nomineePhotoAttachment="
				+ nomineePhotoAttachment + ", genNomineePhotoAttachment=" + genNomineePhotoAttachment
				+ ", npsNomineePhotoAttachment=" + npsNomineePhotoAttachment + "]";
	}

}
