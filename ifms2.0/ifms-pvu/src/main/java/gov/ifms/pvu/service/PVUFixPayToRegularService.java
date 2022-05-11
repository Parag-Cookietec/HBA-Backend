package gov.ifms.pvu.service;

import java.util.List;
import java.util.Map;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPLuLookUpInfoDto;
import gov.ifms.pvu.dto.FixpayToRegularRequestDto;
import gov.ifms.pvu.dto.IdAndValueDto;
import gov.ifms.pvu.dto.PVUFixToRegularPayConDto;
import gov.ifms.pvu.dto.PVUFixToRegularPayListView;
import gov.ifms.pvu.entity.PVUFixToRegularPayConEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;


public interface PVUFixPayToRegularService {

	/**
	 * Gets the EMD list.
	 *
	 * @param pageDetail the page detail
	 * @return the EMD list
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVUFixToRegularPayListView> getFixToRegPayList(PageDetails pageDetail) throws CustomException;
	
	public List<PVUMsPayScaleEntity> getFifthPayScale(FixpayToRegularRequestDto dto);
	
	public List<PVUMsPayBandEntity> getSixthPayBandValue(FixpayToRegularRequestDto dto);
	
	public Map<String, Object> getSixthGradePayValueAndEnterypayValue(FixpayToRegularRequestDto dto);

	public List<IdAndValueDto> getSevenPayLevel(FixpayToRegularRequestDto dto) ;
	
	public List<IdAndValueDto> getPayCellValue(FixpayToRegularRequestDto dto) ;

	public PVUFixToRegularPayConEntity saveOrUpdateFixToRegularPayCon(PVUFixToRegularPayConEntity entitiy,
			String action) throws CustomException;


	/**
	 * Retrieves an PVUFixToRegularPayConEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUFixToRegularPayConEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUFixToRegularPayConDto getFixToRegularPayCon(Long id);

	/**
	 * Saves all given PVUFixToRegularPayConEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	public void deleteFixToRegularPayCon(long id);
	
	
	public void checkEmployeeAlreadyinitiated(Long empId) throws CustomException ;

	public List<EDPLuLookUpInfoDto> getStatus();

}
