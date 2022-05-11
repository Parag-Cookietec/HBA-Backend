package gov.ifms.gst.repository;

import gov.ifms.edp.dto.EDPLuLookUpResponse;
import gov.ifms.edp.dto.IdNameDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * The Interface LuLookUpInfoRepository.
 */
@Repository
@Transactional
public interface LuLookUpInfoRepository
        extends JpaRepository<EDPLuLookUpInfoEntity, Long>, JpaSpecificationExecutor<EDPLuLookUpInfoEntity> {

    /**
     * This method is used to find all look up info by look up id and active status.
     *
     * @param lookUpId     the look up id
     * @param activeStatus the active status
     * @return List of EDPLuLookUpInfoEntity
     */
    List<EDPLuLookUpInfoEntity> findByEdpLuLookUpEntityLookUpIdAndActiveStatus(Long lookUpId, int activeStatus);

    /**
     * Find bylook up info id.
     *
     * @param lookUpInfoId the look up info id
     * @return the EDP lu look up info entity
     */
    EDPLuLookUpInfoEntity findBylookUpInfoId(long lookUpInfoId);

    /**
     * Find by look up info name.
     *
     * @param lookUpInfoName the look up info name
     * @return the EDP lu look up info entity
     */
    EDPLuLookUpInfoEntity findByLookUpInfoName(String lookUpInfoName);

    /**
     * Find by look up info name in.
     *
     * @param lookUpInfoNames the look up info names
     * @return the list
     */
    List<EDPLuLookUpInfoEntity> findByLookUpInfoNameIn(Set<String> lookUpInfoNames);

    /**
     * Find by edp lu look up entity look up name and active status.
     *
     * @param lookName     the look name
     * @param activeStatus the active status
     * @return the list
     */
    List<EDPLuLookUpInfoEntity> findByEdpLuLookUpEntityLookUpNameAndActiveStatus(String lookName, int activeStatus);

    /**
     * Find by edp lu look up entity look up name and active status and look up info name.
     *
     * @param lookName       the look name
     * @param activeStatus   the active status
     * @param lookUpInfoName the look up info name
     * @return the EDP lu look up info entity
     */
    EDPLuLookUpInfoEntity findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(String lookName, int activeStatus, String lookUpInfoName);

    /**
     * Find by edp lu look up entity look up name and active status.
     *
     * @param lookName     the look name
     * @param activeStatus the active status
     * @param sort         the sort
     * @return the list
     */
    List<EDPLuLookUpInfoEntity> findByEdpLuLookUpEntityLookUpNameAndActiveStatus(String lookName, int activeStatus, Sort sort);

    /**
     * Find by look up info name in.
     *
     * @param lookUpInfoNames the look up info names
     * @return the list
     */
    List<EDPLuLookUpInfoEntity> findByLookUpInfoNameIn(List<String> lookUpInfoNames);

    /**
     * Gets the look up by parent name.
     *
     * @param lookTypes the look types
     * @return the look up by parent name
     */
    @Query(value = "SELECT new gov.ifms.edp.dto.EDPLuLookUpResponse(lu.edpLuLookUpEntity.lookUpName,lu.lookUpInfoId,lu.lookUpInfoName) from EDPLuLookUpInfoEntity lu where lu.edpLuLookUpEntity.lookUpName IN (:lookTypes) ")
    List<EDPLuLookUpResponse> getLookUpByParentName(@Param("lookTypes") Set<String> lookTypes);

    /**
     * Gets the only id and name.
     *
     * @param id the id
     * @return the only id and name
     */
    @Query(value = "SELECT new gov.ifms.edp.dto.IdNameDto(e.lookUpInfoId,e.lookUpInfoName) from EDPLuLookUpInfoEntity e where e.lookUpInfoId = :id")
    IdNameDto getOnlyIdAndName(@Param("id") Long id);

    /**
     * Find by edp lu look up entity look up name.
     *
     * @param string the string
     * @return the list
     */
    List<EDPLuLookUpInfoEntity> findByEdpLuLookUpEntityLookUpName(String string);

    /**
     * Find by look up info name and active status.
     *
     * @param lookUpInfoName the look up info name
     * @param activeStatus the active status
     * @return the EDP lu look up info entity
     */
    EDPLuLookUpInfoEntity findByLookUpInfoNameAndActiveStatus(String lookUpInfoName, int activeStatus);
    
    /**
     * Find by look up info name and active status and edp lu look up entity look up id.
     *
     * @param lookUpInfoName the look up info name
     * @param activeStatus the active status
     * @param parentId the parent id
     * @return the EDP lu look up info entity
     */
    EDPLuLookUpInfoEntity findByLookUpInfoNameAndActiveStatusAndEdpLuLookUpEntityLookUpId(String lookUpInfoName, int activeStatus, long parentId);

    /**
     * Find by look up info name and edp lu look up entity look up name and active status.
     *
     * @param lookUpInfoName the look up info name
     * @param parentLookupName the parent lookup name
     * @param activeStatus the active status
     * @return the EDP lu look up info entity
     */
    EDPLuLookUpInfoEntity findByLookUpInfoNameAndEdpLuLookUpEntityLookUpNameAndActiveStatus(String lookUpInfoName, String parentLookupName, int activeStatus);

	/**
	 * Find by look up info name and edp lu look up entity look up name.
	 *
	 * @param yes the yes
	 * @param conditionCheck the condition check
	 * @return the EDP lu look up info entity
	 */
	EDPLuLookUpInfoEntity findByLookUpInfoNameAndEdpLuLookUpEntityLookUpName(String yes, String conditionCheck);
	
    /**
     * Find by edp lu look up entity look up id and look up info value and active status.
     *
     * @param lookUpId the look up id
     * @param value the value
     * @param activeStatus the active status
     * @return the list
     */
    List<EDPLuLookUpInfoEntity> findByEdpLuLookUpEntityLookUpIdAndLookUpInfoValueInAndActiveStatus(Long lookUpId, List<Integer> value, int activeStatus);

	 /**
     * Find by edp lu look up entity look up name and active status.
     *
     * @param lookName     the look name
     * @param activeStatus the active status
     * @return the list
     */
		List<EDPLuLookUpInfoEntity> findByActiveStatusAndLookUpInfoIdIn( int activeStatus,Set<Long> lookName);
    /**
     * Find by edp lu look up entity look up name and active status and look up info name in.
     *
     * @param lookUpName the look up name
     * @param activeStatus the active status
     * @param lookUpInfoNames the look up info names
     * @return the list
     */
    List<EDPLuLookUpInfoEntity> findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoNameIn(String lookUpName, int activeStatus, Set<String> lookUpInfoNames);
    
    /**
     * Find by edp lu look up entity look up id and active status.
     *
     * @param lookUpId     the look up id
     * @param activeStatus the active status
     * @return the list
     */
	@Query("select a from EDPLuLookUpInfoEntity a where a.edpLuLookUpEntity.lookUpId=:lookUpId AND a.activeStatus=:activeStatus")
	public List<EDPLuLookUpInfoEntity> findByParentLookUp(@Param("lookUpId")Long lookUpId,@Param("activeStatus")int activeStatus);
	
	@Query("select a from EDPLuLookUpInfoEntity a where a.lookUpInfoName=:lookUpInfoName and a.edpLuLookUpEntity.lookUpName=:lookUpName AND a.activeStatus=:activeStatus")
	public EDPLuLookUpInfoEntity findByParentLookUpName(@Param("lookUpInfoName")String lookUpInfoName,@Param("lookUpName")String lookUpName,@Param("activeStatus")int activeStatus);

	List<EDPLuLookUpInfoEntity> findByLookUpInfoIdInAndEdpLuLookUpEntityLookUpId(Set<Long> statusNameList,Long parentLookupId);

    public EDPLuLookUpInfoEntity findByEdpLuLookUpEntityLookUpIdAndLookUpInfoValue(Long parentId, Integer lookupInfoValue);
}
