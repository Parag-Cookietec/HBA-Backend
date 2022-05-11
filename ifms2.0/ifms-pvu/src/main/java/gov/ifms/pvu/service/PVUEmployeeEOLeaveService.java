package gov.ifms.pvu.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.itextpdf.text.DocumentException;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeEOLeaveView;
import gov.ifms.pvu.dto.PVUEmployeeEOLeaveDto;
import gov.ifms.pvu.dto.PVUEmployeeWfHSTDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUEmployeeEOLeaveEntity;

/**
 * The Interface PVUEmployeeEOLeaveService.
 */
public interface PVUEmployeeEOLeaveService extends PVUBaseService {

	/**
	 * Gets the PVU employee EO leave.
	 *
	 * @param id the id
	 * @return the PVU employee EO leave
	 * @throws CustomException the custom exception
	 */
	public Optional<PVUEmployeeEOLeaveEntity> getPVUEmployeeEOLeave(Long id) throws CustomException;

	/**
	 * Save or update PVU employee EO leave.
	 *
	 * @param dto the dto
	 * @return the PVU employee EO leave entity
	 * @throws CustomException the custom exception
	 */
	public PVUEmployeeEOLeaveDto saveOrUpdatePVUEmployeeEOLeave(PVUEmployeeEOLeaveDto dto) throws CustomException;

	/**
	 * Gets the PVU employee EO leaves.
	 *
	 * @param pageDetail the page detail
	 * @return the PVU employee EO leaves
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVUEmployeEOLeaveView> getPVUEmployeeEOLeaves(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	public Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException;

	/**
	 * Gets the employee WF history by emp id.
	 *
	 * @param id the id
	 * @return the employee WF history by emp id
	 * @throws CustomException the custom exception
	 */
	public List<PVUEmployeeWfHSTDto> getEmployeeWFHistoryByEmpId(Long id) throws CustomException;

	/**
	 * Insert employee itr.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the PVU common response
	 * @throws CustomException the custom exception
	 */
	public PVUEmployeeEOLeaveDto insertWfEolItr(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException;

	/**
	 * Gets the auto employee number.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the auto employee number
	 * @throws CustomException the custom exception
	 */
	public Boolean getAutoEmployeeNumber(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException;

    /**
     * Gets the one by trn no.
     *
     * @param trnNo the trn no
     * @return the one by trn no
     * @throws CustomException the custom exception
     */
    PVUEmployeeEOLeaveEntity getOneByTrnNo(String trnNo) throws CustomException;

	/**
	 * Update active status by emp eol id.
	 *
	 * @param id the id
	 * @param activeStatus the active status
	 * @throws CustomException the custom exception
	 */
	public void updateActiveStatusByEmpEolId(Long id, int activeStatus) throws CustomException;
	
	String generatePrintEndorsement(IdDto dto) throws IOException,CustomException, DocumentException;
	
	String generateEOLPrintComments(IdDto dto) throws IOException,CustomException, DocumentException;
	
	
	public void getPvuEmployeeEOLeaveValidation(PVUEmployeeEOLeaveDto dto) throws CustomException;
	
	public void getPvuEmployeeEOLeaveValidationCreate(PVUEmployeeEOLeaveDto dto) throws CustomException;

}
