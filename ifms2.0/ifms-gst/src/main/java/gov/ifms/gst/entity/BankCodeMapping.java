package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TPAO_TEMP_BANK_CODE_MAPP", schema = GSTConstant.GST_SCHEMA)
public class BankCodeMapping extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEMP_BANK_CODE_MAPP_ID")
	private Long id;

	@Column(name = "BANK_SHORT_CODE")
	private String bankShortCode;

	@Column(name = "MS_BANK_ID")
	private Long msBankId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBankShortCode() {
		return bankShortCode;
	}

	public void setBankShortCode(String bankShortCode) {
		this.bankShortCode = bankShortCode;
	}

	public Long getMsBankId() {
		return msBankId;
	}

	public void setMsBankId(Long msBankId) {
		this.msBankId = msBankId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
