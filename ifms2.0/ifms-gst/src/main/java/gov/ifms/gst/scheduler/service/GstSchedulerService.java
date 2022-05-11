package gov.ifms.gst.scheduler.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import gov.ifms.gst.dto.request.AppHdr;
import gov.ifms.gst.dto.request.Document;
import gov.ifms.gst.dto.request.RequestPayload;
import gov.ifms.gst.dto.request.Stmt;
import gov.ifms.gst.entity.*;
import gov.ifms.gst.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

@Service
public class GstSchedulerService {
	private static Logger logger = LoggerFactory.getLogger(GstSchedulerService.class);

	private final String PATH = "C:\\projects\\new\\com.demo.javaxml\\src\\main\\resources\\AS010400158560103720191217269404.xml";

	@Autowired
	private RBIAccStmtHdrRepository rbiAccStmtHdrRepository;

	@Autowired
	private RBIAccStmtBalRepository rbiAccStmtBalRepository;

	@Autowired
	private RBIAccStmtTranxnRepository rbiAccStmtTranxnRepository;

	@Autowired
	private RBIFileTranxnRepository rbiFileTranxnRepository;
	
	@Autowired
	private GSTFileProcessRepository gstFileProcessRepository;
	

	//@Scheduled(fixedRate = 5000)
	public void readApi() {
		logger.info("Api Expression Current time is :: {}", Calendar.getInstance().getTime());
		try {
			build(loadRequestPayload());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private GstSchedulerService build(RequestPayload requestPayload) {
		
		//TODO find name of file
		if(!gstFileProcessRepository.findByFileName(requestPayload.getAppHdr().getBizMsgIdr()).isPresent()) {
			buildRbiAccStmtHdr(requestPayload).buildRbiAccStmtBal(requestPayload).buildRbiAccStmtTranxn(requestPayload)
				.buildRbiRBIFileTranxn(requestPayload);
		}

		return this;

	}

	private GstSchedulerService buildRbiAccStmtHdr(RequestPayload requestPayload) {
		
		
		RBIAccStmtHdr rbiAccStmtHdr = new RBIAccStmtHdr();

		AppHdr appHdr = requestPayload.getAppHdr();
		Document document = requestPayload.getDocument();

		Stmt stmt = requestPayload.getDocument().getBkToCstmrStmt().getStmt();

		
		
		rbiAccStmtHdr.setFromMembId(appHdr.getFr().getfIId().getFinInstnId().getClrSysMmbId().getMmbId());
		rbiAccStmtHdr.setBizMsgIdr(appHdr.getBizMsgIdr());
		rbiAccStmtHdr.setBizSvcInfo(appHdr.getBizSvc());
		rbiAccStmtHdr.setId(document.getBkToCstmrStmt().getStmt().getId());
		rbiAccStmtHdr.setLastPgIndx(document.getBkToCstmrStmt().getStmt().getStmtPgntn().getLastPgInd());
		rbiAccStmtHdr.setCreDtTm(document.getBkToCstmrStmt().getStmt().getCreDtTm());
		rbiAccStmtHdr.setDocMsgId(document.getBkToCstmrStmt().getGrpHdr().getMsgId());

		rbiAccStmtHdrRepository.save(rbiAccStmtHdr);
		
		return this;
	}

	private GstSchedulerService buildRbiAccStmtBal(RequestPayload requestPayload) {

		Stmt stmt = requestPayload.getDocument().getBkToCstmrStmt().getStmt();

		stmt.getBal().forEach(b -> {
			RBIAccStmtBal rbiAccStmtBal = new RBIAccStmtBal();
			rbiAccStmtBal.setRbiAccStmtId(stmt.getId());
			rbiAccStmtBal.setCcyInrAmt(b.getAmount().getValue());
			rbiAccStmtBal.setBalCdType(b.getCdtDbtInd());
			rbiAccStmtBal.setCdtDbtDttm(LocalDateTime.parse(b.getDt().getDtTm()));
			rbiAccStmtBalRepository.save(rbiAccStmtBal);
		});

		return this;
	}

	private GstSchedulerService buildRbiAccStmtTranxn(RequestPayload requestPayload) {

		Stmt stmt = requestPayload.getDocument().getBkToCstmrStmt().getStmt();
		
		
		stmt.getNtry().forEach(n->{
			
			DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");  
			
			RBIAccStmtTranxn rbiAccStmtTranxn = new RBIAccStmtTranxn();

			rbiAccStmtTranxn.setRbiAccStmtId(stmt.getId());
			rbiAccStmtTranxn.setNtryRefId(n.getNtryRef());
			rbiAccStmtTranxn.setCcyInrAmt(n.getAmount().getValue());
			rbiAccStmtTranxn.setCrtDbtType(n.getCdtDbtInd());
			rbiAccStmtTranxn.setRvslIndType(n.isRvslInd()?"true":"false");
			rbiAccStmtTranxn.setStatusType(n.getSts());
			rbiAccStmtTranxn.setBookTxCd(n.getBkTxCd().getPrtry().getCd());
			try {
				rbiAccStmtTranxn.setValueDt(dateFormat.parse(n.getValDt().getDt()));
				rbiAccStmtTranxn.setBookingDt(dateFormat.parse(n.getBookgDt().getDt()));
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rbiAccStmtTranxnRepository.save(rbiAccStmtTranxn);
		});
		

		
//    	rbiAccStmtTranxn.setNtry(requestPayload.getDocument().getBkToCstmrStmt().getStmt().getNtry());
//    	rbiAccStmtTranxn.setRvslIndType(PATH);
//    	rbiAccStmtTranxn.setBookingDt(null);

		// rbiAccStmtHdrRepository.save(rBIAccStmtHdr)

		return this;
	}

	private GstSchedulerService buildRbiRBIFileTranxn(RequestPayload requestPayload) {
		
		Stmt stmt = requestPayload.getDocument().getBkToCstmrStmt().getStmt();
		
		
		stmt.getNtry().forEach(n->{

		RBIFileTranxn rbiFileTranxn = new RBIFileTranxn();

	
		rbiFileTranxn.setMemberId(requestPayload.getAppHdr().getFr().getfIId().getFinInstnId().getClrSysMmbId().getMmbId());
		rbiFileTranxn.setMessageId(requestPayload.getDocument().getBkToCstmrStmt().getGrpHdr().getMsgId());

		
		rbiFileTranxnRepository.save(rbiFileTranxn);
		// rbiAccStmtHdrRepository.save(rBIAccStmtHdr)
		});
		return this;
	}
	
	
	private GstSchedulerService buildGstFileProcess(RequestPayload requestPayload) {

		
	AppHdr appHdr = requestPayload.getAppHdr();
	Document document = requestPayload.getDocument();

	Stmt stmt = requestPayload.getDocument().getBkToCstmrStmt().getStmt();
		GSTFileProcess gstFileProcess = new GSTFileProcess();
		

		gstFileProcess.setFileName(appHdr.getBizMsgIdr());
//		gstFileProcess.setMemberId(requestPayload.getAppHdr().getFr().getfIId().getFinInstnId().getClrSysMmbId().getMmbId());
//		gstFileProcess.setMessageId(requestPayload.getDocument().getBkToCstmrStmt().getGrpHdr().getMsgId());

		
		gstFileProcessRepository.save(gstFileProcess);
		// rbiAccStmtHdrRepository.save(rBIAccStmtHdr)
	
		return this;
	}
	

	private RequestPayload loadRequestPayload() throws Exception {
		try {
			XmlMapper xmlMapper = new XmlMapper();
			xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			xmlMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
			File file = new File(PATH);
			String xml = inputStreamToString(new FileInputStream(file));

			// System.out.println("xml \n"+xml);

			return xmlMapper.readValue(xml, RequestPayload.class);

		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("No Data found");
		}

	}

	public String inputStreamToString(InputStream is) throws IOException {
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
