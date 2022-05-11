package gov.ifms.dmo.service;

import java.util.List;

import gov.ifms.common.dto.SerachApprovedDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.dto.DMOGOIApprovedRepayDto;
import gov.ifms.dmo.dto.DMOGOILoanDto;
import gov.ifms.dmo.dto.DMOGOILoanPostDto;
import gov.ifms.dmo.dto.DMOGOISearchDto;

/**
 * The Class DMOGOILoanService.
 * 
 * @version v 1.0.
 * @created 2021/07/13 11:40:45.
 *
 */
public interface DMOGOILoanService {

	/**
	 * Convert given DMOGOILoanDto to DMOGOILoanEntity
	 * Saves a given DMOGOILoanEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the dto
	 * @return the saved DMOGOILoanEntity
	 */
	DMOGOILoanPostDto saveOrUpdateGOILoanReceived(DMOGOILoanPostDto dto) throws CustomException;

	
	/**
	 * Retrieves an DMOGOILoanEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the DMOGOILoanEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	DMOGOILoanPostDto getGOILoanReceived(Long id);
	
	/**
	 * Fetch all the GOILoanApprovedList items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<DMOGOILoanDto>
	 */

	public List<DMOGOILoanPostDto> getGOILoanApprovedList(SerachApprovedDto pageDetail) throws CustomException;


	/**
	 * Retrieves all repayments
	 * 
	 * @param id must not be {@literal null}.
	 * @return the DMOGOILoanEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	DMOGOILoanDto getAllRepayments(Long id);


	String deleteGoi(Long id);


	List<DMOGOILoanPostDto> search(DMOGOISearchDto dto);


	DMOGOIApprovedRepayDto searchRepay(DMOGOISearchDto dto);


	DMOGOILoanPostDto updateGOILoanReceived(DMOGOILoanPostDto dto) throws CustomException;

}
