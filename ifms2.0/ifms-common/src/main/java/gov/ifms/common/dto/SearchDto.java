package gov.ifms.common.dto;

import java.io.Serializable;

/**
 * The EDPIdDto.
 *
 * @version 1.0
 * @created 2019/07/26 15:15:38
 */
public class SearchDto implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The id.
     */
    //@Digits(integer = Constant.DOUBLE_MAX_INTEGER, fraction = Constant.DOUBLE_MAX_FRACTION)
    private Long id;

    private Boolean isTransfer;

    /**
     * Instantiates a new id dto.
     */
    public SearchDto() {
    }

    /**
     * Instantiates a new id dto.
     *
     * @param id the id
     */
    public SearchDto(Long id) {
        super();
        this.id = id;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getTransfer() {
        return isTransfer;
    }

    public void setTransfer(Boolean transfer) {
        isTransfer = transfer;
    }

    @Override
    public String toString() {
        return "transferSearchDto{" +
                "id=" + id +
                ", isTransfer=" + isTransfer +
                '}';
    }
}
