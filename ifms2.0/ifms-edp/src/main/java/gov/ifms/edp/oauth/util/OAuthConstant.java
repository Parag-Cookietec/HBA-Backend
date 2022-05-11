package gov.ifms.edp.oauth.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.lang.StringUtils;

import gov.ifms.common.util.MessageUtil;

/**
 * The Class OAuthConstant.
 */
public class OAuthConstant {

	/** The Constant IS_AUTHENTICATED. */
	public static final String IS_AUTHENTICATED = "isAuthenticated()";

	/** The Constant PERMIT_ALL. */
	public static final String PERMIT_ALL = "permitAll()";

	/** The Constant SECURE_ALGO. */
	public static final String SECURE_ALGO = "PBEWithMD5AndDES";

	/** The Constant ACCESS_CONTROL_ALLOW_ORIGN. */
	public static final String ACCESS_CONTROL_ALLOW_ORIGN = "Access-Control-Allow-Origin";

	/** The Constant ACCESS_CONTROL_ALLOW_ORIGIN_VALUE. */
	public static final String ACCESS_CONTROL_ALLOW_ORIGIN_VALUE = "*";

	/** The Constant ACCESS_CONTROL_ALLOW_METHODS. */
	public static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";

	/** The Constant HTTP_METHOD. */
	public static final String HTTP_METHOD = "POST, GET, PUT, OPTIONS, DELETE, PATCH";

	/** The Constant ACCESS_CONTROL_MAX_AGE. */
	public static final String ACCESS_CONTROL_MAX_AGE = "Access-Control-Max-Age";

	/** The Constant ACCESS_CONTROL_MAX_AGE_VALUE. */
	public static final String ACCESS_CONTROL_MAX_AGE_VALUE = "3600";

	/** The Constant ACCESS_CONTROL_ALLOW_HEADER. */
	public static final String ACCESS_CONTROL_ALLOW_HEADER = "Access-Control-Allow-Headers";

	/** The Constant ACCESS_CONTROL_ALLOW_HEADER_VALUE. */
	public static final String ACCESS_CONTROL_ALLOW_HEADER_VALUE = "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With";

	/** The Constant AUTHORIZATION. */
	public static final String AUTHORIZATION = "Authorization";

	/** The Constant AUTHENTICATION_FAIL. */
	public static final String AUTHENTICATION_FAIL = "Authentication Failed";

	/** The Constant INVALID_REFESH_TOKEN. */
	public static final String INVALID_REFESH_TOKEN = "Invalid Refresh Token";

	/** The Constant AUTHENTICATION_SUCCESS. */
	public static final String AUTHENTICATION_SUCCESS = "Authentication Success";

	/** The Constant OAUTH_DATA_FETCH_SUCESS. */
	public static final String OAUTH_DATA_FETCH_SUCESS = "OAuth Data Fetch Success";

	/** The Constant OAUTH_USER_NOT_FOUND. */
	public static final String OAUTH_USER_NOT_FOUND = "User not exists";

	/** The Constant OAUTH_TOKEN_REVOKE. */
	public static final String OAUTH_TOKEN_REVOKE = "Logout Success";

	/** The Constant USERNAME. */
	public static final String USERNAME = "username";

	/** The Constant USER_CODE. */
	public static final String USER_CODE = "usercode";

	/** The Constant SECRET. */
	public static final String SECRET = "password";

	/** The Constant EMAIL_ID. */
	public static final String EMAIL_ID = "emailId";

	/** The Constant ROLE. */
	public static final String ROLE = "role";

	/** The Constant ENDPOINT. */
	public static final String ENDPOINT = "endpoints";

	/** The Constant MENU. */
	public static final String MENU = "menu";

	/** The Constant OAUTH_USER_INFO. */
	public static final String OAUTH_USER_INFO = "OAuthUserInfo";

	/** The Constant OAUTH_SERVICE_NAME. */
	public static final String OAUTH_SERVICE_NAME = "OauthServiceImpl";

	/** The Constant SECURE_REQUEST_TOKEN_HEADER. */
	public static final String SECURE_REQUEST_TOKEN_HEADER = "Bearer ";

	/** The Constant REQUEST_TOKEN_HEADER. */
	public static final String REQUEST_TOKEN_HEADER = "Basic ";

	/** The Constant GRANT_TYPE_HEADER. */
	public static final String GRANT_TYPE_HEADER = "grant_type";

	/** The Constant STATUS. */
	public static final String STATUS = "status";

	/** The Constant DATA. */
	public static final String DATA = "data";

