/**
 * 
 */
package gov.ifms.workflow.util;

/**
 * @author Vivek
 *
 */
public enum LocationType {
	SAME_OFFICE(511),
	SAME_OFFICE_SAME_BRANCH(512),
	SAME_OFFICE_OTHER_BRANCH_TYPE(513),
	PARENT_OFFICE(514),
	PARENT_OFFICE_SAME_BRANCH(515),
	PARENT_OFFICE_OTHER_BRANCH_TYPE(516),
	CHILD_OFFICE(517),
	OTHER_OFFICE(518),
	CUSTOM(519);
	
	private int value;
	
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	private LocationType(int value) {
		this.value = value;
	}
}
