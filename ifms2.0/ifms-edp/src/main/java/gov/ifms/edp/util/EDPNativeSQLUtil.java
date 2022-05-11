package gov.ifms.edp.util;

import java.util.Map;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPNativeSQLUtil.
 */
public class EDPNativeSQLUtil {

	/**
	 * Instantiates a new EDP native SQL util.
	 */
	private EDPNativeSQLUtil() {
		super();
	}

	/**
	 * Gets the emp and mobile by user code.
	 *
	 * @return the emp and mobile by user code
	 */
	public static final String getEmpAndMobileByUserCode() {
		return new StringBuilder(
				"SELECT emp.EMAIL_ID as c0, emp.MOBILE_NO as c1, Msuer.USER_ID as c2 , emp.EMPLOYEE_NO as c3  FROM ")
						.append(Constant.EDP_MASTER_SCHEMA).append(".MS_EMPLOYEE emp").append(" INNER JOIN ")
						.append(Constant.EDP_MASTER_SCHEMA).append(".LK_EMP_USER empuser")
						.append(" ON emp.EMP_ID  = EMPUSER.EMP_ID").append(" INNER JOIN ")
						.append(Constant.EDP_MASTER_SCHEMA).append(".MS_USER msuer")
						.append(" ON MSUER.USER_ID = EMPUSER.USER_ID").append(" WHERE Msuer.USER_CODE = :userCode")
						.toString();
	}

	/**
	 * Gets the designation post count.
	 *
	 * @return the designation post count
	 */
	public static final String getDesignationPostCount() {
		return new StringBuilder(
				"SELECT DISTINCT (DESGN.DESIGNATION_ID),DESGN.DESIGNATION_NAME,(SELECT COUNT(LPO.LK_POST_OFFICE_ID) FROM ")
						.append(Constant.EDP_MASTER_SCHEMA).append(".LK_POST_OFFICE lpo, ")
						.append(Constant.EDP_MASTER_SCHEMA).append(".MS_POST PST, ").append(Constant.EDP_MASTER_SCHEMA)
						.append(".MS_OFFICE OFF WHERE PST.POST_ID = LPO.POST_ID AND OFF.OFFICE_ID = LPO.OFFICE_ID AND DESGN.DESIGNATION_ID = PST.DESIGNATION_ID AND off.ACTIVE_STATUS = :isactive AND off.OFFICE_ID=:officeId) FROM ")
						.append(Constant.EDP_MASTER_SCHEMA)
						.append(".MS_DESIGNATION DESGN WHERE ACTIVE_STATUS = :isactive GROUP BY DESGN.DESIGNATION_ID, DESGN.DESIGNATION_NAME")
						.toString();
	}

	/**
	 * Gets the perissions by menu and post id.
	 *
	 * @return the perissions by menu and post id
	 */
	public static final String getPerissionsByMenuAndPostId() {

		StringBuilder sb = new StringBuilder();

		sb.append("SELECT ROLEPERMISSION.ROLE_PRM_ID  roleId,ROLEPERMISSION.ROLE_PRM_NAME AS roleName FROM ")
				.append(Constant.EDP_MASTER_SCHEMA).append(".MS_ROLE_PERMISSIONS rolepermission ");
		sb.append(Constant.SQL_INNER_JOIN).append(Constant.EDP_MASTER_SCHEMA).append(".T_USR_RG_MAP usrmap ");
		sb.append(" ON ROLEPERMISSION.P_ROLE_PRM_ID = USRMAP.TRN_USR_ROLE_PRM_ID ");
		sb.append(Constant.SQL_INNER_JOIN).append(Constant.EDP_MASTER_SCHEMA).append(".LK_PO_OFF_USER offusr ");
		sb.append(" ON OFFUSR.LK_PO_OFF_USER_ID = USRMAP.LK_PO_OFF_USER_ID  ");
		sb.append(Constant.SQL_INNER_JOIN).append(Constant.EDP_MASTER_SCHEMA).append(".MS_USER usr ");
		sb.append(" ON USR.USER_ID = OFFUSR.USER_ID   ");
		sb.append(Constant.SQL_INNER_JOIN).append(Constant.EDP_MASTER_SCHEMA).append(".LK_POST_OFFICE office ");
		sb.append(" ON office.LK_POST_OFFICE_ID = OFFUSR.LK_PO_OFF_USER_ID ");
		sb.append(Constant.SQL_INNER_JOIN).append(Constant.EDP_MASTER_SCHEMA).append(".MS_POST post ");
		sb.append(" ON post.POST_ID = office.POST_ID WHERE  post.POST_ID = :postId  ");

		return sb.toString();
	}

