package gov.ifms.loc.workflow.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPMsLocationEntity;

/**
 * The Class LocMsDivisionEntity.
 */
@Entity
@Table(name = "MS_DIVISION", schema = Constant.BUDGET_MASTER_SCHEMA)
public class LocMsDivisionEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The divison id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DIVISION_ID")
	private long divisonId;

	/** The division name. */
	@Column(name = "DIVISION_NAME")
	private String divisionName;

	/** The division name guj. */
	@Column(name = "DIVISION_NAME_GUJ")
	private String divisionNameGuj;

	/** The division description. */
	@Column(name = "DIVISION_DESCRIPTION")
	private String divisionDescription;

	/** The division description guj. */
	@Column(name = "DIVISION_DESCRIPTION_GUJ")
	private String divisionDescriptionGuj;

	/** The division type id. */
	@Column(name = "DIVISION_TYPE_ID")
	private long divisionTypeId;

	/** The parent division id. */
	@Column(name = "PARENT_DIVISION_ID")
	private long parentDivisionId;

	/** The disirict id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISTRICT_ID", referencedColumnName = "LOCATION_ID")
	private EDPMsLocationEntity disirictId;

	/** The parent division id. */
	@Column(name = "DEPARTMENT_ID")
	private long departmentId;

	/**
	 * MsDivisionDto Constructor.
	 */
	public LocMsDivisionEntity() {
		super();
	}

	/**
	 * Gets the divison id.
	 *
	 * @return the divison id
	 */
	public long getDivisonId() {
		return divisonId;
	}

	/**
	 * Sets the divison id.
	 *
	 * @param divisonId the new divison id
	 */
	public void setDivisonId(long divisonId) {
		this.divisonId = divisonId;
	}

	/**
	 * Gets the division name.
	 *
	 * @return the division name
	 */
	public String getDivisionName() {
		return divisionName;
	}

	/**
	 * Sets the division name.
	 *
	 * @param divisionName the new division name
	 */
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	/**
	 * Gets the division name guj.
	 *
	 * @return the division name guj
	 */
	public String getDivisionNameGuj() {
		return divisionNameGuj;
	}

	/**
	 * Sets the division name guj.
	 *
	 * @param divisionNameGuj the new division name guj
	 */
	public void setDivisionNameGuj(String divisionNameGuj) {
		this.divisionNameGuj = divisionNameGuj;
	}

	/**
	 * Gets the division description.
	 *
	 * @return the division description
	 */
	public String getDivisionDescription() {
		return divisionDescription;
	}

	/**
	 * Sets the division description.
	 *
	 * @param divisionDescription the new division description
	 */
	public void setDivisionDescription(String divisionDescription) {
		this.divisionDescription = divisionDescription;
	}

	/**
	 * Gets the division description guj.
	 *
	 * @return the division description guj
	 */
	public String getDivisionDescriptionGuj() {
		return divisionDescriptionGuj;
	}

	/**
	 * Sets the division description guj.
	 *
	 * @param divisionDescriptionGuj the new division description guj
	 */
	public void setDivisionDescriptionGuj(String divisionDescriptionGuj) {
		this.divisionDescriptionGuj = divisionDescriptionGuj;
	}

	/**
	 * Gets the division type id.
	 *
	 * @return the division type id
	 */
	public long getDivisionTypeId() {
		return divisionTypeId;
	}

	/**
	 * Sets the division type id.
	 *
	 * @param divisionTypeId the new division type id
	 */
	public void setDivisionTypeId(long divisionTypeId) {
		this.divisionTypeId = divisionTypeId;
	}

	/**
	 * Gets the parent division id.
	 *
	 * @return the parent division id
	 */
	public long getParentDivisionId() {
		return parentDivisionId;
	}

	/**
	 * Sets the parent division id.
	 *
	 * @param parentDivisionId the new parent division id
	 */
	public void setParentDivisionId(long parentDivisionId) {
		this.parentDivisionId = parentDivisionId;
	}

	/**
	 * Gets the disirict id.
	 *
	 * @return the disirict id
	 */
	public EDPMsLocationEntity getDisirictId() {
		return disirictId;
	}

	/**
	 * Sets the disirict id.
	 *
	 * @param disirictId the new disirict id
	 */
	public void setDisirictId(EDPMsLocationEntity disirictId) {
		this.disirictId = disirictId;
	}

	public LocMsDivisionEntity(long divisonId) {
		super();
		this.divisonId = divisonId;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

}
