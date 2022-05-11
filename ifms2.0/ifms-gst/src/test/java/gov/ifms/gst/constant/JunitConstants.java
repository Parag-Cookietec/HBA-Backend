package gov.ifms.gst.constant;

import java.util.Date;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;

import gov.ifms.common.util.Constant;
import gov.ifms.gst.util.GSTConstant;

/**
 * The Class JunitConstants.
 */
public class JunitConstants {

	/** The Constant INTEGER_TYPE. */
	public static final Integer INTEGER_TYPE = 1;

	/** The Constant INTEGER_TYPE_ZERO. */
	public static final Integer INTEGER_TYPE_ZERO = 0;

	/** The Constant LONG_TYPE. */
	public static final Long LONG_TYPE = 1l;

	/** The Constant STRING_TYPE. */
	public static final String STRING_TYPE = "123";

	/** The Constant STATUS. */
	public static final String STATUS = "Pending";
	/** The Constant STRING_ABC. */
	public static final String STRING_ABC = "abc";

	/** The Constant ACTIVE_STATUS. */
	public static final int ACTIVE_STATUS = 1;

	/** The Constant REQUEST_TYPE_ACTIVATE. */
	public static final Long REQUEST_TYPE_ACTIVATE = 1260L;

	/** The Constant REQUEST_TYPE_INACTIVATE. */
	public static final Long REQUEST_TYPE_INACTIVATE = 1261L;

	/** The Constant DATE. */
	public static final Date DATE = new Date();

	/** The Constant INT_TYPE. */
	public static final int INT_TYPE = 0;

	/** The Constant TRUE_V. */
	public static final Boolean TRUE_V = true;

	/** The Constant FALSE_V. */
	public static final Boolean FALSE_V = false;

	/** The Constant DOUBLE_VAL. */
	public static final Double DOUBLE_VAL = 1.00;

	/** The Constant LONG_TYPE_ZER. */
	public static final Long LONG_TYPE_ZER = 0l;

	public static final String PROC_NAME = GSTConstant.GST_SCHEMA.concat(Constant.DOT.concat(GSTConstant.P_GST_TRN_NO_GEN));

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
}
