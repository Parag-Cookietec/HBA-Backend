package gov.ifms.common.attachment.util;

public enum AttachmentCategoryType {
    TRANSACTION(501),
    WORKFLOW(502),
    SPECIFIC_FD_LEVEL_TRANSACTION(865),
    SPECIFIC_AD_LEVEL_TRANSACTION(866);


    private long value;

    /**
     * @return the value
     */
    public long getValue() {
        return value;
    }

    AttachmentCategoryType(long value) {
        this.value = value;
    }
}
