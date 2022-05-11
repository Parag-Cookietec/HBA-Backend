package gov.ifms.edp.report.dto;

import java.io.Serializable;

/**
 * The Class CommonReportHeaderDto.
 */
public class CommonReportHeaderDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private String header;
	
	/** The order no. */
	private Long orderNo;

	/**
	 * Instantiates a new common report header dto.
	 *
	 * @param header the header
	 * @param orderNo the order no
	 */
	public CommonReportHeaderDto(String header, Long orderNo) {
		super();
		this.header = header;
		this.orderNo = orderNo;
	}

	/**
	 * Gets the header.
	 *
	 * @return the header
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * Sets the header.
	 *
	 * @param header the new header
	 */
	public void setHeader(String header) {
		this.header = header;
	}

	/**
	 * Gets the order no.
	 *
	 * @return the order no
	 */
	public Long getOrderNo() {
		return orderNo;
	}

	/**
	 * Sets the order no.
	 *
	 * @param orderNo the new order no
	 */
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
}
