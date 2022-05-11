package gov.ifms.dmo.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "MDMO_WMA_TYPES", schema = Constant.DMO_SCHEMA)
public class DMOWMATypesEntity extends BaseEntity implements Serializable{

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WMA_TYPE_ID")
	private Long id;
	
	@Column(name = "WMA_TYPE")
	private String wmaType;
	
	@Column(name = "WMA_LIMIT")
	private Double wmaLimit;
	
	@Column(name = "WMA_ROI")
	private Double wmaRoi;
	
	@Column(name = "START_FRM_DT")
	private LocalDate startFrmDt;
	
	@Column(name = "END_TO_DT")
	private LocalDate endToDt;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the wmaType
	 */
	public String getWmaType() {
		return wmaType;
	}

	/**
	 * @param wmaType the wmaType to set
	 */
	public void setWmaType(String wmaType) {
		this.wmaType = wmaType;
	}

	/**
	 * @return the wmaLimit
	 */
	public Double getWmaLimit() {
		return wmaLimit;
	}

	/**
	 * @param wmaLimit the wmaLimit to set
	 */
	public void setWmaLimit(Double wmaLimit) {
		this.wmaLimit = wmaLimit;
	}

	/**
	 * @return the wmaRoi
	 */
	public Double getWmaRoi() {
		return wmaRoi;
	}

	/**
	 * @param wmaRoi the wmaRoi to set
	 */
	public void setWmaRoi(Double wmaRoi) {
		this.wmaRoi = wmaRoi;
	}

	/**
	 * @return the startFrmDt
	 */
	public LocalDate getStartFrmDt() {
		return startFrmDt;
	}

	/**
	 * @param startFrmDt the startFrmDt to set
	 */
	public void setStartFrmDt(LocalDate startFrmDt) {
		this.startFrmDt = startFrmDt;
	}

	/**
	 * @return the endToDt
	 */
	public LocalDate getEndToDt() {
		return endToDt;
	}

	/**
	 * @param endToDt the endToDt to set
	 */
	public void setEndToDt(LocalDate endToDt) {
		this.endToDt = endToDt;
	}
	
}
