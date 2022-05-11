package gov.ifms.pvu.dto;

/**
 * The Class PrintEndorsementCommonDto.
 */
public class PvuPrintStickerReportDto {

	private PVUPrintEndorsementDto printEndorsementDto;
	private PvuWFWrapperDto pvuWFWrapperDto;
	private PVUStickerDTO stickerDTO;

	public PVUPrintEndorsementDto getPrintEndorsementDto() {
		return printEndorsementDto;
	}

	public void setPrintEndorsementDto(PVUPrintEndorsementDto printEndorsementDto) {
		this.printEndorsementDto = printEndorsementDto;
	}

	public PvuWFWrapperDto getPvuWFWrapperDto() {
		return pvuWFWrapperDto;
	}

	public void setPvuWFWrapperDto(PvuWFWrapperDto pvuWFWrapperDto) {
		this.pvuWFWrapperDto = pvuWFWrapperDto;
	}

	public PVUStickerDTO getStickerDTO() {
		return stickerDTO;
	}

	public void setStickerDTO(PVUStickerDTO stickerDTO) {
		this.stickerDTO = stickerDTO;
	}

	

	
	
	
}
