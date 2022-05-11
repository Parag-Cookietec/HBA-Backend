package gov.ifms.dmo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.ifms.dmo.dao.GenericDao;
import gov.ifms.dmo.entity.DMOGRFCRFInvestmentEntity;

@Repository
@Transactional
public interface DMOGRFCRFReportRepository extends GenericDao, JpaRepository<DMOGRFCRFInvestmentEntity, Long> {

}
