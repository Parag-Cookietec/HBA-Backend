package gov.ifms.common.attachment.dto;

import java.io.Serializable;
import java.util.Objects;

public class MsAttachmentDto implements Serializable {

    private Long id;

    private String name;

    private String isMandatory;

    private Long category;


    public MsAttachmentDto(Long id, String name, String isMandatory) {
        this.id = id;
        this.name = name;
        this.isMandatory = isMandatory;
    }

    public MsAttachmentDto(Long id, String name, String isMandatory, Long category) {
        this.id = id;
        this.name = name;
        this.isMandatory = isMandatory;
        this.category = category;
    }

    public MsAttachmentDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(String isMandatory) {
        this.isMandatory = isMandatory;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsAttachmentDto that = (MsAttachmentDto) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getIsMandatory(), that.getIsMandatory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getIsMandatory());
    }

    @Override
    public String toString() {
        return "MsAttachmentDto{" + "id=" + id +
                ", name='" + name + '\'' +
                ", isMandatory='" + isMandatory + '\'' +
                '}';
    }
}
