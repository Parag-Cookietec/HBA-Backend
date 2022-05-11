package gov.ifms.pvu.service;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUPromotionDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.request.PromotionValidationRequest;
import gov.ifms.pvu.entity.PVUPromotionEntity;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.DocumentException;

/**
 * The Class PVUPromotionService.
 *
 * @version v 1.0
 * @created 2019/12/20 16:35:46
 */
public interface PVUPromotionService {
    /**
     * Retrieves an PVUPromotionEntity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the PVUPromotionEntity with the given id or {@literal null} if none found
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    PVUPromotionEntity getPVUPromotion(Long id);

    /**
     * Saves a given PVUPromotionEntity. Use the returned instance for further operations
     * as the save operation might have changed the entity instance completely.
     *
     * @param entity the entity
     * @return the saved PVUPromotionEntity
     */
    PVUPromotionDto saveOrUpdatePVUPromotion(PVUPromotionDto entity) throws CustomException;

    /*
     * Gets the all lu look up info as map.
     *
     * @return the all lu look up info as map
     * @throws CustomException the custom exception
     */
    Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException;

    PVUPromotionDto insertInITR(PvuWFWrapperDto wrapperDto) throws CustomException;

    void setComparerDetails(PVUPromotionDto dto) throws CustomException;

    boolean validatePromotion(PromotionValidationRequest request) throws CustomException;

    void deleteById(IdDto dto) throws CustomException;
    public String generatePrintEndorsement(IdDto dto) throws IOException, CustomException, DocumentException;
}
