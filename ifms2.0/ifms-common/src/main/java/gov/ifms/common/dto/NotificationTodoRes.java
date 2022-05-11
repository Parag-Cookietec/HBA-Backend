package gov.ifms.common.dto;


import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

@NativeQueryResultEntity
public class NotificationTodoRes implements Serializable {

    private static final long serialVersionUID = 1L;

    @NativeQueryResultColumn(index = 0)
    private Long moduleId;

    @NativeQueryResultColumn(index = 1)
    private String moduleName;

    @NativeQueryResultColumn(index = 2)
    private String moduleNameGuj;

    @NativeQueryResultColumn(index = 3)
    private String moduleNameDesc;

    @NativeQueryResultColumn(index = 4)
    private Long menuId;

    @NativeQueryResultColumn(index = 5)
    private String menuName;

    @NativeQueryResultColumn(index = 6)
    private String menuNameGuj;

    @NativeQueryResultColumn(index = 7)
    private String menuLink;

    @NativeQueryResultColumn(index = 8)
    private String menuNameDesc;

    @NativeQueryResultColumn(index = 9)
    private int count;

    public NotificationTodoRes() {
        super();
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleNameGuj() {
        return moduleNameGuj;
    }

    public void setModuleNameGuj(String moduleNameGuj) {
        this.moduleNameGuj = moduleNameGuj;
    }

    public String getModuleNameDesc() {
        return moduleNameDesc;
    }

    public void setModuleNameDesc(String moduleNameDesc) {
        this.moduleNameDesc = moduleNameDesc;
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

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationTodoRes that = (NotificationTodoRes) o;
        return count == that.count && Objects.equals(moduleId, that.moduleId) && Objects.equals(moduleName, that.moduleName) && Objects.equals(moduleNameGuj, that.moduleNameGuj) && Objects.equals(moduleNameDesc, that.moduleNameDesc) && Objects.equals(menuLink, that.menuLink) && Objects.equals(menuId, that.menuId) && Objects.equals(menuName, that.menuName) && Objects.equals(menuNameGuj, that.menuNameGuj) && Objects.equals(menuNameDesc, that.menuNameDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moduleId, moduleName, moduleNameGuj, moduleNameDesc, menuLink, count, menuId, menuName, menuNameGuj, menuNameDesc);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", NotificationTodoRes.class.getSimpleName() + "[", "]")
                .add("moduleId=" + moduleId)
                .add("moduleName='" + moduleName + "'")
                .add("moduleNameGuj='" + moduleNameGuj + "'")
                .add("moduleNameDesc='" + moduleNameDesc + "'")
                .add("menuLink='" + menuLink + "'")
                .add("count=" + count)
                .add("menuId=" + menuId)
                .add("menuName='" + menuName + "'")
                .add("menuNameGuj='" + menuNameGuj + "'")
                .add("menuNameDesc='" + menuNameDesc + "'")
                .toString();
    }
}
