package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gov.ifms.pvu.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.converter.PVUEmployeCCCExamDetailConverter;
import gov.ifms.pvu.converter.PVUEmployeDeptExamDetailsConverter;
import gov.ifms.pvu.converter.PVUEmployeLangExamConverter;
import gov.ifms.pvu.converter.PVUEmployeQualificationConverter;
import gov.ifms.pvu.entity.PVUEmployeCCCExamDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeDeptExamDetailsEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeLangExamEntity;
import gov.ifms.pvu.entity.PVUEmployeQualificationEntity;
import gov.ifms.pvu.repository.PVUEmployeCCCExamDetailRepository;
import gov.ifms.pvu.repository.PVUEmployeDeptExamDetailsRepository;
import gov.ifms.pvu.repository.PVUEmployeLangExamRepository;
import gov.ifms.pvu.repository.PVUEmployeQualificationRepository;
import gov.ifms.pvu.service.PVUEmployeQualificationServiceImpl;

class PVUEmployeQualificationServiceImplTest {

	@InjectMocks
	private PVUEmployeQualificationServiceImpl pvuEmployeQualificationServiceImpl;
	@Mock
	private PVUEmployeQualificationRepository pvuEmployeQualificationRepository;

	@Mock
	private PVUEmployeQualificationEntity pvuEmployeQualificationEntity;

	@Mock
	private PVUEmployeQualificationConverter pvuEmployeQualificationConverter;

	@Mock
	private PVUEmployeeQualificationDtos pvuEmployeeQualificationDtos;

	@Mock
	List<PVUEmployeQualificationDto> list;
//	@Mock
//	List<PVUEmployeQualificationEntity> enList;
	@Mock
	PVUEmployeQualificationEntity em;
	@Mock
	List<PVUEmployeCCCExamDetailDto> ccList;
	
	@Mock
	private PVUEmployeCCCExamDetailDto pvuEmployeCCCExamDetailDto;

	@Mock
	List<PVUEmployeCCCExamDetailEntity> ccEnList;

	@Mock
	private PVUEmployeCCCExamDetailEntity pvuEmployeCCCExamDetailEntity;

	@Mock
	private EDPLuLookUpInfoRepository luLookUpInfoRepository;

	@Mock
	private PVUEmployeCCCExamDetailRepository cccExamDetailsRepository;

	@Mock
	private PVUEmployeQualificationRepository repository;
	@Mock
	private PVUEmployeCCCExamDetailConverter cccExamDetailsConverter;

	@Mock
	List<PVUEmployeLangExamDto> laList;

	@Mock
	List<PVUEmployeLangExamEntity> laEnList;

	@Mock
	private PVUEmployeLangExamRepository langExamDetailsRepository;
	@Mock
	private PVUEmployeLangExamConverter langExamDetailsConverter;

	@Mock
	List<PVUEmployeDeptExamDetailsDto> exList;

	@Mock
	List<PVUEmployeDeptExamDetailsEntity> exEnList;

	@Mock
	PVUEmployeDeptExamDetailsEntity ent;

	@Mock
	private PVUEmployeDeptExamDetailsRepository deptExamDetailsRepository;
	@Mock
	private PVUEmployeDeptExamDetailsConverter deptExamDetailsConverter;

	@Mock
	private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;

	@Mock
	private List<PVUEmployeQualificationEntity> qenList;

	@Mock
	private List<PVUEmployeQualificationDto> qdtList;

	@Mock
	private PVUEmployeEntity pvuEmployeEntity;

	@Mock
	private PVUEmployeEntity employeEntity;

	@Mock
	private PVUEmployeDeptExamDetailsDto pvuEmployeDeptExamDetailsDto;

	@Mock
	PVUEmployeeQualificationUpdateDtos pvuEmployeUpdateDtos;

	@Mock
	private PVUEmployeCCCExamDetailConverter cccExamDetailConverter;

	@Mock
	private PVUEmployeCCCExamDetailRepository cccExamDetailRepository;

	@Mock
	List<PVUEmployeDeptExamDetailsEditableDto> lisDpt;

	@Mock
	List<PVUEmployeCCCExamDetailEditableDto> listccc;

	@Mock
	List<PVUEmployeLangExamEditableDto> listLang;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	void testGetEmployeQualification() {
		when(pvuEmployeQualificationRepository.getOne(1l)).thenReturn(pvuEmployeQualificationEntity);
		pvuEmployeQualificationServiceImpl.getEmployeQualification(1l);
//		verify(pvuEmployeQualificationRepository, times(1)).getOne(1L);
	}

