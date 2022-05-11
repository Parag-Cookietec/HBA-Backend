package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class PVUEmpEventsRevisedRegularTab implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private List<PVUEmpEventsRevision> empEventsRevision;

	/**
	 * @return the empEventsRevision
	 */
	public List<PVUEmpEventsRevision> getEmpEventsRevision() {
		return empEventsRevision;
	}

	/**
	 * @param empEventsRevision the empEventsRevision to set
	 */
	public void setEmpEventsRevision(List<PVUEmpEventsRevision> empEventsRevision) {
		this.empEventsRevision = empEventsRevision;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empEventsRevision);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUEmpEventsRevisedRegularTab)) {
			return false;
		}
		PVUEmpEventsRevisedRegularTab other = (PVUEmpEventsRevisedRegularTab) obj;
		return Objects.equals(empEventsRevision, other.empEventsRevision);
	}

}