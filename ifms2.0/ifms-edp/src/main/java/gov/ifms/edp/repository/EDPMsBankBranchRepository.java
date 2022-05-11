package gov.ifms.edp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Sort;

import gov.ifms.edp.entity.EDPMsBankBranchEntity;

/**
 * The Interface EDPMsBankBranchRepository.
 */
@Repository
@Transactional
public interface EDPMsBankBranchRepository extends JpaRepository<EDPMsBankBranchEntity,Long> , 
                  JpaSpecificationExecutor<EDPMsBankBranchEntity> {

	/**
	 * Find by ifsc code and active status.
	 *
	 * @param ifscCode the ifsc code
	 * @param activeStatus the active status
	 * @return the optional
	 */
	Optional<EDPMsBankBranchEntity> findByIfscCodeAndActiveStatusAndDistrictIdAndBankIdBankId(String ifscCode, int activeStatus, Long distId, Long bankId);

	/**
	 * Find is scroll pay.
	 *
	 * @param distId the Office id
	 * @param bankId the bank id
	 * @return the list
	 */
	@Query(value = "SELECT bankoffice.MS_BANK_OFFICE_ID FROM MASTER_V1.MS_BANK_OFFICE bankoffice WHERE bankoffice.OFFICE_ID = :distId AND bankoffice.BANK_ID = :bankId AND bankoffice.ACTIVE_STATUS = 1 AND bankoffice.IS_SCROLL_APL = 2 ", nativeQuery = true)
	List<Object[]> findIsScrollPay(@Param("distId") Long distId, @Param("bankId") Long bankId);

	List<EDPMsBankBranchEntity> findByActiveStatus(int activeStatus, Sort sort);
	
}
