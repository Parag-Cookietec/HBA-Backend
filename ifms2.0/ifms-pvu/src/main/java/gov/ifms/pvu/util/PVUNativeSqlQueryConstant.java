package gov.ifms.pvu.util;

import static gov.ifms.common.util.Constant.SQL_FROM;
import static gov.ifms.common.util.Constant.SQL_INNER_JOIN;

import gov.ifms.common.util.Constant;

public class PVUNativeSqlQueryConstant {



	private static final String MS_OFFICE_OFC_ON_OFC_OFFICE_ID_EMP_OFFICE_ID = ".MS_OFFICE ofc ON ofc.OFFICE_ID  =  EMP.OFFICE_ID ";
	private static final String MS_EMPLOYEE_EMP_ON_EMP_EMP_ID_TPRE_EMP_ID = ".MS_EMPLOYEE emp ON emp.EMP_ID = TPRE.EMP_ID ";
	private static final String PRNT_REPRINT_DATE_AS_C4_FROM = "PRNT.REPRINT_DATE AS c4  FROM  ";
	private static final String MS_USER_USERS_ON_USERS_USER_ID_POU_USER_ID = ".MS_USER users ON users.USER_ID  = pou.USER_ID ";
	private static final String MS_POST_POST_ON_POST_POST_ID_PO_POST_ID = ".MS_POST post ON POST.POST_ID  = po.POST_ID ";
	private static final String LK_PO_OFF_USER_POU_ON_POU_LK_PO_OFF_USER_ID_PRNT_UPDATED_BY_POST = ".LK_PO_OFF_USER  pou ON pou.LK_PO_OFF_USER_ID = prnt.UPDATED_BY_POST ";
	private static final String LK_POST_OFFICE_PO_ON_PO_LK_POST_OFFICE_ID_POU_LK_POST_OFFICE_ID_INNER_JOIN = ".LK_POST_OFFICE po ON po.LK_POST_OFFICE_ID  = pou.LK_POST_OFFICE_ID INNER JOIN ";
	private static final String REASON_REASON_ID_AS_C1_REASON_REASON_NAME_AS_C2 = " REASON.REASON_ID AS C1,	REASON.REASON_NAME AS C2, ";



