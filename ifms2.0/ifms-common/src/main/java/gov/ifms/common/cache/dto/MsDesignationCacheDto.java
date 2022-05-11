package gov.ifms.common.cache.dto;

import java.util.Objects;
import java.util.StringJoiner;

public class MsDesignationCacheDto {


    private Long designationId;

    private String designationName;

    private String designationNameGuj;

    private String designationCode;

    public MsDesignationCacheDto() {
    }

    public MsDesignationCacheDto(Long designationId, String designationName, String designationNameGuj, String designationCode) {
        this.designationId = designationId;
        this.designationName = designationName;
        this.designationNameGuj = designationNameGuj;
        this.designationCode = designationCode;
    }

    public Long getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Long designationId) {
        this.designationId = designationId;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getDesignationNameGuj() {
        return designationNameGuj;
    }

    public void setDesignationNameGuj(String designationNameGuj) {
        this.designationNameGuj = designationNameGuj;
    }

    public String getDesignationCode() {
        return designationCode;
    }

    public void setDesignationCode(String designationCode) {
        this.designationCode = designationCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsDesignationCacheDto that = (MsDesignationCacheDto) o;
        return Objects.equals(designationId, that.designationId) &&
                Objects.equals(designationName, that.designationName) &&
                Objects.equals(designationNameGuj, that.designationNameGuj) &&
                Objects.equals(designationCode, that.designationCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designationId, designationName, designationNameGuj, designationCode);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MsDesignationCacheDto.class.getSimpleName() + "[", "]")
                .add("designationId=" + designationId)
                .add("designationName='" + designationName + "'")
                .add("designationNameGuj='" + designationNameGuj + "'")
                .add("designationCode='" + designationCode + "'")
                .toString();
    }
}
