package gov.ifms.pvu.dto.response;

import gov.ifms.pvu.entity.PVUTransferEntity;

import java.time.LocalDate;


public class PVUTransferListDto {

    /**
     * The transfer id.
     */
    private long id;

    /**
     * The transaction no.
     */
    private String transactionNo;

    /**
     * The office id.
     */
    private long officeId;

    /**
     * The transfer order no.
     */
    private String transferOrderNo;

    /**
     * The transfer order date.
     */
    private LocalDate transferOrderDate;

    /**
     * The transfer order date.
     */
    private boolean submitted;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }

    public String getTransferOrderNo() {
        return transferOrderNo;
    }

    public void setTransferOrderNo(String transferOrderNo) {
        this.transferOrderNo = transferOrderNo;
    }

    public LocalDate getTransferOrderDate() {
        return transferOrderDate;
    }

    public void setTransferOrderDate(LocalDate transferOrderDate) {
        this.transferOrderDate = transferOrderDate;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public static PVUTransferListDto convert(PVUTransferEntity entity) {
        PVUTransferListDto dto = new PVUTransferListDto();
        dto.setId(entity.getId());
        dto.setOfficeId(entity.getOffice() != null ? entity.getOffice().getOfficeId() : 0);
        dto.setTransactionNo(entity.getTrnNo());
        dto.setTransactionNo(entity.getTrnNo());
        dto.setTransferOrderDate(entity.getTransferOrderDate());
        dto.setTransferOrderNo(entity.getTransferOrderNo());
        return dto;
    }


}
