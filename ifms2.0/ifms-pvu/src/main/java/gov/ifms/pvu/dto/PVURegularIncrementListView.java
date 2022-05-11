package gov.ifms.pvu.dto;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NativeQueryResultEntity
public class PVURegularIncrementListView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	PagebleDTO<PVURegularIncrementEligibleListView> eligibleDto;

	PagebleDTO<PVURegularIncrementNonEligibleListView> nonEligibledtos;

	List<PVURegularIncrementSmryView> pvuRegularIncrementSmryView;

	public PagebleDTO<PVURegularIncrementEligibleListView> getEligibleDto() {
		return eligibleDto;
	}

	public void setEligibleDto(PagebleDTO<PVURegularIncrementEligibleListView> eligibleDto) {
		this.eligibleDto = eligibleDto;
	}

	public PagebleDTO<PVURegularIncrementNonEligibleListView> getNonEligibledtos() {
		return nonEligibledtos;
	}

	public void setNonEligibledtos(PagebleDTO<PVURegularIncrementNonEligibleListView> nonEligibledtos) {
		this.nonEligibledtos = nonEligibledtos;
	}

	public List<PVURegularIncrementSmryView> getPvuRegularIncrementSmryView() {
		return pvuRegularIncrementSmryView;
	}

	public void setPvuRegularIncrementSmryView(List<PVURegularIncrementSmryView> pvuRegularIncrementSmryView) {
		this.pvuRegularIncrementSmryView = pvuRegularIncrementSmryView;
	}
}
