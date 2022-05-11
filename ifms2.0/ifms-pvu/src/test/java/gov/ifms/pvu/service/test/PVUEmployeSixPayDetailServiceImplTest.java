package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.pvu.converter.PVUEmpBankDetailConverter;
import gov.ifms.pvu.converter.PVUEmployeFivePayDetailConverter;
import gov.ifms.pvu.converter.PVUEmployeFixPayDetailsConverter;
import gov.ifms.pvu.converter.PVUEmployeFourthPayDetailConverter;
import gov.ifms.pvu.converter.PVUEmployeSevenPayDetailConverter;
import gov.ifms.pvu.converter.PVUEmployeSixPayDetailConverter;
import gov.ifms.pvu.converter.PVUEmployeeJoiningPayConverter;
import gov.ifms.pvu.converter.PVUMsPayCellConverter;
import gov.ifms.pvu.dto.PVUEmpBankDetailDto;
import gov.ifms.pvu.dto.PVUEmployeFivePayDetailDto;
import gov.ifms.pvu.dto.PVUEmployeFixPayDetailsDto;
import gov.ifms.pvu.dto.PVUEmployeFourthPayDetailDto;
import gov.ifms.pvu.dto.PVUEmployePayDetailDtos;
import gov.ifms.pvu.dto.PVUEmployeSevenPayDetailDto;
import gov.ifms.pvu.dto.PVUEmployeSixPayDetailDto;
import gov.ifms.pvu.dto.PVUEmployeeJoiningPayDto;
import gov.ifms.pvu.dto.PVUMsPayCellDto;
import gov.ifms.pvu.dto.PvuCommonRequest;
import gov.ifms.pvu.entity.PVUEmpBankDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeFivePayDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeFixPayDetailsEntity;
import gov.ifms.pvu.entity.PVUEmployeFourthPayDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeSevenPayDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeSixPayDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeeJoiningPayEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.repository.PVUEmpBankDetailRepository;
import gov.ifms.pvu.repository.PVUEmployeFivePayDetailRepository;
import gov.ifms.pvu.repository.PVUEmployeFixPayDetailsRepository;
import gov.ifms.pvu.repository.PVUEmployeFourthPayDetailRepository;
import gov.ifms.pvu.repository.PVUEmployeSevenPayDetailRepository;
import gov.ifms.pvu.repository.PVUEmployeSixPayDetailRepository;
import gov.ifms.pvu.repository.PVUEmployeeJoiningPayRepository;
import gov.ifms.pvu.repository.PVUMsPayCellRepository;
import gov.ifms.pvu.service.PVUEmployePayDetailServiceImpl;


/**
 * The Class PVUEmployeSixPayDetailServiceImplTest.
 */
class PVUEmployeSixPayDetailServiceImplTest {

	
	/** The pvu employe six pay detail service impl. */
	@InjectMocks
	private PVUEmployePayDetailServiceImpl pvuEmployeSixPayDetailServiceImpl;
	
	/** The pvu employe pay detail dtos. */
	@Mock
	private PVUEmployePayDetailDtos pvuEmployePayDetailDtos;
	
	/** The pvu employe 6 pay detail dto. */
	@Mock
	private PVUEmployeSixPayDetailDto pvuEmploye6PayDetailDto;
	
	/** The pvu employe 7 pay detail dto. */
	@Mock
	private PVUEmployeSevenPayDetailDto pvuEmploye7PayDetailDto;
	
	/** The pvu employe five pay detail dto. */
	@Mock
	private PVUEmployeFivePayDetailDto pvuEmployeFivePayDetailDto;

	/** The pvu employe fourth pay detail dto. */
	@Mock
	private PVUEmployeFourthPayDetailDto pvuEmployeFourthPayDetailDto;
	
	/** The pvu employe fourth pay detail entity. */
	@Mock
	private PVUEmployeFourthPayDetailEntity pvuEmployeFourthPayDetailEntity;
	
	/** The pvu employe five pay detail entity. */
	@Mock
	private PVUEmployeFivePayDetailEntity pvuEmployeFivePayDetailEntity;
	
	/** The pvu employe six pay detail entity. */
	@Mock
	private PVUEmployeSixPayDetailEntity pvuEmployeSixPayDetailEntity;
	
	/** The pvu employe seven pay detail entity. */
	@Mock
	private PVUEmployeSevenPayDetailEntity pvuEmployeSevenPayDetailEntity;
	
	/** The pvu employe fourth pay detail repository. */
	@Mock
	private PVUEmployeFourthPayDetailRepository pvuEmployeFourthPayDetailRepository;
	
