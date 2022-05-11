package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPIdDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPOffTypeAndSubTypeDto;
import gov.ifms.edp.dto.EDPOfficeDetailsDto;
import gov.ifms.edp.dto.EDPOfficeDivisionDto;
import gov.ifms.edp.dto.EDPOfficeDto;
import gov.ifms.edp.dto.EDPOfficeHistoryReportView;
import gov.ifms.edp.dto.EDPWorkflowStatusDto;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPUpdateOfficeTrnEntity;

/**
 * The Interface EDPMsOfficeService.
 */
public interface EDPMsOfficeService {

	/**
	 * Returns all instances of the EDPMsOfficeEntity type.
	 * 
	 * @return all EDPMsOfficeEntity
	 */
	List<EDPMsOfficeEntity> getMsOffices();

	/**
	 * Retrieves an EDPMsOfficeEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsOfficeEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	EDPMsOfficeDto getMsOffice(Long id);

	/**
	 * Saves a given EDPMsOfficeEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity   the entity
	 * @param isCreate the is create
	 * @param isUpdate the is update
	 * @param dto      the dto
	 * @return the saved EDPMsOfficeEntity
	 * @throws CustomException the custom exception
	 */
	EDPMsOfficeEntity saveOrUpdateMsOffice(EDPMsOfficeEntity entity, boolean isCreate, boolean isUpdate,
			EDPMsOfficeDto dto) throws CustomException;

	/**
	 * Saves all given EDPMsOfficeEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	List<EDPMsOfficeEntity> saveMsOffices(List<EDPMsOfficeEntity> entities);

	/**
	 * Deletes the EDPMsOfficeEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	void deleteMsOffice(Long id);

	/**
	 * Fetch all the EDPMsOffice items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsOfficeDto>
	 * @throws SecurityException the security exception
	 */
	PagebleDTO<EDPMsOfficeDto> edpMsOfficeAsMethodNameSearch(PageDetails pageDetail);

	/**
	 * This method is used to find office by post id.
	 *
	 * @param userId the user id
	 * @param postId the post id
	 * @return List of ClueDto
	 */
	List<ClueDto> findOfficeByPostId(Long userId, Long postId);

	/**
	 * This method is used to find office by id.
	 *
	 * @param userId   the user id
	 * @param postId   the post id
	 * @param officeId the office id
	 * @return List of ClueDto
	 */
	List<ClueDto> findOfficeById(Long userId, Long postId, Long officeId);

	/**
	 * Find id code estimation from.
	 *
	 * @return the list
	 */
	List<ClueDto> findIdCodeEstimationFrom();

	/**
	 * Find office details.
	 *
	 * @return the list
	 */

	EDPOfficeDetailsDto getOfficeDetails();

	/**
	 * Update active status.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @return true, if successful
	 * @throws CustomException the custom exception
	 */
	void updateActiveStatus(Long id, int activeStatus) throws CustomException;

	/**
	 * Gets the next cardex no.
	 *
	 * @param districtId the district id
	 * @return the next cardex no
	 */
	ClueDto getNextCardexNo(Long districtId);

	/**
	 * Gets the district wise office details.
	 *
	 * @return the district wise office details
	 */
	List<ClueDto> getDistrictWiseOfficeDetails();

	/**
	 * Gets the all departments with hod.
	 *
	 * @return the all code and id
	 * @throws CustomException the custom exception
	 */
	List<ClueDto> getAllDepartmentsWithHod() throws CustomException;

	/**
	 * Search for office history report.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<EDPOfficeHistoryReportView> searchForOfficeHistoryReport(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the office by district and pvu id.
	 *
	 * @param officeDto the office dto
	 * @return the office by district and pvu id
	 */
	List<ClueDto> getOfficeByDistrictAndPvuId(EDPMsOfficeDto officeDto);

	/**
	 * Gets the offices by district.
	 *
	 * @param distId the dist id
	 * @return the offices by district
	 */
	List<EDPMsOfficeDto> getOfficesByDistrict(Long distId);

	/**
	 * Gets the by office type.
	 *
	 * @param officeType the office type
	 * @return the by office type
	 */
	List<EDPMsOfficeDto> getByOfficeType(String officeType);

	/**
	 * Gets the parent office.
	 *
	 * @param officeId the office id
	 * @return the parent office
	 */
	EDPMsOfficeDto getParentOffice(Long officeId);

	/**
	 * Gets the child office list.
	 *
	 * @param officeId the office id
	 * @return the child office list
	 */
	List<EDPMsOfficeDto> getChildOfficeList(Long officeId);

