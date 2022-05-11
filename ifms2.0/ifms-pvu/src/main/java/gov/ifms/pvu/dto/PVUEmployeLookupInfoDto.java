package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.edp.dto.BaseDto;
import gov.ifms.edp.dto.EDPLuLookUpInfoDto;

/**
 * The Class PVUEmployeLookupInfoDto.
 * 
 * @version v 1.0
 * @created 2019/11/22 03:23:32
 *
 */
public class PVUEmployeLookupInfoDto extends BaseDto implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	private EDPLuLookUpInfoDto salutation;

	private EDPLuLookUpInfoDto salutationEntity;

	/**
	 * @return the salutation
	 */
	public EDPLuLookUpInfoDto getSalutation() {
		return salutation;
	}

	/**
	 * @param salutation the salutation to set
	 */
	public void setSalutation(EDPLuLookUpInfoDto salutation) {
		this.salutation = salutation;
	}

	/**
	 * @return the salutationEntity
	 */
	public EDPLuLookUpInfoDto getSalutationEntity() {
		return salutationEntity;
	}

	/**
	 * @param salutationEntity the salutationEntity to set
	 */
	public void setSalutationEntity(EDPLuLookUpInfoDto salutationEntity) {
		this.salutationEntity = salutationEntity;
	}

}
