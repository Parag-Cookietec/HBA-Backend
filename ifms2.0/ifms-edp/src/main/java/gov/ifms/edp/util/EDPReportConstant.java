/*
 * 
 */
package gov.ifms.edp.util;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.util.Constant;


public class EDPReportConstant {

	/**
	 * Instantiates a new EDP report constant.
	 */
	private EDPReportConstant() {
	}

	/** The search update office list. */
	protected static Map<String, String> rightsMappingReportMap = new LinkedHashMap<>(15);

	/** The post transfer summary report map. */
	protected static Map<String, String> reportPostHistoryReportMap = new LinkedHashMap<>(5);

	/** The post transfer summary report map. */
	protected static Map<String, String> postTransferSummaryReportMap = new LinkedHashMap<>(15);

	/** The office creation summary rpt map. */
	protected static Map<String, String> officeCreationSummaryRptMap = new LinkedHashMap<>(15);

	/** The rights mapping report column map. */
	protected static Map<Long, List<String>> reportColumnListMap = new LinkedHashMap<>();

	/** The rights mapping report column map. */
	protected static Map<Long, Object[]> reportColumnArrayMap = new LinkedHashMap<>();

	/** The edp report name map. */
	protected static Map<Long, String> edpReportNameMap = new LinkedHashMap<>(6);
	
	/** The edp report labels. */
	protected static Map<String,String> edpReportLabels = new LinkedHashMap<>();
	
	/** The Constant WF_STATUS_VALUE. */
	public static final String WF_STATUS_VALUE = "IN_WF_STATUS";

	/** The Constant VALUE_SEVEN. */
	public static final int VALUE_SEVEN = 7;

	/** The Constant TRN_FROM_DATE_KEY. */
	public static final String TRN_FROM_DATE_KEY = "trnFromDate";

	/** The Constant TO_DATE_KEY. */
	public static final String TRN_TO_DATE_KEY = "trnToDate";
	
	/** The Constant DISTRICT_KEY. */
	public static final String DISTRICT_KEY = "districtId";

	/** The Constant DISTRICT_VALUE. */
	public static final String DISTRICT_VALUE = "IN_DISTRICT_ID";

	/** The Constant ARG_DDOTYPEID. */
	public static final String ARG_DDOTYPEID = "ddoType";

	/** The Constant TRN_NO_KEY. */
	public static final String TRN_NO_KEY = "trnNo";

	/** The Constant FROM_DATE_KEY. */
	public static final String FROM_DATE_KEY = "fromDate";

	/** The Constant TO_DATE_KEY. */
	public static final String TO_DATE_KEY = "toDate";

	/** The Constant TRN_NO_VALUE. */
	public static final String TRN_NO_VALUE = "IN_TRN_NO";

	/** The Constant FROM_DATE_VALUE. */
	public static final String FROM_DATE_VALUE = "IN_TRN_FROM_DATE";

	/** The Constant TO_DATE_VALUE. */
	public static final String TO_DATE_VALUE = "IN_TRN_TO_DATE";
	
	/** The Constant DEPARTMENT_ID_KEY. */
	public static final String DEPARTMENT_ID_KEY = "departmentId";

	/** The Constant DEPARTMENT_ID_VALUE. */
	public static final String DEPARTMENT_ID_VALUE = "IN_DEPARTMENT_ID";
	
	/** The Constant HOD_ID_KEY. */
	public static final String HOD_ID_KEY = "hodId";

	/** The Constant HOD_ID_VALUE. */
	public static final String HOD_ID_VALUE = "IN_HOD_ID";
	
	/** The Constant DDO_NO_KEY. */
	public static final String DDO_NO_KEY = "ddoNo";

	/** The Constant CARDEX_NO_KEY. */
	public static final String CARDEX_NO_KEY = "cardexNo";

	/** The Constant STATUS_KEY. */
	public static final String STATUS_KEY = "statusId";

	/** The Constant STATUS_VALUE. */
	public static final String STATUS_VALUE = "IN_STATUS_ID";

	/** The Constant CARDEX_NO_VALUE. */
	public static final String CARDEX_NO_VALUE = "IN_CARDEX_NO";

