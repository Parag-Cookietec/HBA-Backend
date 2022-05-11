package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The Class EDPTedpBrDtlDto.
 */
public class EDPSignInMsgDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long signInMsgId;

	private String signInMsg;

	private String signInMsgGuj;

	private Integer enableMsgDspl;

	private Integer activeStatus;

	public EDPSignInMsgDto() {
	}

	public Long getSignInMsgId() {
		return signInMsgId;
	}

	public void setSignInMsgId(Long signInMsgId) {
		this.signInMsgId = signInMsgId;
	}

	public String getSignInMsg() {
		return signInMsg;
	}

	public void setSignInMsg(String signInMsg) {
		this.signInMsg = signInMsg;
	}

	public String getSignInMsgGuj() {
		return signInMsgGuj;
	}

	public void setSignInMsgGuj(String signInMsgGuj) {
		this.signInMsgGuj = signInMsgGuj;
	}

	public Integer getEnableMsgDspl() {
		return enableMsgDspl;
	}

	public void setEnableMsgDspl(Integer enableMsgDspl) {
		this.enableMsgDspl = enableMsgDspl;
	}

	public Integer getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EDPSignInMsgDto that = (EDPSignInMsgDto) o;
		return Objects.equals(signInMsgId, that.signInMsgId) &&
				Objects.equals(signInMsg, that.signInMsg) &&
				Objects.equals(signInMsgGuj, that.signInMsgGuj) &&
				Objects.equals(enableMsgDspl, that.enableMsgDspl) &&
				Objects.equals(activeStatus, that.activeStatus);
	}

	@Override
	public int hashCode() {
		return Objects.hash(signInMsgId, signInMsg, signInMsgGuj, enableMsgDspl, activeStatus);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("EDPSignInMsgDto{");
		sb.append("signInMsgId=").append(signInMsgId);
		sb.append(", signInMsg='").append(signInMsg).append('\'');
		sb.append(", signInMsgGuj='").append(signInMsgGuj).append('\'');
		sb.append(", enableMsgDspl=").append(enableMsgDspl);
		sb.append(", activeStatus=").append(activeStatus);
		sb.append('}');
		return sb.toString();
	}
}
