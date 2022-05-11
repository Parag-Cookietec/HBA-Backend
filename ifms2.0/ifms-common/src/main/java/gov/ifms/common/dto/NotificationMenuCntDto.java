package gov.ifms.common.dto;

import java.io.Serializable;

public class NotificationMenuCntDto implements Serializable {


    private String menuLink;

    private int count;

    private Long menuId;

    private String menuName;

    private String menuNameGuj;

    private String menuNameDesc;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuLink() {
        return menuLink;
    }

    public void setMenuLink(String menuLink) {
        this.menuLink = menuLink;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuNameGuj() {
        return menuNameGuj;
    }

    public void setMenuNameGuj(String menuNameGuj) {
        this.menuNameGuj = menuNameGuj;
    }

    public String getMenuNameDesc() {
        return menuNameDesc;
    }

    public void setMenuNameDesc(String menuNameDesc) {
        this.menuNameDesc = menuNameDesc;
    }
}