	/** The Constant DDO_NO_VALUE. */
	public static final String DDO_NO_VALUE = "IN_DDO_NO";
	
	/** The Constant WF_STATUS_KEY. */
	public static final String WF_STATUS_KEY = "wfStatusId";

	/** The Constant RIGHTS_MAPPING_REPORT. */
	public static final Long RIGHTS_MAPPING_REPORT_MENU_ID = 254l ;
	
	/** The Constant RIGHTS_MAPPING_REPORT_SP. */
	public static final String RIGHTS_MAPPING_REPORT_SP = "REPORT_RIGHTS_MAPPING";
	
	/** The Constant RIGHTS_MAPPING_REPORT. */
	public static final Long POST_TRANSFER_SUMMARY_REPORT_MENU_ID = 256l ;
	
	/** The Constant POST_TRANSFER_SUMMARY_REPORT_SP. */
	public static final String POST_TRANSFER_SUMMARY_REPORT_SP = "REPORT_POST_TRANSFER_REQUEST_SUMMARY";

	/** The Constant REPORT_POST_HISTORY_MENU_ID. */
	public static final Long REPORT_POST_HISTORY_MENU_ID = 257l ;
	
	/** The Constant REPORT_POST_HISTORY_SP. */
	public static final String REPORT_POST_HISTORY_SP = "REPORT_POST_HISTORY";
	
	/** The Constant OFFICE_SUMMARY_REPORT_MENU_ID. */
	public static final Long OFFICE_SUMMARY_REPORT_MENU_ID = 258l ;
	
	/** The Constant OFFICE_SUMMARY_REPORT_SP. */
	public static final String OFFICE_SUMMARY_REPORT_SP = "REPORT_OFFICE_CREATION_SUMMARY";
	
	
	/** The Constant CREATE_NEW_POST_MENU_ID. */
	public static final Long CREATE_NEW_POST_MENU_ID = 39l;
	
	/** The Constant CREATE_OFFICE_MENU_ID. */
	public static final Long CREATE_OFFICE_MENU_ID = 20l;
	
	/** The Constant IN_OFFICE_NAME_KEY. */
	public static final String IN_OFFICE_NAME_KEY = "officeName";
	
	/** The Constant IN_OFFICE_NAME_VALUE. */
	public static final String IN_OFFICE_NAME_VALUE = "IN_OFFICE_NAME";
	
	/** The Constant IN_TRANSACTION_NO_KEY. */
	public static final String IN_TRANSACTION_NO_KEY = "trnNo";
	
	/** The Constant IIN_TRANSACTION_NO_VALUE. */
	public static final String IN_TRANSACTION_NO_VALUE = "IN_TRANSACTION_NO";

	/** The Constant IIN_TRANSACTION_NO_VALUE. */
	public static final String IN_TRN_NO_VALUE = "IN_TRN_NO";
	
	/** The Constant IN_OFFICE_TYPE_ID_KEY. */
	public static final String IN_OFFICE_TYPE_ID_KEY = "officeTypeId";
	
	/** The Constant IN_OFFICE_TYPE_ID_VALUE. */
	public static final String IN_OFFICE_TYPE_ID_VALUE = "IN_OFFICE_TYPE_ID";
	
	/** The Constant IN_DDO_TYPE_ID_KEY. */
	public static final String IN_DDO_TYPE_ID_KEY = "ddoTypeId";
	
	/** The Constant IN_DDO_TYPE_ID_VALUE. */
	public static final String IN_DDO_TYPE_ID_VALUE = "IN_DDO_TYPE_ID";
	
	/** The Constant IN_IS_CO_KEY. */
	public static final String IN_IS_CO_KEY = "isCo";
	
	/** The Constant IN_IS_CO_VALUE. */
	public static final String IN_IS_CO_VALUE = "IN_IS_CO";
	
	/** The Constant IN_PVU_ID_KEY. */
	public static final String IN_PVU_ID_KEY = "pvuId";
	
	/** The Constant IIN_TRANSACTION_NO_VALUE. */
	public static final String IN_PVU_ID_VALUE = "IN_PVU_ID";
	
