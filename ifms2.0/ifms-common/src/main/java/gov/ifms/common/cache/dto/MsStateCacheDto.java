package gov.ifms.common.cache.dto;

import java.util.Objects;
import java.util.StringJoiner;

public class MsStateCacheDto {


    private Long stateId;

    private String stateName;

    private String stateNameGuj;

    private String stateCode;

    public MsStateCacheDto() {
    }

    public MsStateCacheDto(Long stateId, String stateName, String stateNameGuj, String stateCode) {
        this.stateId = stateId;
        this.stateName = stateName;
        this.stateNameGuj = stateNameGuj;
        this.stateCode = stateCode;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateNameGuj() {
        return stateNameGuj;
    }

    public void setStateNameGuj(String stateNameGuj) {
        this.stateNameGuj = stateNameGuj;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsStateCacheDto that = (MsStateCacheDto) o;
        return Objects.equals(stateId, that.stateId) &&
                Objects.equals(stateName, that.stateName) &&
                Objects.equals(stateNameGuj, that.stateNameGuj) &&
                Objects.equals(stateCode, that.stateCode) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stateId, stateName, stateNameGuj, stateCode);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MsStateCacheDto.class.getSimpleName() + "[", "]")
                .add("stateId=" + stateId)
                .add("stateName='" + stateName + "'")
                .add("stateNameGuj='" + stateNameGuj + "'")
                .add("stateCode='" + stateCode + "'")
                .toString();
    }
}
