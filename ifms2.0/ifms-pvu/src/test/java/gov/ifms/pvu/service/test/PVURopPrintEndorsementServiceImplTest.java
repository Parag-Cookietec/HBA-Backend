package gov.ifms.pvu.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.converter.EDPMsDesignationConverter;
import gov.ifms.edp.converter.EDPMsDistrictConverter;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.pvu.converter.PVURopPrintEndorsementConverter;
import gov.ifms.pvu.converter.PVURopPrintEndorsementItrConverter;
import gov.ifms.pvu.dto.AnnexureDto;
import gov.ifms.pvu.dto.PVURevisionOfPayAnnexureListView;
import gov.ifms.pvu.dto.PVURevisionOfPayAnnexureView;
import gov.ifms.pvu.dto.PVURopPrintEndorsementDto;
import gov.ifms.pvu.dto.PVURopPrintEndorsementView;
import gov.ifms.pvu.dto.PVURopView;
import gov.ifms.pvu.dto.PrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.StickerDTO;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVURopPrintEndorsementEntity;
import gov.ifms.pvu.entity.PVURopPrintEndorsementItrEntity;
import gov.ifms.pvu.repository.PVUEmployeRepository;
import gov.ifms.pvu.repository.PVURopPrintEndorsementItrRepository;
import gov.ifms.pvu.repository.PVURopPrintEndorsementRepository;
import gov.ifms.pvu.service.PVUEmployeeEventStatusService;
import gov.ifms.pvu.service.PVURevisionOfPayService;
import gov.ifms.pvu.service.PVURopPrintEndorsementServiceImpl;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.wrapper.PVYFacade;

class PVURopPrintEndorsementServiceImplTest {

	@InjectMocks
	private PVURopPrintEndorsementServiceImpl service;
	
	@Mock
	private PVURopPrintEndorsementRepository repository;
	
	@Mock
	private PVURopPrintEndorsementEntity entity;
	
	@Mock
	private EDPMsDesignationRepository designationRepository;

	/** The designation list. */
	@Mock
	private List<EDPMsDesignationEntity> designationList;

	/** The district repository. */
	@Mock
	private EDPMsDistrictRepository districtRepository;

	/** The district list. */
	@Mock
	private List<EDPMsDistrictEntity> districtList;
	
	@Mock
	private EDPLuLookUpInfoEntity empStatusLookupInfo;
	
	@Mock
	private PvuWFWrapperDto pvuWFWrapperDto;
	
	@Mock
	private PrintStickerReportDto printStickerReportDto;

	/** The pvu facade. */
	@Mock
	private PVYFacade pvuFacade;
	
	@Mock
	private EDPMsDistrictConverter districtConverter;
	
	@Mock
	private EDPMsDesignationRepository eDPMsDesignationRepository;
	
	@Mock
	private EDPMsDesignationConverter eDPMsDesignationConverter;
	
	@Mock
	private PVURevisionOfPayService pvuRevisionOfPayService;
	
	@Mock
	private PVUEmployeRepository pvuEmployeRepository;
	
	@Mock
	private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;
	
	@Mock
	private PVURopPrintEndorsementConverter converter;
	
	@Mock
	private PVURopPrintEndorsementItrConverter printItrConverter;

	@Mock
	private PVURopPrintEndorsementItrRepository printItrRepository;
	
	@Mock
	private PVURopPrintEndorsementItrEntity printItrEntiry;
	
	@Mock
	private PVURopPrintEndorsementDto pvuRopPrintEndorsementDto;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	void testGetRopPrintEndorsements() throws CustomException {
		List<SearchParam> jsonArr = new ArrayList<SearchParam>();
		jsonArr.add(new SearchParam("isSearch", "0"));
		jsonArr.add(new SearchParam("authorizationFromDate", ""));
		jsonArr.add(new SearchParam("authorizationToDate", ""));
		jsonArr.add(new SearchParam("eventName", ""));
		jsonArr.add(new SearchParam("empNo", ""));
		jsonArr.add(new SearchParam("empName", ""));
		jsonArr.add(new SearchParam("designationId", ""));
		jsonArr.add(new SearchParam("caseNo", ""));
		jsonArr.add(new SearchParam("classId", "0"));
		jsonArr.add(new SearchParam("retirementDate", ""));
		jsonArr.add(new SearchParam("panNo", ""));
		jsonArr.add(new SearchParam("districtId", "0"));
		jsonArr.add(new SearchParam("cardexNo", " "));
		jsonArr.add(new SearchParam("ddoCode", ""));
		jsonArr.add(new SearchParam("employeeTypeId", "0"));
		jsonArr.add(new SearchParam("inwardFromDate", ""));
		jsonArr.add(new SearchParam("inwardToDate", ""));
		jsonArr.add(new SearchParam("transNo", ""));
		jsonArr.add(new SearchParam("trnStatus", "Authorised by Class II"));
		jsonArr.add(new SearchParam("wfStatus", ""));
		jsonArr.add(new SearchParam("postId", "975"));
		jsonArr.add(new SearchParam("menuId", "70"));
		jsonArr.add(new SearchParam("officeId", "38"));
		jsonArr.add(new SearchParam("lkPoOffUserId", "559"));
		jsonArr.add(new SearchParam("wfRoleIds", "17"));

		PageDetails pageDetail = new PageDetails();
		pageDetail.setPageElement(1);
		pageDetail.setPageIndex(0);
		pageDetail.setJsonArr(jsonArr);

		service.getRopPrintEndorsements(pageDetail);
		PagebleDTO<PVURopPrintEndorsementView> data = service.getRopPrintEndorsements(pageDetail);
		assertNotNull(data);
	}
	
