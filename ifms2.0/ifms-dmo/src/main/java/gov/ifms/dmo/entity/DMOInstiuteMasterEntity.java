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
public class DMOInstiuteMasterEntity extends BaseEntity implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INSTITUTE_ID")
	private long id;
	
	@Column(name = "INSTITUTE_NAME")
	private String instituteName;
	
	@Column(name = "EFFECTIVE_FRM_DT")
	private LocalDate effectiveFrmDt;
	
	@Column(name = "EFFECTIVE_TO_DT")
	private LocalDate effectiveToDt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
