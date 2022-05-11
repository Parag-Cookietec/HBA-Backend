package gov.ifms.common.cache.dto;

import java.util.Objects;
import java.util.StringJoiner;

public class MsSubSectorCacheDto {

    private Long subSectorId;

    private String subSectorName;

    private String subSectorNameGuj;

    private String subSectorCode;

    private String subSectorCodeGuj;

    private String subSectorCodeName;

    private Long subSectorTypeId;

    private String sectorHeadCode;

    private long sectorHeadId;

    public MsSubSectorCacheDto() {
    }

    public MsSubSectorCacheDto(Long subSectorId, String subSectorName, String subSectorNameGuj, String subSectorCode, String subSectorCodeGuj, String subSectorCodeName, Long subSectorTypeId, String sectorHeadCode, long sectorHeadId) {
        this.subSectorId = subSectorId;
        this.subSectorName = subSectorName;
        this.subSectorNameGuj = subSectorNameGuj;
        this.subSectorCode = subSectorCode;
        this.subSectorCodeGuj = subSectorCodeGuj;
        this.subSectorCodeName = subSectorCodeName;
        this.subSectorTypeId = subSectorTypeId;
        this.sectorHeadCode = sectorHeadCode;
        this.sectorHeadId = sectorHeadId;
    }

    public Long getSubSectorId() {
        return subSectorId;
    }

    public void setSubSectorId(Long subSectorId) {
        this.subSectorId = subSectorId;
    }

    public String getSubSectorName() {
        return subSectorName;
    }

    public void setSubSectorName(String subSectorName) {
        this.subSectorName = subSectorName;
    }

    public String getSubSectorNameGuj() {
        return subSectorNameGuj;
    }

    public void setSubSectorNameGuj(String subSectorNameGuj) {
        this.subSectorNameGuj = subSectorNameGuj;
    }

    public String getSubSectorCode() {
        return subSectorCode;
    }

    public void setSubSectorCode(String subSectorCode) {
        this.subSectorCode = subSectorCode;
    }

    public String getSubSectorCodeGuj() {
        return subSectorCodeGuj;
    }

    public void setSubSectorCodeGuj(String subSectorCodeGuj) {
        this.subSectorCodeGuj = subSectorCodeGuj;
    }

    public String getSubSectorCodeName() {
        return subSectorCodeName;
    }

    public void setSubSectorCodeName(String subSectorCodeName) {
        this.subSectorCodeName = subSectorCodeName;
    }

    public Long getSubSectorTypeId() {
        return subSectorTypeId;
    }

    public void setSubSectorTypeId(Long subSectorTypeId) {
        this.subSectorTypeId = subSectorTypeId;
    }

    public String getSectorHeadCode() {
        return sectorHeadCode;
    }

    public void setSectorHeadCode(String sectorHeadCode) {
        this.sectorHeadCode = sectorHeadCode;
    }

    public long getSectorHeadId() {
        return sectorHeadId;
    }

    public void setSectorHeadId(long sectorHeadId) {
        this.sectorHeadId = sectorHeadId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsSubSectorCacheDto that = (MsSubSectorCacheDto) o;
        return sectorHeadId == that.sectorHeadId &&
                Objects.equals(subSectorId, that.subSectorId) &&
                Objects.equals(subSectorName, that.subSectorName) &&
                Objects.equals(subSectorNameGuj, that.subSectorNameGuj) &&
                Objects.equals(subSectorCode, that.subSectorCode) &&
                Objects.equals(subSectorCodeGuj, that.subSectorCodeGuj) &&
                Objects.equals(subSectorCodeName, that.subSectorCodeName) &&
                Objects.equals(subSectorTypeId, that.subSectorTypeId) &&
                Objects.equals(sectorHeadCode, that.sectorHeadCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subSectorId, subSectorName, subSectorNameGuj, subSectorCode, subSectorCodeGuj, subSectorCodeName, subSectorTypeId, sectorHeadCode, sectorHeadId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MsSubSectorCacheDto.class.getSimpleName() + "[", "]")
                .add("subSectorId=" + subSectorId)
                .add("subSectorName='" + subSectorName + "'")
                .add("subSectorNameGuj='" + subSectorNameGuj + "'")
                .add("subSectorCode='" + subSectorCode + "'")
                .add("subSectorCodeGuj='" + subSectorCodeGuj + "'")
                .add("subSectorCodeName='" + subSectorCodeName + "'")
                .add("subSectorTypeId=" + subSectorTypeId)
                .add("sectorHeadCode='" + sectorHeadCode + "'")
                .add("sectorHeadId=" + sectorHeadId)
                .toString();
    }
}
