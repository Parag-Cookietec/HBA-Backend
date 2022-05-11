package gov.ifms.loc.service;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.util.FreeMarkerEngine;

@Service
public class LocPDFService  {
	private Logger logger = LoggerFactory.getLogger(LocPDFService.class);

	@Autowired
	private FreeMarkerEngine freeMarkerEngine;

	@Value("${node.url}")
	private String nodeUrl;

	/**
	 * Html to Gujarati PDF convert through node serve Url
	 * 
	 * @param html string as map
	 * @return Base64 in response for PDF generate on browser level
	 */
	public String htmlToPdfRequest(Map<String, Object> map) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, Object>> request = new HttpEntity<>(map, headers);
		ResponseEntity<String> response = restTemplate.postForEntity(nodeUrl + URLConstant.GENERATE_PVU_PDF, request,
				String.class);
		return response.getBody();
	}

	/**
	 * Generate PDF
	 * 
	 * @param templateName
	 * @param outputMap
	 * @param docTitle
	 * @return
	 */
	public String generatePDF(String templateName, Map<String, Object> outputMap, String pdfFileName)  {

		String htmltoPdf = null;
		String base64toPDF = null;
		Map<String, Object> map = new HashMap<>();
		StringWriter writer = new StringWriter();

		try {
			writer.write(freeMarkerEngine != null ? freeMarkerEngine.process(templateName, outputMap) : null);

			map.put("content", writer.toString());
			htmltoPdf = htmlToPdfRequest(map);

			logger.info("PDF generated successfully");

			base64toPDF = htmltoPdf;
		} 
		catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return base64toPDF;
	}

	
}