	public static String getRopRemarkHistory() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" SELECT REMARKS.REMARKS AS c0 ,LOOKUP.LOOKUP_INFO_NAME AS c1  , ro.WF_ROLE_NAME AS c2 , REMARKS.RP_EVNT_ID AS c3 ,");
        stringBuilder.append(" REMARKS.RP_EVNT_REMARKS_ID  AS c4 FROM  " );
        stringBuilder.append(Constant.PVU_SCHEMA).append(".PVU_ROP_EVNT_REMARKS remarks ");
        stringBuilder.append(SQL_INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER).append(".WF_WORKFLOW_ROLE RO ON ro.WF_ROLE_ID  = REMARKS.WORKFLOW_ROLE_ID ");
        stringBuilder.append(SQL_INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER).append(".LU_LOOKUP_INFO  lookup ON REMARKS.REASON  = LOOKUP.LOOKUP_INFO_ID ");
        stringBuilder.append(" WHERE REMARKS.RP_EVNT_ID  = :ropEventId and REMARKS.ACTIVE_STATUS =:activeStatus " );
        return  stringBuilder.toString();
    }

    public static String getRopEmployeeOfficeId() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select (SELECT OFFICE_NAME_ALIAS FROM MASTER_V1.MS_OFFICE WHERE office_Id=ofc.PVU_ID ) AS c0 , TPRE.T_PVU_RP_EVNT_ID AS c1  FROM " );
        stringBuilder.append(Constant.PVU_SCHEMA).append(".T_PVU_RP_EVNT tpre  INNER JOIN " );
        stringBuilder.append(Constant.PVU_SCHEMA_MASTER).append(MS_EMPLOYEE_EMP_ON_EMP_EMP_ID_TPRE_EMP_ID );
        stringBuilder.append(SQL_INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
        .append(MS_OFFICE_OFC_ON_OFC_OFFICE_ID_EMP_OFFICE_ID);
        stringBuilder.append("WHERE TPRE.T_PVU_RP_EVNT_ID = :ropEventId " );
        return stringBuilder.toString();
    }

    public static String getSSPEmployeeOfficeId() {
        StringBuilder stringBuilder = new StringBuilder(); // NO SONAR
        stringBuilder.append("select (SELECT nvl(OFFICE_NAME_ALIAS, office_name) FROM MASTER_V1.MS_OFFICE WHERE office_Id=ofc.PVU_ID ) AS c0 , TPRE.T_PVU_SS_EVNT_ID AS c1  FROM ");
        stringBuilder.append(Constant.PVU_SCHEMA).append(".T_PVU_SS_EVNT tpre  INNER JOIN ");
        stringBuilder.append(Constant.PVU_SCHEMA_MASTER).append(MS_EMPLOYEE_EMP_ON_EMP_EMP_ID_TPRE_EMP_ID);
        stringBuilder.append(SQL_INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
                .append(MS_OFFICE_OFC_ON_OFC_OFFICE_ID_EMP_OFFICE_ID);
        stringBuilder.append("WHERE TPRE.T_PVU_SS_EVNT_ID = :eventId ");

        return stringBuilder.toString();
    }
   
    public static String getACPPEmployeeOfficeId() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select (SELECT nvl(OFFICE_NAME_ALIAS, office_name) FROM MASTER_V1.MS_OFFICE WHERE office_Id=ofc.PVU_ID ) AS c0 , TPRE.T_PVU_AP_EVNT_ID AS c1  FROM ");
        stringBuilder.append(Constant.PVU_SCHEMA).append(".T_PVU_AP_EVNT tpre  INNER JOIN ");
        stringBuilder.append(Constant.PVU_SCHEMA_MASTER).append(MS_EMPLOYEE_EMP_ON_EMP_EMP_ID_TPRE_EMP_ID);
        stringBuilder.append(SQL_INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
                .append(MS_OFFICE_OFC_ON_OFC_OFFICE_ID_EMP_OFFICE_ID);
        stringBuilder.append("WHERE TPRE.T_PVU_AP_EVNT_ID = :eventId ");

        return stringBuilder.toString();
    }
    
    public static String getCSPEmployeeOfficeId() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select (SELECT nvl(OFFICE_NAME_ALIAS, office_name) FROM MASTER_V1.MS_OFFICE WHERE office_Id=ofc.PVU_ID ) AS c0 , TPRE.T_PVU_CS_EVNT_ID AS c1  FROM ");
        stringBuilder.append(Constant.PVU_SCHEMA).append(".T_PVU_CS_EVNT tpre  INNER JOIN ");
        stringBuilder.append(Constant.PVU_SCHEMA_MASTER).append(MS_EMPLOYEE_EMP_ON_EMP_EMP_ID_TPRE_EMP_ID);
        stringBuilder.append(SQL_INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
                .append(MS_OFFICE_OFC_ON_OFC_OFFICE_ID_EMP_OFFICE_ID);
        stringBuilder.append("WHERE TPRE.T_PVU_CS_EVNT_ID = :eventId ");
        return stringBuilder.toString();
    }

    public static String getRopReturnRemarks() {
    	StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" SELECT rvr.RP_EVNT_ID AS C0, ");
        stringBuilder.append(REASON_REASON_ID_AS_C1_REASON_REASON_NAME_AS_C2);
        stringBuilder.append(" rvr.REMARKS AS C3, ");
        stringBuilder.append(" rvr.REMARK_TYPE AS C4 ");
        stringBuilder.append(SQL_FROM);
        stringBuilder.append(Constant.PVU_SCHEMA).append(".PVU_ROP_EVNT_REMARKS rvr INNER JOIN ");
        stringBuilder.append(Constant.PVU_SCHEMA_MASTER).append(".MS_REASON reason ON rvr.REASON = REASON.REASON_ID ");
        stringBuilder.append(" AND rvr.RP_EVNT_ID = :ropEventId ");
        stringBuilder.append(" AND rvr.ACTIVE_STATUS = :activeStatus ");
        return stringBuilder.toString();
    }

    public static String getEndorsementHistory() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT PRNT.T_PVU_RP_EVNT_ID AS c0 , USERS.USER_NAME AS c1, post.POST_NAME  AS c2 ,PRNT.REMARK  AS c3 ,");
        sb.append(PRNT_REPRINT_DATE_AS_C4_FROM);
        sb.append(Constant.PVU_SCHEMA).append(".T_PVU_PRN_LST_ITR  prnt ");
        sb.append(SQL_INNER_JOIN);
        sb.append(Constant.PVU_SCHEMA_MASTER).append(LK_PO_OFF_USER_POU_ON_POU_LK_PO_OFF_USER_ID_PRNT_UPDATED_BY_POST);
        sb.append(SQL_INNER_JOIN );
        sb.append(Constant.PVU_SCHEMA_MASTER).append(MS_USER_USERS_ON_USERS_USER_ID_POU_USER_ID);
        sb.append(SQL_INNER_JOIN );
        sb.append(Constant.PVU_SCHEMA_MASTER).append(LK_POST_OFFICE_PO_ON_PO_LK_POST_OFFICE_ID_POU_LK_POST_OFFICE_ID_INNER_JOIN);
        sb.append(Constant.PVU_SCHEMA_MASTER).append(MS_POST_POST_ON_POST_POST_ID_PO_POST_ID);
        sb.append("WHERE prnt.T_PVU_RP_EVNT_ID = :trnId AND REPRINT_DATE IS NOT NULL");
        return sb.toString();
    }
    
    public static String getHPSEmployeeOfficeId() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select (SELECT nvl(OFFICE_NAME_ALIAS, office_name) FROM MASTER_V1.MS_OFFICE WHERE office_Id=ofc.PVU_ID ) AS c0 , TPRE.T_PVU_HP_EVNT_ID AS c1  FROM ");
        stringBuilder.append(Constant.PVU_SCHEMA).append(".T_PVU_HP_EVNT tpre  INNER JOIN ");
        stringBuilder.append(Constant.PVU_SCHEMA_MASTER).append(MS_EMPLOYEE_EMP_ON_EMP_EMP_ID_TPRE_EMP_ID);
        stringBuilder.append(SQL_INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
                .append(MS_OFFICE_OFC_ON_OFC_OFFICE_ID_EMP_OFFICE_ID);
        stringBuilder.append("WHERE TPRE.T_PVU_HP_EVNT_ID = :eventId ");
        return stringBuilder.toString();
    }

    public static String getSHPEmployeeOfficeId() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select (SELECT nvl(OFFICE_NAME_ALIAS, office_name) FROM MASTER_V1.MS_OFFICE WHERE office_Id=ofc.PVU_ID ) AS c0 , TPRE.T_PVU_SP_EVNT_ID AS c1  FROM ");
        stringBuilder.append(Constant.PVU_SCHEMA).append(".T_PVU_SP_EVNT tpre  INNER JOIN ");
        stringBuilder.append(Constant.PVU_SCHEMA_MASTER).append(MS_EMPLOYEE_EMP_ON_EMP_EMP_ID_TPRE_EMP_ID);
        stringBuilder.append(SQL_INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
                .append(MS_OFFICE_OFC_ON_OFC_OFFICE_ID_EMP_OFFICE_ID);
        stringBuilder.append("WHERE TPRE.T_PVU_SP_EVNT_ID = :eventId ");
        return stringBuilder.toString();
    }

    public static String getTikuPayEmpOfficeId() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select (SELECT nvl(OFFICE_NAME_ALIAS, office_name) FROM MASTER_V1.MS_OFFICE WHERE office_Id=ofc.PVU_ID ) AS c0 , TPRE.T_PVU_TK_EVNT_ID AS c1  FROM ");
        stringBuilder.append(Constant.PVU_SCHEMA).append(".T_PVU_TK_EVNT tpre  INNER JOIN ");
        stringBuilder.append(Constant.PVU_SCHEMA_MASTER).append(MS_EMPLOYEE_EMP_ON_EMP_EMP_ID_TPRE_EMP_ID);
        stringBuilder.append(SQL_INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
        .append(MS_OFFICE_OFC_ON_OFC_OFFICE_ID_EMP_OFFICE_ID);
        stringBuilder.append("WHERE TPRE.T_PVU_TK_EVNT_ID = :eventId ");
        return stringBuilder.toString();
    }

    public static String getSteppingUpEmpOfficeId() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select (SELECT nvl(OFFICE_NAME_ALIAS, office_name) FROM MASTER_V1.MS_OFFICE WHERE office_Id=ofc.PVU_ID ) AS c0 , TPRE.T_PVU_ST_EVNT_ID AS c1  FROM ");
        stringBuilder.append(Constant.PVU_SCHEMA).append(".T_PVU_ST_EVNT tpre  INNER JOIN ");
        stringBuilder.append(Constant.PVU_SCHEMA_MASTER).append(MS_EMPLOYEE_EMP_ON_EMP_EMP_ID_TPRE_EMP_ID);
        stringBuilder.append(SQL_INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
        .append(MS_OFFICE_OFC_ON_OFC_OFFICE_ID_EMP_OFFICE_ID);
        stringBuilder.append("WHERE TPRE.T_PVU_ST_EVNT_ID = :eventId ");
        return stringBuilder.toString();
    }

    public static String getSeletionGradeEmpOfficeId() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select (SELECT nvl(OFFICE_NAME_ALIAS, office_name) FROM MASTER_V1.MS_OFFICE WHERE office_Id=ofc.PVU_ID ) AS c0 , TPRE.T_PVU_SG_EVNT_ID AS c1  FROM ");
        stringBuilder.append(Constant.PVU_SCHEMA).append(".T_PVU_SG_EVNT tpre  INNER JOIN ");
        stringBuilder.append(Constant.PVU_SCHEMA_MASTER).append(MS_EMPLOYEE_EMP_ON_EMP_EMP_ID_TPRE_EMP_ID);
        stringBuilder.append(SQL_INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
        .append(MS_OFFICE_OFC_ON_OFC_OFFICE_ID_EMP_OFFICE_ID);
        stringBuilder.append("WHERE TPRE.T_PVU_SG_EVNT_ID = :eventId ");
        return stringBuilder.toString();
    }

    
	public static String getShettyPayReturnRemarks() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" SELECT 	remarks.EVNT_TRN_ID AS C0,").append(REASON_REASON_ID_AS_C1_REASON_REASON_NAME_AS_C2);
		stringBuilder.append(" 	remarks.REMARKS AS C3,	remarks.REMARK_TYPE AS C4  FROM  ");
		stringBuilder.append(Constant.PVU_SCHEMA).append(".PVU_EVNT_RMKS remarks INNER JOIN  ");
		stringBuilder.append(Constant.PVU_SCHEMA_MASTER)
				.append(".MS_REASON reason ON remarks.REASON = REASON.REASON_ID ");
		stringBuilder.append(
				" WHERE REMARKS.ACTIVE_STATUS = :activeStatus AND  REMARKS.PVU_EVNT_ID = :shettyPayID AND REMARKS.EVNT_TRN_ID= :eventID ");

		return stringBuilder.toString();
	}
    
    public static String getReturnReasonRemarks() {
    	StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" SELECT per.PVU_EVNT_ID AS C0, ");
        stringBuilder.append(REASON_REASON_ID_AS_C1_REASON_REASON_NAME_AS_C2);
        stringBuilder.append(" per.REMARKS AS C3, ");
        stringBuilder.append(" per.REMARK_TYPE AS C4 ");
        stringBuilder.append(SQL_FROM);
        stringBuilder.append(Constant.PVU_SCHEMA).append(".PVU_EVNT_RMKS per INNER JOIN ");
        stringBuilder.append(Constant.PVU_SCHEMA_MASTER).append(".MS_REASON reason ON per.REASON = REASON.REASON_ID ");
        stringBuilder.append(" AND per.PVU_EVNT_ID = :pvuEventId "); // 
        stringBuilder.append(" AND per.ACTIVE_STATUS = :activeStatus ");
        return stringBuilder.toString();
    }
    
    public static String getCsEventReturnRemarks() {
    	StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" SELECT csr.EVNT_TRN_ID AS C0, ");
        stringBuilder.append(REASON_REASON_ID_AS_C1_REASON_REASON_NAME_AS_C2);
        stringBuilder.append(" csr.REMARKS AS C3, ");
        stringBuilder.append(" csr.REMARK_TYPE AS C4 ");
        stringBuilder.append(SQL_FROM);
        stringBuilder.append(Constant.PVU_SCHEMA).append(".PVU_EVNT_RMKS csr INNER JOIN ");
        stringBuilder.append(Constant.PVU_SCHEMA_MASTER).append(".MS_REASON reason ON csr.REASON = REASON.REASON_ID ");
        stringBuilder.append(" AND csr.EVNT_TRN_ID = :pvuEventId ");
        stringBuilder.append(" AND csr.ACTIVE_STATUS = :activeStatus AND csr.PVU_EVNT_ID= :eventID");
        return stringBuilder.toString();
    }
    
    public static String getSTPEventReturnRemarks() {
    	StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" SELECT csr.EVNT_TRN_ID AS C0, ");
        stringBuilder.append(REASON_REASON_ID_AS_C1_REASON_REASON_NAME_AS_C2);
        stringBuilder.append(" csr.REMARKS AS C3, ");
        stringBuilder.append(" csr.REMARK_TYPE AS C4 ");
        stringBuilder.append(SQL_FROM);
        stringBuilder.append(Constant.PVU_SCHEMA).append(".PVU_EVNT_RMKS csr INNER JOIN ");
        stringBuilder.append(Constant.PVU_SCHEMA_MASTER).append(".MS_REASON reason ON csr.REASON = REASON.REASON_ID ");
        stringBuilder.append(" AND csr.EVNT_TRN_ID = :pvuEventId ");
        stringBuilder.append(" AND csr.ACTIVE_STATUS = :activeStatus AND csr.PVU_EVNT_ID= :eventID");
        return stringBuilder.toString();
    }


	public static String getAcpReturnRemarks() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" SELECT 	remarks.EVNT_TRN_ID AS C0,	").append(REASON_REASON_ID_AS_C1_REASON_REASON_NAME_AS_C2);
		stringBuilder.append(" 	remarks.REMARKS AS C3,	remarks.REMARK_TYPE AS C4  FROM  ");
		stringBuilder.append(Constant.PVU_SCHEMA).append(".PVU_EVNT_RMKS remarks INNER JOIN  ");
		stringBuilder.append(Constant.PVU_SCHEMA_MASTER)
				.append(".MS_REASON reason ON remarks.REASON = REASON.REASON_ID ");
		stringBuilder.append(
				" WHERE REMARKS.ACTIVE_STATUS = :activeStatus AND  REMARKS.PVU_EVNT_ID = :eventID AND REMARKS.EVNT_TRN_ID= :trnId ");

		return stringBuilder.toString();
	}
	
	public static String getSgEventReturnRemarks() {  
    	StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" SELECT sg.EVNT_TRN_ID AS C0, ");
        stringBuilder.append(REASON_REASON_ID_AS_C1_REASON_REASON_NAME_AS_C2);
        stringBuilder.append(" sg.REMARKS AS C3, ");
        stringBuilder.append(" sg.REMARK_TYPE AS C4 "); 
        stringBuilder.append(SQL_FROM);
        stringBuilder.append(Constant.PVU_SCHEMA).append(".PVU_EVNT_RMKS sg INNER JOIN ");
        stringBuilder.append(Constant.PVU_SCHEMA_MASTER).append(".MS_REASON reason ON sg.REASON = REASON.REASON_ID ");
        stringBuilder.append(" AND sg.EVNT_TRN_ID = :pvuEventId ");
        stringBuilder.append(" AND sg.ACTIVE_STATUS = :activeStatus AND sg.PVU_EVNT_ID= :eventID");
        return stringBuilder.toString();
    }
    public static String getCAEmployeeOfficeId() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select (SELECT nvl(OFFICE_NAME_ALIAS, office_name) FROM MASTER_V1.MS_OFFICE WHERE office_Id=ofc.PVU_ID ) AS c0 , TPRE.T_PVU_CA_EVNT_ID AS c1  FROM ");
        stringBuilder.append(Constant.PVU_SCHEMA).append(".T_PVU_CA_EVNT tpre  INNER JOIN ");
        stringBuilder.append(Constant.PVU_SCHEMA_MASTER).append(MS_EMPLOYEE_EMP_ON_EMP_EMP_ID_TPRE_EMP_ID);
        stringBuilder.append(SQL_INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
                .append(MS_OFFICE_OFC_ON_OFC_OFFICE_ID_EMP_OFFICE_ID);
        stringBuilder.append("WHERE TPRE.T_PVU_CA_EVNT_ID = :eventId ");
        return stringBuilder.toString();
    }

    public static String getApproverList() {
        StringBuilder stringBuilder = new StringBuilder(); // NO SONAR
        stringBuilder.append(" SELECT distinct pou.LK_PO_OFF_USER_ID AS C0, u.USER_ID AS C1, wr.WF_ROLE_ID AS C2, u.USER_NAME AS C3 from ");
        stringBuilder.append(Constant.PVU_SCHEMA_MASTER).append(".LK_USER_MENU um JOIN ");
        stringBuilder.append(Constant.PVU_SCHEMA_MASTER).append(".TRN_USR_MNU_WF_ROLE umw ON um.LK_USER_MENU_ID = umw.LK_USER_MENU_ID ");
        stringBuilder.append(" JOIN MASTER_V1.MS_MENU menu ON um.MENU_ID = MENU.MENU_ID");
        stringBuilder.append(" JOIN MASTER_V1.WF_WORKFLOW_ROLE wr ON umw.WF_ROLE_ID = wr.WF_ROLE_ID");
        stringBuilder.append(" JOIN MASTER_V1.LK_PO_OFF_USER pou ON POU.LK_PO_OFF_USER_ID = UM.LK_PO_OFF_USER_ID");
        stringBuilder.append(" JOIN MASTER_V1.MS_USER u ON POU.USER_ID = U.USER_ID");
        stringBuilder.append(" JOIN MASTER_V1.LK_POST_OFFICE po ON POU.LK_POST_OFFICE_ID = PO.LK_POST_OFFICE_ID");
        stringBuilder.append(" JOIN MASTER_V1.MS_POST p ON po.POST_ID = p.POST_ID");
        stringBuilder.append(" JOIN MASTER_V1.MS_OFFICE o ON po.OFFICE_ID = o.OFFICE_ID");
        stringBuilder.append(" WHERE o.OFFICE_ID = :officeId and wr.WF_ROLE_ID in (15, 16)");
        return stringBuilder.toString();
    }

    public static String getPVUReturnRemarks() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT rem.EVNT_TRN_ID AS C0, reason.REASON_ID  AS C1, reason.REASON_NAME AS C2, rem.REMARKS AS C3, rem.REMARK_TYPE AS C4 FROM ");
        sb.append(Constant.PVU_SCHEMA).append(".PVU_EVNT_RMKS rem").append(Constant.INNER_JOIN);
        sb.append(Constant.PVU_SCHEMA_MASTER).append(".MS_REASON reason ON rem.REASON = reason.REASON_ID ");
        sb.append("AND rem.EVNT_TRN_ID = :trnId AND rem.PVU_EVNT_ID = :eventId AND rem.ACTIVE_STATUS = :activeStatus");
        return sb.toString();
    }

    public static String getWfTable() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT t.SCHEMA_NAME AS C0, t.TRN_WF_TBL_NAME  AS C1 FROM ");
        sb.append(Constant.PVU_SCHEMA_MASTER).append(".LK_MENU_TBL_INFO t ");
        sb.append("where t.MENU_ID = :menuId AND t.EVENT_ID = :eventId AND t.ACTIVE_STATUS = :activeStatus");
        return sb.toString();
    }

    public static String getPrintEndorsementHistory() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT PRNT.T_PVU_TRN_EVNT_ID AS c0 , USERS.USER_NAME AS c1, post.POST_NAME  AS c2 ,PRNT.REMARK  AS c3 ,");
        sb.append(PRNT_REPRINT_DATE_AS_C4_FROM);
        sb.append(Constant.PVU_SCHEMA).append(".T_COMMON_PVU_PREN_LST  PRNT ");
        sb.append(SQL_INNER_JOIN);
        sb.append(Constant.PVU_SCHEMA_MASTER).append(LK_PO_OFF_USER_POU_ON_POU_LK_PO_OFF_USER_ID_PRNT_UPDATED_BY_POST);
        sb.append(SQL_INNER_JOIN );
        sb.append(Constant.PVU_SCHEMA_MASTER).append(MS_USER_USERS_ON_USERS_USER_ID_POU_USER_ID);
        sb.append(SQL_INNER_JOIN );
        sb.append(Constant.PVU_SCHEMA_MASTER).append(LK_POST_OFFICE_PO_ON_PO_LK_POST_OFFICE_ID_POU_LK_POST_OFFICE_ID_INNER_JOIN);
        sb.append(Constant.PVU_SCHEMA_MASTER).append(MS_POST_POST_ON_POST_POST_ID_PO_POST_ID);
        sb.append("WHERE prnt.T_PVU_TRN_EVNT_ID = :trnId AND PVU_EVENT_ID =:eventId REPRINT_DATE IS NOT NULL");
        return sb.toString();
    }
    
    public static String getWfSourceUserDetail(String schemaName, String table) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT t.ASSIGN_BY_POST_ID AS C0, t.ASSIGN_BY_USER_ID AS C1, t.ASSIGN_BY_OFFICE_ID AS C2, t.ASSIGN_BY_POU_ID AS C3  FROM ");
        sb.append(schemaName).append(".").append(table).append(" t where t.ASSIGN_BY_WF_ROLE_ID = 3 AND t.TRN_ID = :trnId AND t.ASSIGN_TO_WF_ROLE_ID IS NULL ORDER BY 1 DESC LIMIT 1 ");
        return sb.toString();
    }