	/** The Constant ERRORS. */
	public static final String ERRORS = "erros";

	/** The Constant USERID. */
	public static final String USERID = "userId";

	/** The Constant CLIENT. */
	public static final String CLIENT = "client";

	/** The Constant CLIENT_ID. */
	public static final String CLIENT_ID = "client_id";

	/** The Constant SCOPE. */
	public static final String SCOPE = "scope";

	/** The Constant CLIENT_SECRET. */
	public static final String CLIENT_SECRET = "$2a$10$KIaNvGjjTzBR42CSr12xZO14G068lpOg7BZ9uy9P.V8gYtdylUdHy"; // admin

	/** The Constant GRANT_TYPE. */
	public static final String GRANT_TYPE = "password";

	/** The Constant GRANT. */
	public static final String GRANT = "grant";

	/** The Constant AUTHORIZATION_CODE. */
	public static final String AUTHORIZATION_CODE = "authorization_code";

	/** The Constant REFRESH_TOKEN. */
	public static final String REFRESH_TOKEN = "refresh_token";

	/** The Constant IMPLICIT. */
	public static final String IMPLICIT = "implicit";

	/** The Constant SCOPE_READ. */
	public static final String SCOPE_READ = "read";

	/** The Constant SCOPE_WRITE. */
	public static final String SCOPE_WRITE = "write";

	/** The Constant TRUST. */
	public static final String TRUST = "trust";

	/** The Constant ACCESS_TOKEN_VALIDITY_SECONDS. */
	public static final int ACCESS_TOKEN_VALIDITY_SECONDS = Integer.parseInt(MessageUtil.getMsg("ACCESS_TOKEN_VALIDITY_SECONDS"));

	/** The Constant REFRESH_TOKEN_VALIDITY_SECONDS. */
	public static final int REFRESH_TOKEN_VALIDITY_SECONDS = Integer.parseInt(MessageUtil.getMsg("REFRESH_TOKEN_VALIDITY_SECONDS"));

	/** The Constant OPT_VALIDITY. */
	public static final String OPT_VALIDITY = MessageUtil.getMsg("OTP_VALIDITY").trim();

	/** The Constant OAUTH_USER_MAX_SESSION. */
	public static final int OAUTH_USER_MAX_SESSION = 5;

	/** The Constant RESOURCE_ID. */
	public static final String RESOURCE_ID = "resource_id";

	/** The Constant EMPTY. */
	public static final String EMPTY = StringUtils.EMPTY;

	/** The Constant LDAPBASE. */
	public static final String LDAPBASE = "ou=GOG";

	/** The Constant UTF8. */
	public static final Charset UTF8 = StandardCharsets.UTF_8;

	/** The Constant UID. */
	public static final String UID = "uid";

	/** The Constant CN. */
	public static final String CN = "cn";

	/** The Constant OBJECTCLASS. */
	public static final String OBJECTCLASS = "objectClass";

	/** The Constant PERSON. */
	public static final String PERSON = "person";

	/** The Constant TELEPHONE_NUMBER. */
	public static final String TELEPHONE_NUMBER = "telephoneNumber";

	/** The Constant POSTAL_ADDRESS. */
	public static final String POSTAL_ADDRESS = "postalAddress";

	/** The Constant USER_PASSWORD. */
	public static final String USER_PASWD = "userPassword";

	/** The Constant SN. */
	public static final String SN = "sn";

	/** The Constant CACHE_CONTROL. */
	public static final String CACHE_CONTROL = "Cache-Control";

	/** The Constant NOSTORE. */
	public static final String NOSTORE = "no-store";

	/** The Constant PRAGMA. */
	public static final String PRAGMA = "Pragma";

	/** The Constant NOCACHE. */
	public static final String NOCACHE = "no-cache";

	/** The Constant CONTENT_TYPE. */
	public static final String CONTENT_TYPE = "Content-Type";

	/** The Constant CONTENTTYPE_VALUE. */
	public static final String CONTENTTYPE_VALUE = "application/json;charset=UTF-8";

	/** The Constant POST. */
	public static final String POST = "post";

	/** The Constant BOOKMARKS. */
	public static final String BOOKMARKS = "bookmarks";

	/** The Constant OPTIONS. */
	public static final String OPTIONS = "OPTIONS";

	/** The Constant ORGANIZATIONAL_PERSON. */
	public static final Object ORGANIZATIONAL_PERSON = "organizationalPerson";

	/** The Constant UIDOBJECT. */
	public static final Object UIDOBJECT = "uidObject";

	/** The Constant TOP. */
	public static final Object TOP = "top";

