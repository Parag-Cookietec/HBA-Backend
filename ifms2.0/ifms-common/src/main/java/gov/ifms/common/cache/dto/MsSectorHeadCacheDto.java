package gov.ifms.common.cache.dto;


public class MsSectorHeadCacheDto {

    private long sectorheadId;

    private String sectorheadName;

    private String sectorheadNameGuj;

    private String sectorheadCode;

    private String sectorheadCodeGuj;

    private String sectorheadCodeName;

    private int sectorheadTypeId;

    public MsSectorHeadCacheDto() {

        super();
    }

    public MsSectorHeadCacheDto(long sectorheadId, String sectorheadName, String sectorheadNameGuj, String sectorheadCode, String sectorheadCodeGuj, String sectorheadCodeName, int sectorheadTypeId) {
        this.sectorheadId = sectorheadId;
        this.sectorheadName = sectorheadName;
        this.sectorheadNameGuj = sectorheadNameGuj;
        this.sectorheadCode = sectorheadCode;
        this.sectorheadCodeGuj = sectorheadCodeGuj;
        this.sectorheadCodeName = sectorheadCodeName;
        this.sectorheadTypeId = sectorheadTypeId;
    }


    public long getSectorheadId() {
        return sectorheadId;
    }

    public void setSectorheadId(long sectorheadId) {
        this.sectorheadId = sectorheadId;
    }

    public String getSectorheadName() {
        return sectorheadName;
    }

    public void setSectorheadName(String sectorheadName) {
        this.sectorheadName = sectorheadName;
    }

    public String getSectorheadNameGuj() {
        return sectorheadNameGuj;
    }

    public void setSectorheadNameGuj(String sectorheadNameGuj) {
        this.sectorheadNameGuj = sectorheadNameGuj;
    }

    public String getSectorheadCode() {
        return sectorheadCode;
    }

    public void setSectorheadCode(String sectorheadCode) {
        this.sectorheadCode = sectorheadCode;
    }

    public String getSectorheadCodeGuj() {
        return sectorheadCodeGuj;
    }

    public void setSectorheadCodeGuj(String sectorheadCodeGuj) {
        this.sectorheadCodeGuj = sectorheadCodeGuj;
    }

    public String getSectorheadCodeName() {
        return sectorheadCodeName;
    }

    public void setSectorheadCodeName(String sectorheadCodeName) {
        this.sectorheadCodeName = sectorheadCodeName;
    }

    public int getSectorheadTypeId() {
        return sectorheadTypeId;
    }

    public void setSectorheadTypeId(int sectorheadTypeId) {
        this.sectorheadTypeId = sectorheadTypeId;
    }
}
