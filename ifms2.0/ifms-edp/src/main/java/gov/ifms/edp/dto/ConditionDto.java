package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;

/**
 * The Class ConditionDto.
 */
public class ConditionDto  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The trn id. */
    private long trnId;

    /** The menu id. */
    private long menuId;
    
    /** The action id. */
    private String action;

    /** The condition. */
    private List<String> condition;

    /** The default condition. */
    private String  defaultCondition;

    /**
     * Gets the trn id.
     *
     * @return the trn id
     */
    public long getTrnId() {
        return trnId;
    }

    /**
     * Sets the trn id.
     *
     * @param trnId the new trn id
     */
    public void setTrnId(long trnId) {
        this.trnId = trnId;
    }

    /**
     * Gets the condition.
     *
     * @return the condition
     */
    public List<String> getCondition() {
        return condition;
    }

    /**
     * Sets the condition.
     *
     * @param condition the new condition
     */
    public void setCondition(List<String> condition) {
        this.condition = condition;
    }

    /**
     * Gets the default condition.
     *
     * @return the default condition
     */
    public String getDefaultCondition() {
        return defaultCondition;
    }

    /**
     * Sets the default condition.
     *
     * @param defaultCondition the new default condition
     */
    public void setDefaultCondition(String defaultCondition) {
        this.defaultCondition = defaultCondition;
    }

	/**
	 * Gets the menu id.
	 *
	 * @return the menu id
	 */
	public long getMenuId() {
		return menuId;
	}

	/**
	 * Sets the menu id.
	 *
	 * @param menuId the new menu id
	 */
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	/**
	 * Gets the action.
	 *
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * Sets the action.
	 *
	 * @param action the new action
	 */
	public void setAction(String action) {
		this.action = action;
	}

}
