package gov.ifms.gst.workflow.dto;

import java.util.List;
import java.util.Objects;

/**
 * The Class GstTrnSubmitAssignedToUsersImpl.
 */
public class GstTrnSubmitAssignedToUsersImpl extends GstTrnSubmitAssignedToDto{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8475102100315589765L;
	
	/** The trn dto. */
	private List<GstTrnIdRemAssToUserDto> trnDto;

    /**
     * Gets the trn dto.
     *
     * @return the trn dto
     */
    public List<GstTrnIdRemAssToUserDto> getTrnDto() {
        return trnDto;
    }

    /**
     * Sets the trn dto.
     *
     * @param trnDto the new trn dto
     */
    public void setTrnDto(List<GstTrnIdRemAssToUserDto> trnDto) {
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
        GstTrnSubmitAssignedToUsersImpl that = (GstTrnSubmitAssignedToUsersImpl) o;
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
        final StringBuilder sb = new StringBuilder("GstTrnSubmitAssignedToUsersImpl{");
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
    public List<GstTrnIdRemAssToUserDto> prepareTrnDto(){
        System.out.println("####In Child Class GstTrnSubmitAssignedToUsersImpl(To Multiple User)");
        return this.getTrnDto();
    }
}
