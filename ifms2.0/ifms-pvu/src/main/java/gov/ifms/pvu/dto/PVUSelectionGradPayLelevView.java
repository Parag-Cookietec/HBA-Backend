package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVUMsPayCellDto.
 *
 * @version v 1.0
 * @created 2019/12/23 17:34:36
 */
@NativeQueryResultEntity
public class PVUSelectionGradPayLelevView implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@NativeQueryResultColumn(index = 0)
	private long paylevelId;

	/** The cell id. */
	@NativeQueryResultColumn(index = 1)
	private String cellId;

	/** The pay band id. */
	@NativeQueryResultColumn(index = 2)
	private Long cellValue;

	/** The pay band id. */
	@NativeQueryResultColumn(index = 3)
	private String cId;

	@NativeQueryResultColumn(index = 4)
	private boolean flag;

	/**
	 * @return the paylevelId
	 */
	public long getPaylevelId() {
		return paylevelId;
	}

	/**
	 * @param paylevelId the paylevelId to set
	 */
	public void setPaylevelId(long paylevelId) {
		this.paylevelId = paylevelId;
	}

	/**
	 * @return the cellId
	 */
	public String getCellId() {
		return cellId;
	}

	/**
	 * @param cellId the cellId to set
	 */
	public void setCellId(String cellId) {
		this.cellId = cellId;
	}



	/**
	 * @return the flag
	 */
	public boolean isFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	/**
	 * @return the cId
	 */
	public String getcId() {
		return cId;
	}

	/**
	 * @param cId the cId to set
	 */
	public void setcId(String cId) {
		this.cId = cId;
	}

	/**
	 * @return the cellValue
	 */
	public Long getCellValue() {
		return cellValue;
	}

	/**
	 * @param cellValue the cellValue to set
	 */
	public void setCellValue(Long cellValue) {
		this.cellValue = cellValue;
	}


}
