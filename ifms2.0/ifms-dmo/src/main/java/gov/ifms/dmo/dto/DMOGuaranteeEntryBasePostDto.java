package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DMOGuaranteeEntryBasePostDto implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotEmpty(message = "{guarantee.entry.notNull}")
	@Valid
	private List<DMOGuaranteeEntryPostDto> guaranteeList = new ArrayList<>();

	public List<DMOGuaranteeEntryPostDto> getGuaranteeList() {
		return guaranteeList;
	}

	public void setGuaranteeList(List<DMOGuaranteeEntryPostDto> guaranteeList) {
		this.guaranteeList = guaranteeList;
	}

}
