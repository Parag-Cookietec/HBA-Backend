package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.loc.dto.LocBankReqDtlDto;
import gov.ifms.loc.entity.LocAccountOpenReqBankSdEntity;

/**
 * The Class LocAccountOpenReqBankSdController.
 * 
 * @version 1.0
 * @created 2021/01/01 16:35:39
 */

@Repository
@Transactional
public interface LocAccountOpenReqBankSdRepository extends JpaRepository<LocAccountOpenReqBankSdEntity, Long>,
		JpaSpecificationExecutor<LocAccountOpenReqBankSdEntity> {

	/**
	 * Gets the bank req dtl by hdr id and active status.
	 *
	 * @param lcOpenReqHdrId the lc open req hdr id
	 * @param activeStatus   the active status
	 * @return the bank req dtl by hdr id and active status
	 */
	@Query(value = "SELECT sd.LC_OPEN_REQ_HDR_ID hdrId, sd.LC_OPEN_REQ_BANK_SD_ID dtlId, sd.BANK_ID bankId, sd.BANK_REMARKS bankRemarks, mb.BANK_NAME bankName, bank.BRANCH_ADDR bankAddress, bank.BRANCH_CODE bankIfscCode,BANK.BANK_BRANCH_ID AS bankBranchId  FROM LOC.TLOC_OPEN_REQ_BANK_SD sd, LOC.TLOC_LC_OPEN_REQ_HDR hdr, MASTER_V1.MS_BANK_BRANCH bank, MASTER_V1.MS_BANK mb WHERE mb.BANK_ID = sd.BANK_ID AND bank.BANK_BRANCH_ID = sd.BANK_BRANCH_ID  AND sd.LC_OPEN_REQ_HDR_ID = hdr.LC_OPEN_REQ_HDR_ID AND sd.LC_OPEN_REQ_HDR_ID =:lcOpenReqHdrId AND sd.ACTIVE_STATUS =:activeStatus", nativeQuery = true)
	public LocBankReqDtlDto getBankReqDtlByHdrIdAndActiveStatus(@Param("lcOpenReqHdrId") Long lcOpenReqHdrId,
			@Param("activeStatus") Integer activeStatus);

	/**
	 * Find by hdr id and active status.
	 *
	 * @param lcOpenReqHdrId the lc open req hdr id
	 * @param activeStatus   the active status
	 * @return the loc account open req bank sd entity
	 */
	public LocAccountOpenReqBankSdEntity findByLcOpenReqHdrIdLcOpenReqHdrIdAndActiveStatus(Long lcOpenReqHdrId,
			int activeStatus);

	/**
	 * Update account open req bank sd.
	 *
	 * @param hdrId        the hdr id
	 * @param activeStatus the active status
	 * @param bankCode     the bank code
	 * @param bankBranchId the bank branch id
	 * @param bankRemarks  the bank remarks
	 */
	@Modifying
	@Query(value = "Update LOC.TLOC_OPEN_REQ_BANK_SD SD set SD.BANK_CODE=:bankCode, SD.BANK_BRANCH_ID=:bankBranchId, SD.BANK_REMARKS=:bankRemarks"
			+ " where SD.LC_OPEN_REQ_HDR_ID=:hdrId and SD.ACTIVE_STATUS=:activeStatus", nativeQuery = true)
	public void updateAccountOpenReqBankSd(@Param("hdrId") Long hdrId, @Param("activeStatus") int activeStatus,
			@Param("bankCode") Long bankCode, @Param("bankBranchId") Long bankBranchId,
			@Param("bankRemarks") String bankRemarks);
}
