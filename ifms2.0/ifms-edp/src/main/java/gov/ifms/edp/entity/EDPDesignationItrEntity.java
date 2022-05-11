package gov.ifms.edp.entity;

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

import gov.ifms.common.util.Constant;

/**
 * The Class EDPDesignationItrEntity.
 */
@Entity
@Table(name = "T_DESIGNATION_ITR", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPDesignationItrEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The designation itr id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_DESIGNATION_ITR_ID")
	private Long designationItrId;

	/** The designation id. */
	@Column(name = "DESIGNATION_ID")
	private Long designationId;

	/** The designation name. */
	@Column(name = "DESIGNATION_NAME")
	private String designationName;

	/** The designation name guj. */
	@Column(name = "DESIGNATION_NAME_GUJ")
	private String designationNameGuj;

	/** The designation description. */
	@Column(name = "DESIGNATION_DESC")
	private String designationDescription;

	/** The designation description guj. */
	@Column(name = "DESIGNATION_DESC_GUJ")
	private String designationDescriptionGuj;

	/** The designation short name. */
	@Column(name = "DSGN_SHORT_NAME")
	private String designationShortName;

	/** The designation short name guj. */
	@Column(name = "DSGN_SHORT_NAME_GUJ")
	private String designationShortNameGuj;

	/** The designation code. */
	@Column(name = "DESIGNATION_CODE")
	private String designationCode;

	/** The designation code guj. */
	@Column(name = "DESIGNATION_CODE_GUJ")
	private String designationCodeGuj;

	/** The parent designation id. */
	@Column(name = "PARENT_DSGN_ID")
	private Long parentDesignationId;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/** The trn no. */
	@Column(name = "TRN_NO")
	private Long trnNo;

	/** The office id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;

	/** The has objection. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OBJECTION", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity hasObjection;

	/** The objection remarks. */
	@Column(name = "OBJECTION_REMARKS")
	private String objectionRemarks;

	/** The initiated by. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INITIATED_BY", referencedColumnName = "LK_PO_OFF_USER_ID")
	private EDPLkPoOffUserEntity initiatedBy;

	/** The wf in request. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WF_IN_REQUEST", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity wfInRequest;

	/**
	 * @return the wfInRequest
	 */
	public EDPLuLookUpInfoEntity getWfInRequest() {
		return wfInRequest;
	}

	/**
	 * @param wfInRequest the wfInRequest to set
	 */
	public void setWfInRequest(EDPLuLookUpInfoEntity wfInRequest) {
		this.wfInRequest = wfInRequest;
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
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public EDPMsOfficeEntity getOfficeId() {
		return officeId;
	}

	/**
	 * @return the hasObjection
	 */
	public EDPLuLookUpInfoEntity getHasObjection() {
		return hasObjection;
	}

	/**
	 * @param hasObjection the hasObjection to set
	 */
	public void setHasObjection(EDPLuLookUpInfoEntity hasObjection) {
		this.hasObjection = hasObjection;
	}

	/**
	 * @return the objectionRemarks
	 */
	public String getObjectionRemarks() {
		return objectionRemarks;
	}

	/**
	 * @param objectionRemarks the objectionRemarks to set
	 */
	public void setObjectionRemarks(String objectionRemarks) {
		this.objectionRemarks = objectionRemarks;
	}

	/**
	 * @return the initiatedBy
	 */
	public EDPLkPoOffUserEntity getInitiatedBy() {
		return initiatedBy;
	}

	/**
	 * @param initiatedBy the initiatedBy to set
	 */
	public void setInitiatedBy(EDPLkPoOffUserEntity initiatedBy) {
		this.initiatedBy = initiatedBy;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(EDPMsOfficeEntity officeId) {
		this.officeId = officeId;
	}

	/**
	 * Instantiates a new EDP designation itr entity.
	 */
	public EDPDesignationItrEntity() {
		super();
	}

	/**
	 * Instantiates a new EDP designation itr entity.
	 *
	 * @param designationId the designation id
	 */
	public EDPDesignationItrEntity(long designationId) {
		super();
		this.designationId = designationId;
	}

	/**
	 * Gets the designation itr id.
	 *
	 * @return the designationItrId
	 */
	public Long getDesignationItrId() {
		return designationItrId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(designationCode, designationCodeGuj, designationDescription, designationDescriptionGuj,
				designationId, designationItrId, designationName, designationNameGuj, designationShortName,
				designationShortNameGuj, hasObjection, initiatedBy, objectionRemarks, officeId, parentDesignationId,
				statusId, trnNo, wfInRequest);
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
		EDPDesignationItrEntity other = (EDPDesignationItrEntity) obj;
		return Objects.equals(designationCode, other.designationCode)
				&& Objects.equals(designationCodeGuj, other.designationCodeGuj)
				&& Objects.equals(designationDescription, other.designationDescription)
				&& Objects.equals(designationDescriptionGuj, other.designationDescriptionGuj)
				&& Objects.equals(designationId, other.designationId)
				&& Objects.equals(designationItrId, other.designationItrId)
				&& Objects.equals(designationName, other.designationName)
				&& Objects.equals(designationNameGuj, other.designationNameGuj)
				&& Objects.equals(designationShortName, other.designationShortName)
				&& Objects.equals(designationShortNameGuj, other.designationShortNameGuj)
				&& Objects.equals(hasObjection, other.hasObjection) && Objects.equals(initiatedBy, other.initiatedBy)
				&& Objects.equals(objectionRemarks, other.objectionRemarks) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(parentDesignationId, other.parentDesignationId)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(trnNo, other.trnNo)
				&& Objects.equals(wfInRequest, other.wfInRequest);
	}

	/**
	 * Sets the designation itr id.
	 *
	 * @param designationItrId the designationItrId to set
	 */
	public void setDesignationItrId(Long designationItrId) {
		this.designationItrId = designationItrId;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designationId
	 */
	public Long getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	/**
	 * Gets the designation name.
	 *
	 * @return the designationName
	 */
	public String getDesignationName() {
		return designationName;
	}

	/**
	 * Sets the designation name.
	 *
	 * @param designationName the designationName to set
	 */
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	/**
	 * Gets the designation name guj.
	 *
	 * @return the designationNameGuj
	 */
	public String getDesignationNameGuj() {
		return designationNameGuj;
	}

	/**
	 * Sets the designation name guj.
	 *
	 * @param designationNameGuj the designationNameGuj to set
	 */
	public void setDesignationNameGuj(String designationNameGuj) {
		this.designationNameGuj = designationNameGuj;
	}

	/**
	 * Gets the designation description.
	 *
	 * @return the designationDescription
	 */
	public String getDesignationDescription() {
		return designationDescription;
	}

	/**
	 * Sets the designation description.
	 *
	 * @param designationDescription the designationDescription to set
	 */
	public void setDesignationDescription(String designationDescription) {
		this.designationDescription = designationDescription;
	}

	/**
	 * Gets the designation description guj.
	 *
	 * @return the designationDescriptionGuj
	 */
	public String getDesignationDescriptionGuj() {
		return designationDescriptionGuj;
	}

	/**
	 * Sets the designation description guj.
	 *
	 * @param designationDescriptionGuj the designationDescriptionGuj to set
	 */
	public void setDesignationDescriptionGuj(String designationDescriptionGuj) {
		this.designationDescriptionGuj = designationDescriptionGuj;
	}

	/**
	 * Gets the designation short name.
	 *
	 * @return the designationShortName
	 */
	public String getDesignationShortName() {
		return designationShortName;
	}

	/**
	 * Sets the designation short name.
	 *
	 * @param designationShortName the designationShortName to set
	 */
	public void setDesignationShortName(String designationShortName) {
		this.designationShortName = designationShortName;
	}

	/**
	 * Gets the designation short name guj.
	 *
	 * @return the designationShortNameGuj
	 */
	public String getDesignationShortNameGuj() {
		return designationShortNameGuj;
	}

	/**
	 * Sets the designation short name guj.
	 *
	 * @param designationShortNameGuj the designationShortNameGuj to set
	 */
	public void setDesignationShortNameGuj(String designationShortNameGuj) {
		this.designationShortNameGuj = designationShortNameGuj;
	}

	/**
	 * Gets the designation code.
	 *
	 * @return the designationCode
	 */
	public String getDesignationCode() {
		return designationCode;
	}

	/**
	 * Sets the designation code.
	 *
	 * @param designationCode the designationCode to set
	 */
	public void setDesignationCode(String designationCode) {
		this.designationCode = designationCode;
	}

	/**
	 * Gets the designation code guj.
	 *
	 * @return the designationCodeGuj
	 */
	public String getDesignationCodeGuj() {
		return designationCodeGuj;
	}

	/**
	 * Sets the designation code guj.
	 *
	 * @param designationCodeGuj the designationCodeGuj to set
	 */
	public void setDesignationCodeGuj(String designationCodeGuj) {
		this.designationCodeGuj = designationCodeGuj;
	}

	/**
	 * Gets the parent designation id.
	 *
	 * @return the parentDesignationId
	 */
	public Long getParentDesignationId() {
		return parentDesignationId;
	}

	/**
	 * Sets the parent designation id.
	 *
	 * @param parentDesignationId the parentDesignationId to set
	 */
	public void setParentDesignationId(Long parentDesignationId) {
		this.parentDesignationId = parentDesignationId;
	}

	/**
	 * Gets the trn no.
	 *
	 * @return the trnNo
	 */
	public Long getTrnNo() {
		return trnNo;
	}

	/**
	 * Sets the trn no.
	 *
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(Long trnNo) {
		this.trnNo = trnNo;
	}

}
