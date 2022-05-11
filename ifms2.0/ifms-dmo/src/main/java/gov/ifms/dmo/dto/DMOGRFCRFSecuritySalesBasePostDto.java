package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DMOGRFCRFSecuritySalesBasePostDto implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotEmpty(groups = { DMOGRFCRFSecuritySalePostDto.class }, message = "{sales.securities.notNull}")
	@Valid
	private List<DMOGRFCRFSecuritySalePostDto> salesSec = new ArrayList<>();

	public List<DMOGRFCRFSecuritySalePostDto> getSalesSec() {
		return salesSec;
	}

	public void setSalesSec(List<DMOGRFCRFSecuritySalePostDto> salesSec) {
		this.salesSec = salesSec;
	}

}
