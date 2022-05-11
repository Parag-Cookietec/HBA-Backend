package gov.ifms.common.cache.dto;

import java.util.Objects;
import java.util.StringJoiner;

public class MsDeptCacheDto {

    private Long departmentId;

    private String departmentName;

    private String departmentNameGuj;

    private String departmentShort;

    private String departmentCode;

    public MsDeptCacheDto() {
        super();
    }

    public MsDeptCacheDto(Long departmentId, String departmentName, String departmentNameGuj, String departmentShort, String departmentCode) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentNameGuj = departmentNameGuj;
        this.departmentShort = departmentShort;
        this.departmentCode = departmentCode;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentNameGuj() {
        return departmentNameGuj;
    }

    public void setDepartmentNameGuj(String departmentNameGuj) {
        this.departmentNameGuj = departmentNameGuj;
    }

    public String getDepartmentShort() {
        return departmentShort;
    }

    public void setDepartmentShort(String departmentShort) {
        this.departmentShort = departmentShort;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsDeptCacheDto that = (MsDeptCacheDto) o;
        return Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(departmentName, that.departmentName) &&
                Objects.equals(departmentNameGuj, that.departmentNameGuj) &&
                Objects.equals(departmentShort, that.departmentShort) &&
                Objects.equals(departmentCode, that.departmentCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, departmentName, departmentNameGuj, departmentShort, departmentCode);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MsDeptCacheDto.class.getSimpleName() + "[", "]")
                .add("departmentId=" + departmentId)
                .add("departmentName='" + departmentName + "'")
                .add("departmentNameGuj='" + departmentNameGuj + "'")
                .add("departmentShort='" + departmentShort + "'")
                .add("departmentCode='" + departmentCode + "'")
                .toString();
    }
}
