package gov.ifms.pvu.dto.response;

import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * The Class PVUMsSevenPayFormatDto.
 *
 * @version v 1.0
 * @created 2019/12/23 17:34:36
 */
public class PVUMsSevenPayFormatDto implements Serializable {

    /**
     * The serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private long id;

    private String payLevelValue;

    private int order;

    private List<PVUMsPayCellFormatDto> cells;

    public static PVUMsSevenPayFormatDto create(PVUMsPayLevelEntity level, List<PVUMsPayCellEntity> cells) {
        PVUMsSevenPayFormatDto response = new PVUMsSevenPayFormatDto();
        response.setId(level.getId());
        response.setOrder(level.getOrder());
        response.setPayLevelValue(level.getPayLevelValue());
        response.setCells(cells.stream().map(PVUMsPayCellFormatDto::create).collect(Collectors.toList()));
        return response;
    }

    /**
     * PVUMsPayCellDto Constructor
     */
    public PVUMsSevenPayFormatDto() {
        super();
    }

    /**
     * @return the order
     */
    public int getOrder() {
        return order;
    }

    /**
     * @param order the order
     */
    public void setOrder(int order) {
        this.order = order;
    }

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
     * @return the payLevelValue
     */
    public String getPayLevelValue() {
        return payLevelValue;
    }

    /**
     * @param payLevelValue the payLevelValue to set
     */
    public void setPayLevelValue(String payLevelValue) {
        this.payLevelValue = payLevelValue;
    }

    /**
     * @return the cells
     */
    public List<PVUMsPayCellFormatDto> getCells() {
        return cells;
    }

    /**
     * @param cells the cells to set
     */
    public void setCells(List<PVUMsPayCellFormatDto> cells) {
        this.cells = cells;
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
        PVUMsSevenPayFormatDto that = (PVUMsSevenPayFormatDto) obj;
        return id == that.id &&
                order == that.order &&
                Objects.equals(payLevelValue, that.payLevelValue) &&
                Objects.equals(cells, that.cells);
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, payLevelValue, order, cells);
    }

    /**
     * toString method.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "PVUMsSevenPayFormatDto{" + "id=" + id +
                ", payLevelValue='" + payLevelValue + '\'' +
                ", order=" + order +
                ", cells=" + cells +
                '}';
    }
}
