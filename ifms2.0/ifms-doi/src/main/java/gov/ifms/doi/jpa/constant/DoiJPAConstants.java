package gov.ifms.doi.jpa.constant;

/**
 * 
 * @author Sagar Jadhav
 *
 */
public class DoiJPAConstants {

	private DoiJPAConstants() {
	}

	public static final String DOI_SCHEMA = "DOI";
	public static final String MASTER_V1_SCHEMA = "MASTER_V1";
	public static final String DOI_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss SSS";
	public static final String DOI_DATE_FORMAT = "yyyy-MM-dd";

	public static final String DOI_JPA_CLAIM_LISTING_BASE_URL = "doi/claim-listing";
	public static final String DOI_JPA_CLAIM_LISTING = "doi/claim-listing-page";

	public static final String SEND_FOR_PAYMENT_LISTING = "Send_For_Payment";
	public static final String ACCEPTED_APPLICATION_LISTING = "Accepted_Application";
	public static final String RETURL_TO_NODAL_LISTING = "Return_To_Nodal";
	public static final String PENDING_FOR_APPROVAL_LISTING = "Pending_for_Approval";

	public static final String ACTIVE_STATUS_VALUE = "1";
	public static final String IN_ACTIVE_STATUS_VALUE = "0";

	public static final String CAUSE_OF_LOSS_LIST = "Cause of Loss";
	public static final String YES_NO_REQUIREMENT_LIST = "Requirement List";
	public static final String ACTIVE_INACTIVE_LIST = "Active Inactive";
	public static final String ACTIVE_POLICY_TYPES_LIST = "Policy Types";
	public static final String ACTIVE_POLICY_STATUS_LIST = "Policy Status List";
	public static final String ACTIVE_YEAR_LIST = "Year List";
	public static final String ACTIVE_MONTH_LIST = "Month List";
	public static final String REFERENCE_NUMBER = "Reference Number";
	public static final String POLICY_NUMBER = "Policy Number";
	public static final String CLAIM_NUMBER = "Claim Number";
	public static final String ENDORSEMENT_NUMBER = "Endorsement Number";
	public static final String DECEASED_PERSON = "Deceased Person";
	public static final String GUJRAT_STATE = "Gujarat";
	public static final Long GUJRAT_STATE_ID = (long) 7;
	public static final String DIRECT_BUSINESS_PARTY_TYPE = "DIRECT_BUSINESS_PARTY_TYPE";
	public static final String DIRECT_BUSINESS_OFFICE_TYPE = "Office_type";
	public static final String DOI_BANK_BRANCH_TYPE = "Branch Type";
	public static final String DOI_PAYMENT_MODE = "Payment Mode";

}
