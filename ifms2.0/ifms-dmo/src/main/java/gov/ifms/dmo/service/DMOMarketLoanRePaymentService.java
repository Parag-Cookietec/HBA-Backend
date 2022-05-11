package gov.ifms.dmo.service;

import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.dmo.dto.DMOGOISearchDto;
import gov.ifms.dmo.dto.DMOMarketLoanDto;
import gov.ifms.dmo.dto.DMOMarketLoanRePaymentDto;

/**
 * The Class DMOGOILoanRePaymentService.
 * 
 * @version v 2.0.
 * @created 2021/07/20 15:19:32
 *
 */
public interface DMOMarketLoanRePaymentService {

	/**
	 * Fetch all the GOI loan RePayments schedule list items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<DMOMarketLoanDto>
	 */
	PagebleDTO<DMOMarketLoanDto> findAll(PageDetails pageDetail) throws CustomException;

	/**
	 * Convert GOILoanRePaymentEntity to DMOGOILoanMatchPayableDto
	 * Retrieves an GOILoanRePaymentEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the GOILoanRePaymentEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	DMOMarketLoanDto findById(Long id);

	List<DMOMarketLoanDto> save(DMOMarketLoanDto dto) throws CustomException;

	String update(DMOMarketLoanRePaymentDto dto);

	DMOMarketLoanRePaymentDto matchWithPayable(DMOGOISearchDto dto);

}
