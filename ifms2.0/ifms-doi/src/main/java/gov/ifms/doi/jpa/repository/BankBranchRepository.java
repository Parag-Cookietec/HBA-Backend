package gov.ifms.doi.jpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.jpa.entity.BankBranchEntity;

/**
 * 
 * @author Sagar Jadhav
 *
 */
public interface BankBranchRepository extends JpaRepository<BankBranchEntity, Long> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("select entity from BankBranchEntity entity where entity.activeStatus = 1")
	List<BankBranchEntity> getActiveBankBranchList();

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("select entity from BankBranchEntity entity where entity.activeStatus = 1 and entity.bankId= :bankId")
	List<BankBranchEntity> getActiveBankBranchListByBankId(@Param("bankId") Long bankId);

}