	@Test
	void testSaveOrUpdateEmployeQualification() throws CustomException {
		when(luLookUpInfoRepository.findByLookUpInfoName("Exempted")).thenReturn(edpLuLookUpInfoEntity);
		when(luLookUpInfoRepository.findByLookUpInfoName("Pass")).thenReturn(edpLuLookUpInfoEntity);
		when(pvuEmployeeQualificationDtos.getPvuEmployeQualificationDto()).thenReturn(list);
		when(pvuEmployeQualificationConverter.toEntity(list)).thenReturn(qenList);
		when(repository.saveAll(qenList)).thenReturn(qenList);
		when(pvuEmployeeQualificationDtos.getPvuEmployeLangExamDto()).thenReturn(laList);
		when(langExamDetailsConverter.toEntity(laList)).thenReturn(laEnList);
		when(langExamDetailsRepository.saveAll(laEnList)).thenReturn(laEnList);
		when(qenList.get(0)).thenReturn(pvuEmployeQualificationEntity);
		when(pvuEmployeQualificationEntity.getPvuEmployeEntity()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeeQualificationDtos.isExemptedDeptExamFlag()).thenReturn(true);
		when(pvuEmployeeQualificationDtos.getExemptedDeptExam()).thenReturn(pvuEmployeDeptExamDetailsDto);
		when(deptExamDetailsConverter.toEntity(pvuEmployeDeptExamDetailsDto)).thenReturn(ent);
		when(pvuEmployeeQualificationDtos.isExemptedCccExamFlag()).thenReturn(true);
		when(pvuEmployeeQualificationDtos.getExemptedCccExam()).thenReturn(pvuEmployeCCCExamDetailDto);
		when(cccExamDetailsConverter.toEntity(pvuEmployeCCCExamDetailDto)).thenReturn(pvuEmployeCCCExamDetailEntity);
		when(cccExamDetailConverter.toEntity(pvuEmployeeQualificationDtos.getPvuEmployeCCCExamDetailDto())).thenReturn(ccEnList);

		assertNotNull(
				pvuEmployeQualificationServiceImpl.saveOrUpdateEmployeQualification(pvuEmployeeQualificationDtos));
		when(luLookUpInfoRepository.findByLookUpInfoName("Exempted")).thenReturn(edpLuLookUpInfoEntity);
		when(luLookUpInfoRepository.findByLookUpInfoName("Pass")).thenReturn(edpLuLookUpInfoEntity);
		when(pvuEmployeeQualificationDtos.getPvuEmployeQualificationDto()).thenReturn(list);
		when(pvuEmployeQualificationConverter.toEntity(list)).thenReturn(qenList);
		when(repository.saveAll(qenList)).thenReturn(qenList);
		when(pvuEmployeeQualificationDtos.getPvuEmployeLangExamDto()).thenReturn(laList);
		when(langExamDetailsConverter.toEntity(laList)).thenReturn(laEnList);
		when(langExamDetailsRepository.saveAll(laEnList)).thenReturn(laEnList);
		when(qenList.get(0)).thenReturn(pvuEmployeQualificationEntity);
		when(pvuEmployeQualificationEntity.getPvuEmployeEntity()).thenReturn(pvuEmployeEntity);
		when(pvuEmployeeQualificationDtos.isExemptedCccExamFlag()).thenReturn(false);
		when(pvuEmployeeQualificationDtos.isExemptedDeptExamFlag()).thenReturn(false);
		assertNotNull(
				pvuEmployeQualificationServiceImpl.saveOrUpdateEmployeQualification(pvuEmployeeQualificationDtos));


	}

	@Test
	void testGetEmployeQualificationByEmpId() throws CustomException {

		when(repository.findPVUEmployeQualificationEntityBypvuEmployeEntityEmpIdAndActiveStatus(176l, 1))
				.thenReturn(qenList);

		when(deptExamDetailsRepository.findPVUEmployeDeptExamDetailsEntityBypvuEmployeEntityEmpIdAndActiveStatus(176l,
				1)).thenReturn(exEnList);
		when(exEnList.get(0)).thenReturn(ent);
		when(ent.getExamStatus()).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoName()).thenReturn("Exempted");

		when(deptExamDetailsConverter.toDTO(exEnList)).thenReturn(exList);

