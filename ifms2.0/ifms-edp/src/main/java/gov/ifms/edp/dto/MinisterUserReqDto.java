package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

public class MinisterUserReqDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private long menuId;

    private long ministerId;

    private long officeId;

    public MinisterUserReqDto() {
        super();
    }

    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    public long getMinisterId() {
        return ministerId;
    }

    public void setMinisterId(long ministerId) {
        this.ministerId = ministerId;
    }

    public long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MinisterUserReqDto that = (MinisterUserReqDto) o;
        return menuId == that.menuId &&
                ministerId == that.ministerId &&
                officeId == that.officeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, ministerId, officeId);
    }

    @Override
    public String toString() {
        return "MinisterUserReqDto{" +
                "menuId=" + menuId +
                ", ministerId=" + ministerId +
                ", officeId=" + officeId +
                '}';
    }
}
