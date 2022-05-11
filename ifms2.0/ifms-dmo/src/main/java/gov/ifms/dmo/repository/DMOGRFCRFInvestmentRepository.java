package gov.ifms.dmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.dmo.entity.DMOGRFCRFInvestmentEntity;

@Repository
@Transactional
public interface DMOGRFCRFInvestmentRepository
		extends JpaRepository<DMOGRFCRFInvestmentEntity, Long>, JpaSpecificationExecutor<DMOGRFCRFInvestmentEntity> {

}
