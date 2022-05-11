package gov.ifms.pvu.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeFivePayDetailDto;
import gov.ifms.pvu.dto.PVUEmployePayDetailDtos;
import gov.ifms.pvu.dto.PVUEmployeSixPayDetailDto;
import gov.ifms.pvu.dto.PVUMsPayCellDto;
import gov.ifms.pvu.dto.PvuCommonRequest;
import gov.ifms.pvu.entity.PVUEmployeSixPayDetailEntity;

/**
 * The Class PVUEmployePayDetailService.
 *
 * @version v 1.0
 * @created 2019/11/26 12:51:22
 */
public interface PVUEmployePayDetailService extends PVUBaseService {
	/**
	 * Retrieves an PVUEmployePayDetailService by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployePayDetailService with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeSixPayDetailEntity getEmployeSixPayDetail(Long id);

	/**
	 * Gets the employepay details.
	 *
	 * @param id the id
	 * @return the employepay details
	 * @throws CustomException the custom exception
	 */
	public PVUEmployePayDetailDtos getEmployepayDetails(Long id) throws CustomException;

	/**
	 * Saves a given PVUEmployePayDetailService. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param pageDetail the page detail
	 * @return the saved PVUEmployePayDetailService
	 * @throws CustomException the custom exception
	 */

	/**
	 * Saves all given PVUEmployePayDetailService entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */

	/**
	 * Fetch all the PVUEmploye6PayDetail items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmploye6PayDetailDto>
	 */
	public PagebleDTO<PVUEmployeSixPayDetailDto> getEmploye6PayDetails(PageDetails pageDetail) throws CustomException;

	/**
	 * Save or update employe six pay detail.
	 *
	 * @param dto the dto
	 * @return the PVU employe pay detail dtos
	 * @throws CustomException the custom exception
	 */
	PVUEmployePayDetailDtos saveOrUpdateEmployePayDetail(PVUEmployePayDetailDtos dto) throws CustomException;

	/**
	 * Gets the seven basic.
	 *
	 * @param pvuRequest the pvu request
	 * @return the seven basic
	 * @throws CustomException the custom exception
	 */
	PVUMsPayCellDto getSevenBasic(PvuCommonRequest pvuRequest) throws CustomException;

	/**
	 * Gets the basic.
	 *
	 * @param payScale the pay scale
	 * @param empid    the empid
	 * @return the basic
	 */
	PVUEmployeFivePayDetailDto getBasic(Long payScale, long empid);

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException;

	/**
	 * Gets the seven basic by plevel and pk.
	 *
	 * @param pvuRequest the pvu request
	 * @return the seven basic by plevel and pk
	 * @throws CustomException the custom exception
	 */
	public PVUMsPayCellDto getSevenBasicByPlevelAndPk(PvuCommonRequest pvuRequest) throws CustomException;

	/**
	 * Validate pay commision.
	 *
	 * @param empId              the emp id
	 * @param eventEffectiveDate the event effective date
	 * @param comm               the comm
	 * @throws CustomException the custom exception
	 * @throws ParseException  the parse exception
	 */
	public void validatePayCommision(Long empId, Date eventEffectiveDate, Long comm, Date doj)
			throws CustomException, ParseException;
	
}
