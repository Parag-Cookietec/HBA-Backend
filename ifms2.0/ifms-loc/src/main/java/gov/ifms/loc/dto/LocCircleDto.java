package gov.ifms.loc.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocCircleDto
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class LocCircleDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The circle id. */
	@NativeQueryResultColumn(index = 0)
	private long circleId;

	/** The circle code. */
	@NativeQueryResultColumn(index = 1)
	private String circleCode;

	/** The circle name. */
	@NativeQueryResultColumn(index = 2)
	private String circleName;

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "LocCircleDto [circleId=" + circleId + ", circleCode=" + circleCode + ", circleName=" + circleName + "]";
	}

	/**
	 * Instantiates a new loc circle dto.
	 */
	public LocCircleDto() {
		super();
	}

	/**
	 * @param circleId
	 * @param circleName
	 */
	public LocCircleDto(long circleId, String circleName) {
		super();
		this.circleId = circleId;
		this.circleName = circleName;
	}

	/**
	 * @return the circleId
	 */
	public long getCircleId() {
		return circleId;
	}

	/**
	 * @param circleId the circleId to set
	 */
	public void setCircleId(long circleId) {
		this.circleId = circleId;
	}

	/**
	 * @return the circleCode
	 */
	public String getCircleCode() {
		return circleCode;
	}

	/**
	 * @param circleCode the circleCode to set
	 */
	public void setCircleCode(String circleCode) {
		this.circleCode = circleCode;
	}

	/**
	 * @return the circleName
	 */
	public String getCircleName() {
		return circleName;
	}

	/**
	 * @param circleName the circleName to set
	 */
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

}
