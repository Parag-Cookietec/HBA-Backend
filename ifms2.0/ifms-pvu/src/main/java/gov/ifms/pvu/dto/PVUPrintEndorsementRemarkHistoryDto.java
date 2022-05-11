package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class PVUPrintEndorsementRemarkHistoryDto implements Serializable {

    private static final long serialVersionUID = 1L;
    @NativeQueryResultColumn(index = 0)
    private Long rpEventId;
    @NativeQueryResultColumn(index = 1)
    private String userName;
    @NativeQueryResultColumn(index = 2)
    private String postName;
    @NativeQueryResultColumn(index = 3)
    private String remarks;
    @NativeQueryResultColumn(index = 4)
    private Date reprintDate;




	/**
	 * @return the rpEventId
	 */
	public Long getRpEventId() {
		return rpEventId;
	}

	/**
	 * @param rpEventId the rpEventId to set
	 */
	public void setRpEventId(Long rpEventId) {
		this.rpEventId = rpEventId;
	}

	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getReprintDate() {
        return reprintDate;
    }

    public void setReprintDate(Date reprintDate) {
        this.reprintDate = reprintDate;
    }
}
