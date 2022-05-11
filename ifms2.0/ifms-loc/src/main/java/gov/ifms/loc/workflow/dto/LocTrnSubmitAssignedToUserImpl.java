package gov.ifms.loc.workflow.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The Class LocTrnSubmitAssignedToUserImpl.
 */
public class LocTrnSubmitAssignedToUserImpl extends LocTrnSubmitAssignedToDto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3991323760703709851L;
	
	/** The trn ids. */
	private transient List<Long> trnIds;
	
	/** The remarks. */
	private String remarks;

    /** The assign to. */
    private WfUserDetailsV3 assignTo;

    /**
     * Gets the trn ids.
     *
     * @return the trn ids
     */
    public List<Long> getTrnIds() {
        return trnIds;
    }

    /**
     * Sets the trn ids.
     *
     * @param trnIds the new trn ids
     */
    public void setTrnIds(List<Long> trnIds) {
        this.trnIds = trnIds;
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
     * Gets the assign to.
     *
     * @return the assign to
     */
    public WfUserDetailsV3 getAssignTo() {
        return assignTo;
    }

    /**
     * Sets the assign to.
     *
     * @param assignTo the new assign to
     */
    public void setAssignTo(WfUserDetailsV3 assignTo) {
        this.assignTo = assignTo;
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
        if (!super.equals(o)) return false;
        LocTrnSubmitAssignedToUserImpl that = (LocTrnSubmitAssignedToUserImpl) o;
        return Objects.equals(trnIds, that.trnIds) && Objects.equals(remarks, that.remarks) && Objects.equals(assignTo, that.assignTo);
    }



    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), trnIds, remarks, assignTo);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LocTrnSubmitAssignedToUserImpl{");
        sb.append("trnIds=").append(trnIds);
        sb.append(", remarks='").append(remarks).append('\'');
        sb.append(", assignTo=").append(assignTo);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Prepare trn dto.
     *
     * @return the list
     */
    @Override
    public List<LocTrnIdRemAssToUserDto> prepareTrnDto(){
        System.out.println("####In Child Class LocTrnSubmitAssignedToUserImpl(To Single User)");
        List<LocTrnIdRemAssToUserDto> trnDtos = new ArrayList<>();
        this.getTrnIds().stream().forEach(trn -> {
            LocTrnIdRemAssToUserDto trnDto = new LocTrnIdRemAssToUserDto();
            trnDto.setTrnId(trn);
            trnDto.setPouId(this.getAssignTo().getPouId());
            trnDto.setOfficeId(this.getAssignTo().getOfficeId());
            trnDto.setBranchId(this.getAssignTo().getBranchId());
            trnDto.setRemarks(this.getRemarks());
            trnDtos.add(trnDto);
        });
        return trnDtos;
    }
}
