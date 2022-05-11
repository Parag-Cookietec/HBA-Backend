package gov.ifms.common.cache.dto;

import java.util.Objects;
import java.util.StringJoiner;

public class MsTalukaCacheDto {


    private Long talukaId;

    private String talukaName;

    private String talukaNameGuj;

    private String talukaCode;

    private Long districtId;

    private String districtCode;

    public MsTalukaCacheDto() {
    }

    public MsTalukaCacheDto(Long talukaId, String talukaName, String talukaCode, Long districtId) {
        this.talukaId = talukaId;
        this.talukaName = talukaName;
        this.talukaCode = talukaCode;
        this.districtId = districtId;
    }

    public Long getTalukaId() {
        return talukaId;
    }

    public void setTalukaId(Long talukaId) {
        this.talukaId = talukaId;
    }

    public String getTalukaName() {
        return talukaName;
    }

    public void setTalukaName(String talukaName) {
        this.talukaName = talukaName;
    }

    public String getTalukaNameGuj() {
        return talukaNameGuj;
    }

    public void setTalukaNameGuj(String talukaNameGuj) {
        this.talukaNameGuj = talukaNameGuj;
    }

    public String getTalukaCode() {
        return talukaCode;
    }

    public void setTalukaCode(String talukaCode) {
        this.talukaCode = talukaCode;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsTalukaCacheDto that = (MsTalukaCacheDto) o;
        return Objects.equals(talukaId, that.talukaId) &&
                Objects.equals(talukaName, that.talukaName) &&
                Objects.equals(talukaNameGuj, that.talukaNameGuj) &&
                Objects.equals(talukaCode, that.talukaCode) &&
                Objects.equals(districtId, that.districtId) &&
                Objects.equals(districtCode, that.districtCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(talukaId, talukaName, talukaNameGuj, talukaCode, districtId, districtCode);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MsTalukaCacheDto.class.getSimpleName() + "[", "]")
                .add("talukaId=" + talukaId)
                .add("talukaName='" + talukaName + "'")
                .add("talukaNameGuj='" + talukaNameGuj + "'")
                .add("talukaCode='" + talukaCode + "'")
                .add("districtId=" + districtId)
                .add("districtCode='" + districtCode + "'")
                .toString();
    }
}
