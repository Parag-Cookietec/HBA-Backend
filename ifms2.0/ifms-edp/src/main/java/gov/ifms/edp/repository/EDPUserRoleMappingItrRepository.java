package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import gov.ifms.edp.entity.EDPUserRoleMappingItrEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

/**
 * The Interface EDPUserRoleMappingItrRepository.
 */
@Repository
@Transactional
public interface EDPUserRoleMappingItrRepository extends JpaRepository<EDPUserRoleMappingItrEntity,Long> , 
                  JpaSpecificationExecutor<EDPUserRoleMappingItrEntity> {
   
   /**
    * Deletes the EDPUserRoleMappingItrEntity with the given id.
    *
    * @param id must not be {@literal null}.
    * @param activeStatus the active status
    * @param updatedBy the updated by
    * @param updatedDate the updated date
    * @return the int
    * @throws IllegalArgumentException in case the given {@code id} is
    *                                  {@literal null}
    */              	  
  @Modifying
  @Query(value = "update EDPUserRoleMappingItrEntity set activeStatus= :activeStatus , updatedBy=:updatedBy , "
  		+ "updatedDate=:updatedDate where id = :id")
  public int deleteUserRoleMappingItr(@Param("id") long id,@Param("activeStatus") int 
		  activeStatus,@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);	
}
