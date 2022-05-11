package gov.ifms.pvu.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.oauth.service.OAuthService;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUEmployeReversionConverter;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeReversionDto;
import gov.ifms.pvu.dto.PVUReversionPayLelevView;
import gov.ifms.pvu.dto.PvuCommonRequest;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEventsEntity;
import gov.ifms.pvu.entity.PVUEmployeReversionEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeReversionRepository;
import gov.ifms.pvu.repository.PVUEmployeSevenPayDetailRepository;
import gov.ifms.pvu.repository.PVUEmployeSixPayDetailRepository;
import gov.ifms.pvu.repository.PVUMsGradePayRepository;
import gov.ifms.pvu.repository.PVUMsPayLevelRepository;
import gov.ifms.pvu.repository.PVUMsPayScaleRepository;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;
import gov.ifms.pvu.wrapper.PVYFacade;

/**
 * The Class PVUEmployeReversionEventController.
 *
 * @version v 1.0
 * @created 2019/12/20 11:11:57O
 */
@Transactional
@Service
public class PVUEmployeReversionServiceImpl implements PVUEmployeReversionService {

    /**
     * The logger.
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /**
     * The PVUEmployeReversionEventAsMethodName repository.
     */
    @Autowired
    private PVUEmployeReversionRepository repository;

    /**
     * The converter.
     */
    @Autowired
    private PVUEmployeReversionConverter converter;

    @Autowired
    private PVUEmployeEventsService pvuEmployeEventsService;
    /**
     * The lookupinforepository.
     */
    @Autowired
    private EDPLuLookUpInfoRepository lookupinforepository;

    @Autowired
    private PVYFacade pvuFacade;

    @Autowired
    private PVUCommonService pvuCommonService;

    @Autowired
    private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;

    @Autowired
    PVUMsPayLevelRepository pvuMsPayLevelRepository;

    @Autowired
    PVUEmployeSixPayDetailRepository pvuEmployeSixPayDetailRepository;

    @Autowired
    PVUMsGradePayRepository pvuMsGradePayRepository;

    @Autowired
    PVUEmployeSevenPayDetailRepository pvuEmployeSevenPayDetailRepository;

    @Autowired
    private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;
    @Autowired
    private OAuthService authService;
    
    @Autowired
    private PVUMsPayScaleRepository scaleRepository;

    /**
     * Retrieves an PVUEmployeReversionEventEntity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the PVUEmployeReversionEventEntity with the given id or
     * {@literal null} if none found
     * @throws CustomException          the custom exception
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    @Override
    public PVUEmployeReversionEntity getPVUEmployeReversionEvent(Long id) throws CustomException {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(MsgConstant.RECORD_NOT_FOUND));

    }

    /**
     * Saves a given PVUEmployeReversionEventEntity. Use the returned instance for
     * further operations as the save operation might have changed the entity
     * instance completely.
     *
     * @param dto the dto
     * @return the saved PVUEmployeReversionEventEntity
     */
    @Trace
    @Override
    @Transactional(rollbackOn = {CustomException.class})
    public PVUEmployeReversionEntity saveOrUpdatePVUEmployeReversionEvent(PVUEmployeReversionDto dto) throws CustomException {
        PVUEmployeReversionEntity entity = converter.toEntity(dto);
        if (dto.getStatusId() == 0) {
            pvuEmployeeEventStatusService.inProgressSuspensionEvent(entity.getEmployee().getEmpId());
            entity.setStatusId(this.lookupinforepository.findByLookUpInfoName(Constant.SAVE_AS_DRAFT));
        }
        return repository.save(entity);
    }
    
    /**
     * Gets the all lu look up info as map.
     *
     * @return the all lu look up info as map
     * @throws CustomException the custom exception
     */