	/**
	 * Gets the user wf roles by post off user id.
	 *
	 * @param status the status
	 * @return the user wf roles by post off user id
	 */
	public static String getUserWfRolesByPostOffUserId(String status) {

		StringBuilder sb = new StringBuilder();

		sb.append(
				"SELECT	MENU.MENU_ID AS c0, ROLEPERM.WF_ROLE_ID AS c1, ROLEPERM.WF_ROLE_NAME AS c2, RGMAP.STATUS_ID AS c3, ");
		sb.append(
				"(SELECT lli2.LOOKUP_INFO_NAME FROM MASTER_V1.LU_LOOKUP_INFO lli2 WHERE rgmap.STATUS_ID = lli2.LOOKUP_INFO_ID)AS c4, ");
		sb.append(
				"menurole.IS_REMOVED AS IS_REMOVED, SUBMODULE.SUB_MODULE_ID AS SUB_MODULE , SUBMODULE.SUB_MODULE_NAME AS c5, MODULE.MODULE_ID AS c6 ,MODULE.MODULE_NAME AS c7 , ");
		sb.append("(SELECT emp.EMPLOYEE_NAME FROM MASTER_V1.MS_EMPLOYEE emp WHERE emp.EMP_ID = RGMAP.EMP_ID )AS c10, ");
		sb.append("(SELECT emp.EMPLOYEE_NO FROM MASTER_V1.MS_EMPLOYEE emp WHERE emp.EMP_ID = RGMAP.EMP_ID )AS c11, ");
		sb.append("post.POST_NAME AS c12,MENUROLE.T_USR_RG_MAP_ID as c13,MENUROLE.LK_USER_MENU_ID as c14, ");
		sb.append("(SELECT mu.USER_CODE FROM MASTER_V1.MS_USER AS mu WHERE mu.USER_ID = RGMAP.CREATED_BY) AS c15, ");
		sb.append(
				"( SELECT post.POST_NAME FROM MASTER_V1.MS_POST post WHERE	post.POST_ID = RGMAP.CREATED_BY_POST ) AS c16, ");
		sb.append(" RGMAP.CREATED_BY_POST AS c17 ");
		sb.append("FROM MASTER_V1.TRN_USR_MNU_WF_ROLE AS menurole INNER JOIN MASTER_V1.LK_USER_MENU usermenu ON ");
		sb.append(
				"USERMENU.LK_PO_OFF_USER_ID = :postOfficeUserId AND USERMENU.LK_USER_MENU_ID = MENUROLE.LK_USER_MENU_ID ");
		sb.append("INNER JOIN MASTER_V1.T_USR_RG_MAP rgmap ON RGMAP.T_USR_RG_MAP_ID = MENUROLE.T_USR_RG_MAP_ID ");
		sb.append("INNER JOIN MASTER_V1.WF_WORKFLOW_ROLE roleperm ON ROLEPERM.WF_ROLE_ID = menurole.WF_ROLE_ID ");
		sb.append("INNER JOIN MASTER_V1.LK_PO_OFF_USER pou ON RGMAP.LK_PO_OFF_USER_ID = pou.LK_PO_OFF_USER_ID ");
		sb.append("INNER JOIN MASTER_V1.LK_POST_OFFICE po ON pou.LK_POST_OFFICE_ID = po.LK_POST_OFFICE_ID ");
		sb.append("INNER JOIN MASTER_V1.MS_POST post ON post.POST_ID = po.POST_ID ");
		sb.append(
				"INNER JOIN MASTER_V1.MS_MENU menu ON MENU.MENU_ID = USERMENU.MENU_ID AND roleperm.WF_ROLE_ID = menurole.WF_ROLE_ID ");
		sb.append("LEFT JOIN MASTER_V1.MS_SUB_MODULE submodule ON MENU.SUB_MODULE_ID = SUBMODULE.SUB_MODULE_ID ");
		sb.append("LEFT JOIN MASTER_V1.MS_MODULE module ON MENU.MODULE_ID = MODULE.MODULE_ID ");
		sb.append(
				"WHERE roleperm.ACTIVE_STATUS = '1' AND menurole.ACTIVE_STATUS = '1' AND RGMAP.ACTIVE_STATUS = '1' AND pou.ACTIVE_STATUS = 1 ");
		sb.append(
				" AND MENU.ACTIVE_STATUS=1 AND usermenu.ACTIVE_STATUS=1 AND post.ACTIVE_STATUS=1 AND po.ACTIVE_STATUS=1 ");
		if (!status.isEmpty()) {
			sb.append(" AND menurole.IS_REMOVED=0 ");
			sb.append(
					" AND RGMAP.STATUS_ID = (SELECT lli.LOOKUP_INFO_ID FROM MASTER_V1.LU_LOOKUP_INFO lli WHERE lli.LOOKUP_INFO_NAME='"
							+ status + "') ");
		}
		sb.append(
				"GROUP BY MENU.MENU_ID , ROLEPERM.WF_ROLE_ID , ROLEPERM.WF_ROLE_NAME ,RGMAP.STATUS_ID , menurole.IS_REMOVED, RGMAP.EMP_ID, ");
		sb.append(
				"RGMAP.CREATED_BY, RGMAP.CREATED_BY_POST, post.POST_NAME, MODULE.MODULE_ID , MODULE.MODULE_NAME ,SUBMODULE.SUB_MODULE_ID,SUBMODULE.SUB_MODULE_NAME ,MENUROLE.LK_USER_MENU_ID,MENUROLE.T_USR_RG_MAP_ID ");
		return sb.toString();
	}

