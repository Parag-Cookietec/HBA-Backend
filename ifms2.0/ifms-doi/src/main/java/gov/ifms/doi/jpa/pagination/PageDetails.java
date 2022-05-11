package gov.ifms.doi.jpa.pagination;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class PageDetails.
 */
public class PageDetails {

    /**
     * The page index.
     */
    private int pageIndex;

    /**
     * The page element.
     */
    private int pageElement;

    /**
     * The sort by column.
     */
    private String sortByColumn;

    /**
     * The sort order.
     */
    private String sortOrder;

    /**
     * The json arr.
     */
    private List<SearchParam> jsonArr;
    
    
    
    
    


	/**
     * Gets the page index.
     *
     * @return the page index
     */
    public int getPageIndex() {
        return pageIndex;
    }

    /**
     * Sets the page index.
     *
     * @param pageIndex the new page index
     */
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * Gets the page element.
     *
     * @return the page element
     */
    public int getPageElement() {
        return pageElement;
    }

    /**
     * Sets the page element.
     *
     * @param pageElement the new page element
     */
    public void setPageElement(int pageElement) {
        this.pageElement = pageElement;
    }

    /**
     * Gets the sort by column.
     *
     * @return the sort by column
     */
    public String getSortByColumn() {
        return sortByColumn;
    }

    /**
     * Sets the sort by column.
     *
     * @param sortByColumn the new sort by column
     */
    public void setSortByColumn(String sortByColumn) {
        this.sortByColumn = sortByColumn;
    }

    /**
     * Gets the sort order.
     *
     * @return the sort order
     */
    public String getSortOrder() {
        return sortOrder;
    }

    /**
     * Sets the sort order.
     *
     * @param sortOrder the new sort order
     */
    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }


    /**
     * Gets the json arr.
     *
     * @return the json arr
     */
    public List<SearchParam> getJsonArr() {
        return jsonArr;
    }

    /**
     * Sets the json arr.
     *
     * @param jsonArr the new json arr
     */
    public void setJsonArr(List<SearchParam> jsonArr) {
        this.jsonArr = jsonArr;
    }

    /**
     * Gets the page details.
     *
     * @param pageDetail the page detail
     * @return the page details
     */
    public PageRequest getPageDetails(PageDetails pageDetail) {
        PageRequest pageable = null;
        if (StringUtils.hasLength(this.sortByColumn) && StringUtils.hasLength(this.sortOrder)) {
            if (sortOrder.equalsIgnoreCase("ASC")) {
                pageable = PageRequest.of(pageIndex, pageElement, Direction.ASC, (sortByColumn));
            } else {
                pageable = PageRequest.of(pageIndex, pageElement, Direction.DESC, sortByColumn);
            }
        } else {
            pageable = PageRequest.of(pageIndex, pageElement);
        }
        return pageable;
    }

    @Override
    public String toString() {
        return "PageDetails{" + "pageIndex=" + pageIndex +
                ", pageElement=" + pageElement +
                ", sortByColumn='" + sortByColumn + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                ", jsonArr=" + jsonArr +
                '}';
    }

    @JsonIgnore
    public static PageDetails createSingleRecordObj() {
        PageDetails obj = new PageDetails();
        obj.setPageIndex(0);
        obj.setPageElement(1);
        obj.setJsonArr(new ArrayList<>());
        return obj;
    }

    @JsonIgnore
    public static String getValue(PageDetails details, String key) {
        return details.getJsonArr().stream().filter(e -> e.getKey().equalsIgnoreCase(key)).map(SearchParam::getValue).findFirst().orElse(null);
    }

}