	/** The Constant IN_OFFICE_STATUS_ID_KEY. */
	public static final String IN_OFFICE_STATUS_ID_KEY = "officeStatusId";
	
	/** The Constant IN_OFFICE_STATUS_ID_VALUE. */
	public static final String IN_OFFICE_STATUS_ID_VALUE = "IN_OFFICE_STATUS_ID";
	
	/** The Constant IN_LEVEL_ID_KEY. */
	public static final String IN_LEVEL_ID_KEY = "levelId";
	
	/** The Constant IN_LEVEL_ID_VALUE. */
	public static final String IN_LEVEL_ID_VALUE = "IN_LEVEL_ID";
	
	/** The Constant IN_DESIGNATION_ID_KEY. */
	public static final String IN_DESIGNATION_ID_KEY = "designationId";
	
	/** The Constant IN_DESIGNATION_ID_VALUE. */
	public static final String IN_DESIGNATION_ID_VALUE = "IN_DESIGNATION_ID";
	
	/** The Constant IN_BILL_TYPE_ID_KEY. */
	public static final String IN_BILL_TYPE_ID_KEY = "billTypeId";
	
	/** The Constant IN_BILL_TYPE_ID_VALUE. */
	public static final String IN_BILL_TYPE_ID_VALUE = "IN_BILL_TYPE_ID";
	
	/** The Constant IN_HOD_ID_VALUE. */
	public static final String IN_HOD_ID_VALUE = "IN_HOD";
	
	/** The Constant RIGHTS_MAPPING_REPORT_COLUMN. */
	public static final String RIGHTS_MAPPING_REPORT_COLUMN = "Sr No,Reference Number,Reference Date,District,DDO,Cardex,Office Name,"
			+ "Employee No,Employee Name,Post name,Lying With,Transaction Status,Workflow Status";

	/** The Constant POST_TRANSFER_SUMMARY_REPORT_COLUMN. */
	public static final String POST_TRANSFER_SUMMARY_REPORT_COLUMN = "Sr No,Reference Number,Reference Date,District,DDO,Cardex,Office Name,"
			+ "Post name,Transferred From,Transferred To,Lying With,Transaction Status,Workflow Status";
	
	/** The Constant REPORT_POST_HISTORY_REPORT_COLUMN. */
	public static final String REPORT_POST_HISTORY_REPORT_COLUMN = "Sr No,Post Name,Employee No,Employee Name,From Date,To Date";

	public static final String OFFICE_SUMMARY_REPORT_COLUMN = "Sr No,Reference Number,Reference Date,Unique ID,District,DDO No,Cardex No,Office Name,"
			+ "Designation of DDO,Department,HOD,Office Type,DDO Type,PVU,Is it Controlling Office,CO Office Name,Mapped Treasury/STO/PAO,Start Date,"
			+ "End Date,Office Status,Bill type,Lying With,Transaction Status,Workflow Status";

