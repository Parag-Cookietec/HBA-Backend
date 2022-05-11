package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DMONSSFLoanBaseReportDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private Map<String, List<DMONSSFLoanReportDto>> map = new HashMap<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, List<DMONSSFLoanReportDto>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<DMONSSFLoanReportDto>> map) {
		this.map = map;
	}

}
