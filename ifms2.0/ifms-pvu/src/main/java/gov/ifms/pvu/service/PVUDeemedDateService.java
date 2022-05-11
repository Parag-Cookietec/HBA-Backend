package gov.ifms.pvu.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.DocumentException;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUDeemedDateDto;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUDeemedDateEntity;

import java.util.List;
import java.util.Map;

/**
 * The Class PVUDeemedDateService.
 */
public interface PVUDeemedDateService {
    /**
     * Retrieves an PVUDeemedDateEntity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the PVUDeemedDateEntity with the given id or {@literal null} if none
     * found
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    PVUDeemedDateEntity getPVUDeemedDate(Long id);

    /**
     * Saves a given PVUDeemedDateEntity. Use the returned instance for further
     * operations as the save operation might have changed the entity instance
     * completely.
     *
     * @param dto the dto
     * @return the saved PVUDeemedDateEntity
     */
    PVUDeemedDateDto saveOrUpdatePVUDeemedDate(PVUDeemedDateDto dto) throws CustomException;

    /**
     * Fetch all the PVUDeemedDate items with pagination.
     *
     * @param pageDetail the page detail
     * @return List<PVUDeemedDateDto>
     */
    PagebleDTO<PVUDeemedDateDto> getPVUDeemedDates(PageDetails pageDetail) throws CustomException;

    /*
     * Gets the all lu look up info as map.
     *
     * @return the all lu look up info as map
     *
     * @throws CustomException the custom exception
     */
    Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException;


    public PVUDeemedDateDto insertDeemedItr(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException;

    public boolean deleteDeemedDateEventById(IdDto idDto) throws CustomException;

	String generatePrintEndorsement(IdDto dto) throws IOException,CustomException, DocumentException;
	
	String generateComparisionReport(IdDto dto) throws IOException,CustomException, DocumentException;

}
