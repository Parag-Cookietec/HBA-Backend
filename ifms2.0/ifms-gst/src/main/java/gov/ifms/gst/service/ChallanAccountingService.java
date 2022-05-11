package gov.ifms.gst.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.dto.AccountScreenChallanDto;
import gov.ifms.gst.dto.GSTChallanAccountingListingDTO;
import gov.ifms.gst.dto.ReconcileDetailsDto;
import gov.ifms.gst.entity.GstRbiFilesTranxn;

public interface ChallanAccountingService {

	PagebleDTO<GstRbiFilesTranxn> getChallanList(PageDetails pageDetail) throws CustomException;

    AccountScreenChallanDto getById(Long id);

    ReconcileDetailsDto getReconcileDetails(Long id);

    ReconcileDetailsDto saveOrUpdate(ReconcileDetailsDto dto);

	PagebleDTO<GSTChallanAccountingListingDTO> getChallanAccountingListing(PageDetails pageDetail);
}
