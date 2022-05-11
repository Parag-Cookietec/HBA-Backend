/**
 * 
 */
package gov.ifms.workflow.util;

/**
 * @author Vivek
 *
 */
public enum SendBack {
	DEFUALT(0), PRIVIOUS(1), REWORK(-1), RETURN_ASSIGNED_TO(-2), RETURN_INITIATOR(-3);

	private int value;

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	private SendBack(int value) {
		this.value = value;
	}
}
