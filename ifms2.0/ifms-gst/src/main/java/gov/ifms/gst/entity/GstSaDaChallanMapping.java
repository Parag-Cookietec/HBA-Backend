package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TPAO_SA_DA_CHALLAN_MAPPING", schema = GSTConstant.GST_SCHEMA)
public class GstSaDaChallanMapping extends BaseEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SA_DA_CHALLAN_MAPPING_ID")
	private Long id;

	@Column(name = "SA_DA_ID")
	private Long saDaId;

	@Column(name = "BANK_ID")
	private Long bankId;

	@Column(name = "FILE_PROCESS_ID")
	private Long fileProcessId;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "RBI_FILE_TRANXN_ID", referencedColumnName = "RBI_FILE_TRANXN_ID")
	private GstRbiFilesTranxn rbiFileTranxn;

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

	public GstRbiFilesTranxn getRbiFileTranxn() {
		return rbiFileTranxn;
	}

	public void setRbiFileTranxn(GstRbiFilesTranxn rbiFileTranxn) {
		this.rbiFileTranxn = rbiFileTranxn;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GstSaDaChallanMapping that = (GstSaDaChallanMapping) o;
		return Objects.equals(id, that.id) && Objects.equals(saDaId, that.saDaId) && Objects.equals(bankId, that.bankId) && Objects.equals(fileProcessId, that.fileProcessId) && Objects.equals(rbiFileTranxn, that.rbiFileTranxn);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, saDaId, bankId, fileProcessId, rbiFileTranxn);
	}
}
