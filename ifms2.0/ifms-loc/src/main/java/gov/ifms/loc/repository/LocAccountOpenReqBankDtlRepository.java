package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.dto.LocBankReqDtlDto;
import gov.ifms.loc.entity.LocAccountOpenReqBankDtlEntity;

/**
 * The Class LocAccountOpenReqBankDtlController.
 * 
 * @version 1.0
 * @created 2021/01/01 18:18:37
 */

@Repository
@Transactional
public interface LocAccountOpenReqBankDtlRepository extends JpaRepository<LocAccountOpenReqBankDtlEntity, Long>,
		JpaSpecificationExecutor<LocAccountOpenReqBankDtlEntity>, GenericDao {

	/**
	 * Gets the bank req dtl by hdr id and active status.
	 *
	 * @param lcOpenReqHdrId the lc open req hdr id
	 * @param activeStatus   the active status
	 * @return the bank req dtl by hdr id and active status
	 */
	@Query(value = "SELECT sd.LC_OPEN_REQ_HDR_ID hdrId, sd.LC_OPEN_REQ_BANK_DTL_ID dtlId, sd.BANK_ID bankId, sd.BANK_REMARKS bankRemarks, mb.BANK_NAME bankName, bank.BRANCH_ADDR bankAddress, bank.BRANCH_CODE bankIfscCode,BANK.BANK_BRANCH_ID AS bankBranchId FROM LOC.TLOC_OPEN_REQ_BANK_DTL sd, LOC.TLOC_LC_OPEN_REQ_HDR hdr, MASTER_V1.MS_BANK_BRANCH bank, MASTER_V1.MS_BANK mb WHERE mb.BANK_ID = sd.BANK_ID AND bank.BANK_BRANCH_ID = sd.BANK_BRANCH_ID AND sd.LC_OPEN_REQ_HDR_ID = hdr.LC_OPEN_REQ_HDR_ID AND sd.LC_OPEN_REQ_HDR_ID =:lcOpenReqHdrId AND sd.ACTIVE_STATUS =:activeStatus", nativeQuery = true)
	public LocBankReqDtlDto getBankReqDtlByHdrIdAndActiveStatus(@Param("lcOpenReqHdrId") Long lcOpenReqHdrId,
			@Param("activeStatus") Integer activeStatus);
}