	@Test
	void testGetPvuSearchFields() {
		assertNotNull(service.getPvuSearchFields());
	}
	
	@Test
	void testSaveOrUpdateRopInward() {
		assertNotNull(when(repository.save(entity)).thenReturn(entity));
		service.saveOrUpdateRopPrintEndorsement(entity);
	}
	
	@Test
	void testGetRopPrintEndorsement() {
		when(repository.getOne(1l)).thenReturn(entity);
		assertEquals(entity, service.getRopPrintEndorsement(1l));
		verify(repository, times(1)).getOne(1L);
	}
	
	@Test
	void testGetPELuLookUpDetails() throws CustomException {
		List<EDPMsDistrictEntity> lstEDPMsDistrictEntity = new ArrayList<EDPMsDistrictEntity>();
		List<EDPMsDesignationEntity> lstEDPMsDesignationEntity = new ArrayList<EDPMsDesignationEntity>();
		List<EDPSDTDto> lstEDPSDTDto = new ArrayList<EDPSDTDto>();
		
		List<Object[]> objectPvuSp = new ArrayList<Object[]>();
		Object[] lookUpObject = new Object[3];
		lookUpObject[0] = "ropType";
		lookUpObject[1] = 1;
		lookUpObject[2] =  "ropType";
		objectPvuSp.add(lookUpObject);
		
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_EMP_ROP_INWARD_LK_SP));
		when(repository.callStoredProcedure(procName, Collections.emptyMap())).thenReturn(objectPvuSp);
		when(districtRepository.findByActiveStatusAndStateId(Constant.ACTIVE_STATUS, EDPConstant.STATE_ID_GUJ,
				EDPUtility.getJpaSort(EDPConstant.DISTRICT_NAME, EDPConstant.ORDER_ASC))).thenReturn(lstEDPMsDistrictEntity);
		when(districtConverter.toEDPSDTDto(lstEDPMsDistrictEntity)).thenReturn(lstEDPSDTDto);
		when(eDPMsDesignationRepository.findByActiveStatusEquals(Constant.ACTIVE_STATUS)).thenReturn(lstEDPMsDesignationEntity);
		when(eDPMsDesignationConverter.toEDPSDTDto(lstEDPMsDesignationEntity)).thenReturn(lstEDPSDTDto);
		assertNotNull(service.getPELuLookUpDetails());
	}


	@Test
	void testSubmitPrintEndorsement() throws CustomException {
		PrintStickerReportDto dto = new PrintStickerReportDto();
		PvuWFWrapperDto pvuWFWrapperDto = new PvuWFWrapperDto();
		StickerDTO stickerDTO = new StickerDTO();
		Object getResult = 0l;

		pvuWFWrapperDto.setTrnId(1l);
		stickerDTO.setId(1);
		
		PVURopPrintEndorsementDto printEndorsementDto = new PVURopPrintEndorsementDto();
		printEndorsementDto.setId(2l);
		printEndorsementDto.setPrintCnt(0l);
		printEndorsementDto.setPrintDate(new Date());
		
		dto.setPvuWFWrapperDto(pvuWFWrapperDto);
		dto.setPrintEndorsementDto(printEndorsementDto);
		dto.setStickerDTO(stickerDTO);

		PVURopView pvuRopView = new PVURopView();
		pvuRopView.setId(1L);
		pvuRopView.setEmpId(1L);
		pvuRopView.setTrnNo("20-21/ROP/0000001");
		
		when(pvuRevisionOfPayService.getRevisionOfPayView(dto.getStickerDTO().getId())).thenReturn(pvuRopView);
		when(repository.findByIdAndActiveStatus(dto.getPrintEndorsementDto().getId(),Constant.ACTIVE_STATUS)).thenReturn(null);
		when(pvuFacade.callWorkFlowApis(pvuWFWrapperDto)).thenReturn(true);
		doNothing().when(pvuRevisionOfPayService).authorizedRop(dto.getPvuWFWrapperDto().getTrnId());
		
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.P_PVU_ROP_AUTO_INCR));
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("IN_TRN_NO", pvuRopView.getTrnNo());
		when(repository.callUsingCallableStmt(procName, map)).thenReturn(getResult);
		doNothing().when(pvuEmployeeEventStatusService).resetInProgressEmployeeEventStatus(
				pvuRopView.getEmpId(), OAuthUtility.getCurrentUserLkPOUId());
		when(converter.toEntity(dto.getPrintEndorsementDto())).thenReturn(entity);
		when(repository.save(entity)).thenReturn(entity);
		when(printItrConverter.toEntity(entity)).thenReturn(printItrEntiry);
		when(printItrRepository.save(printItrEntiry)).thenReturn(printItrEntiry);
		when(converter.toDTO(entity)).thenReturn(pvuRopPrintEndorsementDto);
		assertNotNull(service.submitPrintEndorsement(dto));
	}
	
	@Test
	void testGeneratePrintEndorsement() throws CustomException, DocumentException {
		Document document = new Document();
		PVURopView pvuRopView= new PVURopView();
		PrintStickerReportDto dto= new PrintStickerReportDto();
		service.submitPrintHistory(dto,pvuRopView);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfWriter.getInstance(document, byteArrayOutputStream);
		when(pvuRevisionOfPayService.getRevisionOfPayView(1l)).thenReturn(pvuRopView);
		assertNotNull(pvuRopView);
		Optional<PVUEmployeEntity> pvuEmployeEntityOptional = Optional.empty() ;
		when(pvuEmployeRepository.findByEmpIdAndActiveStatus(pvuRopView.getEmpId(), Constant.ACTIVE_STATUS)).thenReturn(pvuEmployeEntityOptional);
	}
	
	
	
	@Test
	void testGenerateAnnexure() throws CustomException, DocumentException {
		AnnexureDto dto =  new AnnexureDto();
		Document document = new Document();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfWriter.getInstance(document, byteArrayOutputStream);
		
		List<Object[]> objectPvuSp = new ArrayList<Object[]>();
		Object[] pvuAnnexureObject = new Object[3];
		pvuAnnexureObject[0] = "empName";
		pvuAnnexureObject[1] = "empDesignation";
		pvuAnnexureObject[2] =  "empStatus";
		objectPvuSp.add(pvuAnnexureObject);
		
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_ROP_PRINT_CALCULATION));
		PVURevisionOfPayAnnexureView payAnnexureView = service.getPVURopAnnexure(dto);
		when(repository.callStoredProcedure(procName, Collections.emptyMap())).thenReturn(objectPvuSp);

		List<Object[]> incrementList = new ArrayList<Object[]>();
		Object[] incrementObject = new Object[4];
		pvuAnnexureObject[0] = "2016-01-01";
		pvuAnnexureObject[1] = "17510";
		pvuAnnexureObject[2] =  "4600";
		incrementList.add(incrementObject);
		
		List<PVURevisionOfPayAnnexureListView> annexureListViews = service.getPVURopAnnexureList(dto);
		String procName1 = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_ROP_PRINT_CALCULATION_LIST));
		when(repository.callStoredProcedure(procName1, Collections.emptyMap())).thenReturn(incrementList);
		assertNotNull(objectPvuSp);
		assertNotNull(incrementList);
		
		PdfPCell cell1 = PVURopPrintEndorsementServiceImpl.getCell("Date Of Increment");
		PdfPCell cell2 = PVURopPrintEndorsementServiceImpl.getCellWithBorder("Date Of Increment");
		assertNotNull(cell1);
		assertNotNull(cell2);
		
		document.open();
		 float [] pointColumnWidths = {30F, 300F,30F,200F};       
         PdfPTable table = new PdfPTable(pointColumnWidths);
         table.setWidthPercentage(100);
         table.addCell(PVURopPrintEndorsementServiceImpl.getCell("1"));
         table.addCell(PVURopPrintEndorsementServiceImpl.getCell("Name of the Government Servant"));
         table.addCell(PVURopPrintEndorsementServiceImpl.getCell((":")));
         table.addCell(PVURopPrintEndorsementServiceImpl.getCell("EmpName"));
         document.add(table);
		document.close();
	}
	
	
}
