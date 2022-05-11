package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeShettyPayDto.
 *
 * @version v 1.0
 * @created 2020/01/06 12:53:37
 *
 */
/**
 * @author HP
 *
 */
public class PVUEmployeeSelectionGradeAuditViewDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private PVUEmployeePostDetailDto postDetails;

	private PVUEmployeeCurrentDetailDto currentDetails;

	/**
	 * @return the currentDetails
	 */
	public PVUEmployeeCurrentDetailDto getCurrentDetails() {
		return currentDetails;
	}

	/**
	 * @return the postDetails
	 */
	public PVUEmployeePostDetailDto getPostDetails() {
		return postDetails;
	}

	/**
	 * @param postDetails the postDetails to set
	 */
	public void setPostDetails(PVUEmployeePostDetailDto postDetails) {
		this.postDetails = postDetails;
	}

	/**
	 * @param currentDetails the currentDetails to set
	 */
	public void setCurrentDetails(PVUEmployeeCurrentDetailDto currentDetails) {
		this.currentDetails = currentDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((currentDetails == null) ? 0 : currentDetails.hashCode());
		result = prime * result + ((postDetails == null) ? 0 : postDetails.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof PVUEmployeeSelectionGradeAuditViewDto)) {
			return false;
		}
		PVUEmployeeSelectionGradeAuditViewDto other = (PVUEmployeeSelectionGradeAuditViewDto) obj;
		if (currentDetails == null) {
			if (other.currentDetails != null) {
				return false;
			}
		} else if (!currentDetails.equals(other.currentDetails)) {
			return false;
		}
		if (postDetails == null) {
			if (other.postDetails != null) {
				return false;
			}
		} else if (!postDetails.equals(other.postDetails)) {
			return false;
		}
		return true;
	}
	
	
}
