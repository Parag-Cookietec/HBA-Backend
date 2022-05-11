package gov.ifms.common.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class NotificationToDoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long moduleId;

    private String moduleName;

    private String moduleNameGuj;

    private String moduleNameDesc;

    public String getModuleNameDesc() {
        return moduleNameDesc;
    }

    public void setModuleNameDesc(String moduleNameDesc) {
        this.moduleNameDesc = moduleNameDesc;
    }

    public String getModuleNameGuj() {
        return moduleNameGuj;
    }

    public void setModuleNameGuj(String moduleNameGuj) {
        this.moduleNameGuj = moduleNameGuj;
    }

    private List<NotificationMenuCntDto> notificationMenuCntDtos;

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

    public List<NotificationMenuCntDto> getNotificationMenuCntDtos() {
        return notificationMenuCntDtos;
    }

    public void setNotificationMenuCntDtos(List<NotificationMenuCntDto> notificationMenuCntDtos) {
        this.notificationMenuCntDtos = notificationMenuCntDtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationToDoDto that = (NotificationToDoDto) o;
        return Objects.equals(moduleId, that.moduleId) && Objects.equals(moduleName, that.moduleName) && Objects.equals(moduleNameGuj, that.moduleNameGuj) && Objects.equals(moduleNameDesc, that.moduleNameDesc) && Objects.equals(notificationMenuCntDtos, that.notificationMenuCntDtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moduleId, moduleName, moduleNameGuj, moduleNameDesc, notificationMenuCntDtos);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", NotificationToDoDto.class.getSimpleName() + "[", "]")
                .add("moduleId=" + moduleId)
                .add("moduleName='" + moduleName + "'")
                .add("moduleNameGuj='" + moduleNameGuj + "'")
                .add("moduleNameDesc='" + moduleNameDesc + "'")
                .add("notificationMenuCntDtos=" + notificationMenuCntDtos)
                .toString();
    }
}