	static {
		
		rightsMappingReportMap.put(EDPReportConstant.TRN_FROM_DATE_KEY, EDPReportConstant.FROM_DATE_VALUE);
		rightsMappingReportMap.put(EDPReportConstant.TRN_TO_DATE_KEY, EDPReportConstant.TO_DATE_VALUE);
		rightsMappingReportMap.put(EDPReportConstant.DISTRICT_KEY, EDPReportConstant.DISTRICT_VALUE);
		rightsMappingReportMap.put(EDPReportConstant.DEPARTMENT_ID_KEY, EDPReportConstant.DEPARTMENT_ID_VALUE);
		rightsMappingReportMap.put(EDPReportConstant.HOD_ID_KEY, EDPReportConstant.IN_HOD_ID_VALUE);
		rightsMappingReportMap.put(EDPReportConstant.DDO_NO_KEY, EDPReportConstant.DDO_NO_VALUE);
		rightsMappingReportMap.put(EDPReportConstant.CARDEX_NO_KEY, EDPReportConstant.CARDEX_NO_VALUE);
		rightsMappingReportMap.put(EDPReportConstant.STATUS_KEY, EDPReportConstant.STATUS_VALUE);
		rightsMappingReportMap.put(EDPReportConstant.WF_STATUS_KEY, EDPReportConstant.WF_STATUS_VALUE);
		rightsMappingReportMap.put(EDPReportConstant.IN_OFFICE_NAME_KEY, EDPReportConstant.IN_OFFICE_NAME_VALUE);
		rightsMappingReportMap.put(EDPReportConstant.IN_TRANSACTION_NO_KEY, EDPReportConstant.IN_TRANSACTION_NO_VALUE);
		
		postTransferSummaryReportMap.put(EDPReportConstant.TRN_FROM_DATE_KEY, EDPReportConstant.FROM_DATE_VALUE);
		postTransferSummaryReportMap.put(EDPReportConstant.TRN_TO_DATE_KEY, EDPReportConstant.TO_DATE_VALUE);
		postTransferSummaryReportMap.put(EDPReportConstant.DISTRICT_KEY, EDPReportConstant.DISTRICT_VALUE);
		postTransferSummaryReportMap.put(EDPReportConstant.DEPARTMENT_ID_KEY, EDPReportConstant.DEPARTMENT_ID_VALUE);
		postTransferSummaryReportMap.put(EDPReportConstant.HOD_ID_KEY, EDPReportConstant.IN_HOD_ID_VALUE);
		postTransferSummaryReportMap.put(EDPReportConstant.DDO_NO_KEY, EDPReportConstant.DDO_NO_VALUE);
		postTransferSummaryReportMap.put(EDPReportConstant.CARDEX_NO_KEY, EDPReportConstant.CARDEX_NO_VALUE);
		postTransferSummaryReportMap.put(EDPReportConstant.STATUS_KEY, EDPReportConstant.STATUS_VALUE);
		postTransferSummaryReportMap.put(EDPReportConstant.IN_TRANSACTION_NO_KEY, EDPReportConstant.IN_TRANSACTION_NO_VALUE);
		postTransferSummaryReportMap.put(EDPReportConstant.WF_STATUS_KEY, EDPReportConstant.WF_STATUS_VALUE);
		postTransferSummaryReportMap.put(EDPReportConstant.IN_OFFICE_NAME_KEY, EDPReportConstant.IN_OFFICE_NAME_VALUE);
		
		reportPostHistoryReportMap.put(EDPReportConstant.IN_OFFICE_ID_KEY,EDPReportConstant.IN_OFFICE_ID_VALUE);
		reportPostHistoryReportMap.put(EDPReportConstant.IN_POST_ID_KEY,EDPReportConstant.IN_POST_ID_VALUE);
		
		officeCreationSummaryRptMap.put(EDPReportConstant.TRN_FROM_DATE_KEY, EDPReportConstant.FROM_DATE_VALUE);
		officeCreationSummaryRptMap.put(EDPReportConstant.TRN_TO_DATE_KEY, EDPReportConstant.TO_DATE_VALUE);
		officeCreationSummaryRptMap.put(EDPReportConstant.DEPARTMENT_ID_KEY, EDPReportConstant.DEPARTMENT_ID_VALUE);
		officeCreationSummaryRptMap.put(EDPReportConstant.HOD_ID_KEY, EDPReportConstant.IN_HOD_ID_VALUE);
		officeCreationSummaryRptMap.put(EDPReportConstant.DISTRICT_KEY, EDPReportConstant.DISTRICT_VALUE);
		officeCreationSummaryRptMap.put(EDPReportConstant.DDO_NO_KEY, EDPReportConstant.DDO_NO_VALUE);
		officeCreationSummaryRptMap.put(EDPReportConstant.CARDEX_NO_KEY, EDPReportConstant.CARDEX_NO_VALUE);
		officeCreationSummaryRptMap.put(EDPReportConstant.IN_OFFICE_NAME_KEY, EDPReportConstant.IN_OFFICE_NAME_VALUE);
		officeCreationSummaryRptMap.put(EDPReportConstant.IN_OFFICE_TYPE_ID_KEY, EDPReportConstant.IN_OFFICE_TYPE_ID_VALUE);
		officeCreationSummaryRptMap.put(EDPReportConstant.IN_DDO_TYPE_ID_KEY, EDPReportConstant.IN_DDO_TYPE_ID_VALUE);
		officeCreationSummaryRptMap.put(EDPReportConstant.IN_IS_CO_KEY, EDPReportConstant.IN_IS_CO_VALUE);
		officeCreationSummaryRptMap.put(EDPReportConstant.IN_PVU_ID_KEY, EDPReportConstant.IN_PVU_ID_VALUE);
		officeCreationSummaryRptMap.put(EDPReportConstant.IN_OFFICE_STATUS_ID_KEY, EDPReportConstant.IN_OFFICE_STATUS_ID_VALUE);
		officeCreationSummaryRptMap.put(EDPReportConstant.IN_LEVEL_ID_KEY, EDPReportConstant.IN_LEVEL_ID_VALUE);
		officeCreationSummaryRptMap.put(EDPReportConstant.IN_DESIGNATION_ID_KEY, EDPReportConstant.IN_DESIGNATION_ID_VALUE);
		officeCreationSummaryRptMap.put(EDPReportConstant.IN_BILL_TYPE_ID_KEY, EDPReportConstant.IN_BILL_TYPE_ID_VALUE);
		officeCreationSummaryRptMap.put(EDPReportConstant.IN_TRANSACTION_NO_KEY, EDPReportConstant.IN_TRN_NO_VALUE);
		
		edpReportNameMap.put(EDPReportConstant.RIGHTS_MAPPING_REPORT_MENU_ID,EDPReportConstant.RIGHTS_MAPPING_REPORT_MENU_NAME);
		edpReportNameMap.put(EDPReportConstant.POST_TRANSFER_SUMMARY_REPORT_MENU_ID,EDPReportConstant.POST_TRANSFER_SUMMARY_REPORT_NAME);	
		edpReportNameMap.put(EDPReportConstant.REPORT_POST_HISTORY_MENU_ID,EDPReportConstant.POST_POST_HISTORY_REPORT_NAME);
		edpReportNameMap.put(EDPReportConstant.OFFICE_SUMMARY_REPORT_MENU_ID,EDPReportConstant.OFFICE_SUMMARY_REPORT_NAME);
		
		
		edpReportLabels.put(EDPReportConstant.TRN_FROM_DATE_KEY, EDPReportConstant.REPORT_FROM_DATE_LABEL);
		edpReportLabels.put(EDPReportConstant.TRN_TO_DATE_KEY, EDPReportConstant.REPORT_TO_DATE_LABEL);
		edpReportLabels.put(EDPReportConstant.DISTRICT_KEY, EDPReportConstant.REPORT_DISTRICT_LABEL);
		edpReportLabels.put(EDPReportConstant.DEPARTMENT_ID_KEY, EDPReportConstant.REPORT_DEPARTMENT_LABEL);
		edpReportLabels.put(EDPReportConstant.HOD_ID_KEY, EDPReportConstant.REPORT_HOD_LABEL);
		edpReportLabels.put(EDPReportConstant.DDO_NO_KEY, EDPReportConstant.REPORT_DDO_NO_LABEL);
		edpReportLabels.put(EDPReportConstant.CARDEX_NO_KEY, EDPReportConstant.REPORT_CARDEX_NO_LABEL);
		edpReportLabels.put(EDPReportConstant.STATUS_KEY, EDPReportConstant.REPORT_STATUS_LABEL);
		edpReportLabels.put(EDPReportConstant.WF_STATUS_KEY, EDPReportConstant.REPORT_WF_STATUS_LABEL);
		edpReportLabels.put(EDPReportConstant.IN_OFFICE_NAME_KEY, EDPReportConstant.REPORT_OFFICE_NAME_LABEL);
		edpReportLabels.put(EDPReportConstant.IN_TRANSACTION_NO_KEY, EDPReportConstant.REPORT_TRANSACTION_NO_LABEL);
		edpReportLabels.put(EDPReportConstant.IN_OFFICE_ID_KEY, EDPReportConstant.REPORT_OFFICE_NAME_LABEL);
		edpReportLabels.put(EDPReportConstant.IN_POST_ID_KEY, EDPReportConstant.REPORT_POST_ID_LABEL);

		reportColumnListMap.put(EDPReportConstant.RIGHTS_MAPPING_REPORT_MENU_ID,Arrays.asList(RIGHTS_MAPPING_REPORT_COLUMN.split(Constant.COMMA)));
		reportColumnListMap.put(EDPReportConstant.POST_TRANSFER_SUMMARY_REPORT_MENU_ID,Arrays.asList(POST_TRANSFER_SUMMARY_REPORT_COLUMN.split(Constant.COMMA)));
		reportColumnListMap.put(EDPReportConstant.REPORT_POST_HISTORY_MENU_ID,Arrays.asList(REPORT_POST_HISTORY_REPORT_COLUMN.split(Constant.COMMA)));
		reportColumnListMap.put(EDPReportConstant.OFFICE_SUMMARY_REPORT_MENU_ID,Arrays.asList(OFFICE_SUMMARY_REPORT_COLUMN.split(Constant.COMMA)));
		
		reportColumnArrayMap.put(EDPReportConstant.RIGHTS_MAPPING_REPORT_MENU_ID,RIGHTS_MAPPING_REPORT_COLUMN.split(Constant.COMMA));
		reportColumnArrayMap.put(EDPReportConstant.POST_TRANSFER_SUMMARY_REPORT_MENU_ID,POST_TRANSFER_SUMMARY_REPORT_COLUMN.split(Constant.COMMA));
		reportColumnArrayMap.put(EDPReportConstant.REPORT_POST_HISTORY_MENU_ID,REPORT_POST_HISTORY_REPORT_COLUMN.split(Constant.COMMA));
		reportColumnArrayMap.put(EDPReportConstant.OFFICE_SUMMARY_REPORT_MENU_ID,OFFICE_SUMMARY_REPORT_COLUMN.split(Constant.COMMA));
	}

	
	public static Map<String, String> getPostTransferSummaryReportMap() {
		return postTransferSummaryReportMap;
	}


