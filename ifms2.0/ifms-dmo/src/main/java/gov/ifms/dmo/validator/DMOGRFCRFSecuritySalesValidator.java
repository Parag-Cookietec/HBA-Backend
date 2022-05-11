package gov.ifms.dmo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import gov.ifms.dmo.dto.DMOGRFCRFSecuritySalePostDto;

@Component
public class DMOGRFCRFSecuritySalesValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return DMOGRFCRFSecuritySalePostDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "saleDt", "sale.dt.notNull");
		ValidationUtils.rejectIfEmpty(errors, "rbiAdviceNo", "rbi.advice.no.notNull");
		ValidationUtils.rejectIfEmpty(errors, "rbiAdviceDt", "rbi.advice.dt.notNull");
		ValidationUtils.rejectIfEmpty(errors, "currAccBal", "prog.bal.acc.notNull");
		ValidationUtils.rejectIfEmpty(errors, "stAccTransfrAmt", "st.acc.transfr.amt.notNull");
		ValidationUtils.rejectIfEmpty(errors, "securityTypeId", "security.type.id.notNull");
		ValidationUtils.rejectIfEmpty(errors, "currFaceValue", "curr.face.value.notNull");
		ValidationUtils.rejectIfEmpty(errors, "faceValSecSold", "face.val.sec.sold.notNull");
		ValidationUtils.rejectIfEmpty(errors, "unitsSoldNo", "units.sold.no.notNull");
		ValidationUtils.rejectIfEmpty(errors, "salesPrice", "sales.price.notNull");
		ValidationUtils.rejectIfEmpty(errors, "brokenDays", "broken.days.notNull");
		ValidationUtils.rejectIfEmpty(errors, "accrIntrstRecv", "accr.intrst.recv.notNull");
		ValidationUtils.rejectIfEmpty(errors, "totalRelzdAmt", "total.relzd.amt.notNull");
	}

}
