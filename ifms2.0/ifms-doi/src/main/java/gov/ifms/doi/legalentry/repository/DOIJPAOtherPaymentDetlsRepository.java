package gov.ifms.doi.legalentry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.doi.legalentry.entity.DOIJpaLegalOthrPaymentEntity;

/**
 * @author Rudra
 *
 */

@Repository
@Transactional
public interface DOIJPAOtherPaymentDetlsRepository extends JpaRepository<DOIJpaLegalOthrPaymentEntity, Long>{
	
}