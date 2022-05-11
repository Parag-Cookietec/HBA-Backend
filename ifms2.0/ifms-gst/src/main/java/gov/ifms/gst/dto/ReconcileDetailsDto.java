package gov.ifms.gst.dto;

public class ReconcileDetailsDto {


    private AccountScreenChallanDto accountScreenChallanDto;

    private GSTAccountHdrDto gstDetails;

    private AccountingEntriesDto accountingEntriesDto;

    private String accountHdrId;

    public AccountScreenChallanDto getAccountScreenChallanDto() {
        return accountScreenChallanDto;
    }

    public void setAccountScreenChallanDto(AccountScreenChallanDto accountScreenChallanDto) {
        this.accountScreenChallanDto = accountScreenChallanDto;
    }

    public GSTAccountHdrDto getGstDetails() {
        return gstDetails;
    }

    public void setGstDetails(GSTAccountHdrDto gstDetails) {
        this.gstDetails = gstDetails;
    }

    public AccountingEntriesDto getAccountingEntriesDto() {
        return accountingEntriesDto;
    }

    public void setAccountingEntriesDto(AccountingEntriesDto accountingEntriesDto) {
        this.accountingEntriesDto = accountingEntriesDto;
    }

    public String getAccountHdrId() {
        return accountHdrId;
    }

    public void setAccountHdrId(String accountHdrId) {
        this.accountHdrId = accountHdrId;
    }
}
