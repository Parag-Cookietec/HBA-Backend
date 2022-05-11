package gov.ifms.pvu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.entity.PVUMsEventEntity;

/**
 * The Class PVUMsEventRepository.
 */

@Repository
@Transactional
public interface PVUMsEventRepository extends JpaRepository<PVUMsEventEntity, Long> {

    List<PVUMsEventEntity> findAllByActiveStatus(int activeStatus);

    List<PVUMsEventEntity> findAllByScreenTypeAndActiveStatus(int screenType, int activeStatus);
    
    Optional<PVUMsEventEntity> findByEventCode(String eventCode);
}
