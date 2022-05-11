package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import gov.ifms.common.dto.IdDto;
import gov.ifms.pvu.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.pvu.converter.PVUEmployeDepartmentConverter;
import gov.ifms.pvu.converter.PVUEmployeHistoryConverter;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeHistoryEntity;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeHistoryRepository;
import gov.ifms.pvu.service.PVUEmployeDepartmentServiceImpl;

class PVUEmployeDepartmentServiceImplTest {
	@InjectMocks
	private PVUEmployeDepartmentServiceImpl service;

	@Mock
	private PVUEmployeDepartmentDtos pvuEmployeDepartmentDtos;

	@Mock
	private PVUEmployeDepartmentDto pvuEmployeDepartmentDto;

	 @Mock
      PVUEmployeHistoryEntity pvuEmployeHistoryEntity;

	@Mock
	private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;

	@Mock
	List<PVUEmployeHistoryDto> lst;

	@Mock
	List<PVUEmployeHistoryEntity> enLst;

	@Mock
	private PVUEmployeHistoryConverter pvuemployehistoryconverter;

	@Mock
	private PVUEmployeHistoryRepository pvuemployehistoryRepository;

	@Mock
	private PVUEmployeDepartmentConverter pvuEmployeDepartmentConverter;
	@Mock
	private PVUEmployeDepartmentEntity pvuEmployeDepartmentEntity;

	@Mock
	private PVUEmployeEntity pvuEmployeEntity;
	
	    @Mock
		Page<PVUEmployeDepartmentEntity> page;
		
		@Mock
		List<PVUEmployeDepartmentEntity> eLst;
		
		@Mock
		List<PVUEmployeDepartmentDto> dList;
		
		@Mock
		private EDPLuLookUpInfoEntity sdf;

	@Mock
	PVUEmployeHistoryRepository pvuEmployeHistoryRepositary;


