package gov.ifms.loc.workflow.dto;

import java.util.List;
import java.util.Objects;

/**
 * The Class LocTrnSubmitAssignedToUsersImpl.
 */
public class LocTrnSubmitAssignedToUsersImpl extends LocTrnSubmitAssignedToDto{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8475102100315589765L;
	
	/** The trn dto. */
	private List<LocTrnIdRemAssToUserDto> trnDto;

    /**
     * Gets the trn dto.
     *
     * @return the trn dto
     */
    public List<LocTrnIdRemAssToUserDto> getTrnDto() {
        return trnDto;
    }

    /**
     * Sets the trn dto.
     *
     * @param trnDto the new trn dto
     */
    public void setTrnDto(List<LocTrnIdRemAssToUserDto> trnDto) {
        this.trnDto = trnDto;
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
        LocTrnSubmitAssignedToUsersImpl that = (LocTrnSubmitAssignedToUsersImpl) o;
        return Objects.equals(trnDto, that.trnDto);
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), trnDto);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LocTrnSubmitAssignedToUsersImpl{");
        sb.append("trnDto=").append(trnDto);
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
        System.out.println("####In Child Class LocTrnSubmitAssignedToUsersImpl(To Multiple User)");
        return this.getTrnDto();
    }
}