		when(cccExamDetailsRepository.findPVUEmployeCCCExamDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(1l, 1)).thenReturn(ccEnList);
		when(ccEnList.get(0)).thenReturn(pvuEmployeCCCExamDetailEntity);
		when(pvuEmployeCCCExamDetailEntity.getExamStatus()).thenReturn(edpLuLookUpInfoEntity);
		when(pvuEmployeCCCExamDetailEntity.getCccExamName()).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoName()).thenReturn("Pass");


		when(cccExamDetailsConverter.toDTO(ccEnList)).thenReturn(ccList);
		when(ccEnList.get(0)).thenReturn(pvuEmployeCCCExamDetailEntity);
		when(pvuEmployeCCCExamDetailEntity.getExamStatus()).thenReturn(edpLuLookUpInfoEntity);

		when(langExamDetailsRepository.findPVUEmployeLangExamEntityBypvuEmployeEntityEmpIdAndActiveStatus(1l, 1)).thenReturn(laEnList);
		when(langExamDetailsConverter.toDTO(laEnList)).thenReturn(laList);

		pvuEmployeQualificationServiceImpl.getEmployeQualificationByEmpId(1l);
		when(repository.findPVUEmployeQualificationEntityBypvuEmployeEntityEmpIdAndActiveStatus(1l, 1)).thenReturn(qenList);

		when(deptExamDetailsRepository.findPVUEmployeDeptExamDetailsEntityBypvuEmployeEntityEmpIdAndActiveStatus(1l,
				1)).thenReturn(exEnList);
		
//		when(ent.getExamStatus()).thenReturn(edpLuLookUpInfoEntity);
		when(edpLuLookUpInfoEntity.getLookUpInfoName()).thenReturn("Exempted");

		when(deptExamDetailsConverter.toDTO(exEnList)).thenReturn(exList);

		when(cccExamDetailsRepository.findPVUEmployeCCCExamDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(1l, 1))
				.thenReturn(ccEnList);
		when(cccExamDetailsConverter.toDTO(ccEnList)).thenReturn(ccList);
		
