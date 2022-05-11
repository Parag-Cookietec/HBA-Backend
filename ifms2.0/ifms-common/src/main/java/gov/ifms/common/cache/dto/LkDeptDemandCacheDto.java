package gov.ifms.common.cache.dto;

import java.util.Objects;
import java.util.StringJoiner;

public class LkDeptDemandCacheDto extends MsDemandCacheDto {


    private Long deptDemandId;

    public Long getDeptDemandId() {
        return deptDemandId;
    }

    public void setDeptDemandId(Long deptDemandId) {
        this.deptDemandId = deptDemandId;
    }

    public LkDeptDemandCacheDto(Long deptDemandId) {
        this.deptDemandId = deptDemandId;
    }

    public LkDeptDemandCacheDto(Long deptDemandId , long demandId, String demandName, String demandNameGuj, String demandCode, String demandCodeGuj, String demandCodeName) {
        super(demandId, demandName, demandNameGuj, demandCode, demandCodeGuj, demandCodeName);
        this.deptDemandId = deptDemandId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LkDeptDemandCacheDto that = (LkDeptDemandCacheDto) o;
        return Objects.equals(deptDemandId, that.deptDemandId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptDemandId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LkDeptDemandCacheDto.class.getSimpleName() + "[", "]")
                .add("deptDemandId=" + deptDemandId)
                .toString();
    }
}
