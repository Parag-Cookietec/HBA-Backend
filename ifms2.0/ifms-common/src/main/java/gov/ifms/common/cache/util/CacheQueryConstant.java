package gov.ifms.common.cache.util;

import gov.ifms.common.util.Constant;

import java.util.HashMap;
import java.util.Map;

public class CacheQueryConstant {

    private CacheQueryConstant(){
        super();
    }
    public static Map<String, Object> getActiveStatusMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("activeStatus", Constant.ACTIVE_STATUS);
        return map;
    }

    public static String getAllFy() {
        return "select new gov.ifms.common.cache.dto.MsFyCacheDto(o.financialYearId , o.fyStart,o.fyStartMonth,o.fyEnd,o.fyEndMonth,o.fy,o.isCurrentYear.lookUpInfoId) from EDPMsFinancialYearEntity o where o.activeStatus = :activeStatus";
    }

    public static String getAllBPN() {
        return "select new gov.ifms.common.cache.dto.MsBPNCacheDto(o.bpnId,o.bpnName, o.bpnNameGuj, o.bpnCode, o.bpnCodeGuj, o.bpnCodeName ) from BudgetMsBPNEntity o where o.activeStatus = :activeStatus";
    }

    public static String  getAllDept() {
        StringBuilder sb = new StringBuilder();
        sb.append( "select new gov.ifms.common.cache.dto.MsDeptCacheDto(o.departmentId, o.departmentName, o.departmentNameGuj, o.departmentShort, o.departmentCode ) from EDPMsDepartmentEntity o where o.activeStatus = :activeStatus ");
        return sb.toString();
    }

    public static String getDeptById() {
        StringBuilder sb = new StringBuilder(getAllDept());
        sb.append(" and o.departmentId = :departmentId ");
        return  sb.toString();
    }

    public static String getLKDemandByDeptId() {
        StringBuilder sb = new StringBuilder();
        sb.append(" select new gov.ifms.common.cache.dto.LkDeptDemandCacheDto(o.deptDemandId, o.demandEntity.demandId, o.demandEntity.demandName, o.demandEntity.demandNameGuj, o.demandEntity.demandCode, o.demandEntity.demandCodeGuj, o.demandEntity.demandCodeName) from BudgetLKDeptDemandEntity o where o.activeStatus = :activeStatus ");
        sb.append(" and o.deptEntity.departmentId= :departmentId ");
        return sb.toString();
    }

    public static String getLKDeptByDemandId() {
        StringBuilder sb = new StringBuilder();
        sb.append("select new gov.ifms.common.cache.dto.MsDeptCacheDto(o.deptEntity.departmentId, o.deptEntity.departmentName, o.deptEntity.departmentNameGuj, o.deptEntity.departmentShort, o.deptEntity.departmentCode) from BudgetLKDeptDemandEntity o where o.activeStatus = :activeStatus ");
        sb.append(" and o.demandEntity.demandId= :demandId ");
        return sb.toString();
    }

    public static String getDemandByBpnId() {
        StringBuilder sb = new StringBuilder();
        sb.append(" select new gov.ifms.common.cache.dto.MsDemandCacheDto(o.demandId, o.demandName, o.demandNameGuj, o.demandCode, o.demandCodeGuj, o.demandCodeName ,o.budgetMsBPNEntity.bpnId) from BudgetMsDemandEntity o where o.activeStatus = :activeStatus ");
        sb.append(" and o.budgetMsBPNEntity.bpnId= :bpnId ");
        return sb.toString();
    }

    public static String getMajorHeadByDemandId() {
        StringBuilder sb = new StringBuilder();
        sb.append(" select new gov.ifms.common.cache.dto.MsMajorHeadCacheDto(o.majorHeadId,o.majorHeadName,o.majorHeadNameGuj,o.majorHeadCode,o.budgetMsDemandEntities.demandId) from BudgetMsMajorHeadEntity o where o.activeStatus = :activeStatus ");
        sb.append(" and o.budgetMsDemandEntities.demandId= :demandId ");
        return sb.toString();
    }

    public static String getSectorHead() {
        StringBuilder sb = new StringBuilder();
        sb.append(" select new gov.ifms.common.cache.dto.MsSectorHeadCacheDto(o.sectorheadId, o.sectorheadName, o.sectorheadNameGuj, o.sectorheadCode, o.sectorheadCodeGuj, o.sectorheadCodeName, o.sectorheadTypeId) from BudgetMsSectorheadEntity o where o.activeStatus = :activeStatus ");
        return sb.toString();
    }

    public static String getSubSectorBySectorHeadId() {
        StringBuilder sb = new StringBuilder();
        sb.append(" select new gov.ifms.common.cache.dto.MsSubSectorCacheDto(o.subSectorId, o.subSectorName, o.subSectorNameGuj, o.subSectorCode, o.subSectorCodeGuj, o.subSectorCodeName, o.subSectorTypeId, o.sectorHeadCode, o.sectorHeadId) from BudgetMsSubSectorEntity o where o.activeStatus = :activeStatus ");
        sb.append(" and  o.sectorHeadId=:sectorHeadId ");
        return sb.toString();
    }

    public static String getSubMajorHeadByMajorHeadId() {
        StringBuilder sb = new StringBuilder();
        sb.append(" select new gov.ifms.common.cache.dto.MsSubMajorHeadCacheDto(o.subMajorHeadId, o.submajorHeadName, o.submajorHeadNameGuj, o.subMajorHeadCode, o.subMajorHeadCodeGuj, o.subMajorHeadCodeNames, o.submajorHeadTypeId, o.budgetMsDemand.demandId, o.majorHeadEntity.majorHeadId) from BudgetMsSubMajorHeadEntity o where o.activeStatus = :activeStatus ");
        sb.append(" and o.majorHeadEntity.majorHeadId=:majorHeadId");
        return sb.toString();
    }

    public static String getMinorHeadBySubMajorHeadId() {
        StringBuilder sb = new StringBuilder();
        sb.append(" select new gov.ifms.common.cache.dto.MsMinorHeadCacheDto(o.minorHeadId, o.minorHeadName, o.minorHeadNameGuj, o.minorHeadCode, o.minorHeadCodeGuj, o.minorHeadCodeName, o.subMajorHeadEntity.subMajorHeadId, o.majorHeadEntity.majorHeadId, o.demandEntity.demandId) from BudgetMsMinorHeadEntity o where o.activeStatus = :activeStatus ");
        sb.append("  and o.subMajorHeadEntity.subMajorHeadId =:subMajorHeadId ORDER BY o.minorHeadCodeName ASC ");
        return sb.toString();
    }


    public static String getSubHeadByMinorHeadId() {
        StringBuilder sb = new StringBuilder();
        sb.append(" select o.subHeadId as c0, o.subHeadName as c1, o.subheadNameGuj as c2, o.subHeadCode as c3, ");
        sb.append(" o.subHeadCodecGuj as c4, o.subHeadCodeName as c5 , o.edpCode as c6, o.planningCode as c7, ");
        sb.append(" o.isCss as c8, o.minorHeadEntity.minorHeadId as c9, o.demandentity.demandId as c10, o.majorHeadEntity.majorHeadId as c11 ,  o.subMajorHeadEntity.subMajorHeadId  as c12 from BudgetMsSubHeadEntity o where o.activeStatus = :activeStatus ");
        sb.append(" and o.minorHeadEntity.minorHeadId =:minorHeadId ORDER BY o.subHeadCodeName ASC");
        return sb.toString();
    }

    public static String getDetailHeadBySubHeadId() {
        StringBuilder sb = new StringBuilder();
        sb.append(" select o.detailHeadId as c0, o.detailHeadName as c1, o.detailHeadNameGuj as c2, o.detailHeadCode as c3, o.detailHeadCodeGuj as c4, ");
        sb.append(" o.detailHeadCodeName as c5, o.edpCode as c6, o.planningCode as c7, o.isCss as c8, o.minorHeadEntity.minorHeadId as c9 , o.demandentity.demandId as c10, o.majorHeadEntity.majorHeadId as c11, ");
        sb.append(" o.subMajorHeadEntity.subMajorHeadId as c12 , o.subHeadEntity.subHeadId as c13 ");
        sb.append(" from BudgetMsDetailHeadEntity o where o.activeStatus = :activeStatus ");
        sb.append(" and o.subHeadEntity.subHeadId =:subHeadId ");
        return sb.toString();
    }

    public static String getObjectHead() {
        StringBuilder sb = new StringBuilder();
        sb.append(" select o.objectId as c0, o.objectName as c1, o.objectNameGuj as c2, o.objectCode as c3, o.objectCodeGuj as c4 , " );
        sb.append(" o.objectCodeName as c5 , o.iSGaidId as c6, o.isCnmId as c7 , o.isBrekUpNeededId.lookUpInfoId as c8, o.odbjectClassId.objectClassId  as c9, " );
        sb.append(" o.isRecoveryId.lookUpInfoId as c10, o.giaBreakupId as c11, o.isReceipt.lookUpInfoId  as c12 " );
        sb.append(" from BudgetMsObjectHeadEntity o where o.activeStatus = :activeStatus ");
        return sb.toString();
    }

    public static String getObjectHeadByObjectClassId() {
        StringBuilder sb = new StringBuilder(getObjectHead());
        sb.append(" and o.odbjectClassId.objectClassId =:objectClassId ");
        return sb.toString();
    }

    public static String getMinisterByDemandId() {
        StringBuilder sb = new StringBuilder();
        sb.append(" select new gov.ifms.common.cache.dto.MsMinisterInChargeCacheDto(o.msMinisterInChargeId, o.name, o.nameGuj, o.demand.demandId, o.portfolio, o.portfolioGuj, o.lkPOUId) ");
        sb.append(" from BudgetMsMinisterInChargeEntity o where o.activeStatus = :activeStatus ");
        sb.append(" and  o.demand.demandId=:demandId ");
        return sb.toString();
    }

    public static String getMinisterByPOUId() {
        StringBuilder sb = new StringBuilder();
        sb.append(" select new gov.ifms.common.cache.dto.MsMinisterInChargeCacheDto(o.msMinisterInChargeId, o.name, o.nameGuj, o.demand.demandId, o.portfolio, o.portfolioGuj, o.lkPOUId) ");
        sb.append(" from BudgetMsMinisterInChargeEntity o where o.activeStatus = :activeStatus ");
        sb.append(" and o.lkPOUId=:lkPOUId ");
        return sb.toString();
    }

    public static String getState() {
        StringBuilder sb = new StringBuilder();
        sb.append(" select new gov.ifms.common.cache.dto.MsStateCacheDto(o.stateId, o.stateName, o.stateNameGuj, o.stateCode) from EDPMsStateEntity o where o.activeStatus = :activeStatus ");
        return sb.toString();
    }

    public static String getStateByStateId() {
        StringBuilder sb = new StringBuilder(getState());
        sb.append(" and o.stateId =:stateId ");
        return sb.toString();
    }

    public static String getDistrict() {
        StringBuilder sb = new StringBuilder();
        sb.append(" select new gov.ifms.common.cache.dto.MsDistrictCacheDto(o.districtId, o.districtName, o.districtNameGuj, o.districtCode, o.stateId, o.stdCode) from EDPMsDistrictEntity o where o.activeStatus = :activeStatus ");
        return sb.toString();
    }

    public static String getDistrictByStateId() {
        StringBuilder sb = new StringBuilder(getDistrict());
        sb.append(" and o.stateId =:stateId ");
        return sb.toString();
    }

    public static String getDistrictByDistrictId() {
        StringBuilder sb = new StringBuilder(getDistrict());
        sb.append(" and o.districtId =:districtId ");
        return sb.toString();
    }

    public static String getDistrictOnlyGUJState() {
        StringBuilder sb = new StringBuilder(getDistrict());
        sb.append(" and o.stateId=:stateId");
        return sb.toString();
    }

    public static String getTaluka() {
        StringBuilder sb = new StringBuilder();
        sb.append(" select new gov.ifms.common.cache.dto.MsTalukaCacheDto(o.talukaId, o.talukaName, o.talukaCode, o.districtId) from EDPMsTalukaEntity o where o.activeStatus = :activeStatus ");
        return sb.toString();
    }

    public static String getTalukaByDistrictId() {
        StringBuilder sb = new StringBuilder(getTaluka());
        sb.append(" and o.districtId =:districtId ");
        return sb.toString();
    }

    public static String getTalukaByTalukaId() {
        StringBuilder sb = new StringBuilder(getTaluka());
        sb.append(" and o.talukaId =:talukaId ");
        return sb.toString();
    }

    public static String getDesignation() {
        StringBuilder sb = new StringBuilder();
        sb.append(" select new gov.ifms.common.cache.dto.MsDesignationCacheDto(o.designationId, o.designationName, o.designationNameGuj, o.designationCode) from EDPMsDesignationEntity o where o.activeStatus = :activeStatus ");
        sb.append(" and o.statusId = 327 ");
        return sb.toString();
    }

    public static String getDesignationByDesignationId() {
        StringBuilder sb = new StringBuilder(getDesignation());
        sb.append(" and o.designationId =:designationId ");
        return sb.toString();
    }

    public static String getLookupInfoQuery() {
        return "select new gov.ifms.common.cache.dto.LkLookUpInfoCacheDto(o.lookUpInfoId, o.lookUpInfoName, o.lookUpInfoNameGuj, o.edpLuLookUpEntity.lookUpId, o.lookUpInfoValue, o.orderId,o.lookUpInfoDescription) from EDPLuLookUpInfoEntity o where o.activeStatus = :activeStatus ";
    }

    public static String getLookupInfoByParentLookupId() {
        StringBuilder sb = new StringBuilder(getLookupInfoQuery());
        sb.append(" and o.edpLuLookUpEntity.lookUpId =:lookUpId");
        return sb.toString();
    }

    public static String getLookupInfoByParentLookupName() {
        StringBuilder sb = new StringBuilder(getLookupInfoQuery());
        sb.append(" and o.edpLuLookUpEntity.lookUpName =:lookUpName");
        return sb.toString();
    }

    public static String getLookupInfoId() {
        StringBuilder sb = new StringBuilder();
        sb.append(" select new gov.ifms.common.cache.dto.LkLookUpInfoCacheDto(o.lookUpInfoId, o.lookUpInfoName, o.lookUpInfoNameGuj, o.edpLuLookUpEntity.lookUpId, o.lookUpInfoValue, o.orderId) from EDPLuLookUpInfoEntity o where o.activeStatus = :activeStatus ");
        sb.append(" and o.lookUpInfoId =:lookUpInfoId");
        return sb.toString();
    }

    public static String getWfStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT DISTINCT o.toWfStatus  FROM WfActionConfigEntity o WHERE o.edpMsMenuEntity.menuId =:menuId AND o.fromOfficeTypeId =:officeTypeId and o.activeStatus = :activeStatus" );
        return  sb.toString();
    }

    public static String getTrnStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT DISTINCT o.toStatus  FROM WfActionConfigEntity o WHERE o.edpMsMenuEntity.menuId =:menuId AND o.fromOfficeTypeId =:officeTypeId and o.activeStatus = :activeStatus" );
        return  sb.toString();
    }
    
    public static String getOffByDistrictId() {
		StringBuilder sb = new StringBuilder();
		sb.append(" select new gov.ifms.common.cache.dto.MsOfficeCacheDto(o.officeId,o.officeName, o.ddoNo, o.cardexno, o.officeNameDisp,o.departmentId.departmentId,o.departmentId.departmentName) from EDPMsOfficeEntity o where o.districtId.districtId = :districtId and o.statusId=327 and o.activeStatus = :activeStatus and o.officeStatus = 283 ");
		return sb.toString();
    }
    
    public static String getDemandByDemandCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(" select new gov.ifms.common.cache.dto.MsDemandCacheDto(o.demandId, o.demandName, o.demandNameGuj, o.demandCode, o.demandCodeGuj, o.demandCodeName ,o.budgetMsBPNEntity.bpnId) from BudgetMsDemandEntity o where o.activeStatus = :activeStatus ");
        sb.append(" and o.demandCode= :demandCode ");
        return sb.toString();
    }
}
