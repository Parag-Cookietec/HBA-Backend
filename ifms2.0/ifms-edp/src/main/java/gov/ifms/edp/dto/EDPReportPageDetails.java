package gov.ifms.edp.dto;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import gov.ifms.edp.util.EDPReportAction;

/**
 * The Class PageDetails.
 */
public class EDPReportPageDetails {

    /**
     * The page index.
     */
    private int pageIndex;

    /**
     * The page element.
     */
    private int pageElement;

    /**
     * The json arr.
     */
    private List<EDPReportSearchParamDto> jsonArr;
    
    /** The report name. */
    @NotNull
    private Long menuId;
    
    /** The report action. */
    @NotEmpty
    private EDPReportAction reportAction;

	/**
	 * @return the pageIndex
	 */
	public int getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * @return the pageElement
	 */
	public int getPageElement() {
		return pageElement;
	}

	/**
	 * @param pageElement the pageElement to set
	 */
	public void setPageElement(int pageElement) {
		this.pageElement = pageElement;
	}

	/**
	 * @return the jsonArr
	 */
	public List<EDPReportSearchParamDto> getJsonArr() {
		return jsonArr;
	}

	/**
	 * @param jsonArr the jsonArr to set
	 */
	public void setJsonArr(List<EDPReportSearchParamDto> jsonArr) {
		this.jsonArr = jsonArr;
	}

	/**
	 * @return the menuId
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return the reportAction
	 */
	public EDPReportAction getReportAction() {
		return reportAction;
	}

	/**
	 * @param reportAction the reportAction to set
	 */
	public void setReportAction(EDPReportAction reportAction) {
		this.reportAction = reportAction;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(jsonArr, pageElement, pageIndex, reportAction, menuId);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPReportPageDetails)) {
			return false;
		}
		EDPReportPageDetails other = (EDPReportPageDetails) obj;
		return Objects.equals(jsonArr, other.jsonArr) && pageElement == other.pageElement
				&& pageIndex == other.pageIndex && reportAction == other.reportAction && menuId == other.menuId;
	}
   
}
