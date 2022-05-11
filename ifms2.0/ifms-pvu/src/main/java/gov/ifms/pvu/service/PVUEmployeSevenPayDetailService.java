package gov.ifms.pvu.service;

import java.util.Optional;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUCommonResponse;
import gov.ifms.pvu.dto.PVUEmployeSevenPayDetailDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeSevenPayDetailEntity;

/**
 * The Class PVUEmployeSevenPayDetailService.
 * 
 * @version v 1.0
 * @created 2019/11/26 14:21:09
 *
 */
public interface PVUEmployeSevenPayDetailService extends PVUBaseService {
	/**
	 * Retrieves an PVUEmploye7PayDetailEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmploye7PayDetailEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeSevenPayDetailEntity getEmploye7PayDetail(Long id);

	/**
	 * Saves a given PVUEmploye7PayDetailEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmploye7PayDetailEntity
	 */
	public PVUEmployeSevenPayDetailEntity saveOrUpdateEmploye7PayDetail(PVUEmployeSevenPayDetailEntity entity);


	/**
	 * Fetch all the PVUEmploye7PayDetail items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmploye7PayDetailDto>
	 */
	public PagebleDTO<PVUEmployeSevenPayDetailDto> getEmploye7PayDetails(PageDetails pageDetail) throws CustomException;

	PVUEmployeSevenPayDetailDto getEmpByEmpId(Long id) throws CustomException;

	public Optional<PVUEmployeSevenPayDetailEntity> getEmployee7PayDetails(PVUEmployeEntity employeeEntity);
}