    @Override
    public Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException {
        try {
            Map<String, List<PVUEmployeCreationDDLView>> resultMap = null;
            String procName = Constant.PVU_SCHEMA
                    .concat(Constant.DOT.concat(PvuConstant.PVU_EMPLOYEE_REVERSION_LOOKUP_SP));
            List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = this.lookupEmployeeReversionSp(procName);
            resultMap = lstPVUEmployeCreationDDLView.stream()
                    .collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
            return resultMap;
        } catch (Exception ex) {
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }

    /**
     * Lookup employee reversion sp.
     *
     * @param procName the proc name
     * @return the list
     * @throws CustomException the custom exception
     */
    private List<PVUEmployeCreationDDLView> lookupEmployeeReversionSp(String procName) throws CustomException {
        List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, Collections.emptyMap());
        return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeCreationDDLView.class)
                : Collections.emptyList();
    }

    /**
     * @param pvuWFWrapperDto pvuWFWrapperDto
     * @return the save revesion data
     * @throws CustomException the custom exception
     */

    @Override
    public PVUEmployeReversionDto insertReversionItr(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException {
        PVUEmployeReversionDto pvuCommonResponse = null;
        Date approvedDate = new Date();
        PVUEmployeReversionEntity pvuEmployeReversionEntity = getPVUEmployeReversionEvent(pvuWFWrapperDto.getTrnId());
        EDPLuLookUpInfoEntity empApprovStatsLookupInfo = lookupinforepository
                .findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
                        Constant.ACTIVE_STATUS, Constant.APPROVED);

        if (pvuEmployeReversionEntity.getTrnNo() == null) {
            PVUEmployeeEventStatusEntity statusEntry = pvuEmployeeEventStatusService.inProgressAnyEvent(pvuEmployeReversionEntity.getEmployee().getEmpId());
            pvuEmployeReversionEntity.setRefDate(LocalDateTime.now());
            pvuEmployeReversionEntity.setTrnNo(this.pvuCommonService.getTransactionNumber("RV"));
            repository.save(pvuEmployeReversionEntity);
            statusEntry.setReversion(Constant.LONG_ONE_VALUE);
            pvuEmployeeEventStatusService.updateEventInfo(statusEntry, pvuEmployeReversionEntity.getTrnNo());
        }

        if (pvuEmployeReversionEntity.getStatusId().getLookUpInfoId() == empApprovStatsLookupInfo.getLookUpInfoId()) {
            throw new CustomException(ErrorResponse.TRN_ALREADY_APPROVED);
        }
        boolean check = pvuFacade.callWorkFlowApis(pvuWFWrapperDto);
        if (check) {
            EDPLuLookUpInfoEntity empSubmitStatusLookupInfo = lookupinforepository
                    .findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
                            Constant.ACTIVE_STATUS, Constant.SUBMIT);

            if (empSubmitStatusLookupInfo != null) {
                repository.updateStatusId(empSubmitStatusLookupInfo.getLookUpInfoId(),
                        pvuWFWrapperDto.getTrnId(), OAuthUtility.getCurrentUserUserId(), approvedDate);
            }
            pvuCommonResponse = converter.toDTO(pvuEmployeReversionEntity);
            if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) {
                pvuEmployeReversionEntity.setStatusId(empApprovStatsLookupInfo);
                approveReversionEvent(pvuWFWrapperDto, pvuCommonResponse);
                tosetDesignationAndClass(pvuCommonResponse);
                updateEmpEventStatus(pvuEmployeReversionEntity);
                insertRevAutoIncr(pvuCommonResponse.getTrnNo());
            } else if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) {
                EDPLuLookUpInfoEntity empRejectStatsLookupInfo = lookupinforepository
                        .findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
                                Constant.ACTIVE_STATUS, Constant.REJECTED);
                repository.updateStatusId(empRejectStatsLookupInfo.getLookUpInfoId(), pvuWFWrapperDto.getTrnId(),
                        OAuthUtility.getCurrentUserUserId(), approvedDate);
                updateEmpEventStatus(pvuEmployeReversionEntity);

            }
            insertReversionInITRs(pvuWFWrapperDto);
        } else {
            throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_WHILE_SAVEFILE);
        }
        return pvuCommonResponse;
    }


    /**
     * Update emp event status.
     *
     * @param find the find
     */
    private void updateEmpEventStatus(PVUEmployeReversionEntity find) {
        Optional<PVUEmployeeEventStatusEntity> pvuEmployeeEventStatusEntity;
        pvuEmployeeEventStatusEntity = pvuEmployeeEventStatusService.findByEmpId(find.getEmployee().getEmpId());
        if (pvuEmployeeEventStatusEntity.isPresent()) {
            pvuEmployeeEventStatusEntity.get().setReversion(0);
            pvuEmployeeEventStatusEntity.get().setTransId(null);
            pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(pvuEmployeeEventStatusEntity.get());
        }
    }

    private void insertReversionInITRs(PvuWFWrapperDto pvuWFWrapperDto) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(Constant.IN_TRN_NO, pvuWFWrapperDto.getTrnId());
        map.put(Constant.IN_WORKFLOW_ID, pvuWFWrapperDto.getCurrentWorkflowId());
        map.put(Constant.IN_EVENT_NAME, PvuConstant.EVENT_NAME_REVERSION);
        String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_IN_COMMON_ITRS));
        repository.callStoredProcedure(procName, map);
    }

    public Boolean approveReversionEvent(final PvuWFWrapperDto pvuWFWrapperDto, PVUEmployeReversionDto pvuCommonResponse) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(Constant.IN_TRN_NO, pvuCommonResponse.getTrnNo());
        map.put(Constant.IN_STATUS_ID, pvuWFWrapperDto.getWfStatus());
        String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_APPROVE_REVERSION));
        repository.callStoredProcedure(procName, map);
        return Boolean.TRUE;
    }

    public void tosetDesignationAndClass(PVUEmployeReversionDto dto) {
        PVUEmployeDepartmentEntity department = this.pvuEmployeDepartmentRepository
                .findFirstByPvuEmployeEntityEmpId(dto.getEmployeeId());
        if (department != null) {
            department.setDesignationId(new EDPMsDesignationEntity(dto.getDesignationId()));
            if (dto.getEmployeeClassId() > 0) {
                department.setEmpClass(this.lookupinforepository.findBylookUpInfoId(dto.getEmployeeClassId()));
            }
            this.pvuEmployeDepartmentRepository.save(department);
        }
    }

    @Override
    public List<PVUReversionPayLelevView> getEmployeeCheckPayLevelByEmpId(Long id, Long payCommisionId, LocalDate effectiveDate) throws CustomException {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Object> objectMap = new HashMap<>();
        objectMap.put(PvuConstant.EMP_ID, id);
        PVUEmployeEventsEntity eventRop =  pvuEmployeEventsService.findOneByEmpIdAndPayCommission(id, payCommisionId);

        if(eventRop != null && eventRop.getEventName() != null) {
            objectMap.put("empCreation", eventRop.getEventName());
        }else {
            objectMap.put("empCreation", PvuConstant.EMPLOYEE_CREATION);
        }
        objectMap.put("paycommition", payCommisionId);
        sb.append(
                "SELECT event.EMP_ID,event.evnt_name,dt.DATE_JOINING,event.EVNT_DATE,event.EMP_BASIC_PAY,event.PAY_COMMISSION ,")
                .append(" (SELECT c1.CELL_ID FROM MASTER_V1.MS_PAY_CELL c1 WHERE c1.PAY_CELL_ID = event.CELL_ID),  ")
                .append(" (SELECT l1.PAY_LEVEL_VALUE FROM MASTER_V1.MS_PAY_LEVEL l1 WHERE l1.pay_level_id = event.EMP_PAY_LEVEL), ")
                .append(" (SELECT gp.GRADE_PAY_VALUE FROM MASTER_V1.MS_GRADE_PAY gp WHERE gp.GRADE_PAY_ID = event.EMP_GRD_PAY), ")
                .append(" (SELECT DISTINCT p6.P_BAND_VAL_6_PAYC FROM pvu.T_EMP_6PAY p6 WHERE p6.EMP_ID  =  event.EMP_ID   AND  event.EMP_GRD_PAY IS NOT NULL  ),  ")
                .append(" (SELECT pb.STARTING_VALUE||'-'||pb.ENDING_VALUE FROM MASTER_V1.MS_PAY_BAND pb WHERE pb.PAY_BAND_ID =  event.EMP_PAY_BAND), ")
                .append(" event.CELL_ID AS CID, event.EMP_PAY_LEVEL AS PAY_LEVELID,event.EMP_GRD_PAY AS EMP_GRD_PAYID,event.EMP_PAY_BAND,   ")
                .append(" dt.CLASS,dt.DESIGNATION_ID ,   ")
                .append(" event.PAY_SCALE , (SELECT ps.SCALE_VAL FROM MASTER_V1.MS_PAY_SCALE ps WHERE PAY_SCALE_ID = event.PAY_SCALE) AS PAY_SCALE_value, ")
                .append(" emp_pay.BASIC_PAY AS actual_basic_pay ")
                .append(" FROM   ").append(Constant.PVU_SCHEMA_MASTER).append(".MS_EMPLOYEE emp ,   ")
                .append(Constant.PVU_SCHEMA).append(".T_EMP_DPT_DTL dt , ").append(Constant.PVU_SCHEMA)
                .append(".T_EMP_EVENTS event , ").append(Constant.PVU_SCHEMA).append(".T_EMP_JOIN_PAY_DTL emp_pay ")
                .append(" WHERE emp.EMP_ID = dt.EMP_ID AND emp.EMP_ID = event.EMP_ID AND emp.emp_id = emp_pay.emp_id AND event.EVNT_NAME = :empCreation ")
                .append("AND event.PAY_COMMISSION = :paycommition")
                .append(" AND emp.emp_id = :empId  AND trunc(event.EVNT_DATE) <= to_date( '" + effectiveDate + "' ,'YYYY-MM-DD') "
                        + "ORDER BY event.EVNT_DATE");
        List<Object[]> objectPvuSp = repository.executeSQLQuery(sb.toString(), objectMap);
        return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUReversionPayLelevView.class)
                : Collections.emptyList();
    }
    public PVUReversionPayLelevView getPayCommitionDetails(Map<String, Object> param) {
        String empId = param.get("empId").toString();
        String payCommision = param.get("payCommision").toString();
        Long employeId = Long.parseLong(empId);
        Long payCommisionId = Long.parseLong(payCommision);
        LocalDate effectiveDate = PvuUtils.getStrToLocalDateNew(param.get("effectiveDate").toString());
        PVUReversionPayLelevView currentValue = null;
        try {
            List<PVUReversionPayLelevView> oldValue = getEmployeeCheckPayLevelByEmpId(employeId, payCommisionId, effectiveDate);
            currentValue = findLevelPayByPayComm(oldValue);
        } catch (CustomException e) {
            logger.error(String.format(e.getErrorMsg()));
        }
        return currentValue;
    }

    private PVUReversionPayLelevView findLevelPayByPayComm(List<PVUReversionPayLelevView> oldValue) {
        PVUReversionPayLelevView currentValue = null;
        for (PVUReversionPayLelevView old : oldValue) {
            if ((old.getPayComm() == 152 && old.getCellId() != null)
                    || (old.getPayComm() == 151 && old.getGradePay() != null)
                    || (old.getPayComm() == 150)) {
                currentValue = old;
            }
        }
        return currentValue;
    }

    public PVUEmployeReversionEntity findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(MsgConstant.RECORD_NOT_FOUND));
    }

    public PVUEmployeReversionEntity saveOrUpdate(PVUEmployeReversionEntity entity) throws CustomException {
        PVUEmployeReversionEntity save = null;
        try {
            if (entity.getId() < 1) {
                entity.setTrnNo(pvuCommonService.getTransactionNumber(PvuConstant.TranNo.RV.toString()));
            }
            save = repository.save(entity);
        } catch (Exception e) {
            throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
        }
        return save;
    }

    @Override
    public void deleteById(IdDto dto) {
        if (dto.getId() != null) {
            Optional<PVUEmployeReversionEntity> entity = this.repository.findById(dto.getId());
            entity.ifPresent(this::updateEmpEventStatus);
            repository.deleteById(Constant.IN_ACTIVE_STATUS, dto.getId(),
                    OAuthUtility.getCurrentUserUserId(), new Date());
        }
    }

    public void insertRevAutoIncr(String trnNo) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_TRN_NO, trnNo);
		map.put(Constant.IN_EVNT_CODE, PvuConstant.EVENT_CODE_REVERSION);
		try {
			repository.callStoredProcedure(Constant.PVU_SCHEMA + Constant.DOT + PvuConstant.P_PVU_AUTO_INCR, map);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
    
    // 8 No. Screen
    @Override
	public String generatePrintEndorsement(IdDto dto)  throws IOException, CustomException, DocumentException {
		return generatePdf(dto);
	}
	

	public String generatePdf(IdDto dto) {
		String htmltoPdf = null;
		Map<String, Object> map = new HashMap<>();
		PdfWriter pdfWriter = null;
		StringWriter writer = new StringWriter();
		// create a new document
		Document document = new Document();
		try {

			document = new Document();
			// document header attributes
			document.addAuthor("GOG");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("GOG Finance");
			document.addTitle("Reversion Event");
			document.setPageSize(PageSize.LETTER);
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			pdfWriter=PdfWriter.getInstance(document, baos);

			// open document
			document.open();
			writer.write(generatePrint(dto).toString());

			map.put("content", writer.toString());
			htmltoPdf = pvuCommonService.htmlToPdfRequest(map);
			
			XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
			xmlWorkerHelper.getDefaultCssResolver(true);
			xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(writer.toString()));


			// close the document
			document.close();
			HttpHeaders header = new HttpHeaders();
		    header.setContentType(MediaType.APPLICATION_PDF);
		    header.set(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename="+PvuConstant.EVENT_CODE_REVERSION+".pdf");
		    header.setContentLength(baos.toByteArray().length);

		    logger.info("PDF generated successfully");

			return htmltoPdf;

		} catch (Exception e) {
			logger.info(e.getMessage());
			return null;
		}

	}
	
	public StringWriter generatePrint(IdDto dto) throws CustomException  {
		/* now render the template into a StringWriter */
		StringWriter writer = new StringWriter();
			
		PVUEmployeReversionEntity entity = this.getPVUEmployeReversionEvent(dto.getId());
		VelocityContext context = converter.populateVContext(entity);
		context.put("APPROVER_NAME", String.valueOf(authService.getOnlyIdAndName(entity.getUpdatedBy()).getName()));
		Map<String, Object> map = new HashMap<>();
		map.put("userId", entity.getUpdatedBy());
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getUserDesgnationFromUserId(),map);
		context.put("APPROVER_DESIGNATION",String.valueOf(objects.get(0)[0]));
		
		if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			
			Map<String, Object> curPaymap = new HashMap<>();
			curPaymap.put(PvuConstant.FIELD_PAY_LEVEL_ID, entity.getcPayLevel().getPayLevelValue());
			List<Object[]> curobj = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getPayLevelRange(),curPaymap);
			context.put("CURRENT_PAY_RANGE", String.valueOf(curobj.get(0)[0]));
	
			Map<String, Object> chngePaymap = new HashMap<>();
			chngePaymap.put(PvuConstant.FIELD_PAY_LEVEL_ID, entity.getPayLevel().getPayLevelValue());
			List<Object[]> chngobj = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getPayLevelRange(),chngePaymap);
			context.put("PAY_RANGE", String.valueOf(chngobj.get(0)[0]));
			
			Map<String, Object> curPayLevel = new HashMap<>();
			curPayLevel.put(PvuConstant.FIELD_PAY_LEVEL_ID, entity.getcPayLevel().getPayLevelValue());
			curPayLevel.put("cellId", entity.getcCell().getCellId());
			List<Object[]> curpayLvl = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getPayInPayLevel(),curPayLevel);
			context.put("CURRENT_PAY_IN_LEVEL", String.valueOf(curpayLvl.get(0)[0]));
			
			Map<String, Object> chngePayLevel = new HashMap<>();
			chngePayLevel.put(PvuConstant.FIELD_PAY_LEVEL_ID, entity.getPayLevel().getPayLevelValue());
			chngePayLevel.put("cellId", entity.getCellId().getCellId());
			List<Object[]> chngPayLvl = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getPayInPayLevel(),chngePayLevel);
			context.put("PAY_IN_LEVEL", String.valueOf(chngPayLvl.get(0)[0]));
		}
		else if (entity.getPayComm().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
			context.put("PAYSCALE", this.scaleRepository.getOnlyIdAndName(entity.getPayScale()).getName());
			boolean diff = PvuUtils.compareToLocalDate( entity.getEventEffectiveDate(),PvuUtils.getDateFromStringYMD(PvuConstant.EVENT_EFFICTED_DATE_5_PAY));
			if(diff) {
				context.put("CIVIL", PvuConstant.G_CIVIL);
				context.put("CIVIL_SUB", PvuConstant.G_CIVIL_SUB);
				context.put("PRA_CIVIL", PvuConstant.G_PRA_CIVIL);
			}else {
				context.put("CIVIL", PvuConstant.B_CIVIL);
				context.put("CIVIL_SUB", PvuConstant.B_CIVIL_SUB);
				context.put("PRA_CIVIL", PvuConstant.B_PRA_CIVIL);
			}
		}
		
		Template template = getPrintTemplate(entity);
		template.merge(context, writer);
		return writer;
	}
	public Template getPrintTemplate(PVUEmployeReversionEntity entity) {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();

		Template tempName = new Template();
		if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			tempName=ve.getTemplate("templates/reversion/reversion7.vm");
		}else if(entity.getPayComm().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
			tempName=ve.getTemplate("templates/reversion/reversion6.vm");
		}else if (entity.getPayComm().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
			tempName=ve.getTemplate("templates/reversion/reversion5.vm");
		}
		return tempName;
	}
    
    
    @Override
    public Map<String, List<PVUEmployeCreationDDLView>> getAvailableClassForEmp(Long employeeId) throws CustomException{
		Map<String, List<PVUEmployeCreationDDLView>> responseMap = new HashMap<>();
			
			Map<String, Object> argsMap = new HashMap<>();
			argsMap.put(PvuConstant.EMP_ID_STRING, employeeId);
			
			List<Object[]> classTypes = repository.executeNativeSQLQuery(PVUNativeSqlQueryConstant.getAvailableClassForEmp(), argsMap);
			responseMap.put("Dept_Class", NativeQueryResultsMapper.map(classTypes, PVUEmployeCreationDDLView.class));
		return responseMap;
    }
}
