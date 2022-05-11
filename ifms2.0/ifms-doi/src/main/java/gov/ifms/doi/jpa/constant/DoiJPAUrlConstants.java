package gov.ifms.doi.jpa.constant;

public class DoiJPAUrlConstants {

	private DoiJPAUrlConstants() {
	}

	// JPA Config
	public static final String JPA_CONFIG_SCHEME_POLICY = "doi/master-scheme-policy-dropdown";

	// JPA scheme Entry
	public static final String JPA_SCHEME_MASTER_ENTRY = "doi/master-scheme-entry";
	public static final String JPA_SCHEME_MASTER_LISTING = "doi/master-scheme-listing";
	public static final String JPA_SCHEME_MASTER_LIST = "doi/master-schemes";
	public static final String JPA_SCHEME_MASTER_DELETE = "doi/master-scheme-delete";
	public static final String JPA_SCHEME_MASTER_UPDATE = "doi/master-scheme-update";
	public static final String GET_JPA_SCHEME_MASTER = "doi/master-scheme/{schemeId}";

	// JPA Master policy
	public static final String JPA_SCHEME_MASTER_POLICY_ENTRY = "doi/jpa/jpa-master-policy";
	public static final String JPA_SCHEME_MASTER_POLICY_LISTING = "doi/jpa/jpa-master-policy-listing";
	public static final String JPA_SCHEME_MASTER_POLICY_LISTING_BY_SCHEME_ID = "doi/jpa/jpa-master-policy-listing-by-scheme-id";
	public static final String JPA_SCHEME_MASTER_POLICY_DELETE = "doi/jpa/jpa-master-policy-delete";
	public static final String JPA_SCHEME_MASTER_POLICY_LIST = "doi/jpa/jpa-master-policy-list";
	public static final String JPA_SCHEME_MASTER_POLICY_TYPES = "doi/jpa/jpa-master-policy-types";
	public static final String JPA_SCHEME_MASTER_STATUS = "doi/jpa/jpa-master-status";
	

	public static final String JPA_SCHEME_MASTER_POLICY_WF_ENTRY = "doi/jpa/jpa-master-policy-wf";
	public static final String JPA_SCHEME_MASTER_POLICY_WF_ENTRY_LISTING = "doi/jpa/jpa-master-policy-wf-listing";

	// JPA document master
	public static final String DOI_JPA_DOCUMENT_BASE_URL = "doi/jpa/document-master";
	// JPA document master common
	public static final String DOI_JPA_COMMON_DOCUMENT_LISTING = "/common-document-listing";
	public static final String DOI_JPA_COMMON_DOCUMENT_DELETE = "/common-document-delete";
	public static final String DOI_JPA_COMMON_DOCUMENT_ENTRY = "/common-document-entry";
	// JPA document master scheme
	public static final String DOI_JPA_SCHEME_DOCUMENT_LISTING = "/scheme-document-listing";
	public static final String DOI_JPA_SCHEME_DOCUMENT_DELETE = "/scheme-document-delete";
	public static final String DOI_JPA_SCHEME_DOCUMENT_ENTRY = "/scheme-document-entry";
	// JPA document master loss cause
	public static final String DOI_JPA_LOSSCAUSE_DOCUMENT_LISTING = "/loss-cause-document-listing";
	public static final String DOI_JPA_LOSSCAUSE_DOCUMENT_DELETE = "/loss-cause-document-delete";
	public static final String DOI_JPA_LOSSCAUSE_DOCUMENT_ENTRY = "/loss-cause-document-entry";
	public static final String DOI_JPA_DOCUMENT_LIST_BY_LOSS_CAUSE_AND_SCHEMEID = "/document-list-for-claim";

	// JPA Claim Entry
	public static final String JPA_CLAIM_ENTERY = "doi/jpa/jpa-claim-entry";
	public static final String JPA_CLAIM_ENTERY_LISTING = "doi/jpa/jpa-claim-entry-listing";
	public static final String JPA_CLAIM_ENTERY_LISTING_BY_STATUS = "doi/jpa/jpa-claim-entry-listing-by-status";
	public static final String JPA_CLAIM_ENTERY_BY_ID = "doi/jpa/jpa-claim-entry/{claimId}";	
	public static final String JPA_CLAIM_ENTERY_WF_ENTRY = "doi/jpa/jpa-claim-entry-wf";
	public static final String JPA_CLAIM_ENTERY_WF_ENTRY_LISTING = "doi/jpa/jpa-claim-entry-wf-listing";

	// JPA Legal
	public static final String DOI_JPA_LEGAL_ENTRY_BASE_URL = "doi/jpa-legal";
	public static final String DOI_JPA_LEGAL_ENTRY = "/entry";
	public static final String DOI_GET_JPA_LEGAL_ENTRY = "/entry/{legalEntryId}";
	public static final String DOI_JPA_LEGAL_ENTRY_LISTING = "/entry-listing";
	public static final String DOI_JPA_LEGAL_ENTRY_FOR_REQUEST = "/entry-for-request";
	public static final String DOI_JPA_DELETE_LEGAL_ENTRY_FOR_REQUEST = "/delete-entry-for-request/{legalDtlsId}";
	public static final String DOI_JPA_LEGAL_ENTRY_FOR_REQUEST_LISTING = "/entry-for-request-listing";
	public static final String DOI_JPA_LEGAL_ENTRY_JSON_FORMAT = "/jpa-legal-entry-json-format";
	public static final String DOI_JPA_LEGAL_CLAIM_LISTING = "/claim-listing";
	public static final String CONTENT_TYPE_APP_JSON = "application/json";
	public static final String JPA_LEGAL_ENTERY_WF_ENTRY = "doi/jpa/jpa-legal-entry-wf";
	public static final String JPA_LEGAL_ENTERY_WF_ENTRY_LISTING = "doi/jpa/jpa-legal-entry-wf-listing";

	// Re-Insurance
	public static final String RI_BASE_URL = "re-insurance";
	public static final String RI_PREMIUM_REGISTER_URL = "/premium-register";
	public static final String RI_CLAIM_RECOVERY_ENTRY_URL = "/claim-recovery-entry";
	public static final String RI_POLICY_MASTER_URL = "/policy-master";
	public static final String RI_GET_POLICY_CLAIM_URL = "/policy-Claim_Dtls";
	
	//Co-Insurance
	public static final String COINS_BASE_URL = "co-insurance";
	public static final String COINS_CHEQUE_REGISTER_URL = "/cheque-register";
	public static final String COINS_CHEQUE_REGISTER_LISTING_URL = "/cheque-register-listing"; 
	public static final String COINS_PREMIUM_REGISTER_URL = "/premium-register"; 
	public static final String COINS_POLICY_ENTRY_URL = "/policy-entry";
	public static final String COINS_POLICY_ENTRY_LISTING_URL = "/policy-entry-listing";
	public static final String COINS_POLICY_ENTERY_WF_ENTRY = "co-insurance/coins-policy-entry-wf";
	public static final String COINS_POLICY_ENTERY_WF_ENTRY_LISTING = "co-insurance/coins-policy-entry-wf-listing";
	public static final String COINS_PREMIUM_REFUND_ENTRY_URL = "/premium-refund-entry";
	public static final String COINS_PREMIUM_REFUND_ENTRY_LISTING_URL = "/premium-refund-listing";
	public static final String COINS_CLAIM_ENTRY_URL = "/claim-entry";
	public static final String COINS_CLAIM_LISTING_URL = "/claim-listing";
	public static final String COINS_CLAIM_ENTRY_WF_ENTRY = "co-insurance/coins-claim-entry-wf";
	public static final String COINS_CLAIM_ENTRY_WF_LISTING = "co-insurance/coins-claim-entry-wf-listing";
	//Claim-details
	//Common
	public static final String JPA_COMMON_LOOKUP_CAUSE_OF_LOST = "doi/common-lookup-cause-of-loss";
	public static final String JPA_COMMON_REQUIREMENT_LIST = "doi/common-lookup-requirement-list";
	public static final String JPA_ACTIVE_INACTIVE_LIST = "doi/common-lookup-active-inactive-list";
	public static final String JPA_POLICY_TYPES_LIST = "doi/common-lookup-policy-types-list";
	public static final String JPA_POLICY_STATUS_LIST = "doi/common-lookup-policy-status-list";
	public static final String JPA_YEAR_LIST = "doi/common-lookup-year-list";
	public static final String JPA_MONTH_LIST = "doi/common-lookup-month-list";
	public static final String JPA_LOOKUP_INFO_BASED_ON_CATEGORY = "doi/common-lookup-info-oncategory";
	public static final String DOI_BANK_LIST= "doi/common-bank-list";
	public static final String DOI_BANK_BRANCH_LIST= "doi/common-bank-branch-list";
	
