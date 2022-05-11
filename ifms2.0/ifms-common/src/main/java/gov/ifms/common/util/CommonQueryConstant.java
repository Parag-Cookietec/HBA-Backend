package gov.ifms.common.util;

import java.util.HashMap;
import java.util.Map;

import gov.ifms.common.constant.CommonConstant;

public class CommonQueryConstant {

    private CommonQueryConstant(){
        super();
    }

    /**
     * @return
     */
    public static String getAttachmentCategoryIdByCategoryName() {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT LOOKUPINFO.LOOKUP_INFO_ID  FROM  ").append(Constant.EDP_MASTER_SCHEMA).append(".LU_LOOKUP_INFO lookupinfo ");
        sb.append(" INNER JOIN  ").append(Constant.EDP_MASTER_SCHEMA).append(".LU_LOOKUP lookup ON LOOKUP.LOOKUP_ID  = LOOKUPINFO.PARENT_LOOKUP_ID ");
        sb.append(" WHERE  UPPER(lookupinfo.LOOKUP_INFO_NAME )= UPPER(:category) AND LOOKUP.LOOKUP_ID =:parentlookupId AND LOOKUP.ACTIVE_STATUS  = 1");
        sb.append(" AND LOOKUPINFO.ACTIVE_STATUS = 1 LIMIT 1");
        return sb.toString();
    }

    public static Map<String, Object> getAttachmentCategoryFilterMap(String categoryName) {
        Map<String, Object> map = new HashMap<>();
        map.put("category", categoryName);
        map.put("parentlookupId", Constant.LU_ATTACHMENT_CATEGORY_LOOKUP_ID);
        return map;
    }

    public static String getWorkflowAttachmentByTrnId(Object [] tableName, long categoryId){
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT tta.TRN_ATTACH_ID AS c0, tta.TRN_ID AS C1 , tta.ATTACHMENT_ID AS c2 ,");
        sb.append(" mt.ATTACHMENT_NAME AS c3 , ");
        sb.append(" tta.FILE_NAME AS c4, tta.UPLOADED_FILE_PATH AS c5 ,");
        sb.append(" tta.UPLOADED_FILE_NAME AS c6 ,tta.UPLOADED_FILE_SIZE AS c7,");
        sb.append(" tta.DOCUMENT_ID AS c8 ,"
        		//+ "us.USER_NAME AS c9 ,"
        		+ "NVL((SELECT lli.LOOKUP_INFO_NAME FROM MASTER_V1.LU_LOOKUP_INFO lli WHERE lli.LOOKUP_INFO_ID =me.SALUTATION ), ' ')||' '|| me.EMPLOYEE_NAME ||' '|| me.MIDDLE_GUARDIAN_NAME ||' '|| me.SURNAME AS c9 ,"
        		+ "tta.CREATED_BY_POST AS c10,");
        sb.append(" tta.CREATED_DATE  AS c11  FROM ").append(tableName[0].toString()).append(".").append(tableName[2].toString());
        sb.append(" tta INNER JOIN ").append(Constant.EDP_MASTER_SCHEMA).append(".MS_ATTACHMENTS mt ON mt.ATTACHMENT_ID  =tta.ATTACHMENT_ID ");
        sb.append(" INNER JOIN ").append(Constant.EDP_MASTER_SCHEMA).append(".LK_PO_OFF_USER pou ON POU.LK_PO_OFF_USER_ID  = tta.UPDATED_BY_POST ");
        sb.append(" INNER JOIN ").append(Constant.EDP_MASTER_SCHEMA).append(".MS_USER us ON us.USER_ID  = pou.USER_ID INNER JOIN MASTER_V1.LK_EMP_USER leu ON  tta.UPLOADED_BY =leu.USER_ID  INNER JOIN MASTER_V1.MS_EMPLOYEE me ON  me.EMP_ID =LEU.EMP_ID ");
        sb.append(" WHERE tta.TRN_ID  = :trnId AND   tta.ACTIVE_STATUS  = 1 ");
        sb.append(" AND tta.CATEGORY = :category ");
        if(CommonConstant.WORKFLOW_ATTACH_CAT_ID == categoryId) {
        	sb.append(" AND tta.CREATED_BY_POST =:lkPOUId AND tta.WF_ID IS NULL AND tta.WF_ROLE_ID IS null ");
        }
        return sb.toString();
    }
}
