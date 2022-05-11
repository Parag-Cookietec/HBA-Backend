package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TPAO_NONRECON_ERRORS_DATA", schema = GSTConstant.GST_SCHEMA)
public class NonReconErrorData extends BaseEntity implements Serializable {

	public static final String TRN_SCREEN_NED = "NED";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NONRECON_ERROR_ID")
	private long id;

	@Column(name = "PAO_FILE_HDR_ID")
	private long paoFileHdrId;

	@Column(name = "STATE_CD")
	private short stateCd;

	@Column(name = "NER_RECON_DT")
	private Date nerReconDt;

	@Column(name = "OTHR_MODE_RECON_DT")
	private Date othrModeReconDt;

	@Column(name = "RECON_TYPE_CD")
	private String reconTypeCd;

	@Column(name = "ERROR_CD")
	private String errorCd;

	@Column(name = "CPIN_NO")
	private long cpinNo;
	
	@Column(name = "E_SCROLL_NUM")
	private long eScrollNum;

	public long getPaoFileHdrId() {
		return paoFileHdrId;
	}

	public void setPaoFileHdrId(long paoFileHdrId) {
		this.paoFileHdrId = paoFileHdrId;
	}

	public short getStateCd() {
		return stateCd;
	}

	public void setStateCd(short stateCd) {
		this.stateCd = stateCd;
	}

	public Date getNerReconDt() {
		return nerReconDt;
	}

	public void setNerReconDt(Date nerReconDt) {
		this.nerReconDt = nerReconDt;
	}

	public Date getOthrModeReconDt() {
		return othrModeReconDt;
	}

	public void setOthrModeReconDt(Date othrModeReconDt) {
		this.othrModeReconDt = othrModeReconDt;
	}

	public String getReconTypeCd() {
		return reconTypeCd;
	}

	public void setReconTypeCd(String reconTypeCd) {
		this.reconTypeCd = reconTypeCd;
	}

	public String getErrorCd() {
		return errorCd;
	}

	public void setErrorCd(String errorCd) {
		this.errorCd = errorCd;
	}

	public long getCpinNo() {
		return cpinNo;
	}

	public void setCpinNo(long cpinNo) {
		this.cpinNo = cpinNo;
	}

	public long geteScrollNum() {
		return eScrollNum;
	}

	public void seteScrollNum(long eScrollNum) {
		this.eScrollNum = eScrollNum;
	}

	public NonReconErrorData(Long id) {
		super();
		this.id = id;
	}

	public NonReconErrorData() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
