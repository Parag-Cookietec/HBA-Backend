package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.pvu.converter.PVUEmployeTypeChangeConverter;
import gov.ifms.pvu.converter.PVUEmployeTypeChangeSDConverter;
import gov.ifms.pvu.dto.PVUEmployeTypeChangeDto;
import gov.ifms.pvu.dto.PVUEmployeeTypeDto;
import gov.ifms.pvu.entity.PVUEmployeTypeChangeEntity;
import gov.ifms.pvu.entity.PVUEmployeTypeChangeSDEntity;
import gov.ifms.pvu.repository.PVUEmployeTypeChangeRepository;
import gov.ifms.pvu.repository.PVUEmployeTypeChangeSDRepository;
import gov.ifms.pvu.service.PVUEmployeTypeChangeServiceImpl;

/**
 * The Class PVUEmployeServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class PVUEmployeTypeChangeServiceImplTest {

	@InjectMocks
	private PVUEmployeTypeChangeServiceImpl pVUEmployeTypeChangeServiceImpl;

	@Mock
	private PVUEmployeTypeChangeRepository repository;

	@Mock
	private PVUEmployeTypeChangeConverter converter;

	@Mock
	private PVUEmployeTypeChangeSDConverter sDconverter;

	@Mock
	private PVUEmployeeTypeDto pVUEmployeeTypeDto;

	@Mock
	private PVUEmployeTypeChangeDto employeTypeChangeDto;

	@Mock
	private PVUEmployeTypeChangeSDRepository sDrepository;

	@Mock
	private PVUEmployeTypeChangeEntity pVUEmployeTypeChangeEntity;

	@Mock
	private PVUEmployeTypeChangeSDEntity pVUSDEmployeTypeChangeEntity;

	/**
	 * Setup.
	 */
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	void testGetEmployeeDetails() throws CustomException {
		when(repository.getEmpDetails(1l)).thenReturn(pVUEmployeeTypeDto);
		Object[] results = { 5, 5, "username", 4, "n", 5, "n", 5, "n", 5, "n", "n", 5, "n", "n" };
		List<Object[]> resultw = new ArrayList<Object[]>();
		resultw.add(results);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(resultw);
		assertNotNull(pVUEmployeTypeChangeServiceImpl.getEmployeeDetails(employeTypeChangeDto));

	}

	@Test
	void testSaveOrUpdateEmploye() throws CustomException {
		PVUEmployeTypeChangeDto dto = new PVUEmployeTypeChangeDto();
		dto.setEmpId(1l);
		dto.setStatusId(327L);
		dto.setTpvuRegPrboId(null);
		dto.setTransNo("21-22/PVU/EPTC/000001");
		dto.setRefDate(LocalDateTime.now());
		dto.setCurrentEmpPaytype(161L);
		dto.setEmpPaytype(156L);
		dto.setFinancialYearId(1l);
		dto.setConvEffecDate(LocalDate.now());
		dto.setEmpIncEligible(2L);
		when(repository.findFYYearId("2021")).thenReturn(1l);
		Date d = new Date();
		d.setMonth(5);
		d.setYear(2021);
		PVUEmployeTypeChangeSDEntity pVUEmployeTypeSDChange = new PVUEmployeTypeChangeSDEntity();
		PVUEmployeTypeChangeEntity pVUEmployeTypeChangeEntity = new PVUEmployeTypeChangeEntity();
		pVUEmployeTypeChangeEntity.setCurrentEmpPaytype(161L);
		pVUEmployeTypeChangeEntity.setEmpIncEligible(2L);
		when(repository.findByEmpId(1l)).thenReturn(Mockito.notNull());
		when(repository.getyearCount("21-22/PVU/EPTC/000001")).thenReturn(1l);
		when(converter.toEntity(Mockito.any(PVUEmployeTypeChangeDto.class))).thenReturn(pVUEmployeTypeChangeEntity);
		pVUEmployeTypeSDChange.setActiveStatus(0);
		pVUEmployeTypeSDChange.setTpvuRegPrboSdId(1l);
		Mockito.when(sDrepository.save(Mockito.any(PVUEmployeTypeChangeSDEntity.class)))
				.thenReturn(pVUEmployeTypeSDChange);
		when(converter.toEntity(Mockito.any(PVUEmployeTypeChangeDto.class))).thenReturn(pVUEmployeTypeChangeEntity);
		Mockito.when(repository.save(Mockito.any(PVUEmployeTypeChangeEntity.class)))
				.thenReturn(pVUEmployeTypeChangeEntity);
		Mockito.when(repository.validateAdhoc(Mockito.anyLong()))
		.thenReturn(pVUEmployeeTypeDto);
		PVUEmployeTypeChangeDto pVUEmployeTypeChangeDto = new PVUEmployeTypeChangeDto();
		when(sDconverter.toDTO(Mockito.any(PVUEmployeTypeChangeSDEntity.class))).thenReturn(pVUEmployeTypeChangeDto);
		when(converter.toDTO(Mockito.any(PVUEmployeTypeChangeEntity.class))).thenReturn(pVUEmployeTypeChangeDto);
		assertNotNull(pVUEmployeTypeChangeServiceImpl.saveOrUpdateEmploye(dto));
	}

	@Test
	void testGetEmployeTypeChange() throws CustomException {
		PVUEmployeTypeChangeDto id = new PVUEmployeTypeChangeDto();
		id.setId(1l);
		id.setStatusId(55L);
		when(repository.getOne(1l)).thenReturn(pVUEmployeTypeChangeEntity);
		when(sDrepository.getOne(1l)).thenReturn(pVUSDEmployeTypeChangeEntity);
		PVUEmployeTypeChangeDto pVUEmployeTypeChangeDto = new PVUEmployeTypeChangeDto();
		when(converter.toDTO(Mockito.any(PVUEmployeTypeChangeEntity.class))).thenReturn(pVUEmployeTypeChangeDto);
		when(sDconverter.toDTO(Mockito.any(PVUEmployeTypeChangeSDEntity.class))).thenReturn(pVUEmployeTypeChangeDto);
		pVUEmployeTypeChangeDto.setEmpId(1l);
		when(repository.getEmpDetails(1l)).thenReturn(pVUEmployeeTypeDto);
		assertNotNull(pVUEmployeTypeChangeServiceImpl.getEmployeTypeChange(id));
	}

	@Test
	void fetchEmpTypeChange() throws CustomException {
		Object[] results = { "j", "2021-04-20T00.00.00.000000", 5, "username", "h", "n", "n", "n", 4, "jkk", 56 };
		List<Object[]> resultw = new ArrayList<Object[]>();
		resultw.add(results);
		when(repository.callStoredProcedure(Mockito.anyString(), Mockito.anyMap())).thenReturn(resultw);
		assertNotNull(pVUEmployeTypeChangeServiceImpl.fetchEmpTypeChange(employeTypeChangeDto));
	}

	@Test
	void testdeleteEmployeTypeChange() throws CustomException {
		IdDto id = new IdDto();
		id.setId(1l);
		pVUEmployeTypeChangeServiceImpl.deleteEmployeTypeChange(id);
	}

	@Test
	void testfindEmployeeOfficedetails() throws CustomException {
		when(repository.getEmpDetails(Mockito.anyLong())).thenReturn(pVUEmployeeTypeDto);
		assertNotNull(pVUEmployeTypeChangeServiceImpl.findEmployeeOfficedetails(Mockito.anyLong()));
	}

}
