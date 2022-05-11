package gov.ifms.gst.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.gst.accounting.dto.EodBCpinData;
import gov.ifms.gst.converter.EodCpinFileDataConvertor;
import gov.ifms.gst.dto.EodCPINFileDataDto;
import gov.ifms.gst.dto.JsonCPINDTO;
import gov.ifms.gst.entity.GSTCPINFileData;
import gov.ifms.gst.repository.EodCpinFileDataRepository;
import gov.ifms.gst.repository.FileTypeHdrRepository;

@Service
public class EodCpinFileDataServiceImpl {
	@Autowired
	private EodCpinFileDataConvertor convertor;

	@Autowired
	private EodCpinFileDataRepository repository;

	@Autowired
	private FileTypeHdrRepository filehdrRepository;

	public EodCPINFileDataDto create(EodCPINFileDataDto dto) {
		dto.setTotalAmt(dto.getCessTotal() + dto.getIgstTotal() + dto.getCgstTotal() + dto.getSgstTotal());
		return convertor.toDTO(repository.save(convertor.toEntity(dto)));
	}

	public GSTCPINFileData jsonDto(JsonCPINDTO dto) {
		GSTCPINFileData gstcpinfiledata = new GSTCPINFileData();
		gstcpinfiledata.setCessFee(Double.parseDouble(dto.getCess_fee()));
		gstcpinfiledata.setBankCd(dto.getBank_cd());
		gstcpinfiledata.setGstinTmpidNo(dto.getGstin());
		gstcpinfiledata.setCpinDt(
				java.sql.Date.valueOf(LocalDate.parse(dto.getCpin_dt(), DateTimeFormatter.ofPattern("d/MM/yyyy"))));
		gstcpinfiledata.setCessIntr(Double.parseDouble(dto.getCess_intr()));
		gstcpinfiledata.setCessOth(Double.parseDouble(dto.getCess_oth()));
		gstcpinfiledata.setCessPenalty(Double.parseDouble(dto.getCess_pnlty()));
		gstcpinfiledata.setCessTax(Double.parseDouble(dto.getCess_tax()));
		gstcpinfiledata.setCessTotal(Double.parseDouble(dto.getCess_total()));
		gstcpinfiledata.setCgstFee(Double.parseDouble(dto.getCgst_fee()));
		gstcpinfiledata.setCgstIntr(Double.parseDouble(dto.getCgst_intr()));
		gstcpinfiledata.setCgstPenalty(Double.parseDouble(dto.getCgst_pnlty()));
		gstcpinfiledata.setCgstOth(Double.parseDouble(dto.getCgst_tax()));
		gstcpinfiledata.setCgstTotal(Double.parseDouble(dto.getCgst_total()));
		gstcpinfiledata.setCgstTax(Double.parseDouble(dto.getCgst_tax()));
		gstcpinfiledata.setIgstFee(Double.parseDouble(dto.getIgst_fee()));
		gstcpinfiledata.setIgstIntr(Double.parseDouble(dto.getIgst_intr()));
		gstcpinfiledata.setIgstOth(Double.parseDouble(dto.getIgst_oth()));
		gstcpinfiledata.setIgstPenalty(Double.parseDouble(dto.getIgst_pnlty()));
		gstcpinfiledata.setIgstTax(Double.parseDouble(dto.getIgst_tax()));
		gstcpinfiledata.setIgstTotal(Double.parseDouble(dto.getIgst_total()));
		gstcpinfiledata.setCpinNo(Long.parseLong(dto.getCpin()));
		gstcpinfiledata.setStateCd(Short.valueOf(dto.getState_cd()));
		gstcpinfiledata.setPaymentModeCd(dto.getPaymentMode());
		gstcpinfiledata.setSgstFee(Double.parseDouble(dto.getSgst_fee()));
		gstcpinfiledata.setSgstIntr(Double.parseDouble(dto.getSgst_intr()));
		gstcpinfiledata.setSgstOth(Double.parseDouble(dto.getSgst_oth()));
		gstcpinfiledata.setSgstPenalty(Double.parseDouble(dto.getSgst_pnlty()));
		gstcpinfiledata.setSgstTax(Double.parseDouble(dto.getSgst_tax()));
		gstcpinfiledata.setSgstTotal(Double.parseDouble(dto.getSgst_total()));
		gstcpinfiledata.setTotalAmt(Double.parseDouble(dto.getTotal_amt()));
		gstcpinfiledata.setPaoFileHdrId(filehdrRepository.findByFileTypeCd(dto.getFileType()).getId());
		gstcpinfiledata.setCpinDtTime(LocalDateTime.parse(dto.getCpin_dt().concat(" ").concat(dto.getCpin_tim()),
				DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		return repository.save(gstcpinfiledata);
	}

	public GSTCPINFileData loadEodBCpinData(EodBCpinData dto) {
		GSTCPINFileData gstcpinfiledata = new GSTCPINFileData();
		// you have to write code to save this value

		return repository.save(gstcpinfiledata);
	}

}
