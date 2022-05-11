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
@Table(name = "MDMO_INSTITUTE_MST", schema = Constant.DMO_SCHEMA)
public class DMOInstituteMstEntity extends BaseEntity implements Serializable {
	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The INSTITUTE_ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INSTITUTE_ID")
	private Long id;

	/** The INSTITUTE_NAME. */
	@Column(name = "INSTITUTE_NAME")
	private String instituteName;

	/** The is EFFECTIVE_FRM_DT. */
	@Column(name = "EFFECTIVE_FRM_DT")
	private LocalDate effectiveFrmDt;

	/** The is EFFECTIVE_TO_DT. */
	@Column(name = "EFFECTIVE_TO_DT")
	private LocalDate effectiveToDt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
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
