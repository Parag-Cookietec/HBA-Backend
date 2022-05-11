package gov.ifms.gst.dto;

public class AccManualEntryCRDto {
	private static final long serialVersionUID = 1L;
	private long id;
	private long accManualHdrId;
	private long crMajorheadId;
	private String crMajorhead;
	private long crSubmajorheadId;
	private String crSubmajorhead;
	private long crMinorheadId;
	private String crMinorhead;
	private String crSubhead;
	private long crSubheadId;
	private long crDetailheadId;
	private String crDetailhead;
	private String crObjecthead;

	public String getCrObjecthead() {
		return crObjecthead;
	}

	public void setCrObjecthead(String crObjecthead) {
		this.crObjecthead = crObjecthead;
	}

	public long getCrObjectheadId() {
		return crObjectheadId;
	}

	public void setCrObjectheadId(long crObjectheadId) {
		this.crObjectheadId = crObjectheadId;
	}

	private long crObjectheadId;
	private String creditAmount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAccManualHdrId() {
		return accManualHdrId;
	}

	public void setAccManualHdrId(long accManualHdrId) {
		this.accManualHdrId = accManualHdrId;
	}

	public long getCrMajorheadId() {
		return crMajorheadId;
	}

	public void setCrMajorheadId(long crMajorheadId) {
		this.crMajorheadId = crMajorheadId;
	}

	public String getCrMajorhead() {
		return crMajorhead;
	}

	public void setCrMajorhead(String crMajorhead) {
		this.crMajorhead = crMajorhead;
	}

	public long getCrSubmajorheadId() {
		return crSubmajorheadId;
	}

	public void setCrSubmajorheadId(long crSubmajorheadId) {
		this.crSubmajorheadId = crSubmajorheadId;
	}

	public String getCrSubmajorhead() {
		return crSubmajorhead;
	}

	public void setCrSubmajorhead(String crSubmajorhead) {
		this.crSubmajorhead = crSubmajorhead;
	}

	public long getCrMinorheadId() {
		return crMinorheadId;
	}

	public void setCrMinorheadId(long crMinorheadId) {
		this.crMinorheadId = crMinorheadId;
	}

	public String getCrMinorhead() {
		return crMinorhead;
	}

	public void setCrMinorhead(String crMinorhead) {
		this.crMinorhead = crMinorhead;
	}

	public String getCrSubhead() {
		return crSubhead;
	}

	public void setCrSubhead(String crSubhead) {
		this.crSubhead = crSubhead;
	}

	public long getCrSubheadId() {
		return crSubheadId;
	}

	public void setCrSubheadId(long crSubheadId) {
		this.crSubheadId = crSubheadId;
	}

	public long getCrDetailheadId() {
		return crDetailheadId;
	}

	public void setCrDetailheadId(long crDetailheadId) {
		this.crDetailheadId = crDetailheadId;
	}

	public String getCrDetailhead() {
		return crDetailhead;
	}

	public void setCrDetailhead(String crDetailhead) {
		this.crDetailhead = crDetailhead;
	}

	public String getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(String creditAmount) {
		this.creditAmount = creditAmount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
