package gov.ifms.doi.jpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import gov.ifms.doi.jpa.entity.BankEntity;

/**
 * 
 * @author Sagar Jadhav
 *
 */
public interface BankRepository extends JpaRepository<BankEntity, Long> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("select entity from BankEntity entity where entity.activeStatus = 1")
	List<BankEntity> getActiveBankList();

}