	public static Map<String, String> getRightsMappingReportMap() {
		return rightsMappingReportMap;
	}	
	
	/** The Constant RIGHTS_MAPPING_REPORT_MENU_NAME. */
	public static final String RIGHTS_MAPPING_REPORT_MENU_NAME = "Rights Mapping Summary Report";

	/** The Constant POST_TRANSFER_SUMMARY_REPORT_NAME. */
	public static final String POST_TRANSFER_SUMMARY_REPORT_NAME = "Post Transfer Summary Report";

	/** The Constant POST_POST_HISTORY_REPORT_NAME. */
	public static final String POST_POST_HISTORY_REPORT_NAME = "Post History Report";

	/** The Constant OFFICE_SUMMARY_REPORT_NAME. */
	public static final String OFFICE_SUMMARY_REPORT_NAME = "Office Summary Report";
	


	/**
	 * Gets the edp report name map.
	 *
	 * @return the edp report name map
	 */
	public static Map<Long, String> getEdpReportNameMap() {
		return edpReportNameMap;
	}
	

	/**
	 * Gets the edp report labels.
	 *
	 * @return the edp report labels
	 */
	public static Map<String, String> getEdpReportLabels() {
		return edpReportLabels;
	}


	/** The Constant REPORT_FROM_DATE_LABEL. */
	public static final String REPORT_FROM_DATE_LABEL = "From Date";
	
