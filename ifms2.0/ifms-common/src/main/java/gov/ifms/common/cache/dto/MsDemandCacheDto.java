package gov.ifms.common.cache.dto;

public class MsDemandCacheDto {

    private long demandId;
    private String demandName;
    private String demandNameGuj;

    private String demandCode;
    private String demandCodeGuj;

    private String demandCodeName;

    private long bpnId;


    public long getDemandId() {
        return demandId;
    }

    public void setDemandId(long demandId) {
        this.demandId = demandId;
    }

    public String getDemandName() {
        return demandName;
    }

    public void setDemandName(String demandName) {
        this.demandName = demandName;
    }

    public String getDemandNameGuj() {
        return demandNameGuj;
    }

    public void setDemandNameGuj(String demandNameGuj) {
        this.demandNameGuj = demandNameGuj;
    }

    public String getDemandCode() {
        return demandCode;
    }

    public void setDemandCode(String demandCode) {
        this.demandCode = demandCode;
    }

    public String getDemandCodeGuj() {
        return demandCodeGuj;
    }

    public void setDemandCodeGuj(String demandCodeGuj) {
        this.demandCodeGuj = demandCodeGuj;
    }

    public String getDemandCodeName() {
        return demandCodeName;
    }

    public void setDemandCodeName(String demandCodeName) {
        this.demandCodeName = demandCodeName;
    }

    public long getBpnId() {
        return bpnId;
    }

    public void setBpnId(long bpnId) {
        this.bpnId = bpnId;
    }

    public MsDemandCacheDto() {
        super();
    }

    public MsDemandCacheDto(long demandId, String demandName, String demandNameGuj, String demandCode, String demandCodeGuj, String demandCodeName, long bpnId) {
        this.demandId = demandId;
        this.demandName = demandName;
        this.demandNameGuj = demandNameGuj;
        this.demandCode = demandCode;
        this.demandCodeGuj = demandCodeGuj;
        this.demandCodeName = demandCodeName;
        this.bpnId = bpnId;
    }

    public MsDemandCacheDto(long demandId, String demandName, String demandNameGuj, String demandCode, String demandCodeGuj, String demandCodeName) {
        this.demandId = demandId;
        this.demandName = demandName;
        this.demandNameGuj = demandNameGuj;
        this.demandCode = demandCode;
        this.demandCodeGuj = demandCodeGuj;
        this.demandCodeName = demandCodeName;
    }
}
