package gov.ifms.edp.report.dto;

import java.io.Serializable;
import java.util.Map;

import javax.validation.constraints.NotEmpty;

import gov.ifms.edp.report.util.CommonReportAction;

/**
 * The Class CommonReportViewPageDetails.
 */
public class CommonReportViewPageDetails implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1l;
	
	/** The page index. */
	private Integer pageIndex;
	
	/** The page element. */
	private Integer pageElement;
	
	/** The alias. */
	private String alias;
	
	/** The report action. */
	@NotEmpty
	private CommonReportAction reportAction;
	
	/** The map. */
	private transient Map<String, Object> map;

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
	 * Gets the map.
	 *
	 * @return the map
	 */
	public Map<String, Object> getMap() {
		return map;
	}

	/**
	 * Sets the map.
	 *
	 * @param map the map
	 */
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
}