	//ADDRESS LOOK UP
	public static final String JPA_DOI_GET_STATE_LIST = "doi/common-state-list";
	public static final String JPA_DOI_GET_DISTRICT_LIST_GUJRAT = "doi/common-district-list-gujrat";
	public static final String JPA_DOI_GET_DISTRICT_LIST_BY_STATE_ID = "doi/common-district-list-by-state-id";
	public static final String JPA_DOI_GET_DISTRICT_LIST = "doi/common-district-list";
	public static final String JPA_DOI_GET_TALUKA_LIST_BY_DISTRICT_ID = "doi/common-taluka-list-by-districtid";
	public static final String JPA_DOI_GET_TALUKA_BY_TALUKA_ID = "doi/common-taluka-byid";
	public static final String JPA_DOI_GET_VILLAGE_LIST_BY_TALUKA_ID = "doi/common-village-list-by-talukaid";	
	public static final String JPA_DOI_GET_VILLAGE_BY_VILLAGE_ID = "doi/common-village-byid";
	
	//HBA	
	public static final String DOI_JPA_HBA_BASE_URL="doi/hba";
	//POLICY
	public static final String HBA_POLICY_MASTER="doi/hba/hba-policy-master";	
	public static final String POLICY_MASTER_LISTING="doi/hba/policy-master-listing";
	public static final String POLICY_MASTER_PRINTOUT="doi/hba/policy-master-printout";	
	
	public static final String SURVEYOR_MASTER="doi/hba/surveyor-master";
	public static final String SURVEY_MASTER_LISTING="doi/hba/survey-master-listing";
	public static final String SURVEYOR_BILL_GENERATION_ENTRY="doi/hba/surveyor-bill-generation-entry";
	public static final String SURVEYOR_BILL_GENERATION_LISTING="doi/hba/surveyor-bill-generation-listing";
	//PRAPOSAL
	public static final String HBA_POLICY_PROPOSAL_ENTRY="doi/hba/hba-policy-proposal-entry";
	public static final String POLICY_PROPOSAL_LISTING="doi/hba/policy-proposal-listing";
	public static final String POLICY_PROPOSAL_DELETE="doi/hba/policy-proposal-delete";
	public static final String POLICY_PROPOSAL_LISTING_BY_STATUS="doi/hba/policy-proposal-listing-by-status";
	public static final String POLICY_PROPOSAL_EMPLOYEE_DETAILS="doi/hba/policy-proposal-employee-details";
	//PRAPOSAL WF
	public static final String HBA_POLICY_PROPOSAL_ENTRY_WF="doi/hba/hba-policy-proposal-entry-wf";
	public static final String POLICY_PROPOSAL_LISTING_WF="doi/hba/policy-proposal-listing-wf";
	public static final String POLICY_PROPOSAL_DELETE_WF="doi/hba/policy-proposal-delete-wf";
	public static final String POLICY_PROPOSAL_LISTING_BY_STATUS_WF="doi/hba/policy-proposal-listing-by-status-wf";
	//Claim Entry
	public static final String HBA_CLAIM_ENTRY="doi/hba/claim-entry";
	public static final String CLAIM_ENTRY_LISTING="doi/hba/claim-entry-listing";
	public static final String CLAIM_ENTRY_DELETE="doi/hba/claim-entry-delete";
	public static final String CLAIM_ENTRY_SEND_FOR_PAYMENT="doi/hba/claim-entry-send-for-payment";
	public static final String HBA_CLAIM_LOSS_ENTRY="doi/hba/hba-claim-entry-loss";
	//Loss Claim Entry
	public static final String CLAIM_LOSS_ENTRY_LISTING="doi/hba/claim-entry-listing-loss";
	public static final String CLAIM_LOSS_ENTRY_DELETE="doi/hba/claim-entry-loss-delete";
	public static final String CLAIM_LOSS_ENTRY_LISTING_BY_STATUS="doi/hba/claim-entry-loss-listing-by-status";
	//Reject Claim 
	public static final String HBA_CLAIM_REJECT_ENTRY="doi/hba/hba-claim-entry-reject";
	public static final String CLAIM_REJECT_ENTRY_LISTING="doi/hba/claim-entry-listing-reject";
	public static final String CLAIM_REJECT_ENTRY_DELETE="doi/hba/claim-entry-reject-delete";
	public static final String CLAIM_REJECT_ENTRY_LISTING_BY_STATUS="doi/hba/claim-entry-reject-listing-by-status";
	//HBA Claim WF
	public static final String CLAIM_WF_ENTRY_LISTING="doi/hba/claim-entry-listing-wf";
	public static final String CLAIM_WF_ENTRY_DELETE="doi/hba/claim-entry-delete-wf";
	public static final String HBA_WF_CLAIM_LOSS_ENTRY="doi/hba/hba-claim-entry-loss-wf";	
	//HBA OTHER Claim WF
	public static final String CLAIM_OTHER_ENTRY_LISTING="doi/hba/claim-entry-listing-other";
	public static final String CLAIM_OTHER_ENTRY_DELETE="doi/hba/claim-entry-delete-other";
	public static final String HBA_OTHER_CLAIM_LOSS_ENTRY="doi/hba/hba-claim-entry-loss-other";
	//TdoiSurveyorBillDtlDTO
	public static final String DOI_JPA_HBA_TDOISURVEYORBILLDTL_ENTRY ="/doi-jpa-hba-tdoisurveyorbilldtl-entry";
	public static final String DOI_JPA_HBA_TDOISURVEYORBILLDTL_LISTING ="/doi-jpa-hba-tdoisurveyorbilldtl-listing";
	public static final String DOI_JPA_HBA_TDOISURVEYORBILLDTL_LISTING_BY_STATUS ="/doi-jpa-hba-tdoisurveyorbilldtl-listing-by-status";
	public static final String DOI_JPA_HBA_TDOISURVEYORBILLDTL_DELETE ="/doi-jpa-hba-tdoisurveyorbilldtl-delete";
	//TdoiSurveyorBillWfDTO
	public static final String DOI_JPA_HBA_TDOISURVEYORBILLWF_ENTRY ="/doi-jpa-hba-tdoisurveyorbillwf-entry";
	public static final String DOI_JPA_HBA_TDOISURVEYORBILLWF_LISTING ="/doi-jpa-hba-tdoisurveyorbillwf-listing";
	public static final String DOI_JPA_HBA_TDOISURVEYORBILLWF_LISTING_BY_STATUS ="/doi-jpa-hba-tdoisurveyorbillwf-listing-by-status";
	public static final String DOI_JPA_HBA_TDOISURVEYORBILLWF_DELETE ="/doi-jpa-hba-tdoisurveyorbillwf-delete";
	//TdoiSurveyorDtlDTO
	/*
	public static final String DOI_JPA_HBA_TDOISURVEYORDTL_ENTRY ="/doi-jpa-hba-tdoisurveyordtl-entry";
	public static final String DOI_JPA_HBA_TDOISURVEYORDTL_LISTING ="/doi-jpa-hba-tdoisurveyordtl-listing";
	public static final String DOI_JPA_HBA_TDOISURVEYORDTL_LISTING_BY_STATUS ="/doi-jpa-hba-tdoisurveyordtl-listing-by-status";
	public static final String DOI_JPA_HBA_TDOISURVEYORDTL_DELETE ="/doi-jpa-hba-tdoisurveyordtl-delete";
*/

