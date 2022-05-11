package gov.ifms.pvu.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Class PVUMsPayCellEntity.
 *
 * @version v 1.0
 * @created 2019/12/23 17:34:36
 */
@Entity
@Table(name = "MS_PAY_CELL", schema = Constant.PVU_SCHEMA_MASTER)
public class PVUMsPayCellEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAY_CELL_ID")
	private long id;

	/** The cell id. */
	@Column(name = "CELL_ID")
	private int cellId;

	/** The pay band. */
	@ManyToOne
	@JoinColumn(name = "PAY_BAND_ID")
	private PVUMsPayBandEntity payBand;

	/** The grade pay. */
	@ManyToOne
	@JoinColumn(name = "GRADE_PAY_ID")
	private PVUMsGradePayEntity gradePay;

	/** The pay level. */
	@ManyToOne
	@JoinColumn(name = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity payLevel;

	/** The cell value. */
	@Column(name = "CELL_VALUE")
	private long cellValue;

	/**
	 * PVUMsPayCellEntity Constructor.
	 */
	public PVUMsPayCellEntity() {
		super();
	}

	/**
	 * PVUMsPayCellEntity Constructor.
	 *
	 * @param id the id
	 */
	public PVUMsPayCellEntity(long id) {
		super();
		this.id = id;
	}

	/**
	 * Gets the id.
	 *
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
	 * Gets the pay band.
	 *
	 * @return the payBandId
	 */
	public PVUMsPayBandEntity getPayBand() {
		return payBand;
	}

	/**
	 * Sets the pay band.
	 *
	 * @param payBand the payBandId to set
	 */
	public void setPayBand(PVUMsPayBandEntity payBand) {
		this.payBand = payBand;
	}

	/**
	 * Gets the grade pay.
	 *
	 * @return the gradePayId
	 */
	public PVUMsGradePayEntity getGradePay() {
		return gradePay;
	}

	/**
	 * Sets the grade pay.
	 *
	 * @param gradePay the gradePayId to set
	 */
	public void setGradePay(PVUMsGradePayEntity gradePay) {
		this.gradePay = gradePay;
	}

	/**
	 * Gets the pay level.
	 *
	 * @return the payLevelId
	 */
	public PVUMsPayLevelEntity getPayLevel() {
		return payLevel;
	}

	/**
	 * Sets the pay level.
	 *
	 * @param payLevel the payLevelId to set
	 */
	public void setPayLevel(PVUMsPayLevelEntity payLevel) {
		this.payLevel = payLevel;
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(cellId, cellValue, gradePay, id, payBand, payLevel);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVUMsPayCellEntity other = (PVUMsPayCellEntity) obj;
		return cellId == other.cellId && cellValue == other.cellValue && Objects.equals(gradePay, other.gradePay)
				&& id == other.id && Objects.equals(payBand, other.payBand) && Objects.equals(payLevel, other.payLevel);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUMsPayCellEntity [id=" + id + ", cellId=" + cellId + ", payBandId=" + payBand + ", gradePayId="
				+ gradePay + ", payLevelId=" + payLevel + ", cellValue=" + cellValue + "]";
	}

}
