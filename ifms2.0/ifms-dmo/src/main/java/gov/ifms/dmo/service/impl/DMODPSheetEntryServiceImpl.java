package gov.ifms.dmo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.dmo.converter.DMODPSheetEntryConverter;
import gov.ifms.dmo.converter.DMODPSheetEntryHDRConverter;
import gov.ifms.dmo.dto.DMODPDateSearchDto;
import gov.ifms.dmo.dto.DMODPSheetEntryDto;
import gov.ifms.dmo.dto.DMODPSheetEntryPostDto;
import gov.ifms.dmo.dto.DMODPSheetHDREntryPostDto;
import gov.ifms.dmo.entity.DMODPSheetEntryEntity;
import gov.ifms.dmo.entity.DMODPSheetHDREntity;
import gov.ifms.dmo.entity.DMOMarketLoanEntity;
import gov.ifms.dmo.repository.DMODPSheetEntryHRDRepository;
import gov.ifms.dmo.repository.DMODPSheetEntryRepository;
import gov.ifms.dmo.repository.DMOGOILoanRepository;
import gov.ifms.dmo.repository.DMOInstitutionLoanRepository;
import gov.ifms.dmo.repository.DMOMarketLoanRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.service.DMODPSheetEntryService;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.dmo.utils.DMOUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;

@Service
public class DMODPSheetEntryServiceImpl implements DMODPSheetEntryService {

	@Autowired
	DMODPSheetEntryRepository repository;

	@Autowired
	EDPLuLookUpInfoRepository lookUpInfoRepository;

	@Autowired
	DMODPSheetEntryConverter converter;

	@Autowired
	DMODPSheetEntryHRDRepository hrdRepository;
	@Autowired
	DMOInstitutionLoanRepository institutionLoanRepository;
	@Autowired
	DMOGOILoanRepository dmogoiLoanRepository;
	@Autowired
	DMONSSFLoanRepository dmonssfLoanRepository;
	@Autowired
	DMOMarketLoanRepository dmoMarketLoanRepository;

	@Autowired
	DMODPSheetEntryHDRConverter hrdConverter;

