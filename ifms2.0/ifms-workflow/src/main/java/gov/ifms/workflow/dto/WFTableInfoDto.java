package gov.ifms.workflow.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class WFTableInfoDto
 */
@NativeQueryResultEntity
public class WFTableInfoDto implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index =  0)
	private String tableName;
	
	@NativeQueryResultColumn(index =  1)
	private String attachTableName;

	@NativeQueryResultColumn(index =  2)
	private String schemaName;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getAttachTableName() {
		return attachTableName;
	}

	public void setAttachTableName(String attachTableName) {
		this.attachTableName = attachTableName;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public WFTableInfoDto() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(attachTableName, schemaName, tableName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof WFTableInfoDto)) {
			return false;
		}
		WFTableInfoDto other = (WFTableInfoDto) obj;
		return Objects.equals(attachTableName, other.attachTableName) && Objects.equals(schemaName, other.schemaName)
				&& Objects.equals(tableName, other.tableName);
	}

	@Override
	public String toString() {
		return String.format("WFTableInfoDto [tableName=%s, attachTableName=%s, schemaName=%s]", tableName,
				attachTableName, schemaName);
	}
}
