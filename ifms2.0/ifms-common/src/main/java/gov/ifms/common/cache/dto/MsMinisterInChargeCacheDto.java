package gov.ifms.common.cache.dto;

import java.util.Objects;
import java.util.StringJoiner;

public class MsMinisterInChargeCacheDto {


    private long msMinisterInChargeId;

    private String name;

    private String nameGuj;

    private long demandId;

    private String portfolio;

    private String portfolioGuj;

    private Long lkPOUId;

    public MsMinisterInChargeCacheDto(long msMinisterInChargeId, String name, String nameGuj, long demandId, String portfolio, String portfolioGuj, Long lkPOUId) {
        this.msMinisterInChargeId = msMinisterInChargeId;
        this.name = name;
        this.nameGuj = nameGuj;
        this.demandId = demandId;
        this.portfolio = portfolio;
        this.portfolioGuj = portfolioGuj;
        this.lkPOUId = lkPOUId;
    }

    public MsMinisterInChargeCacheDto() {
    }

    public long getMsMinisterInChargeId() {
        return msMinisterInChargeId;
    }

    public void setMsMinisterInChargeId(long msMinisterInChargeId) {
        this.msMinisterInChargeId = msMinisterInChargeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameGuj() {
        return nameGuj;
    }

    public void setNameGuj(String nameGuj) {
        this.nameGuj = nameGuj;
    }

    public long getDemandId() {
        return demandId;
    }

    public void setDemandId(long demandId) {
        this.demandId = demandId;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getPortfolioGuj() {
        return portfolioGuj;
    }

    public void setPortfolioGuj(String portfolioGuj) {
        this.portfolioGuj = portfolioGuj;
    }

    public long getLkPOUId() {
        return lkPOUId;
    }

    public void setLkPOUId(long lkPOUId) {
        this.lkPOUId = lkPOUId;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsMinisterInChargeCacheDto that = (MsMinisterInChargeCacheDto) o;
        return msMinisterInChargeId == that.msMinisterInChargeId &&
                demandId == that.demandId &&
                lkPOUId == that.lkPOUId &&
                Objects.equals(name, that.name) &&
                Objects.equals(nameGuj, that.nameGuj) &&
                Objects.equals(portfolio, that.portfolio) &&
                Objects.equals(portfolioGuj, that.portfolioGuj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msMinisterInChargeId, name, nameGuj, demandId, portfolio, portfolioGuj, lkPOUId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MsMinisterInChargeCacheDto.class.getSimpleName() + "[", "]")
                .add("msMinisterInChargeId=" + msMinisterInChargeId)
                .add("name='" + name + "'")
                .add("nameGuj='" + nameGuj + "'")
                .add("demandId=" + demandId)
                .add("portfolio='" + portfolio + "'")
                .add("portfolioGuj='" + portfolioGuj + "'")
                .add("lkPOUId=" + lkPOUId)
                .toString();
    }
}
