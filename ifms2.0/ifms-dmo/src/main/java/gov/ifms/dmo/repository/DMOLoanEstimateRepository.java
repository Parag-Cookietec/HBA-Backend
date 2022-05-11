package gov.ifms.dmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.dmo.entity.DMOLoanEstimateEntity;
@Repository
public interface DMOLoanEstimateRepository  extends JpaRepository<DMOLoanEstimateEntity, Long>,JpaSpecificationExecutor<DMOLoanEstimateEntity>{

}
