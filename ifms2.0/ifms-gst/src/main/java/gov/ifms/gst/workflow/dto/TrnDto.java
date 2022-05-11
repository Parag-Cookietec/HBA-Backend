package gov.ifms.gst.workflow.dto;

import java.io.Serializable;

public class TrnDto implements Serializable {

    /** The wfRequestNo. */
    private Long trnId;

    /** The wfRequestNo. */
    private String remarks;

    public Long getTrnId() {
        return trnId;
    }

    public void setTrnId(Long trnId) {
        this.trnId = trnId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
