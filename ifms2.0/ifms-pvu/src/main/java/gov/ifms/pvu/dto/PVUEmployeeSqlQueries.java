package gov.ifms.pvu.dto;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.util.Constant;

public class PVUEmployeeSqlQueries {  

	public static void getQuerieOfHistoryOfEmpDetails(IdDto idDtod ,StringBuilder sb) {
		sb.append(" SELECT itr.T_EMP_ITR_ID, itr.EMP_ID,mo.OFFICE_NAME,mu.USER_CODE, ").append(
				" CONCAT(CONCAT(CONCAT(CONCAT(CONCAT(CONCAT(PVU.GET_LOOKUP_INFO_VAL(itr.SALUTATION),' '),itr.employee_name),' '),	itr.MIDDLE_GUARDIAN_NAME),' '), itr.SURNAME)  AS EmployeeName  ,")
				.append(" PVU.GET_LOOKUP_INFO_VAL(itr.GENDER) AS GENDER, PVU.GET_LOOKUP_INFO_VAL(itr.NATIONALITY) AS NATIONALITY, ")
				.append(" itr.DOB ,itr.EMAIL_ID ,itr.MOBILE_NO ,itr.FATHER_NAME ,itr.MOTHER_NAME ,PVU.GET_LOOKUP_INFO_VAL(itr.MARITAL_STATUS) AS MARITAL_STATUS, ")
				.append(" PVU.GET_LOOKUP_INFO_VAL(itr.CATEGORY) AS CATEGORY,itr.RELIGION ,itr.CASTE ,PVU.GET_LOOKUP_INFO_VAL(itr.BLOOD_GROUP) AS BLOOD_GROUP, ")
				.append(" PVU.GET_LOOKUP_INFO_VAL(itr.DIVYANG_JT) AS DIVYANG_JT,PVU.GET_LOOKUP_INFO_VAL(itr.DIVYANG_SUB_CAT) AS DIVYANG_SUB_CAT ,itr.MED_FIT_CERT_DATE ,itr.ID_MARK ,itr.HEIGHT_CM , ")
				.append(" itr.ELECTION_CARD_NO ,itr.AADHAR_NO ,itr.PAN_NO ,itr.PASSPORT_NO ,itr.PASSPORT_EXP_DATE , ")
				.append(" itr.BUCKLE_NO ,mu.USER_NAME ,mp.POST_NAME,itr.UPDATED_DATE ,itr.CHANGE_TYPE ,OTHER_PH_CATEGORY ").append(Constant.SQL_FROM)
				.append(Constant.PVU_SCHEMA).append(".T_EMP_ITR itr ");
				getInnerJoinCommonDetails(idDtod,sb);
	}

