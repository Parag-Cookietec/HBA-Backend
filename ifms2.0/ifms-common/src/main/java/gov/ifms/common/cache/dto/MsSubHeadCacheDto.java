package gov.ifms.common.cache.dto;


import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class MsSubHeadCacheDto {


    @NativeQueryResultColumn(index = 0)
    private long subHeadId;

    @NativeQueryResultColumn(index = 1)
    private String subHeadName;

    @NativeQueryResultColumn(index = 2)
    private String subheadNameGuj;



    @NativeQueryResultColumn(index = 3)
    private String subHeadCode;

    @NativeQueryResultColumn(index = 4)
    private String subHeadCodecGuj;

    @NativeQueryResultColumn(index = 5)
    private String subHeadCodeName;

    @NativeQueryResultColumn(index = 6)
    private String edpCode;

    @NativeQueryResultColumn(index = 7)
    private String planningCode;


    @NativeQueryResultColumn(index = 8)
    private long isCss;

    @NativeQueryResultColumn(index = 9)
    private long minorHeadId;

    @NativeQueryResultColumn(index = 10)
    private long demandId;

    @NativeQueryResultColumn(index = 11)
    private long majorHeadId;

    @NativeQueryResultColumn(index = 12)
    private long subMajorHeadId;



    public long getSubHeadId() {
        return subHeadId;
    }

    public void setSubHeadId(long subHeadId) {
        this.subHeadId = subHeadId;
    }

    public String getSubHeadName() {
        return subHeadName;
    }

    public void setSubHeadName(String subHeadName) {
        this.subHeadName = subHeadName;
    }

    public String getSubheadNameGuj() {
        return subheadNameGuj;
    }

    public void setSubheadNameGuj(String subheadNameGuj) {
        this.subheadNameGuj = subheadNameGuj;
    }

    public String getSubHeadCode() {
        return subHeadCode;
    }

    public void setSubHeadCode(String subHeadCode) {
        this.subHeadCode = subHeadCode;
    }

    public String getSubHeadCodecGuj() {
        return subHeadCodecGuj;
    }

    public void setSubHeadCodecGuj(String subHeadCodecGuj) {
        this.subHeadCodecGuj = subHeadCodecGuj;
    }

    public String getSubHeadCodeName() {
        return subHeadCodeName;
    }

    public void setSubHeadCodeName(String subHeadCodeName) {
        this.subHeadCodeName = subHeadCodeName;
    }

    public String getEdpCode() {
        return edpCode;
    }

    public void setEdpCode(String edpCode) {
        this.edpCode = edpCode;
    }

    public String getPlanningCode() {
        return planningCode;
    }

    public void setPlanningCode(String planningCode) {
        this.planningCode = planningCode;
    }

    public long getIsCss() {
        return isCss;
    }

    public void setIsCss(long isCss) {
        this.isCss = isCss;
    }

    public long getMinorHeadId() {
        return minorHeadId;
    }

    public void setMinorHeadId(long minorHeadId) {
        this.minorHeadId = minorHeadId;
    }

    public long getDemandId() {
        return demandId;
    }

    public void setDemandId(long demandId) {
        this.demandId = demandId;
    }

    public long getMajorHeadId() {
        return majorHeadId;
    }

    public void setMajorHeadId(long majorHeadId) {
        this.majorHeadId = majorHeadId;
    }

    public long getSubMajorHeadId() {
        return subMajorHeadId;
    }

    public void setSubMajorHeadId(long subMajorHeadId) {
        this.subMajorHeadId = subMajorHeadId;
    }
}
