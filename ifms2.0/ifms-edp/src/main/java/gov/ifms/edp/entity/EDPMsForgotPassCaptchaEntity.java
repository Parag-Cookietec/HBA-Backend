package gov.ifms.edp.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.oauth.util.OAuthUtility;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The Class EDPMsForgotPassCaptchaEntity.
 * 
 * @version 1.0
 * @created 2021/01/16 14:30:45
 *
 */
@Entity
@Table(name = "MS_FORGOT_PASS_CAPTCHA", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsForgotPassCaptchaEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAPTCHA_ID")
	private Long captchaId;

	@Column(name = "CAPTCHA")
	private String captcha;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	public EDPMsForgotPassCaptchaEntity() {
	}

	public EDPMsForgotPassCaptchaEntity(String captcha) {
		this.captcha = captcha;
	}

	public Long getCaptchaId() {
		return captchaId;
	}

	public void setCaptchaId(Long captchaId) {
		this.captchaId = captchaId;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EDPMsForgotPassCaptchaEntity that = (EDPMsForgotPassCaptchaEntity) o;
		return Objects.equals(captchaId, that.captchaId) &&
				Objects.equals(captcha, that.captcha) &&
				Objects.equals(createdDate, that.createdDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(captchaId, captcha, createdDate);
	}

	/**
	 * Before create.
	 */
	@PrePersist
	private void beforeCreate() {
		this.createdDate = new Date();
	}

}
