package gov.ifms.edp.service;

import java.io.ByteArrayInputStream;

import gov.ifms.common.exception.CustomException;
import gov.ifms.edp.dto.EDPBulkEmployeeCreationDto;
import gov.ifms.edp.entity.EDPBECUserEntity;
import gov.ifms.edp.entity.EDPBulkEmployeeCreationEntity;

public interface EDPUserCreationService {
	
	/**
	 * Upload file.
	 *
	 * @param  upload the file 
	 * @throws CustomException the custom exception
	 */
// BudgetAgUploadHdrDto uploadFile(BudgetAgUploadHdrDto agUploadHdrDto) throws CustomException, IOException;
	
	public EDPBulkEmployeeCreationEntity saveBulkEmployeeCreationTransaction(EDPBulkEmployeeCreationDto dto)  throws CustomException;

	public ByteArrayInputStream submitBulkEmployeeData(long id) throws CustomException;
}