	/** The Constant SPRING_ENCRYPT_KEY. */
	public static final String SPRING_ENCRYPT_KEY = "spring.encrypt.key";

	/** The Constant SPRING_OAUTH_ENABLED. */
	// Enabel and Disable OAUtH OR LDAP
	public static final String SPRING_OAUTH_ENABLED = "spring.oauth.enabled";

	/** The Constant USER_ID. */
	public static final String USER_ID = "userId";

	/** The Constant TRUE. */
	public static final String TRUE = "true";

	/** The Constant FALSE. */
	public static final String FALSE = "false";

	/** The Constant ACTIVE_STATUS. */
	public static final int ACTIVE_STATUS = 1;

	/** The Constant DEACTIVE_STATUS. */
	public static final int DEACTIVE_STATUS = 0;

	/** The Constant LOOK_UP_CONDITIONCHECK. */
	public static final String LOOK_UP_CONDITIONCHECK = "ConditionCheck";

	/** The Constant LOOK_UP_INFO_NAME_YES. */
	public static final String LOOK_UP_INFO_NAME_YES = "YES";

	/** The Constant IS_ALREADY_LOGGING. */
	public static final String IS_ALREADY_LOGGING = "isALreadyLogging";

	/** The Constant ALREADY_LOGGING. */
	public static final String ALREADY_LOGGING = "User Already Logged In, Please Logout";

	/** The Constant USERNAME_OR_PASWD_INCORRECT. */
	public static final String USERNAME_OR_PASWD_INCORRECT = "Invalid Employee Number Or Password";
	
	/** The Constant ACCOUNT_LOCKED. */
	public static final String ACCOUNT_LOCKED = "Too many login attempts.Please visit Forgot Password.";

	/** The Constant WRONG_PASSWORD1. */
	public static final String WRONG_PASSWORD1 = "You have entered wrong password ";
	
	/** The Constant WRONG_PASSWORD2. */
	public static final String WRONG_PASSWORD2 = "time(s). If you try  more than 5 times your accout will be locked";


	/** The Constant OFFICE. */
	public static final String OFFICE = "office";

	/** The Constant DESIGNATION. */
	public static final String DESIGNATION = "designation";

	/** The Constant USER_INFO. */
	public static final String USER_INFO = "userinfo";

	/** The Constant MILLI_TO_SECOND_DIFF. */
	public static final long MILLI_TO_SECOND_DIFF = 1000L;

	/** The Constant UNAUTHORISED_ACCESS. */
	public static final String UNAUTHORISED_ACCESS = "Unauthorised To Access Data";

	/** The Constant NO_RIGHTS_FOR_ACCESS_DATA. */
	public static final String NO_RIGHTS_FOR_ACCESS_DATA = "You Have No Rights For Access This Data";

	/** The Constant BODY. */
	public static final String BODY = "body";

	/** The Constant LOG_MSG_USERNAME_REQUESTEDURL_HAVERIGHTS. */
	public static final String LOG_MSG_USERNAME_REQUESTEDURL_HAVERIGHTS = "Username: {}, Requested Url: {} , Have Rights: {}";

	/** The Constant POST_ID. */
	public static final String POST_ID = "postid";

	/** The Constant INVALID_PARAMETER_PASS. */
	public static final String INVALID_PARAMETER_PASS = "Invalid Parameter Pass";

	/** The Constant LOOK_UP_CONDITIONCHECK. */
	public static final String LOOK_UP_LISTOFBILL = "Lists of Bill";

	/** The Constant LOOK_UP_CONDITIONCHECK. */
	public static final String LOOK_UP_BILLTYPE = "Bill Type";

	/** The Constant LOOK_UP_CONDITIONCHECK. */
	public static final String LOOK_UP_STATUSID = "Status_id";

	/** The Constant PASS_CHANGE_SUCCESS. */
	public static final String PASS_CHANGE_SUCCESS = "Password Change Successfully";

	/** The Constant PASS_NOT_SAME. */
	public static final String PASS_NOT_SAME = "New Password And Confirm Password Not Same";
	
	/** The Constant WRONG_OLD_PASS. */
	public static final String WRONG_OLD_PASS = "Current Password is Invalid";

	/** The Constant PASS_ALREADY_USED. */
	public static final String PASS_ALREADY_USED = "Password May Not Be Similar To Last 3 Password";

	/** The Constant X_FORWARDED_FOR. */
	public static final String X_FORWARDED_FOR = "X-FORWARDED-FOR";

	/** The Constant USER_AGENT. */
	public static final String USER_AGENT = "User-Agent";

