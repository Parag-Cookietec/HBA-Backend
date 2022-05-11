package gov.ifms.common.cache.dto;


public class MsMajorHeadCacheDto {

    private long majorHeadId;

    private String majorHeadName;

    private String majorHeadNameGuj;

    private String majorHeadCode;

    private long demandId;

    public MsMajorHeadCacheDto() {
        super();
    }

    public MsMajorHeadCacheDto(long majorHeadId, String majorHeadName, String majorHeadNameGuj, String majorHeadCode, long demandId) {
        this.majorHeadId = majorHeadId;
        this.majorHeadName = majorHeadName;
        this.majorHeadNameGuj = majorHeadNameGuj;
        this.majorHeadCode = majorHeadCode;
        this.demandId = demandId;
    }

    public long getMajorHeadId() {
        return majorHeadId;
    }

    public void setMajorHeadId(long majorHeadId) {
        this.majorHeadId = majorHeadId;
    }

    public String getMajorHeadName() {
        return majorHeadName;
    }

    public void setMajorHeadName(String majorHeadName) {
        this.majorHeadName = majorHeadName;
    }

    public String getMajorHeadNameGuj() {
        return majorHeadNameGuj;
    }

    public void setMajorHeadNameGuj(String majorHeadNameGuj) {
        this.majorHeadNameGuj = majorHeadNameGuj;
    }

    public String getMajorHeadCode() {
        return majorHeadCode;
    }

    public void setMajorHeadCode(String majorHeadCode) {
        this.majorHeadCode = majorHeadCode;
    }

    public long getDemandId() {
        return demandId;
    }

    public void setDemandId(long demandId) {
        this.demandId = demandId;
    }


}
