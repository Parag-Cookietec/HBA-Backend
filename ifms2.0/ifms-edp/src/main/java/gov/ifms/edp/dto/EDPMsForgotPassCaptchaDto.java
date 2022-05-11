package gov.ifms.edp.dto;


import java.io.Serializable;
import java.util.Objects;


/**
 * The Class EDPMsForgotPassCaptchaDto.
 */
public class EDPMsForgotPassCaptchaDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Long captchaId;

	private String captcha;

	private String createdDate;

	private byte[] captchaImg;

	public EDPMsForgotPassCaptchaDto() {
	}

	public EDPMsForgotPassCaptchaDto(Long captchaId, byte[] captchaImg) {
		this.captchaId = captchaId;
		this.captchaImg = captchaImg;
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

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public byte[] getCaptchaImg() {
		return captchaImg;
	}

	public void setCaptchaImg(byte[] captchaImg) {
		this.captchaImg = captchaImg;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EDPMsForgotPassCaptchaDto that = (EDPMsForgotPassCaptchaDto) o;
		return Objects.equals(captchaId, that.captchaId) &&
				Objects.equals(captcha, that.captcha) &&
				Objects.equals(createdDate, that.createdDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(captchaId, captcha, createdDate);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("EDPMsForgotPassCaptchaDto{");
		sb.append("captchaId=").append(captchaId);
		sb.append(", captcha='").append(captcha).append('\'');
		sb.append(", createdDate='").append(createdDate).append('\'');
		sb.append('}');
		return sb.toString();
	}
}