package gov.ifms.common.cache.dto;

import java.util.Objects;
import java.util.StringJoiner;

public class MsDistrictCacheDto {


    private Long districtId;

    private String districtName;

    private String districtNameGuj;

    private String districtCode;

    private Long stateId;

    private String stdCode;

    public MsDistrictCacheDto() {
    }

    public MsDistrictCacheDto(Long districtId, String districtName, String districtNameGuj, String districtCode, Long stateId, String stdCode) {
        this.districtId = districtId;
        this.districtName = districtName;
        this.districtNameGuj = districtNameGuj;
        this.districtCode = districtCode;
        this.stateId = stateId;
        this.stdCode = stdCode;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictNameGuj() {
        return districtNameGuj;
    }

    public void setDistrictNameGuj(String districtNameGuj) {
        this.districtNameGuj = districtNameGuj;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getStdCode() {
        return stdCode;
    }

    public void setStdCode(String stdCode) {
        this.stdCode = stdCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsDistrictCacheDto that = (MsDistrictCacheDto) o;
        return Objects.equals(districtId, that.districtId) &&
                Objects.equals(districtName, that.districtName) &&
                Objects.equals(districtNameGuj, that.districtNameGuj) &&
                Objects.equals(districtCode, that.districtCode) &&
                Objects.equals(stateId, that.stateId) &&
                Objects.equals(stdCode, that.stdCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(districtId, districtName, districtNameGuj, districtCode, stateId, stdCode);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MsDistrictCacheDto.class.getSimpleName() + "[", "]")
                .add("districtId=" + districtId)
                .add("districtName='" + districtName + "'")
                .add("districtNameGuj='" + districtNameGuj + "'")
                .add("districtCode='" + districtCode + "'")
                .add("stateId=" + stateId)
                .add("stdCode='" + stdCode + "'")
                .toString();
    }
}
