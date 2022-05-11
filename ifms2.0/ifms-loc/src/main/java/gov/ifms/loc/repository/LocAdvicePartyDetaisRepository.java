package gov.ifms.loc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.loc.dto.LocAdvicePrepDtlDto;
import gov.ifms.loc.entity.LocAdvicePartyDetailsEntity;

/**
 * The Class locLocAdvicePartyDetaisController.
 * 
 * @version v 1.0
 * @created 2021/02/23 14:53:51
 */

@Repository
@Transactional
public interface LocAdvicePartyDetaisRepository extends JpaRepository<LocAdvicePartyDetailsEntity, Long>,
		JpaSpecificationExecutor<LocAdvicePartyDetailsEntity> {

	/**
	 * Gets the advice prep hdr dto by hdr id and active status.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @return the advice prep hdr dto by hdr id and active status
	 */
	@Query(value = "SELECT 	HDR.CHEQUE_AMNT AS chequeAmount ,HDR.CHEQUE_DT AS chequeDate,HDR.CHEQUE_NO AS chequeNo,	HDR.PARTY_NAME AS partyName FROM LOC.TLOC_LC_ADVICE_PARTY_SD HDR WHERE 	HDR.TLOC_ADVICE_PARTY_SD_ID = :Sdid AND HDR.ACTIVE_STATUS = :activeStatus", nativeQuery = true)
	public LocAdvicePrepDtlDto getAdvicePrepHdrDtoByHdrIdAndActiveStatus(@Param("Sdid") Long Sdid,
			@Param("activeStatus") Integer activeStatus);

}
