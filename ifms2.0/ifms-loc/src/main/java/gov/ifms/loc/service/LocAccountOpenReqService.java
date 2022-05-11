package gov.ifms.loc.service;

import java.util.List;
import java.util.Map;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.loc.dto.LocAccOpenReqDtlDto;
import gov.ifms.loc.dto.LocAccountOpenReqAgDtlDto;
import gov.ifms.loc.dto.LocAccountOpenReqAgSdDto;
import gov.ifms.loc.dto.LocAccountOpenReqBankSdDto;
import gov.ifms.loc.dto.LocAccountOpenReqDivisionSdDto;
import gov.ifms.loc.dto.LocAccountOpenReqDtlDto;
import gov.ifms.loc.dto.LocAccountOpenReqHdrDto;
import gov.ifms.loc.dto.LocAccountOpenReqItrDto;
import gov.ifms.loc.dto.LocAccountOpenReqSdDto;
import gov.ifms.loc.dto.LocAgReqDtlDto;
import gov.ifms.loc.dto.LocBankDetailsDto;
import gov.ifms.loc.dto.LocBankReqDtlDto;
import gov.ifms.loc.dto.LocCircleDto;
import gov.ifms.loc.dto.LocDiviReqDtlDto;
import gov.ifms.loc.dto.LocMasterIdDto;
import gov.ifms.loc.dto.LocOpenListingParamDto;
import gov.ifms.loc.dto.LocOpenReqAgViewDto;
import gov.ifms.loc.dto.LocOpenReqBankViewDto;
import gov.ifms.loc.dto.LocOpenReqDiviViewDto;
import gov.ifms.loc.dto.LocOpenReqListDto;
import gov.ifms.loc.dto.LocOpenReqSubmitDto;
import gov.ifms.loc.dto.LocOpenReqViewDto;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.dto.LocTreasuryDto;
import gov.ifms.loc.dto.LocTreasuryParamDto;
import gov.ifms.loc.entity.LocAccountOpenReqHdrEntity;
import gov.ifms.loc.entity.LocAccountOpenReqSdEntity;

/**
 * The Class LocAccountOpenReqService.
 *
 * @version 1.0
 * @created 2020/12/22 12:52:20
 */
public interface LocAccountOpenReqService {

	/**
	 * Gets the account open req hdr.
	 *
	 * @param id the id
	 * @return the account open req hdr
	 */
	public LocAccountOpenReqHdrEntity getAccountOpenReqHdr(Long id);

	/**
	 * Saves a given LocAccountOpenReqHdrEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved LocAccountOpenReqHdrEntity
	 */
	public LocAccountOpenReqHdrEntity saveOrUpdateAccountOpenReqHdr(LocAccountOpenReqHdrEntity entity);

	/**
	 * Fetch all the LocAccountOpenReqHdr items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<LocAccountOpenReqHdrDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<LocAccountOpenReqHdrDto> getAccountOpenReqHdrs(PageDetails pageDetail) throws CustomException;

	/**
	 * Retrieves an LocAccountOpenReqSdEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the LocAccountOpenReqSdEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public LocAccountOpenReqSdEntity getAccountOpenReqSd(Long id);

	/**
	 * Saves a given LocAccountOpenReqSdEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved LocAccountOpenReqSdEntity
	 */
	public LocAccountOpenReqSdEntity saveOrUpdateAccountOpenReqSd(LocAccountOpenReqSdEntity entity);

	/**
	 * Fetch all the LocAccountOpenReqSd items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<LocAccountOpenReqSdDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<LocAccountOpenReqSdDto> getAccountOpenReqSds(PageDetails pageDetail) throws CustomException;

	/**
	 * Fetch all the LocAccountOpenReqDtl items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<LocAccountOpenReqDtlDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<LocAccountOpenReqDtlDto> getAccountOpenReqDtls(PageDetails pageDetail) throws CustomException;

	/**
	 * Fetch all the LocAccountOpenReqItr items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<LocAccountOpenReqItrDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<LocAccountOpenReqItrDto> getAccountOpenReqItrs(PageDetails pageDetail) throws CustomException;

	/**
	 * Fetch all the Circle items.
	 *
	 * @return List<LocCircleDto>
	 * @throws CustomException the custom exception
	 */
	public List<LocCircleDto> getAllCircle() throws CustomException;

