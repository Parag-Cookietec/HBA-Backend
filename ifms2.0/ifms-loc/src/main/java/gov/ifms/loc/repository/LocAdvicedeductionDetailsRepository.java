package gov.ifms.loc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.loc.entity.LocAdviceDeductionDetailsEntity;

/**
 * The Class LocAdvicedeductionDetailsController.
 * 
 * @version v 1.0
 * @created 2021/02/23 11:48:46
 */

@Repository
@Transactional
public interface LocAdvicedeductionDetailsRepository extends JpaRepository<LocAdviceDeductionDetailsEntity, Long>,
		JpaSpecificationExecutor<LocAdviceDeductionDetailsEntity> {
	/**
	 * Deletes the LocAdvicedeductionDetailsEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	LocAdviceDeductionDetailsEntity findByLcAdviceIdAndActiveStatus(Long hrdId, int activeStatus);
	
	
	@Query(value = "SELECT 	HDR.CHEQUE_AMNT AS chequeAmount ,HDR.CHEQUE_DT AS chequeDate,HDR.CHEQUE_NO AS chequeNo,	HDR.PARTY_NAME AS partyName FROM LOC.TLOC_LC_ADVICE_PARTY_SD HDR WHERE 	HDR.TLOC_ADVICE_PARTY_SD_ID = :Sdid AND HDR.ACTIVE_STATUS = :activeStatus",nativeQuery = true)
	List<Object[]> getEditViewData(@Param("Sdid") Long Sdid,
									@Param("activeStatus") int activeStatus);


}
