package gov.ifms.pvu.service;

import com.itextpdf.text.DocumentException;
import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.*;
import gov.ifms.pvu.entity.PVUIncrementEventEntity;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The Class PVUIncrementEventController.
 * 
 * @version v 1.0
 * @created 2020/01/09 19:28:39
 *
 */
public interface PVUEmployeIncrementService {
	/**
	 * Gets the all lu look up info as map.
	 *
	 * @param procedureName the procedure name
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	public Map<String, List<PVUEmployeCreationDDLView>> getLookUpInfoAsMap(String procedureName) throws CustomException;

	/**
	 * Fetch all the PVUIncrementEvent items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUIncrementEventDto>
	 * @throws CustomException the custom exception
	 */
	public PVURegularIncrementListView getRegularEmployeeIncrementList(PageDetails pageDetail)
			throws CustomException;

	public PVUIncrementEventEntity saveOrUpdateIncrementEvent(PVUIncrementEventEntity entity) throws CustomException;

	public PVUIncrementMainEventDto saveOrUpdateIncrementEventEmpSummary(PVUIncrementMainEventDto dto) throws CustomException;

	public String getEmployeeDataReportExcel(PageDetails pageDetail) throws CustomException;

	public PagebleDTO<PVUEmployeeIncrementListView> getPVUEmployeeIncrementList(PageDetails pageDetail)
			throws CustomException;

	/*
	 * public List<Object[]> pvuEmployeeIncrementConfirmAndProcess(PageDetails
	 * pageDetail) throws CustomException;
	 */
	public List<Object[]> pvuEmployeeIncrementConfirmAndProcess(PVUIncrementMainEventDto dto)
			throws CustomException;

	public PVUIncrementMainEventDto insertIncrementItr(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException;

	public PVUIncrementEventEntity getIncrementEvent(Long id);

	public String getIneligibleEmployeeListExcel(PageDetails pageDetail) throws CustomException;

	public String getSuccessCountExcel(PageDetails pageDetail) throws CustomException;
	public PVUIncrementMainEventDto getIncrementEventEmpSummary(Long id) throws CustomException;
	public Boolean validateIncrementSubmit(PVUIncrementMainEventDto dto) throws CustomException;

	public String getProcessedEmployeeListExcel(PageDetails pageDetail) throws CustomException;
	public boolean deleteIncrementTrns(IdDto idDto) throws CustomException;
	public PagebleDTO<PVURegularIncrementEligibleListView2>  getprocessStatus(PageDetails pageDetail) throws CustomException;
	public String generatePrintEndorsement(IdDto dto) throws IOException, CustomException, DocumentException;

}
