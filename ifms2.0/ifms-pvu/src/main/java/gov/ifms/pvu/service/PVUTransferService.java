package gov.ifms.pvu.service;

import java.util.List;
import java.util.Map;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.pvu.dto.*;
import gov.ifms.pvu.entity.PVUTransferEntity;

/**
 * The Class PVUTransferController.
 *
 * @version v 1.0
 * @created 2019/12/21 22:53:07
 */
public interface PVUTransferService  extends  PVUBaseService{

    public PVUTransferEntity getTransferById(Long id);

    public PVUTransferDto saveOrUpdateTransfer(PVUTransferDto dto) throws CustomException;

    public PagebleDTO<PVUTransferEmployeeView> getTransferList(PageDetails pageDetail) throws CustomException;

    public PagebleDTO<PVUTransferEmployeeView> getJoiningTransferList(PageDetails pageDetail) throws CustomException;

    public Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException;

    public List<EDPMsOfficeDto> getOfficeByDistrict(Long id) throws CustomException;

    PVUTransferDto insertInITR(PvuWFWrapperDto wrapperDto) throws CustomException;

    PVUTransferEmployeeDetailsDto getLookupDetails() throws CustomException;

    public void deleteTransferById(Long id, int inactiveStatus) throws CustomException;
}