	/** The Constant REPORT_TO_DATE_LABEL. */
	public static final String REPORT_TO_DATE_LABEL = "To Date";
	
	/** The Constant REPORT_DISTRICT_LABEL. */
	public static final String REPORT_DISTRICT_LABEL ="District";
    
    /** The Constant REPORT_DEPARTMENT_LABEL. */
    public static final String REPORT_DEPARTMENT_LABEL = "Department";
    
    /** The Constant REPORT_HOD_LABEL. */
    public static final String REPORT_HOD_LABEL = "Hod";
    
    /** The Constant REPORT_DDO_NO_LABEL. */
    public static final String REPORT_DDO_NO_LABEL ="DDO No";
    
    /** The Constant REPORT_CARDEX_NO_LABEL. */
    public static final String REPORT_CARDEX_NO_LABEL ="Cardex No";
    
    /** The Constant REPORT_STATUS_LABEL. */
    public static final String REPORT_STATUS_LABEL = "Status";
    
    /** The Constant REPORT_WF_STATUS_LABEL. */
    public static final String REPORT_WF_STATUS_LABEL ="Workflow Status";
    
    /** The Constant REPORT_OFFICE_NAME_LABEL. */
    public static final String REPORT_OFFICE_NAME_LABEL ="Office Name";
    
