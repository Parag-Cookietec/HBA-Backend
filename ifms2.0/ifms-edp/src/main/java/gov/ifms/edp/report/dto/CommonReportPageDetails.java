package gov.ifms.edp.report.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import gov.ifms.edp.report.util.CommonReportAction;

/**
 * The Class CommonReportPageDetails.
 */
public class CommonReportPageDetails implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1l;
	
	/** The page index. */
	private Integer pageIndex;
	
	/** The page element. */
	private Integer pageElement;
	
	/** The menu id. */
	@NotNull
	private Long menuId;
	
	/** The alias. */
	private String alias;
	
	/** The report action. */
	@NotEmpty
	private CommonReportAction reportAction;
	
	/** The json arr. */
	private List<CommonReportSearchParamDto> jsonArr;

	/**
	 * Gets the page index.
	 *
	 * @return the page index
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}

	/**
	 * Sets the page index.
	 *
	 * @param pageIndex the new page index
	 */
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * Gets the page element.
	 *
	 * @return the page element
	 */
	public Integer getPageElement() {
		return pageElement;
	}

	/**
	 * Sets the page element.
	 *
	 * @param pageElement the new page element
	 */
	public void setPageElement(Integer pageElement) {
		this.pageElement = pageElement;
	}

	/**
	 * Gets the menu id.
	 *
	 * @return the menu id
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * Sets the menu id.
	 *
	 * @param menuId the new menu id
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * Gets the alias.
	 *
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * Sets the alias.
	 *
	 * @param alias the new alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * Gets the report action.
	 *
	 * @return the report action
	 */
	public CommonReportAction getReportAction() {
		return reportAction;
	}

	/**
	 * Sets the report action.
	 *
	 * @param reportAction the new report action
	 */
	public void setReportAction(CommonReportAction reportAction) {
		this.reportAction = reportAction;
	}

	/**
	 * Gets the json arr.
	 *
	 * @return the json arr
	 */
	public List<CommonReportSearchParamDto> getJsonArr() {
		return jsonArr;
	}

	/**
	 * Sets the json arr.
	 *
	 * @param jsonArr the new json arr
	 */
	public void setJsonArr(List<CommonReportSearchParamDto> jsonArr) {
		this.jsonArr = jsonArr;
	}
	
}