	/** The pvu employe five pay detail repository. */
	@Mock
	private PVUEmployeFivePayDetailRepository pvuEmployeFivePayDetailRepository;
	
	/** The pvu employe six pay detail repository. */
	@Mock
	private PVUEmployeSixPayDetailRepository pvuEmployeSixPayDetailRepository;
	
	/** The pvu employe seven pay detail repository. */
	@Mock
	private PVUEmployeSevenPayDetailRepository pvuEmployeSevenPayDetailRepository;

	/** The pvu employe fourth pay detail convertor. */
	@Mock
	private PVUEmployeFourthPayDetailConverter pvuEmployeFourthPayDetailConvertor;
	
	/** The pvu employe five pay detail convertor. */
	@Mock
	private PVUEmployeFivePayDetailConverter pvuEmployeFivePayDetailConvertor;
	
	/** The pvu employe six pay detail convertor. */
	@Mock
	private PVUEmployeSixPayDetailConverter pvuEmployeSixPayDetailConvertor;
	
	/** The pvu employe seven pay detail convertor. */
	@Mock
	private PVUEmployeSevenPayDetailConverter pvuEmployeSevenPayDetailConvertor;
	
	/** The dt. */
	@Mock
	private PVUEmployeFixPayDetailsDto dt;
	
	/** The pvu employe fix pay details converter. */
	@Mock
	private PVUEmployeFixPayDetailsConverter pvuEmployeFixPayDetailsConverter;
	
	/** The re. */
	@Mock
	private PVUEmployeFixPayDetailsRepository re;
	
	/** The en. */
	@Mock
	private PVUEmployeFixPayDetailsEntity en;
	
	/** The page. */
	@Mock
	Page<PVUEmployeSixPayDetailEntity> page;
	
	/** The lst. */
	@Mock
	List<PVUEmployeSixPayDetailEntity> lst;
	
	/** The list. */
	@Mock
	List<PVUEmployeSixPayDetailDto> list;
	
	/** The pvu request. */
	@Mock
	PvuCommonRequest pvuRequest;
	
	/** The pay cell repository. */
	@Mock
	private PVUMsPayCellRepository payCellRepository;
	
	/** The opt cell. */
	@Mock
	private PVUMsPayCellEntity optCell;
	
	/** The pay cell converter. */
	@Mock
	private PVUMsPayCellConverter payCellConverter;
	
	/** The dto. */
	@Mock
	private PVUMsPayCellDto dto;
	
	/** The request. */
	@Mock
	Map<String, Long> request;
	
	/** The pvu employe five pay detail repositary. */
	@Mock
	private PVUEmployeFivePayDetailRepository pvuEmployeFivePayDetailRepositary;
	
	@Mock
	private PVUEmployeeJoiningPayRepository pvuEmployeeJoiningPayRepository; 
	
	/** The pvu employee joining pay converter. */
	@Mock
	private PVUEmployeeJoiningPayConverter pvuEmployeeJoiningPayConverter;
	
	/** The pvu emp bank detail repository. */
	@Mock
	private PVUEmpBankDetailRepository pvuEmpBankDetailRepository;
	
	/** The pvu emp bank detail converter. */
	@Mock
	private PVUEmpBankDetailConverter pvuEmpBankDetailConverter;

	@Mock
	private PVUEmployeeJoiningPayEntity pvuEmployeeJoiningPayEntity;
	
	@Mock
	private PVUEmpBankDetailEntity pvuEmpBankDetailEntity;
	
	@Mock
	private PVUEmployeeJoiningPayDto pvuEmployeeJoiningPayDto;
	
	@Mock
	private PVUEmpBankDetailDto pvuEmpBankDetailDto;
	/**
	 * Setup.
	 */
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get employe six pay detail.
	 */
	@Test
	void testGetEmployeSixPayDetail() {
		when(pvuEmployeSixPayDetailRepository.findOneBySixpayId(1l)).thenReturn(pvuEmployeSixPayDetailEntity);
		assertEquals(pvuEmployeSixPayDetailServiceImpl.getEmployeSixPayDetail(1l), pvuEmployeSixPayDetailEntity);
		verify(pvuEmployeSixPayDetailRepository,times(1)).findOneBySixpayId(1l);
	}

