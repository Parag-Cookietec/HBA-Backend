package gov.ifms.common.cache.dto;

import java.util.Objects;

public class CommonDto {

    private long officeTypeId;

    private long menuId;

    public CommonDto() {
        super();
    }

    public long getOfficeTypeId() {
        return officeTypeId;
    }

    public void setOfficeTypeId(long officeTypeId) {
        this.officeTypeId = officeTypeId;
    }

    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonDto commonDto = (CommonDto) o;
        return officeTypeId == commonDto.officeTypeId &&
                menuId == commonDto.menuId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(officeTypeId, menuId);
    }

}
