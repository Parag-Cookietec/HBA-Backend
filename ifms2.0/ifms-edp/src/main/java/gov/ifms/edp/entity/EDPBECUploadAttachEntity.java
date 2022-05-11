package gov.ifms.edp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "TEDP_BEC_ATT", schema = Constant.EDP_SCHEMA)
public class EDPBECUploadAttachEntity extends EDPBaseAttachmentEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRN_ATTACH_ID")
	private Long id;

	/** The trn id. */
	@Column(name = "TRN_ID")
	private Long trnId;

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
	 * BudgetAgUploadAttachDto Constructor.
	 */
	public EDPBECUploadAttachEntity() {
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
	 * Gets the trn id.
	 *
	 * @return the trn id
	 */
	public Long getTrnId() {
		return trnId;
	}

	/**
	 * Sets the trn id.
	 *
	 * @param trnId the new trn id
	 */
	public void setTrnId(Long trnId) {
		this.trnId = trnId;
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