	/**
	 * Test get employepay details.
	 * @throws CustomException 
	 */
	@Test
	void testGetEmployepayDetails() throws CustomException {
		PVUEmployePayDetailDtos dtos = new PVUEmployePayDetailDtos();
	
		when(pvuEmployeFourthPayDetailRepository.findPVUEmployeFourthPayDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(1l,1)).thenReturn(java.util.Optional.of(pvuEmployeFourthPayDetailEntity));
		when(pvuEmployeFourthPayDetailConvertor.toDTO(pvuEmployeFourthPayDetailEntity)).thenReturn(pvuEmployeFourthPayDetailDto);
		dtos.setPvuEmployefourthPayDetailDto(pvuEmployeFourthPayDetailDto);
		
		when(pvuEmployeFivePayDetailRepository.findOneByPvuEmployeEntityEmpIdAndActiveStatus(1l,1)).thenReturn(java.util.Optional.of(pvuEmployeFivePayDetailEntity));
		when(pvuEmployeFivePayDetailConvertor.toDTO(pvuEmployeFivePayDetailEntity)).thenReturn(pvuEmployeFivePayDetailDto);
		dtos.setPvuEmployefourthPayDetailDto(pvuEmployeFourthPayDetailDto);
		
		when(pvuEmployeSixPayDetailRepository.findOneBySixpayId(1l)).thenReturn(pvuEmployeSixPayDetailEntity);
		when(pvuEmployeSixPayDetailConvertor.toDTO(pvuEmployeSixPayDetailEntity)).thenReturn(pvuEmploye6PayDetailDto);
		dtos.setPvuEmployefourthPayDetailDto(pvuEmployeFourthPayDetailDto);
		
		when(pvuEmployeSevenPayDetailRepository.findOneByPvuEmployeEntityEmpIdAndActiveStatus(1l,1)).thenReturn(java.util.Optional.of(pvuEmployeSevenPayDetailEntity));
		when(pvuEmployeSevenPayDetailConvertor.toDTO(pvuEmployeSevenPayDetailEntity)).thenReturn(pvuEmploye7PayDetailDto);
		dtos.setPvuEmployefourthPayDetailDto(pvuEmployeFourthPayDetailDto);
		
		when(pvuEmployeeJoiningPayRepository.findOneByPvuEmployeEntityEmpId(1l)).thenReturn(java.util.Optional.of(pvuEmployeeJoiningPayEntity));
		when(pvuEmployeeJoiningPayConverter.toDTO(pvuEmployeeJoiningPayEntity)).thenReturn(pvuEmployeeJoiningPayDto);
		dtos.setPvuEmployeeJoiningPayDto(pvuEmployeeJoiningPayDto);
		
		when(pvuEmpBankDetailRepository.findOneByPvuEmployeEntityEmpId(1l)).thenReturn(java.util.Optional.of(pvuEmpBankDetailEntity));
		when(pvuEmpBankDetailConverter.toDTO(pvuEmpBankDetailEntity)).thenReturn(pvuEmpBankDetailDto);
		dtos.setPvuEmpBankDetailDto(pvuEmpBankDetailDto);
		
		assertNotNull(pvuEmployeSixPayDetailServiceImpl.getEmployepayDetails(1l));
	}