public static String getResultEventPrint() {
    	
    	StringBuilder  str = new StringBuilder();
    	
    	str.append("SELECT ");
    	str.append("	inEvnt.T_PVU_AP_EVNT_ID AS AP_EVNT_ID, ");
    	str.append("	msEmp.EMP_ID AS EMP_ID, ");
    	str.append("	msEmp.EMPLOYEE_NO AS EMP_NO, ");
    	str.append("	msEmp.EMPLOYEE_NAME AS EMP_NAME, ");
    	str.append("	inEvnt.TRN_NO as TRN_NO, ");
    	str.append("	inEvnt.ACP_ORDER_NO as EVENT_ORDER_NO, ");
    	str.append("	inEvnt.EVNT_ORDER_DATE AS EVENT_ORDER_DATE, ");
    	str.append("	inEvnt.DATE_NXT_INCR, ");
    	str.append("	inEvnt.ACP_TYPE AS ACP_TYPE, ");
    	str.append("	PVU.GET_LOOKUP_INFO_VAL(inEvnt.ACP_TYPE) AS ACP_TYPE_NAME, ");
    	str.append("	inEvnt.CLASS_ID AS CLASS_ID, ");
    	str.append("	PVU.GET_LOOKUP_INFO_VAL(inEvnt.CLASS_ID) AS CLASS_NAME, ");
    	str.append("	inEvnt.DESIGNATION_ID AS DESIGNATION_ID, ");
    	str.append("	(SELECT DESIGNATION_NAME FROM MASTER_V1.MS_DESIGNATION WHERE DESIGNATION_ID =inEvnt.DESIGNATION_ID) AS DESIGNATION_NAME, ");
    	str.append("	dtl.DATE_JOINING AS DOJ, ");
    	str.append("	inEvnt.C_SCALE, ");
    	str.append("	(SELECT sc.SCALE_VAL FROM MASTER_V1.MS_PAY_SCALE sc WHERE sc.PAY_SCALE_ID=inEvnt.C_SCALE) AS c_scale_value, ");
    	str.append("	inEvnt.C_PAY_BAND_VALUE, ");
    	str.append("	inEvnt.C_GRADE_PAY, ");
    	str.append("	(SELECT gp.GRADE_PAY_VALUE FROM MASTER_V1.MS_GRADE_PAY gp WHERE gp.GRADE_PAY_ID=inEvnt.C_GRADE_PAY) AS c_grade_pay_value, ");
    	str.append("	inEvnt.C_BASIC_PAY, ");
    	str.append("	inEvnt.PAY_LEVEL, ");
    	str.append("	(SELECT pl.PAY_LEVEL_VALUE FROM MASTER_V1.MS_PAY_LEVEL pl WHERE pl.PAY_LEVEL_ID=inEvnt.PAY_LEVEL) AS r_pay_level_value, ");
    	str.append("	inEvnt.CELL_ID, ");
    	str.append("	(SELECT cell.CELL_ID FROM MASTER_V1.MS_PAY_CELL cell WHERE cell.pay_cell_id=inEvnt.CELL_ID) AS r_cell_value, ");
    	str.append("	inEvnt.PAY_BAND_VALUE, ");
    	str.append("	inEvnt.GRADE_PAY, ");
    	str.append("	(SELECT gp.GRADE_PAY_VALUE FROM MASTER_V1.MS_GRADE_PAY gp WHERE gp.GRADE_PAY_ID=inEvnt.GRADE_PAY) AS r_grade_pay_value, ");
    	str.append("	inEvnt.BASIC_PAY, ");
    	str.append("	dtl.RETIREMENT_DATE AS RETIREMENT_DATE, ");
    	str.append("	inEvnt.OFFICE_ID AS OFFICE_ID, ");
    	str.append("	(SELECT mo.OFFICE_NAME FROM MASTER_V1.MS_OFFICE mo WHERE mo.OFFICE_ID = inEvnt.OFFICE_ID) AS OFFICE_NAME, ");
    	str.append("	inEvnt.BEN_EFF_DATE as EVENT_EFF_DATE, ");
    	str.append("	--inEvnt.REASON_CHNG_EFF_DATE , ");
    	str.append("	--PVU.GET_LOOKUP_INFO_VAL(inEvnt.REASON_CHNG_EFF_DATE) AS REASON_CHNG, ");
    	str.append("	--inEvnt.REMARKS AS remarks,  ");
    	str.append("	inEvnt.C_PAY_BAND AS C_PAY_BAND_ID, ");
    	str.append("	(SELECT mpb.STARTING_VALUE || ''-'' || mpb.ENDING_VALUE FROM MASTER_V1.MS_PAY_BAND mpb where mpb.PAY_BAND_ID = inEvnt.C_PAY_BAND) AS C_PAY_BAND, ");
    	str.append("	inEvnt.PAY_BAND AS R_PAY_BAND_ID, ");
    	str.append("	(SELECT mpb.STARTING_VALUE || ''-'' || mpb.ENDING_VALUE FROM MASTER_V1.MS_PAY_BAND mpb where mpb.PAY_BAND_ID = inEvnt.PAY_BAND) AS R_PAY_BAND, ");
    	str.append("	--inEvnt.C_NEXT_INCR_DATE as C_NEXT_INCR_DATE, ");
    	str.append("	inEvnt.CREATED_DATE AS CREATED_DATE, ");
    	str.append("	inEvnt.AUDITOR_REMARKS AS audRemarksC42, ");
    	str.append("	inEvnt.CLASS_II_REMARKS AS class2c43, ");
    	str.append("	inEvnt.PRINT_REMARKS AS printRemarksC44, ");
    	str.append("	inEvnt.AUDI_RET_RES AS audiRetResC45, ");
    	str.append("	inEvnt.CLASS_II_RET_RES AS cls2RetResC46, ");
    	str.append("	inEvnt.PRINT_COUNT AS printCountc47, ");
    	str.append("	inEvnt.PRINT_RET_RES AS printRetResC48, ");
    	str.append("	--case when inEvnt.IS_PRINTABLE = ' || V_PRINT_STATUS || ' then 1 else 0 end AS isPrintableC49, ");
    	str.append("	inEvnt.APPR_DATE AS apprDatec50, ");
    	str.append("	inEvnt.AUTH_DATE AS authDateC51 ");
    	str.append("	--inEvnt.npa AS npa52, ");
    	str.append("	--PVU.GET_LOOKUP_INFO_VAL(inEvnt.npa)	AS npaValue53, ");
    	str.append("	--inEvnt.AUTO_6_VALD_BASIC as AUTO_6_VALD_BASIC, ");
    	str.append("	--inEvnt.AUTO_6_VALD_PAY_VAL as AUTO_6_VALD_PAY_VAL, ");
    	str.append("	--inEvnt.AUTO_6_VALD_FLAG as AUTO_6_VALD_FLAG ");
    	str.append(" FROM PVU.T_PVU_AP_EVNT inEvnt, ");
    	str.append("	MASTER_V1.MS_EMPLOYEE msEmp, ");
    	str.append("	PVU.T_EMP_DPT_DTL dtl ");
    	str.append(" WHERE 		inEvnt.ACTIVE_STATUS = 1 ");
    	str.append("	AND msEmp.EMP_ID = inEvnt.EMP_ID ");
    	str.append("	AND inEvnt.EMP_ID = dtl.EMP_ID ");
    	str.append("	AND inEvnt.T_PVU_AP_EVNT_ID = :acpEventId ");
    	str.append("	order by msEmp.EMPLOYEE_NO");
    	
    	return str.toString();
    }


    public static String  getPVUEventEndorsementHistory() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT PRNT.T_CMNPVU_PREN_LST_ITR_ID AS c0,USERS.USER_NAME AS c1, post.POST_NAME AS c2, PRNT.REMARK AS c3, PRNT.REPRINT_DATE AS c4 FROM ");
        sb.append(Constant.PVU_SCHEMA).append(".T_CMNPVU_PREN_LST_ITR PRNT ");
        sb.append(" INNER JOIN MASTER_V1.LK_PO_OFF_USER pou ON pou.LK_PO_OFF_USER_ID = prnt.UPDATED_BY_POST ");
        sb.append(" INNER JOIN MASTER_V1.MS_USER users ON users.USER_ID = pou.USER_ID ");
        sb.append(" INNER JOIN MASTER_V1.LK_POST_OFFICE po ON po.LK_POST_OFFICE_ID = pou.LK_POST_OFFICE_ID ");
        sb.append(" INNER JOIN MASTER_V1.MS_POST post ON POST.POST_ID = po.POST_ID ");
        sb.append("WHERE PRNT.T_PVU_TRN_EVNT_ID = :trnId AND PRNT.PVU_EVENT_ID =:eventId AND REPRINT_DATE IS NOT NULL AND prnt.ACTIVE_STATUS=1 ");
        return sb.toString();
    }