    /** The Constant REPORT_TRANSACTION_NO_LABEL. */
    public static final String REPORT_TRANSACTION_NO_LABEL = "Transaction No";
    
    /** The Constant REPORT_POST_ID_LABEL. */
    public static final String REPORT_POST_ID_LABEL = "Post";
    
    /** The Constant REPORT_STRING_JOIN. */
    public static final String REPORT_STRING_COLON = " : ";
    
    /** The Constant REPORT_STRING_COMA. */
    public static final String REPORT_STRING_COMA = " , ";

    /** The Constant REPORT_STRING_COMA_WITH_END_SPACE. */
    public static final String REPORT_STRING_COMA_WITH_END_SPACE = " , ";
    
    /** The Constant REPORT_GENERATED_BY. */
    public static final String REPORT_GENERATED_BY = "Generated By : ";
    
    /** The Constant REPORT_GENERATED_DATETIME. */
    public static final String REPORT_GENERATED_DATETIME = "Generated Date and Time : ";
    
	/** The Constant ATTACHMENT_FILENAME. */
    public static final String ATTACHMENT_FILENAME = "attachment; filename=";
	
	/** The Constant PDF_EXTENSION. */
    public static final String PDF_EXTENSION = ".pdf";

    /** The Constant XLSX_EXTENSION. */
    public static final String XLSX_EXTENSION = ".xlsx";
    
    /** The Constant ARIAL_FONT. */
    public static final String ARIAL_FONT = "Arial";
    
    public static final String REPORT_ELECTRONICALLY_TEXT  = MsgConstant.REPORT_ELECTRONICALLY_TEXT;

    /** The column widths. */
    private static float[] rightsMappingColumnWidths = new float[] { 15f, 69f, 45f, 45f, 23f, 29f, 65f, 40f, 55f, 50f, 50f, 35f, 35f};

    /** The post transfer summary report column widths. */
    private static float[] postTransferSummaryReportColumnWidths = new float[] { 15f, 69f, 45f, 45f, 23f, 29f, 65f, 40f, 55f, 50f, 50f, 35f, 35f };
    
    /** The report post history report column widths. */
    private static float[] reportPostHistoryReportColumnWidths = new float[] {15f, 130f, 30f, 65f, 48f, 48f};

    /** The office summary report column widths. */
    private static float[] officeSummaryReportColumnWidths =  new float[] {18f,69f,45f,45f,45f,23f,29f,65f,45f,45f,45f,45f,45f,45f,45f,45f,45f,45f,45f,45f,45f,45f,45f,45f};

	/**
	 * @return the rIGHTS_MAPPING_REPORT_COLUMN_MAP
	 */
	public static Map<Long, List<String>> getReportColumnListMap() {
		return reportColumnListMap;
	}

	/**
	 * @return the rEPORT_COLUMN_ARRAY_MAP
	 */
	public static Map<Long, Object[]> getReportColumnArrayMap() {
		return reportColumnArrayMap;
	}
	
	/**
	 * @return the rEPORT_POST_HISTORY_REPORT_MAP
	 */
	public static Map<String, String> getReportPostHistoryReportMap() {
		return reportPostHistoryReportMap;
	}
	
	/**
	 * Gets the office creation summary rpt map.
	 *
	 * @return the office creation summary rpt map
	 */
	public static Map<String, String> getOfficeCreationSummaryRptMap() {
		return officeCreationSummaryRptMap;
	}

	/** The Constant USER_NAME_NO_BORDER. */
	public static final String USER_NAME_NO_BORDER = "userName_NoBorder";

	/** The Constant NO_BORDER. */
	public static final String NO_BORDER = "_NoBorder";