	/**
	 * Gets the HOD list basedon department office.
	 *
	 * @param officeId the office id
	 * @return the HOD list basedon department office
	 */
	List<EDPMsOfficeDto> getHODListBasedonDepartmentOffice(Long officeId);

	/**
	 * Gets the CO list by hod office id.
	 *
	 * @param officeId the office id
	 * @return the CO list by hod office id
	 */
	List<EDPMsOfficeDto> getCOListByHodOfficeId(Long officeId);

	/**
	 * Gets the offices by flag list.
	 *
	 * @param names the names
	 * @return the offices by flag list
	 */
	EDPOfficeDivisionDto getOfficesByFlagList(List<ClueDto> names);

	/**
	 * Gets the by office type by office type id.
	 *
	 * @param id the id
	 * @return the by office type by office type id
	 */
	List<EDPMsOfficeDto>  getByOfficeTypeByOfficeTypeId(Long id);
	
	 /**
 	 * Gets the fd office.
 	 *
 	 * @return the fd office
 	 */
 	public List<EDPMsOfficeDto> getFdOffice();

 	/**
	  * Checks whether workflow is required.
	  *
	  * @param menuId the menu id
	  * @return Boolean
	  */
	Boolean isWorkflowRequired(Long menuId);

	/**
	 * Saves a given EDPMsOfficeEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param officeEntity the office entity
	 * @param isCreate     the is create
	 * @param isUpdate     the is update
	 * @param dto          the dto
	 * @return the saved EDPMsOfficeEntity
	 * @throws CustomException the custom exception
	 */
	EDPMsOfficeEntity saveAsDraftMsOffice(EDPMsOfficeEntity officeEntity, boolean isCreate, boolean isUpdate,
			EDPMsOfficeDto dto) throws CustomException;


	/**
	 * Gets the offices and status by district.
	 *
	 * @param districtId the district id
	 * @param ddoNo the ddo no
	 * @param cardexNo the cardex no
	 * @param office the office
	 * @return the offices and status by district
	 * @throws CustomException the custom exception
	 */
	List<EDPOfficeDto> getOfficesAndStatusByDistrict(Long districtId, String ddoNo, Long cardexNo, String office)
			throws CustomException;

	/**
	 * Check for Workflow status
	 * 
	 * @param dto
	 * @return 
	 * @throws CustomException 
	 */
	List<EDPWorkflowStatusDto> checkWfStatus(EDPIdDto dto) throws CustomException;

	String getWfInitErrorMessage(EDPWorkflowStatusDto dto);
	
	public boolean checkDdoNoByDistrictId(Long districtId, String ddoNo);

	/**
	 * Update Ms Office
	 * 
	 * @param dto
	 * @return EDPMsOfficeEntity
	 * @throws CustomException 
	 */
	EDPMsOfficeEntity updateMsOffice(EDPMsOfficeDto dto) throws CustomException;

	/**
	 * Gets the bills by office id.
	 *
	 * @param id the id
	 * @return the bills by office id
	 */
	List<ClueDto> getBillsByOfficeId(Long id);

	/**
	 * Approve Update Office Request
	 * 
	 * @param dto
	 * @throws CustomException 
	 */
	void approveOfficeUpdate(EDPMsOfficeDto dto) throws CustomException;

	/**
	 * Get Master Office details.
	 * 
	 * @param id
	 * @return EDPMsOfficeDto
	 */
	EDPMsOfficeDto getMasterOfficeDetails(Long id);
	
	/**
	 * Gets the last office trn.
	 *
	 * @param officeId the office id
	 * @param activeStatus the active status
	 * @return the last office trn
	 */
	public EDPUpdateOfficeTrnEntity getLastOfficeTrn(Long officeId, int activeStatus);

	public List<EDPMsOfficeDto> getTrsPaoOffices(IdDto idDto);

	public boolean validateCardexNo(Long cardexNo);

	public List<EDPMsOfficeDto>  getBillSubmitToByOffice(Long officeId);

	public List<EDPMsOfficeDto>  getTreasuryOfficeByDistrictId(Long districtId);
	
	/**
	 * Gets the by office type by office type id.
	 *
	 * @param dto the id
	 * @return the by office type by office type id
	 */
	List<EDPMsOfficeDto>  getOfficeByOfficeTypeAndSubOfficeType(EDPOffTypeAndSubTypeDto dto);
	



	List<ClueDto> validateCardexNoAndDdoNo(List<Long> list);
	
	
	
	/**
	 * Gets the CO list by hod office id.
	 *
	 * @param departmentId the office id
	 * @return the CO list by hod office id
	 */
	List<EDPMsOfficeDto> getCOListByDepartmentId(Long departmentId);



	List<EDPMsOfficeDto> getHODListByDepartmentOffice(Long departmentId);


}
