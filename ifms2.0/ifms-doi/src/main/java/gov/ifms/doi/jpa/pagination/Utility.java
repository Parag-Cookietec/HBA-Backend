package gov.ifms.doi.jpa.pagination;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.DoiCommonLookUpInfoDTO;
import gov.ifms.doi.jpa.service.imp.DoiCommonLookupInfoServiceImpl;

@Service
public class Utility {

	public static final String DATE_FORMAT = "dd/MM/yyyy";

	public static Object converter(Class<?> clazz, Object value) throws ParseException {
		Object obj = null;
		if (clazz == int.class) {
			obj = Integer.parseInt(value.toString());
		} else if (clazz == String.class) {
			obj = value.toString();
		} else if (clazz == Date.class) {
			obj = new SimpleDateFormat(DATE_FORMAT).parse(value.toString());
		} else if (clazz == LocalDate.class) {
			obj = LocalDate.parse(value.toString(), DateTimeFormatter.ofPattern(DATE_FORMAT));
		} else if (clazz == Double.class) {
			obj = Double.parseDouble(value.toString());
		} else {
			obj = value;
		}
		return obj;

	}

	public static Predicate getPredictionUtil(Path<?> path, SearchCriteria criteria, Root<T> root,
			CriteriaBuilder builder) {
		try {
			Object currentValue = criteria.getValue();
			Class<?> clazz = path.getJavaType();

			if (clazz == int.class) {
				return builder.greaterThanOrEqualTo(root.get(criteria.getKey()),
						Integer.parseInt(currentValue.toString()));
			} else if (clazz == String.class) {
				return builder.greaterThanOrEqualTo(root.get(criteria.getKey()), currentValue.toString());
			} else if (clazz == Date.class) {
				return builder.greaterThanOrEqualTo(root.get(criteria.getKey()),
						new SimpleDateFormat(DATE_FORMAT).parse(currentValue.toString()));
			} else if (clazz == LocalDate.class) {
				return builder.greaterThanOrEqualTo(root.get(criteria.getKey()),
						LocalDate.parse(currentValue.toString(), DateTimeFormatter.ofPattern(DATE_FORMAT)));
			} else if (clazz == Double.class) {
				return builder.greaterThanOrEqualTo(root.get(criteria.getKey()),
						Double.parseDouble(currentValue.toString()));
			} else {
				return builder.greaterThanOrEqualTo(root.get(criteria.getKey()), currentValue.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Autowired
	DoiCommonLookupInfoServiceImpl doiCommonLookupInfoServiceImpl;

	/**
	 * 
	 * @return
	 */
	public String getRefrenceNumber() {
		List<DoiCommonLookUpInfoDTO> response = doiCommonLookupInfoServiceImpl
				.getByParentLookUpName(DoiJPAConstants.REFERENCE_NUMBER);
		String formatted = String.valueOf(Long.valueOf(response.get(0).getLookupInfoValue()) + 1);
		doiCommonLookupInfoServiceImpl.updateLookupInfoValue(DoiJPAConstants.REFERENCE_NUMBER, formatted);
		int lastTwoDigits = Calendar.getInstance().get(Calendar.YEAR) % 100;
		return lastTwoDigits + "-" + (lastTwoDigits + 1) + "/DOI/JPA/" + formatted;
	}

	public String getPolicyNumber() {
		List<DoiCommonLookUpInfoDTO> response = doiCommonLookupInfoServiceImpl
				.getByParentLookUpName(DoiJPAConstants.POLICY_NUMBER);
		String formatted = String.valueOf(Long.valueOf(response.get(0).getLookupInfoValue()) + 1);
		doiCommonLookupInfoServiceImpl.updateLookupInfoValue(DoiJPAConstants.POLICY_NUMBER, formatted);
		return formatted;
	}
	
	public short getEndorsementSrNo() {
		List<DoiCommonLookUpInfoDTO> response = doiCommonLookupInfoServiceImpl
				.getByParentLookUpName(DoiJPAConstants.ENDORSEMENT_NUMBER);
		short formatted = (short) (Long.valueOf(response.get(0).getLookupInfoValue()) + 1);
		doiCommonLookupInfoServiceImpl.updateLookupInfoValue(DoiJPAConstants.ENDORSEMENT_NUMBER, String.valueOf(formatted));
		return formatted;
	}
	
	public String getClaimNumber() {
		List<DoiCommonLookUpInfoDTO> response = doiCommonLookupInfoServiceImpl
				.getByParentLookUpName(DoiJPAConstants.CLAIM_NUMBER);
		String formatted = String.valueOf(Long.valueOf(response.get(0).getLookupInfoValue()) + 1);
		doiCommonLookupInfoServiceImpl.updateLookupInfoValue(DoiJPAConstants.CLAIM_NUMBER, formatted);
		if(formatted.length()<5) {
			StringUtils.leftPad(formatted,5, "0");
		}
		return formatted;
	}


}