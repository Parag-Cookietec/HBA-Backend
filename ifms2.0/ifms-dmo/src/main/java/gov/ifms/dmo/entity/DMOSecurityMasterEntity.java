package gov.ifms.dmo.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "MDMO_SECURITY_MST", schema = Constant.DMO_SCHEMA)
public class DMOSecurityMasterEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SECURTIY_ID")
	private Long id;

	@Column(name = "SECURITY_NAME")
	private String securityName;

	@Column(name = "EFFECTIVE_FRM_DT")
	private LocalDate effectiveFrmDt;

	@Column(name = "EFFECTIVE_TO_DT")
	private LocalDate effectiveToDt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}

	public LocalDate getEffectiveFrmDt() {
		return effectiveFrmDt;
	}

	public void setEffectiveFrmDt(LocalDate effectiveFrmDt) {
		this.effectiveFrmDt = effectiveFrmDt;
	}

	public LocalDate getEffectiveToDt() {
		return effectiveToDt;
	}

	public void setEffectiveToDt(LocalDate effectiveToDt) {
		this.effectiveToDt = effectiveToDt;
	}
}
