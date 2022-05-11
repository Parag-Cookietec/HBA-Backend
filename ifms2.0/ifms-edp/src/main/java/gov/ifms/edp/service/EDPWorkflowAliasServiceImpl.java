package gov.ifms.edp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPHeaderParam;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;

@Service
public class EDPWorkflowAliasServiceImpl implements EDPWorkflowAliasService {

	@Autowired
	private EDPMsOfficeRepository officeRepository;

	@Autowired
	private EDPLuLookUpInfoRepository lookupInfoRepository;

	@Autowired
	private EDPMsDistrictRepository districtRepository;

	@Override
	public ClueDto getOfficeDetailsByAlias(String alias, Long districtId) {

		ClueDto clueDto = new ClueDto();		
		if(EDPConstant.TO_PAO_ALIAS.equalsIgnoreCase(alias)) {
			EDPMsDistrictEntity districtEntity = districtRepository.findByDistrictIdAndActiveStatus(districtId, Constant.ACTIVE_STATUS);
			if(districtEntity.getDistrictCode().equals(EDPConstant.GNR_PAO_DIST_CODE)) {
				EDPMsOfficeEntity paoOffice = officeRepository.findByOfficeCodeAndActiveStatus(EDPConstant.GNR_PAO_OFFICE_CODE, Constant.ACTIVE_STATUS);
				clueDto.setOfficeId(paoOffice.getOfficeId());
				clueDto.setOfficeName(paoOffice.getOfficeName());
			}else if(districtEntity.getDistrictCode().equals(EDPConstant.AHMD_PAO_DIST_CODE)){
				EDPMsOfficeEntity paoOffice = officeRepository.findByOfficeCodeAndActiveStatus(EDPConstant.AHMD_PAO_OFFICE_CODE, Constant.ACTIVE_STATUS);
				clueDto.setOfficeId(paoOffice.getOfficeId());
				clueDto.setOfficeName(paoOffice.getOfficeName());
			}
			else {
				EDPLuLookUpInfoEntity toEntity = lookupInfoRepository.findByLookUpInfoNameAndEdpLuLookUpEntityLookUpNameAndActiveStatus(EDPConstant.TREASURY_OFFICE,EDPConstant.OFFICE_SUB_TYPE, Constant.ACTIVE_STATUS);
				EDPMsOfficeEntity treasuryOffice = officeRepository.findByDistrictIdDistrictIdAndOfficeSubTypeAndActiveStatus(districtId, toEntity.getLookUpInfoId(), Constant.ACTIVE_STATUS);
				clueDto.setOfficeId(treasuryOffice.getOfficeId());
				clueDto.setOfficeName(treasuryOffice.getOfficeName());				
			}
		}else if(EDPConstant.DAT_ALIAS.equalsIgnoreCase(alias)) {
			EDPMsOfficeEntity datOffice = officeRepository.findByOfficeDivisionAndActiveStatus(EDPConstant.DAT_OFFICE, Constant.ACTIVE_STATUS);
			clueDto.setOfficeId(datOffice.getOfficeId());
			clueDto.setOfficeName(datOffice.getOfficeName());
		}
		return clueDto;
	}

	/**
	 * Gets the wf comman header.
	 *
	 * @param dto the dto
	 * @return the wf comman header
	 * @throws CustomException
	 */
	@Override
	public List<EDPHeaderParam> getWfCommanHeader(ClueDto dto) throws CustomException {
		Map<String, Object> response = officeRepository.jdbcCallStoredProcedureForEDPWfHeaderApi(dto.getId(),
				dto.getMenuId());
		return EDPUtility.getWFHeaderResponse(response);
	}

}
