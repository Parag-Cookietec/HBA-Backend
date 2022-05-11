package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TPAO_ACC_MANUAL_ENTRY_CR", schema = GSTConstant.GST_SCHEMA)
public class AccManualEtryDR extends BaseEntity implements Serializable {
	public static final String TRN_SCREEN_AMCE = "AMCE";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACC_MANUAL_CR_ID")
	private long id;

	@Column(name = "ACC_MANUAL_HDR_ID")
	private long accManualHdrId;

	@Column(name = "CR_MAJORHEAD_ID")
	private long crMajorheadId;

	@Column(name = "CR_MAJORHEAD")
	private String crMajorhead;

	@Column(name = "CR_SUBMAJORHEAD_ID")
	private long crSubmajorheadId;

	@Column(name = "CR_SUBMAJORHEAD")
	private String crSubmajorhead;

	@Column(name = "CR_MINORHEAD_ID")
	private long crMinorheadId;

	@Column(name = "CR_MINORHEAD")
	private String crMinorhead;

	@Column(name = "CR_SUBHEAD")
	private String crSubhead;

	@Column(name = "CR_SUBHEAD_ID")
	private long crSubheadId;

	@Column(name = "CR_DETAILHEAD_ID")
	private long crDetailheadId;

	@Column(name = "CR_DETAILHEAD")
	private String crDetailhead;

	@Column(name = "CR_OBJECTHEAD")
	private long crObjecthead;

	@Column(name = "CR_OBJECTHEAD_ID")
	private String crObjectheadId;

	@Column(name = "CREDIT_AMOUNT")
	private String creditAmount;

	public AccManualEtryDR(long id) {
		super();
		this.id = id;
	}

	public AccManualEtryDR() {
		super();
	}

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

	public long getCrObjecthead() {
		return crObjecthead;
	}

	public void setCrObjecthead(long crObjecthead) {
		this.crObjecthead = crObjecthead;
	}

	public String getCrObjectheadId() {
		return crObjectheadId;
	}

	public void setCrObjectheadId(String crObjectheadId) {
		this.crObjectheadId = crObjectheadId;
	}

	public String getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(String creditAmount) {
		this.creditAmount = creditAmount;
	}

	public static String getTrnScreenAmce() {
		return TRN_SCREEN_AMCE;
	}

}
