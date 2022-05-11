
package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocAdviceVerifyAuthSearchParam.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class LocInwardCardexSrchParamDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The div id. */
	@NativeQueryResultColumn(index = 0)
	private Long divId;

	/** The div code. */
	@NativeQueryResultColumn(index = 1)
	private String divCode;

	/** The div name. */
	@NativeQueryResultColumn(index = 2)
	private String divName;

	/** The circle id. */
	@NativeQueryResultColumn(index = 3)
	private Long circleId;

	/** The circle name. */
	@NativeQueryResultColumn(index = 4)
	private String circleName;

	/** The circle code. */
	@NativeQueryResultColumn(index = 5)
	private String circleCode;

	/** The circle code list. */
	private List<LocInwardCardexSrchParamDto> circleCodeList;

	/** The circle name list. */
	private List<LocInwardCardexSrchParamDto> circleNameList;

	/** The div code list. */
	private List<LocInwardCardexSrchParamDto> divCodeList;

	/** The div name list. */
	private List<LocInwardCardexSrchParamDto> divNameList;

	/**
	 * Gets the div id.
	 *
	 * @return the div id
	 */
	public Long getDivId() {
		return divId;
	}

	/**
	 * Sets the div id.
	 *
	 * @param divId the new div id
	 */
	public void setDivId(Long divId) {
		this.divId = divId;
	}

	/**
	 * Gets the div code.
	 *
	 * @return the div code
	 */
	public String getDivCode() {
		return divCode;
	}

	/**
	 * Sets the div code.
	 *
	 * @param divCode the new div code
	 */
	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

	/**
	 * Gets the div name.
	 *
	 * @return the div name
	 */
	public String getDivName() {
		return divName;
	}

	/**
	 * Sets the div name.
	 *
	 * @param divName the new div name
	 */
	public void setDivName(String divName) {
		this.divName = divName;
	}

	/**
	 * Gets the circle id.
	 *
	 * @return the circle id
	 */
	public Long getCircleId() {
		return circleId;
	}

	/**
	 * Sets the circle id.
	 *
	 * @param circleId the new circle id
	 */
	public void setCircleId(Long circleId) {
		this.circleId = circleId;
	}

	/**
	 * Gets the circle name.
	 *
	 * @return the circle name
	 */
	public String getCircleName() {
		return circleName;
	}

	/**
	 * Sets the circle name.
	 *
	 * @param circleName the new circle name
	 */
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	/**
	 * Gets the circle code.
	 *
	 * @return the circle code
	 */
	public String getCircleCode() {
		return circleCode;
	}

	/**
	 * Sets the circle code.
	 *
	 * @param circleCode the new circle code
	 */
	public void setCircleCode(String circleCode) {
		this.circleCode = circleCode;
	}

	/**
	 * Gets the circle code list.
	 *
	 * @return the circle code list
	 */
	public List<LocInwardCardexSrchParamDto> getCircleCodeList() {
		return circleCodeList;
	}

	/**
	 * Sets the circle code list.
	 *
	 * @param circleCodeList the new circle code list
	 */
	public void setCircleCodeList(List<LocInwardCardexSrchParamDto> circleCodeList) {
		this.circleCodeList = circleCodeList;
	}

	/**
	 * Gets the circle name list.
	 *
	 * @return the circle name list
	 */
	public List<LocInwardCardexSrchParamDto> getCircleNameList() {
		return circleNameList;
	}

	/**
	 * Sets the circle name list.
	 *
	 * @param circleNameList the new circle name list
	 */
	public void setCircleNameList(List<LocInwardCardexSrchParamDto> circleNameList) {
		this.circleNameList = circleNameList;
	}

	/**
	 * Gets the div code list.
	 *
	 * @return the div code list
	 */
	public List<LocInwardCardexSrchParamDto> getDivCodeList() {
		return divCodeList;
	}

	/**
	 * Sets the div code list.
	 *
	 * @param divCodeList the new div code list
	 */
	public void setDivCodeList(List<LocInwardCardexSrchParamDto> divCodeList) {
		this.divCodeList = divCodeList;
	}

	/**
	 * Gets the div name list.
	 *
	 * @return the div name list
	 */
	public List<LocInwardCardexSrchParamDto> getDivNameList() {
		return divNameList;
	}

	/**
	 * Sets the div name list.
	 *
	 * @param divNameList the new div name list
	 */
	public void setDivNameList(List<LocInwardCardexSrchParamDto> divNameList) {
		this.divNameList = divNameList;
	}
}
