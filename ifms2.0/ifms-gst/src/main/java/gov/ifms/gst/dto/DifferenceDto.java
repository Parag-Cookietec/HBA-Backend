package gov.ifms.gst.dto;

import java.util.ArrayList;
import java.util.List;

public class DifferenceDto {
	private List<GSTFileSummeryDto> readFile = new ArrayList<>();
	private List<GSTNDto> diffrenceFile = new ArrayList<>();

	public List<GSTNDto> getDiffrenceFile() {
		return diffrenceFile;
	}

	public void setDiffrenceFile(List<GSTNDto> diffrenceFile) {
		this.diffrenceFile = diffrenceFile;
	}

	public List<GSTFileSummeryDto> getReadFile() {
		return readFile;
	}

	public void setReadFile(List<GSTFileSummeryDto> readFile) {
		this.readFile = readFile;
	}
}
