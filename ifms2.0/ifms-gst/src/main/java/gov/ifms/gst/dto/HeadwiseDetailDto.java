package gov.ifms.gst.dto;

import java.io.Serializable;

public class HeadwiseDetailDto implements Serializable {

	/** The majorehead id. */
	private Long majorheadId;

	/** The submajorhead id. */
	private Long submajorheadId;

	/** The minorhead id. */
	private Long minorheadId;

	/** The subhead id. */
	private Long subheadId;

	/** The detailhead id. */
	private Long detailheadId;

	public Long getMajorheadId() {
		return majorheadId;
	}

	public void setMajorheadId(Long majorheadId) {
		this.majorheadId = majorheadId;
	}

	public Long getSubmajorheadId() {
		return submajorheadId;
	}

	public void setSubmajorheadId(Long submajorheadId) {
		this.submajorheadId = submajorheadId;
	}

	public Long getMinorheadId() {
		return minorheadId;
	}

	public void setMinorheadId(Long minorheadId) {
		this.minorheadId = minorheadId;
	}

	public Long getSubheadId() {
		return subheadId;
	}

	public void setSubheadId(Long subheadId) {
		this.subheadId = subheadId;
	}

	public Long getDetailheadId() {
		return detailheadId;
	}

	public void setDetailheadId(Long detailheadId) {
		this.detailheadId = detailheadId;
	}
}
