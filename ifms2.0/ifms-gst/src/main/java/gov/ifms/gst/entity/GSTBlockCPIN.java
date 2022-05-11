package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

@Entity
@Table(name = "TPAO_BLOCK_CPIN", schema = GSTConstant.GST_SCHEMA)
public class GSTBlockCPIN extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String TRN_SCREEN_GBC = "BCL";
	public static final String TRN_SCREEN_BMS = "BMS";
	
	@Transient
	private Long createService;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BLOCK_CPIN_ID")
	private long id;

	@Column(name = "FILE_NAME")
	private String fileName;

	@Column(name = "CPIN_DT")
	private Date cpinDt;

	@Column(name = "CIN_NO")
	private String cinNo;

	@Column(name = "CPIN_NO")
	private Long cpinNo;

	@Column(name = "CPIN_AMOUNT")
	private Double cpinAmount;

	@Column(name = "GOVT_CREDIT_DT")
	private Date govtCreditDt;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "REFERENCE_DT")
	private LocalDateTime referenceDt;

	@Column(name = "REC_STATUS_ID")
	private long recStatusId;

	@Column(name = "REC_STATUS")
	private String recStatus;

	@Transient
	private Long menuId;

	public GSTBlockCPIN(long id) {
		super();
		this.id = id;
	}

	public GSTBlockCPIN() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getCpinDt() {
		return cpinDt;
	}

	public void setCpinDt(Date cpinDt) {
		this.cpinDt = cpinDt;
	}

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	public Long getCpinNo() {
		return cpinNo;
	}

	public void setCpinNo(Long cpinNo) {
		this.cpinNo = cpinNo;
	}

	public Double getCpinAmount() {
		return cpinAmount;
	}

	public void setCpinAmount(Double cpinAmount) {
		this.cpinAmount = cpinAmount;
	}

	public Date getGovtCreditDt() {
		return govtCreditDt;
	}

	public void setGovtCreditDt(Date govtCreditDt) {
		this.govtCreditDt = govtCreditDt;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public LocalDateTime getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(LocalDateTime referenceDt) {
		this.referenceDt = referenceDt;
	}

	public long getRecStatusId() {
		return recStatusId;
	}

	public void setRecStatusId(long recStatusId) {
		this.recStatusId = recStatusId;
	}

	public String getRecStatus() {
		return recStatus;
	}

	public void setRecStatus(String recStatus) {
		this.recStatus = recStatus;
	}

	public static String getTrnScreenGbc() {
		return TRN_SCREEN_GBC;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getCreateService() {
		return createService;
	}

	public void setCreateService(Long createService) {
		this.createService = createService;
	}	
}
