package gov.ifms.doi.hba.utils;

import java.util.HashMap;
import java.util.Map;

public class QueryConstant {

    /**
     * Gets the ins trn details qr string qr string.
     *
     * @return the ins trn details qr string qr string
     */
    public static String getEmployeeDetailsQrString() {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT tagd.HBA_MCA_ACC_NUM ,tagd.EMPLOYEE_NUM ,tagd.FIRST_NAME ,tagd.MIDDLE_NAME ,tagd.LAST_NAME, ");
        queryString.append(
                " loan.LOAN_AMT,OFC.OFFICE_NAME,OFC.DESIGANATION_ID,OFC.OFFICE_ADD FROM DPFF.THBA_ACC_GEN_DTL tagd ");
        queryString.append(" LEFT JOIN DPFF.THBA_ADG_OFF_DTL OFC ON OFC.THBA_ACC_GEN_DTL_ID =TAGD.THBA_ACC_GEN_DTL_ID ");
        queryString.append(
                " LEFT JOIN DPFF.THBA_ADG_LOAN_DTL loan ON loan.THBA_ACC_GEN_DTL_ID =TAGD.THBA_ACC_GEN_DTL_ID ");
        queryString.append(" WHERE tagd.HBA_MCA_ACC_NUM= :loanAccountNo ");
        return queryString.toString();
    }

    /**
     * Gets the ins trn details qr string qr param map.
     *
     * @param loanAccountNo the loanAccountNo
     * @return the ins trn details qr string qr param map
     */
    public static Map<String, Object> getEmployeeDetailsQrStringParamMap(String loanAccountNo) {
        Map<String, Object> params = new HashMap<>();
        params.put("loanAccountNo", loanAccountNo);
        return params;
    }

    /**
     * Gets the ins trn details qr string qr string.
     *
     * @return the ins trn details qr string qr string
     */
    public static String getDesignationDetailsQrString() {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT md.DESIGNATION_NAME FROM MASTER_V1.MS_DESIGNATION md WHERE md.DESIGNATION_ID =:designationId ");
        return queryString.toString();
    }

    /**
     * Gets the ins trn details qr string qr param map.
     *
     * @param designationId the loanAccountNo
     * @return the ins trn details qr string qr param map
     */
    public static Map<String, Object> getDesignationDetailsQrStringParamMap(Integer designationId) {
        Map<String, Object> params = new HashMap<>();
        params.put("designationId", designationId);
        return params;
    }
}