//		when(pvuEmployeCCCExamDetailEntity.getExamStatus()).thenReturn(edpLuLookUpInfoEntity);

		when(langExamDetailsRepository.findPVUEmployeLangExamEntityBypvuEmployeEntityEmpIdAndActiveStatus(1l, 1))
				.thenReturn(laEnList);
		when(langExamDetailsConverter.toDTO(laEnList)).thenReturn(laList);

		pvuEmployeQualificationServiceImpl.getEmployeQualificationByEmpId(1l);

	}

	@Test
	void testGetEmployeQualificationByEmpIdException() throws Exception {
		PVUEmployeeQualificationDtos dto = new PVUEmployeeQualificationDtos();
		when(pvuEmployeQualificationRepository
				.findPVUEmployeQualificationEntityBypvuEmployeEntityEmpIdAndActiveStatus(1l, 1)).thenReturn(null);

		assertNotNull(dto);

	}

	@Test
	void updateQualificationActiveStatus() throws CustomException {
		when(pvuEmployeQualificationRepository.updateActiveStatusByQualificationId(1, 1, 1, new Date())).thenReturn(1);
		pvuEmployeQualificationServiceImpl.updateQualificationActiveStatus(1l, 1);
	}

	@Test
	void updateDeptExamActiveStatus() throws CustomException {
		when(deptExamDetailsRepository.updateActiveStatusByEmpDeptExamDetailId(1, 1, 1, new Date())).thenReturn(1);
		pvuEmployeQualificationServiceImpl.updateDeptExamActiveStatus(1l, 1);
	}

	@Test
	void updateCccExamActiveStatus() throws CustomException {
		when(cccExamDetailsRepository.updateActiveStatusByEmpCCCExamDetailId(1, 1, 1, new Date())).thenReturn(1);
		pvuEmployeQualificationServiceImpl.updateCccExamActiveStatus(1l, 1);
	}

	@Test
	void updateLangExamActiveStatus() throws CustomException {
		when(langExamDetailsRepository.updateActiveStatusByempLangExamId(1, 1, 1, new Date())).thenReturn(1);
		pvuEmployeQualificationServiceImpl.updateLangExamActiveStatus(1l, 1);
	}

	@Test
	void testGetHistoryOfEmpLngDeptExamDetailsByEmpId() throws CustomException {
		StringBuilder sb = new StringBuilder();
		IdDto idDtod = new IdDto();
		idDtod.setId(1l);
		PVUEmployeeSqlQueries.getQuerieOfHistoryOfEmpAddressByEmpId(idDtod, sb);
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(pvuEmployeQualificationRepository.executeSQLQueryOnly(Mockito.anyString())).thenReturn(objects);
		assertNotNull(pvuEmployeQualificationServiceImpl.getHistoryOfEmpLngDeptExamDetailsByEmpId(idDtod));
	}
	
	@Test
	void testGetHistoryOfEmpDeptExamDetailsByEmpId() throws CustomException {
		StringBuilder sb = new StringBuilder();
		IdDto idDtod = new IdDto();
		idDtod.setId(1l);
		PVUEmployeeSqlQueries.getQuerieOfHistoryOfEmpAddressByEmpId(idDtod, sb);
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(pvuEmployeQualificationRepository.executeSQLQueryOnly(Mockito.anyString())).thenReturn(objects);
		assertNotNull(pvuEmployeQualificationServiceImpl.getHistoryOfEmpDeptExamDetailsByEmpId(idDtod));
	}
	
	@Test
	void testGetHistoryOfEmpCceDeptExamDetailsByEmpId() throws CustomException {
		StringBuilder sb = new StringBuilder();
		IdDto idDtod = new IdDto();
		idDtod.setId(1l);
		PVUEmployeeSqlQueries.getQuerieOfHistoryOfEmpAddressByEmpId(idDtod, sb);
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(pvuEmployeQualificationRepository.executeSQLQueryOnly(Mockito.anyString())).thenReturn(objects);
		assertNotNull(pvuEmployeQualificationServiceImpl.getHistoryOfEmpCceDeptExamDetailsByEmpId(idDtod));
	}
	
	@Test
	void testGetHistoryOfEmpQulifictionByEmpId() throws CustomException {
		StringBuilder sb = new StringBuilder();
		IdDto idDtod = new IdDto();
		idDtod.setId(1l);
		PVUEmployeeSqlQueries.getQuerieOfHistoryOfEmpAddressByEmpId(idDtod, sb);
		Object[] object = new Object[1];
		object[0] = "";
		List<Object[]> objects = new ArrayList<Object[]>();
		objects.add(object);
		when(pvuEmployeQualificationRepository.executeSQLQueryOnly(Mockito.anyString())).thenReturn(objects);
		assertNotNull(pvuEmployeQualificationServiceImpl.getHistoryOfEmpQulifictionByEmpId(idDtod));
	}


	@Test
	void testEditEmployeQualification() throws CustomException {
		EmployeeChangeType type = new EmployeeChangeType();
		type.setEmpQualitype(1);
		type.setEmpDptDtltype(1);
		type.setEmpccetype(1);
		PVUEmployeDeptExamDetailsEditableDto deptExamEditableDto =  new PVUEmployeDeptExamDetailsEditableDto();
		PVUEmployeCCCExamDetailEditableDto cccDto = new PVUEmployeCCCExamDetailEditableDto();
		PVUEmployeQualificationDto qulificationDto = new PVUEmployeQualificationDto();
		PVUEmployeQualificationEntity entiy = new PVUEmployeQualificationEntity();
		qulificationDto.setChangeType(1);
		when(pvuEmployeeQualificationDtos.getExemptedCccExam()).thenReturn(pvuEmployeCCCExamDetailDto);
		when(luLookUpInfoRepository.findByLookUpInfoName("Exempted")).thenReturn(edpLuLookUpInfoEntity);
		when(pvuEmployeUpdateDtos.getPvuEmployeQualificationDto()).thenReturn(list);
		when(list.get(0)).thenReturn(qulificationDto);
		when(pvuEmployeQualificationConverter.toEntity(list)).thenReturn(qenList);
		when(qenList.get(0)).thenReturn(new PVUEmployeQualificationEntity());
		when(repository.saveAll(qenList)).thenReturn(qenList);
		when(pvuEmployeUpdateDtos.getPvuEmployeLangExamDto()).thenReturn(listLang);
		when(langExamDetailsConverter.toEntity(laList)).thenReturn(laEnList);
		when(langExamDetailsRepository.saveAll(laEnList)).thenReturn(laEnList);
		when(qenList.get(0)).thenReturn(pvuEmployeQualificationEntity);
		when(pvuEmployeQualificationEntity.getPvuEmployeEntity()).thenReturn(pvuEmployeEntity);
		deptExamEditableDto.setEmpId(1);
		cccDto.setEmpId(1);
		when(pvuEmployeUpdateDtos.getPvuEmployeDeptExamDetailsDto()).thenReturn(lisDpt);
		when(lisDpt.get(0)).thenReturn(deptExamEditableDto);

		when(deptExamDetailsConverter.toEntity(pvuEmployeDeptExamDetailsDto)).thenReturn(ent);

		when(pvuEmployeUpdateDtos.getPvuEmployeCCCExamDetailDto()).thenReturn(listccc);
		when(listccc.get(0)).thenReturn(cccDto);

		when(cccExamDetailsConverter.toEntity(pvuEmployeCCCExamDetailDto)).thenReturn(pvuEmployeCCCExamDetailEntity);

		when(pvuEmployeeQualificationDtos.isExemptedDeptExamFlag()).thenReturn(true);
		when(pvuEmployeeQualificationDtos.isExemptedCccExamFlag()).thenReturn(true);
		when(deptExamDetailsConverter.toUpdateEntity(deptExamEditableDto)).thenReturn(ent);
		when(cccExamDetailConverter.toEditableEntity(cccDto)).thenReturn(pvuEmployeCCCExamDetailEntity);
		assertNotNull(pvuEmployeQualificationServiceImpl.editEmployeQualification(pvuEmployeUpdateDtos , type));
	}

	@Test
	public void testSetPVUEmployeCCCExamDetailEdit(){
		EmployeeChangeType type = new EmployeeChangeType();
		type.setEmpQualitype(1);
		type.setEmpDptDtltype(1);
		type.setEmpccetype(1);
		PVUEmployeeQualificationUpdateDtos dto = new PVUEmployeeQualificationUpdateDtos();
		PVUEmployeeQualificationUpdateDtos allQualExamDtos = new PVUEmployeeQualificationUpdateDtos();
		 EDPLuLookUpInfoEntity exemptedStatusId = new EDPLuLookUpInfoEntity();
		PVUEmployeCCCExamDetailEditableDto pvuEmployeCCCExamDetailDto = new PVUEmployeCCCExamDetailEditableDto();
		List<PVUEmployeCCCExamDetailEditableDto> listccc = new ArrayList<>();
		pvuEmployeCCCExamDetailDto.setChangeType(1l);
		pvuEmployeCCCExamDetailDto.setEmpId(1l);
		listccc.add(pvuEmployeCCCExamDetailDto);
		dto.setPvuEmployeCCCExamDetailDto(listccc);
		dto.setExemptedCccExam(pvuEmployeCCCExamDetailDto);
		when(cccExamDetailRepository.findPVUEmployeCCCExamDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(1l,1)).thenReturn(ccEnList);
		when(cccExamDetailConverter.toEditableEntity(pvuEmployeCCCExamDetailDto)).thenReturn(pvuEmployeCCCExamDetailEntity);
		dto.setExemptedCccExamFlag(false);
		pvuEmployeQualificationServiceImpl.setPVUEmployeCCCExamDetailEdit(dto, allQualExamDtos, exemptedStatusId,type);
		dto.setExemptedCccExamFlag(true);
		pvuEmployeQualificationServiceImpl.setPVUEmployeCCCExamDetailEdit(dto, allQualExamDtos, exemptedStatusId,type);
	}

	@Test
	public void testSetPVUEmployeDeptExamDetailForEdit(){
		EmployeeChangeType type = new EmployeeChangeType();
		type.setEmpQualitype(1);
		type.setEmpDptDtltype(1);
		type.setEmpccetype(1);
		PVUEmployeeQualificationUpdateDtos dto = new PVUEmployeeQualificationUpdateDtos();
		PVUEmployeeQualificationUpdateDtos allQualExamDtos = new PVUEmployeeQualificationUpdateDtos();
		EDPLuLookUpInfoEntity exemptedStatusId = new EDPLuLookUpInfoEntity();
		PVUEmployeDeptExamDetailsEditableDto dptDetailDto = new PVUEmployeDeptExamDetailsEditableDto();
		List<PVUEmployeDeptExamDetailsEditableDto> listccc = new ArrayList<>();
		dptDetailDto.setChangeType(1l);
		dptDetailDto.setEmpId(1l);
		listccc.add(dptDetailDto);
		dto.setExemptedDeptExam(dptDetailDto);
		dto.setPvuEmployeDeptExamDetailsDto(listccc);
		when(deptExamDetailsRepository.findPVUEmployeDeptExamDetailsEntityBypvuEmployeEntityEmpIdAndActiveStatus(176l,1)).thenReturn(exEnList);
		when(deptExamDetailsConverter.toUpdateEntity(dptDetailDto)).thenReturn(ent);
		when(ent.getRemarks()).thenReturn("remark");
		dto.setExemptedDeptExamFlag(true);
		pvuEmployeQualificationServiceImpl.setPVUEmployeDeptExamDetailForEdit(dto, allQualExamDtos, exemptedStatusId,type);
		dto.setExemptedDeptExamFlag(false);
		pvuEmployeQualificationServiceImpl.setPVUEmployeDeptExamDetailForEdit(dto, allQualExamDtos, exemptedStatusId,type);
	}





}
