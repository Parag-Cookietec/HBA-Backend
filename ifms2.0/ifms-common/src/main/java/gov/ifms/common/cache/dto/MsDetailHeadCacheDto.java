package gov.ifms.common.cache.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class MsDetailHeadCacheDto {


    @NativeQueryResultColumn(index = 0)
    private long detailHeadId;

    @NativeQueryResultColumn(index = 1)
    private String detailHeadName;

    @NativeQueryResultColumn(index = 2)
    private String detailHeadNameGuj;

    @NativeQueryResultColumn(index = 3)
    private String detailHeadCode;

    @NativeQueryResultColumn(index = 4)
    private String detailHeadCodeGuj;

    @NativeQueryResultColumn(index = 5)
    private String detailHeadCodeName;

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

    @NativeQueryResultColumn(index = 13)
    private long subHeadId;



    public MsDetailHeadCacheDto() {
        super();
    }

    public long getDetailHeadId() {
        return detailHeadId;
    }

    public void setDetailHeadId(long detailHeadId) {
        this.detailHeadId = detailHeadId;
    }

    public String getDetailHeadName() {
        return detailHeadName;
    }

    public void setDetailHeadName(String detailHeadName) {
        this.detailHeadName = detailHeadName;
    }

    public String getDetailHeadNameGuj() {
        return detailHeadNameGuj;
    }

    public void setDetailHeadNameGuj(String detailHeadNameGuj) {
        this.detailHeadNameGuj = detailHeadNameGuj;
    }

    public String getDetailHeadCode() {
        return detailHeadCode;
    }

    public void setDetailHeadCode(String detailHeadCode) {
        this.detailHeadCode = detailHeadCode;
    }

    public String getDetailHeadCodeGuj() {
        return detailHeadCodeGuj;
    }

    public void setDetailHeadCodeGuj(String detailHeadCodeGuj) {
        this.detailHeadCodeGuj = detailHeadCodeGuj;
    }

    public String getDetailHeadCodeName() {
        return detailHeadCodeName;
    }

    public void setDetailHeadCodeName(String detailHeadCodeName) {
        this.detailHeadCodeName = detailHeadCodeName;
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

    public long getSubHeadId() {
        return subHeadId;
    }

    public void setSubHeadId(long subHeadId) {
        this.subHeadId = subHeadId;
    }
}
