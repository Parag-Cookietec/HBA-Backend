package gov.ifms.common.pagination;

import gov.ifms.common.util.Constant;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The Class SearchParam.
 */
public class SearchParam {

    /**
     * The key.
     */
    private String key;

    /**
     * The value.
     */
    private String value;

    /**
     * Gets the default map.
     *
     * @param defaultmap the defaultmap
     * @return the default map
     */
    public static Map<String, Object> getDefaultMap(Map<String, String> defaultmap) {
        Map<String, Object> map = new HashMap<>();
        defaultmap.forEach((k, v) -> map.put(k, 0));
        return map;
    }

    /**
     * Creates the.
     *
     * @param key   the key
     * @param value the value
     * @return the search param
     */
    public static SearchParam create(String key, String value) {
        return new SearchParam(key, value);
    }

    /**
     * Gets the key.
     *
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key the new key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value.
     *
     * @param value the new value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Instantiates a new search param.
     *
     * @param key   the key
     * @param value the value
     */
    public SearchParam(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Instantiates a new search param.
     */
    public SearchParam() {

    }

    /**
     * Gets the map.
     *
     * @param list        the list
     * @param searchParam the search param
     * @return the map
     */
    public static Map<String, Object> getMap(List<SearchParam> list, Map<String, String> searchParam) {
        Map<String, Object> map = new LinkedHashMap<>();
        list.forEach(e -> {
            String key = searchParam.get(e.getKey());
            if (key != null) {
                map.put(key, e.getValue());
            }
        });
        return map;
    }

    /**
     * Builds the page in map.
     *
     * @param stringBuilder the string builder
     * @param pageDetail    the page detail
     * @param collect       the collect
     * @return the map
     */
    public static Map<String, Object> buildPageInMap(StringBuilder stringBuilder, PageDetails pageDetail,
                                                     Map<String, String> collect) {
        Map<String, Object> map = buildPageInMapWithOutFilter(pageDetail, stringBuilder);
        List<SearchParam> searchParams = pageDetail.getJsonArr();
        if (searchParams != null && !searchParams.isEmpty()) {
            Map<String, Object> map1 = SearchParam.getMap(searchParams, collect);
            map.putAll(map1);
        } else {
            Map<String, Object> map1 = SearchParam.getDefaultMap(collect);
            map.putAll(map1);
        }
        return map;
    }

    /**
     * Builds the page in map with out filter.
     *
     * @param pageDetail    the page detail
     * @param stringBuilder the string builder
     * @return the map
     */
    public static Map<String, Object> buildPageInMapWithOutFilter(PageDetails pageDetail, StringBuilder stringBuilder) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
        map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
        if ((stringBuilder != null) && (stringBuilder.length() > 0)) {
            map.put(Constant.IN_USER_LIST, stringBuilder.substring(0, stringBuilder.length() - 1));
        }
        return map;
    }

    @Override
    public String toString() {
        return "SearchParam{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
