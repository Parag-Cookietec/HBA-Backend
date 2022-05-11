package gov.ifms.common.cache.repository;

import gov.ifms.common.cache.entity.CustomEntity;
import gov.ifms.common.dao.GenericDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CacheRepository extends JpaRepository<CustomEntity,Integer> , GenericDao {

}
