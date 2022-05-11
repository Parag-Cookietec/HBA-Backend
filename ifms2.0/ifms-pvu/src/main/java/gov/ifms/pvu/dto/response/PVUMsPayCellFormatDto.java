package gov.ifms.pvu.dto.response;

import gov.ifms.pvu.entity.PVUMsPayCellEntity;

import java.io.Serializable;
import java.util.Objects;


/**
 * The Class PVUMsPayCellFormatDto.
 *
 * @version v 1.0
 * @created 2019/12/23 17:34:36
 */
public class PVUMsPayCellFormatDto implements Serializable {

    /**
     * The serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private long id;

    private String displayName;

    private int cellId;

    private long cellValue;

    public static PVUMsPayCellFormatDto create(PVUMsPayCellEntity entity) {
        PVUMsPayCellFormatDto response = new PVUMsPayCellFormatDto();
        response.setId(entity.getId());
        response.setCellId(entity.getCellId());
        response.setCellValue(entity.getCellValue());
        response.setDisplayName("Cell - " + entity.getCellId());
        return response;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the cellId
     */
    public int getCellId() {
        return cellId;
    }

    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @param displayName the displayName to set
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * @param cellId the cellId to set
     */
    public void setCellId(int cellId) {
        this.cellId = cellId;
    }

    /**
     * @return the cellValue
     */
    public long getCellValue() {
        return cellValue;
    }

    /**
     * @param cellValue the cellValue to set
     */
    public void setCellValue(long cellValue) {
        this.cellValue = cellValue;
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PVUMsPayCellFormatDto that = (PVUMsPayCellFormatDto) obj;
        return id == that.id &&
                cellId == that.cellId &&
                cellValue == that.cellValue &&
                displayName.equals(that.displayName);
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, displayName, cellId, cellValue);
    }

    /**
     * toString method.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "PVUMsPayCellFormatDto{" + "id=" + id +
                ", displayName='" + displayName + '\'' +
                ", cellId=" + cellId +
                ", cellValue=" + cellValue +
                '}';
    }
}
