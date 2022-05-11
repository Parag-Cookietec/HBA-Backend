package gov.ifms.common.cache.dto;

import java.util.Objects;
import java.util.StringJoiner;

public class MsSubMajorHeadCacheDto {

    private long subMajorHeadId;

    private String submajorHeadName;

    private String submajorHeadNameGuj;

    private String subMajorHeadCode;

    private String subMajorHeadCodeGuj;

    private String subMajorHeadCodeNames;

    private Long submajorHeadTypeId;

    private long demandId;

    private long majorHeadId;

    public MsSubMajorHeadCacheDto() {
        super();
    }

    public MsSubMajorHeadCacheDto(long subMajorHeadId, String submajorHeadName, String submajorHeadNameGuj, String subMajorHeadCode, String subMajorHeadCodeGuj, String subMajorHeadCodeNames, Long submajorHeadTypeId, long demandId, long majorHeadId) {
        this.subMajorHeadId = subMajorHeadId;
        this.submajorHeadName = submajorHeadName;
        this.submajorHeadNameGuj = submajorHeadNameGuj;
        this.subMajorHeadCode = subMajorHeadCode;
        this.subMajorHeadCodeGuj = subMajorHeadCodeGuj;
        this.subMajorHeadCodeNames = subMajorHeadCodeNames;
        this.submajorHeadTypeId = submajorHeadTypeId;
        this.demandId = demandId;
        this.majorHeadId = majorHeadId;
    }

    public long getSubMajorHeadId() {
        return subMajorHeadId;
    }

    public void setSubMajorHeadId(long subMajorHeadId) {
        this.subMajorHeadId = subMajorHeadId;
    }

    public String getSubmajorHeadName() {
        return submajorHeadName;
    }

    public void setSubmajorHeadName(String submajorHeadName) {
        this.submajorHeadName = submajorHeadName;
    }

    public String getSubmajorHeadNameGuj() {
        return submajorHeadNameGuj;
    }

    public void setSubmajorHeadNameGuj(String submajorHeadNameGuj) {
        this.submajorHeadNameGuj = submajorHeadNameGuj;
    }

    public String getSubMajorHeadCode() {
        return subMajorHeadCode;
    }

    public void setSubMajorHeadCode(String subMajorHeadCode) {
        this.subMajorHeadCode = subMajorHeadCode;
    }

    public String getSubMajorHeadCodeGuj() {
        return subMajorHeadCodeGuj;
    }

    public void setSubMajorHeadCodeGuj(String subMajorHeadCodeGuj) {
        this.subMajorHeadCodeGuj = subMajorHeadCodeGuj;
    }

    public String getSubMajorHeadCodeNames() {
        return subMajorHeadCodeNames;
    }

    public void setSubMajorHeadCodeNames(String subMajorHeadCodeNames) {
        this.subMajorHeadCodeNames = subMajorHeadCodeNames;
    }

    public Long getSubmajorHeadTypeId() {
        return submajorHeadTypeId;
    }

    public void setSubmajorHeadTypeId(Long submajorHeadTypeId) {
        this.submajorHeadTypeId = submajorHeadTypeId;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", MsSubMajorHeadCacheDto.class.getSimpleName() + "[", "]")
                .add("subMajorHeadId=" + subMajorHeadId)
                .add("submajorHeadName='" + submajorHeadName + "'")
                .add("submajorHeadNameGuj='" + submajorHeadNameGuj + "'")
                .add("subMajorHeadCode='" + subMajorHeadCode + "'")
                .add("subMajorHeadCodeGuj='" + subMajorHeadCodeGuj + "'")
                .add("subMajorHeadCodeNames='" + subMajorHeadCodeNames + "'")
                .add("submajorHeadTypeId=" + submajorHeadTypeId)
                .add("demandId=" + demandId)
                .add("majorHeadId=" + majorHeadId)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsSubMajorHeadCacheDto that = (MsSubMajorHeadCacheDto) o;
        return subMajorHeadId == that.subMajorHeadId &&
                demandId == that.demandId &&
                majorHeadId == that.majorHeadId &&
                Objects.equals(submajorHeadName, that.submajorHeadName) &&
                Objects.equals(submajorHeadNameGuj, that.submajorHeadNameGuj) &&
                Objects.equals(subMajorHeadCode, that.subMajorHeadCode) &&
                Objects.equals(subMajorHeadCodeGuj, that.subMajorHeadCodeGuj) &&
                Objects.equals(subMajorHeadCodeNames, that.subMajorHeadCodeNames) &&
                Objects.equals(submajorHeadTypeId, that.submajorHeadTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subMajorHeadId, submajorHeadName, submajorHeadNameGuj, subMajorHeadCode, subMajorHeadCodeGuj, subMajorHeadCodeNames, submajorHeadTypeId, demandId, majorHeadId);
    }
}
