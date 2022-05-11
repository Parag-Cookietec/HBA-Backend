package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class IdNameDto.
 */
public class IdNameDto implements Serializable {

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
    private String name;

    /**
     * IdNameDto Constructor.
     */
    public IdNameDto() {
        super();
    }

    /**
     * IdNameDto Constructor.
     */
    public IdNameDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
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
        IdNameDto that = (IdNameDto) obj;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    /**
     * toString method.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "IdNameDto{" + "id=" + id +
                ", name='" + name +
                '}';
    }
}
