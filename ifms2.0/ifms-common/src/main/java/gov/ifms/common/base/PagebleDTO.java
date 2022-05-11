package gov.ifms.common.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class PagebleDTO.
 */
public class PagebleDTO<T> {
	
	
	
	/** The size. */
	private int size;
	
	/** The total page. */
	private int totalPage;
	
	/** The total element. */
	private long totalElement;
	
	/** The grand total required in Budget. */
	private BigDecimal grandTotal;
	
	/**
	 * @return the grandTotal
	 */
	public BigDecimal getGrandTotal() {
		return grandTotal;
	}

	/**
	 * @param grandTotal the grandTotal to set
	 */
	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}

	/** The result. */
	private List<T> result = new ArrayList<>();

	/**
	 * Gets the total page.
	 *
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * Sets the total page.
	 *
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Sets the size.
	 *
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Gets the total element.
	 *
	 * @return the totalElement
	 */
	public long getTotalElement() {
		return totalElement;
	}

	/**
	 * Sets the total element.
	 *
	 * @param totalElement the totalElement to set
	 */
	public void setTotalElement(long totalElement) {
		this.totalElement = totalElement;
	}

	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public List<T> getResult() {
		return result;
	}

	/**
	 * Sets the result.
	 *
	 * @param result the result to set
	 */
	public void setResult(List<T> result) {
		this.result = result;
	}

	/**
	 * Instantiates a new pageble DTO.
	 *
	 * @param size the size
	 * @param totalPage the total page
	 * @param totalElement the total element
	 * @param result the result
	 */
	public PagebleDTO(int size, int totalPage, long totalElement, List<T> result) {
		this.size = size;
		this.totalPage = totalPage;
		this.totalElement = totalElement;
		this.result = result;
	}
	
	/**
	 * Instantiates a new pageble DTO.
	 *
	 * @param size the size
	 * @param totalPage the total page
	 * @param totalElement the total element
	 * @param result the result
	 * @param grandTotal;
	 */
	public PagebleDTO(int size, int totalPage, long totalElement, List<T> result, BigDecimal grandTotal) {
		this.size = size;
		this.totalPage = totalPage;
		this.totalElement = totalElement;
		this.result = result;
		this.grandTotal = grandTotal;
	}
	
	public PagebleDTO(List<T> result) {
		this.result = result;
	}

}
