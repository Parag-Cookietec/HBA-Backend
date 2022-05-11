package gov.ifms.dmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.dmo.dao.GenericDao;
import gov.ifms.dmo.entity.DMODPSheetT14BILLMatureEntity;

@Repository
@Transactional
public interface DMODPSheetT14BILLMatureRepository extends JpaRepository<DMODPSheetT14BILLMatureEntity, Long>,
		JpaSpecificationExecutor<DMODPSheetT14BILLMatureEntity>, GenericDao {

}
