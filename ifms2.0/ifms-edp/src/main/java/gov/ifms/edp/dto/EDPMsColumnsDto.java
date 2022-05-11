package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPMsColumnsDto.
 * 
 * @version 1.0
 * @created 2019/08/29 18:39:10
 *
 */
public class EDPMsColumnsDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The column id. */
	private long columnId;

	/** The column name. */
	private String columnName;

	/** The column description. */
	private String columnDescription;

	/** The column table id. */
	private int columnTableId;

	/**
	 * Gets the column id.
	 *
	 * @return the columnId
	 */
	public long getColumnId() {
		return columnId;
	}

	/**
	 * Sets the column id.
	 *
	 * @param columnId the columnId to set
	 */
	public void setColumnId(long columnId) {
		this.columnId = columnId;
	}

	/**
	 * Gets the column name.
	 *
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * Sets the column name.
	 *
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * Gets the column description.
	 *
	 * @return the columnDescription
	 */
	public String getColumnDescription() {
		return columnDescription;
	}

	/**
	 * Sets the column description.
	 *
	 * @param columnDescription the columnDescription to set
	 */
	public void setColumnDescription(String columnDescription) {
		this.columnDescription = columnDescription;
	}

	/**
	 * Gets the column table id.
	 *
	 * @return the columnTableId
	 */
	public int getColumnTableId() {
		return columnTableId;
	}

	/**
	 * Sets the column table id.
	 *
	 * @param columnTableId the columnTableId to set
	 */
	public void setColumnTableId(int columnTableId) {
		this.columnTableId = columnTableId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(columnDescription, columnId, columnName, columnTableId);
		return result;
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
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof EDPMsColumnsDto)) {
			return false;
		}
		EDPMsColumnsDto other = (EDPMsColumnsDto) obj;
		return Objects.equals(columnDescription, other.columnDescription) && columnId == other.columnId
				&& Objects.equals(columnName, other.columnName) && columnTableId == other.columnTableId;
	}

}
