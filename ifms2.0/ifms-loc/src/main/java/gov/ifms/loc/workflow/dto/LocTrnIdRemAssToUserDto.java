package gov.ifms.loc.workflow.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class LocTrnIdRemAssToUserDto.
 */
public class LocTrnIdRemAssToUserDto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5735832725261271754L;

	/** The trn id. */
	private long trnId;

    /** The pou id. */
    private Long pouId;

    /** The office id. */
    private Long officeId;

    /** The branch id. */
    private Long branchId;

    /** The remarks. */
    private String remarks;

    /**
     * Gets the trn id.
     *
     * @return the trn id
     */
    public long getTrnId() {
        return trnId;
    }

    /**
     * Sets the trn id.
     *
     * @param trnId the new trn id
     */
    public void setTrnId(long trnId) {
        this.trnId = trnId;
    }

    /**
     * Gets the pou id.
     *
     * @return the pou id
     */
    public Long getPouId() {
        return pouId;
    }

    /**
     * Sets the pou id.
     *
     * @param pouId the new pou id
     */
    public void setPouId(Long pouId) {
        this.pouId = pouId;
    }

    /**
     * Gets the office id.
     *
     * @return the office id
     */
    public Long getOfficeId() {
        return officeId;
    }

    /**
     * Sets the office id.
     *
     * @param officeId the new office id
     */
    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    /**
     * Gets the branch id.
     *
     * @return the branch id
     */
    public Long getBranchId() {
        return branchId;
    }

    /**
     * Sets the branch id.
     *
     * @param branchId the new branch id
     */
    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    /**
     * Gets the remarks.
     *
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Sets the remarks.
     *
     * @param remarks the new remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * Equals.
     *
     * @param o the o
     * @return true, if successful
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocTrnIdRemAssToUserDto that = (LocTrnIdRemAssToUserDto) o;
        return trnId == that.trnId && Objects.equals(pouId, that.pouId) && Objects.equals(officeId, that.officeId) && Objects.equals(branchId, that.branchId) && Objects.equals(remarks, that.remarks);
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(trnId, pouId, officeId, branchId, remarks);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LocTrnIdRemAssToUserDto{");
        sb.append("trnId=").append(trnId);
        sb.append(", pouId=").append(pouId);
        sb.append(", officeId=").append(officeId);
        sb.append(", branchId=").append(branchId);
        sb.append(", remarks='").append(remarks).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
