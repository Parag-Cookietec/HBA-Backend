package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "TPAO_EXCEPTION_FILE_DATA", schema = GSTConstant.GST_SCHEMA)
public class ExceptionFileData extends BaseEntity implements Serializable {

	public static final String TRN_SCREEN_EFD = "EFD";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EXCEPTION_FILE_ID")
	private long id;

	@Column(name = "PAO_FILE_HDR_ID")
	private long pao_file_hdr_id;

	@Column(name = "STATE_CD")
	private short state_cd;

	@Column(name = "PAYMENT_MODE_CD")
	private char payment_mode_cd;

	@Column(name = "CPIN")
	private long cpin;

	@Column(name = "BANK_CD")
	private char bank_cd;

	@Column(name = "REPORT_DT")
	private LocalDate report_dt;

	@Column(name = "REPORT_DT_TIME")
	private LocalDate report_dt_time;

	@Column(name = "ERROR_CD")
	private char error_cd;

	@Column(name = "ERROR_MESSAGE")
	private String error_message;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPao_file_hdr_id() {
		return pao_file_hdr_id;
	}

	public void setPao_file_hdr_id(long pao_file_hdr_id) {
		this.pao_file_hdr_id = pao_file_hdr_id;
	}

	public short getState_cd() {
		return state_cd;
	}

	public void setState_cd(short state_cd) {
		this.state_cd = state_cd;
	}

	public char getPayment_mode_cd() {
		return payment_mode_cd;
	}

	public void setPayment_mode_cd(char payment_mode_cd) {
		this.payment_mode_cd = payment_mode_cd;
	}

	public long getCpin() {
		return cpin;
	}

	public void setCpin(long cpin) {
		this.cpin = cpin;
	}

	public char getBank_cd() {
		return bank_cd;
	}

	public void setBank_cd(char bank_cd) {
		this.bank_cd = bank_cd;
	}

	public LocalDate getReport_dt() {
		return report_dt;
	}

	public void setReport_dt(LocalDate report_dt) {
		this.report_dt = report_dt;
	}

	public LocalDate getReport_dt_time() {
		return report_dt_time;
	}

	public void setReport_dt_time(LocalDate report_dt_time) {
		this.report_dt_time = report_dt_time;
	}

	public char getError_cd() {
		return error_cd;
	}

	public void setError_cd(char error_cd) {
		this.error_cd = error_cd;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	public static String getTrnScreenEfd() {
		return TRN_SCREEN_EFD;
	}

	public ExceptionFileData(long id) {
		super();
		this.id = id;
	}

	public ExceptionFileData() {
		super();
	}
}
