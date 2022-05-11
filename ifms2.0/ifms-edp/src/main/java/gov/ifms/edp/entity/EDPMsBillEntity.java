package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

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

/**
 * The Class EDPMsBillEntity.
 * 
 * @version 1.0
 * @created 2020/01/29 17:03:45
 *
 */
@Entity
@Table(name = "MS_BILL", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsBillEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BILL_ID")
	private Long billId;

	@Column(name = "BILL_NAME")
	private String billName;

	@Column(name = "BILL_NAME_GUJ")
	private String billNameGuj;

	@Column(name = "BILL_CODE")
	private String billCode;

	@Column(name = "BILL_CODE_GUJ")
	private String billCodeGuj;

	@Column(name = "BILL_CODE_NAME")
	private String billCodeName;

	@Column(name = "BILL_DESC")
	private String billDesc;

	@Column(name = "BILL_DESC_GUJ")
	private String billDescGuj;

	@Column(name = "PARENT_BILL_ID")
	private Long parentBillId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BILL_TYPE_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity billTypeId;

	/**
	 * EDPMsBillDto Constructor
	 */
	public EDPMsBillEntity() {
		super();
	}

	/**
	 * hascode method
	 */
	@Override
	public int hashCode() {
		return Objects.hash(billId, billName, billNameGuj, billCode, billCodeGuj, billCodeName, billDesc, billDescGuj,
				billTypeId, parentBillId);
	}

	/**
	 * equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPMsBillEntity)) {
			return false;
		}

		EDPMsBillEntity other = (EDPMsBillEntity) obj;

		return Objects.equals(billId, other.billId) && Objects.equals(billName, other.billName)
				&& Objects.equals(billNameGuj, other.billNameGuj) && Objects.equals(billCode, other.billCode)
				&& Objects.equals(billCodeGuj, other.billCodeGuj) && Objects.equals(billCodeName, other.billCodeName)
				&& Objects.equals(billDesc, other.billDesc) && Objects.equals(billDescGuj, other.billDescGuj)
				&& Objects.equals(billTypeId, other.billTypeId) && Objects.equals(parentBillId, other.parentBillId);
	}

	/**
	 * getter setter
	 */

	/**
	 * @return the billId
	 */
	public Long getBillId() {
		return billId;
	}

	/**
	 * @param billId the billId to set
	 */
	public void setBillId(Long billId) {
		this.billId = billId;
	}

	/**
	 * @return the billName
	 */
	public String getBillName() {
		return billName;
	}

	/**
	 * @param billName the billName to set
	 */
	public void setBillName(String billName) {
		this.billName = billName;
	}

	/**
	 * @return the billNameGuj
	 */
	public String getBillNameGuj() {
		return billNameGuj;
	}

	/**
	 * @param billNameGuj the billNameGuj to set
	 */
	public void setBillNameGuj(String billNameGuj) {
		this.billNameGuj = billNameGuj;
	}

	/**
	 * @return the billCode
	 */
	public String getBillCode() {
		return billCode;
	}

	/**
	 * @param billCode the billCode to set
	 */
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	/**
	 * @return the billCodeGuj
	 */
	public String getBillCodeGuj() {
		return billCodeGuj;
	}

	/**
	 * @param billCodeGuj the billCodeGuj to set
	 */
	public void setBillCodeGuj(String billCodeGuj) {
		this.billCodeGuj = billCodeGuj;
	}

	/**
	 * @return the billCodeName
	 */
	public String getBillCodeName() {
		return billCodeName;
	}

	/**
	 * @param billCodeName the billCodeName to set
	 */
	public void setBillCodeName(String billCodeName) {
		this.billCodeName = billCodeName;
	}

	/**
	 * @return the billDesc
	 */
	public String getBillDesc() {
		return billDesc;
	}

	/**
	 * @param billDesc the billDesc to set
	 */
	public void setBillDesc(String billDesc) {
		this.billDesc = billDesc;
	}

	/**
	 * @return the billDescGuj
	 */
	public String getBillDescGuj() {
		return billDescGuj;
	}

	/**
	 * @param billDescGuj the billDescGuj to set
	 */
	public void setBillDescGuj(String billDescGuj) {
		this.billDescGuj = billDescGuj;
	}

	/**
	 * @return the parentBillId
	 */
	public Long getParentBillId() {
		return parentBillId;
	}

	/**
	 * @param parentBillId the parentBillId to set
	 */
	public void setParentBillId(Long parentBillId) {
		this.parentBillId = parentBillId;
	}

	/**
	 * @return the billTypeId
	 */
	public EDPLuLookUpInfoEntity getBillTypeId() {
		return billTypeId;
	}

	/**
	 * @param billTypeId the billTypeId to set
	 */
	public void setBillTypeId(EDPLuLookUpInfoEntity billTypeId) {
		this.billTypeId = billTypeId;
	}
	
}
