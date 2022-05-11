package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.AnnexureDto;
import gov.ifms.pvu.dto.PVUEmployeDetailsDto;
import gov.ifms.pvu.dto.PVURopPrintEndorsementDto;
import gov.ifms.pvu.dto.PVURopPrintEndorsementView;
import gov.ifms.pvu.dto.PrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PrintStickerReportDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.entity.PVURopPrintEndorsementEntity;

import java.util.List;
/**
 * The Class PVURopPrintEndorsementController.
 * 
 * @version v 1.0
 * @created 2020/04/06 16:00:01
 *
 */
public interface PVURopPrintEndorsementService {
	/**
	 * Retrieves an PVURopPrintEndorsementEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVURopPrintEndorsementEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVURopPrintEndorsementEntity getRopPrintEndorsement(Long id);

	/**
	 * Saves a given PVURopPrintEndorsementEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVURopPrintEndorsementEntity
	 */
	public PVURopPrintEndorsementEntity saveOrUpdateRopPrintEndorsement(PVURopPrintEndorsementEntity entity);

	/**
	 * Fetch all the PVURopPrintEndorsement items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVURopPrintEndorsementDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVURopPrintEndorsementView> getRopPrintEndorsements(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the pvu search fields.
	 *
	 * @return the pvu search fields
	 */
	List<PVUSearchEnum> getPvuSearchFields();

	/**
	 * Gets the PE lu look up details.
	 *
	 * @return the PE lu look up details
	 * @throws CustomException the custom exception
	 */
	PVUEmployeDetailsDto getPELuLookUpDetails() throws CustomException;

	/**
	 * Submit print endorsement.
	 *
	 * @param dto the dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	public PVURopPrintEndorsementDto submitPrintEndorsement(PrintStickerReportDto dto) throws CustomException;

	/**
	 * Generate print endorsement.
	 *
	 * @param dto the sticker DTO
	 * @return the string
	 * @throws CustomException 
	 */
	String generatePrintEndorsement(PrintStickerReportDto dto) throws CustomException;
	
	/**
	 * Generate Annexure.
	 *
	 * @param dto the sticker DTO
	 * @return the string
	 */
	String generateAnnexure(AnnexureDto dto);

	List<PrintEndorsementRemarkHistoryDto> getRopPrintEndorsementHistory(Long id) throws CustomException;
	
	/**
	 * Generate print endorsement.
	 *
	 * @param dto the sticker DTO
	 * @return the string
	 * @throws CustomException 
	 */
	String generatePrintEndorsementList(List<PrintStickerReportDto> dto) throws CustomException;
}
