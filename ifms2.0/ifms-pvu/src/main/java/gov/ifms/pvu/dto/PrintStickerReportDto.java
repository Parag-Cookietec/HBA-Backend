package gov.ifms.pvu.dto;

/**
 * The Class PrintEndorsementCommonDto.
 */
public class PrintStickerReportDto {

	/** The print endorsement dto. */
	private PVURopPrintEndorsementDto printEndorsementDto;
	
	/** The pvu WF wrapper dto. */
	private PvuWFWrapperDto pvuWFWrapperDto;

	/** The sticker dto. */
	private StickerDTO stickerDTO;

	/**
	 * Gets the prints the endorsement dto.
	 *
	 * @return the prints the endorsement dto
	 */
	public PVURopPrintEndorsementDto getPrintEndorsementDto() {
		return printEndorsementDto;
	}

	/**
	 * Sets the prints the endorsement dto.
	 *
	 * @param printEndorsementDto the new prints the endorsement dto
	 */
	public void setPrintEndorsementDto(PVURopPrintEndorsementDto printEndorsementDto) {
		this.printEndorsementDto = printEndorsementDto;
	}

	/**
	 * Gets the pvu WF wrapper dto.
	 *
	 * @return the pvu WF wrapper dto
	 */
	public PvuWFWrapperDto getPvuWFWrapperDto() {
		return pvuWFWrapperDto;
	}

	/**
	 * Sets the pvu WF wrapper dto.
	 *
	 * @param pvuWFWrapperDto the new pvu WF wrapper dto
	 */
	public void setPvuWFWrapperDto(PvuWFWrapperDto pvuWFWrapperDto) {
		this.pvuWFWrapperDto = pvuWFWrapperDto;
	}

	/**
	 * Gets the sticker dto.
	 *
	 * @return the sticker dto
	 */
	public StickerDTO getStickerDTO() {
		return stickerDTO;
	}

	/**
	 * Sets the sticker dto.
	 *
	 * @param stickerDTO the new sticker dto
	 */
	public void setStickerDTO(StickerDTO stickerDTO) {
		this.stickerDTO = stickerDTO;
	}
}
