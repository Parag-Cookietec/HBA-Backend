/*
 * 
 */
package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUEmployeNomineeDto.
 * 
 * @version v 1.0
 * @created 2021/01/22 03:02:40
 *
 */

@NativeQueryResultEntity
public class PVUEmployeNomineeUpdateDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp nominee id. */
	@NativeQueryResultColumn(index = 0)
	private String empNomineeId;

	@NativeQueryResultColumn(index = 1)
	private String relationshipName;

	/** The nominee name. */

	@NativeQueryResultColumn(index = 2)
	private String nomineeName;

	/** The nominee address. */

	@NativeQueryResultColumn(index = 3)
	private String nomineeAddress;

	/** The nominee age. */

	@NativeQueryResultColumn(index = 4)
	private String nomineeAge;

	/** The nominee share. */

	@NativeQueryResultColumn(index = 5)
	private int nomineeShare;

	@NativeQueryResultColumn(index = 6)
	private String updateByUserCode;

	@NativeQueryResultColumn(index = 7)
	private String updateByUserName;

	@NativeQueryResultColumn(index = 8)
	private String updateByPostName;

	@NativeQueryResultColumn(index = 9)
	private String officeName;

	@NativeQueryResultColumn(index = 10)
	private String updateByUpdateDate;


	// upatedRecord = 1, newRecord = 2 , RecordDelete =3
	@NativeQueryResultColumn(index = 11)
	private String changeType ;

	// upatedRecord = 1, newRecord = 2 , RecordDelete =3
	@NativeQueryResultColumn(index = 12)
	private String otherRelationship ;

	@NativeQueryResultColumn(index = 13)
	private String relationshipId ;

	/**
	 * @return the changeType
	 */
	public String getChangeType() {
		return changeType;
	}

	/**
	 * @param changeType the changeType to set
	 */
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	
	/**
	 * @return the empNomineeId
	 */
	public String getEmpNomineeId() {
		return empNomineeId;
	}

	/**
	 * @param empNomineeId the empNomineeId to set
	 */
	public void setEmpNomineeId(String empNomineeId) {
		this.empNomineeId = empNomineeId;
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
	 * @return the nomineeName
	 */
	public String getNomineeName() {
		return nomineeName;
	}

	/**
	 * @param nomineeName the nomineeName to set
	 */
	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}

	/**
	 * @return the nomineeAddress
	 */
	public String getNomineeAddress() {
		return nomineeAddress;
	}

	/**
	 * @param nomineeAddress the nomineeAddress to set
	 */
	public void setNomineeAddress(String nomineeAddress) {
		this.nomineeAddress = nomineeAddress;
	}

	/**
	 * @return the nomineeAge
	 */
	public String getNomineeAge() {
		return nomineeAge;
	}

	/**
	 * @param nomineeAge the nomineeAge to set
	 */
	public void setNomineeAge(String nomineeAge) {
		this.nomineeAge = nomineeAge;
	}

	/**
	 * @return the nomineeShare
	 */
	public int getNomineeShare() {
		return nomineeShare;
	}

	/**
	 * @param nomineeShare the nomineeShare to set
	 */
	public void setNomineeShare(int nomineeShare) {
		this.nomineeShare = nomineeShare;
	}

	/**
	 * @return the updateByUserCode
	 */
	public String getUpdateByUserCode() {
		return updateByUserCode;
	}

	/**
	 * @param updateByUserCode the updateByUserCode to set
	 */
	public void setUpdateByUserCode(String updateByUserCode) {
		this.updateByUserCode = updateByUserCode;
	}

	/**
	 * @return the updateByUserName
	 */
	public String getUpdateByUserName() {
		return updateByUserName;
	}

	/**
	 * @param updateByUserName the updateByUserName to set
	 */
	public void setUpdateByUserName(String updateByUserName) {
		this.updateByUserName = updateByUserName;
	}

	/**
	 * @return the updateByPostName
	 */
	public String getUpdateByPostName() {
		return updateByPostName;
	}

	/**
	 * @param updateByPostName the updateByPostName to set
	 */
	public void setUpdateByPostName(String updateByPostName) {
		this.updateByPostName = updateByPostName;
	}

	/**
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * @return the updateByUpdateDate
	 */
	public String getUpdateByUpdateDate() {
		return updateByUpdateDate;
	}

	/**
	 * @param updateByUpdateDate the updateByUpdateDate to set
	 */
	public void setUpdateByUpdateDate(String updateByUpdateDate) {
		this.updateByUpdateDate = updateByUpdateDate;
	}

	public String getOtherRelationship() {
		return otherRelationship;
	}

	public void setOtherRelationship(String otherRelationship) {
		this.otherRelationship = otherRelationship;
	}

	public String getRelationshipId() {
		return relationshipId;
	}

	public void setRelationshipId(String relationshipId) {
		this.relationshipId = relationshipId;
	}


}
