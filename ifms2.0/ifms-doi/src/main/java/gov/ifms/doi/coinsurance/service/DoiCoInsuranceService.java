/**
 * 
 */
package gov.ifms.doi.coinsurance.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.doi.coinsurance.dto.DoiCoinsChequeRegisterDTO;
import gov.ifms.doi.coinsurance.dto.DoiCoinsClaimHdrDTO;
import gov.ifms.doi.coinsurance.dto.DoiCoinsPolicyHdrDTO;
import gov.ifms.doi.coinsurance.dto.DoiCoinsPremiumRefundDTO;
import gov.ifms.doi.coinsurance.dto.DoiCoinsPremiumRegisterDTO;
import gov.ifms.doi.jpa.pagination.PageDetails;
import java.util.*;

/**
 * @author Rudra
 *
 */
public interface DoiCoInsuranceService {

	DoiCoinsChequeRegisterDTO saveOrUpdateCoinsChequeRegister(DoiCoinsChequeRegisterDTO dto);

	PagebleDTO<DoiCoinsChequeRegisterDTO> getCoinsChequeRegisterListing(PageDetails pageDetail) throws CustomException;

	DoiCoinsPremiumRegisterDTO getAndSaveCoinsPremiumRegister(DoiCoinsPremiumRegisterDTO dto);

	DoiCoinsPolicyHdrDTO saveOrUpdateCoinsPolicyMaster(DoiCoinsPolicyHdrDTO dto);

	PagebleDTO<DoiCoinsPolicyHdrDTO> getCoinsPolicyListing(PageDetails pageDetail) throws CustomException;

	PagebleDTO<DoiCoinsPremiumRefundDTO> saveOrUpdateCoinsPremiumRefundEntry(DoiCoinsPremiumRefundDTO dto) throws CustomException;

	PagebleDTO<DoiCoinsPremiumRefundDTO> getCoinsPremiumRefundListing(PageDetails pageDetail) throws CustomException;

	DoiCoinsClaimHdrDTO saveOrUpdateCoinsClaimEntry(DoiCoinsClaimHdrDTO dto);

	PagebleDTO<DoiCoinsClaimHdrDTO> getCoinsClaimEntryListing(PageDetails pageDetail) throws CustomException;

	List<DoiCoinsClaimHdrDTO> findAllClaimDetails();

}