	/** The Constant SEND_EMAIL_FROM. */
	public static final String SEND_EMAIL_FROM = MessageUtil.getMsg("EMAIL_FROM");

	/** The Constant OTP_SENT_SUCCESSFULLY. */
	public static final String OTP_SENT_SUCCESSFULLY = "OTP Sent Successfully";

	/** The Constant OTP_VALID. */
	public static final String OTP_VALID = "OTP Valid";

	/** The Constant OTP_IN_VALID. */
	public static final String OTP_IN_VALID = "OTP Invalid";

	/** The Constant IS_FIRST_LOGIN. */
	public static final String IS_FIRST_LOGIN = "isFirstLogin";
	
	/** The Constant IS_RESET_PWD_VALUE. */
	public static final int IS_RESET_PWD_VALUE = 1;
	

	/** The Constant INVALID_USER_CODE. */
	public static final String INVALID_USER_CODE = "Invalid Employee Number";
	
	/** The Constant PASS_REGEX. */
	public static final String PASS_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$";
	
	/** The Constant LOOK_UP_STATUS_OFFICE. */
	public static final String LOOK_UP_STATUS_OFFICE = "Status_Office";

	/** The Constant IS_RESET. */
	public static final String IS_RESET = "isResetPwd";
	
	
	/** The Constant PRINT_PD. */
	public static final String PRINT_UC_PD = "UserCode: {} , Password: {}";
	
	/** The Constant NO_POST_MAP_TO_THIS_USER. */
	public static final String NO_POST_MAP_TO_THIS_USER = "No Post Map To This User";

	
	/** The Constant NO_EMAIL_MAP_TO_THIS_USER. */
	public static final String NO_EMAIL_MAP_TO_THIS_USER = "Email Id Not Registered With Employee";

	/** The Constant NO_EMAIL_AND_MNO_MAP_TO_THIS_USER. */
	public static final String NO_EMAIL_AND_MNO_MAP_TO_THIS_USER = "Email Id and Mobile No. is Not Registered with Employee.";

	/** The Constant NOT_GOG_EMAIL_MAP_TO_THIS_USER. */
	public static final String NOT_GOG_EMAIL_MAP_TO_THIS_USER = "GOG Email Id Not Map With Employee";
	
	/** The Constant NEW_PASS_OLD_PASS_NOT_SAME. */
	public static final String NEW_PASS_OLD_PASS_NOT_SAME = "New Password Should Be Not Same Current Password";
	
	/** The Constant USER_CODE_NOT_FOUND. */
	public static final String USER_CODE_NOT_FOUND = "Employee Number Doesn't Exist";
	

	/** The Constant SELF_USER_CODE_FOUND. */
	public static final String SELF_USER_CODE_FOUND = "User Can Not Reset Own Password";

	/** The Constant NO_EMAIL_MAP_TO_THIS_USER. */
	public static final String EMAIL_ID_IS_NOT_VALID= "Email Id is not Valid !!!";

	/** The Constant MOBILE_NO_IS_NOT_VALID. */
	public static final String MOBILE_NO_IS_NOT_VALID= "Mobile No. is not Valid !!!";

	/**
	 * Instantiates a new o auth constant.
	 */
	private OAuthConstant() {
		super();

	}

	/** The Constant EMPLOYEE_INFO. */
	public static final String EMPLOYEE_INFO = "EmployeeInfo";
	
	/** The Constant SWITCH_ROLE_SUCCESSFULLY. */
	public static final String SWITCH_ROLE_SUCCESSFULLY = "Switch Post Successfully";
	
	/** The Constant INVALID_PARAMETER_PASS. */
	public static final String POST_INVALID = "Invalid Post Selected";
	
	/** The Constant EMPLOYEE_INFO. */
	public static final String BRANCH_DETAILS = "branchDetails";
	
	/** The Constant USER_TYPE. */
	public static final String USER_TYPE = "usertype";

	/** The Constant SIGN_IN_MSG_INFO. */
	public static final String SIGN_IN_MSG_INFO = "signInMsgInfo";

	/** The Constant IDEAL_TIMEOUT. */
	public static final String IDEAL_TIMEOUT = "idleTimeout";

	/** The Constant IDEAL_TIMOUT_MILLI_SECONDS. */
	public static final double IDEAL_TIMOUT_MILLI_SECONDS = Double.parseDouble(MessageUtil.getMsg("IDEAL_TIMOUT_MILLI_SECONDS"));

	/** The Constant INVALID_USER_CODE. */
	public static final String INVALID_CAPTCHA = "Invalid Captcha!";
}
