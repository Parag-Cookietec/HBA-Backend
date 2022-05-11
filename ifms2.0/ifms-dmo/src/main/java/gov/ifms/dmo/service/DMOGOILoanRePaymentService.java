package gov.ifms.dmo.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.dmo.dto.DMOGOILoanDto;
import gov.ifms.dmo.dto.DMOGOILoanPostDto;
import gov.ifms.dmo.dto.DMOGOILoanRePaymentDto;
import gov.ifms.dmo.dto.DMOGOISearchDto;

/**
 * The Class DMOGOILoanRePaymentService.
 * 
 * @version v 2.0.
 * @created 2021/07/20 15:19:32
 *
 */
public interface DMOGOILoanRePaymentService {

	/**
	 * Fetch all the GOI loan RePayments schedule list items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<DMOGOILoanDto>
	 */
	PagebleDTO<DMOGOILoanDto> findAll(PageDetails pageDetail) throws CustomException;

	/**
	 * Convert GOILoanRePaymentEntity to DMOGOILoanMatchPayableDto
	 * Retrieves an GOILoanRePaymentEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the GOILoanRePaymentEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	DMOGOILoanDto findById(Long id);

	List<DMOGOILoanRePaymentDto> save(DMOGOILoanPostDto dto) throws CustomException; 

	String update(DMOGOILoanRePaymentDto dto);

	DMOGOILoanRePaymentDto matchWithPayable(DMOGOISearchDto dto);

}
