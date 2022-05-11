package gov.ifms.dmo.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.dto.DMOGRFCRFReportDto;
import gov.ifms.dmo.dto.DMOGRFCRFReportPostDto;
import gov.ifms.dmo.dto.DMOGRFCRFStatementReportDto;

public interface DMOGRFCRFReportService {

	PagebleDTO<DMOGRFCRFReportDto> investmentSaleReport(DMOGRFCRFReportPostDto dto) throws CustomException;

	PagebleDTO<DMOGRFCRFStatementReportDto> statementReport(DMOGRFCRFReportPostDto dto) throws CustomException;

	PagebleDTO<DMOGRFCRFReportDto> totalInvestmentSecurityReport(DMOGRFCRFReportPostDto dto) throws CustomException;

	PagebleDTO<DMOGRFCRFReportDto> yearWiseMaturityInvestmentReport(DMOGRFCRFReportPostDto dto) throws CustomException;

}
