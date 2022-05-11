package gov.ifms.common.dto;

import java.io.Serializable;

/**
 * The Class FieldDto.
 */
public class FieldDto implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The field value. */
    private String fieldValue;

    /**
     * Gets the field value.
     *
     * @return the field value
     */
    public String getFieldValue() {
        return fieldValue;
    }

    /**
     * Sets the field value.
     *
     * @param fieldValue the new field value
     */
    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

}
