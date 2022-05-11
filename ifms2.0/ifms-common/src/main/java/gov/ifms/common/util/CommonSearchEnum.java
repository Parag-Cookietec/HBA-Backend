package gov.ifms.common.util;

import java.util.StringJoiner;

public enum CommonSearchEnum {

    COMMON_SEARCH_FIELD_IS_OFFICE_ID("officeId", "IN_OFFICE_ID"),
    COMMON_SEARCH_FIELD_IS_POU_ID("pouId", "IN_POU_ID");
    /** The key. */
    private String key;

    /** The value. */
    private String value;

    /**
     * Instantiates a new PVU search enum.
     *
     * @param key   the key
     * @param value the value
     */
    CommonSearchEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Gets the key.
     *
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", CommonSearchEnum.class.getSimpleName() + "[", "]")
                .add("key='" + key + "'")
                .add("value='" + value + "'")
                .toString();
    }
}
