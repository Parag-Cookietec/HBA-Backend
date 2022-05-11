package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Date;

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
import gov.ifms.edp.entity.EDPMsOfficeEntity;

/**
 * The Class PVURopInwardEntity.
 * 
 * @version v 1.0
 * @created 2020/03/12 14:42:25
 *
 */
@Entity
@Table(name = "T_PVU_RP_INW", schema = Constant.PVU_SCHEMA)
public class PVURopInwardEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The inward id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_RP_INW_ID")
	private Long inwardId;

	/** The pvu employe entity. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private PVUEmployeEntity pvuEmployeEntity;

	/** The pvu revision of pay entity. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "T_PVU_RP_EVNT_ID", referencedColumnName = "T_PVU_RP_EVNT_ID")
	private PVURevisionOfPayEntity pvuRevisionOfPayEntity;

	/** The workflow id. */
	@Column(name = "WF_ID")
	private Long workflowId;

	/** The inward date. */
	@Column(name = "INWARD_DATE")
	private Date inwardDate;

	/** The inward no. */
	@Column(name = "INWARD_NO")
	private String inwardNo;

	/** The pou id. */
	@Column(name = "POU_ID")
	private Long pouId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;
	
	/**
	 * PVURopInwardEntity Constructor.
	 */
	public PVURopInwardEntity() {
		super();
	}

	/**
	 * Gets the inward id.
	 *
	 * @return the inward id
	 */
	public Long getInwardId() {
		return inwardId;
	}

	/**
	 * Sets the inward id.
	 *
	 * @param inwardId the new inward id
	 */
	public void setInwardId(Long inwardId) {
		this.inwardId = inwardId;
	}

	/**
	 * Gets the pvu employe entity.
	 *
	 * @return the pvu employe entity
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
	 * Gets the pvu revision of pay entity.
	 *
	 * @return the pvu revision of pay entity
	 */
	public PVURevisionOfPayEntity getPvuRevisionOfPayEntity() {
		return pvuRevisionOfPayEntity;
	}

	/**
	 * Sets the pvu revision of pay entity.
	 *
	 * @param pvuRevisionOfPayEntity the new pvu revision of pay entity
	 */
	public void setPvuRevisionOfPayEntity(PVURevisionOfPayEntity pvuRevisionOfPayEntity) {
		this.pvuRevisionOfPayEntity = pvuRevisionOfPayEntity;
	}

	/**
	 * Gets the workflow id.
	 *
	 * @return the workflow id
	 */
	public Long getWorkflowId() {
		return workflowId;
	}

	/**
	 * Sets the workflow id.
	 *
	 * @param workflowId the new workflow id
	 */
	public void setWorkflowId(Long workflowId) {
		this.workflowId = workflowId;
	}

	/**
	 * Gets the inward date.
	 *
	 * @return the inward date
	 */
	public Date getInwardDate() {
		return inwardDate;
	}

	/**
	 * Sets the inward date.
	 *
	 * @param inwardDate the new inward date
	 */
	public void setInwardDate(Date inwardDate) {
		this.inwardDate = inwardDate;
	}

	/**
	 * Gets the inward no.
	 *
	 * @return the inward no
	 */
	public String getInwardNo() {
		return inwardNo;
	}

	/**
	 * Sets the inward no.
	 *
	 * @param inwardNo the new inward no
	 */
	public void setInwardNo(String inwardNo) {
		this.inwardNo = inwardNo;
	}

	/**
	 * Gets the pou id.
	 *
	 * @return the pou id
	 */
	public Long getPouId() {
		return pouId;
	}

	/**
	 * Sets the pou id.
	 *
	 * @param pouId the new pou id
	 */
	public void setPouId(Long pouId) {
		this.pouId = pouId;
	}

	public EDPMsOfficeEntity getOfficeId() {
		return officeId;
	}

	public void setOfficeId(EDPMsOfficeEntity officeId) {
		this.officeId = officeId;
	}

}