	@BeforeEach
	public void setup() {

		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testSaveOrUpdateEmployeeDepartment() {
		PVUEmployeDepartmentDtos dtos = new PVUEmployeDepartmentDtos();
		when(pvuEmployeDepartmentDtos.getPvuEmployeDepartmentDto()).thenReturn(pvuEmployeDepartmentDto);
		when(pvuEmployeDepartmentConverter.toEntity(pvuEmployeDepartmentDto)).thenReturn(pvuEmployeDepartmentEntity);
		when(pvuEmployeDepartmentRepository.save(pvuEmployeDepartmentEntity)).thenReturn(pvuEmployeDepartmentEntity);
		when(pvuEmployeDepartmentDtos.getPvuEmployeHistoryDto()).thenReturn(lst);
		when(pvuemployehistoryconverter.toEntity(lst)).thenReturn(enLst);
		when(pvuemployehistoryRepository.saveAll(enLst)).thenReturn(enLst);
		dtos.setPvuEmployeHistoryDto(pvuemployehistoryconverter.toDTO(enLst));
		dtos.setPvuEmployeDepartmentDto(pvuEmployeDepartmentConverter.toDTO(pvuEmployeDepartmentEntity));
		service.saveOrUpdateEmployeeDepartment(pvuEmployeDepartmentDtos);
		assertNotNull(dtos);
		when(pvuEmployeDepartmentDto.getEmpId()).thenReturn(1l);
		getClassIdByEmpId();
		when(pvuEmployeDepartmentDtos.getPvuEmployeHistoryDto()).thenReturn(null);
		service.saveOrUpdateEmployeeDepartment(pvuEmployeDepartmentDtos);
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetEmployeDepartments() throws CustomException {
		

		 List<SearchParam> jsonArr = new ArrayList<SearchParam>();
			        jsonArr.add(new SearchParam("isSearch", "1"));
			        jsonArr.add(new SearchParam("empNo", "1"));
			        jsonArr.add(new SearchParam("empName", "V"));
			        jsonArr.add(new SearchParam("caseNo", " "));
			        jsonArr.add(new SearchParam("startDate", ""));
			        jsonArr.add(new SearchParam("endDate", ""));
			        jsonArr.add(new SearchParam("officeId", "0"));
			        jsonArr.add(new SearchParam("designationId", "0"));
			        jsonArr.add(new SearchParam("transNo", " "));
			        jsonArr.add(new SearchParam("workflowId", "0"));

			        PageDetails pageDetail = new PageDetails();
			        pageDetail.setPageElement(1);
			        pageDetail.setPageIndex(0);
			        pageDetail.setJsonArr(jsonArr);
			        when(pvuEmployeDepartmentRepository.findAll(Mockito.any(Specification.class),Mockito.any(PageRequest.class))).thenReturn(page);
			        when(page.getContent()).thenReturn(eLst);
			        when(pvuEmployeDepartmentConverter.toDTO(eLst)).thenReturn(dList);
		service.getEmployeDepartments(pageDetail);
	}

	@Test
	void testGetEmployeeDepartment() {
		PVUEmployeDepartmentDtos dtos = new PVUEmployeDepartmentDtos();
		when(pvuEmployeDepartmentRepository.findOneByPvuEmployeEntityEmpId(1l)).thenReturn(pvuEmployeDepartmentEntity);
		when(pvuEmployeDepartmentConverter.toDTO(pvuEmployeDepartmentEntity)).thenReturn(pvuEmployeDepartmentDto);
		dtos.setPvuEmployeDepartmentDto(pvuEmployeDepartmentDto);
		pvuEmployeDepartmentEntity.setActiveStatus(1);

		when(pvuEmployeEntity.getEmpId()).thenReturn(1l);
		when(pvuEmployeDepartmentEntity.getPvuEmployeEntity()).thenReturn(pvuEmployeEntity);
		when(pvuemployehistoryRepository.findPVUEmployeHistoryEntityBypvuEmployeEntityEmpId(1l)).thenReturn(enLst);
		when(pvuemployehistoryconverter.toDTO(enLst)).thenReturn(lst);
		dtos.setPvuEmployeHistoryDto(lst);
		service.getEmployeeDepartment(1l);
		assertNotNull(dtos);

		service.getEmployeeDepartment(null);
		pvuEmployeDepartmentEntity = null;
		service.getEmployeeDepartment(null);

	}

	@Test
	void getClassIdByEmpId()
	{
		when(pvuEmployeDepartmentRepository.findOneByPvuEmployeEntityEmpId(1l)).thenReturn(pvuEmployeDepartmentEntity);
		when(pvuEmployeDepartmentEntity.getEmpClass()).thenReturn(sdf);
		when(sdf.getLookUpInfoId()).thenReturn(1l);
		assertNotNull(service.getClassIdByEmpId(1l));
	}

	@Test
	void testGetQuerieOfHistoryOfEmpPRVHistByEmpId() throws CustomException{
		StringBuilder sb = new StringBuilder();
		IdDto idDtod = new IdDto();
		idDtod.setId(1l);
		PVUEmployeeSqlQueries.getQuerieOfHistoryOfEmpPRVHistByEmpId(idDtod,sb);
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(pvuEmployeDepartmentRepository.executeSQLQueryOnly(Mockito.anyString())).thenReturn(objects);
		assertNotNull(service.getQuerieOfHistoryOfEmpPRVHistByEmpId(idDtod));
	}

	@Test
	void testGetQuerieOfHistoryOfEmpDepartmentByEmpId() throws CustomException{
		StringBuilder sb = new StringBuilder();
		IdDto idDtod = new IdDto();
		idDtod.setId(1l);
		PVUEmployeeSqlQueries.getQuerieOfHistoryOfEmpPRVHistByEmpId(idDtod,sb);
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(pvuEmployeDepartmentRepository.executeSQLQueryOnly(Mockito.anyString())).thenReturn(objects);
		assertNotNull(service.getQuerieOfHistoryOfEmpDepartmentByEmpId(idDtod));
	}

	@Test
	void testEditEmployeeDepartment() {
		PVUEmployeDepartmentUpdateDtos dtos = new PVUEmployeDepartmentUpdateDtos();
		PVUEmployeDepartmentEditabelDto pvuEmployeDepartmentDtoedit =  new PVUEmployeDepartmentEditabelDto();
		pvuEmployeDepartmentDtoedit.setChangeType(1l);
		pvuEmployeDepartmentDtoedit.setEmpId(1l);
		pvuEmployeDepartmentDtoedit.setDepartmentId(1l);
		dtos.setPvuEmployeDepartmentDto(pvuEmployeDepartmentDtoedit);
		List<PVUEmployeHistoryEditFormdataDto> hisList = new ArrayList<>();

		PVUEmployeHistoryEditFormdataDto historyDto = new PVUEmployeHistoryEditFormdataDto();
		historyDto.setChangeType(1l);
		historyDto.setEmployeHistroyId(1l);
		hisList.add(historyDto);

		PVUEmployeHistoryEditFormdataDto historyDto2 = new PVUEmployeHistoryEditFormdataDto();
		historyDto2.setChangeType(2l);
		historyDto2.setEmployeHistroyId(1l);
		hisList.add(historyDto2);

		PVUEmployeHistoryEditFormdataDto historyDto3 = new PVUEmployeHistoryEditFormdataDto();
		historyDto3.setChangeType(3l);
		historyDto3.setEmployeHistroyId(1l);
		hisList.add(historyDto3);

		dtos.setPvuEmployeHistoryDto(hisList);
		EmployeeChangeType type = new EmployeeChangeType();
		getClassIdByEmpId();
		when(pvuEmployeDepartmentConverter.toEditEntity(pvuEmployeDepartmentEntity,pvuEmployeDepartmentDtoedit)).thenReturn(pvuEmployeDepartmentEntity);
		when(pvuEmployeDepartmentRepository.save(pvuEmployeDepartmentEntity)).thenReturn(pvuEmployeDepartmentEntity);
		when(pvuemployehistoryconverter.toEntityUpdate(pvuEmployeHistoryEntity,new PVUEmployeHistoryEditFormdataDto())).thenReturn(pvuEmployeHistoryEntity);
		when(pvuemployehistoryRepository.saveAll(enLst)).thenReturn(enLst);
		when(pvuEmployeHistoryRepositary.findById(1l)).thenReturn(Optional.of(pvuEmployeHistoryEntity));
		service.editEmployeeDepartment(dtos,type);
		assertNotNull(dtos);
		dtos.setPvuEmployeHistoryDto(null);
		service.editEmployeeDepartment(dtos,type);
		when(pvuEmployeDepartmentDtos.getPvuEmployeHistoryDto()).thenReturn(null);
		service.editEmployeeDepartment(dtos,type);
	}

}
