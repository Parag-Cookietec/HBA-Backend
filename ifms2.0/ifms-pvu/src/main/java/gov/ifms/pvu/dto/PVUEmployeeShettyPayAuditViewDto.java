package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

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
public class PVUEmployeeShettyPayAuditViewDto extends BaseDto implements Serializable {

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
		result = prime * result + Objects.hash(currentDetails, postDetails);
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
		if (!(obj instanceof PVUEmployeeShettyPayAuditViewDto)) {
			return false;
		}
		PVUEmployeeShettyPayAuditViewDto other = (PVUEmployeeShettyPayAuditViewDto) obj;
		return Objects.equals(currentDetails, other.currentDetails) && Objects.equals(postDetails, other.postDetails);
	}

}
