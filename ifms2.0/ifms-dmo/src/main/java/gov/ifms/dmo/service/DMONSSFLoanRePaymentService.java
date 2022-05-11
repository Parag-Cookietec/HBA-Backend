package gov.ifms.dmo.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.dmo.dto.DMOGOISearchDto;
import gov.ifms.dmo.dto.DMONSSFLoanDto;
import gov.ifms.dmo.dto.DMONSSFLoanPostDto;
import gov.ifms.dmo.dto.DMONSSFLoanRePaymentDto;

/**
 * The Class DMONSSFLoanRePaymentService.
 * 
 * @version v 2.0.
 * @created 2021/07/20 15:19:32
 *
 */
public interface DMONSSFLoanRePaymentService {

	/**
	 * Fetch all the NSSF loan RePayments schedule list items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<DMONSSFLoanDto>
	 */
	PagebleDTO<DMONSSFLoanDto> findAll(PageDetails pageDetail) throws CustomException;

	/**
	 * Convert NSSFLoanRePaymentEntity to DMONSSFLoanMatchPayableDto
	 * Retrieves an NSSFLoanRePaymentEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the NSSFLoanRePaymentEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	DMONSSFLoanDto findById(Long id);

	List<DMONSSFLoanRePaymentDto> save(DMONSSFLoanPostDto dto) throws CustomException;

	String update(DMONSSFLoanRePaymentDto dto);

	DMONSSFLoanRePaymentDto matchWithPayable(DMOGOISearchDto dto);

}
