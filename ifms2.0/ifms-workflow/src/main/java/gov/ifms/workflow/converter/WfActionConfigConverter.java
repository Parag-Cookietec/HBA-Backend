package gov.ifms.workflow.converter;

import gov.ifms.common.base.BaseConverter;

import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsMenuEntity;
import gov.ifms.workflow.dto.WfActionConfigCondition;
import gov.ifms.workflow.dto.WfActionConfigDto;

import gov.ifms.workflow.entity.MsWorkflowActionEntity;

import gov.ifms.workflow.entity.MsWorkflowRoleEntity;
import gov.ifms.workflow.entity.WfActionConfigEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.*;

@Component
public class WfActionConfigConverter implements BaseConverter<WfActionConfigEntity, WfActionConfigDto> {


    @Override
    public WfActionConfigEntity toEntity(WfActionConfigDto dto) {
        WfActionConfigEntity wfActionConfigEntity = new WfActionConfigEntity();
        BeanUtils.copyProperties(dto, wfActionConfigEntity);
        wfActionConfigEntity.setEdpMsMenuEntity(new EDPMsMenuEntity(dto.getMenuId()));
        wfActionConfigEntity.setFromBranchTypeId(dto.getFromBranchTypeId());
        wfActionConfigEntity.setFromOfficeTypeId(dto.getFromOfficeTypeId());
        wfActionConfigEntity.setInitWfRoleId(dto.getInitWfRoleId());
        wfActionConfigEntity.setLocationType(new EDPLuLookUpInfoEntity(dto.getLocationType()));
        wfActionConfigEntity.setMsWorkflowActionEntity(new MsWorkflowActionEntity(dto.getWorkflowActionId()));
        wfActionConfigEntity.setTargetMenuId(dto.getTargetMenuId());
        wfActionConfigEntity.setFromWorkFlowRoleEntity(new MsWorkflowRoleEntity(dto.getFromWfRoleId()));
        wfActionConfigEntity.setToWorkFlowRoleId(dto.getToWfRoleId());
        wfActionConfigEntity.setToOfficeTypeId(dto.getToOfficeTypeId());
        wfActionConfigEntity.setToBranchTypeId(dto.getToBranchTypeId());
        return wfActionConfigEntity;
    }

    @Override
    public WfActionConfigDto toDTO(WfActionConfigEntity entity) {
        WfActionConfigDto dto = new WfActionConfigDto();
        BeanUtils.copyProperties(entity, dto);
        dto.setMenuId(entity.getEdpMsMenuEntity().getMenuId());
        dto.setFromBranchTypeId(entity.getFromBranchTypeId());
        dto.setFromOfficeTypeId(entity.getFromOfficeTypeId());
        dto.setInitWfRoleId(entity.getInitWfRoleId());
        dto.setLocationType(entity.getLocationType().getLookUpInfoId());
        dto.setWorkflowActionId(entity.getMsWorkflowActionEntity().getWfActionId());
        dto.setTargetMenuId(entity.getTargetMenuId());
        dto.setFromWfRoleId(entity.getFromWorkFlowRoleEntity().getWfRoleId());
        dto.setToWfRoleId(entity.getToWorkFlowRoleId());
        dto.setToOfficeTypeId(entity.getToOfficeTypeId());
        dto.setToBranchTypeId(entity.getToBranchTypeId());

        return dto;
    }

    public WfActionConfigCondition toWfConditionDto(WfActionConfigDto wfaction) {
        WfActionConfigCondition dto = new WfActionConfigCondition();
        dto.setActionConfigId(wfaction.getActionConfigId());
        dto.setCondition(wfaction.getCondition());
        dto.setWfActionCode(wfaction.getWfActionCode());
        dto.setWfActionName(wfaction.getWfActionName());
        dto.setFromIsFD(wfaction.getFromIsFD());
        dto.setIsToBranchSelReq(wfaction.getIsToBranchSelReq());
        dto.setIsToOfficeSelReq(wfaction.getIsToOfficeSelReq());
        dto.setIsToUserSelReq(wfaction.getIsToUserSelReq());
        dto.setTargetMenuId(wfaction.getTargetMenuId());
        dto.setLocationType(wfaction.getLocationType());
        dto.setLocationTypeName(wfaction.getLocationTypeName());
        dto.setWorkflowActionId(wfaction.getWorkflowActionId());
        dto.setFromWfRoleId(wfaction.getFromWfRoleId());
        dto.setLocationValue(wfaction.getLocationValue());
        dto.setToWfRoleId(wfaction.getToWfRoleId());
        dto.setToBranchTypeId(wfaction.getToBranchTypeId());
        dto.setGroupVersionCode(wfaction.getGroupVersionCode());
        dto.setToIsFd(wfaction.getToIsFd());
        dto.setToOfficeTypeId(wfaction.getToOfficeTypeId());
        return dto;
    }

    public List<WfActionConfigDto> toWfActionDTO(List<WfActionConfigEntity> entities) {
        List<WfActionConfigDto> dtos = new ArrayList<>();
        entities.stream().forEach(entity -> {
            WfActionConfigDto dto = new WfActionConfigDto();
            dto.setActionConfigId(entity.getActionconfigId());
            dto.setFromWfRoleId(entity.getFromWorkFlowRoleEntity().getWfRoleId());
            dto.setFromBranchTypeId(entity.getFromBranchTypeId());
            dto.setToBranchTypeId(entity.getToBranchTypeId());
            dto.setFromOfficeTypeId(entity.getFromOfficeTypeId());
            dto.setToWfRoleId(entity.getToWorkFlowRoleId());
            dto.setCondition(entity.getCondition());
            dto.setGroupVersionCode(entity.getGroupVersionCode());
            if (!Utils.isEmpty(entity.getMsWorkflowActionEntity().getWfActionId())) {
                dto.setWorkflowActionId(entity.getMsWorkflowActionEntity().getWfActionId());
                dto.setWfActionCode(entity.getMsWorkflowActionEntity().getWfActionCode());
                dto.setWfActionName(entity.getMsWorkflowActionEntity().getWfActionName());
            }
            if (!Utils.isEmpty(entity.getLocationType().getLookUpInfoId())) {
                dto.setLocationType(entity.getLocationType().getLookUpInfoId());
                dto.setLocationTypeName(entity.getLocationType().getLookUpInfoName());
            }
            dto.setLocationValue(entity.getLocationValue());
            dto.setFromIsFD(entity.getFromIsFD());
            dto.setIsToBranchSelReq(entity.getIsToBranchSelReq());
            dto.setIsToOfficeSelReq(entity.getIsToOfficeSelReq());
            dto.setIsToUserSelReq(entity.getIsToUserSelReq());
            dto.setTargetMenuId(entity.getTargetMenuId());
            dto.setToIsFd(entity.getToIsFd());
            dto.setToOfficeTypeId(entity.getToOfficeTypeId());
            dtos.add(dto);
        });
        Map<Long, List<WfActionConfigCondition>> collect = dtos.stream().collect(groupingBy(
                WfActionConfigDto::getWorkflowActionId, mapping(this::toWfConditionDto, toList()))
        );
        List<WfActionConfigDto> unique = dtos.stream()
                .collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparingLong(WfActionConfigDto::getWorkflowActionId))),
                        ArrayList::new));
        for (WfActionConfigDto actionConfigDto : unique) {
            if (collect.get(actionConfigDto.getWorkflowActionId()).size() > 1) {
                actionConfigDto.setWfActionConfigDtoList(collect.get(actionConfigDto.getWorkflowActionId()));
            }
        }
        return unique;
    }
}
