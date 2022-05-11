package gov.ifms.edp.dto;

public class EDPLuLookUpResponse {

    /**
     * The lookup type.
     */
    private String lookupType;

    /**
     * The lookup info id.
     */
    private Long lookupInfoId;

    /**
     * The lookup info name.
     */
    private String lookupInfoName;

    public EDPLuLookUpResponse() {
    }

    public EDPLuLookUpResponse(String lookupType, Long lookupInfoId, String lookupInfoName) {
        this.lookupType = lookupType;
        this.lookupInfoId = lookupInfoId;
        this.lookupInfoName = lookupInfoName;
    }

    public String getLookupType() {
        return lookupType;
    }

    public void setLookupType(String lookupType) {
        this.lookupType = lookupType;
    }

    public Long getLookupInfoId() {
        return lookupInfoId;
    }

    public void setLookupInfoId(Long lookupInfoId) {
        this.lookupInfoId = lookupInfoId;
    }

    public String getLookupInfoName() {
        return lookupInfoName;
    }

    public void setLookupInfoName(String lookupInfoName) {
        this.lookupInfoName = lookupInfoName;
    }
}
