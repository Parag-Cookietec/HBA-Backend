package gov.ifms.common.scheduler.repository;

import gov.ifms.common.scheduler.entity.MsCMNSchedulerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MsCMNSchedulerRepository extends JpaRepository<MsCMNSchedulerEntity,Long>, JpaSpecificationExecutor<MsCMNSchedulerEntity> {


    List<MsCMNSchedulerEntity> findByActiveStatus(int activeStatus);


}
