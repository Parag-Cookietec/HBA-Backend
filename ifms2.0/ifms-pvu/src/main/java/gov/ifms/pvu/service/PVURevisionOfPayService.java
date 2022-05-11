package gov.ifms.pvu.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import com.itextpdf.text.DocumentException;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.dto.PVURevisionOfPayDto;
import gov.ifms.pvu.dto.PVURevisionOfPayRemarkHstDto;
import gov.ifms.pvu.dto.PVURevisionOfPaySearchView;
import gov.ifms.pvu.dto.PVURopDetailRequest;
import gov.ifms.pvu.dto.PVURopEmployeView;
import gov.ifms.pvu.dto.PVURopPostDetailView;
import gov.ifms.pvu.dto.PVURopRemarksDto;
import gov.ifms.pvu.dto.PVURopView;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.RopEmployeeDetailDto;
import gov.ifms.pvu.dto.response.RopConfigurationDto;
import gov.ifms.pvu.entity.PVURevisionOfPayEntity;

/**
 * The Class PVURevisionOfPayController.
 *
 * @version v 1.0
 * @created 2020/01/09 12:59:56
 */
public interface PVURevisionOfPayService extends PVUBaseService {

    public PVURevisionOfPayDto getRevisionOfPay(Long id);

    public PagebleDTO<PVURevisionOfPaySearchView> getRevisionOfPaysSearchList(PageDetails pageDetail) throws CustomException;

    public void insertRopITR(final PvuWFWrapperDto pvuWFWrapperDto) ;

	public List<RopConfigurationDto> ropConfigurationList();

	public PVURevisionOfPayDto saveOrUpdateRevisionOfPay(@Valid PVURevisionOfPayDto dto) throws CustomException;

	public PVURevisionOfPayEntity saveOrUpdate(PVURevisionOfPayEntity entity) throws CustomException;

	public PVURevisionOfPayEntity getRevisionOfPayById(Long id);

    public boolean submitRopEvent(PvuWFWrapperDto wrapperDto) throws CustomException;

	public Boolean ropGivenPrevious(PVURopDetailRequest pvuRopDetailRequest) throws CustomException, ParseException;

	public PVURopPostDetailView ropPostDetails(PVURopDetailRequest pvuRopDetailRequest) throws CustomException;

	public PVURevisionOfPayDto updateRopRemarks(PVURevisionOfPayDto dto) throws CustomException;

	public PVURopView getRevisionOfPayView(Long id) throws CustomException;

    public boolean deleteRopTrns(IdDto idDto) throws CustomException;

    public List<PVURevisionOfPayRemarkHstDto> getRopRemarkHistory(IdDto idDto) throws CustomException;

	public PagebleDTO<PVURopEmployeView> getRopSearchEmployes(PageDetails pageDetail) throws CustomException;

	public RopEmployeeDetailDto getRopEmployeeDetails(PVURopDetailRequest ropEmployeeRequest) throws CustomException, ParseException;

    public EDPMsOfficeDto getPVUOfficeName(IdDto idDto);

    public PagebleDTO<PVURevisionOfPaySearchView> getPVURevisionOfPaysSearchList(PageDetails pageDetail) throws CustomException;

	public List<PVUMsReasonDto> getRopReasons();

	public List<PVURopRemarksDto> getReturnReasonByTransactionId(Long id) throws CustomException;

	public void insertRopRemarksITR(Long transId);

	void authorizedRop(Long transId);
	
	String generateDdoApprovalCertificate(IdDto dto) throws IOException,CustomException, DocumentException;
}
