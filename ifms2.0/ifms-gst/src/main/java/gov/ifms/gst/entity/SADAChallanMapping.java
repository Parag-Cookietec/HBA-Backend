package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TPAO_SA_DA_CHALLAN_MAPPING", schema = GSTConstant.GST_SCHEMA)
public class SADAChallanMapping extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SA_DA_CHALLAN_MAPPING_ID")
	private long id;

	@Column(name = "SA_DA_ID")
	private Long saDaId;

	@Column(name = "BANK_ID")
	private Long bankId;

	@Column(name = "FILE_PROCESS_ID")
	private Long fileProcessId;

	@Column(name = "RBI_FILE_TRANXN_ID")
	private Long rbiFileTranxnId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSaDaId() {
		return saDaId;
	}

	public void setSaDaId(Long saDaId) {
		this.saDaId = saDaId;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public Long getFileProcessId() {
		return fileProcessId;
	}

	public void setFileProcessId(Long fileProcessId) {
		this.fileProcessId = fileProcessId;
	}

	public Long getRbiFileTranxnId() {
		return rbiFileTranxnId;
	}

	public void setRbiFileTranxnId(Long rbiFileTranxnId) {
		this.rbiFileTranxnId = rbiFileTranxnId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
