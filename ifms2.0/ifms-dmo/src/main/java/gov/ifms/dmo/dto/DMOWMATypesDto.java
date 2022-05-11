package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class DMOWMATypesDto implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String wmaType;
	
	private Double wmaLimit;
	
	private Double wmaRoi;
	
	private LocalDate startFrmDt;
	
	private LocalDate endToDt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWmaType() {
		return wmaType;
	}

	public void setWmaType(String wmaType) {
		this.wmaType = wmaType;
	}

	public Double getWmaLimit() {
		return wmaLimit;
	}

	public void setWmaLimit(Double wmaLimit) {
		this.wmaLimit = wmaLimit;
	}

	public Double getWmaRoi() {
		return wmaRoi;
	}

	public void setWmaRoi(Double wmaRoi) {
		this.wmaRoi = wmaRoi;
	}

	public LocalDate getStartFrmDt() {
		return startFrmDt;
	}

	public void setStartFrmDt(LocalDate startFrmDt) {
		this.startFrmDt = startFrmDt;
	}

	public LocalDate getEndToDt() {
		return endToDt;
	}

	public void setEndToDt(LocalDate endToDt) {
		this.endToDt = endToDt;
	}

}
