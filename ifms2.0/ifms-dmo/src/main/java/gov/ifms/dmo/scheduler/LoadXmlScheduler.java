package gov.ifms.dmo.scheduler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class LoadXmlScheduler {

	public static final String PATH_HDR = "C:\\Project\\doc\\Fax message\\DP011600000000000020210813000222.xml";
	public static final String PATH_DTL = "C:\\Project\\doc\\Clearance Memo\\CMV6011610099000009220210813000010.xml";
	
	public static DPHdrFaxRequestPayload loadRequestPayloadForHdr() throws Exception {
		try {
			XmlMapper xmlMapper = new XmlMapper();
			xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			xmlMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
			File file = new File(PATH_HDR);
			String xml = inputStreamToString(new FileInputStream(file));

			return xmlMapper.readValue(xml, DPHdrFaxRequestPayload.class);

		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("No Data found");
		}

	}

	public static DPDtlClearenceRequestPayload loadRequestPayloadForDtl() throws Exception {
		try {
			XmlMapper xmlMapper = new XmlMapper();
			xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			xmlMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
			File file = new File(PATH_DTL);
			String xml = inputStreamToString(new FileInputStream(file));
			
			return xmlMapper.readValue(xml, DPDtlClearenceRequestPayload.class);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new Exception("No Data found");
		}
		
	}

	public static String inputStreamToString(InputStream is) throws IOException {
		StringBuilder sb = new StringBuilder();
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		return sb.toString();
	}

}
