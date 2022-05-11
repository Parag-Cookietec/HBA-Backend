package gov.ifms.pvu.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class PVURevisionOfPayAnnexureListView.
 *
 * @version v 1.0
 */
@NativeQueryResultEntity
public class PVURevisionOfPayAnnexureListView implements Serializable {

    private static final long serialVersionUID = 1L;
	
    @NativeQueryResultColumn(index = 0)
    private String evntDate;
    
    @NativeQueryResultColumn(index = 1)
    private String payBandValue;
    
    @NativeQueryResultColumn(index = 2)
    private String gradePayValue;
    
    @NativeQueryResultColumn(index = 3)
    private String payIn7th;

	/**
	 * Gets evnt date.
	 *
	 * @return the evnt date
	 */
	public String getEvntDate() {
		return evntDate;
	}

	/**
	 * Sets evnt date.
	 *
	 * @param evntDate the evnt date
	 */
	public void setEvntDate(String evntDate) {
		this.evntDate = evntDate;
	}

	/**
	 * Gets pay band value.
	 *
	 * @return the pay band value
	 */
	public String getPayBandValue() {
		return payBandValue;
	}

	/**
	 * Sets pay band value.
	 *
	 * @param payBandValue the pay band value
	 */
	public void setPayBandValue(String payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * Gets grade pay value.
	 *
	 * @return the grade pay value
	 */
	public String getGradePayValue() {
		return gradePayValue;
	}

	/**
	 * Sets grade pay value.
	 *
	 * @param gradePayValue the grade pay value
	 */
	public void setGradePayValue(String gradePayValue) {
		this.gradePayValue = gradePayValue;
	}

	/**
	 * Gets pay in 7 th.
	 *
	 * @return the pay in 7 th
	 */
	public String getPayIn7th() {
		return payIn7th;
	}

	/**
	 * Sets pay in 7 th.
	 *
	 * @param payIn7th the pay in 7 th
	 */
	public void setPayIn7th(String payIn7th) {
		this.payIn7th = payIn7th;
	}


	@Override
	public int hashCode() {
		return Objects.hash(evntDate, gradePayValue, payBandValue, payIn7th);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PVURevisionOfPayAnnexureListView)) {
			return false;
		}
		PVURevisionOfPayAnnexureListView other = (PVURevisionOfPayAnnexureListView) obj;
		return Objects.equals(evntDate, other.evntDate) && Objects.equals(gradePayValue, other.gradePayValue)
				&& Objects.equals(payBandValue, other.payBandValue) && Objects.equals(payIn7th, other.payIn7th);
	}

	@Override
	public String toString() {
		return "PVURevisionOfPayAnnexureListView [evntDate=" + evntDate + ", payBandValue=" + payBandValue
				+ ", gradePayValue=" + gradePayValue + ", payIn7th=" + payIn7th + "]";
	}
    
    

}
