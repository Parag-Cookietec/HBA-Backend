package gov.ifms.pvu.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;

import java.io.Serializable;
import java.util.Objects;


/**
 * The Class PVUMsGradePayFormatDto.
 *
 * @version v 1.0
 * @created 2019/12/23 17:34:36
 */
public class PVUMsGradePayFormatDto implements Serializable {

    /**
     * The serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private long id;

    private String gradePayValue;

    public static PVUMsGradePayFormatDto create(PVUMsGradePayEntity entity) {
        PVUMsGradePayFormatDto response = new PVUMsGradePayFormatDto();
        response.setId(entity.getId());
        response.setGradePayValue(entity.getGradePayValue());
        return response;
    }

    /**
     * getter setter
     */

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the gradePayValue
     */
    public String getGradePayValue() {
        return gradePayValue;
    }

    /**
     * @return the gradePayValue
     */
    @JsonIgnore
    public Long getGradePayValueInLong() {
        if (this.getGradePayValue().charAt(0) != 0 && Character.isDigit(this.getGradePayValue().charAt(0))) {
            return Long.parseLong(this.getGradePayValue());
        }
        return 0L;
    }

    /**
     * @param gradePayValue the gradePayValue to set
     */
    public void setGradePayValue(String gradePayValue) {
        this.gradePayValue = gradePayValue;
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PVUMsGradePayFormatDto that = (PVUMsGradePayFormatDto) obj;
        return id == that.id &&
                gradePayValue.equals(that.gradePayValue);
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, gradePayValue);
    }

    /**
     * toString method.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "PVUMsGradePayFormatDto{" + "id=" + id +
                ", gradePayValue='" + gradePayValue + '\'' +
                '}';
    }
}
