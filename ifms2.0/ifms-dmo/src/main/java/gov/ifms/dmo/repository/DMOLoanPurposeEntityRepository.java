package gov.ifms.dmo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.dmo.dao.GenericDao;
import gov.ifms.dmo.entity.DMOLoanPurposeEntity;

@Repository
@Transactional
public interface DMOLoanPurposeEntityRepository
		extends JpaRepository<DMOLoanPurposeEntity, Long>, GenericDao, JpaSpecificationExecutor<DMOLoanPurposeEntity> {

	List<DMOLoanPurposeEntity> findByActiveStatusEqualsOrderByLoanPurposeAsc(int i);

}
