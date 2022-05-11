package gov.ifms.gst.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetStatusDto {

	private String brName;
	private short stateCd;
	private String fileTypeCd;
	private String paymentModeCd;
	private String gstinTmpidNo;
	private Date cpinDt;
	private LocalDateTime cpinDtTime;
	private Date cinDt;
	private LocalDateTime cinDtTime;
	private long cpinNo;
	private String cinNo;
	private long bankRefNum;
	private List<AmountDto> amountDto = new ArrayList<>();
	private Date govCrediteDate;
	private boolean response;
	private String partyName;
	private String scrollNo;
	private String scrollDate;
	private Date govAccountCreditDate;
	private String status;
	private String bankCd;
	private String lyingWith;
	private String accountOn;

	public boolean isResponse() {
		return response;
	}

	public void setResponse(boolean response) {
		this.response = response;
	}

	public List<AmountDto> getAmountDto() {
		return amountDto;
	}

	public void setAmountDto(List<AmountDto> amountDto) {
		this.amountDto = amountDto;
	}

	public Date getGovCrediteDate() {
		return govCrediteDate;
	}

	public void setGovCrediteDate(Date govCrediteDate) {
		this.govCrediteDate = govCrediteDate;
	}

	public String getBrName() {
		return brName;
	}

	public void setBrName(String brName) {
		this.brName = brName;
	}

	public short getStateCd() {
		return stateCd;
	}

	public void setStateCd(short stateCd) {
		this.stateCd = stateCd;
	}

	public String getFileTypeCd() {
		return fileTypeCd;
	}

	public void setFileTypeCd(String fileTypeCd) {
		this.fileTypeCd = fileTypeCd;
	}

	public String getPaymentModeCd() {
		return paymentModeCd;
	}

	public void setPaymentModeCd(String paymentModeCd) {
		this.paymentModeCd = paymentModeCd;
	}

	public String getGstinTmpidNo() {
		return gstinTmpidNo;
	}

	public void setGstinTmpidNo(String gstinTmpidNo) {
		this.gstinTmpidNo = gstinTmpidNo;
	}

	public Date getCpinDt() {
		return cpinDt;
	}

	public void setCpinDt(Date cpinDt) {
		this.cpinDt = cpinDt;
	}

	public LocalDateTime getCpinDtTime() {
		return cpinDtTime;
	}

	public void setCpinDtTime(LocalDateTime cpinDtTime) {
		this.cpinDtTime = cpinDtTime;
	}

	public Date getCinDt() {
		return cinDt;
	}

	public void setCinDt(Date cinDt) {
		this.cinDt = cinDt;
	}

	public LocalDateTime getCinDtTime() {
		return cinDtTime;
	}

	public void setCinDtTime(LocalDateTime cinDtTime) {
		this.cinDtTime = cinDtTime;
	}

	public long getCpinNo() {
		return cpinNo;
	}

	public void setCpinNo(long cpinNo) {
		this.cpinNo = cpinNo;
	}

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	public long getBankRefNum() {
		return bankRefNum;
	}

	public void setBankRefNum(long bankRefNum) {
		this.bankRefNum = bankRefNum;
	}

	public List<AmountDto> getDto() {
		return amountDto;
	}

	public void setDto(List<AmountDto> amountDto) {
		this.amountDto = amountDto;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getScrollNo() {
		return scrollNo;
	}

	public void setScrollNo(String scrollNo) {
		this.scrollNo = scrollNo;
	}

	public String getScrollDate() {
		return scrollDate;
	}

	public void setScrollDate(String scrollDate) {
		this.scrollDate = scrollDate;
	}

	public Date getGovAccountCreditDate() {
		return govAccountCreditDate;
	}

	public void setGovAccountCreditDate(Date govAccountCreditDate) {
		this.govAccountCreditDate = govAccountCreditDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBankCd() {
		return bankCd;
	}

	public void setBankCd(String bankCd) {
		this.bankCd = bankCd;
	}

	public String getLyingWith() {
		return lyingWith;
	}

	public void setLyingWith(String lyingWith) {
		this.lyingWith = lyingWith;
	}

	public String getAccountOn() {
		return accountOn;
	}

	public void setAccountOn(String accountOn) {
		this.accountOn = accountOn;
	}

}
