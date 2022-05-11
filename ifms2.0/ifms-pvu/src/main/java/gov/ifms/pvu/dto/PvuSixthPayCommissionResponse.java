package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;
import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class PvuCommonRequest.
 */
public class PvuSixthPayCommissionResponse implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NativeQueryResultColumn(index = 0)
	private String payScaleId;
	
	@NativeQueryResultColumn(index = 1)
	private String payScalName;

	/**
	 * @return the payScalName
	 */
	public String getPayScalName() {
		return payScalName;
	}

	/**
	 * @param payScalName the payScalName to set
	 */
	public void setPayScalName(String payScalName) {
		this.payScalName = payScalName;
	}

	/**
	 * @return the payScaleId
	 */
	public String getPayScaleId() {
		return payScaleId;
	}

	/**
	 * @param payScaleId the payScaleId to set
	 */
	public void setPayScaleId(String payScaleId) {
		this.payScaleId = payScaleId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(payScalName, payScaleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PvuSixthPayCommissionResponse other = (PvuSixthPayCommissionResponse) obj;
		return Objects.equals(payScalName, other.payScalName) && Objects.equals(payScaleId, other.payScaleId);
	}

	
	

	
	
	
	
	
}
