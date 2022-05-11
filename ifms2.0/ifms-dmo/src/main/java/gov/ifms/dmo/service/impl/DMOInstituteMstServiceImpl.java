package gov.ifms.dmo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.dmo.dto.DMOLookUpDto;
import gov.ifms.dmo.entity.DMOInstituteMstEntity;
import gov.ifms.dmo.entity.DMOLoanPurposeEntity;
import gov.ifms.dmo.repository.DMOInstituteMstRespository;
import gov.ifms.dmo.repository.DMOLoanPurposeEntityRepository;
import gov.ifms.dmo.service.DMOInstituteMstService;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.entity.EDPMsTreasuryEntity;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;
import gov.ifms.edp.repository.EDPMsTreasuryRepository;

@Service
public class DMOInstituteMstServiceImpl implements DMOInstituteMstService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	DMOInstituteMstRespository instituteMstRespository;

	@Autowired
	EDPMsDesignationRepository designationRepository;
	@Autowired
	DMOLoanPurposeEntityRepository dmoLoanPurposeEntityRepository;

	@Autowired
	EDPMsTreasuryRepository edpMsTreasuryRepository;

	@Autowired
	EDPMsFinancialYearRepository edpMsFinancialYearRepository;

	@Override
	public List<DMOLookUpDto> getAllInstitute() throws CustomException {
		try {
			List<DMOInstituteMstEntity> instituteMstrs = instituteMstRespository
					.findByActiveStatusOrderByInstituteNameAsc(Constant.ACTIVE_STATUS);
			return instituteMstrs.stream().map(institute -> {
				DMOLookUpDto dto = new DMOLookUpDto();
				dto.setId(institute.getId());
				dto.setName(institute.getInstituteName());
				return dto;
			}).collect(Collectors.toList());
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public List<DMOLookUpDto> getAllDesignation() throws CustomException {
		try {
			List<EDPMsDesignationEntity> instituteMstrs = designationRepository
					.findByActiveStatusEqualsOrderByDesignationNameAsc(1);
			return instituteMstrs.stream().map(institute -> {
				DMOLookUpDto dto = new DMOLookUpDto();
				dto.setId(institute.getDesignationId());
				dto.setName(institute.getDesignationName());
				return dto;
			}).collect(Collectors.toList());

		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public List<DMOLookUpDto> getAllPurpose() throws CustomException {
		try {
			List<DMOLoanPurposeEntity> instituteMstrs = dmoLoanPurposeEntityRepository
					.findByActiveStatusEqualsOrderByLoanPurposeAsc(1);
			return instituteMstrs.stream().map(institute -> {
				DMOLookUpDto dto = new DMOLookUpDto();
				dto.setId(institute.getId());
				dto.setName(institute.getLoanPurpose());
				dto.setSchemeName(institute.getPlanSchemeName());
				return dto;
			}).collect(Collectors.toList());

		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public List<DMOLookUpDto> getAllTreasury() throws CustomException {
		try {
			List<EDPMsTreasuryEntity> instituteMstrs = edpMsTreasuryRepository
					.findByActiveStatusEqualsOrderByTreasuryNameAsc(1);
			return instituteMstrs.stream().map(institute -> {
				DMOLookUpDto dto = new DMOLookUpDto();
				dto.setId(institute.getTreasuryId());
				dto.setName(institute.getTreasuryName());
				return dto;
			}).collect(Collectors.toList());

		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public List<DMOLookUpDto> getAllFinancial() throws CustomException {
		try {
			List<EDPMsFinancialYearEntity> instituteMstrs = edpMsFinancialYearRepository
					.findAllByActiveStatusOrderByFyStart(1);
			return instituteMstrs.stream().map(institute -> {
				DMOLookUpDto dto = new DMOLookUpDto();
				dto.setId(institute.getFinancialYearId());
				dto.setName(institute.getFy());
				return dto;
			}).collect(Collectors.toList());

		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
}
