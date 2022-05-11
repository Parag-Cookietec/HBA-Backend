package gov.ifms.common.cache.dto;



public class LkLookUpInfoCacheDto {

    private long lookUpInfoId;

    private String lookUpInfoName;

    private String lookUpInfoNameGuj;

    private long parentLookupId;

    private Integer lookUpInfoValue;

    private short orderId;
    
    private String lookUpInfoDescription;
    
    

   
	public LkLookUpInfoCacheDto() {
    }

    public LkLookUpInfoCacheDto(long lookUpInfoId, String lookUpInfoName, String lookUpInfoNameGuj, long parentLookupId, Integer lookUpInfoValue, short orderId,String lookUpInfoDescription) {
        this.lookUpInfoId = lookUpInfoId;
        this.lookUpInfoName = lookUpInfoName;
        this.lookUpInfoNameGuj = lookUpInfoNameGuj;
        this.parentLookupId = parentLookupId;
        this.lookUpInfoValue = lookUpInfoValue;
        this.orderId = orderId;
        this.lookUpInfoDescription=lookUpInfoDescription;
    }
    public LkLookUpInfoCacheDto(long lookUpInfoId, String lookUpInfoName, String lookUpInfoNameGuj, long parentLookupId, Integer lookUpInfoValue, short orderId) {
        this.lookUpInfoId = lookUpInfoId;
        this.lookUpInfoName = lookUpInfoName;
        this.lookUpInfoNameGuj = lookUpInfoNameGuj;
        this.parentLookupId = parentLookupId;
        this.lookUpInfoValue = lookUpInfoValue;
        this.orderId = orderId;
    }


    public long getLookUpInfoId() {
        return lookUpInfoId;
    }

    public void setLookUpInfoId(long lookUpInfoId) {
        this.lookUpInfoId = lookUpInfoId;
    }

    public String getLookUpInfoName() {
        return lookUpInfoName;
    }

    public void setLookUpInfoName(String lookUpInfoName) {
        this.lookUpInfoName = lookUpInfoName;
    }

    public String getLookUpInfoNameGuj() {
        return lookUpInfoNameGuj;
    }

    public void setLookUpInfoNameGuj(String lookUpInfoNameGuj) {
        this.lookUpInfoNameGuj = lookUpInfoNameGuj;
    }

    public long getParentLookupId() {
        return parentLookupId;
    }

    public void setParentLookupId(long parentLookupId) {
        this.parentLookupId = parentLookupId;
    }

    public Integer getLookUpInfoValue() {
        return lookUpInfoValue;
    }

    public void setLookUpInfoValue(Integer lookUpInfoValue) {
        this.lookUpInfoValue = lookUpInfoValue;
    }

    public short getOrderId() {
        return orderId;
    }

    public void setOrderId(short orderId) {
        this.orderId = orderId;
    }
    public String getLookUpInfoDescription() {
		return lookUpInfoDescription;
	}

	public void setLookUpInfoDescription(String lookUpInfoDescription) {
		this.lookUpInfoDescription = lookUpInfoDescription;
	}

}