	/** The Constant CREATE_DATA_NO_BORDER_DDO. */
	public static final String CREATE_DATA_NO_BORDER_DDO = "createData_NoBorder_Ddo";

	/** The Constant USER_NAME_NO_BORDER_DDO. */
	public static final String USER_NAME_NO_BORDER_DDO = "userName_NoBorder_Ddo";

	/** The Constant BLANK2_NO_BORDER_DDO. */
	public static final String BLANK2_NO_BORDER_DDO = "blank2_NoBorder_Ddo";

	/** The Constant BLANK1_NO_BORDER_DDO. */
	public static final String BLANK1_NO_BORDER_DDO = "blank1_NoBorder_Ddo";

	/** The Constant OFFICE_NAME_DDO. */
	public static final String OFFICE_NAME_DDO = "OfficeName_Ddo";

	/** The Constant REPORT_DDO. */
	public static final String REPORT_DDO = "Report_Ddo";

	/** The Constant COLOUMN_DDO. */
	public static final String COLOUMN_DDO = "coloumn_Ddo";

	/** The Constant SELECTOR_DDO. */
	public static final String SELECTOR_DDO = "selector_Ddo";

	/** The Constant OFFICE_ADD_DDO. */
	public static final String OFFICE_ADD_DDO = "OfficeAdd_Ddo";
	
	/** The Constant SP_REPORT_DISTRICT_WISE_OFFICE_DTL. */
	public static final String SP_REPORT_DISTRICT_WISE_OFFICE_DTL = "SP_REPORT_DISTRICT_WISE_OFFICE_DTL";
	
	/** The Constant SP_REPORT_POST_HISORY_GET_DETAIL. */
	public static final String SP_REPORT_POST_HISORY_GET_DETAIL = "SP_REPORT_OFFICE_POST_DETAIL";
	
	/** The Constant IN_OFFICE_ID_KEY. */
	public static final String IN_OFFICE_ID_KEY = "officeId";
	
	/** The Constant IN_OFFICE_ID_VALUE. */
	public static final String IN_OFFICE_ID_VALUE = "IN_OFFICE_ID";

	/** The Constant IN_POST_ID_KEY. */
	public static final String IN_POST_ID_KEY = "postId";
	
	/** The Constant IN_POST_ID_VALUE. */
	public static final String IN_POST_ID_VALUE = "IN_POST_ID";
	
	/** The Constant PAY_VERIFICATION_UNIT_SELF. */
	public static final String PAY_VERIFICATION_UNIT_SELF = "Pay Verification Unit, Self";
	
	/** The Constant DASH. */
	public static final String DASH = "-";
	
	/** The Constant UNDERSCORE. */
	public static final String UNDERSCORE = "_";
	
	/** The Constant DD_MM_YYYY. */
	public static final String DD_MM_YYYY = "dd_MM_yyyy";
	
	/** The Constant BORDER_THIN. */
	public static final BorderStyle BORDER_THIN  = BorderStyle.THIN; 
	
	/** The Constant CENTER. */
	public static final HorizontalAlignment CENTER = HorizontalAlignment.CENTER;
	
	/** The Constant SOLID_FOREGROUND. */
	public static final FillPatternType SOLID_FOREGROUND = FillPatternType.SOLID_FOREGROUND ;
	

	/**
	 * @return the rIGHTS_MAPPING_COLUMN_WIDTHS
	 */
	public static float[] getRightsMappingColumnWidths() {
		return rightsMappingColumnWidths;
	}

	/**
	 * @return the pOST_TRANSFER_SUMMARY_REPORT_COLUMN_WIDTHS
	 */
	public static float[] getPostTransferSummaryReportColumnWidths() {
		return postTransferSummaryReportColumnWidths;
	}

	/**
	 * @return the rEPORT_POST_HISTORY_REPORT_COLUMN_WIDTHS
	 */
	public static float[] getReportPostHistoryReportColumnWidths() {
		return reportPostHistoryReportColumnWidths;
	}

	/**
	 * @return the oFFICE_SUMMARY_REPORT_COLUMN_WIDTHS
	 */
	public static float[] getOfficeSummaryReportColumnWidths() {
		return officeSummaryReportColumnWidths;
	}

	
}
