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
import org.springframework.data.domain.Sort;

import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.constant.JunitConstants;
import gov.ifms.dmo.dto.DMOLookUpDto;
import gov.ifms.dmo.service.impl.EDPDepartmentMstServiceImpl;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.entity.EDPMsHodEntity;
import gov.ifms.edp.repository.EDPMsDepartmentRepository;
import gov.ifms.edp.repository.EDPMsHodRepository;

@TestInstance(Lifecycle.PER_CLASS)
class EDPDepartmentMstServiceTest {

	@InjectMocks
	EDPDepartmentMstServiceImpl departmentMstServiceImpl;

	@Mock
	EDPMsDepartmentRepository departmentServiceRepository;

	@Mock
	EDPMsDepartmentEntity departmentEntity;

	@Mock
	EDPMsHodEntity edpMsHodEntity;

	@Mock
	EDPMsHodRepository edpMsHodRepository;

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
	@DisplayName("Test Service Get All Department.")
	void testGetAllDepartment() throws CustomException {
		dmoLookUpDto = new DMOLookUpDto();
		departmentEntity = new EDPMsDepartmentEntity();
		List<EDPMsDepartmentEntity> listDeptMs = new ArrayList<EDPMsDepartmentEntity>();
		List<DMOLookUpDto> dtos = new ArrayList<DMOLookUpDto>();
		dmoLookUpDto.setId(JunitConstants.LONG_TYPE);
		dmoLookUpDto.setName(JunitConstants.STRING_TYPE);
		departmentEntity.setDepartmentId(JunitConstants.LONG_TYPE);
		departmentEntity.setDepartmentName(JunitConstants.STRING_TYPE);
		departmentEntity.setActiveStatus(JunitConstants.INTEGER_TYPE);
		dtos.add(dmoLookUpDto);
		listDeptMs.add(departmentEntity);
		when(departmentServiceRepository.findByActiveStatus(1, Sort.by(Sort.Direction.ASC, "departmentName")))
				.thenReturn(listDeptMs);
		dtos = departmentMstServiceImpl.getAllDepartment();
		assertEquals(JunitConstants.LONG_TYPE, dtos.get(0).getId());
	}

	@Test
	@DisplayName("Test Service Get All HOD By Department.")
	void testGetAllHODByDepartment() throws CustomException {
		dmoLookUpDto = new DMOLookUpDto();
		edpMsHodEntity = new EDPMsHodEntity();
		List<EDPMsHodEntity> listDeptMs = new ArrayList<EDPMsHodEntity>();
		List<DMOLookUpDto> dtos = new ArrayList<DMOLookUpDto>();
		dmoLookUpDto.setId(JunitConstants.LONG_TYPE);
		dmoLookUpDto.setName(JunitConstants.STRING_TYPE);
		edpMsHodEntity.setHodId(JunitConstants.LONG_TYPE);
		edpMsHodEntity.setHodName(JunitConstants.STRING_TYPE);
		dtos.add(dmoLookUpDto);
		listDeptMs.add(edpMsHodEntity);
		when(edpMsHodRepository.findByDepartmentIdDepartmentId(dmoLookUpDto.getId())).thenReturn(listDeptMs);
		dtos = departmentMstServiceImpl.getAllHODByDepartment(dmoLookUpDto);
		assertEquals(JunitConstants.LONG_TYPE, dtos.get(0).getId());
	}

}