	/**
	 * Create Loc Account Request Header.
	 *
	 * @param locActOpnReqHdrDto the page detail
	 * @return LocAccountOpenReqHdrDto
	 * @throws CustomException the custom exception
	 */
	LocAccountOpenReqHdrDto createLocAccReqHdr(LocAccountOpenReqHdrDto locActOpnReqHdrDto) throws CustomException;

	/**
	 * Get TREASURY By DISTRICT_ID And DEPARTMENT_ID.
	 *
	 * @param locTreasuryParamDto the loc treasury param dto
	 * @return List<LocCircleDto>
	 * @throws CustomException the custom exception
	 */
	LocTreasuryDto getTreasuryByDistrictIdAndDepartmentId(LocTreasuryParamDto locTreasuryParamDto)
			throws CustomException;

	/**
	 * Retrieves an LocAccountOpenReqHdrEntity by its id.
	 *
	 * @param hdrId      must not be {@literal null}.
	 * @param isEditable the is editable
	 * @return the LocAccountOpenReqHdrEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	LocAccOpenReqDtlDto getAccountOpenReqDtl(Long hdrId, int isEditable);

	/**
	 * Gets the major head.
	 *
	 * @return the major head
	 * @throws CustomException the custom exception
	 */
	List<ClueDto> getMajorHead() throws CustomException;

	/**
	 * Gets the sub major head.
	 *
	 * @param dto the dto
	 * @return the sub major head
	 * @throws CustomException the custom exception
	 */
	List<ClueDto> getSubMajorHead(LocMasterIdDto dto) throws CustomException;

	/**
	 * Gets the minor head.
	 *
	 * @param dto the dto
	 * @return the minor head
	 * @throws CustomException the custom exception
	 */
	List<ClueDto> getMinorHead(LocMasterIdDto dto) throws CustomException;

	/**
	 * Gets the sub head.
	 *
	 * @param dto the dto
	 * @return the sub head
	 * @throws CustomException the custom exception
	 */
	List<ClueDto> getSubHead(LocMasterIdDto dto) throws CustomException;

	/**
	 * Gets the detail head.
	 *
	 * @param dto the dto
	 * @return the detail head
	 * @throws CustomException the custom exception
	 */
	List<ClueDto> getDetailHead(LocMasterIdDto dto) throws CustomException;

	/**
	 * Creates the ag office detail.
	 *
	 * @param dto the dto
	 * @return the loc account open req ag sd dto
	 * @throws CustomException the custom exception
	 */
	LocAccountOpenReqAgSdDto createAgOfficeDetail(LocAccountOpenReqAgSdDto dto) throws CustomException;

	/**
	 * Gets the loc open req ag view details.
	 *
	 * @param pageDetails the page details
	 * @return the loc open req ag view details
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<LocOpenReqAgViewDto> getLocOpenReqAgViewDetails(PageDetails pageDetails) throws CustomException;

	/**
	 * Gets the history details.
	 *
	 * @param pageDetails the page details
	 * @return the history details
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<LocOpenReqViewDto> getLocOpenReqViewDetails(PageDetails pageDetails) throws CustomException;

	/**
	 * Gets the loc open req bank view details.
	 *
	 * @param pageDetails the page details
	 * @return the loc open req bank view details
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<LocOpenReqBankViewDto> getLocOpenReqBankViewDetails(PageDetails pageDetails) throws CustomException;

	/**
	 * Gets the loc open req divi view details.
	 *
	 * @param pageDetails the page details
	 * @return the loc open req divi view details
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<LocOpenReqDiviViewDto> getLocOpenReqDiviViewDetails(PageDetails pageDetails) throws CustomException;

	/**
	 * Submit data.
	 *
	 * @param submitWfDto the submit wf dto
	 * @throws CustomException the custom exception
	 */
	public void submitData(LocSubmitWfDto submitWfDto) throws CustomException;

