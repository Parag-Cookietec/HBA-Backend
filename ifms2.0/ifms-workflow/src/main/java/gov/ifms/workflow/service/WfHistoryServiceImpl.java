package gov.ifms.workflow.service;

import gov.ifms.common.attachment.dto.AttachmentCommonDto;
import gov.ifms.common.attachment.util.AttachmentCategoryType;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;

import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.workflow.dto.WfHSTDto;
import gov.ifms.workflow.dto.WfReqHistoryDto;
import gov.ifms.workflow.entity.LkMenuTblInfoEntity;
import gov.ifms.workflow.repository.WfActionConfigRepository;
import gov.ifms.workflow.util.QueryConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class WfHistoryServiceImpl implements WfHistoryService{


    @Autowired
    private WfActionConfigRepository wfActionConfigRepository;


    @Autowired
    private WfActionConfigService wfActionConfigService;

    /**
     * @param dto
     * @return
     */
    @Override
    public List<WfHSTDto> getWFHistory(WfReqHistoryDto dto) throws CustomException {
        LkMenuTblInfoEntity menuTblInfoEntity = wfActionConfigService.getTblInfo(dto.getMenuId(),dto.getEventId());
        if(Objects.nonNull(menuTblInfoEntity)) {
            Map<String, Object> objectMap = new HashMap<>();
            objectMap.put("trnId", dto.getTrnId());
            List<Object[]> wfObjects = wfActionConfigRepository.executeSQLQuery(QueryConstant.getCommonWFHistoryQuery(menuTblInfoEntity), objectMap);
            List<WfHSTDto> wfHSTDtos = NativeQueryResultsMapper.map(wfObjects, WfHSTDto.class);
            if (StringUtils.hasLength(menuTblInfoEntity.getAttachTblName())){
                objectMap.put("category", AttachmentCategoryType.WORKFLOW.getValue());
                for (WfHSTDto wfHSTDto : wfHSTDtos) {
                    String sb = QueryConstant.getWfAttachment(menuTblInfoEntity);
                    objectMap.put("wfRoleId",wfHSTDto.getWfRoleId());
                    objectMap.put("wfId" , wfHSTDto.getWfId());
                    List<Object[]> objects = wfActionConfigRepository.executeSQLQuery(sb, objectMap);
                    if (!Utils.isEmpty(objects)) {
                        wfHSTDto.setAttachmentCommonDtoList(NativeQueryResultsMapper.map(objects, AttachmentCommonDto.class));
                    } else{
                        wfHSTDto.setAttachmentCommonDtoList(Collections.emptyList());
                    }
                }
            }
            return wfHSTDtos;
        }
        throw new CustomException(ErrorResponse.MENU_ID_EMPTY);
    }


}
