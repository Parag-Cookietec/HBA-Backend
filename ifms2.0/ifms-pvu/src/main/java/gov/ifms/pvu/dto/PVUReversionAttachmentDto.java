package gov.ifms.pvu.dto;

import java.util.Objects;

import gov.ifms.pvu.common.BasePVUAttachmentDto;

/**
 * The Class PVUReversionAttachmentDto.
 * 
 * @version v 1.0
 * @created 2020/01/13 15:56:29
 *
 */
public class PVUReversionAttachmentDto extends BasePVUAttachmentDto {

	 /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The id.
     */

    private Long workflowId;

    private Long wfRoleId;

    private Long reversionId;

	public Long getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(Long workflowId) {
		this.workflowId = workflowId;
	}

	public Long getWfRoleId() {
		return wfRoleId;
	}
	
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	public Long getReversionId() {
		return reversionId;
	}

	public void setReversionId(Long reversionId) {
		this.reversionId = reversionId;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		if (!(obj instanceof PVUReversionAttachmentDto)) {
			return false;
		}
		PVUReversionAttachmentDto that = (PVUReversionAttachmentDto) obj;
		  return Objects.equals(getId(), that.getId()) &&
	                Objects.equals(getWorkflowId(), that.getWorkflowId()) &&
	                Objects.equals(getReversionId(), that.getReversionId()) &&
	                Objects.equals(getWfRoleId(), that.getWfRoleId());
	}

	    /**
	     * Hash code.
	     *
	     * @return the int
	     */
	    @Override
	    public int hashCode() {
	        return Objects.hash(getId(), getWorkflowId(), getWfRoleId(),getReversionId());
	    }
	
    
}
