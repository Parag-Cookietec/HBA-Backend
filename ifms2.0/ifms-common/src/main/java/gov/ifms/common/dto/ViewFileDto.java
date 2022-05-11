package gov.ifms.common.dto;

public class ViewFileDto {


    private String fileName;

    private String fileSrc;

    public ViewFileDto() {
        super();
    }

    public ViewFileDto(String fileName, String fileSrc) {
        this.fileName = fileName;
        this.fileSrc = fileSrc;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSrc() {
        return fileSrc;
    }

    public void setFileSrc(String fileSrc) {
        this.fileSrc = fileSrc;
    }
}
