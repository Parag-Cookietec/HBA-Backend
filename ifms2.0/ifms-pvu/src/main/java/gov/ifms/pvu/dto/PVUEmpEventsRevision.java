package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class PVUEmpEventsRevision implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	private int revised;
	private List<PVUEmpEventsRevisedRegularTabView> tabDetails;

	/**
	 * @return the revised
	 */
	public int getRevised() {
		return revised;
	}

	/**
	 * @param revised the revised to set
	 */
	public void setRevised(int revised) {
		this.revised = revised;
	}

	/**
	 * @return the tabDetails
	 */
	public List<PVUEmpEventsRevisedRegularTabView> getTabDetails() {
		return tabDetails;
	}

	/**
	 * @param tabDetails the tabDetails to set
	 */
	public void setTabDetails(List<PVUEmpEventsRevisedRegularTabView> tabDetails) {
		this.tabDetails = tabDetails;
	}

	@Override
	public int hashCode() {
		return Objects.hash(revised, tabDetails);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUEmpEventsRevision)) {
			return false;
		}
		PVUEmpEventsRevision other = (PVUEmpEventsRevision) obj;
		return revised == other.revised && Objects.equals(tabDetails, other.tabDetails);
	}

}