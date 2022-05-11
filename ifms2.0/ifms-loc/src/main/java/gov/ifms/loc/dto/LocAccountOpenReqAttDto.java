package gov.ifms.loc.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * The Class BudgetSubHeadAttachDto.
 *
 * @version 1.0
 * @created 2020/09/09 09:12:26
 */
public class LocAccountOpenReqAttDto implements Serializable {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The id.
     */
	
    private Long id;

    /**
     * The sub head hdr id.
     */
    @NotNull
    private Long subHeadHdrId;

    /**
     * The document id.
     */
    private String documentId;

    /**
     * The category.
     */
    private Long category;

    /**
     * The wf id.
     */
    private Long wfId;

    /**
     * The wf role id.
     */
    private Long wfRoleId;

    /**
     * BudgetSubHeadAttachDto Constructor.
     */
    public LocAccountOpenReqAttDto() {
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
    public Long getSubHeadHdrId() {
        return subHeadHdrId;
    }

    /**
     * Sets the sub head hdr id.
     *
     * @param subHeadHdrId the new sub head hdr id
     */
    public void setSubHeadHdrId(Long subHeadHdrId) {
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