	/**
	 * Test save or update employe six pay detail.
	 *
	 * @throws CustomException the custom exception
	 */
	@Test
	void testSaveOrUpdateEmployeSixPayDetail() throws CustomException {
		PVUEmployePayDetailDtos dtos = new PVUEmployePayDetailDtos();
		dtos.setPvuEmployefourthPayDetailDto(pvuEmployeFourthPayDetailDto);
		dtos.setPvuEmployefivePayDetailDto(pvuEmployeFivePayDetailDto);
		dtos.setPvuEmployeSixPayDetailDto(pvuEmploye6PayDetailDto);
		dtos.setPvuEmployeSevenPayDetailDto(pvuEmploye7PayDetailDto);
		when(pvuEmployeFourthPayDetailDto.getPayScale()).thenReturn(1l);
		when(pvuEmployePayDetailDtos.getPvuEmployefourthPayDetailDto()).thenReturn(pvuEmployeFourthPayDetailDto);
		
		when(pvuEmployeFivePayDetailDto.getPayScale()).thenReturn(1l);
		when(pvuEmployePayDetailDtos.getPvuEmployefivePayDetailDto()).thenReturn(pvuEmployeFivePayDetailDto);
		
		when(pvuEmploye6PayDetailDto.getGradePay()).thenReturn(1l);
		when(pvuEmployePayDetailDtos.getPvuEmployeSixPayDetailDto()).thenReturn(pvuEmploye6PayDetailDto);
		when(pvuEmploye7PayDetailDto.getCellId()).thenReturn(1l);
		when(pvuEmployePayDetailDtos.getPvuEmployeSevenPayDetailDto()).thenReturn(pvuEmploye7PayDetailDto);


		when(pvuEmployeFourthPayDetailConvertor.toEntity(pvuEmployeFourthPayDetailDto)).thenReturn(pvuEmployeFourthPayDetailEntity);
		when(pvuEmployeFourthPayDetailRepository.save(pvuEmployeFourthPayDetailEntity)).thenReturn(pvuEmployeFourthPayDetailEntity);
		
		when(pvuEmployePayDetailDtos.getPvuEmployefivePayDetailDto()).thenReturn(pvuEmployeFivePayDetailDto);
		when(pvuEmployeFivePayDetailConvertor.toEntity(pvuEmployeFivePayDetailDto)).thenReturn(pvuEmployeFivePayDetailEntity);
		when(pvuEmployeFivePayDetailRepository.save(pvuEmployeFivePayDetailEntity)).thenReturn(pvuEmployeFivePayDetailEntity);
		
		when(pvuEmployePayDetailDtos.getPvuEmployeSixPayDetailDto()).thenReturn(pvuEmploye6PayDetailDto);
		when(pvuEmployeSixPayDetailConvertor.toEntity(pvuEmploye6PayDetailDto)).thenReturn(pvuEmployeSixPayDetailEntity);
		when(pvuEmployeSixPayDetailRepository.save(pvuEmployeSixPayDetailEntity)).thenReturn(pvuEmployeSixPayDetailEntity);
		
		when(pvuEmployePayDetailDtos.getPvuEmployeSevenPayDetailDto()).thenReturn(pvuEmploye7PayDetailDto);
		when(pvuEmployeSevenPayDetailConvertor.toEntity(pvuEmploye7PayDetailDto)).thenReturn(pvuEmployeSevenPayDetailEntity);
		when(pvuEmployeSevenPayDetailRepository.save(pvuEmployeSevenPayDetailEntity)).thenReturn(pvuEmployeSevenPayDetailEntity);
		
		when(pvuEmployePayDetailDtos.getPvuEmployeFixPayDetailsDto()).thenReturn(dt);
		when(pvuEmployeFixPayDetailsConverter.toEntity(dt)).thenReturn(en);
		when(re.save(en)).thenReturn(en);
		assertNotNull(pvuEmployeSixPayDetailServiceImpl.saveOrUpdateEmployePayDetail(dtos));
	}

	/**
	 * Gets the employe 6 pay details.
	 *
	 * @return the employe 6 pay details
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
    @Test
	void getEmploye6PayDetails() throws CustomException
	{
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
	        when(pvuEmployeSixPayDetailRepository.findAll(Mockito.any(Specification.class),Mockito.any(PageRequest.class))).thenReturn(page);
	        when(page.getContent()).thenReturn(lst);
	        when(pvuEmployeSixPayDetailConvertor.toDTO(lst)).thenReturn(list);
		assertNotNull(pvuEmployeSixPayDetailServiceImpl.getEmploye6PayDetails(pageDetail));
	}
	
	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	@Test
	void getAllLuLookUpInfoAsMap() throws CustomException
	{
		assertNotNull(pvuEmployeSixPayDetailServiceImpl.getAllLuLookUpInfoAsMap());
	}
	
	/**
	 * Gets the basic.
	 *
	 * @return the basic
	 */
	@Test
	void getBasic()
	{
		when(pvuEmployeFivePayDetailRepositary.findOneByPayScalePayScaleIdAndPvuEmployeEntityEmpId(1l, 206)).thenReturn(pvuEmployeFivePayDetailEntity);
		when(pvuEmployeFivePayDetailConvertor.toDTO(pvuEmployeFivePayDetailEntity)).thenReturn(pvuEmployeFivePayDetailDto);
		
		assertNotNull(pvuEmployeSixPayDetailServiceImpl.getBasic(1l, 206l));
	}
	
	/**
	 * Gets the seven basic.
	 *
	 * @return the seven basic
	 * @throws CustomException the custom exception
	 */
	@Test
	void getSevenBasic() throws CustomException
	{
	
		
		when(pvuRequest.getRequest()).thenReturn(request);
		when(request.get("cellId")).thenReturn(5l);
		when(request.get("payLevelId")).thenReturn(3l);
		when(payCellRepository.findOneByPayLevelIdAndCellId(3l,
				5)).thenReturn(Optional.of(optCell));
		when(payCellConverter.toDTO(optCell)).thenReturn(dto);
		assertNotNull(pvuEmployeSixPayDetailServiceImpl.getSevenBasic(pvuRequest));
	}
	
}