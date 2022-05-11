package gov.ifms.dmo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DMOGRFCRFIntimationSearchPostDto implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotNull(message = "{intimation.no.notNull}")
	@Size(max = 30, message = "{intimation.no.size}")
	@NotEmpty
	private String intimationNo;
	private Long accountTypeId;
	private String accountType;

	public String getIntimationNo() {
		return intimationNo;
	}

	public void setIntimationNo(String intimationNo) {
		this.intimationNo = intimationNo;
	}

	public Long getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(Long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}
