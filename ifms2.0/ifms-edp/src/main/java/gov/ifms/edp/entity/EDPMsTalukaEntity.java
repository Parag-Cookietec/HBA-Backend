package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPMsTalukaEntity.
 * 
 * @version 1.0
 * @created 2019/12/11 11:50:41
 *
 */
@Entity
@Table(name = "MS_TALUKA", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsTalukaEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The taluka id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TALUKA_ID")
	private Long talukaId;

	/** The district id. */
	@Column(name = "DISTRICT_ID")
	private Long districtId;

	/** The taluka name. */
	@Column(name = "TALUKA_NAME")
	private String talukaName;

	/** The taluka code. */
	@Column(name = "TALUKA_CODE")
	private String talukaCode;

	@Column(name = "STD_CODE")
	private String stdCode;
	/**
	 * EDPMsTalukaDto Constructor.
	 */
	public EDPMsTalukaEntity() {
		super();
	}
	
	/**
	 * Instantiates a new EDP ms taluka entity.
	 *
	 * @param talukaId the taluka id
	 */
	public EDPMsTalukaEntity(Long talukaId) {
		super();
		this.talukaId = talukaId;
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(talukaId, districtId, talukaName, talukaCode);
	}

	/**
	 * equals method.
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
		if (!(obj instanceof EDPMsTalukaEntity)) {
			return false;
		}

		EDPMsTalukaEntity other = (EDPMsTalukaEntity) obj;

		return Objects.equals(talukaId, other.talukaId)
				&& Objects.equals(districtId, other.districtId) && Objects.equals(talukaName, other.talukaName)
				&& Objects.equals(talukaCode, other.talukaCode);
	}

	/**
	 * getter setter.
	 *
	 * @return the taluka id
	 */

	/**
	 * @return the talukaId
	 */
	public Long getTalukaId() {
		return talukaId;
	}

	/**
	 * Sets the taluka id.
	 *
	 * @param talukaId the talukaId to set
	 */
	public void setTalukaId(Long talukaId) {
		this.talukaId = talukaId;
	}
	
	/**
	 * Gets the district id.
	 *
	 * @return the districtId
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	/**
	 * Gets the taluka name.
	 *
	 * @return the talukaName
	 */
	public String getTalukaName() {
		return talukaName;
	}

	/**
	 * Sets the taluka name.
	 *
	 * @param talukaName the talukaName to set
	 */
	public void setTalukaName(String talukaName) {
		this.talukaName = talukaName;
	}

	/**
	 * Gets the taluka code.
	 *
	 * @return the talukaCode
	 */
	public String getTalukaCode() {
		return talukaCode;
	}

	/**
	 * Sets the taluka code.
	 *
	 * @param talukaCode the talukaCode to set
	 */
	public void setTalukaCode(String talukaCode) {
		this.talukaCode = talukaCode;
	}

	/**
	 * @return the stdCode
	 */
	public String getStdCode() {
		return stdCode;
	}

	/**
	 * @param stdCode the stdCode to set
	 */
	public void setStdCode(String stdCode) {
		this.stdCode = stdCode;
	}
	
}
