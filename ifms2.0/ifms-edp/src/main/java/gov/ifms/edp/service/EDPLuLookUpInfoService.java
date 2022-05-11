package gov.ifms.edp.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.SearchDto;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPLuLookUpInfoDto;
import gov.ifms.edp.dto.EDPLuLookUpResponse;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

/**
 * The Interface EDPLuLookUpInfoService.
 */
public interface EDPLuLookUpInfoService {

	/**
	 * Returns all instances of the EDPLuLookUpInfoEntity type.
	 * 
	 * @return all EDPLuLookUpInfoEntity
	 */
	List<EDPLuLookUpInfoEntity> getLuLookUpInfos();

	/**
	 * Retrieves an EDPLuLookUpInfoEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPLuLookUpInfoEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	EDPLuLookUpInfoEntity getLuLookUpInfo(long id);

	/**
	 * Saves a given EDPLuLookUpInfoEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPLuLookUpInfoEntity
	 */
	EDPLuLookUpInfoEntity saveOrUpdateLuLookUpInfo(EDPLuLookUpInfoEntity entity);

	/**
	 * Saves all given EDPLuLookUpInfoEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	List<EDPLuLookUpInfoEntity> saveLuLookUpInfos(List<EDPLuLookUpInfoEntity> entities);

	/**
	 * Deletes the EDPLuLookUpInfoEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	void deleteLuLookUpInfo(long id);

	/**
	 * Fetch all the EDPLuLookUpInfo items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPLuLookUpInfoDto>
	 */
	PagebleDTO<EDPLuLookUpInfoDto> edpLuLookUpInfoAsMethodNameSearch(PageDetails pageDetail);

	/**
	 * Find by look up id.
	 *
	 * @return the list
	 */
	List<ClueDto> findByLookUpId();
	
	/**
	 * Find by look up name.
	 *
	 * @param lookUpName the look up name
	 * @return the list
	 */
	List<EDPLuLookUpInfoEntity> findByLookUpName(final String lookUpName);
	
	/**
	 * Find by edp lu look up entity look up id and active status.
	 *
	 * @param lookUpId the look up id
	 * @return the list
	 */
	List<EDPLuLookUpInfoEntity> findByEdpLuLookUpEntityLookUpIdAndActiveStatus(Long lookUpId);
	
	/**
	 * Find by look up name.
	 *
	 * @param lookUpName the look up name
	 * @param sortColumnName the sort column name
	 * @param order the order
	 * @return the list
	 */
	List<EDPLuLookUpInfoEntity> findByLookUpName(String lookUpName,String sortColumnName,int order);
	
	List<ClueDto> findIdAndNameByLookUpName(String lookupName);

	List<EDPLuLookUpResponse> getLookUpInfoByParentName(Set<String> lookTypes);
	
	/**
     * getLookUpInfoByParentLookUp
     *
     * @param lookUpName the look up name
     * @return the Map
     */
    Map<String, List<EDPLuLookUpResponse>> getLookUpInfoByParentLookUp(Set<String> lookTypes);

	List<ClueDto> getLookUpInfoByParentLookUpId(SearchDto dto);
}
