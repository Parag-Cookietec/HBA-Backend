package gov.ifms.loc.entity;

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

import gov.ifms.loc.util.LocConstant;

/**
 * The Class BudgetSubHeadAttachEntity.
 * 
 * @version 1.0
 * @created 2020/09/09 09:12:26
 *
 */
@Entity
@Table(name = "TLOC_LC_OPEN_REQ_ATT", schema = LocConstant.LOC_SCHEMA)
public class LocAccountOpenReqAttEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRN_ATTACH_ID")
	private Long id;

	/** The sub head hdr id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRN_ID", referencedColumnName = "LC_OPEN_REQ_HDR_ID")
	private LocAccountOpenReqHdrEntity subHeadHdrId;

	/** The document id. */
	@Column(name = "DOCUMENT_ID")
	private String documentId;
	
	/** The category. */
	@Column(name = "CATEGORY")
	private Long category;
	
	/** The wf id. */
	@Column(name = "WF_ID")
	private Long wfId;
	
	/** The wf role id. */
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;

	/**
	 * BudgetSubHeadAttachDto Constructor.
	 */
	public LocAccountOpenReqAttEntity() {
		super();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the sub head hdr id.
	 *
	 * @return the sub head hdr id
	 */
	public LocAccountOpenReqHdrEntity getSubHeadHdrId() {
		return subHeadHdrId;
	}

	/**
	 * Sets the sub head hdr id.
	 *
	 * @param subHeadHdrId the new sub head hdr id
	 */
	public void setSubHeadHdrId(LocAccountOpenReqHdrEntity subHeadHdrId) {
		this.subHeadHdrId = subHeadHdrId;
	}

	/**
	 * Gets the document id.
	 *
	 * @return the document id
	 */
	public String getDocumentId() {
		return documentId;
	}

	/**
	 * Sets the document id.
	 *
	 * @param documentId the new document id
	 */
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public Long getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(Long category) {
		this.category = category;
	}

	/**
	 * Gets the wf id.
	 *
	 * @return the wf id
	 */
	public Long getWfId() {
		return wfId;
	}

	/**
	 * Sets the wf id.
	 *
	 * @param wfId the new wf id
	 */
	public void setWfId(Long wfId) {
		this.wfId = wfId;
	}

	/**
	 * Gets the wf role id.
	 *
	 * @return the wf role id
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * Sets the wf role id.
	 *
	 * @param wfRoleId the new wf role id
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

}
