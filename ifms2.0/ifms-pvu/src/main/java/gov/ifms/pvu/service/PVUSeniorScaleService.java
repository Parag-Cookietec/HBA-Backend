package gov.ifms.pvu.service;

import com.itextpdf.text.DocumentException;
import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.GenericDao;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.pvu.dto.*;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.dto.response.PVUEventSeniorScaleDDOView;
import gov.ifms.pvu.entity.PVUSeniorScaleEntity;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;

import java.io.IOException;
import java.util.*;

/**
 * The Class PVUSeniorScaleService.
 */
public interface PVUSeniorScaleService {

    GenericDao getRepository();

    /**
     * Retrieves an PVUSeniorScaleEntity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the PVUSeniorScaleEntity with the given id or {@literal null} if none found
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    PVUSeniorScaleEntity getPVUSeniorScale(Long id);

    /**
     * Saves a given PVUSeniorScaleDto. Use the returned instance for further operations
     * as the save operation might have changed the entity instance completely.
     *
     * @param dto the dto
     * @return the saved PVUSeniorScaleDto
     */
    PVUSeniorScaleDto saveOrUpdatePVUSeniorScale(PVUSeniorScaleDto dto) throws CustomException;

    /**
     * Fetch all the PVUSeniorScale items with pagination.
     *
     * @param pageDetail the page detail
     * @return List<PVUSeniorScaleDto>
     */
    PagebleDTO<PVUSeniorScaleDto> getPVUSeniorScales(PageDetails pageDetail);

    PVUSeniorScaleDto insertInITR(PvuWFWrapperDto wrapperDto) throws CustomException;

    void insertSSRemarksITR(PvuWFWrapperDto wrapperDto);

    PagebleDTO<PVUEventSeniorScaleDDOView> ddoWFListing(PageDetails pageDetails) throws CustomException;

    void insertSSPITR(PvuWFWrapperDto pvuWFWrapperDto);

    String getWfRlCdBySSPTrnId(Long id);

    EDPMsOfficeDto getPVUOfficeName(IdDto idDto);

    PagebleDTO<PVUInwardView> getSSPInwardList(PageDetails pageDetail) throws CustomException;

    PagebleDTO<PVUPrintEndorsementView> getSSPPrintEndorsementList(PageDetails pageDetail) throws CustomException;

    PagebleDTO<PVUOutwardView> getSSPOutWardList(PageDetails pageDetail) throws CustomException;

    List<PVUSearchEnum> getOutwardPvuSearchFields();

    List<PVUSearchEnum> getPrintPrintEndorsementSearchFields();

    List<PVUSearchEnum> getInwardPvuSearchFields();

    Boolean generateInwardNumber(List<IdDto> dto) throws CustomException;

    Boolean generateOutWardNumber(List<IdDto> dtos) throws CustomException;

    Boolean submitSSPInward(List<PvuWFWrapperDto> wrapperDto) throws CustomException;

    Boolean submitSSPDistributor(List<PvuWFWrapperDto> wrapperDto) throws CustomException;

    Boolean submitSSPOutWard(List<PvuWFOutWardWrapperDto> wrapperDto) throws CustomException;

    PagebleDTO<PVUSeniorScalePVUOfficeSearchDto> getPVUOfficeSSPEmployeeSearch(PageDetails pageDetail) throws CustomException;

    List<PVUMsReasonDto> getPvuOfficeSSPReasonCode();

    Map<String, Object> getPVUResponse(IdDto dto) throws CustomException;

    /**
     * Store proc pvu.
     *
     * @param <T>      type of Object
     * @param procName the proc name
     * @param map      the map
     * @param view     type of Class
     * @return the list
     * @throws CustomException the custom exception
     */
    default <T> List<T> storeProcPvu(String procName, Map<String, Object> map, Class<T> view) throws CustomException {
        List<Object[]> objectPvuSp = getRepository().callStoredProcedure(procName, map);
        return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, view)
                : Collections.emptyList();
    }

    default void storeProcPvu(String procName, Map<String, Object> map) throws CustomException {
        getRepository().callStoredProcedure(procName, map);
    }

    default Boolean generateNumber(List<IdDto> dtos, String sp) throws CustomException {
        try {
            List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
            dtos.forEach(dto -> {
                Map<Integer, Object> map = new HashMap<>();
                map.put(1, "SS_PVU");
                map.put(2, dto.getId());
                parameterMapList.add(map);
            });
            return getRepository().callStoreProcBatch("{CALL "
                            + Constant.PVU_SCHEMA.concat(Constant.DOT.concat(sp)) + "(?,?)}",
                    parameterMapList);
        } catch (Exception ex) {
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }

    PVUSeniorScaleDto saveOrUpdateRemarks(PVUSSPRemarkRequest dto);

    List<PVUEventRemarksDto> getReturnRemarks(Long id) throws CustomException;

    void test(IdDto dto) throws CustomException;

    String generatePrintOrder(PvuPrintStickerReportDto dto) throws CustomException, IOException, DocumentException;

    String generatePrintOrders(List<PvuPrintStickerReportDto> dto) throws CustomException, IOException, DocumentException;

    public List<PrintEndorsementRemarkHistoryDto> getReprintEndorsementRemarks(Long id) throws CustomException;

    void deleteById(IdDto dto) throws CustomException;
    String generatePrintEndorsement(IdDto dto) throws IOException,CustomException, DocumentException;
}
