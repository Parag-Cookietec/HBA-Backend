package gov.ifms.common.cache.dto;

import java.util.Objects;
import java.util.StringJoiner;

public class MsBPNCacheDto {

    private long bpnId;

    private String bpnName;

    private String bpnNameGuj;

    private String bpnCode;

    private String bpnCodeGuj;

    private String bpnCodeName;

    public MsBPNCacheDto() {
        super();
    }

    public MsBPNCacheDto(long bpnId, String bpnName, String bpnNameGuj, String bpnCode, String bpnCodeGuj, String bpnCodeName) {
        this.bpnId = bpnId;
        this.bpnName = bpnName;
        this.bpnNameGuj = bpnNameGuj;
        this.bpnCode = bpnCode;
        this.bpnCodeGuj = bpnCodeGuj;
        this.bpnCodeName = bpnCodeName;
    }

    public long getBpnId() {
        return bpnId;
    }

    public void setBpnId(long bpnId) {
        this.bpnId = bpnId;
    }

    public String getBpnName() {
        return bpnName;
    }

    public void setBpnName(String bpnName) {
        this.bpnName = bpnName;
    }

    public String getBpnNameGuj() {
        return bpnNameGuj;
    }

    public void setBpnNameGuj(String bpnNameGuj) {
        this.bpnNameGuj = bpnNameGuj;
    }

    public String getBpnCode() {
        return bpnCode;
    }

    public void setBpnCode(String bpnCode) {
        this.bpnCode = bpnCode;
    }

    public String getBpnCodeGuj() {
        return bpnCodeGuj;
    }

    public void setBpnCodeGuj(String bpnCodeGuj) {
        this.bpnCodeGuj = bpnCodeGuj;
    }

    public String getBpnCodeName() {
        return bpnCodeName;
    }

    public void setBpnCodeName(String bpnCodeName) {
        this.bpnCodeName = bpnCodeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsBPNCacheDto that = (MsBPNCacheDto) o;
        return bpnId == that.bpnId &&
                Objects.equals(bpnName, that.bpnName) &&
                Objects.equals(bpnNameGuj, that.bpnNameGuj) &&
                Objects.equals(bpnCode, that.bpnCode) &&
                Objects.equals(bpnCodeGuj, that.bpnCodeGuj) &&
                Objects.equals(bpnCodeName, that.bpnCodeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bpnId, bpnName, bpnNameGuj, bpnCode, bpnCodeGuj, bpnCodeName);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MsBPNCacheDto.class.getSimpleName() + "[", "]")
                .add("bpnId=" + bpnId)
                .add("bpnName='" + bpnName + "'")
                .add("bpnNameGuj='" + bpnNameGuj + "'")
                .add("bpnCode='" + bpnCode + "'")
                .add("bpnCodeGuj='" + bpnCodeGuj + "'")
                .add("bpnCodeName='" + bpnCodeName + "'")
                .toString();
    }
}