	//TdoiSurveyorDtlDTO
	public static final String DOI_HBA_SURVEYOR_MASTER_ENTRY ="doi/hba/surveyor-master-entry";
	public static final String DOI_HBA_SURVEYOR_MASTER_LISTING ="doi/hba/surveyor-master-listing";

	public static final String DOI_JPA_HBA_TDOISURVEYORDTL_LISTING_BY_STATUS ="/doi-jpa-hba-tdoisurveyordtl-listing-by-status";
	public static final String DOI_JPA_HBA_TDOISURVEYORDTL_DELETE ="/doi-jpa-hba-tdoisurveyordtl-delete";

	
	//Direct business
	public static final String DOI_JPA_DB_BASE_URL="doi/db";
	public static final String DOI_BASE_URL = "/doi";
	//MdoiDbFireSumInsrMstDTO
	public static final String DOI_DB_PARTY_TYPES ="doi/db-party-types";
	public static final String DOI_DB_OFFICE_TYPES ="doi/db-office-types";
	public static final String DOI_BANK_BRANCH_TYPES ="doi/bank-branch-types";
	public static final String DOI_PAYMENT_MODES ="doi/payment-modes";
	public static final String DOI_JPA_DB_MDOIDBFIRESUMINSRMST_ENTRY ="/doi-jpa-db-mdoidbfiresuminsrmst-entry";
	public static final String DOI_JPA_DB_MDOIDBFIRESUMINSRMST_LISTING ="/doi-jpa-db-mdoidbfiresuminsrmst-listing";
	public static final String DOI_JPA_DB_MDOIDBFIRESUMINSRMST_LISTING_BY_STATUS ="/doi-jpa-db-mdoidbfiresuminsrmst-listing-by-status";
	public static final String DOI_JPA_DB_MDOIDBFIRESUMINSRMST_DELETE ="/doi-jpa-db-mdoidbfiresuminsrmst-delete";
	//MdoiDbPartyBankDtlDTO
	public static final String DOI_JPA_DB_MDOIDBPARTYBANKDTL_ENTRY ="/doi-jpa-db-mdoidbpartybankdtl-entry";
	public static final String DOI_JPA_DB_MDOIDBPARTYBANKDTL_LISTING ="/doi-jpa-db-mdoidbpartybankdtl-listing";
	public static final String DOI_JPA_DB_MDOIDBPARTYBANKDTL_LISTING_BY_STATUS ="/doi-jpa-db-mdoidbpartybankdtl-listing-by-status";
	public static final String DOI_JPA_DB_MDOIDBPARTYBANKDTL_DELETE ="/doi-jpa-db-mdoidbpartybankdtl-delete";
	
