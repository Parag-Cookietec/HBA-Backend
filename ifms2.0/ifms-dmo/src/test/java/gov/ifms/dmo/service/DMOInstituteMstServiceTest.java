package gov.ifms.dmo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.constant.JunitConstants;
import gov.ifms.dmo.dto.DMOLookUpDto;
import gov.ifms.dmo.entity.DMOInstituteMstEntity;
import gov.ifms.dmo.entity.DMOLoanPurposeEntity;
import gov.ifms.dmo.repository.DMOInstituteMstRespository;
import gov.ifms.dmo.repository.DMOLoanPurposeEntityRepository;
import gov.ifms.dmo.service.impl.DMOInstituteMstServiceImpl;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.entity.EDPMsTreasuryEntity;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;
import gov.ifms.edp.repository.EDPMsTreasuryRepository;

@TestInstance(Lifecycle.PER_CLASS)
class DMOInstituteMstServiceTest {

	@InjectMocks
	DMOInstituteMstServiceImpl dmoInstituteMstServiceImpl;

	@Mock
	DMOInstituteMstRespository instituteMstRespository;
	@Mock
	EDPMsDesignationRepository designationRepository;
	@Mock
	DMOLoanPurposeEntityRepository dmoLoanPurposeEntityRepository;
	@Mock
	EDPMsTreasuryRepository edpMsTreasuryRepository;
	@Mock
	EDPMsFinancialYearRepository edpMsFinancialYearRepository;

	@Mock
	DMOInstituteMstEntity dmoInstituteMstEntity;

	@Mock
	EDPMsDesignationEntity designationEntity;
	@Mock
	DMOLoanPurposeEntity dmoLoanPurposeEntity;
	@Mock
	EDPMsTreasuryEntity edpMsTreasuryEntity;
	@Mock
	EDPMsFinancialYearEntity edpMsFinancialYearEntity;

	@Mock
	DMOLookUpDto dmoLookUpDto;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test service Get All Institute")
	void testGetAllInstitute() throws CustomException {
		dmoLookUpDto = new DMOLookUpDto();
		dmoInstituteMstEntity = new DMOInstituteMstEntity();
		dmoLookUpDto.setId(JunitConstants.LONG_TYPE);
		dmoLookUpDto.setName(JunitConstants.STRING_TYPE);
		dmoInstituteMstEntity.setId(JunitConstants.LONG_TYPE);
		dmoInstituteMstEntity.setInstituteName(JunitConstants.STRING_TYPE);
		List<DMOInstituteMstEntity> instituteMstrs = new ArrayList<DMOInstituteMstEntity>();
		instituteMstrs.add(dmoInstituteMstEntity);
		List<DMOLookUpDto> dtos = new ArrayList<DMOLookUpDto>();
		dtos.add(dmoLookUpDto);
		when(instituteMstRespository.findByActiveStatusOrderByInstituteNameAsc(JunitConstants.INTEGER_TYPE))
				.thenReturn(instituteMstrs);
		dtos = dmoInstituteMstServiceImpl.getAllInstitute();
		assertEquals(JunitConstants.LONG_TYPE, dtos.get(0).getId());
	}

	@Test
	@DisplayName("Test service Get All Designation")
	void testGetAllDesignation() throws CustomException {
		dmoLookUpDto = new DMOLookUpDto();
		designationEntity = new EDPMsDesignationEntity();
		dmoLookUpDto.setId(JunitConstants.LONG_TYPE);
		dmoLookUpDto.setName(JunitConstants.STRING_TYPE);
		designationEntity.setDesignationId(JunitConstants.LONG_TYPE);
		designationEntity.setDesignationName(JunitConstants.STRING_TYPE);
		List<EDPMsDesignationEntity> designationEntities = new ArrayList<EDPMsDesignationEntity>();
		designationEntities.add(designationEntity);
		List<DMOLookUpDto> dtos = new ArrayList<DMOLookUpDto>();
		dtos.add(dmoLookUpDto);
		when(designationRepository.findByActiveStatusEqualsOrderByDesignationNameAsc(JunitConstants.INTEGER_TYPE))
				.thenReturn(designationEntities);
		dtos = dmoInstituteMstServiceImpl.getAllDesignation();
		assertEquals(JunitConstants.LONG_TYPE, dtos.get(0).getId());
	}

