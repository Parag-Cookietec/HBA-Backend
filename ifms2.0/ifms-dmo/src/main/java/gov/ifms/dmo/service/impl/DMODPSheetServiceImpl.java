package gov.ifms.dmo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.dmo.converter.DMODPSheetEntryConverter;
import gov.ifms.dmo.converter.DMODPSheetEntryHDRConverter;
import gov.ifms.dmo.dto.DMODPSheetEntryPostDto;
import gov.ifms.dmo.dto.DMODPSheetHDREntryPostDto;
import gov.ifms.dmo.dto.DMODPSheetHDRPostDto;
import gov.ifms.dmo.dto.DMOLookUpDto;
import gov.ifms.dmo.entity.DMODPSheetEntryEntity;
import gov.ifms.dmo.entity.DMODPSheetHDREntity;
import gov.ifms.dmo.repository.DMODPSheetEntryHRDRepository;
import gov.ifms.dmo.repository.DMODPSheetEntryRepository;
import gov.ifms.dmo.service.DMODPSheetService;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.dmo.utils.DMOUtility;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;

@Service
public class DMODPSheetServiceImpl implements DMODPSheetService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private DMODPSheetEntryHRDRepository dpSheetEntryHRDRepository;

	@Autowired
	private DMODPSheetEntryRepository dpSheetEntryRepository;

	@Autowired
	private EDPMsFinancialYearRepository financialYearRepository;

	@Autowired
	private DMODPSheetEntryHDRConverter hrdConverter;

	@Autowired
	private DMODPSheetEntryConverter entityConverter;

	@Override
	public PagebleDTO<DMODPSheetHDREntryPostDto> getDPSheetByCodeAndDateAndRcvdDt(DMODPSheetHDRPostDto dto)
			throws CustomException {
		try {
			DMODPSheetHDREntryPostDto hrdEntityPostDto = new DMODPSheetHDREntryPostDto();
			Map<String, Object> spParamMap = new HashMap<>();
			String dpSheetReceivedDate = dto.getDpSheetReciveDate();
			String dpSheetDate = dto.getDpSheetDate();
			String gocCode = String.valueOf(dto.getGogCode());
			List<DMODPSheetHDREntryPostDto> dpSheetHdrlist = new ArrayList<>();

			if (StringUtils.isNotBlank(dto.getDpSheetReciveDate())) {
				Optional<DMODPSheetHDREntity> dpSheetHdrEntityOptional = dpSheetEntryHRDRepository
						.findByDpSheetDate(dto.getDpSheetReciveDate(), DMOConstant.IS_DE_ACTIVE_STATUS);
				if (dpSheetHdrEntityOptional.isPresent()) {
					DMODPSheetHDREntity dmodpSheetHDREntity = dpSheetHdrEntityOptional.get();
					hrdEntityPostDto = hrdConverter.toDTO(dmodpSheetHDREntity);
					dpSheetDate = String.valueOf(hrdEntityPostDto.getDpSheetDate());
					gocCode = String.valueOf(hrdEntityPostDto.getGogCode());
				}
			} else {
				Optional<DMODPSheetHDREntity> dpSheetHdrEntityOptional = dpSheetEntryHRDRepository
						.findByGogCodeAndDpSheetDate(dto.getDpSheetDate(), dto.getGogCode(),
								DMOConstant.IS_DE_ACTIVE_STATUS);
				if (dpSheetHdrEntityOptional.isPresent()) {
					DMODPSheetHDREntity dmodpSheetHDREntity = dpSheetHdrEntityOptional.get();
					hrdEntityPostDto = hrdConverter.toDTO(dmodpSheetHDREntity);
				}
			}

			spParamMap.put(DMOConstant.IN_PAGE_INDEX, dto.getPageIndex());
			spParamMap.put(DMOConstant.IN_PAGE_SIZE, dto.getPageElement());
			spParamMap.put(DMOConstant.IN_GOG_CODE, gocCode);
			spParamMap.put(DMOConstant.IN_DP_SHEET_DT, dpSheetDate);
			spParamMap.put(DMOConstant.IN_DP_SHEET_RCVD_DT, dpSheetReceivedDate);
			String procName = DMOConstant.DMO_SCHEMA.concat(Constant.DOT.concat(DMOConstant.SP_DP_SHEET_GET_DTL));
			List<Object[]> responseList = dpSheetEntryHRDRepository.callStoredProcedure(procName, spParamMap);
			List<DMODPSheetEntryPostDto> response = NativeQueryResultsMapper.map(responseList,
					DMODPSheetEntryPostDto.class);
			hrdEntityPostDto.setDpSheetDtos(response);
			dpSheetHdrlist.add(hrdEntityPostDto);
			return new PagebleDTO<>(dto.getPageElement(), 0, response.isEmpty() ? 0 : response.get(0).getCount(),
					dpSheetHdrlist);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public DMODPSheetHDREntryPostDto getLatestDPSheet() throws CustomException {
		try {

			Optional<DMODPSheetHDREntity> dpSheetHdrEntityOptional = dpSheetEntryHRDRepository.findOneByOrderByIdDesc();
			if (dpSheetHdrEntityOptional.isPresent()) {
				DMODPSheetHDREntryPostDto dto = new DMODPSheetHDREntryPostDto();
				DMODPSheetHDREntity dmodpSheetHDREntity = dpSheetHdrEntityOptional.get();
				dto.setGogCode(dmodpSheetHDREntity.getGogCode());
				dto.setDpSheetDate(dmodpSheetHDREntity.getDpSheetDate());
				dto.setRefNo(dmodpSheetHDREntity.getRefNo());
				dto.setRefDate(dmodpSheetHDREntity.getRefDate());
				return dto;
			}
			return null;
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public Object deleteDpSheetDtl(IdDto idDto) throws CustomException {
		try {
			Optional<DMODPSheetEntryEntity> dpSheetEntryOptional = dpSheetEntryRepository.findById(idDto.getId());
			if (dpSheetEntryOptional.isPresent()) {
				DMODPSheetEntryEntity dmodpSheetEntryEntity = dpSheetEntryOptional.get();
				dmodpSheetEntryEntity.setActiveStatus(DMOConstant.IS_DE_ACTIVE_STATUS);
				dpSheetEntryRepository.save(dmodpSheetEntryEntity);
				return "Successfull Delete.";
			}
			return "Failed to delete record.";
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public DMODPSheetHDREntryPostDto saveAsDraftDPSheet(DMODPSheetHDREntryPostDto dto) throws CustomException {
		try {
			Optional<DMODPSheetHDREntity> dpSheetHdrOptional = dpSheetEntryHRDRepository.findById(dto.getDpSheetId());
			if (dpSheetHdrOptional.isPresent()) {
				DMODPSheetHDREntity hrdEntity = dpSheetHdrOptional.get();
				hrdEntity.setRefDate(LocalDateTime.now());
				if (StringUtils.isBlank(dto.getRefNo())) {
					hrdEntity.setRefNo(generateTrnNo(DMOConstant.DPS_MENU_ID));
				}
				hrdEntity.setFinancialYear(dto.getFinancialYear());
				hrdEntity.setTotSheetAmt(dto.getTotSheetAmt());
				hrdEntity.setClosMinBal(dto.getClosMinBal());
				hrdEntity.settBill14DBal(dto.gettBill14DBal());
				List<DMODPSheetEntryEntity> entryEntities = new ArrayList<>();
				dto.getDpSheetDtos().stream().forEach(entityEntrydto -> {
					Optional<DMODPSheetEntryEntity> entryEntityOptional = dpSheetEntryRepository
							.findById(entityEntrydto.getDpSheetDtlId());
					if (entryEntityOptional.isPresent()) {
						DMODPSheetEntryEntity entryEntity = entryEntityOptional.get();
						entryEntity = entityConverter.toEntity(entityEntrydto);
						entryEntities.add(entryEntity);
					}
				});
				if (StringUtils.isNotBlank(dto.getApiName()) && "saveAsDraft".equalsIgnoreCase(dto.getApiName()))
					hrdEntity.setActiveStatus(DMOConstant.IS_DE_ACTIVE_STATUS);
				else if (StringUtils.isNotBlank(dto.getApiName()) && "submit".equalsIgnoreCase(dto.getApiName()))
					hrdEntity.setActiveStatus(DMOConstant.IS_ACTIVE_STATUS);
				hrdEntity.setEntities(entryEntities);
				DMODPSheetHDREntity dmodpSheetHDREntity = dpSheetEntryHRDRepository.save(hrdEntity);
				DMODPSheetHDREntryPostDto hrdEntityPostDto = hrdConverter.toDTO(dmodpSheetHDREntity);
				List<DMODPSheetEntryPostDto> entryEntitiesDtos = entityConverter
						.toDTO(dmodpSheetHDREntity.getEntities());
				hrdEntityPostDto.setDpSheetDtos(entryEntitiesDtos);
				return hrdEntityPostDto;
			}
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		return dto;
	}

	private String generateTrnNo(String menuCode) {
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(DMOConstant.TRN_SCREEN, menuCode);
		String procName = DMOConstant.DMO_SCHEMA.concat(Constant.DOT.concat(DMOConstant.TRANSACTION_NO_GENERATION));
		List<Object[]> responseList = dpSheetEntryHRDRepository.callStoredProcedure(procName, argMap);
		return DMOUtility.convertObjectToString(responseList.get(0)[0]);
	}

	@Override
	public List<DMOLookUpDto> fyDropDown() {
		List<EDPMsFinancialYearEntity> financialYearEntities = financialYearRepository
				.findByActiveStatus(DMOConstant.IS_ACTIVE_STATUS, Sort.by("financialYearId").ascending());
		return financialYearEntities.stream().map(fy -> {
			DMOLookUpDto lookUpData = new DMOLookUpDto();
			lookUpData.setId(fy.getFinancialYearId());
			lookUpData.setName(fy.getFy());
			return lookUpData;
		}).collect(Collectors.toList());
	}

}
