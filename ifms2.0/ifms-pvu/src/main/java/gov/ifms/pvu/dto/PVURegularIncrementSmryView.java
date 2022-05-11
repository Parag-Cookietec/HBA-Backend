package gov.ifms.pvu.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Date;

@NativeQueryResultEntity
public class PVURegularIncrementSmryView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The in emp id. */
	@NativeQueryResultColumn(index = 0)
	private Integer rn;

	/** The emp id. */
	@NativeQueryResultColumn(index = 1)
	private Long classId;

	/** The emp id. */
	@NativeQueryResultColumn(index = 2)
	private Long total;

	@NativeQueryResultColumn(index = 3)
	private Long eligible;

	/** The emp id. */
	@NativeQueryResultColumn(index = 4)
	private Long inEligible;

	@NativeQueryResultColumn(index = 5)
	private Long included;

	@NativeQueryResultColumn(index = 6)
	private Long excluded;

	/** The cur pay level. */
	@NativeQueryResultColumn(index = 7)
	private Long processed;

	@NativeQueryResultColumn(index = 8)
	private Long failure;

	@NativeQueryResultColumn(index = 9)
	private String className;

	public Integer getRn() {
		return rn;
	}

	public void setRn(Integer rn) {
		this.rn = rn;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getEligible() {
		return eligible;
	}

	public void setEligible(Long eligible) {
		this.eligible = eligible;
	}

	public Long getInEligible() {
		return inEligible;
	}

	public void setInEligible(Long inEligible) {
		this.inEligible = inEligible;
	}

	public Long getIncluded() {
		return included;
	}

	public void setIncluded(Long included) {
		this.included = included;
	}

	public Long getExcluded() {
		return excluded;
	}

	public void setExcluded(Long excluded) {
		this.excluded = excluded;
	}

	public Long getProcessed() {
		return processed;
	}

	public void setProcessed(Long processed) {
		this.processed = processed;
	}

	public Long getFailure() {
		return failure;
	}

	public void setFailure(Long failure) {
		this.failure = failure;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
