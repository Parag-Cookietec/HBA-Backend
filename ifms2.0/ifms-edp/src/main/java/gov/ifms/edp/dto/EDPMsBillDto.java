package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPMsBillDto.
 * 
 * @version 1.0
 * @created 2020/01/29 17:03:45
 *
 */
public class EDPMsBillDto extends BaseDto implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	private Long billId;

	private String billName;

	private String billNameGuj;

	private String billCode;

	private String billCodeGuj;

	private String billCodeName;

	private String billDesc;

	private String billDescGuj;

	private Long billTypeId;

	private Long parentBillId;

	/**
	 * EDPMsBillDto Constructor
	 */
	public EDPMsBillDto() {
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
		if (!(obj instanceof EDPMsBillDto)) {
			return false;
		}

		EDPMsBillDto other = (EDPMsBillDto) obj;

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
	 * @return the billTypeId
	 */
	public Long getBillTypeId() {
		return billTypeId;
	}

	/**
	 * @param billTypeId the billTypeId to set
	 */
	public void setBillTypeId(Long billTypeId) {
		this.billTypeId = billTypeId;
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

}
