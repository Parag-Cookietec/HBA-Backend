package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * The Class EDPAddDesAttachmentEntity.
 */
@Entity
@Table(name = "MPAO_BANK_RATE_MASTER", schema = GSTConstant.GST_SCHEMA)
public class GSTBankRateMaster extends BaseEntity implements Serializable {
	
	

	public static final String TRN_SCREEN_BMS = "BMS";

	/** The designation id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BANK_RATE_ID")
	private Long id;

	/** The bankRate. */
	@Column(name = "BANK_RATE")
	private Double bankRate;

	/** The additionalRate. */
	@Column(name = "ADDITIONAL_RATE")
	private Double additionalRate;

	/** The panaltyRate. */
	@Column(name = "PENALTY_RATE")
	private Double panaltyRate;

	/** The effectiveFromDate. */
	@Column(name = "EFFECTIVE_FRM_DT")
	private LocalDate effectiveFromDate;

	/** The effectiveToDate. */
	@Column(name = "EFFECTIVE_TO_DT")
	private LocalDate effectiveToDate;

	/** The referenceNumber. */
	@Column(name = "REFERENCE_NO")
	private String referenceNumber;

	/** The referenceDate. */
	@Column(name = "REFERENCE_DT")
	private LocalDate referenceDate;

	public GSTBankRateMaster(Long id) {
		super();
		this.id = id;
	}

	public GSTBankRateMaster() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getBankRate() {
		return bankRate;
	}

	public void setBankRate(Double bankRate) {
		this.bankRate = bankRate;
	}

	public Double getAdditionalRate() {
		return additionalRate;
	}

	public void setAdditionalRate(Double additionalRate) {
		this.additionalRate = additionalRate;
	}

	public Double getPanaltyRate() {
		return panaltyRate;
	}

	public void setPanaltyRate(Double panaltyRate) {
		this.panaltyRate = panaltyRate;
	}

	public LocalDate getEffectiveFromDate() {
		return effectiveFromDate;
	}

	public void setEffectiveFromDate(LocalDate effectiveFromDate) {
		this.effectiveFromDate = effectiveFromDate;
	}

	public LocalDate getEffectiveToDate() {
		return effectiveToDate;
	}

	public void setEffectiveToDate(LocalDate effectiveToDate) {
		this.effectiveToDate = effectiveToDate;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public LocalDate getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(LocalDate referenceDate) {
		this.referenceDate = referenceDate;
	}
	
}
