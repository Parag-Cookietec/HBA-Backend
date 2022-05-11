package gov.ifms.workflow.service;

import java.util.*;
import java.util.stream.Collectors;

import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.workflow.repository.MsWorkflowRepository;
import gov.ifms.workflow.util.WorkFlowConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.workflow.dto.PVUWFReqHistoryDto;
import gov.ifms.workflow.dto.PVUWfHSTDto;
import gov.ifms.workflow.entity.LkMenuTblInfoEntity;
import gov.ifms.workflow.repository.LkMenuTblInfoRepository;
import gov.ifms.workflow.repository.WfRepository;
import gov.ifms.workflow.util.QueryConstant;

/**
 * The Class PVUWfHistoryServiceImpl
 */
@Service
public class PVUWfHistoryServiceImpl implements PVUWfHistoryService {

    @Autowired
    private LkMenuTblInfoRepository repository;

    @Autowired
    WfRepository wfRepo;

    @Autowired
    private MsWorkflowService service;

    @Autowired
    private MsWorkflowRepository workflowRepository;

    /**
     * getWFHistory
     *
     * @param dto
     * @return List<PVUWfHSTDto>
     * @throws CustomException
     */
    @Override
    public List<PVUWfHSTDto> getWFHistory(PVUWFReqHistoryDto dto) throws CustomException {
        LkMenuTblInfoEntity menuTblInfoEntity = null;
        if (dto.getEventId() != null) {
            menuTblInfoEntity = repository.findByMenuIdAndActiveStatusAndEventId(dto.getMenuId(),
                    Constant.ACTIVE_STATUS, dto.getEventId());
        } else {
            menuTblInfoEntity = repository.findByMenuIdAndActiveStatusAndEventIdIsNull(dto.getMenuId(),
                    Constant.ACTIVE_STATUS);
        }
        HashMap<String, Object> objectMap = new HashMap<>();
        objectMap.put("trnId", dto.getTrnId());
        List<Object[]> objectPvuSp = wfRepo.executeSQLQuery(QueryConstant.getPFWFHistoryQuery(menuTblInfoEntity), objectMap);
        return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUWfHSTDto.class)
                : Collections.emptyList();
    }

    /**
     * getPvuWFHistory
     *
     * @param dto
     * @return List<PVUWfHSTDto>
     * @throws CustomException
     */
    @Override
    public List<PVUWfHSTDto> getPvuWFHistory(PVUWFReqHistoryDto dto) throws CustomException {
        long officeTypeId = OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeTypeId();
        List<Long> wfRolesList = Arrays.asList(dto.getWfRoles()).stream().map(x -> new Long(x)).collect(Collectors.toList());
        long currentWfRoleId = service.findActualWfRoleIdForPVUHistory(wfRolesList, dto.getTrnId(),dto.getMenuId(),dto.getEventId(),officeTypeId).getAssignToWfRoleId();
        String currentWfRole = workflowRepository.findWfRoleCodeById(currentWfRoleId);
        LkMenuTblInfoEntity menuTblInfoEntity;
        if (dto.getEventId() != null) {
            menuTblInfoEntity = repository.findByMenuIdAndActiveStatusAndEventId(dto.getMenuId(),
                    Constant.ACTIVE_STATUS, dto.getEventId());
        } else {
            menuTblInfoEntity = repository.findByMenuIdAndActiveStatusAndEventIdIsNull(dto.getMenuId(),
                    Constant.ACTIVE_STATUS);
        }
        StringBuilder appendQuery = new StringBuilder();
        switch (currentWfRole) {
            case WorkFlowConstant.PVU_AUDITOR_WF:
            case WorkFlowConstant.PVU_VERIFIER_WF:
            case WorkFlowConstant.PVU_APRROVER_CLASS_I_WF:
            case WorkFlowConstant.PVU_APRROVER_CLASS_II_WF:
                appendQuery.append(" AND WFROLE.WF_ROLE_CODE NOT IN ( ");
                appendQuery.append(WorkFlowConstant.PF_CREATOR_WF_CODE).append(",");
                appendQuery.append(WorkFlowConstant.PF_VERIFIER_WF_CODE).append(",");
                appendQuery.append(WorkFlowConstant.PVU_INWARD).append(",");
                appendQuery.append(WorkFlowConstant.PVU_OUTWARD).append(",");
                appendQuery.append(WorkFlowConstant.PVU_PRINT_ENDORSEMENT_WF_CODE).append(",");
                appendQuery.append(WorkFlowConstant.PVU_DISTRIBUTE);
                appendQuery.append(")");
                break;
            case WorkFlowConstant.PF_VERIFIER_WF:
            case WorkFlowConstant.PF_CREATOR_WF:
            case WorkFlowConstant.PF_APPROVER_WF:
                appendQuery.append(" AND WFROLE.WF_ROLE_CODE  IN ( ");
                appendQuery.append(WorkFlowConstant.PF_CREATOR_WF_CODE).append(",");
                appendQuery.append(WorkFlowConstant.PF_VERIFIER_WF_CODE).append(",");
                appendQuery.append(WorkFlowConstant.PF_APPROVER_WF_CODE);
                appendQuery.append(")");
                break;
            default:
            	appendQuery.append(" AND WFROLE.WF_ROLE_CODE NOT IN ( ");
            	appendQuery.append(WorkFlowConstant.PVU_INWARD).append(",");
            	appendQuery.append(WorkFlowConstant.PVU_DISTRIBUTE);
                appendQuery.append(") ");
        }
        HashMap<String, Object> objectMap = new HashMap<>();
        objectMap.put("trnId", dto.getTrnId());
        List<Object[]> objectPvuSp = wfRepo.executeSQLQuery(QueryConstant.getPVUWFHistoryQuery(menuTblInfoEntity, appendQuery.toString()), objectMap);
        return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUWfHSTDto.class)
                : Collections.emptyList();
    }
}

