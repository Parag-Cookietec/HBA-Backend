package gov.ifms.gst.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class ExceptionFileDataDto implements Serializable {

	private long id;
	private long pao_file_hdr_id;
	private short state_cd;
	private char payment_mode_cd;
	private long cpin;
	private char bank_cd;
	private LocalDate report_dt;
	private LocalDate report_dt_time;
	private char error_cd;
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
}
