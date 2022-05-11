package gov.ifms.edp.entity;

import gov.ifms.common.util.Constant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


/**
 * EDPSignInMsgEntity
 */
@Entity
@Table(name = "SIGN_IN_MSG",schema = Constant.EDP_MASTER_SCHEMA)
public class EDPSignInMsgEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The sign in msg id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SIGN_IN_MSG_ID ")
	private Long signInMsgId;

	/** The sign In Msg. */
	@Column(name = "SIGN_IN_MSG")
	private String signInMsg;

	/** The sign In Msg Guj. */
	@Column(name = "SIGN_IN_MSG_GUJ")
	private String signInMsgGuj;

	/** The enable Msg Dspl */
	@Column(name = "ENABLE_MSG_DSPL")
	private Integer enableMsgDspl;

	/**
	 * activeStatus
	 */
	@Column(name = "ACTIVE_STATUS")
	private Integer activeStatus;

	/**
	 *
	 */
	public EDPSignInMsgEntity() {
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
		EDPSignInMsgEntity that = (EDPSignInMsgEntity) o;
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
}
