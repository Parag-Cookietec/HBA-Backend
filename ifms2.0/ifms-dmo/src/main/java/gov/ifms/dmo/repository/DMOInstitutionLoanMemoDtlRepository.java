package gov.ifms.dmo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.dmo.dao.GenericDao;
import gov.ifms.dmo.entity.DMOInstitutionalLoanMemoDtlEntity;

@Repository
@Transactional
public interface DMOInstitutionLoanMemoDtlRepository
		extends JpaRepository<DMOInstitutionalLoanMemoDtlEntity, Long>, GenericDao, JpaSpecificationExecutor<DMOInstitutionalLoanMemoDtlEntity> {

}
