package gov.ifms.common.cache.dto;

import java.util.Objects;
import java.util.StringJoiner;

public class MsMinorHeadCacheDto {

    private long minorHeadId;

    private String minorHeadName;

    private String minorHeadNameGuj;

    private String minorHeadCode;

    private String minorHeadCodeGuj;

    private String minorHeadCodeName;

    private long subMajorHeadId;

    private long majorHeadId;

    private long demandId;

    public MsMinorHeadCacheDto() {
        super();
    }

    public MsMinorHeadCacheDto(long minorHeadId, String minorHeadName, String minorHeadNameGuj, String minorHeadCode, String minorHeadCodeGuj, String minorHeadCodeName, long subMajorHeadId, long majorHeadId, long demandId) {
        this.minorHeadId = minorHeadId;
        this.minorHeadName = minorHeadName;
        this.minorHeadNameGuj = minorHeadNameGuj;
        this.minorHeadCode = minorHeadCode;
        this.minorHeadCodeGuj = minorHeadCodeGuj;
        this.minorHeadCodeName = minorHeadCodeName;
        this.subMajorHeadId = subMajorHeadId;
        this.majorHeadId = majorHeadId;
        this.demandId = demandId;
    }

    public long getMinorHeadId() {
        return minorHeadId;
    }

    public void setMinorHeadId(long minorHeadId) {
        this.minorHeadId = minorHeadId;
    }

    public String getMinorHeadName() {
        return minorHeadName;
    }

    public void setMinorHeadName(String minorHeadName) {
        this.minorHeadName = minorHeadName;
    }

    public String getMinorHeadNameGuj() {
        return minorHeadNameGuj;
    }

    public void setMinorHeadNameGuj(String minorHeadNameGuj) {
        this.minorHeadNameGuj = minorHeadNameGuj;
    }

    public String getMinorHeadCode() {
        return minorHeadCode;
    }

    public void setMinorHeadCode(String minorHeadCode) {
        this.minorHeadCode = minorHeadCode;
    }

    public String getMinorHeadCodeGuj() {
        return minorHeadCodeGuj;
    }

    public void setMinorHeadCodeGuj(String minorHeadCodeGuj) {
        this.minorHeadCodeGuj = minorHeadCodeGuj;
    }

    public String getMinorHeadCodeName() {
        return minorHeadCodeName;
    }

    public void setMinorHeadCodeName(String minorHeadCodeName) {
        this.minorHeadCodeName = minorHeadCodeName;
    }

    public long getSubMajorHeadId() {
        return subMajorHeadId;
    }

    public void setSubMajorHeadId(long subMajorHeadId) {
        this.subMajorHeadId = subMajorHeadId;
    }

    public long getMajorHeadId() {
        return majorHeadId;
    }

    public void setMajorHeadId(long majorHeadId) {
        this.majorHeadId = majorHeadId;
    }

    public long getDemandId() {
        return demandId;
    }

    public void setDemandId(long demandId) {
        this.demandId = demandId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MsMinorHeadCacheDto.class.getSimpleName() + "[", "]")
                .add("minorHeadId=" + minorHeadId)
                .add("minorHeadName='" + minorHeadName + "'")
                .add("minorHeadNameGuj='" + minorHeadNameGuj + "'")
                .add("minorHeadCode='" + minorHeadCode + "'")
                .add("minorHeadCodeGuj='" + minorHeadCodeGuj + "'")
                .add("minorHeadCodeName='" + minorHeadCodeName + "'")
                .add("subMajorHeadId=" + subMajorHeadId)
                .add("majorHeadId=" + majorHeadId)
                .add("demandId=" + demandId)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsMinorHeadCacheDto that = (MsMinorHeadCacheDto) o;
        return minorHeadId == that.minorHeadId &&
                subMajorHeadId == that.subMajorHeadId &&
                majorHeadId == that.majorHeadId &&
                demandId == that.demandId &&
                Objects.equals(minorHeadName, that.minorHeadName) &&
                Objects.equals(minorHeadNameGuj, that.minorHeadNameGuj) &&
                Objects.equals(minorHeadCode, that.minorHeadCode) &&
                Objects.equals(minorHeadCodeGuj, that.minorHeadCodeGuj) &&
                Objects.equals(minorHeadCodeName, that.minorHeadCodeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minorHeadId, minorHeadName, minorHeadNameGuj, minorHeadCode, minorHeadCodeGuj, minorHeadCodeName, subMajorHeadId, majorHeadId, demandId);
    }
}
