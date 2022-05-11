package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.List;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUFixToRegularPayConDto.
 * 
 * @version 1.0
 * @created 2021/04/11 14:05:32
 *
 */
public class PVUFixToRegularPayConListDto extends BaseDto implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	private List<PVUFixToRegularPayConDto> dtos;

	/**
	 * @return the dtos
	 */
	public List<PVUFixToRegularPayConDto> getDtos() {
		return dtos;
	}

	/**
	 * @param dtos the dtos to set
	 */
	public void setDtos(List<PVUFixToRegularPayConDto> dtos) {
		this.dtos = dtos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dtos == null) ? 0 : dtos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof PVUFixToRegularPayConListDto))
			return false;
		PVUFixToRegularPayConListDto other = (PVUFixToRegularPayConListDto) obj;
		if (dtos == null) {
			if (other.dtos != null)
				return false;
		} else if (!dtos.equals(other.dtos))
			return false;
		return true;
	}

	
}
