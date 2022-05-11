package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

/**
 * The Class PVUEmployeNomineeEntity.
 * 
 * @version v 1.0
 * @created 2019/11/27 03:02:40
 *
 */
@Entity
@Table(name = "T_EMP_NOMI_DTL", schema = Constant.PVU_SCHEMA)
public class PVUEmployeNomineeEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp nominee id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EMP_NOMI_DTL_ID")
	private long empNomineeId;

	/** The relationship. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "RELATIONSHIP", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity relationship;

	/** The nominee name. */
	@Column(name = "NOMINEE_NAME")
	private String nomineeName;

	/** The nominee address. */
	@Column(name = "NOMINEE_ADDR")
	private String nomineeAddress;

	/** The nominee age. */
	@Column(name = "NOMINEE_AGE")
	private String nomineeAge;

	/** The nominee share. */
	@Column(name = "PERC_SHARE")
	private int nomineeShare;

	/** The pvu employe entity. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private PVUEmployeEntity pvuEmployeEntity;

	/** The nominee photo. */
	@Column(name = "NOMINEE_PHOTO")
	private String nomineePhoto;

	/** The gen nominee photo. */
	@Column(name = "GEN_NOMI_FORM")
	private String genNomineePhoto;

	/** The nps nominee photo. */
	@Column(name = "NPS_NOMI_FORM")
	private String npsNomineePhoto;

	/** The relationship. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/** The file. */
	private transient MultipartFile file;
	
	/** The other relationship. */
	@Column(name = "OTHER_RELATIONSHIP")
	private String otherRelationship;

	/** The nominee photo name. */
	@Column(name = "NOMINEE_PHOTO_NAME")
	private String nomineePhotoName;
	
	/** The gen nominee form name. */
	@Column(name = "GEN_NOMI_FORM_NAME")
	private String genNomineeFormName;
	
	/** The nps nominee form name. */
	@Column(name = "NPS_NOMI_FORM_NAME")
	private String npsNomineeFormName;
	
	@Column(name = "CHANGE_TYPE")
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
	 * @return the nominee age
	 */

	/**
	 * @return the nomineeAge
	 */
	public String getNomineeAge() {
		return nomineeAge;
	}

	/**
	 * Sets the nominee age.
	 *
	 * @param nomineeAge the nomineeAge to set
	 */
	public void setNomineeAge(String nomineeAge) {
		this.nomineeAge = nomineeAge;
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
	 * Gets the gen nominee photo.
	 *
	 * @return the genNomineePhoto
	 */
	public String getGenNomineePhoto() {
		return genNomineePhoto;
	}

	/**
	 * Sets the gen nominee photo.
	 *
	 * @param genNomineePhoto the genNomineePhoto to set
	 */
	public void setGenNomineePhoto(String genNomineePhoto) {
		this.genNomineePhoto = genNomineePhoto;
	}

	/**
	 * Gets the nps nominee photo.
	 *
	 * @return the npsNomineePhoto
	 */
	public String getNpsNomineePhoto() {
		return npsNomineePhoto;
	}

	/**
	 * Sets the nps nominee photo.
	 *
	 * @param npsNomineePhoto the npsNomineePhoto to set
	 */
	public void setNpsNomineePhoto(String npsNomineePhoto) {
		this.npsNomineePhoto = npsNomineePhoto;
	}

	/**
	 * Gets the emp nominee id.
	 *
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
	 * Gets the file.
	 *
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}

	/**
	 * Sets the file.
	 *
	 * @param file the new file
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}

	/**
	 * Gets the relationship.
	 *
	 * @return the relationship
	 */
	public EDPLuLookUpInfoEntity getRelationship() {
		return relationship;
	}

	/**
	 * Sets the relationship.
	 *
	 * @param relationship the relationship to set
	 */
	public void setRelationship(EDPLuLookUpInfoEntity relationship) {
		this.relationship = relationship;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
		this.statusId = statusId;
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
	 * Gets the nominee photo name.
	 *
	 * @return the nomineePhotoName
	 */
	public String getNomineePhotoName() {
		return nomineePhotoName;
	}

	/**
	 * Sets the nominee photo name.
	 *
	 * @param nomineePhotoName the nomineePhotoName to set
	 */
	public void setNomineePhotoName(String nomineePhotoName) {
		this.nomineePhotoName = nomineePhotoName;
	}

	/**
	 * Gets the gen nominee form name.
	 *
	 * @return the genNomineeFormName
	 */
	public String getGenNomineeFormName() {
		return genNomineeFormName;
	}

	/**
	 * Sets the gen nominee form name.
	 *
	 * @param genNomineeFormName the genNomineeFormName to set
	 */
	public void setGenNomineeFormName(String genNomineeFormName) {
		this.genNomineeFormName = genNomineeFormName;
	}

	/**
	 * Gets the nps nominee form name.
	 *
	 * @return the npsNomineeFormName
	 */
	public String getNpsNomineeFormName() {
		return npsNomineeFormName;
	}

	/**
	 * Sets the nps nominee form name.
	 *
	 * @param npsNomineeFormName the npsNomineeFormName to set
	 */
	public void setNpsNomineeFormName(String npsNomineeFormName) {
		this.npsNomineeFormName = npsNomineeFormName;
	}

	/**
	 * Gets the pvu employe entity.
	 *
	 * @return pvuEmployeEntity
	 */
	public PVUEmployeEntity getPvuEmployeEntity() {
		return pvuEmployeEntity;
	}

	/**
	 * Sets the pvu employe entity.
	 *
	 * @param pvuEmployeEntity the new pvu employe entity
	 */
	public void setPvuEmployeEntity(PVUEmployeEntity pvuEmployeEntity) {
		this.pvuEmployeEntity = pvuEmployeEntity;
	}

	/**
	 * PVUEmployeNomineeEntity Constructor.
	 */
	public PVUEmployeNomineeEntity() {
		super();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(empNomineeId, genNomineeFormName, genNomineePhoto, nomineeAddress, nomineeAge, nomineeName,
				nomineePhoto, nomineePhotoName, nomineeShare, npsNomineeFormName, npsNomineePhoto, otherRelationship,
				pvuEmployeEntity, relationship, statusId);
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
		PVUEmployeNomineeEntity other = (PVUEmployeNomineeEntity) obj;
		return empNomineeId == other.empNomineeId && Objects.equals(genNomineeFormName, other.genNomineeFormName)
				&& Objects.equals(genNomineePhoto, other.genNomineePhoto)
				&& Objects.equals(nomineeAddress, other.nomineeAddress) && Objects.equals(nomineeAge, other.nomineeAge)
				&& Objects.equals(nomineeName, other.nomineeName) && Objects.equals(nomineePhoto, other.nomineePhoto)
				&& Objects.equals(nomineePhotoName, other.nomineePhotoName) && nomineeShare == other.nomineeShare
				&& Objects.equals(npsNomineeFormName, other.npsNomineeFormName)
				&& Objects.equals(npsNomineePhoto, other.npsNomineePhoto)
				&& Objects.equals(otherRelationship, other.otherRelationship)
				&& Objects.equals(pvuEmployeEntity, other.pvuEmployeEntity)
				&& Objects.equals(relationship, other.relationship) && Objects.equals(statusId, other.statusId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeNomineeEntity [empNomineeId=" + empNomineeId + ", relationship=" + relationship
				+ ", nomineeName=" + nomineeName + ", nomineeAddress=" + nomineeAddress + ", nomineeAge=" + nomineeAge
				+ ", nomineeShare=" + nomineeShare + ", pvuEmployeEntity=" + pvuEmployeEntity + ", nomineePhoto="
				+ nomineePhoto + ", genNomineePhoto=" + genNomineePhoto + ", npsNomineePhoto=" + npsNomineePhoto
				+ ", statusId=" + statusId + ", otherRelationship=" + otherRelationship + ", nomineePhotoName="
				+ nomineePhotoName + ", genNomineeFormName=" + genNomineeFormName + ", npsNomineeFormName="
				+ npsNomineeFormName + "]";
	}

}
