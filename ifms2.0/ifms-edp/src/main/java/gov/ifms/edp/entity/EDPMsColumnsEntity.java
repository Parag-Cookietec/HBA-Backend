package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPMsColumnsEntity.
 */
@Entity
@Table(name = "MS_COLUMNS", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsColumnsEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The column id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COLUMN_ID")
	private long columnId;

	/** The column name. */
	@Column(name = "COLUMN_NAME")
	private String columnName;

	/** The column description. */
	@Column(name = "COLUMN_DESCRIPTION")
	private String columnDescription;

	/** The column table id. */
	@Column(name = "COLUMN_TABLE_ID")
	private int columnTableId;

	/**
	 * Gets the column id.
	 *
	 * @return the column id
	 */
	public long getColumnId() {
		return columnId;
	}

	/**
	 * Sets the column id.
	 *
	 * @param columnId the new column id
	 */
	public void setColumnId(long columnId) {
		this.columnId = columnId;
	}

	/**
	 * Gets the column name.
	 *
	 * @return the column name
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * Sets the column name.
	 *
	 * @param columnName the new column name
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * Gets the column description.
	 *
	 * @return the column description
	 */
	public String getColumnDescription() {
		return columnDescription;
	}

	/**
	 * Sets the column description.
	 *
	 * @param columnDescription the new column description
	 */
	public void setColumnDescription(String columnDescription) {
		this.columnDescription = columnDescription;
	}

	/**
	 * Gets the column table id.
	 *
	 * @return the column table id
	 */
	public int getColumnTableId() {
		return columnTableId;
	}

	/**
	 * Sets the column table id.
	 *
	 * @param columnTableId the new column table id
	 */
	public void setColumnTableId(int columnTableId) {
		this.columnTableId = columnTableId;
	}

	/**
	 * Instantiates a new EDP ms columns entity.
	 */
	public EDPMsColumnsEntity() {
		super();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(columnDescription, columnId, columnName, columnTableId);
	}

	/**
	 * Equals.
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
		if (!(obj instanceof EDPMsColumnsEntity)) {
			return false;
		}
		EDPMsColumnsEntity other = (EDPMsColumnsEntity) obj;
		return Objects.equals(columnDescription, other.columnDescription) && columnId == other.columnId
				&& Objects.equals(columnName, other.columnName) && columnTableId == other.columnTableId;
	}

}
