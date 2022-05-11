package gov.ifms.dmo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "TDMO_GRF_CRF_SECURITY_DTL", schema = Constant.DMO_SCHEMA)
public class DMOGRFCRFSecurityDtlEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEC_SALE_DTL_ID")
	private Long id;

	@Column(name = "GRF_CRF_SEC_SALE_ID")
	private Long grfCrfSecSaleId;

	@Column(name = "SEC_SALE_ID")
	private Long secSaleId;

	/** The is SECURITY_TYPE_ID. */
	@Column(name = "SECURITY_TYPE_ID")
	private Long securityTypeId;

	/** The is CURR_FACE_VALUE. */
	@Column(name = "CURR_FACE_VALUE")
	private Double currFaceValue;

	/** The is FACE_VAL_SEC_SOLD. */
	@Column(name = "FACE_VAL_SEC_SOLD")
	private Double faceValSecSold;

	/** The is UNITS_SOLD_NO. */
	@Column(name = "UNITS_SOLD_NO")
	private Long unitsSoldNo;

	/** The is SALES_PRICE. */
	@Column(name = "SALES_PRICE")
	private Double salesPrice;

	/** The is SALE_SEC_RELZD_AMT. */
	@Column(name = "SALE_SEC_RELZD_AMT")
	private Double saleSecRelzdAmt;

	/** The is BROKEN_DAYS. */
	@Column(name = "BROKEN_DAYS")
	private Integer brokenDays;

	/** The is ACCR_INTRST_RECV. */
	@Column(name = "ACCR_INTRST_RECV")
	private Double accrIntrstRecv;

	/** The is TOTAL_RELZD_AMT. */
	@Column(name = "TOTAL_RELZD_AMT")
	private Double totalRelzdAmt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GRF_CRF_SEC_SALE_ID", referencedColumnName = "GRF_CRF_SEC_SALE_ID", insertable = false, updatable = false)
	DMOGRFCRFSecuritySaleEntity securitySale;

	public DMOGRFCRFSecuritySaleEntity getSecuritySale() {
		return securitySale;
	}

	public void setSecuritySale(DMOGRFCRFSecuritySaleEntity securitySale) {
		this.securitySale = securitySale;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGrfCrfSecSaleId() {
		return grfCrfSecSaleId;
	}

	public void setGrfCrfSecSaleId(Long grfCrfSecSaleId) {
		this.grfCrfSecSaleId = grfCrfSecSaleId;
	}

	public Long getSecSaleId() {
		return secSaleId;
	}

	public void setSecSaleId(Long secSaleId) {
		this.secSaleId = secSaleId;
	}

	public Long getSecurityTypeId() {
		return securityTypeId;
	}

	public void setSecurityTypeId(Long securityTypeId) {
		this.securityTypeId = securityTypeId;
	}

	public Double getCurrFaceValue() {
		return currFaceValue;
	}

	public void setCurrFaceValue(Double currFaceValue) {
		this.currFaceValue = currFaceValue;
	}

	public Double getFaceValSecSold() {
		return faceValSecSold;
	}

	public void setFaceValSecSold(Double faceValSecSold) {
		this.faceValSecSold = faceValSecSold;
	}

	public Long getUnitsSoldNo() {
		return unitsSoldNo;
	}

	public void setUnitsSoldNo(Long unitsSoldNo) {
		this.unitsSoldNo = unitsSoldNo;
	}

	public Double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(Double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public Double getSaleSecRelzdAmt() {
		return saleSecRelzdAmt;
	}

	public void setSaleSecRelzdAmt(Double saleSecRelzdAmt) {
		this.saleSecRelzdAmt = saleSecRelzdAmt;
	}

	public Integer getBrokenDays() {
		return brokenDays;
	}

	public void setBrokenDays(Integer brokenDays) {
		this.brokenDays = brokenDays;
	}

	public Double getAccrIntrstRecv() {
		return accrIntrstRecv;
	}

	public void setAccrIntrstRecv(Double accrIntrstRecv) {
		this.accrIntrstRecv = accrIntrstRecv;
	}

	public Double getTotalRelzdAmt() {
		return totalRelzdAmt;
	}

	public void setTotalRelzdAmt(Double totalRelzdAmt) {
		this.totalRelzdAmt = totalRelzdAmt;
	}

}