	/**
	 * Gets the open listing data.
	 *
	 * @param dto the dto
	 * @return the open listing data
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<LocOpenReqListDto> getOpenListingData(PageDetails dto) throws CustomException;

	/**
	 * Gets the request param.
	 *
	 * @return the request param
	 * @throws CustomException the custom exception
	 */
	LocOpenListingParamDto getRequestParam() throws CustomException;

	/**
	 * Gets the ag office detail.
	 *
	 * @param hdrId      the hdr id
	 * @param isEditable the is editable
	 * @return the ag office detail
	 * @throws CustomException the custom exception
	 */
	LocAgReqDtlDto getAgOfficeDetail(Long hdrId, Integer isEditable) throws CustomException;

	/**
	 * Validate ag office detail.
	 *
	 * @param dto the dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	Boolean validateAgOfficeDetail(LocAccountOpenReqAgDtlDto dto) throws CustomException;

	/**
	 * Gets the all bank details.
	 *
	 * @param dto the dto
	 * @return the all bank details
	 * @throws CustomException the custom exception
	 */
	LocBankDetailsDto getAllBankDetails(IdDto dto) throws CustomException;

	/**
	 * Creates the bank office detail.
	 *
	 * @param dto the dto
	 * @return the loc account open req bank sd dto
	 * @throws CustomException the custom exception
	 */
	LocAccountOpenReqBankSdDto createBankOfficeDetail(LocAccountOpenReqBankSdDto dto) throws CustomException;

	/**
	 * Gets the bank office detail.
	 *
	 * @param hdrId      the hdr id
	 * @param isEditable the is editable
	 * @return the bank office detail
	 * @throws CustomException the custom exception
	 */
	LocBankReqDtlDto getBankOfficeDetail(Long hdrId, Integer isEditable) throws CustomException;

	/**
	 * Creates the division office detail.
	 *
	 * @param dto the dto
	 * @return the loc account open req division sd dto
	 * @throws CustomException the custom exception
	 */
	LocAccountOpenReqDivisionSdDto createDivisionOfficeDetail(LocAccountOpenReqDivisionSdDto dto)
			throws CustomException;

	/**
	 * Gets the division office detail.
	 *
	 * @param hdrId      the hdr id
	 * @param isEditable the is editable
	 * @return the division office detail
	 */
	LocDiviReqDtlDto getDivisionOfficeDetail(Long hdrId, Integer isEditable);

	/**
	 * Gets the loc open req submit details.
	 *
	 * @param hdrId the hdr id
	 * @return the loc open req submit details
	 * @throws CustomException the custom exception
	 */
	LocOpenReqSubmitDto getLocOpenReqSubmitDetails(Long hdrId) throws CustomException;

	/**
	 * Gets the division validation.
	 *
	 * @param dto the dto
	 * @return the division validation
	 */
	public int getDivisionValidation(LocAccountOpenReqHdrDto dto) throws CustomException;

	/**
	 * Gets the circle by department.
	 *
	 * @param id the id
	 * @return the circle by department
	 * @throws CustomException the custom exception
	 */
	public List<LocCircleDto> getCircleByDepartment(Long id) throws CustomException;

	/**
	 * Delete by id.
	 *
	 * @param dto the dto
	 * @return the id dto
	 * @throws CustomException the custom exception
	 */
	IdDto deleteById(IdDto dto) throws CustomException;
	
	/**
	 * Gen auth letter.
	 *
	 * @param dto the dto
	 * @return the map
	 * @throws CustomException the custom exception
	 */
	public Map<String,Object> genAuthLetter(IdDto dto) throws CustomException;

}
