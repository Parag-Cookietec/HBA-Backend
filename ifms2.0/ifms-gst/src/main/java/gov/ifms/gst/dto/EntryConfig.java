package gov.ifms.gst.dto;

public class EntryConfig {
	private long id;
	private long majorheadId;
	private String majorhead;
	private long submajorheadId;
	private String submajorhead;
	private long minorheadId;
	private String minorhead;
	private String subhead;
	private long subheadId;
	private long detailheadId;
	private String detailhead;
	private String entryDesc;

	public EntryConfig(){}

	public EntryConfig(long majorheadId, String majorhead, long submajorheadId, String submajorhead, long minorheadId, String minorhead, String subhead, long subheadId, long detailheadId, String detailhead, String entryDesc) {
		this.majorheadId = majorheadId;
		this.majorhead = majorhead;
		this.submajorheadId = submajorheadId;
		this.submajorhead = submajorhead;
		this.minorheadId = minorheadId;
		this.minorhead = minorhead;
		this.subhead = subhead;
		this.subheadId = subheadId;
		this.detailheadId = detailheadId;
		this.detailhead = detailhead;
		this.entryDesc = entryDesc;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMajorheadId() {
		return majorheadId;
	}

	public void setMajorheadId(long majorheadId) {
		this.majorheadId = majorheadId;
	}

	public String getMajorhead() {
		return majorhead;
	}

	public void setMajorhead(String majorhead) {
		this.majorhead = majorhead;
	}

	public long getSubmajorheadId() {
		return submajorheadId;
	}

	public void setSubmajorheadId(long submajorheadId) {
		this.submajorheadId = submajorheadId;
	}

	public String getSubmajorhead() {
		return submajorhead;
	}

	public void setSubmajorhead(String submajorhead) {
		this.submajorhead = submajorhead;
	}

	public long getMinorheadId() {
		return minorheadId;
	}

	public void setMinorheadId(long minorheadId) {
		this.minorheadId = minorheadId;
	}

	public String getMinorhead() {
		return minorhead;
	}

	public void setMinorhead(String minorhead) {
		this.minorhead = minorhead;
	}

	public String getSubhead() {
		return subhead;
	}

	public void setSubhead(String subhead) {
		this.subhead = subhead;
	}

	public long getSubheadId() {
		return subheadId;
	}

	public void setSubheadId(long subheadId) {
		this.subheadId = subheadId;
	}

	public long getDetailheadId() {
		return detailheadId;
	}

	public void setDetailheadId(long detailheadId) {
		this.detailheadId = detailheadId;
	}

	public String getDetailhead() {
		return detailhead;
	}

	public void setDetailhead(String detailhead) {
		this.detailhead = detailhead;
	}

	public String getEntryDesc() {
		return entryDesc;
	}

	public void setEntryDesc(String entryDesc) {
		this.entryDesc = entryDesc;
	}
}
