package gov.ifms.pvu.dto;

import gov.ifms.edp.dto.BaseDto;

import java.io.Serializable;
import java.util.Objects;


/**
 * The Class PVUMsPayCellDto.
 *
 * @version v 1.0
 * @created 2019/12/23 17:34:36
 */
public class PVUMsPayCellDto extends BaseDto implements Serializable {

    /** The serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    private long id;

    /** The cell id. */
    private int cellId;

    /** The pay band id. */
    private long payBandId;

    /** The grade pay id. */
    private long gradePayId;

    /** The pay level id. */
    private long payLevelId;

    /** The cell value. */
    private long cellValue;

    /** The personal Pay. */
    private long personalPay;



    /**
     * PVUMsPayCellDto Constructor.
     */
    public PVUMsPayCellDto() {
        super();
    }

    /**
     * hascode method.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, cellId, payBandId, gradePayId, payLevelId, cellValue, personalPay);
    }

    /**
     * equals method.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof PVUMsPayCellDto)) {
            return false;
        }

        PVUMsPayCellDto other = (PVUMsPayCellDto) obj;

        return id == other.id
                && cellId == other.cellId
                && payBandId == other.payBandId
                && gradePayId == other.gradePayId
                && payLevelId == other.payLevelId
                && cellValue == other.cellValue
                && personalPay == other.personalPay
                ;
    }

    /**
     * toString method.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "PVUMsPayCellDto [id = " + id + ",cellId = " + cellId + ",payBandId = " + payBandId + ",gradePayId = " + gradePayId + ",payLevelId = " + payLevelId + ",cellValue = " + cellValue + ",personalPay = " + personalPay + "]";
    }

    /**
     * getter setter.
     *
     * @return the id
     */

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the cell id.
     *
     * @return the cellId
     */
    public int getCellId() {
        return cellId;
    }

    /**
     * Sets the cell id.
     *
     * @param cellId the cellId to set
     */
    public void setCellId(int cellId) {
        this.cellId = cellId;
    }

    /**
     * Gets the pay band id.
     *
     * @return the payBandId
     */
    public long getPayBandId() {
        return payBandId;
    }

    /**
     * Sets the pay band id.
     *
     * @param payBandId the payBandId to set
     */
    public void setPayBandId(long payBandId) {
        this.payBandId = payBandId;
    }

    /**
     * Gets the grade pay id.
     *
     * @return the gradePayId
     */
    public long getGradePayId() {
        return gradePayId;
    }

    /**
     * Sets the grade pay id.
     *
     * @param gradePayId the gradePayId to set
     */
    public void setGradePayId(long gradePayId) {
        this.gradePayId = gradePayId;
    }

    /**
     * Gets the pay level id.
     *
     * @return the payLevelId
     */
    public long getPayLevelId() {
        return payLevelId;
    }

    /**
     * Sets the pay level id.
     *
     * @param payLevelId the payLevelId to set
     */
    public void setPayLevelId(long payLevelId) {
        this.payLevelId = payLevelId;
    }

    /**
     * Gets the cell value.
     *
     * @return the cellValue
     */
    public long getCellValue() {
        return cellValue;
    }

    /**
     * Sets the cell value.
     *
     * @param cellValue the cellValue to set
     */
    public void setCellValue(long cellValue) {
        this.cellValue = cellValue;
    }

	/**
	 * Gets the personal pay.
	 *
	 * @return the personalPay
	 */
	public long getPersonalPay() {
		return personalPay;
	}

	/**
	 * Sets the personal pay.
	 *
	 * @param personalPay the personalPay to set
	 */
	public void setPersonalPay(long personalPay) {
		this.personalPay = personalPay;
	}


}
