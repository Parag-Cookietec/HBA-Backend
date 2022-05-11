/**
 * 
 */
package gov.ifms.doi.legalentry.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Rudra
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DOIJPALegalDetailEntryDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 816478610896162678L;

	private long legalEntryId;
	
	private long inwardNo;
	
	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date inwardDt;
	
	private long jpaClaimId;
	
	private String referenceNo;
	
	@JsonFormat(pattern="dd-MMM-yyyy")
	private Timestamp referenceDt;

	private List<DOIJpaLegalDtlDTO> jpaLegalDtlDTO;
	
	/**
	 * 
	 */
	public DOIJPALegalDetailEntryDTO() {
		super();
	}

	/**
	 * @return the legalEntryId
	 */
	public long getLegalEntryId() {
		return legalEntryId;
	}

	/**
	 * @param legalEntryId the legalEntryId to set
	 */
	public void setLegalEntryId(long legalEntryId) {
		this.legalEntryId = legalEntryId;
	}

	/**
	 * @return the inwardNo
	 */
	public long getInwardNo() {
		return inwardNo;
	}

	/**
	 * @param inwardNo the inwardNo to set
	 */
	public void setInwardNo(long inwardNo) {
		this.inwardNo = inwardNo;
	}

	/**
	 * @return the inwardDt
	 */
	public Date getInwardDt() {
		return inwardDt;
	}

	/**
	 * @param inwardDt the inwardDt to set
	 */
	public void setInwardDt(Date inwardDt) {
		this.inwardDt = inwardDt;
	}

	/**
	 * @return the jpaClaimId
	 */
	public long getJpaClaimId() {
		return jpaClaimId;
	}

	/**
	 * @param jpaClaimId the jpaClaimId to set
	 */
	public void setJpaClaimId(long jpaClaimId) {
		this.jpaClaimId = jpaClaimId;
	}

	/**
	 * @return the referenceNo
	 */
	public String getReferenceNo() {
		return referenceNo;
	}

	/**
	 * @param referenceNo the referenceNo to set
	 */
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	/**
	 * @return the referenceDt
	 */
	public Timestamp getReferenceDt() {
		return referenceDt;
	}

	/**
	 * @param referenceDt the referenceDt to set
	 */
	public void setReferenceDt(Timestamp referenceDt) {
		this.referenceDt = referenceDt;
	}

	/**
	 * @return the jpaLegalDtlDTO
	 */
	public List<DOIJpaLegalDtlDTO> getJpaLegalDtlDTO() {
		return jpaLegalDtlDTO;
	}

	/**
	 * @param jpaLegalDtlDTO the jpaLegalDtlDTO to set
	 */
	public void setJpaLegalDtlDTO(List<DOIJpaLegalDtlDTO> jpaLegalDtlDTO) {
		this.jpaLegalDtlDTO = jpaLegalDtlDTO;
	}

}
