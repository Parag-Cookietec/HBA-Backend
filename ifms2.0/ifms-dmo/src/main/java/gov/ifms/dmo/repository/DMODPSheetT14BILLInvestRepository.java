package gov.ifms.dmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.dmo.dao.GenericDao;
import gov.ifms.dmo.entity.DMODPSheetT14BILLInvestEntity;

@Repository
@Transactional
public interface DMODPSheetT14BILLInvestRepository extends JpaRepository<DMODPSheetT14BILLInvestEntity, Long>,
		JpaSpecificationExecutor<DMODPSheetT14BILLInvestEntity>, GenericDao {

}
