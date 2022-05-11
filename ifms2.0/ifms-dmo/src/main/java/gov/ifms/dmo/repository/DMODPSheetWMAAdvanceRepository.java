package gov.ifms.dmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.dmo.dao.GenericDao;
import gov.ifms.dmo.entity.DMODPSheetWMAAdvanceEntity;

@Repository
@Transactional
public interface DMODPSheetWMAAdvanceRepository extends JpaRepository<DMODPSheetWMAAdvanceEntity, Long>,
		JpaSpecificationExecutor<DMODPSheetWMAAdvanceEntity>, GenericDao {

}
