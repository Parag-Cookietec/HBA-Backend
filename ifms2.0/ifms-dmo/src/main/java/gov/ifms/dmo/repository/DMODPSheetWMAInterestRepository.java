package gov.ifms.dmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.dmo.dao.GenericDao;
import gov.ifms.dmo.entity.DMODPSheetWMAInterestEntity;

@Repository
@Transactional
public interface DMODPSheetWMAInterestRepository extends JpaRepository<DMODPSheetWMAInterestEntity, Long>,
		JpaSpecificationExecutor<DMODPSheetWMAInterestEntity>, GenericDao {

}
