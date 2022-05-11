package gov.ifms.loc.dto;

import gov.ifms.edp.dto.BaseDto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class LocMsCircleDto.
 */
public class LocMsCircleDto extends BaseDto implements Serializable {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The id.
     */
    private Long id;

    /**
     * The circle cd.
     */
    private String circleCd;

    /**
     * The circle name.
     */
    private String circleName;

    /**
     * The circle name guj.
     */
    private String circleNameGuj;

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
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the circle cd.
     *
     * @return the circle cd
     */
    public String getCircleCd() {
        return circleCd;
    }

    /**
     * Sets the circle cd.
     *
     * @param circleCd the new circle cd
     */
    public void setCircleCd(String circleCd) {
        this.circleCd = circleCd;
    }

    /**
     * Gets the circle name.
     *
     * @return the circle name
     */
    public String getCircleName() {
        return circleName;
    }

    /**
     * Sets the circle name.
     *
     * @param circleName the new circle name
     */
    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    /**
     * Gets the circle name guj.
     *
     * @return the circle name guj
     */
    public String getCircleNameGuj() {
        return circleNameGuj;
    }

    /**
     * Sets the circle name guj.
     *
     * @param circleNameGuj the new circle name guj
     */
    public void setCircleNameGuj(String circleNameGuj) {
        this.circleNameGuj = circleNameGuj;
    }

    /**
     * Instantiates a new loc ms circle dto.
     */
    public LocMsCircleDto() {
        super();
    }

    /**
     * Equals.
     *
     * @param o the o
     * @return true, if successful
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LocMsCircleDto))
            return false;
        if (!super.equals(o))
            return false;
        LocMsCircleDto that = (LocMsCircleDto) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCircleCd(), that.getCircleCd())
                && Objects.equals(getCircleName(), that.getCircleName())
                && Objects.equals(getCircleNameGuj(), that.getCircleNameGuj());
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getCircleCd(), getCircleName(), getCircleNameGuj());
    }
}