	private static void getInnerJoinCommonDetails(IdDto idDtod,StringBuilder sb) {
		sb.append(Constant.SQL_INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
				.append(".ms_user mu ON itr.UPDATED_BY = mu.USER_ID ").append(Constant.SQL_INNER_JOIN)
				.append(Constant.PVU_SCHEMA_MASTER).append(".LK_PO_OFF_USER lpou ON mu.USER_ID = lpou.USER_ID ")
				.append(Constant.SQL_INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
				.append(".LK_POST_OFFICE lpo ON lpo.LK_POST_OFFICE_ID = lpou.LK_POST_OFFICE_ID ")
				.append(Constant.SQL_INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
				.append(".MS_POST mp ON mp.POST_ID = lpo.POST_ID ").append(Constant.SQL_INNER_JOIN)
				.append(Constant.PVU_SCHEMA_MASTER).append(".MS_OFFICE mo ON mo.OFFICE_ID = lpo.OFFICE_ID ")
				.append(" WHERE itr.EMP_ID = '" + idDtod.getId()  + "' AND itr.WF_ROLE_ID IN (3,80) ORDER BY  itr.UPDATED_DATE DESC ");
	}
	
	public static void getQuerieOfHistoryOfEmpCSSEXMOfDTLDetails(IdDto idDtod, StringBuilder sb) {
		sb.append(" SELECT itr.T_EMP_CCCEXM_ITR_ID , PVU.GET_LOOKUP_INFO_VAL(itr.EXAM_NAME) AS EXAM_NAME , ").append(
				" ( SELECT couse.COURSE_NAME FROM MASTER_V1.MS_COURSE couse WHERE couse.COURSE_ID = itr.EXAM_BODY) AS EXAM_BODY , ")
				.append(" itr.DATE_EXAM, itr.DATE_PASS_EXAM, PVU.GET_LOOKUP_INFO_VAL(itr.STATUS) AS STATUS, ")
				.append(" itr.NOTIFY_CERT_NO, itr.REMARK, itr.UPDATED_DATE, mu.USER_CODE , mu.USER_NAME , mp.POST_NAME,mo.OFFICE_NAME ,itr.CHANGE_TYPE ")
				.append(Constant.SQL_FROM).append(Constant.PVU_SCHEMA).append(".T_EMP_CCCEXM_DTL_ITR itr ");
		getInnerJoinCommonDetailsForTabelPopulateData(idDtod, sb);
	}

	public static void getQuerieOfHistoryOfEmpLagExamDetails(IdDto idDtod, StringBuilder sb) {
		sb.append(" SELECT itr.T_EMP_LNG_EXM_ITR_ID, PVU.GET_LOOKUP_INFO_VAL(itr.LANGUAGE) AS LANGUAG, ")
				.append(" itr.EXAM_BODY , PVU.GET_LOOKUP_INFO_VAL(itr.EXAM_TYPE) AS EXAM_TYPE , ")
				.append(" itr.DATE_PASS_EXAM, itr.SEAT_NO, PVU.GET_LOOKUP_INFO_VAL(itr.STATUS) AS STATUS, ")
				.append(" itr.REMARK, itr.UPDATED_DATE, mu.USER_CODE , mu.USER_NAME , mp.POST_NAME,mo.OFFICE_NAME ,itr.CHANGE_TYPE ")
				.append(Constant.SQL_FROM).append(Constant.PVU_SCHEMA).append(".T_EMP_LANG_EXAM_ITR itr ");
		getInnerJoinCommonDetailsForTabelPopulateData(idDtod, sb);
	}

	public static void getQuerieOfHistoryOfEmpNominiByEmpId(IdDto idDtod, StringBuilder sb) {
		sb.append(" SELECT itr.T_EMP_NOMI_DTL_ITR_ID, PVU.GET_LOOKUP_INFO_VAL(itr.RELATIONSHIP) AS RELATIONSHIP_Name, ")
		.append(" itr.NOMINEE_NAME, itr.NOMINEE_ADDR, itr.NOMINEE_AGE, itr.PERC_SHARE, ")
		.append(" mu.USER_CODE ,mu.USER_NAME , mp.POST_NAME,mo.OFFICE_NAME, itr.UPDATED_DATE ,itr.CHANGE_TYPE ,itr.OTHER_RELATIONSHIP,itr.RELATIONSHIP AS RELATIONSHIP_ID")
		.append(Constant.SQL_FROM).append(Constant.PVU_SCHEMA).append(".T_EMP_NOMI_DTL_ITR itr ");
		getInnerJoinCommonDetailsForTabelPopulateData(idDtod, sb);
	}

	public static void getQuerieOfHistoryOfEmpAddressByEmpId(IdDto idDtod, StringBuilder sb) {
		sb.append(" SELECT itr.T_EMP_ADDR_ITR_ID, itr.C_ADDR_LINE1, itr.C_ADDR_LINE2, ").append(
				" (SELECT cstat.STATE_NAME FROM MASTER_V1.MS_STATE cstat WHERE cstat.STATE_ID = itr.C_STATE_ID) AS C_STATE_ID, ")
				.append(" (SELECT cdis.DISTRICT_NAME  FROM MASTER_V1.MS_DISTRICT cdis WHERE cdis.DISTRICT_ID = itr.C_DISTRICT_ID) AS C_DISTRICT_ID, ")
				.append(" (SELECT ctal.TALUKA_NAME FROM MASTER_V1.MS_TALUKA ctal WHERE ctal.TALUKA_ID = itr.C_TALUKA_ID) AS C_TALUKA_ID, C_CITY, ")
				.append(" itr.C_PIN_CODE, PVU.GET_LOOKUP_INFO_VAL(itr.C_DIST_FROM_OFFICE) AS C_DIST_FROM_OFFICE , itr.P_ADDR_LINE1, itr.P_ADDR_LINE2, ")
				.append(" (SELECT pstat.STATE_NAME FROM MASTER_V1.MS_STATE pstat WHERE pstat.STATE_ID = itr.P_STATE_ID) AS P_STATE_ID, ")
				.append(" (SELECT pdis.DISTRICT_NAME  FROM MASTER_V1.MS_DISTRICT pdis WHERE pdis.DISTRICT_ID = itr.P_DISTRICT_ID) AS P_DISTRICT_ID,  ")
				.append(" (SELECT ptal.TALUKA_NAME FROM MASTER_V1.MS_TALUKA ptal WHERE ptal.TALUKA_ID = itr.P_TALUKA_ID) AS P_TALUKA_ID, ")
				.append(" itr.P_CITY, itr.P_PIN_CODE, itr.N_ADDR_LINE1,itr.N_ADDR_LINE2, ")
				.append(" (SELECT nstat.STATE_NAME FROM MASTER_V1.MS_STATE nstat WHERE nstat.STATE_ID = itr.N_STATE_ID) AS N_STATE_ID, ")
				.append(" (SELECT ndis.DISTRICT_NAME  FROM MASTER_V1.MS_DISTRICT ndis WHERE ndis.DISTRICT_ID = itr.N_DISTRICT_ID) AS N_DISTRICT_ID,  ")
				.append(" (SELECT ntal.TALUKA_NAME FROM MASTER_V1.MS_TALUKA ntal WHERE ntal.TALUKA_ID = itr.N_TALUKA_ID) AS N_TALUKA_ID, ")
				.append(" itr.N_CITY, itr.N_PIN_CODE, itr.UPDATED_DATE,mu.USER_CODE ,mu.USER_NAME ,mp.POST_NAME,mo.OFFICE_NAME ,itr.CHANGE_TYPE ")
				.append(Constant.SQL_FROM).append(Constant.PVU_SCHEMA).append(".T_EMP_ADDR_ITR itr ");
		getInnerJoinCommonDetails(idDtod, sb);
	}

	public static void getQuerieOfHistoryOfEmpDeptExamDetailsByEmpId(IdDto idDtod, StringBuilder sb) {
		sb.append(
				" SELECT itr.T_EMP_DPTEXM_ITR_ID, itr.DEPT_EXM_NAME, PVU.GET_LOOKUP_INFO_VAL(itr.EXAM_BODY) AS EXAM_BODY ,itr.DATE_EXM_PASS, ")
				.append(" PVU.GET_LOOKUP_INFO_VAL(itr.STATUS) as STATUS, itr.ATTEMPTS, itr.REMARK, itr.UPDATED_DATE, ")
				.append(" mu.USER_CODE ,mu.USER_NAME ,mp.POST_NAME,mo.OFFICE_NAME ,itr.CHANGE_TYPE ").append(Constant.SQL_FROM)
				.append(Constant.PVU_SCHEMA).append(".T_EMP_DPTEXM_DTL_ITR itr ");
		getInnerJoinCommonDetailsForTabelPopulateData(idDtod, sb);
	}

	public static void getQuerieOfHistoryOfEmpQulifictionByEmpId(IdDto idDtod, StringBuilder sb) {
		sb.append(" SELECT itr.T_EMP_QUALI_ITR_ID, ").append(
				" (SELECT couse.COURSE_NAME FROM MASTER_V1.MS_COURSE couse WHERE couse.COURSE_ID = itr.SCHOOL_DEGREE) AS SCHOOL_DEGREE, ")
				.append(" (SELECT cousr.COURSE_NAME FROM MASTER_V1.MS_COURSE cousr WHERE cousr.COURSE_ID = itr.COURSE_NAME) AS NEW_COURSE_NAME , ")
				.append(" (SELECT fy.FY_START FROM MASTER_V1.MS_FINANCIAL_YEAR fy WHERE fy.FINANCIAL_YEAR_ID = itr.YEAR_PASSING) AS YEAR_PASSING , itr.SCHOOL_COLLEGE, itr.UNVERSITY_BOARD, itr.PERC_CGPA,  ")
				.append(" itr.REMARKS, itr.UPDATED_DATE,mu.USER_CODE ,mu.USER_NAME ,mp.POST_NAME,mo.OFFICE_NAME ,itr.CHANGE_TYPE , itr.COURSE_NAME AS COURSE_Id ,itr.OTHER_COURSE_NAME ")
				.append(Constant.SQL_FROM).append(Constant.PVU_SCHEMA).append(".T_EMP_QUALI_ITR itr ");
		getInnerJoinCommonDetailsForTabelPopulateData(idDtod, sb);
	}

	public static void getQuerieOfHistoryOfEmpDepartmentByEmpId(IdDto idDtod, StringBuilder sb) {
		sb.append(
				" SELECT itr.T_EMP_DPT_DTL_ITR_ID, itr.DATE_JOINING, itr.RETIREMENT_DATE, ")
				.append(" PVU.GET_LOOKUP_INFO_VAL(itr.EMP_STATUS) AS EMP_STATUS, PVU.GET_LOOKUP_INFO_VAL(itr.EMP_PAY_TYPE) AS EMP_PAY_TYPE, ")
				.append(" (SELECT dg.DESIGNATION_NAME FROM MASTER_V1.MS_DESIGNATION dg WHERE dg.DESIGNATION_ID = itr.DESIGNATION_ID) AS DESIGNATION, ")
				.append(" (SELECT dis.DISTRICT_NAME FROM MASTER_V1.MS_DISTRICT dis WHERE dis.DISTRICT_ID = itr.DISTRICT_ID) AS DISTRICT,  ")
				.append(" (SELECT off.OFFICE_NAME FROM MASTER_V1.MS_OFFICE off WHERE off.OFFICE_ID = itr.NAME_PRESENT_OFFICE) AS NAME_PRESENT_OFFICE, ")
				.append(" itr.DDO_CODE, itr.OFF_ADD_CONT_NO,  PVU.GET_LOOKUP_INFO_VAL(itr.CLASS) AS CLASS, ")
				.append(" PVU.GET_LOOKUP_INFO_VAL(itr.EMP_TYPE) AS EMP_TYPE, ")
				.append(" (SELECT dcat.DEPT_CATEGORY_NAME FROM MASTER_V1.MS_DEPT_CATEGORY dcat WHERE dcat.DEPT_CATEGORY_ID = itr.DEPT_CAT) AS DEPT_CAT, ")
				.append(" itr.STATION, (SELECT tal.TALUKA_NAME FROM MASTER_V1.MS_TALUKA tal WHERE tal.TALUKA_ID = itr.TALUKA) AS TALUKA, ")
				.append(" (SELECT dept.DEPARTMENT_NAME FROM MASTER_V1.MS_DEPARTMENT dept WHERE dept.DEPARTMENT_ID = itr.NAME_P_ADMIN_DEPT) AS NAME_P_ADMIN_DEPT,  ")
				.append("  itr.GPF, itr.PRAN_ACCT_NO,itr.PPO_NO, itr.DATE_DEATH_TERM_NO ,itr.UPDATED_DATE,mu.USER_CODE, ")
				.append(" mu.USER_NAME ,mp.POST_NAME ,mo.OFFICE_NAME ,itr.CHANGE_TYPE ,itr.DEPUT_START_DATE,itr.DEPUT_END_DATE,itr.PPAN_NO, ")
				.append(" PVU.GET_LOOKUP_INFO_VAL(itr.IS_ON_DEPUTATION) as IS_ON_DEPUTATION,itr.DEPUT_DDO_CODE,itr.DEPUT_CARDEX_NO,")
				.append(" (SELECT doff.OFFICE_NAME FROM MASTER_V1.MS_OFFICE doff WHERE doff.OFFICE_ID = itr.DEPUT_NAME_PRESENT_OFFICE) AS DEPUT_NAME_PRESENT_OFFICE ,")
				.append(" (SELECT dupdis.DISTRICT_NAME FROM MASTER_V1.MS_DISTRICT dupdis WHERE dupdis.DISTRICT_ID = itr.DEPUT_DISTRICT_ID) AS DEPUT_DISTRICT_ID,")
				.append("itr.FIX_PAY_DATE as FIX_PROBATIONAL_JOIN_DATE")
				.append(Constant.SQL_FROM)
				.append(Constant.PVU_SCHEMA).append(".T_EMP_DPT_DTL_ITR itr ");
		getInnerJoinCommonDetails(idDtod, sb);
	}

	public static void getQuerieOfHistoryOfEmpPRVHistByEmpId(IdDto idDtod, StringBuilder sb) {
		sb.append(
				" SELECT (SELECT  lli.LOOKUP_INFO_NAME FROM MASTER_V1.LU_LOOKUP_INFO lli  WHERE LOOKUP_INFO_id = itr.EMPLOYMENT_TYPE AND ACTIVE_STATUS =  1) AS EMPLOYMENT_TYPE, ")
				.append(" itr.DEPT_NAME,itr.OFF_NAME,itr.OFF_ADD,itr.EMP_DSGN,itr.FROM_DATE,itr.TO_DATE,itr.LAST_PAY_DRWN, ")
				.append(" (SELECT  lli.LOOKUP_INFO_NAME FROM MASTER_V1.LU_LOOKUP_INFO lli  WHERE LOOKUP_INFO_id = itr.IS_SERV_CONT AND ACTIVE_STATUS =  1) AS IS_SERV_CONT, ")
				.append(" itr.UPDATED_DATE,mu.USER_CODE ,mu.USER_NAME , mp.POST_NAME ,mo.OFFICE_NAME ,itr.CHANGE_TYPE ,itr.ORDER_NO_DATE ")
				.append(Constant.SQL_FROM).append(Constant.PVU_SCHEMA).append(".T_EMP_PRV_HIST itr ");
		getInnerJoinCommonDetailsForTabelPopulateData(idDtod, sb);
	}

	public static void getOfficeNameByOfficeType(IdDto idDtod, StringBuilder sb) {
		sb.append(" SELECT ms.OFFICE_ID,ms.OFFICE_NAME ")
				.append(Constant.SQL_FROM).append(Constant.PVU_SCHEMA_MASTER).append(".MS_OFFICE ms WHERE ms.OFFICE_TYPE_ID =  '" + idDtod.getId()  + "' and ms.ACTIVE_STATUS = 1 ");
	}

	private static void getInnerJoinCommonDetailsForTabelPopulateData(IdDto idDtod,StringBuilder sb) {
		sb.append(Constant.SQL_INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
				.append(".ms_user mu ON itr.UPDATED_BY = mu.USER_ID ").append(Constant.SQL_INNER_JOIN)
				.append(Constant.PVU_SCHEMA_MASTER).append(".LK_PO_OFF_USER lpou ON mu.USER_ID = lpou.USER_ID ")
				.append(Constant.SQL_INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
				.append(".LK_POST_OFFICE lpo ON lpo.LK_POST_OFFICE_ID = lpou.LK_POST_OFFICE_ID ")
				.append(Constant.SQL_INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
				.append(".MS_POST mp ON mp.POST_ID = lpo.POST_ID ").append(Constant.SQL_INNER_JOIN)
				.append(Constant.PVU_SCHEMA_MASTER).append(".MS_OFFICE mo ON mo.OFFICE_ID = lpo.OFFICE_ID ")
				.append(" WHERE itr.EMP_ID = '" + idDtod.getId()  + "' AND itr.CHANGE_TYPE != 0 ORDER BY  itr.UPDATED_DATE DESC ");
	}

	public static void getOfficeDetailsByCardexAndDDOAndDId(long districtId, long dooNo , long cardexNo, StringBuilder sb) {
		sb.append(" SELECT ms.OFFICE_ID,ms.OFFICE_NAME ")
				.append(Constant.SQL_FROM).append(Constant.PVU_SCHEMA_MASTER)
				.append(".MS_OFFICE ms WHERE ms.DISTRICT_ID =  '" + districtId  + "' AND ms.DDO_NO = '" + dooNo  + "'  AND ms.CARDEX_NO = '" + cardexNo  +"'  and ms.ACTIVE_STATUS = 1 ");
	}

}
