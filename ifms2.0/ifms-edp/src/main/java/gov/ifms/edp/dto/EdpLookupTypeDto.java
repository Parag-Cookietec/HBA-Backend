/**
 * 
 */
package gov.ifms.edp.dto;

import java.util.Objects;
import java.util.Set;

/**
 * The Class EdpLookupTypeDto.
 *
 * @author HP
 */
public class EdpLookupTypeDto {

	
	/** The lookup types. */
	private Set<String>lookupTypes;
	
	/**
	 * Gets the lookup types.
	 *
	 * @return the lookup types
	 */
	public Set<String> getLookupTypes() {
		return lookupTypes;
	}
	
	/**
	 * Sets the lookup types.
	 *
	 * @param lookupTypes the new lookup types
	 */
	public void setLookupTypes(Set<String> lookupTypes) {
		this.lookupTypes = lookupTypes;
	}
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lookupTypes);
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
		if (!(obj instanceof EdpLookupTypeDto)) {
			return false;
		}
		EdpLookupTypeDto other = (EdpLookupTypeDto) obj;
		return Objects.equals(lookupTypes, other.lookupTypes);
	}
	
}