	/**
	 * Fetch all the DMODPSheetHDR items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<DMODPSheetHDREntity>
	 */
	@Override
	public PagebleDTO<DMODPSheetEntryPostDto> dpSheetListing(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<DMODPSheetEntryEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<DMODPSheetEntryEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<DMODPSheetEntryEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	@Override
	public DMODPSheetEntryPostDto findById(Long id) {
		return converter.toDTO(repository.getOne(id));
	}

	/**
	 * Convert given DMODPSheetHDREntryPostDto to DMODPSheetHDREntity Saves a given
	 * DMODPSheetHDREntity. Use the returned instance for further operations as the
	 * save operation might have changed the entity instance completely.
	 *
	 * @param dto the dto
	 * @return the saved DMODPSheetHDREntity
	 */
	@Override
	public DMODPSheetEntryDto saveOrUpdateDPSheet(DMODPSheetHDREntryPostDto dto) {
		DMODPSheetHDREntity hrdEntity = hrdConverter.toEntity(dto);
		hrdEntity.setRefDate(LocalDateTime.now());
		hrdEntity.setRefNo(generateTrnNo(DMOConstant.DPS_MENU_ID));
		hrdEntity.setFinancialYear("2021-2022");
		List<DMODPSheetEntryEntity> entryEntities = converter.toEntity(dto.getDpSheetDtos());
		hrdEntity.setEntities(entryEntities);
		hrdRepository.save(hrdEntity);
		return null;
	}

	/**
	 * Generate trn no.
	 *
	 * @param menuCode the menu code
	 * @return the string
	 */
	private String generateTrnNo(String menuCode) {
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(DMOConstant.TRN_SCREEN, menuCode);
		String procName = DMOConstant.DMO_SCHEMA.concat(Constant.DOT.concat(DMOConstant.TRANSACTION_NO_GENERATION));
		List<Object[]> responseList = hrdRepository.callStoredProcedure(procName, argMap);
		return DMOUtility.convertObjectToString(responseList.get(0)[0]);
	}

	/**
	 * Fetch all the DMODPSheetHDR items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<DMODPSheetHDREntity>
	 */
	@Override
	public DMODPSheetHDREntryPostDto searchByDate(DMODPDateSearchDto dateSearchDto) throws CustomException {

		DMODPSheetHDREntryPostDto dto = new DMODPSheetHDREntryPostDto();
		DMODPSheetHDREntity entity = hrdRepository.findByDpSheetReciveDateAndIsProcessed(
				Utils.convertStringToLocalDate(dateSearchDto.getDate()), DMOConstant.IS_PROCESSED);
		if (ObjectUtils.isEmpty(entity)) {
			dto.setDpSheetDtos(new ArrayList<>());
		}else {
			dto = hrdConverter.toDTO(entity);
			dto.setDpSheetDtos(converter.toDTO(entity.getEntities()));
		}
		return dto;

	}

	@Override
	public PagebleDTO<DMODPSheetEntryPostDto> dpSheetListingGoi(PageDetails pageDetail) throws CustomException {
		try {
			List<DMODPSheetEntryEntity> pages = new ArrayList<>();
			List<DMODPSheetEntryPostDto> page = new ArrayList<>();
			List<Long> tranc = new ArrayList<>();
			if(null != pageDetail.getSortByColumn()) {
				if(pageDetail.getSortByColumn().equalsIgnoreCase("1")) {
					tranc.add(26l);
					pages = repository.findAllByTransactionIdInAndAdviceDate(tranc, 
							pageDetail.getJsonArr().get(0).getValue(), pageDetail.getJsonArr().get(1).getValue(), (pageDetail.getPageIndex() * pageDetail.getPageElement()), pageDetail.getPageElement());
					for(DMODPSheetEntryEntity ent: pages) {
						DMODPSheetEntryPostDto dto = converter.toDTO(ent);
						if(dmogoiLoanRepository.findByAdviceNo(ent.getAdviceNo()).isPresent()) {
							dto.setAddDetailStatus(1);
						}else {
							dto.setAddDetailStatus(0);
						}
						page.add(dto);
					}
				}else {
					tranc.add(27l);
					tranc.add(28l);
					pages = repository.findAllByTransactionIdInAndAdviceDate(tranc, 
							pageDetail.getJsonArr().get(0).getValue(), pageDetail.getJsonArr().get(1).getValue(), (pageDetail.getPageIndex() * pageDetail.getPageElement()), pageDetail.getPageElement());
				}
			}else {
				pages = repository.findAllByTransactionId(26l, (pageDetail.getPageIndex() * pageDetail.getPageElement()), pageDetail.getPageElement());
				for(DMODPSheetEntryEntity ent: pages) {
					DMODPSheetEntryPostDto dto = converter.toDTO(ent);
					if(dmogoiLoanRepository.findByAdviceNo(ent.getAdviceNo()).isPresent()) {
						dto.setAddDetailStatus(1);
					}else {
						dto.setAddDetailStatus(0);
					}
					page.add(dto);
				}
			}
			int totalElement = repository.getSizeOfTransactionId(tranc, pageDetail.getJsonArr().get(0).getValue(), pageDetail.getJsonArr().get(1).getValue()).size();
			
			return new PagebleDTO<>(pageDetail.getPageElement(), DMOUtility.checkDecimal((double)totalElement /(double)pageDetail.getPageElement()), totalElement, page);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	@Override
	public PagebleDTO<DMODPSheetEntryPostDto> dpSheetListingNssf(PageDetails pageDetail) throws CustomException {
		try {
			List<DMODPSheetEntryEntity> pages = new ArrayList<>();
			List<DMODPSheetEntryPostDto> page = new ArrayList<>();
			List<Long> tranc = new ArrayList<>();
			if(null != pageDetail.getSortByColumn()) {
				if(pageDetail.getSortByColumn().equalsIgnoreCase("1")) {
					tranc.add(16l);
					pages = repository.findAllByTransactionIdInAndAdviceDate(tranc, 
							pageDetail.getJsonArr().get(0).getValue(), pageDetail.getJsonArr().get(1).getValue(), (pageDetail.getPageIndex() * pageDetail.getPageElement()), pageDetail.getPageElement());
					for(DMODPSheetEntryEntity ent: pages) {
						DMODPSheetEntryPostDto dto = converter.toDTO(ent);
						if(dmonssfLoanRepository.findByAdviceNo(ent.getAdviceNo()).isPresent()) {
							dto.setAddDetailStatus(1);
						}else {
							dto.setAddDetailStatus(0);
						}
						page.add(dto);
					}
				}else {
					tranc.add(17l);
					tranc.add(18l);
					pages = repository.findAllByTransactionIdInAndAdviceDate(tranc, 
							pageDetail.getJsonArr().get(0).getValue(), pageDetail.getJsonArr().get(1).getValue(), (pageDetail.getPageIndex() * pageDetail.getPageElement()), pageDetail.getPageElement());
				}
			}else {
				pages = repository.findAllByTransactionId(16l, (pageDetail.getPageIndex() * pageDetail.getPageElement()), pageDetail.getPageElement());
				for(DMODPSheetEntryEntity ent: pages) {
					DMODPSheetEntryPostDto dto = converter.toDTO(ent);
					if(dmonssfLoanRepository.findByAdviceNo(ent.getAdviceNo()).isPresent()) {
						dto.setAddDetailStatus(1);
					}else {
						dto.setAddDetailStatus(0);
					}
					page.add(dto);
				}
			}
			int totalElement = repository.getSizeOfTransactionId(tranc, pageDetail.getJsonArr().get(0).getValue(), pageDetail.getJsonArr().get(1).getValue()).size();
			return new PagebleDTO<>(pageDetail.getPageElement(), DMOUtility.checkDecimal((double)totalElement /(double)pageDetail.getPageElement()), totalElement, page);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	@Override
	public PagebleDTO<DMODPSheetEntryPostDto> dpSheetListingMarket(PageDetails pageDetail) throws CustomException {
		try {
			List<DMODPSheetEntryEntity> pages = new ArrayList<>();
			List<DMODPSheetEntryPostDto> page = new ArrayList<>();
			List<Long> tranc = new ArrayList<>();
			if(null != pageDetail.getSortByColumn()) {
				if(pageDetail.getSortByColumn().equalsIgnoreCase("1")) {
					tranc.add(19l);
					pages = repository.findAllByTransactionIdInAndAdviceDate(tranc, 
							pageDetail.getJsonArr().get(0).getValue(), pageDetail.getJsonArr().get(1).getValue(), (pageDetail.getPageIndex() * pageDetail.getPageElement()), pageDetail.getPageElement());
					for(DMODPSheetEntryEntity ent: pages) {
						DMODPSheetEntryPostDto dto = converter.toDTO(ent);
						Optional<List<DMOMarketLoanEntity>> findByAdviceNo = dmoMarketLoanRepository.findAllByAdviceNo(ent.getAdviceNo());
						if(findByAdviceNo.isPresent()) {
							dto.setAddDetailStatus(1);
						}else {
							dto.setAddDetailStatus(0);
						}
						page.add(dto);
					}
				}else {
					tranc.add(20l);
					tranc.add(21l);
					tranc.add(22l);
					pages = repository.findAllByTransactionIdInAndAdviceDate(tranc, 
							pageDetail.getJsonArr().get(0).getValue(), pageDetail.getJsonArr().get(1).getValue(), (pageDetail.getPageIndex() * pageDetail.getPageElement()), pageDetail.getPageElement());
				}
			}else {
				pages = repository.findAllByTransactionId(19l, (pageDetail.getPageIndex() * pageDetail.getPageElement()), pageDetail.getPageElement());
				for(DMODPSheetEntryEntity ent: pages) {
					DMODPSheetEntryPostDto dto = converter.toDTO(ent);
					if(dmoMarketLoanRepository.findByAdviceNo(ent.getAdviceNo()).isPresent()) {
						dto.setAddDetailStatus(1);
					}else {
						dto.setAddDetailStatus(0);
					}
					page.add(dto);
				}
			}
			int totalElement = repository.getSizeOfTransactionId(tranc, pageDetail.getJsonArr().get(0).getValue(), pageDetail.getJsonArr().get(1).getValue()).size();
			return new PagebleDTO<>(pageDetail.getPageElement(), DMOUtility.checkDecimal((double)totalElement /(double)pageDetail.getPageElement()), totalElement, page);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	@Override
	public PagebleDTO<DMODPSheetEntryPostDto> dpSheetListingInstitute(PageDetails pageDetail) throws CustomException {
		try {
			List<DMODPSheetEntryEntity> pages = new ArrayList<>();
			List<DMODPSheetEntryPostDto> page = new ArrayList<>();
			List<Long> tranc = new ArrayList<>();
			if(null != pageDetail.getSortByColumn()) {
				if(pageDetail.getSortByColumn().equalsIgnoreCase("1")) {
					tranc.add(23l);
					pages = repository.findAllByTransactionIdInAndAdviceDate( tranc, 
							pageDetail.getJsonArr().get(0).getValue(), pageDetail.getJsonArr().get(1).getValue(), (pageDetail.getPageIndex() * pageDetail.getPageElement()), pageDetail.getPageElement());
					for(DMODPSheetEntryEntity ent: pages) {
						DMODPSheetEntryPostDto dto = converter.toDTO(ent);
						if(institutionLoanRepository.findByAdviceNo(ent.getAdviceNo()).isPresent()) {
							dto.setAddDetailStatus(1);
						}else {
							dto.setAddDetailStatus(0);
						}
						page.add(dto);
					}
				}else {
					tranc.add(24l);
					tranc.add(25l);
					pages = repository.findAllByTransactionIdInAndAdviceDate(tranc, 
							pageDetail.getJsonArr().get(0).getValue(), pageDetail.getJsonArr().get(1).getValue(), (pageDetail.getPageIndex() * pageDetail.getPageElement()), pageDetail.getPageElement());
				}
			}else {
				pages = repository.findAllByTransactionId(23l, (pageDetail.getPageIndex() * pageDetail.getPageElement()), pageDetail.getPageElement());
				for(DMODPSheetEntryEntity ent: pages) {
					DMODPSheetEntryPostDto dto = converter.toDTO(ent);
					if(institutionLoanRepository.findByAdviceNo(ent.getAdviceNo()).isPresent()) {
						dto.setAddDetailStatus(1);
					}else {
						dto.setAddDetailStatus(0);
					}
					page.add(dto);
				}
			}
			int totalElement = repository.getSizeOfTransactionId(tranc, pageDetail.getJsonArr().get(0).getValue(), pageDetail.getJsonArr().get(1).getValue()).size();
			return new PagebleDTO<>(pageDetail.getPageElement(), DMOUtility.checkDecimal((double)totalElement /(double)pageDetail.getPageElement()), totalElement, page);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
}