	/**
	 * Gets the user wf roles by post off user id for menu.
	 *
	 * @param isForMenu            the is for menu
	 * @return the user wf roles by post off user id for menu
	 */
	public static String getUserWfRolesByPostOffUserIdForMenu(Boolean isForMenu) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT MENU.MENU_ID AS c0, ROLEPERM.WF_ROLE_ID AS c1, ROLEPERM.WF_ROLE_NAME AS c2, ");
		sb.append("	RGMAP.STATUS_ID AS c3, ");
		sb.append(
				"(SELECT lli2.LOOKUP_INFO_NAME FROM MASTER_V1.LU_LOOKUP_INFO lli2	WHERE rgmap.STATUS_ID = lli2.LOOKUP_INFO_ID)AS c4, ");
		sb.append("	menurole.IS_REMOVED AS c5 ");
		sb.append(" FROM MASTER_V1.TRN_USR_MNU_WF_ROLE AS menurole INNER JOIN MASTER_V1.LK_USER_MENU usermenu ");
		sb.append(
				" ON USERMENU.LK_PO_OFF_USER_ID = :postOfficeUserId AND USERMENU.LK_USER_MENU_ID = MENUROLE.LK_USER_MENU_ID ");
		sb.append(" INNER JOIN MASTER_V1.T_USR_RG_MAP rgmap ON RGMAP.T_USR_RG_MAP_ID = MENUROLE.T_USR_RG_MAP_ID ");
		sb.append(" INNER JOIN MASTER_V1.WF_WORKFLOW_ROLE roleperm ON ROLEPERM.WF_ROLE_ID = menurole.WF_ROLE_ID ");
		sb.append(" INNER JOIN MASTER_V1.LK_PO_OFF_USER pou ON RGMAP.LK_PO_OFF_USER_ID = pou.LK_PO_OFF_USER_ID ");
		sb.append(
				" INNER JOIN MASTER_V1.MS_MENU menu ON MENU.MENU_ID = USERMENU.MENU_ID AND roleperm.WF_ROLE_ID = menurole.WF_ROLE_ID ");
		sb.append(
				" WHERE roleperm.ACTIVE_STATUS = '1' AND menurole.ACTIVE_STATUS = '1' AND RGMAP.ACTIVE_STATUS = '1' AND pou.ACTIVE_STATUS = 1 ");
		if (Boolean.TRUE.equals(isForMenu)) {
			sb.append(" AND MENU.MENU_ID = :menuId ");
		}
		sb.append(
				" GROUP BY MENU.MENU_ID ,	ROLEPERM.WF_ROLE_ID ,ROLEPERM.WF_ROLE_NAME ,RGMAP.STATUS_ID ,menurole.IS_REMOVED ");
		/** sb.append(" ORDER BY menurole.TRN_USR_WF_ROLE_ID DESC "); */
		return sb.toString();
	}

	/**
	 * Gets the saved user rights bypost office user id.
	 *
	 * @param isRequestForApproved the is request for approved
	 * @return the saved user rights bypost office user id
	 */
	// Saved User Rights
	public static String getSavedUserRightsBypostOfficeUserId(Boolean isRequestForApproved) {
		StringBuilder sb = new StringBuilder();

		sb.append(
				"SELECT roleperm.ROLE_PRM_ID  as c0 , ROLEPERM.ROLE_PRM_NAME as c1  , MENU.MENU_ID as c2 , MENU.MENU_NAME  as c3 , SUBMODULE.SUB_MODULE_ID  as c4 , SUBMODULE.SUB_MODULE_NAME as c5, ");
		sb.append(
				"MODULE.MODULE_ID  as c6 , MODULE.MODULE_NAME as c7 , RGMAP.STATUS_ID AS c8,menurole.IS_REMOVED AS c9 ,(SELECT emp.EMPLOYEE_NAME FROM MASTER_V1.MS_EMPLOYEE emp WHERE emp.EMP_ID =RGMAP.EMP_ID )AS c10,(SELECT emp.EMPLOYEE_NO FROM MASTER_V1.MS_EMPLOYEE emp WHERE emp.EMP_ID =RGMAP.EMP_ID )AS c11,post.POST_NAME AS c12,(SELECT lli2.LOOKUP_INFO_NAME FROM MASTER_V1.LU_LOOKUP_INFO lli2 WHERE rgmap.STATUS_ID=lli2.LOOKUP_INFO_ID)AS c13, ");
		sb.append(" (SELECT	mu.USER_CODE FROM MASTER_V1.MS_USER AS mu WHERE mu.USER_ID = RGMAP.CREATED_BY) AS c14, ");
		sb.append(
				" (SELECT post.POST_NAME FROM MASTER_V1.MS_POST post WHERE post.POST_ID = RGMAP.CREATED_BY_POST ) AS c15, ");
		sb.append(" RGMAP.CREATED_BY_POST AS c16 FROM ");
		sb.append(Constant.EDP_MASTER_SCHEMA).append(".TRN_USR_MNU_ROLE_PRM menurole ");
		sb.append(Constant.SQL_INNER_JOIN).append(Constant.EDP_MASTER_SCHEMA).append(
				".LK_USER_MENU usermenu ON USERMENU.LK_PO_OFF_USER_ID = :postOfficeUserId AND USERMENU.LK_USER_MENU_ID =MENUROLE.LK_USER_MENU_ID  ");
		sb.append(Constant.SQL_INNER_JOIN).append(Constant.EDP_MASTER_SCHEMA)
				.append(".T_USR_RG_MAP rgmap ON RGMAP.T_USR_RG_MAP_ID = MENUROLE.T_USR_RG_MAP_ID ");
		sb.append(Constant.SQL_INNER_JOIN).append(Constant.EDP_MASTER_SCHEMA)
				.append(".MS_ROLE_PERMISSIONS roleperm ON ROLEPERM.ROLE_PRM_ID = menurole.ROLE_PRM_ID ");
		sb.append("INNER JOIN MASTER_V1.LK_PO_OFF_USER pou ON RGMAP.LK_PO_OFF_USER_ID=pou.LK_PO_OFF_USER_ID ");
		sb.append(Constant.SQL_INNER_JOIN).append(Constant.EDP_MASTER_SCHEMA)
				.append(".LK_POST_OFFICE po ON pou.LK_POST_OFFICE_ID=po.LK_POST_OFFICE_ID ");
		sb.append(Constant.SQL_INNER_JOIN).append(Constant.EDP_MASTER_SCHEMA)
				.append(".MS_POST post ON post.POST_ID=po.POST_ID ");
		sb.append(Constant.SQL_INNER_JOIN).append(Constant.EDP_MASTER_SCHEMA).append(
				".MS_MENU menu  ON MENU.MENU_ID = USERMENU.MENU_ID AND  roleperm.ROLE_PRM_ID = menurole.ROLE_PRM_ID LEFT JOIN ");
		sb.append(Constant.EDP_MASTER_SCHEMA)
				.append(".MS_SUB_MODULE submodule ON MENU.SUB_MODULE_ID = SUBMODULE.SUB_MODULE_ID  LEFT JOIN ");
		sb.append(Constant.EDP_MASTER_SCHEMA).append(
				".MS_MODULE module ON  MENU.MODULE_ID = MODULE.MODULE_ID where roleperm.ACTIVE_STATUS = '1' AND menurole.ACTIVE_STATUS = '1' AND RGMAP.ACTIVE_STATUS = '1' ");
		if (Boolean.TRUE.equals(isRequestForApproved)) {
			sb.append(
					" AND RGMAP.STATUS_ID = (SELECT lli.LOOKUP_INFO_ID FROM MASTER_V1.LU_LOOKUP_INFO lli WHERE lli.LOOKUP_INFO_NAME='Saved as Draft') ");
			sb.append(" AND menurole.IS_REMOVED=0 ");
		}
		sb.append("AND post.ACTIVE_STATUS=1 AND pou.ACTIVE_STATUS=1 AND po.ACTIVE_STATUS=1 ");
		sb.append(" ORDER BY menurole.TRN_USR_ROLE_PRM_ID DESC");
		return sb.toString();
	}

	/**
	 * get post by menu and off id.
	 *
	 * @return post
	 */
	public static String getPostByMenuOffId() {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT emp.EMP_ID,emp.EMPLOYEE_NO,emp.EMPLOYEE_NAME,po.POST_ID,(SELECT post.POST_NAME FROM MASTER_V1.MS_POST post WHERE post.post_id = po.POST_ID and post.active_status = 1 ),(SELECT info.LOOKUP_INFO_NAME FROM MASTER_V1.LU_LOOKUP_INFO info WHERE info.LOOKUP_INFO_ID=usr.IS_PRIMARY_POST AND  info.active_status = 1 ) AS Post_type,LISTAGG(prm.ROLE_PRM_ID,',')WITHIN GROUP(ORDER BY prm.ROLE_PRM_ID ASC) AS ROLE_PRM_ID,LISTAGG(rper.ROLE_PRM_NAME,',') WITHIN GROUP(ORDER BY prm.ROLE_PRM_ID ASC) AS ROLE_PRM_NAME , ");
		sb.append(
				"(SELECT OFF.OFFICE_NAME FROM MASTER_V1.MS_OFFICE off  WHERE off.office_id = po.OFFICE_ID and off.active_status = 1),po.office_id,(SELECT menu.MENU_NAME FROM MASTER_V1.MS_MENU menu WHERE menu.MENU_ID = lkmenu.MENU_ID and menu.active_status = 1),rgmp.STATUS_ID   ");
		sb.append(" FROM  ").append(Constant.EDP_MASTER_SCHEMA).append(".TRN_USR_MNU_ROLE_PRM prm,")
				.append(Constant.EDP_MASTER_SCHEMA).append(".T_USR_RG_MAP rgmp,").append(Constant.EDP_MASTER_SCHEMA)
				.append(".LK_USER_MENU lkmenu ,").append(Constant.EDP_MASTER_SCHEMA).append(".LK_PO_OFF_USER usr,")
				.append(Constant.EDP_MASTER_SCHEMA).append(".LK_POST_OFFICE po,").append(Constant.EDP_MASTER_SCHEMA)
				.append(".MS_EMPLOYEE emp,").append(Constant.EDP_MASTER_SCHEMA).append(".MS_ROLE_PERMISSIONS rper,")
				.append(Constant.EDP_MASTER_SCHEMA).append(".LU_LOOKUP_INFO linfo")
				.append(" WHERE prm.T_USR_RG_MAP_ID = rgmp.T_USR_RG_MAP_ID AND lkmenu.LK_USER_MENU_ID = prm.LK_USER_MENU_ID AND lkmenu.LK_PO_OFF_USER_ID = usr.LK_PO_OFF_USER_ID")
				.append(" AND po.LK_POST_OFFICE_ID = usr.LK_POST_OFFICE_ID AND emp.emp_id = rgmp.emp_id  AND rper.ROLE_PRM_ID=prm.ROLE_PRM_ID AND LINFO.LOOKUP_INFO_ID=rgmp.STATUS_ID AND po.OFFICE_ID =:offId  AND  lkmenu.MENU_ID =:menuId AND linfo.LOOKUP_INFO_NAME='Approved' ")
				.append("AND prm.ACTIVE_STATUS=1 AND rgmp.ACTIVE_STATUS=1 AND LKMENU.ACTIVE_STATUS=1 AND usr.ACTIVE_STATUS=1 AND po.ACTIVE_STATUS=1 AND emp.ACTIVE_STATUS=1 AND rper.ACTIVE_STATUS=1 AND LINFO.ACTIVE_STATUS=1")
				.append(" GROUP BY  emp.EMPLOYEE_NO, emp.EMPLOYEE_NAME, po.office_id, lkmenu.MENU_ID, po.POST_ID, usr.IS_PRIMARY_POST, po.OFFICE_ID, emp.EMP_ID, po.POST_ID,rgmp.STATUS_ID ORDER BY usr.IS_PRIMARY_POST desc");
		return sb.toString();

	}

	/**
	 * Validate post and user.
	 *
	 * @return the string
	 */
	public static final String validatePostAndUser() {
		return new StringBuilder(
				"SELECT upt.TEDP_UPT_ID,post.POST_NAME,FROMUSR.USER_NAME old ,TOUSR.USER_NAME new FROM edp.TEDP_UPT_HDR header ")
						.append("INNER JOIN edp.TEDP_UPT upt ON upt.TEDP_UPT_HDR_ID=HEADER.TEDP_UPT_HDR_ID ")
						.append("LEFT JOIN MASTER_V1.LK_POST_OFFICE ofc ON ofc.LK_POST_OFFICE_ID=upt.LK_POST_OFFICE_ID ")
						.append("LEFT JOIN MASTER_V1.MS_POST post ON post.POST_ID=ofc.POST_ID  ")
						.append("LEFT JOIN MASTER_V1.MS_USER fromusr ON fromusr.USER_ID=upt.FROM_USER_ID  ")
						.append("LEFT JOIN MASTER_V1.MS_USER tousr ON   tousr.USER_ID=upt.TO_USER_ID  ")
						.append("LEFT JOIN (SELECT LOOKUP_INFO_ID,LOOKUP_INFO_NAME FROM MASTER_V1.LU_LOOKUP_INFO INFO ")
						.append("INNER JOIN MASTER_V1.LU_LOOKUP LOOKUP ON INFO.PARENT_LOOKUP_ID=LOOKUP.LOOKUP_ID) LK ON LK.LOOKUP_INFO_ID=HEADER.STATUS_ID ")
						.append("WHERE upt.ACTIVE_STATUS=1 AND LK.LOOKUP_INFO_NAME!='Submit' AND  LK.LOOKUP_INFO_NAME != 'Approved' AND (upt.LK_POST_OFFICE_ID=:postOfficeId OR   upt.FROM_USER_ID=:fromUserId OR UPT.TO_USER_ID=:fromUserId OR ")
						.append("upt.from_USER_ID=:toUserId OR UPT.TO_USER_ID=:toUserId ) And upt.TEDP_UPT_HDR_ID != :headerId ORDER BY upt.TEDP_UPT_ID desc ")
						.toString();
	}

	/**
	 * Gets the wf by menu id.
	 *
	 * @return the wf by menu id
	 */
	public static final String getWfByMenuId() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT mw.LK_MNU_WFROLE_ID, mw.MENU_ID, mw.WF_ROLE_ID,");
		sb.append(" wmw.WF_ROLE_NAME AS WF_NAME FROM ");
		sb.append(Constant.EDP_MASTER_SCHEMA).append(".LK_MENU_WFROLE mw ");
		sb.append(Constant.SQL_INNER_JOIN);
		sb.append(Constant.EDP_MASTER_SCHEMA).append(".WF_WORKFLOW_ROLE wmw ");
		sb.append("ON mw.WF_ROLE_ID=wmw.WF_ROLE_ID");
		sb.append(" AND mw.MENU_OFFICE_TYPE_ID=:menuOfficeTypeId AND mw.ACTIVE_STATUS=1");
		return sb.toString();
	}

	/**
	 * Gets the wf role and id by lk usr menu and rg map id.
	 *
	 * @param paramMap the param map
	 * @return the wf role and id by lk usr menu and rg map id
	 */
	public static final String getWfRoleAndIdByLkUsrMenuAndRgMapId(Map<String, Object> paramMap) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT TUMWR.LK_USER_MENU_ID AS LK_USER_MENU_ID, ");
		sb.append("LISTAGG(tumwr.WF_ROLE_ID,',') WITHIN GROUP (ORDER BY tumwr.WF_ROLE_ID) AS WF_ROLE_ID, ");
		sb.append("LISTAGG(wwr.WF_ROLE_NAME,',') AS WF_ROLE_NAME, ");
		sb.append(
				"LISTAGG(tumwr.TRN_USR_WF_ROLE_ID,',') WITHIN GROUP (ORDER BY tumwr.TRN_USR_WF_ROLE_ID) AS TRN_USR_WF_ROLE_ID ");
		sb.append(" FROM MASTER_V1.TRN_USR_MNU_WF_ROLE AS tumwr, MASTER_V1.WF_WORKFLOW_ROLE AS wwr WHERE ");
		sb.append("	tumwr.T_USR_RG_MAP_ID = :" + Constant.IN_USR_RGMAP_ID);
		sb.append(" AND WWR.WF_ROLE_ID = TUMWR.WF_ROLE_ID AND tumwr.ACTIVE_STATUS = 1 ");
		if (paramMap.containsKey(EDPConstant.IS_REMOVED)) {
			sb.append("AND TUMWR.IS_REMOVED = :" + EDPConstant.IS_REMOVED);
		}
		sb.append(" GROUP BY TUMWR.LK_USER_MENU_ID");
		return sb.toString();
	}

	/**
	 * get post by menu and off id.
	 *
	 * @return post
	 */
	public static String getWfByMenuOffId() {
		StringBuilder sb = new StringBuilder();
		sb.append(
				" SELECT emp.EMPLOYEE_NO,LISTAGG(prm.WF_ROLE_ID, ','),LISTAGG(rper.WF_ROLE_NAME, ','),po.POST_ID,po.office_id, ");
		sb.append(
				" (SELECT menu.MENU_NAME FROM MASTER_V1.MS_MENU menu WHERE menu.MENU_ID = lkmenu.MENU_ID AND menu.active_status = 1), rgmp.STATUS_ID ");
		sb.append(" FROM  ").append(Constant.EDP_MASTER_SCHEMA).append(".TRN_USR_MNU_WF_ROLE prm,")
				.append(Constant.EDP_MASTER_SCHEMA).append(".T_USR_RG_MAP rgmp,").append(Constant.EDP_MASTER_SCHEMA)
				.append(".LK_USER_MENU lkmenu ,").append(Constant.EDP_MASTER_SCHEMA).append(".LK_PO_OFF_USER usr,")
				.append(Constant.EDP_MASTER_SCHEMA).append(".LK_POST_OFFICE po,").append(Constant.EDP_MASTER_SCHEMA)
				.append(".MS_EMPLOYEE emp,").append(Constant.EDP_MASTER_SCHEMA).append(".WF_WORKFLOW_ROLE rper,")
				.append(Constant.EDP_MASTER_SCHEMA).append(".LU_LOOKUP_INFO linfo")
				.append(" WHERE prm.T_USR_RG_MAP_ID = rgmp.T_USR_RG_MAP_ID AND lkmenu.LK_USER_MENU_ID = prm.LK_USER_MENU_ID AND lkmenu.LK_PO_OFF_USER_ID = usr.LK_PO_OFF_USER_ID ")
				.append(" AND po.LK_POST_OFFICE_ID = usr.LK_POST_OFFICE_ID AND emp.emp_id = rgmp.emp_id AND rper.WF_ROLE_ID = prm.WF_ROLE_ID AND LINFO.LOOKUP_INFO_ID = rgmp.STATUS_ID AND po.OFFICE_ID =:offId AND lkmenu.MENU_ID =:menuId AND linfo.LOOKUP_INFO_NAME = 'Approved'  ")
				.append("AND prm.ACTIVE_STATUS=1 AND rgmp.ACTIVE_STATUS=1 AND LKMENU.ACTIVE_STATUS=1 AND usr.ACTIVE_STATUS=1 AND po.ACTIVE_STATUS=1 AND emp.ACTIVE_STATUS=1 AND rper.ACTIVE_STATUS=1 AND LINFO.ACTIVE_STATUS=1 ")
				.append(" GROUP BY  emp.EMPLOYEE_NO, emp.EMPLOYEE_NAME, po.office_id,lkmenu.MENU_ID, po.POST_ID,usr.IS_PRIMARY_POST,po.OFFICE_ID,emp.EMP_ID,po.POST_ID,rgmp.STATUS_ID ");
		return sb.toString();

	}

	/**
	 * Gets the office attachment SQL.
	 *
	 * @return the office attachment SQL
	 */
	public static String getOfficeAttachmentSQL() {
		return new StringBuilder("SELECT att.ATTACHMENT_NAME,  oa.FILE_NAME,  oa.UPLOADED_FILE_NAME,  oa.UPLOADED_BY, ")
				.append("oa.T_EDP_OFF_ATTACH_ID, oa.MS_EDP_S_OFF_ID,  ")
				.append(" oa.created_by, oa.created_by_post, oa.created_date, oa.updated_by, oa.updated_by_post, ")
				.append("oa.updated_date, oa.role_prm_id, oa.version_id,oa.UPLOADED_FILE_PATH,oa.ATTACHMENT_ID  FROM ")
				.append(Constant.EDP_MASTER_SCHEMA).append(".MS_ATTACHMENTS att LEFT OUTER JOIN ")
				.append(Constant.EDP_SCHEMA).append(".T_EDP_OFF_ATTACH oa ")
				.append(" ON att.ATTACHMENT_ID=oa.ATTACHMENT_ID AND oa.MS_EDP_S_OFF_ID = :officeId ")
				.append(" WHERE  att.ATTACHMENT_TYPE = :attachmentType ").toString();
	}

	/**
	 * Gets the post attachment SQL.
	 *
	 * @return the post attachment SQL
	 */
	public static String getPostAttachmentSQL() {
		return new StringBuilder("SELECT att.ATTACHMENT_NAME,  oa.FILE_NAME,  oa.UPLOADED_FILE_NAME,  oa.UPLOADED_BY, ")
				.append("oa.T_EDP_PO_ATTACH_ID, oa.POST_ID,  ")
				.append(" oa.created_by, oa.created_by_post, oa.created_date, oa.updated_by, oa.updated_by_post, ")
				.append("oa.updated_date, oa.WORKFLOW_ID, oa.version_id,oa.UPLOADED_FILE_PATH,oa.ATTACHMENT_ID, oa.WORKFLOW_ROLE_ID FROM ")
				.append(Constant.EDP_MASTER_SCHEMA).append(".MS_ATTACHMENTS att LEFT OUTER JOIN ")
				.append(Constant.EDP_SCHEMA).append(".T_EDP_PO_ATTACH oa ")
				.append(" ON att.ATTACHMENT_ID=oa.ATTACHMENT_ID AND oa.POST_ID = :postId ")
				.append(" WHERE  att.ATTACHMENT_TYPE = :attachmentType ").toString();
	}

	/**
	 * Gets the department by post id.
	 *
	 * @return the department by post id
	 */
	public static String getDepartmentByPostId() {
		return new StringBuilder("SELECT dept.DEPARTMENT_ID, dept.DEPARTMENT_NAME FROM MASTER_V1.MS_DEPARTMENT dept ")
				.append("INNER JOIN MASTER_V1.MS_OFFICE off ON off.DEPARTMENT_ID=dept.DEPARTMENT_ID ")
				.append("INNER JOIN MASTER_V1.LK_POST_OFFICE po ON po.OFFICE_ID=off.OFFICE_ID ")
				.append("INNER JOIN MASTER_V1.LK_PO_OFF_USER pou ON pou.LK_POST_OFFICE_ID=po.LK_POST_OFFICE_ID ")
				.append("INNER JOIN MASTER_V1.MS_POST p ON po.POST_ID=p.POST_ID ")
				.append("WHERE po.POST_ID=:postId AND dept.ACTIVE_STATUS=1 AND ")
				.append("off.ACTIVE_STATUS=1 AND po.ACTIVE_STATUS=1 AND pou.ACTIVE_STATUS=1 AND p.ACTIVE_STATUS=1")
				.toString();
	}

	/** The Constant GET_USERNAME_POST_OFFICE_FROM_LKPOU_ID. */
	public static final String GET_USERNAME_POST_OFFICE_FROM_LKPOU_ID = "SELECT  EMP.EMPLOYEE_NO, upper( EDP.GET_LOOKUP_INFO_VAL(EMP.SALUTATION)||' '||EMP.EMPLOYEE_NAME||' '||EMP.MIDDLE_GUARDIAN_NAME||' '||EMP.SURNAME), "
			+ "MP.POST_NAME, MO.OFFICE_NAME_DISP, MD.DISTRICT_NAME ,  MO.DDO_NO, MO.CARDEX_NO FROM MASTER_V1.LK_PO_OFF_USER LPOU,MASTER_V1.MS_POST MP,MASTER_V1.MS_EMPLOYEE emp ,MASTER_V1.MS_OFFICE MO, MASTER_V1.LK_POST_OFFICE LPO, MASTER_V1.MS_USER mu, MASTER_V1.MS_DISTRICT md "
			+ "WHERE LPOU.USER_ID = mu.USER_ID AND mu.USER_CODE = emp.EMPLOYEE_NO "
			+ "AND LPOU.LK_POST_OFFICE_ID = LPO.LK_POST_OFFICE_ID AND LPO.OFFICE_ID = MO.OFFICE_ID AND MO.DISTRICT_ID = MD.DISTRICT_ID "
			+ "AND LPO.POST_ID = MP.POST_ID AND LPOU.LK_PO_OFF_USER_ID = :lkPouId";

	/** The Constant GET_EMPS_FOR_OFFICE. */
	public static final String GET_EMPS_FOR_OFFICE = "SELECT emp.EMP_ID,EMP.EMPLOYEE_NO, upper( EDP.GET_LOOKUP_INFO_VAL(EMP.SALUTATION)||' '||EMP.EMPLOYEE_NAME||' '||EMP.MIDDLE_GUARDIAN_NAME||' '||EMP.SURNAME)  FROM MASTER_V1.MS_EMPLOYEE EMP WHERE EMP.ACTIVE_STATUS = 1 AND EMP.EMPLOYEE_NO IN (:userId)";

	/**
	 * Gets the modules for office type.
	 *
	 * @param officeTypeId     the office type id
	 * @param officeCategoryId the office category id
	 * @return the modules for office type
	 */
	public static final String getModulesForOfficeType(Long officeTypeId, Long officeCategoryId) {

		StringBuilder moduleString = new StringBuilder();
		moduleString.append(
				"SELECT lmot.LK_MOD_OFF_TYPE_ID, lmot.MODULE_ID, mm.MODULE_DISP_NAME FROM MASTER_V1.LK_MOD_OFFICE_TYPE lmot, MASTER_V1.MS_MODULE mm ");
		moduleString.append("WHERE lmot.MODULE_ID = mm.MODULE_ID AND lmot.OFFICE_TYPE_ID = " + officeTypeId
				+ " AND lmot.ACTIVE_STATUS = 1 ");
		if (officeCategoryId > 0) {
			moduleString.append("AND lmot.OFFICE_CATEGORY_ID =" + officeCategoryId);
		} else {
			moduleString.append("AND lmot.OFFICE_CATEGORY_ID IS null");
		}
		return moduleString.toString();
	}

	/** The Constant GET_SUBMODULE_FROM_ID. */
	public static final String GET_SUBMODULE_FROM_ID = "SELECT SUB_MODULE_ID, SUB_MODULE_DISP_NAME FROM MASTER_V1.MS_SUB_MODULE WHERE SUB_MODULE_ID in (:subModuleId)";

	/** The Constant GET_MENU_FROM_ID. */
	public static final String GET_MENU_FROM_ID = "SELECT lsmot.menu_id, mm.MENU_NAME, lsmot.LK_MNU_OFF_TYPE_ID FROM MASTER_V1.LK_SUB_MNU_OFF_TYPE lsmot, MASTER_V1.MS_MENU mm  WHERE lsmot.MOD_OFF_TYPE_ID = :modOffTypeId AND lsmot.MENU_ID = mm.MENU_ID  AND lsmot.ACTIVE_STATUS = 1";

	/** The Constant GET_MENU_FROM_ID_AND_SUBMODULE. */
	public static final String GET_MENU_FROM_ID_AND_SUBMODULE = "SELECT lsmot.menu_id, mm.MENU_NAME, lsmot.LK_MNU_OFF_TYPE_ID FROM MASTER_V1.LK_SUB_MNU_OFF_TYPE lsmot, MASTER_V1.MS_MENU mm  WHERE lsmot.MOD_OFF_TYPE_ID = :modOffTypeId AND lsmot.SUB_MODULE_ID =:subModuleId AND lsmot.MENU_ID = mm.MENU_ID AND lsmot.ACTIVE_STATUS = 1 ORDER BY lsmot.MENU_ID ";

	/** The Constant CHECK_REQUEST_RIGHTS_MAPPING_WITH_STATUS. */
	public static final String CHECK_REQUEST_RIGHTS_MAPPING_WITH_STATUS = "SELECT me.EMPLOYEE_NO,TURM.UPDATED_BY, mu.USER_CODE FROM  "
			+ "EDP.T_USR_RG_MAP turm, MASTER_V1.MS_EMPLOYEE me, MASTER_V1.LK_PO_OFF_USER lpou, MASTER_V1.MS_USER mu  "
			+ "WHERE turm.LK_PO_OFF_USER_ID = :postOfficeUserId AND turm.STATUS_ID = :statusId AND TURM.ACTIVE_STATUS = 1 AND turm.EMP_ID = me.EMP_ID "
			+ "AND turm.UPDATED_BY_POST = LPOU.LK_PO_OFF_USER_ID AND lpou.USER_ID = mu.USER_ID";

	/** The Constant GET_EMPLOYEE_INFO_FOR_LOGIN_BY_USER_CODE. */
	public static final String GET_EMPLOYEE_INFO_FOR_LOGIN_BY_USER_CODE = "SELECT (SELECT lli.LOOKUP_INFO_NAME FROM MASTER_V1.LU_LOOKUP_INFO lli WHERE lli.LOOKUP_INFO_ID = me.SALUTATION ), "
			+ "me.EMPLOYEE_NAME, me.MIDDLE_GUARDIAN_NAME, me.SURNAME, me.EMAIL_ID, me.MOBILE_NO, me.PAN_NO "
			+ "FROM MASTER_V1.MS_EMPLOYEE me WHERE me.EMPLOYEE_NO = :userCode ";

	/**
	 * Gets the modules for office type.
	 *
	 * @return the modules for office type
	 */
	public static final String getModulesForDatOfficeType() {
		StringBuilder moduleString = new StringBuilder();
		moduleString.append(
				"SELECT lmot.LK_MOD_OFF_TYPE_ID, lmot.MODULE_ID, mm.MODULE_NAME FROM MASTER_V1.LK_MOD_OFFICE_TYPE lmot, MASTER_V1.MS_MODULE mm ");
		moduleString.append("WHERE lmot.MODULE_ID = mm.MODULE_ID AND lmot.LK_MOD_OFF_TYPE_ID = 2");
		return moduleString.toString();
	}

	/** The Constant GET_EMP_PHOTO_BY_EMPNO. */
	public static final String GET_EMP_PHOTO_BY_EMPNO = "SELECT  me.EMPLOYEE_PHOTO,me.EMP_PHOTO_NAME FROM  MASTER_V1.MS_EMPLOYEE me WHERE me.EMPLOYEE_NO = :empNo";

	/** The Constant GET_WFROLES_BY_MENU_OFF_TYPE. */
	public static final String GET_WFROLES_BY_MENU_OFF_TYPE = "SELECT * FROM MASTER_V1.LK_MENU_WFROLE WHERE MENU_OFFICE_TYPE_ID = :menuOfficeTypeId";

	/** The Constant GET_WFROLES_FOR_OFFICE_USER_AND_MENU. */
	public static final String GET_WFROLES_FOR_OFFICE_USER_AND_MENU = "SELECT WF_ROLE_NAME FROM master_v1.TRN_USR_MNU_WF_ROLE tumwr, MASTER_V1.LK_USER_MENU lum, master_v1.WF_WORKFLOW_ROLE wwr, MASTER_V1.LK_POST_OFFICE lpo, MASTER_V1.LK_PO_OFF_USER lpou "
			+ "WHERE lpo.OFFICE_ID = :officeId AND LUM.MENU_ID = :menuId AND lpou.USER_ID = :userId AND "
			+ "tumwr.LK_USER_MENU_ID = LUM.LK_USER_MENU_ID " + "AND tumwr.WF_ROLE_ID = wwr.WF_ROLE_ID AND "
			+ "lum.LK_PO_OFF_USER_ID  = lpou.LK_PO_OFF_USER_ID AND "
			+ "lpou.LK_POST_OFFICE_ID = lpo.LK_POST_OFFICE_ID  " 
			+ "AND TUMWR.ACTIVE_STATUS = 1 AND lum.ACTIVE_STATUS = 1 AND wwr.ACTIVE_STATUS = 1 AND lpo.ACTIVE_STATUS = 1 AND lpou.ACTIVE_STATUS = 1";

	/** The Constant GET_WF_TABLE_FOR_MENU. */
	public static final String GET_WF_TABLE_FOR_MENU = "SELECT lmti.TRN_WF_TBL_NAME FROM MASTER_V1.LK_MENU_TBL_INFO lmti WHERE MENU_ID = :menuId";

	/**
	 * Gets the assign by office for wf.
	 *
	 * @param tableName the table name
	 * @return the assign by office for wf
	 */
	public static final String getAssignByOfficeForWf(String tableName) {
		StringBuilder moduleString = new StringBuilder();
		moduleString.append("SELECT ASSIGN_BY_OFFICE_ID FROM ");
		moduleString.append(Constant.EDP_SCHEMA).append(Constant.DOT).append(tableName);
		moduleString.append(" WHERE TRN_ID = :trnId");
		moduleString.append(" AND CREATED_DATE = (SELECT min(CREATED_DATE) from ");
		moduleString.append(Constant.EDP_SCHEMA).append(Constant.DOT).append(tableName);
		moduleString.append(" WHERE TRN_ID = :trnId");
		moduleString.append(")");
		return moduleString.toString();
	}

	/** The Constant SELECT_QUERY. */
	public static final String SELECT_QUERY = "SELECT config.FROM_STATUS,config.TO_STATUS,config.FROM_WF_STATUS,config.TO_WF_STATUS ";

	/** The Constant GET_EDP_WF_TRN_STATUS_QUERY. */
	public static final String GET_EDP_WF_TRN_STATUS_QUERY = SELECT_QUERY + "FROM MASTER_V1.WF_ACTION_CONFIG config WHERE config.MENU_ID = 35";
	
	/** The Constant GET_EDP_WF_TRN_STATUS_BY_MENU_ID_QUERY. */
	public static final String GET_EDP_WF_TRN_STATUS_BY_MENU_ID_QUERY = SELECT_QUERY + "FROM MASTER_V1.WF_ACTION_CONFIG config WHERE config.MENU_ID = :menuId";
	
	/**
	 * Gets the office attachment.
	 *
	 * @param attchTblName the attch tbl name
	 * @return the office attachment
	 */
	public static final String getOfficeAttachment(String attchTblName) {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT attch.*,EDP.GET_LOOKUP_INFO_VAL(me.SALUTATION) ||' '||me.EMPLOYEE_NAME ||' '||me.MIDDLE_GUARDIAN_NAME ||' '||me.SURNAME FROM EDP.").append(attchTblName).append(" attch INNER JOIN ");
		sb.append("MASTER_V1.MS_USER mu ON ");
		sb.append("mu.USER_ID =attch.CREATED_BY INNER JOIN ");
		sb.append("MASTER_V1.MS_EMPLOYEE me ON ");
		sb.append("me.EMPLOYEE_NO =mu.USER_CODE ");
		sb.append("WHERE attch.OFFICE_ID =:officeId ");
		sb.append(
				"AND attch.ACTIVE_STATUS =1 AND mu.ACTIVE_STATUS =1  AND me.ACTIVE_STATUS =1 ");
		return sb.toString();

	}
	
	
	/** The Constant GET_LEVEL_FOR_UPD_WF. */
	public static final String GET_LEVEL_FOR_UPD_WF = "SELECT teudw.level FROM EDP.T_EDP_UPD_DSGN_WF teudw WHERE teudw.TRN_ID = :trnId AND teudw.ACTIVE_STATUS = 1";

	/**
	 * Gets the office itr attachment.
	 *
	 * @return the office itr attachment
	 */
	public static String getOfficeItrAttachment() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT atchItr.*, ");
		sb.append("EDP.GET_LOOKUP_INFO_VAL(emp.salutation) ||' '|| emp.employee_name ||' '|| emp.middle_guardian_name ||' '|| emp.surname ");
		sb.append("FROM EDP.T_EDP_OFF_ATTACH_ITR atchItr INNER JOIN ");
		sb.append("MASTER_V1.MS_USER mu ON ");
		sb.append("mu.user_id = atchItr.created_by INNER JOIN ");
		sb.append("MASTER_V1.MS_EMPLOYEE emp ON ");
		sb.append("emp.employee_no = mu.user_code ");
		sb.append("WHERE atchItr.t_edp_upd_off_trn_id = :officeTrnId ");
		sb.append("AND atchItr.active_status =1 AND mu.active_status = 1 AND emp.active_status = 1");

		return sb.toString();
	}
	
	/** The Constant GET_BRANCH_BRANCHTYPE_BY_OFFICE_ID. */
	public static final String GET_BRANCH_BRANCHTYPE_BY_OFFICE_ID ="SELECT mb.BRANCH_NAME,lu.LOOKUP_INFO_ID,lu.LOOKUP_INFO_NAME,mb.BRANCH_ID FROM MASTER_V1.MS_BRANCH mb,MASTER_V1.LU_LOOKUP_INFO lu " + 
			"WHERE mb.ACTIVE_STATUS = :activeStatus AND lu.ACTIVE_STATUS = :activeStatus AND mb.BRANCH_TYPE_ID = lu.LOOKUP_INFO_ID AND mb.OFFICE_ID = :officeId";

	/** The Constant GET_BRANCH_NAME_FROM_DTL. */
	public static final String GET_BRANCH_NAME_FROM_DTL = "SELECT dtl.TEDP_BR_CR_DTL_ID,dtl.BRANCH_NAME,dtl.BRANCH_TYPE_ID,dtl.OFFICE_ID,hdr.TEDP_BR_HDR_ID FROM EDP.TEDP_BR_HDR hdr , EDP.TEDP_BR_CR_DTL dtl " + 
			"WHERE hdr.STATUS_ID = :statusId AND dtl.ACTIVE_STATUS = :activeStatus AND hdr.ACTIVE_STATUS = :activeStatus AND dtl.OFFICE_ID = :officeId " + 
			"AND dtl.BRANCH_NAME = :branchName AND hdr.REQUEST_TYPE= :requestType  AND hdr.TEDP_BR_HDR_ID = dtl.TEDP_BR_HDR_ID";

	/** The Constant GET_LEVEL_FOR_POST_WF. */
	public static final String GET_LEVEL_FOR_POST_WF = "SELECT teudw.level FROM EDP.T_EDP_POST_WF teudw WHERE teudw.TRN_ID = :trnId AND teudw.ACTIVE_STATUS = 1";

	/** The Constant GET_LEVEL_FOR_DSGN_WF. */
	public static final String GET_LEVEL_FOR_DSGN_WF = "SELECT teudw.level FROM EDP.T_EDP_DESIGNATION_WF teudw WHERE teudw.TRN_ID = :trnId AND teudw.ACTIVE_STATUS = 1";
	
	/** The Constant GET_ALL_USER_CODE_BY_OFFICE_ID. */
	public static final String GET_ALL_USER_CODE_BY_OFFICE_ID = "SELECT mu.USER_CODE FROM MASTER_V1.MS_USER mu ,MASTER_V1.LK_PO_OFF_USER lpou , MASTER_V1.LK_POST_OFFICE lpo " + 
			"WHERE lpo.LK_POST_OFFICE_ID = LPOU.LK_POST_OFFICE_ID AND LPOU.USER_ID = mu.USER_ID AND lpo.OFFICE_ID = :officeId " + 
			"AND lpo.ACTIVE_STATUS = :activeStatus AND lpou.ACTIVE_STATUS = :activeStatus AND mu.ACTIVE_STATUS = :activeStatus";

	/** The Constant GET_OFFICE_EMPS. */
	public static final String GET_OFFICE_EMPS = "SELECT emp.EMP_ID,EMP.EMPLOYEE_NO, upper( EDP.GET_LOOKUP_INFO_VAL(EMP.SALUTATION)||' '||EMP.EMPLOYEE_NAME||' '||EMP.MIDDLE_GUARDIAN_NAME||' '||EMP.SURNAME)  FROM MASTER_V1.LK_EMP_USER US,  MASTER_V1.MS_EMPLOYEE EMP WHERE US.EMP_ID = EMP.EMP_ID AND US.USER_ID IN (:userId)";

	/** The Constant GET_MAPPED_BRANCH_FOR_POU. */
	public static final String GET_MAPPED_BRANCH_FOR_POU = "SELECT branch_id FROM MASTER_V1.TRN_POU_BR_MAP tpbm WHERE TR_FROM_POU_ID = :fromPouId AND LK_PO_OFF_USER_ID = :toPouId AND ACTIVE_STATUS = :activeStatus";
	
	/** The Constant GET_TO_STO_OFF_BY_DIS_ID. */
	public static final String GET_TO_STO_OFF_BY_DIS_ID=" SELECT off.OFFICE_ID , off.OFFICE_NAME_DISP , off.OFFICE_CODE FROM MASTER_V1.MS_OFFICE off INNER  JOIN MASTER_V1.MS_DISTRICT edpmsdistr1_ ON off.district_id = edpmsdistr1_.district_id WHERE edpmsdistr1_.district_id = :districtId  AND off.active_status = :activeStatus AND off.status_id = :statusId AND (off.is_treasury = :isTreasury OR off.is_subtreasury = :isSubTreasury OR off.office_sub_type = :paOffice) ORDER BY off.OFFICE_NAME_DISP ";
}
