package gov.ifms.pvu.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.oauth.service.OAuthService;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.pvu.common.PVUCommonService;
import gov.ifms.pvu.converter.PVUIncrementEmpConverter;
import gov.ifms.pvu.dto.PVUIncrementEmpDto;
import gov.ifms.pvu.entity.PVUIncrementEmpEntity;
import gov.ifms.pvu.repository.PVUIncrementEmpRepository;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUIncrementEmpController.
 * 
 * @version v 1.0
 * @created 2020/01/12 19:19:14
 */
@Service
public class PVUIncrementEmpServiceImpl implements PVUIncrementEmpService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The PVUIncrementEmpAsMethodName repository. */
	@Autowired
	private PVUIncrementEmpRepository repository;

	/** The PVUIncrementEmpAsMethodName helper. */
	@Autowired
	private PVUIncrementEmpConverter converter;

	@Autowired
	private OAuthService authService;

	@Autowired
	private PVUCommonService commonService;

	/**
	 * Retrieves an PVUIncrementEmpEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUIncrementEmpEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUIncrementEmpEntity getIncrementEmp(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUIncrementEmpEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUIncrementEmpEntity
	 */
	@Override
	public PVUIncrementEmpEntity saveOrUpdateIncrementEmp(PVUIncrementEmpEntity entity) {
		return repository.save(entity);
	}

	@Override
	public List<PVUIncrementEmpEntity> saveOrUpdateIncrementEmp(List<PVUIncrementEmpEntity> lstEntity) {
		return repository.saveAll(lstEntity);
	}

	@Override
	public List<PVUIncrementEmpDto> saveOrUpdateIncrementEmpDto(List<PVUIncrementEmpDto> lstPVUIncrementEmpDto) {
		List<PVUIncrementEmpEntity> lstEntity = converter.toEntity(lstPVUIncrementEmpDto);
		return converter.toDTO(saveOrUpdateIncrementEmp(lstEntity));
	}

	@Override
	public List<PVUIncrementEmpDto> getIncrementEmpByEventId(Long inEventId) {
		List<PVUIncrementEmpDto> list = new ArrayList<>();
		List<PVUIncrementEmpEntity> lstPVUIncrementEmpEntity = repository.findAllByInEventIdInEventId(inEventId);
		if (!lstPVUIncrementEmpEntity.isEmpty()) {
			list = converter.toDTO(lstPVUIncrementEmpEntity);
		}
		return list;
	}

	@Override
	public void deleteIncrementEmpIdByEventId(int inActiveStatus, Long incrementEvent, Date updatedDate) {
		repository.deleteIncrementEmptByInEventId(inActiveStatus, incrementEvent, updatedDate,
				OAuthUtility.getCurrentUserUserId(), OAuthUtility.getCurrentUserLkPOUId());
	}

	@Override
	public void deleteIrrelevantEmployeeFromTransaction(Long inEventId) {
		repository.deleteIncrementEmptByInEventId(inEventId);
	}

	@Override
	public String generatePrintEndorsement(IdDto dto) throws IOException, CustomException, DocumentException {
		return generatePdf(dto);
	}

	public String generatePdf(IdDto dto) throws CustomException {

		PdfWriter pdfWriter = null;
		StringWriter writer = new StringWriter();
		// create a new document
		Document document = new Document();
		try {
			String htmltoPdf = null;
			Map<String, Object> map = new HashMap<>();
			document = new Document();
			// document header attributes
			document.addAuthor("GOG");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("GOG Finance");
			document.addTitle("Increment Event");
			document.setPageSize(PageSize.LETTER);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			pdfWriter = PdfWriter.getInstance(document, baos);

			// open document
			document.open();

			writer.write(generatePrint(dto).toString());

			XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
			xmlWorkerHelper.getDefaultCssResolver(true);
			xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(writer.toString()));

			// close the document
			document.close();
			map.put("content", writer.toString());
			htmltoPdf = commonService.htmlToPdfRequest(map); // call this method for node js API for html to Base64
			return htmltoPdf;

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	public StringWriter generatePrint(IdDto dto) {
		/* now render the template into a StringWriter */
		StringWriter writer = new StringWriter();

		List<PVUIncrementEmpEntity> lsEntity = repository.findAllByInEventIdInEventId(dto.getId());
		PVUIncrementEmpEntity entity = lsEntity.get(0);
		VelocityContext context = converter.populateVContext(lsEntity);
		context.put("APPROVER_NAME", String.valueOf(authService.getOnlyIdAndName(entity.getUpdatedBy()).getName()));
		Map<String, Object> map = new HashMap<>();
		map.put("userId", entity.getUpdatedBy());
		setApprover(context, map);
		Template template = getPrintTemplate(entity);
		template.merge(context, writer);
		return writer;
	}

	private void setApprover(VelocityContext context, Map<String, Object> map) {
		List<Object[]> objects = repository.executeSQLQuery(PVUNativeSqlQueryConstant.getUserDesgnationFromUserId(),
				map);
		if (objects == null || objects.isEmpty()) {
			context.put("APPROVER_DESIGNATION", "");
		} else {
			context.put("APPROVER_DESIGNATION", String.valueOf(objects.get(0)[0]));
		}
	}

	public Template getPrintTemplate(PVUIncrementEmpEntity entity) {
		/* first, get and initialize an engine */
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();

		Template tempName = new Template();
		if (entity.getInEventId().getIncrementFor().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			tempName = ve.getTemplate("templates/increment/increment7.vm");
		} else if (entity.getInEventId().getIncrementFor().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
			tempName = ve.getTemplate("templates/increment/increment6.vm");
		} else if (entity.getInEventId().getIncrementFor().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
			tempName = ve.getTemplate("templates/increment/increment5.vm");
		}
		return tempName;
	}

}