	//MdoiDbPartyMstDTO
	public static final String DOI_PARTY_MASTER_ENTRY = "/party-master";
	public static final String DOI_PARTY_MASTER_LISTING = "/party-master-listing";
	public static final String DOI_PARTY_MASTER_DELETE = "/party-master-delete";
	public static final String DOI_PARTY_MASTER_LISTING_BY_STATUS = "/party-master-listing-by-status";
	public static final String ADD_AVIATION_POLICY = "/aviation-policy";
	//MdoiDbPartyOfficeDtlDTO
	public static final String DOI_JPA_DB_MDOIDBPARTYOFFICEDTL_ENTRY ="/doi-jpa-db-mdoidbpartyofficedtl-entry";
	public static final String DOI_JPA_DB_MDOIDBPARTYOFFICEDTL_LISTING ="/doi-jpa-db-mdoidbpartyofficedtl-listing";
	public static final String DOI_JPA_DB_MDOIDBPARTYOFFICEDTL_LISTING_BY_STATUS ="/doi-jpa-db-mdoidbpartyofficedtl-listing-by-status";
	public static final String DOI_JPA_DB_MDOIDBPARTYOFFICEDTL_DELETE ="/doi-jpa-db-mdoidbpartyofficedtl-delete";
	//TdoiDbClaimEntryDTO
	public static final String DOI_JPA_DB_CLAIMENTRY_ENTRY ="/doi-jpa-db-claimentry-entry";
	public static final String DOI_JPA_DB_CLAIMENTRY_LISTING ="/doi-jpa-db-claimentry-listing";
	public static final String DOI_JPA_DB_CLAIMENTRY_LISTING_BY_STATUS ="/doi-jpa-db-claimentry-listing-by-status";
	public static final String DOI_JPA_DB_CLAIMENTRY_DELETE ="/doi-jpa-db-claimentry-delete";
	//TdoiDbClaimPrevLossDTO
	public static final String DOI_JPA_DB_CLAIMPREVLOSS_ENTRY ="/doi-jpa-db-claimprevloss-entry";
	public static final String DOI_JPA_DB_CLAIMPREVLOSS_LISTING ="/doi-jpa-db-claimprevloss-listing";
	public static final String DOI_JPA_DB_CLAIMPREVLOSS_LISTING_BY_STATUS ="/doi-jpa-db-claimprevloss-listing-by-status";
	public static final String DOI_JPA_DB_CLAIMPREVLOSS_DELETE ="/doi-jpa-db-claimprevloss-delete";
	//TdoiDbClaimPropDtlDTO
	public static final String DOI_JPA_DB_CLAIMPROPDTL_ENTRY ="/doi-jpa-db-claimpropdtl-entry";
	public static final String DOI_JPA_DB_CLAIMPROPDTL_LISTING ="/doi-jpa-db-claimpropdtl-listing";
	public static final String DOI_JPA_DB_CLAIMPROPDTL_LISTING_BY_STATUS ="/doi-jpa-db-claimpropdtl-listing-by-status";
	public static final String DOI_JPA_DB_CLAIMPROPDTL_DELETE ="/doi-jpa-db-claimpropdtl-delete";
	//TdoiDbClaimQueryDTO
	public static final String DOI_JPA_DB_CLAIMQUERY_ENTRY ="/doi-jpa-db-claimquery-entry";
	public static final String DOI_JPA_DB_CLAIMQUERY_LISTING ="/doi-jpa-db-claimquery-listing";
	public static final String DOI_JPA_DB_CLAIMQUERY_LISTING_BY_STATUS ="/doi-jpa-db-claimquery-listing-by-status";
	public static final String DOI_JPA_DB_CLAIMQUERY_DELETE ="/doi-jpa-db-claimquery-delete";
	//TdoiDbClaimRiDtlDTO
	public static final String DOI_JPA_DB_CLAIMRIDTL_ENTRY ="/doi-jpa-db-claimridtl-entry";
	public static final String DOI_JPA_DB_CLAIMRIDTL_LISTING ="/doi-jpa-db-claimridtl-listing";
	public static final String DOI_JPA_DB_CLAIMRIDTL_LISTING_BY_STATUS ="/doi-jpa-db-claimridtl-listing-by-status";
	public static final String DOI_JPA_DB_CLAIMRIDTL_DELETE ="/doi-jpa-db-claimridtl-delete";
	//TdoiDbClaimWfDTO
	public static final String DOI_JPA_DB_CLAIMWF_ENTRY ="/doi-jpa-db-claimwf-entry";
	public static final String DOI_JPA_DB_CLAIMWF_LISTING ="/doi-jpa-db-claimwf-listing";
	public static final String DOI_JPA_DB_CLAIMWF_LISTING_BY_STATUS ="/doi-jpa-db-claimwf-listing-by-status";
	public static final String DOI_JPA_DB_CLAIMWF_DELETE ="/doi-jpa-db-claimwf-delete";
	//TdoiDbFireBuildingValDTO
	public static final String DOI_JPA_DB_FIREBUILDINGVAL_ENTRY ="/doi-jpa-db-firebuildingval-entry";
	public static final String DOI_JPA_DB_FIREBUILDINGVAL_LISTING ="/doi-jpa-db-firebuildingval-listing";
	public static final String DOI_JPA_DB_FIREBUILDINGVAL_LISTING_BY_STATUS ="/doi-jpa-db-firebuildingval-listing-by-status";
	public static final String DOI_JPA_DB_FIREBUILDINGVAL_DELETE ="/doi-jpa-db-firebuildingval-delete";
	//TdoiDbFirePastPolicyDTO
	public static final String DOI_JPA_DB_FIREPASTPOLICY_ENTRY ="/doi-jpa-db-firepastpolicy-entry";
	public static final String DOI_JPA_DB_FIREPASTPOLICY_LISTING ="/doi-jpa-db-firepastpolicy-listing";
	public static final String DOI_JPA_DB_FIREPASTPOLICY_LISTING_BY_STATUS ="/doi-jpa-db-firepastpolicy-listing-by-status";
	public static final String DOI_JPA_DB_FIREPASTPOLICY_DELETE ="/doi-jpa-db-firepastpolicy-delete";
	//TdoiDbFireRiskLocDTO
	public static final String DOI_JPA_DB_FIRERISKLOC_ENTRY ="/doi-jpa-db-fireriskloc-entry";
	public static final String DOI_JPA_DB_FIRERISKLOC_LISTING ="/doi-jpa-db-fireriskloc-listing";
	public static final String DOI_JPA_DB_FIRERISKLOC_LISTING_BY_STATUS ="/doi-jpa-db-fireriskloc-listing-by-status";
	public static final String DOI_JPA_DB_FIRERISKLOC_DELETE ="/doi-jpa-db-fireriskloc-delete";
	//TdoiDbFireSumInsuredDTO
	public static final String DOI_JPA_DB_FIRESUMINSURED_ENTRY ="/doi-jpa-db-firesuminsured-entry";
	public static final String DOI_JPA_DB_FIRESUMINSURED_LISTING ="/doi-jpa-db-firesuminsured-listing";
	public static final String DOI_JPA_DB_FIRESUMINSURED_LISTING_BY_STATUS ="/doi-jpa-db-firesuminsured-listing-by-status";
	public static final String DOI_JPA_DB_FIRESUMINSURED_DELETE ="/doi-jpa-db-firesuminsured-delete";
	//TdoiDbPolAviationAircraftDTO
	public static final String DOI_JPA_DB_POLAVIATIONAIRCRAFT_ENTRY ="/doi-jpa-db-polaviationaircraft-entry";
	public static final String DOI_JPA_DB_POLAVIATIONAIRCRAFT_LISTING ="/doi-jpa-db-polaviationaircraft-listing";
	public static final String DOI_JPA_DB_POLAVIATIONAIRCRAFT_LISTING_BY_STATUS ="/doi-jpa-db-polaviationaircraft-listing-by-status";
	public static final String DOI_JPA_DB_POLAVIATIONAIRCRAFT_DELETE ="/doi-jpa-db-polaviationaircraft-delete";
	//TdoiDbPolAviationDTO
	public static final String DOI_JPA_DB_POLAVIATION_ENTRY ="/doi-jpa-db-polaviation-entry";
	public static final String DOI_JPA_DB_POLAVIATION_LISTING ="/doi-jpa-db-polaviation-listing";
	public static final String DOI_JPA_DB_POLAVIATION_LISTING_BY_STATUS ="/doi-jpa-db-polaviation-listing-by-status";
	public static final String DOI_JPA_DB_POLAVIATION_DELETE ="/doi-jpa-db-polaviation-delete";
	//TdoiDbPolAviationRiDtlDTO
	public static final String DOI_JPA_DB_POLAVIATIONRIDTL_ENTRY ="/doi-jpa-db-polaviationridtl-entry";
	public static final String DOI_JPA_DB_POLAVIATIONRIDTL_LISTING ="/doi-jpa-db-polaviationridtl-listing";
	public static final String DOI_JPA_DB_POLAVIATIONRIDTL_LISTING_BY_STATUS ="/doi-jpa-db-polaviationridtl-listing-by-status";
	public static final String DOI_JPA_DB_POLAVIATIONRIDTL_DELETE ="/doi-jpa-db-polaviationridtl-delete";
	//TdoiDbPolAviationWfDTO
	public static final String DOI_JPA_DB_POLAVIATIONWF_ENTRY ="/doi-jpa-db-polaviationwf-entry";
	public static final String DOI_JPA_DB_POLAVIATIONWF_LISTING ="/doi-jpa-db-polaviationwf-listing";
	public static final String DOI_JPA_DB_POLAVIATIONWF_LISTING_BY_STATUS ="/doi-jpa-db-polaviationwf-listing-by-status";
	public static final String DOI_JPA_DB_POLAVIATIONWF_DELETE ="/doi-jpa-db-polaviationwf-delete";
	//TdoiDbPolBuglrRiDtlDTO
	public static final String DOI_JPA_DB_POLBUGLRRIDTL_ENTRY ="/doi-jpa-db-polbuglrridtl-entry";
	public static final String DOI_JPA_DB_POLBUGLRRIDTL_LISTING ="/doi-jpa-db-polbuglrridtl-listing";
	public static final String DOI_JPA_DB_POLBUGLRRIDTL_LISTING_BY_STATUS ="/doi-jpa-db-polbuglrridtl-listing-by-status";
	public static final String DOI_JPA_DB_POLBUGLRRIDTL_DELETE ="/doi-jpa-db-polbuglrridtl-delete";
	//TdoiDbPolBurglaryDTO
	public static final String DOI_JPA_DB_POLBURGLARY_ENTRY ="/doi-jpa-db-polburglary-entry";
	public static final String DOI_JPA_DB_POLBURGLARY_LISTING ="/doi-jpa-db-polburglary-listing";
	public static final String DOI_JPA_DB_POLBURGLARY_LISTING_BY_STATUS ="/doi-jpa-db-polburglary-listing-by-status";
	public static final String DOI_JPA_DB_POLBURGLARY_DELETE ="/doi-jpa-db-polburglary-delete";
	//TdoiDbPolBurglaryWfDTO
	public static final String DOI_JPA_DB_POLBURGLARYWF_ENTRY ="/doi-jpa-db-polburglarywf-entry";
	public static final String DOI_JPA_DB_POLBURGLARYWF_LISTING ="/doi-jpa-db-polburglarywf-listing";
	public static final String DOI_JPA_DB_POLBURGLARYWF_LISTING_BY_STATUS ="/doi-jpa-db-polburglarywf-listing-by-status";
	public static final String DOI_JPA_DB_POLBURGLARYWF_DELETE ="/doi-jpa-db-polburglarywf-delete";
	//TdoiDbPolElecEquipDTO
	public static final String DOI_JPA_DB_POLELECEQUIP_ENTRY ="/doi-jpa-db-polelecequip-entry";
	public static final String DOI_JPA_DB_POLELECEQUIP_LISTING ="/doi-jpa-db-polelecequip-listing";
	public static final String DOI_JPA_DB_POLELECEQUIP_LISTING_BY_STATUS ="/doi-jpa-db-polelecequip-listing-by-status";
	public static final String DOI_JPA_DB_POLELECEQUIP_DELETE ="/doi-jpa-db-polelecequip-delete";
	//TdoiDbPolElecWfDTO
	public static final String DOI_JPA_DB_POLELECWF_ENTRY ="/doi-jpa-db-polelecwf-entry";
	public static final String DOI_JPA_DB_POLELECWF_LISTING ="/doi-jpa-db-polelecwf-listing";
	public static final String DOI_JPA_DB_POLELECWF_LISTING_BY_STATUS ="/doi-jpa-db-polelecwf-listing-by-status";
	public static final String DOI_JPA_DB_POLELECWF_DELETE ="/doi-jpa-db-polelecwf-delete";
	//TdoiDbPolEquipDtlDTO
	public static final String DOI_JPA_DB_POLEQUIPDTL_ENTRY ="/doi-jpa-db-polequipdtl-entry";
	public static final String DOI_JPA_DB_POLEQUIPDTL_LISTING ="/doi-jpa-db-polequipdtl-listing";
	public static final String DOI_JPA_DB_POLEQUIPDTL_LISTING_BY_STATUS ="/doi-jpa-db-polequipdtl-listing-by-status";
	public static final String DOI_JPA_DB_POLEQUIPDTL_DELETE ="/doi-jpa-db-polequipdtl-delete";
	//TdoiDbPolFireBuildingValDTO
	public static final String DOI_JPA_DB_POLFIREBUILDINGVAL_ENTRY ="/doi-jpa-db-polfirebuildingval-entry";
	public static final String DOI_JPA_DB_POLFIREBUILDINGVAL_LISTING ="/doi-jpa-db-polfirebuildingval-listing";
	public static final String DOI_JPA_DB_POLFIREBUILDINGVAL_LISTING_BY_STATUS ="/doi-jpa-db-polfirebuildingval-listing-by-status";
	public static final String DOI_JPA_DB_POLFIREBUILDINGVAL_DELETE ="/doi-jpa-db-polfirebuildingval-delete";
	//TdoiDbPolFirePastPolicyDTO
	public static final String DOI_JPA_DB_POLFIREPASTPOLICY_ENTRY ="/doi-jpa-db-polfirepastpolicy-entry";
	public static final String DOI_JPA_DB_POLFIREPASTPOLICY_LISTING ="/doi-jpa-db-polfirepastpolicy-listing";
	public static final String DOI_JPA_DB_POLFIREPASTPOLICY_LISTING_BY_STATUS ="/doi-jpa-db-polfirepastpolicy-listing-by-status";
	public static final String DOI_JPA_DB_POLFIREPASTPOLICY_DELETE ="/doi-jpa-db-polfirepastpolicy-delete";
	//TdoiDbPolFirePerilDTO
	public static final String DOI_JPA_DB_POLFIREPERIL_ENTRY ="/doi-jpa-db-polfireperil-entry";
	public static final String DOI_JPA_DB_POLFIREPERIL_LISTING ="/doi-jpa-db-polfireperil-listing";
	public static final String DOI_JPA_DB_POLFIREPERIL_LISTING_BY_STATUS ="/doi-jpa-db-polfireperil-listing-by-status";
	public static final String DOI_JPA_DB_POLFIREPERIL_DELETE ="/doi-jpa-db-polfireperil-delete";
	//TdoiDbPolFireRiDtlDTO
	public static final String DOI_JPA_DB_POLFIRERIDTL_ENTRY ="/doi-jpa-db-polfireridtl-entry";
	public static final String DOI_JPA_DB_POLFIRERIDTL_LISTING ="/doi-jpa-db-polfireridtl-listing";
	public static final String DOI_JPA_DB_POLFIRERIDTL_LISTING_BY_STATUS ="/doi-jpa-db-polfireridtl-listing-by-status";
	public static final String DOI_JPA_DB_POLFIRERIDTL_DELETE ="/doi-jpa-db-polfireridtl-delete";
	//TdoiDbPolFireSumInsuredDTO
	public static final String DOI_JPA_DB_POLFIRESUMINSURED_ENTRY ="/doi-jpa-db-polfiresuminsured-entry";
	public static final String DOI_JPA_DB_POLFIRESUMINSURED_LISTING ="/doi-jpa-db-polfiresuminsured-listing";
	public static final String DOI_JPA_DB_POLFIRESUMINSURED_LISTING_BY_STATUS ="/doi-jpa-db-polfiresuminsured-listing-by-status";
	public static final String DOI_JPA_DB_POLFIRESUMINSURED_DELETE ="/doi-jpa-db-polfiresuminsured-delete";
	//TdoiDbPolFireWfDTO
	public static final String DOI_JPA_DB_POLFIREWF_ENTRY ="/doi-jpa-db-polfirewf-entry";
	public static final String DOI_JPA_DB_POLFIREWF_LISTING ="/doi-jpa-db-polfirewf-listing";
	public static final String DOI_JPA_DB_POLFIREWF_LISTING_BY_STATUS ="/doi-jpa-db-polfirewf-listing-by-status";
	public static final String DOI_JPA_DB_POLFIREWF_DELETE ="/doi-jpa-db-polfirewf-delete";
	//TdoiDbPolicyListDTO
	public static final String DOI_JPA_DB_POLICYLIST_ENTRY ="/doi-jpa-db-policylist-entry";
	public static final String DOI_JPA_DB_POLICYLIST_LISTING ="/doi-jpa-db-policylist-listing";
	public static final String DOI_JPA_DB_POLICYLIST_LISTING_BY_STATUS ="/doi-jpa-db-policylist-listing-by-status";
	public static final String DOI_JPA_DB_POLICYLIST_DELETE ="/doi-jpa-db-policylist-delete";
	public static final String TDOI_DB_POLICY_LISTING = "/policy-master-listing";
	public static final String TDOI_DB_ADD_CLAIM = "/claim-entry";
	public static final String TDOI_DB_FETCH_CLAIMS = "/claim-entry-listing";
	//TdoiDbPolMitInsuranceDTO
	public static final String DOI_JPA_DB_POLMITINSURANCE_ENTRY ="/doi-jpa-db-polmitinsurance-entry";
	public static final String DOI_JPA_DB_POLMITINSURANCE_LISTING ="/doi-jpa-db-polmitinsurance-listing";
	public static final String DOI_JPA_DB_POLMITINSURANCE_LISTING_BY_STATUS ="/doi-jpa-db-polmitinsurance-listing-by-status";
	public static final String DOI_JPA_DB_POLMITINSURANCE_DELETE ="/doi-jpa-db-polmitinsurance-delete";
	//TdoiDbPolMitRiDtlDTO
	public static final String DOI_JPA_DB_POLMITRIDTL_ENTRY ="/doi-jpa-db-polmitridtl-entry";
	public static final String DOI_JPA_DB_POLMITRIDTL_LISTING ="/doi-jpa-db-polmitridtl-listing";
	public static final String DOI_JPA_DB_POLMITRIDTL_LISTING_BY_STATUS ="/doi-jpa-db-polmitridtl-listing-by-status";
	public static final String DOI_JPA_DB_POLMITRIDTL_DELETE ="/doi-jpa-db-polmitridtl-delete";
	//TdoiDbPolMitWfDTO
	public static final String DOI_JPA_DB_POLMITWF_ENTRY ="/doi-jpa-db-polmitwf-entry";
	public static final String DOI_JPA_DB_POLMITWF_LISTING ="/doi-jpa-db-polmitwf-listing";
	public static final String DOI_JPA_DB_POLMITWF_LISTING_BY_STATUS ="/doi-jpa-db-polmitwf-listing-by-status";
	public static final String DOI_JPA_DB_POLMITWF_DELETE ="/doi-jpa-db-polmitwf-delete";
	//TdoiDbPolMoneyIntransitDTO
	public static final String DOI_JPA_DB_POLMONEYINTRANSIT_ENTRY ="/doi-jpa-db-polmoneyintransit-entry";
	public static final String DOI_JPA_DB_POLMONEYINTRANSIT_LISTING ="/doi-jpa-db-polmoneyintransit-listing";
	public static final String DOI_JPA_DB_POLMONEYINTRANSIT_LISTING_BY_STATUS ="/doi-jpa-db-polmoneyintransit-listing-by-status";
	public static final String DOI_JPA_DB_POLMONEYINTRANSIT_DELETE ="/doi-jpa-db-polmoneyintransit-delete";
	//TdoiDbPropAviationAircraftDTO
	public static final String DOI_JPA_DB_PROPAVIATIONAIRCRAFT_ENTRY ="/doi-jpa-db-propaviationaircraft-entry";
	public static final String DOI_JPA_DB_PROPAVIATIONAIRCRAFT_LISTING ="/doi-jpa-db-propaviationaircraft-listing";
	public static final String DOI_JPA_DB_PROPAVIATIONAIRCRAFT_LISTING_BY_STATUS ="/doi-jpa-db-propaviationaircraft-listing-by-status";
	public static final String DOI_JPA_DB_PROPAVIATIONAIRCRAFT_DELETE ="/doi-jpa-db-propaviationaircraft-delete";
	//TdoiDbPropAviationRiDtlDTO
	public static final String DOI_JPA_DB_PROPAVIATIONRIDTL_ENTRY ="/doi-jpa-db-propaviationridtl-entry";
	public static final String DOI_JPA_DB_PROPAVIATIONRIDTL_LISTING ="/doi-jpa-db-propaviationridtl-listing";
	public static final String DOI_JPA_DB_PROPAVIATIONRIDTL_LISTING_BY_STATUS ="/doi-jpa-db-propaviationridtl-listing-by-status";
	public static final String DOI_JPA_DB_PROPAVIATIONRIDTL_DELETE ="/doi-jpa-db-propaviationridtl-delete";
	//TdoiDbPropBuglrRiDtlDTO
	public static final String DOI_JPA_DB_PROPBUGLRRIDTL_ENTRY ="/doi-jpa-db-propbuglrridtl-entry";
	public static final String DOI_JPA_DB_PROPBUGLRRIDTL_LISTING ="/doi-jpa-db-propbuglrridtl-listing";
	public static final String DOI_JPA_DB_PROPBUGLRRIDTL_LISTING_BY_STATUS ="/doi-jpa-db-propbuglrridtl-listing-by-status";
	public static final String DOI_JPA_DB_PROPBUGLRRIDTL_DELETE ="/doi-jpa-db-propbuglrridtl-delete";
	//TdoiDbPropElecRiDtlDTO
	public static final String DOI_JPA_DB_PROPELECRIDTL_ENTRY ="/doi-jpa-db-propelecridtl-entry";
	public static final String DOI_JPA_DB_PROPELECRIDTL_LISTING ="/doi-jpa-db-propelecridtl-listing";
	public static final String DOI_JPA_DB_PROPELECRIDTL_LISTING_BY_STATUS ="/doi-jpa-db-propelecridtl-listing-by-status";
	public static final String DOI_JPA_DB_PROPELECRIDTL_DELETE ="/doi-jpa-db-propelecridtl-delete";
	//TdoiDbPropFireRiDtlDTO
	public static final String DOI_JPA_DB_PROPFIRERIDTL_ENTRY ="/doi-jpa-db-propfireridtl-entry";
	public static final String DOI_JPA_DB_PROPFIRERIDTL_LISTING ="/doi-jpa-db-propfireridtl-listing";
	public static final String DOI_JPA_DB_PROPFIRERIDTL_LISTING_BY_STATUS ="/doi-jpa-db-propfireridtl-listing-by-status";
	public static final String DOI_JPA_DB_PROPFIRERIDTL_DELETE ="/doi-jpa-db-propfireridtl-delete";
	//TdoiDbPropMitInsuranceDTO
	public static final String DOI_JPA_DB_PROPMITINSURANCE_ENTRY ="/doi-jpa-db-propmitinsurance-entry";
	public static final String DOI_JPA_DB_PROPMITINSURANCE_LISTING ="/doi-jpa-db-propmitinsurance-listing";
	public static final String DOI_JPA_DB_PROPMITINSURANCE_LISTING_BY_STATUS ="/doi-jpa-db-propmitinsurance-listing-by-status";
	public static final String DOI_JPA_DB_PROPMITINSURANCE_DELETE ="/doi-jpa-db-propmitinsurance-delete";
	//TdoiDbPropMitRiDtlDTO
	public static final String DOI_JPA_DB_PROPMITRIDTL_ENTRY ="/doi-jpa-db-propmitridtl-entry";
	public static final String DOI_JPA_DB_PROPMITRIDTL_LISTING ="/doi-jpa-db-propmitridtl-listing";
	public static final String DOI_JPA_DB_PROPMITRIDTL_LISTING_BY_STATUS ="/doi-jpa-db-propmitridtl-listing-by-status";
	public static final String DOI_JPA_DB_PROPMITRIDTL_DELETE ="/doi-jpa-db-propmitridtl-delete";
	//TdoiDbPropMitWfDTO
	public static final String DOI_JPA_DB_PROPMITWF_ENTRY ="/doi-jpa-db-propmitwf-entry";
	public static final String DOI_JPA_DB_PROPMITWF_LISTING ="/doi-jpa-db-propmitwf-listing";
	public static final String DOI_JPA_DB_PROPMITWF_LISTING_BY_STATUS ="/doi-jpa-db-propmitwf-listing-by-status";
	public static final String DOI_JPA_DB_PROPMITWF_DELETE ="/doi-jpa-db-propmitwf-delete";
	//TdoiDbPropMoneyIntransitDTO
	public static final String DOI_JPA_DB_PROPMONEYINTRANSIT_ENTRY ="/doi-jpa-db-propmoneyintransit-entry";
	public static final String DOI_JPA_DB_PROPMONEYINTRANSIT_LISTING ="/doi-jpa-db-propmoneyintransit-listing";
	public static final String DOI_JPA_DB_PROPMONEYINTRANSIT_LISTING_BY_STATUS ="/doi-jpa-db-propmoneyintransit-listing-by-status";
	public static final String DOI_JPA_DB_PROPMONEYINTRANSIT_DELETE ="/doi-jpa-db-propmoneyintransit-delete";
	//TdoiDbProposalDTO
	public static final String DOI_JPA_DB_PROPOSAL_ENTRY ="/doi-jpa-db-proposal-entry";
	public static final String DOI_JPA_DB_PROPOSAL_LISTING ="/doi-jpa-db-proposal-listing";
	public static final String DOI_JPA_DB_PROPOSAL_LISTING_BY_STATUS ="/doi-jpa-db-proposal-listing-by-status";
	public static final String DOI_JPA_DB_PROPOSAL_DELETE ="/doi-jpa-db-proposal-delete";
	//TdoiDbProposlWfDTO
	public static final String DOI_JPA_DB_PROPOSLWF_ENTRY ="/doi-jpa-db-proposlwf-entry";
	public static final String DOI_JPA_DB_PROPOSLWF_LISTING ="/doi-jpa-db-proposlwf-listing";
	public static final String DOI_JPA_DB_PROPOSLWF_LISTING_BY_STATUS ="/doi-jpa-db-proposlwf-listing-by-status";
	public static final String DOI_JPA_DB_PROPOSLWF_DELETE ="/doi-jpa-db-proposlwf-delete";
	//TdoiDbPropslAviationDTO
	public static final String DOI_JPA_DB_PROPSLAVIATION_ENTRY ="/doi-jpa-db-propslaviation-entry";
	public static final String DOI_JPA_DB_PROPSLAVIATION_LISTING ="/doi-jpa-db-propslaviation-listing";
	public static final String DOI_JPA_DB_PROPSLAVIATION_LISTING_BY_STATUS ="/doi-jpa-db-propslaviation-listing-by-status";
	public static final String DOI_JPA_DB_PROPSLAVIATION_DELETE ="/doi-jpa-db-propslaviation-delete";
	//TdoiDbPropslAviationWfDTO
	public static final String DOI_JPA_DB_PROPSLAVIATIONWF_ENTRY ="/doi-jpa-db-propslaviationwf-entry";
	public static final String DOI_JPA_DB_PROPSLAVIATIONWF_LISTING ="/doi-jpa-db-propslaviationwf-listing";
	public static final String DOI_JPA_DB_PROPSLAVIATIONWF_LISTING_BY_STATUS ="/doi-jpa-db-propslaviationwf-listing-by-status";
	public static final String DOI_JPA_DB_PROPSLAVIATIONWF_DELETE ="/doi-jpa-db-propslaviationwf-delete";
	//TdoiDbPropslBurglaryDTO
	public static final String DOI_JPA_DB_PROPSLBURGLARY_ENTRY ="/doi-jpa-db-propslburglary-entry";
	public static final String DOI_JPA_DB_PROPSLBURGLARY_LISTING ="/doi-jpa-db-propslburglary-listing";
	public static final String DOI_JPA_DB_PROPSLBURGLARY_LISTING_BY_STATUS ="/doi-jpa-db-propslburglary-listing-by-status";
	public static final String DOI_JPA_DB_PROPSLBURGLARY_DELETE ="/doi-jpa-db-propslburglary-delete";
	//TdoiDbPropslBurglaryWfDTO
	public static final String DOI_JPA_DB_PROPSLBURGLARYWF_ENTRY ="/doi-jpa-db-propslburglarywf-entry";
	public static final String DOI_JPA_DB_PROPSLBURGLARYWF_LISTING ="/doi-jpa-db-propslburglarywf-listing";
	public static final String DOI_JPA_DB_PROPSLBURGLARYWF_LISTING_BY_STATUS ="/doi-jpa-db-propslburglarywf-listing-by-status";
	public static final String DOI_JPA_DB_PROPSLBURGLARYWF_DELETE ="/doi-jpa-db-propslburglarywf-delete";
	//TdoiDbPropslElecEquipDTO
	public static final String DOI_JPA_DB_PROPSLELECEQUIP_ENTRY ="/doi-jpa-db-propslelecequip-entry";
	public static final String DOI_JPA_DB_PROPSLELECEQUIP_LISTING ="/doi-jpa-db-propslelecequip-listing";
	public static final String DOI_JPA_DB_PROPSLELECEQUIP_LISTING_BY_STATUS ="/doi-jpa-db-propslelecequip-listing-by-status";
	public static final String DOI_JPA_DB_PROPSLELECEQUIP_DELETE ="/doi-jpa-db-propslelecequip-delete";
	//TdoiDbPropslElecWfDTO
	public static final String DOI_JPA_DB_PROPSLELECWF_ENTRY ="/doi-jpa-db-propslelecwf-entry";
	public static final String DOI_JPA_DB_PROPSLELECWF_LISTING ="/doi-jpa-db-propslelecwf-listing";
	public static final String DOI_JPA_DB_PROPSLELECWF_LISTING_BY_STATUS ="/doi-jpa-db-propslelecwf-listing-by-status";
	public static final String DOI_JPA_DB_PROPSLELECWF_DELETE ="/doi-jpa-db-propslelecwf-delete";
	//TdoiDbPropslEquipDtlDTO
	public static final String DOI_JPA_DB_PROPSLEQUIPDTL_ENTRY ="/doi-jpa-db-propslequipdtl-entry";
	public static final String DOI_JPA_DB_PROPSLEQUIPDTL_LISTING ="/doi-jpa-db-propslequipdtl-listing";
	public static final String DOI_JPA_DB_PROPSLEQUIPDTL_LISTING_BY_STATUS ="/doi-jpa-db-propslequipdtl-listing-by-status";
	public static final String DOI_JPA_DB_PROPSLEQUIPDTL_DELETE ="/doi-jpa-db-propslequipdtl-delete";
	//TdoiDbPropslFirePerilDTO
	public static final String DOI_JPA_DB_PROPSLFIREPERIL_ENTRY ="/doi-jpa-db-propslfireperil-entry";
	public static final String DOI_JPA_DB_PROPSLFIREPERIL_LISTING ="/doi-jpa-db-propslfireperil-listing";
	public static final String DOI_JPA_DB_PROPSLFIREPERIL_LISTING_BY_STATUS ="/doi-jpa-db-propslfireperil-listing-by-status";
	public static final String DOI_JPA_DB_PROPSLFIREPERIL_DELETE ="/doi-jpa-db-propslfireperil-delete";
	//TdoiDbPropslFireWfDTO
	public static final String DOI_JPA_DB_PROPSLFIREWF_ENTRY ="/doi-jpa-db-propslfirewf-entry";
	public static final String DOI_JPA_DB_PROPSLFIREWF_LISTING ="/doi-jpa-db-propslfirewf-listing";
	public static final String DOI_JPA_DB_PROPSLFIREWF_LISTING_BY_STATUS ="/doi-jpa-db-propslfirewf-listing-by-status";
	public static final String DOI_JPA_DB_PROPSLFIREWF_DELETE ="/doi-jpa-db-propslfirewf-delete";
	//TdoiDbPropslPolAddonDTO
	public static final String DOI_JPA_DB_PROPSLPOLADDON_ENTRY ="/doi-jpa-db-propslpoladdon-entry";
	public static final String DOI_JPA_DB_PROPSLPOLADDON_LISTING ="/doi-jpa-db-propslpoladdon-listing";
	public static final String DOI_JPA_DB_PROPSLPOLADDON_LISTING_BY_STATUS ="/doi-jpa-db-propslpoladdon-listing-by-status";
	public static final String DOI_JPA_DB_PROPSLPOLADDON_DELETE ="/doi-jpa-db-propslpoladdon-delete";
	//TdoiDbPropslPolicyDTO
	public static final String DOI_JPA_DB_PROPSLPOLICY_ENTRY ="/doi-jpa-db-propslpolicy-entry";
	public static final String DOI_JPA_DB_PROPSLPOLICY_LISTING ="/doi-jpa-db-propslpolicy-listing";
	public static final String DOI_JPA_DB_PROPSLPOLICY_LISTING_BY_STATUS ="/doi-jpa-db-propslpolicy-listing-by-status";
	public static final String DOI_JPA_DB_PROPSLPOLICY_DELETE ="/doi-jpa-db-propslpolicy-delete";