	@Test
	@DisplayName("Test service Get All Purpose")
	void testGetAllPurpose() throws CustomException {
		dmoLookUpDto = new DMOLookUpDto();
		dmoLoanPurposeEntity = new DMOLoanPurposeEntity();
		dmoLookUpDto.setId(JunitConstants.LONG_TYPE);
		dmoLookUpDto.setName(JunitConstants.STRING_TYPE);
		dmoLoanPurposeEntity.setId(JunitConstants.LONG_TYPE);
		dmoLoanPurposeEntity.setLoanPurpose(JunitConstants.STRING_TYPE);
		List<DMOLoanPurposeEntity> loanPurposeEntities = new ArrayList<DMOLoanPurposeEntity>();
		loanPurposeEntities.add(dmoLoanPurposeEntity);
		List<DMOLookUpDto> dtos = new ArrayList<DMOLookUpDto>();
		dtos.add(dmoLookUpDto);
		when(dmoLoanPurposeEntityRepository.findByActiveStatusEqualsOrderByLoanPurposeAsc(JunitConstants.INTEGER_TYPE))
				.thenReturn(loanPurposeEntities);
		dtos = dmoInstituteMstServiceImpl.getAllPurpose();
		assertEquals(JunitConstants.LONG_TYPE, dtos.get(0).getId());
	}

	@Test
	@DisplayName("Test service Get All Treasury")
	void testGetAllTreasury() throws CustomException {
		dmoLookUpDto = new DMOLookUpDto();
		edpMsTreasuryEntity = new EDPMsTreasuryEntity();
		dmoLookUpDto.setId(JunitConstants.LONG_TYPE);
		dmoLookUpDto.setName(JunitConstants.STRING_TYPE);
		edpMsTreasuryEntity.setTreasuryId(JunitConstants.LONG_TYPE);
		edpMsTreasuryEntity.setTreasuryName(JunitConstants.STRING_TYPE);
		List<EDPMsTreasuryEntity> edpMsTreasuryEntities = new ArrayList<EDPMsTreasuryEntity>();
		edpMsTreasuryEntities.add(edpMsTreasuryEntity);
		List<DMOLookUpDto> dtos = new ArrayList<DMOLookUpDto>();
		dtos.add(dmoLookUpDto);
		when(edpMsTreasuryRepository.findByActiveStatusEqualsOrderByTreasuryNameAsc(JunitConstants.INTEGER_TYPE))
				.thenReturn(edpMsTreasuryEntities);
		dtos = dmoInstituteMstServiceImpl.getAllTreasury();
		assertEquals(JunitConstants.LONG_TYPE, dtos.get(0).getId());
	}

	@Test
	@DisplayName("Test service Get All Financial")
	void testGetAllFinancial() throws CustomException {
		dmoLookUpDto = new DMOLookUpDto();
		edpMsFinancialYearEntity = new EDPMsFinancialYearEntity();
		dmoLookUpDto.setId(JunitConstants.LONG_TYPE);
		dmoLookUpDto.setName(JunitConstants.STRING_TYPE);
		edpMsFinancialYearEntity.setFinancialYearId(JunitConstants.LONG_TYPE);
		edpMsFinancialYearEntity.setFy(JunitConstants.STRING_TYPE);
		List<EDPMsFinancialYearEntity> financialYearEntities = new ArrayList<EDPMsFinancialYearEntity>();
		financialYearEntities.add(edpMsFinancialYearEntity);
		List<DMOLookUpDto> dtos = new ArrayList<DMOLookUpDto>();
		dtos.add(dmoLookUpDto);
		when(edpMsFinancialYearRepository.findAllByActiveStatusOrderByFyStart(JunitConstants.INTEGER_TYPE))
				.thenReturn(financialYearEntities);
		dtos = dmoInstituteMstServiceImpl.getAllFinancial();
		assertEquals(JunitConstants.LONG_TYPE, dtos.get(0).getId());
	}
}
