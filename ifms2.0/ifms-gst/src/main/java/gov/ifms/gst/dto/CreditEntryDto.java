package gov.ifms.gst.dto;

import java.io.Serializable;

public class CreditEntryDto implements Serializable {

	public Long id;

	public Long majorHeadId;

	public String majorHead;

	public Long subMajorHeadId;

	public String subMajorHead;

	public Long minorHeadId;

	public String minorHead;

	public Long subHeadId;

	public String subHead;

	public Long detailHeadId;

	public String detailHead;

	public Long objectHeadId;

	public String objectHead;

	public Double creditAmt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMajorHeadId() {
		return majorHeadId;
	}

	public void setMajorHeadId(Long majorHeadId) {
		this.majorHeadId = majorHeadId;
	}

	public String getMajorHead() {
		return majorHead;
	}

	public void setMajorHead(String majorHead) {
		this.majorHead = majorHead;
	}

	public Long getSubMajorHeadId() {
		return subMajorHeadId;
	}

	public void setSubMajorHeadId(Long subMajorHeadId) {
		this.subMajorHeadId = subMajorHeadId;
	}

	public String getSubMajorHead() {
		return subMajorHead;
	}

	public void setSubMajorHead(String subMajorHead) {
		this.subMajorHead = subMajorHead;
	}

	public Long getMinorHeadId() {
		return minorHeadId;
	}

	public void setMinorHeadId(Long minorHeadId) {
		this.minorHeadId = minorHeadId;
	}

	public String getMinorHead() {
		return minorHead;
	}

	public void setMinorHead(String minorHead) {
		this.minorHead = minorHead;
	}

	public Long getSubHeadId() {
		return subHeadId;
	}

	public void setSubHeadId(Long subHeadId) {
		this.subHeadId = subHeadId;
	}

	public String getSubHead() {
		return subHead;
	}

	public void setSubHead(String subHead) {
		this.subHead = subHead;
	}

	public Long getDetailHeadId() {
		return detailHeadId;
	}

	public void setDetailHeadId(Long detailHeadId) {
		this.detailHeadId = detailHeadId;
	}

	public String getDetailHead() {
		return detailHead;
	}

	public void setDetailHead(String detailHead) {
		this.detailHead = detailHead;
	}

	public Long getObjectHeadId() {
		return objectHeadId;
	}

	public void setObjectHeadId(Long objectHeadId) {
		this.objectHeadId = objectHeadId;
	}

	public String getObjectHead() {
		return objectHead;
	}

	public void setObjectHead(String objectHead) {
		this.objectHead = objectHead;
	}

	public Double getCreditAmt() {
		return creditAmt;
	}

	public void setCreditAmt(Double creditAmt) {
		this.creditAmt = creditAmt;
	}

}