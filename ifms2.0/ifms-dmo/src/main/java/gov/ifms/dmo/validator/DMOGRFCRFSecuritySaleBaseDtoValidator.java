package gov.ifms.dmo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import gov.ifms.dmo.dto.DMOGRFCRFSecuritySalePostDto;
import gov.ifms.dmo.dto.DMOGRFCRFSecuritySalesBasePostDto;

@Component
public class DMOGRFCRFSecuritySaleBaseDtoValidator implements Validator {

	@Autowired
	private DMOGRFCRFSecuritySalesValidator saleSecurityValidator;

	@Override
	public boolean supports(Class<?> clazz) {
		return DMOGRFCRFSecuritySalesBasePostDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		DMOGRFCRFSecuritySalesBasePostDto basePostDto = (DMOGRFCRFSecuritySalesBasePostDto) target;
		saleSecurityValidator = new DMOGRFCRFSecuritySalesValidator();
		int idx = 0;
		for (DMOGRFCRFSecuritySalePostDto saleDto : basePostDto.getSalesSec()) {
			errors.pushNestedPath("salesSec[" + idx + "]");
			ValidationUtils.invokeValidator(this.saleSecurityValidator, saleDto, errors);
			errors.popNestedPath();
			idx++;
		}

	}

}
