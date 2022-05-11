package gov.ifms.common.dto;

import java.io.Serializable;

public class FileAttachmentDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fileName;

    private String documentKey;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDocumentKey() {
        return documentKey;
    }

    public void setDocumentKey(String documentKey) {
        this.documentKey = documentKey;
    }
}
