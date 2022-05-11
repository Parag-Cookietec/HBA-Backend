package gov.ifms.pvu.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;

/**
 * The Class PVUWfTableInfo.
 */
@NativeQueryResultEntity
public class PVUWfTableInfo implements Serializable {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The remarks.
     */
    @NativeQueryResultColumn(index = 0)
    private String schemaName;

    /**
     * The remarks type.
     */
    @NativeQueryResultColumn(index = 1)
    private String tableName;


    /**
     * Gets the remarks.
     *
     * @return the remarks
     */
    public String getSchemaName() {
        return schemaName;
    }

    /**
     * Sets the remarks.
     *
     * @param schemaName the remarks to set
     */
    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    /**
     * Gets the remarks type.
     *
     * @return the remarksType
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * Sets the remarks type.
     *
     * @param tableName the remarksType to set
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }



}