public static String getCommonEndorsementHistory() {
	StringBuilder sb = new StringBuilder();
	sb.append(
			"SELECT PRNT.T_PVU_TRN_EVNT_ID AS c0 , USERS.USER_NAME AS c1, post.POST_NAME  AS c2 ,PRNT.REMARK  AS c3 ,");
	sb.append(PRNT_REPRINT_DATE_AS_C4_FROM);
	sb.append(Constant.PVU_SCHEMA).append(".T_CMNPVU_PREN_LST_ITR  prnt ");
	sb.append(SQL_INNER_JOIN);
	sb.append(Constant.PVU_SCHEMA_MASTER)
			.append(LK_PO_OFF_USER_POU_ON_POU_LK_PO_OFF_USER_ID_PRNT_UPDATED_BY_POST);
	sb.append(SQL_INNER_JOIN);
	sb.append(Constant.PVU_SCHEMA_MASTER).append(MS_USER_USERS_ON_USERS_USER_ID_POU_USER_ID);
	sb.append(SQL_INNER_JOIN);
	sb.append(Constant.PVU_SCHEMA_MASTER)
			.append(LK_POST_OFFICE_PO_ON_PO_LK_POST_OFFICE_ID_POU_LK_POST_OFFICE_ID_INNER_JOIN);
	sb.append(Constant.PVU_SCHEMA_MASTER).append(MS_POST_POST_ON_POST_POST_ID_PO_POST_ID);
	sb.append("WHERE prnt.T_PVU_TRN_EVNT_ID = :trnId AND prnt.PVU_EVENT_ID  = :eventId "
			+ "AND REPRINT_DATE IS NOT NULL AND prnt.ACTIVE_STATUS=1");
	return sb.toString();
}

	public static String queryPayValueByPayCommision() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT mpc1.PAY_LEVEL_ID , mpc1.CELL_ID , mpc1.CELL_VALUE ,mpc1.PAY_CELL_ID   ").append(" FROM   ")
				.append(Constant.PVU_SCHEMA_MASTER).append(".MS_PAY_CELL mpc1   ")
				.append(" WHERE mpc1.PAY_LEVEL_ID = :newPaylevelId AND mpc1.CELL_VALUE >=( SELECT  mpc.CELL_VALUE FROM MASTER_V1.MS_PAY_CELL mpc WHERE mpc.PAY_LEVEL_ID  =  :oldPaylevelId AND mpc.CELL_VALUE =  :cellValue ) ")
				.append("ORDER BY CELL_VALUE ASC LIMIT 1");
		return sb.toString();

	}
	
	public static String returnAcpList() {
		StringBuilder  sb = new StringBuilder();
		sb.append("SELECT events.T_EMP_EVNT_ID,ap.EVNT_EFF_DATE FROM PVU.T_EMP_EVENTS events INNER JOIN ");
		sb.append("pvu.T_PVU_AP_EVNT ap ");
		sb.append("ON ap.TRN_NO = EVENTS.TRN_NO AND ap.EMP_ID = EVENTS.EMP_ID ");
		sb.append("WHERE ap.ACP_TYPE = :acpType ");
		sb.append("AND events.ACTIVE_STATUS = 1 ");
        sb.append("AND ap.ACTIVE_STATUS = 1 ");
		sb.append("AND ap.EMP_ID = :empId ");
		sb.append("AND ap.STATUS_ID = 419");
		return sb.toString();
	}
	
	public static String isAllReadyGivenHPG() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EVNT.T_EMP_EVNT_ID,HP.EVNT_EFF_DATE FROM ");
		sb.append("PVU.T_EMP_EVENTS EVNT  INNER JOIN PVU.T_PVU_HP_EVNT HP ");
		sb.append("ON HP.TRN_NO = EVNT.TRN_NO AND HP.EMP_ID = EVNT.EMP_ID ");
		sb.append("WHERE HP.HP_SCALE_TYPE =:higherPayScaleType AND HP.ACTIVE_STATUS = 1 and evnt.active_status = 1 ");
		sb.append("AND HP.STATUS_ID = 419 AND HP.EMP_ID =:empId");
		return sb.toString();
	}
	
	public static String getUserDesgnationFromUserId() {
		StringBuilder  sb = new StringBuilder();
		sb.append(" SELECT (SELECT DESIGNATION_NAME FROM MASTER_V1.MS_DESIGNATION WHERE DESIGNATION_ID=dpt.DESIGNATION_ID )  ");
		sb.append(" FROM MASTER_V1.MS_USER mu ");
		sb.append(" INNER JOIN MASTER_V1.MS_EMPLOYEE me ON me.EMPLOYEE_NO =mu.USER_CODE ");
		sb.append(" INNER JOIN pvu.T_EMP_DPT_DTL dpt ON me.EMP_ID =dpt.EMP_ID  ");
		sb.append(" WHERE mu.USER_ID =:userId ");
		return sb.toString();
	}
	public static String getPayLevelRange() {
		StringBuilder  sb = new StringBuilder();
		sb.append("  SELECT A.C1||'-'||B.C2  FROM  ");
		sb.append("  (SELECT CL.CELL_VALUE C1  ");
		sb.append("  FROM MASTER_V1.MS_PAY_LEVEL PL ");
		sb.append("  INNER JOIN MASTER_V1.MS_PAY_CELL CL ON  CL.PAY_LEVEL_ID=PL.PAY_LEVEL_ID AND CL.CELL_ID ="+PvuConstant.CELL_ID_MIN  );
		sb.append("  WHERE PL.PAY_LEVEL_VALUE =:payLevelId ) A ");
		sb.append("  , ");
		sb.append("  (SELECT  CL.CELL_VALUE C2 ");
		sb.append("  FROM MASTER_V1.MS_PAY_LEVEL PL ");
		sb.append("  INNER JOIN MASTER_V1.MS_PAY_CELL CL ON  CL.PAY_LEVEL_ID=PL.PAY_LEVEL_ID AND CL.CELL_ID ="+PvuConstant.CELL_ID_MAX );
		sb.append("  WHERE PL.PAY_LEVEL_VALUE =:payLevelId )B ");
		return sb.toString();
	}
	public static String getPayInPayLevel() {
		StringBuilder  sb = new StringBuilder();
		sb.append(" SELECT CL.CELL_VALUE C1 ");
		sb.append(" FROM MASTER_V1.MS_PAY_LEVEL PL ");
		sb.append(" INNER JOIN MASTER_V1.MS_PAY_CELL CL ON  CL.PAY_LEVEL_ID=PL.PAY_LEVEL_ID AND CL.CELL_ID =:cellId");
		sb.append(" WHERE PL.PAY_LEVEL_VALUE =:payLevelId ");
		return sb.toString();
	}
	
	public static String getEmployeeApproverNameAndDesignation() {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT mu.USER_NAME,(SELECT DESIGNATION_NAME FROM MASTER_V1.MS_DESIGNATION WHERE DESIGNATION_ID=dpt.DESIGNATION_ID)\r\n"
						+ "FROM MASTER_V1.MS_USER mu \r\n"
						+ "INNER JOIN MASTER_V1.MS_EMPLOYEE me ON me.EMPLOYEE_NO =mu.USER_CODE INNER JOIN pvu.T_EMP_DPT_DTL dpt ON me.EMP_ID =dpt.EMP_ID  \r\n"
						+ "WHERE mu.USER_ID =(SELECT EMWF.UPDATED_BY FROM PVU.T_PVU_EMPCR_WF EMWF WHERE EMWF.TRN_ID = :trnId AND EMWF.ASSIGN_BY_WF_ROLE_ID = 3 \r\n"
						+ "ORDER BY EMWF.UPDATED_BY DESC LIMIT 1)");
		return sb.toString();
	}
	
	public static String getDeemedDateApproverRemarks() {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT EMWF.REMARKS FROM PVU.T_PVU_DD_WF EMWF WHERE EMWF.TRN_ID = :trnId AND EMWF.ASSIGN_BY_WF_ROLE_ID = 3 ORDER BY EMWF.UPDATED_BY DESC LIMIT 1");
		return sb.toString();
	}
	
	public static String getSteppingUpApproverRemarks() {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT EMWF.REMARKS FROM PVU.T_PVU_ST_WF EMWF WHERE EMWF.TRN_ID = :trnId AND EMWF.ASSIGN_BY_WF_ROLE_ID = 3 ORDER BY EMWF.UPDATED_BY DESC LIMIT 1");
		return sb.toString();
	}
	
	public static String getDDONameAndDesignationAndLocation() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT mu.USER_NAME,mo.OFFICE_NAME_DISP ,mo.ADDR_LINE_1,mo.ADDR_LINE_2 ,\r\n"
				+ "(SELECT DESIGNATION_NAME FROM MASTER_V1.MS_DESIGNATION WHERE DESIGNATION_ID=dpt.DESIGNATION_ID)\r\n"
				+ "FROM MASTER_V1.MS_USER mu INNER JOIN MASTER_V1.MS_EMPLOYEE me ON me.EMPLOYEE_NO =mu.USER_CODE \r\n"
				+ "INNER JOIN pvu.T_EMP_DPT_DTL dpt ON me.EMP_ID =dpt.EMP_ID \r\n"
				+ "LEFT JOIN MASTER_V1.MS_OFFICE mo ON me.OFFICE_ID=mo.OFFICE_ID WHERE mu.USER_ID =:userId");
		return sb.toString();
	}
	
	public static String getRopApprovedDate() {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT EMWF.UPDATED_DATE FROM PVU.T_PVU_RP_WF EMWF WHERE EMWF.TRN_ID = :trnId AND EMWF.ASSIGN_BY_WF_ROLE_ID = 3 ORDER BY EMWF.UPDATED_BY DESC LIMIT 1");
		return sb.toString();
	}
	
	public static String getEOLCommentsUserDetails() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT mu.USER_ID,mo.OFFICE_NAME_DISP,\r\n"
				+ "(SELECT DEPARTMENT_NAME  FROM MASTER_V1.MS_DEPARTMENT WHERE DEPARTMENT_ID=dpt.NAME_P_ADMIN_DEPT),(SELECT DESIGNATION_NAME FROM MASTER_V1.MS_DESIGNATION WHERE DESIGNATION_ID=dpt.DESIGNATION_ID),\r\n"
				+ "(SELECT WF_ROLE_NAME  FROM MASTER_V1.WF_WORKFLOW_ROLE WHERE WF_ROLE_ID  =ew.ASSIGN_BY_WF_ROLE_ID),\r\n"
				+ "ew.UPDATED_DATE,ew.REMARKS FROM PVU.T_PVU_EOL_WF ew INNER JOIN MASTER_V1.MS_USER mu ON mu.USER_ID=ew.ASSIGN_BY_USER_ID INNER JOIN MASTER_V1.MS_EMPLOYEE me ON me.EMPLOYEE_NO =mu.USER_CODE INNER JOIN pvu.T_EMP_DPT_DTL dpt ON me.EMP_ID =dpt.EMP_ID \r\n"
				+ "LEFT JOIN MASTER_V1.MS_OFFICE mo ON me.OFFICE_ID=mo.OFFICE_ID WHERE ew.TRN_ID=:trnId ORDER BY ew.T_PVU_EOL_WF_ID DESC");
		return sb.toString();
	}
	
	public static String getAvailableClassForEmp() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT LOOKUP_INFO_DESCRIPTION, LOOKUP_INFO_ID, LOOKUP_INFO_NAME FROM MASTER_V1.LU_LOOKUP_INFO lli WHERE ORDER_ID BETWEEN \r\n" + 
				"(SELECT ORDER_ID FROM  MASTER_V1.LU_LOOKUP_INFO lli WHERE LOOKUP_INFO_ID = (SELECT DISTINCT(EMP_CLASS) FROM pvu.T_EMP_EVENTS tee WHERE EMP_ID = :employeeId AND EVENT_ID = 1)) AND \r\n" + 
				"(SELECT ORDER_ID FROM  MASTER_V1.LU_LOOKUP_INFO lli WHERE LOOKUP_INFO_ID = (SELECT CLASS FROM PVU.T_EMP_DPT_DTL tedd WHERE EMP_ID = :employeeId))\r\n" + 
				"AND PARENT_LOOKUP_ID = 57");
		return sb.toString();	
	}
}