	//Account Commercial 
	public static final String DOI_JPA_AC_BASE_URL="doi/ac";
	//TdoiAcBtr5DTO
	public static final String DOI_JPA_AC_TDOIACBTR5_ENTRY ="/doi-jpa-ac-tdoiacbtr5-entry";
	public static final String DOI_JPA_AC_TDOIACBTR5_LISTING ="/doi-jpa-ac-tdoiacbtr5-listing";
	public static final String DOI_JPA_AC_TDOIACBTR5_LISTING_BY_STATUS ="/doi-jpa-ac-tdoiacbtr5-listing-by-status";
	public static final String DOI_JPA_AC_TDOIACBTR5_DELETE ="/doi-jpa-ac-tdoiacbtr5-delete";
	//TdoiAcCashbookPaymentDTO
	public static final String DOI_JPA_AC_TDOIACCASHBOOKPAYMENT_ENTRY ="/doi-jpa-ac-tdoiaccashbookpayment-entry";
	public static final String DOI_JPA_AC_TDOIACCASHBOOKPAYMENT_LISTING ="/doi-jpa-ac-tdoiaccashbookpayment-listing";
	public static final String DOI_JPA_AC_TDOIACCASHBOOKPAYMENT_LISTING_BY_STATUS ="/doi-jpa-ac-tdoiaccashbookpayment-listing-by-status";
	public static final String DOI_JPA_AC_TDOIACCASHBOOKPAYMENT_DELETE ="/doi-jpa-ac-tdoiaccashbookpayment-delete";
	//TdoiAcCashbookReceiptDTO
	public static final String DOI_JPA_AC_TDOIACCASHBOOKRECEIPT_ENTRY ="/doi-jpa-ac-tdoiaccashbookreceipt-entry";
	public static final String DOI_JPA_AC_TDOIACCASHBOOKRECEIPT_LISTING ="/doi-jpa-ac-tdoiaccashbookreceipt-listing";
	public static final String DOI_JPA_AC_TDOIACCASHBOOKRECEIPT_LISTING_BY_STATUS ="/doi-jpa-ac-tdoiaccashbookreceipt-listing-by-status";
	public static final String DOI_JPA_AC_TDOIACCASHBOOKRECEIPT_DELETE ="/doi-jpa-ac-tdoiaccashbookreceipt-delete";
	//TdoiAcChallanDtlDTO
	public static final String DOI_JPA_AC_TDOIACCHALLANDTL_ENTRY ="/doi-jpa-ac-tdoiacchallandtl-entry";
	public static final String DOI_JPA_AC_TDOIACCHALLANDTL_LISTING ="/doi-jpa-ac-tdoiacchallandtl-listing";
	public static final String DOI_JPA_AC_TDOIACCHALLANDTL_LISTING_BY_STATUS ="/doi-jpa-ac-tdoiacchallandtl-listing-by-status";
	public static final String DOI_JPA_AC_TDOIACCHALLANDTL_DELETE ="/doi-jpa-ac-tdoiacchallandtl-delete";
	//TdoiAcChallanRegisterDTO
	public static final String DOI_JPA_AC_TDOIACCHALLANREGISTER_ENTRY ="/doi-jpa-ac-tdoiacchallanregister-entry";
	public static final String DOI_JPA_AC_TDOIACCHALLANREGISTER_LISTING ="/doi-jpa-ac-tdoiacchallanregister-listing";
	public static final String DOI_JPA_AC_TDOIACCHALLANREGISTER_LISTING_BY_STATUS ="/doi-jpa-ac-tdoiacchallanregister-listing-by-status";
	public static final String DOI_JPA_AC_TDOIACCHALLANREGISTER_DELETE ="/doi-jpa-ac-tdoiacchallanregister-delete";
	//TdoiAcChequeRegisterDTO
	public static final String DOI_JPA_AC_TDOIACCHEQUEREGISTER_ENTRY ="/doi-jpa-ac-tdoiacchequeregister-entry";
	public static final String DOI_JPA_AC_TDOIACCHEQUEREGISTER_LISTING ="/doi-jpa-ac-tdoiacchequeregister-listing";
	public static final String DOI_JPA_AC_TDOIACCHEQUEREGISTER_LISTING_BY_STATUS ="/doi-jpa-ac-tdoiacchequeregister-listing-by-status";
	public static final String DOI_JPA_AC_TDOIACCHEQUEREGISTER_DELETE ="/doi-jpa-ac-tdoiacchequeregister-delete";
	//TdoiAcDeadStockRegisterDTO
	public static final String DOI_JPA_AC_TDOIACDEADSTOCKREGISTER_ENTRY ="/doi-jpa-ac-tdoiacdeadstockregister-entry";
	public static final String DOI_JPA_AC_TDOIACDEADSTOCKREGISTER_LISTING ="/doi-jpa-ac-tdoiacdeadstockregister-listing";
	public static final String DOI_JPA_AC_TDOIACDEADSTOCKREGISTER_LISTING_BY_STATUS ="/doi-jpa-ac-tdoiacdeadstockregister-listing-by-status";
	public static final String DOI_JPA_AC_TDOIACDEADSTOCKREGISTER_DELETE ="/doi-jpa-ac-tdoiacdeadstockregister-delete";
	//TdoiAcExpenditureRepDTO
	public static final String DOI_JPA_AC_TDOIACEXPENDITUREREP_ENTRY ="/doi-jpa-ac-tdoiacexpenditurerep-entry";
	public static final String DOI_JPA_AC_TDOIACEXPENDITUREREP_LISTING ="/doi-jpa-ac-tdoiacexpenditurerep-listing";
	public static final String DOI_JPA_AC_TDOIACEXPENDITUREREP_LISTING_BY_STATUS ="/doi-jpa-ac-tdoiacexpenditurerep-listing-by-status";
	public static final String DOI_JPA_AC_TDOIACEXPENDITUREREP_DELETE ="/doi-jpa-ac-tdoiacexpenditurerep-delete";
	//TdoiAcStampRegisterDTO
	public static final String DOI_JPA_AC_TDOIACSTAMPREGISTER_ENTRY ="/doi-jpa-ac-tdoiacstampregister-entry";
	public static final String DOI_JPA_AC_TDOIACSTAMPREGISTER_LISTING ="/doi-jpa-ac-tdoiacstampregister-listing";
	public static final String DOI_JPA_AC_TDOIACSTAMPREGISTER_LISTING_BY_STATUS ="/doi-jpa-ac-tdoiacstampregister-listing-by-status";
	public static final String DOI_JPA_AC_TDOIACSTAMPREGISTER_DELETE ="/doi-jpa-ac-tdoiacstampregister-delete";
	//TdoiAcTeExpenditureDtlDTO
	public static final String DOI_JPA_AC_TDOIACTEEXPENDITUREDTL_ENTRY ="/doi-jpa-ac-tdoiacteexpendituredtl-entry";
	public static final String DOI_JPA_AC_TDOIACTEEXPENDITUREDTL_LISTING ="/doi-jpa-ac-tdoiacteexpendituredtl-listing";
	public static final String DOI_JPA_AC_TDOIACTEEXPENDITUREDTL_LISTING_BY_STATUS ="/doi-jpa-ac-tdoiacteexpendituredtl-listing-by-status";
	public static final String DOI_JPA_AC_TDOIACTEEXPENDITUREDTL_DELETE ="/doi-jpa-ac-tdoiacteexpendituredtl-delete";
	//TdoiAcTeRecoveryDtlDTO
	public static final String DOI_JPA_AC_TDOIACTERECOVERYDTL_ENTRY ="/doi-jpa-ac-tdoiacterecoverydtl-entry";
	public static final String DOI_JPA_AC_TDOIACTERECOVERYDTL_LISTING ="/doi-jpa-ac-tdoiacterecoverydtl-listing";
	public static final String DOI_JPA_AC_TDOIACTERECOVERYDTL_LISTING_BY_STATUS ="/doi-jpa-ac-tdoiacterecoverydtl-listing-by-status";
	public static final String DOI_JPA_AC_TDOIACTERECOVERYDTL_DELETE ="/doi-jpa-ac-tdoiacterecoverydtl-delete";
	//TdoiAcTransferEntryDtlDTO
	public static final String DOI_JPA_AC_TDOIACTRANSFERENTRYDTL_ENTRY ="/doi-jpa-ac-tdoiactransferentrydtl-entry";
	public static final String DOI_JPA_AC_TDOIACTRANSFERENTRYDTL_LISTING ="/doi-jpa-ac-tdoiactransferentrydtl-listing";
	public static final String DOI_JPA_AC_TDOIACTRANSFERENTRYDTL_LISTING_BY_STATUS ="/doi-jpa-ac-tdoiactransferentrydtl-listing-by-status";
	public static final String DOI_JPA_AC_TDOIACTRANSFERENTRYDTL_DELETE ="/doi-jpa-ac-tdoiactransferentrydtl-delete";
	//TdoiAcTransferEntryDTO
	public static final String DOI_JPA_AC_TDOIACTRANSFERENTRY_ENTRY ="/doi-jpa-ac-tdoiactransferentry-entry";
	public static final String DOI_JPA_AC_TDOIACTRANSFERENTRY_LISTING ="/doi-jpa-ac-tdoiactransferentry-listing";
	public static final String DOI_JPA_AC_TDOIACTRANSFERENTRY_LISTING_BY_STATUS ="/doi-jpa-ac-tdoiactransferentry-listing-by-status";
	public static final String DOI_JPA_AC_TDOIACTRANSFERENTRY_DELETE ="/doi-jpa-ac-tdoiactransferentry-delete";


}
