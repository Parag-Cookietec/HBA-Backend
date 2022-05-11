package gov.ifms.dmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.dmo.entity.DMOGRFCRFAccountEntity;

@Repository
@Transactional
public interface DMOGRFCRFAccountRepository extends JpaRepository<DMOGRFCRFAccountEntity, Long> {

}
