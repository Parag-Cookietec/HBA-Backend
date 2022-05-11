package gov.ifms.workflow.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class MsWorkflowRoleDto.
 * 
 * @version 1.0
 * @created 2019/08/31 12:19:02
 *
 */
public class MsWorkflowRoleDto extends BaseDto implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	private long wfRoleId;

	private String wfRoleName;

	private String wfRoleNameGuj;

	private String wfRoleDescription;

	private String wfRoleDescriptionGuj;

	private Long parentWfRoleId;

	/**
	 * @return the wfRoleId
	 */
	public long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * @return the wfRoleName
	 */
	public String getWfRoleName() {
		return wfRoleName;
	}

	/**
	 * @param wfRoleName the wfRoleName to set
	 */
	public void setWfRoleName(String wfRoleName) {
		this.wfRoleName = wfRoleName;
	}

	/**
	 * @return the wfRoleNameGuj
	 */
	public String getWfRoleNameGuj() {
		return wfRoleNameGuj;
	}

	/**
	 * @param wfRoleNameGuj the wfRoleNameGuj to set
	 */
	public void setWfRoleNameGuj(String wfRoleNameGuj) {
		this.wfRoleNameGuj = wfRoleNameGuj;
	}

	/**
	 * @return the wfRoleDescription
	 */
	public String getWfRoleDescription() {
		return wfRoleDescription;
	}

	/**
	 * @param wfRoleDescription the wfRoleDescription to set
	 */
	public void setWfRoleDescription(String wfRoleDescription) {
		this.wfRoleDescription = wfRoleDescription;
	}

	/**
	 * @return the wfRoleDescriptionGuj
	 */
	public String getWfRoleDescriptionGuj() {
		return wfRoleDescriptionGuj;
	}

	/**
	 * @param wfRoleDescriptionGuj the wfRoleDescriptionGuj to set
	 */
	public void setWfRoleDescriptionGuj(String wfRoleDescriptionGuj) {
		this.wfRoleDescriptionGuj = wfRoleDescriptionGuj;
	}

	/**
	 * @return the parentWfRoleId
	 */
	public Long getParentWfRoleId() {
		return parentWfRoleId;
	}

	/**
	 * @param parentWfRoleId the parentWfRoleId to set
	 */
	public void setParentWfRoleId(Long parentWfRoleId) {
		this.parentWfRoleId = parentWfRoleId;
	}

	public MsWorkflowRoleDto() {
		super();
	}
	
	public MsWorkflowRoleDto(long wfRoleId) {
		super();
		this.wfRoleId = wfRoleId;
	}

	public MsWorkflowRoleDto(int wfRoleId, String wfRoleName, String wfRoleNameGuj, String wfRoleDescription,
			String wfRoleDescriptionGuj, Long parentWfRoleId) {
		super();
		this.wfRoleId = wfRoleId;
		this.wfRoleName = wfRoleName;
		this.wfRoleNameGuj = wfRoleNameGuj;
		this.wfRoleDescription = wfRoleDescription;
		this.wfRoleDescriptionGuj = wfRoleDescriptionGuj;
		this.parentWfRoleId = parentWfRoleId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(parentWfRoleId, wfRoleDescription, wfRoleDescriptionGuj, wfRoleId, wfRoleName,
				wfRoleNameGuj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MsWorkflowRoleDto)) {
			return false;
		}
		MsWorkflowRoleDto other = (MsWorkflowRoleDto) obj;
		return Objects.equals(parentWfRoleId, other.parentWfRoleId)
				&& Objects.equals(wfRoleDescription, other.wfRoleDescription)
				&& Objects.equals(wfRoleDescriptionGuj, other.wfRoleDescriptionGuj) && wfRoleId == other.wfRoleId
				&& Objects.equals(wfRoleName, other.wfRoleName) && Objects.equals(wfRoleNameGuj, other.wfRoleNameGuj);
	}

	@Override
	public String toString() {
		return String.format(
				"MsWorkflowRoleDto [wfRoleId=%s, wfRoleName=%s, wfRoleNameGuj=%s, wfRoleDescription=%s, wfRoleDescriptionGuj=%s, parentWfRoleId=%s]",
				wfRoleId, wfRoleName, wfRoleNameGuj, wfRoleDescription, wfRoleDescriptionGuj, parentWfRoleId);
	}
	
}
