package gov.ifms.pvu.dto.response;

import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The Class PVUMsSixPayFormatDto.
 *
 * @version v 1.0
 * @created 2019/12/23 11:25:42
 */
public class PVUMsSixPayFormatDto implements Serializable {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The id.
     */
    private long id;

    /**
     * The pay band name.
     */
    private String payBandName;

    /**
     * The starting value.
     */
    private long startingValue;

    /**
     * The end value.
     */
    private long endValue;

    /**
     * The end value.
     */
    private int order;
    
    private String scaleValue;


    /**
     * The end value.
     */
    private List<PVUMsGradePayFormatDto> gradePays;

    /**
     * PVUMsGradePayDto Constructor.
     */
    public PVUMsSixPayFormatDto() {
        super();
    }

    public static PVUMsSixPayFormatDto create(PVUMsPayBandEntity entity, List<PVUMsGradePayEntity> list) {
        PVUMsSixPayFormatDto response = new PVUMsSixPayFormatDto();
        response.setId(entity.getId());
        response.setStartingValue(entity.getStartingValue());
        response.setEndValue(entity.getEndingValue());
        response.setOrder(entity.getOrder());
        //String payBandName = entity.getStartingValue() + (entity.getStartingValue() != entity.getEndingValue() ? " - " + entity.getEndingValue() : "");
        response.setPayBandName(entity.getPayBandDispVal());
        response.setGradePays(list.stream().map(PVUMsGradePayFormatDto::create).collect(Collectors.toList()));
        return response;
    }


    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * Gets the startingValue.
     *
     * @return the startingValue
     */
    public long getStartingValue() {
        return startingValue;
    }

    /**
     * Sets the startingValue.
     *
     * @param startingValue the new startingValue
     */
    public void setStartingValue(long startingValue) {
        this.startingValue = startingValue;
    }

    /**
     * Gets the grade pay id.
     *
     * @return the grade pay id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the grade pay id.
     *
     * @param id the new grade pay id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the payBandName.
     *
     * @return the payBandName
     */
    public String getPayBandName() {
        return payBandName;
    }

    /**
     * Sets the pay band name.
     *
     * @param payBandName the new pay band name
     */
    public void setPayBandName(String payBandName) {
        this.payBandName = payBandName;
    }

    /**
     * Gets the grade pay value.
     *
     * @return the grade pay value
     */
    public List<PVUMsGradePayFormatDto> getGradePays() {
        return gradePays;
    }

    /**
     * Sets the grade pay value.
     *
     * @param gradePays the new grade pay value
     */
    public void setGradePays(List<PVUMsGradePayFormatDto> gradePays) {
        this.gradePays = gradePays;
    }


    public long getEndValue() {
        return endValue;
    }

    public void setEndValue(long endValue) {
        this.endValue = endValue;
    }
  
	/**
	 * @return the scaleValue
	 */
	public String getScaleValue() {
		return scaleValue;
	}

	/**
	 * @param scaleValue the scaleValue to set
	 */
	public void setScaleValue(String scaleValue) {
		this.scaleValue = scaleValue;
	}

	/**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PVUMsSixPayFormatDto that = (PVUMsSixPayFormatDto) o;
        return id == that.id &&
                startingValue == that.startingValue &&
                endValue == that.endValue &&
                order == that.order &&
                Objects.equals(payBandName, that.payBandName) &&
                Objects.equals(gradePays, that.gradePays);
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, payBandName, startingValue, endValue, order, gradePays);
    }

    /**
     * toString method.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "PVUMsSixPayFormatDto{" + "id=" + id +
                ", payBandName='" + payBandName + '\'' +
                ", startingValue=" + startingValue +
                ", endValue=" + endValue +
                ", order=" + order +
                ", gradePays=" + gradePays +
                '}';
    }
}
