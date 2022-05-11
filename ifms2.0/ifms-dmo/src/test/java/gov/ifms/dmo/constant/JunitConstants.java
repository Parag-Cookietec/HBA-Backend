package gov.ifms.dmo.constant;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;

import gov.ifms.common.util.Constant;
import gov.ifms.dmo.utils.DMOConstant;

/**
 * The Class JunitConstants.
 */
public class JunitConstants {

	/** The Constant LONG_TYPE. */
	public static final Long LONG_TYPE = Long.valueOf(1l);

	/** The Constant INTEGER_TYPE. */
	public static final Integer INTEGER_TYPE = 1;

	/** The Constant STRING_TYPE. */
	public static final String STRING_TYPE = "abcd";

	public static final String PROC_NAME = DMOConstant.DMO_SCHEMA
			.concat(Constant.DOT.concat(DMOConstant.TRANSACTION_NO_GENERATION));

	public static String generateTrnNo(String geTrnScreen) {
		return geTrnScreen;
	}

	public static List<Object[]> getRefNoSPResult(String refNo) {
		Object[] argsd = { refNo };
		List<Object[]> args = new ArrayList<>();
		args.add(argsd);
		return args;
	}

	public static final String IPS_REF_NO = "20-21/DMO/IPS/001";
	
	public static final String MML_REF_NO = "20-21/DMO/MML/001";

	public static final String RAMI_REF_NO = "20-21/DMO/RAMI/001";

	public static final String RAFI_REF_NO = "20-21/DMO/RAFI/001";

	public static final String MLA_REF_NO = "20-21/DMO/MLA/001";

	public static final String GE_RREF_NO = "20-21/DMO/GE/001";

	public static final String NLR_REF_NO = "20-21/DMO/NLR/001";

	public static final MediaType CONTENT_TYPE = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype());
	public static final String DPS_REF_NO = "20-21/DMO/DPS/001";

}
