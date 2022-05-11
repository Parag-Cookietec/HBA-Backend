package gov.ifms.gst.dto;

import java.util.ArrayList;
import java.util.List;

public class ListingDto<T> {
	/** The size. */
	private int size;
	
	/** The total element. */
	private long totalElement;
	
	private List<T> result = new ArrayList<>() ;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public long getTotalElement() {
		return totalElement;
	}

	public void setTotalElement(long totalElement) {
		this.totalElement = totalElement;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public ListingDto(int size, long totalElement, List<T> result) {
		this.size = size;
		this.totalElement = totalElement;
		this.result = result;
	}
	
	
}
