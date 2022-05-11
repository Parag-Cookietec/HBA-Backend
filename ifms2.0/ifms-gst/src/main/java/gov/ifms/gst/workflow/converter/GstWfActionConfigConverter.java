package gov.ifms.gst.workflow.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsMenuEntity;
import gov.ifms.gst.workflow.dto.GstWfActionConfigCondition;
import gov.ifms.gst.workflow.dto.GstWfActionConfigDto;
import gov.ifms.gst.workflow.dto.WfActCodeAndNameDto;
import gov.ifms.gst.workflow.entity.GstWfActionConfigEntity;
import gov.ifms.gst.workflow.repository.GstWfActionConfigRepository;
import gov.ifms.gst.workflow.util.GstQueryConstant;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.*;

/**
 * The Class GstWfActionConfigConverter.
 */
@Component
public class GstWfActionConfigConverter implements BaseConverter<GstWfActionConfigEntity, GstWfActionConfigDto> {

    /** The repository. */
    @Autowired
    private GstWfActionConfigRepository repository;

    /**
     * To entity.
     *
     * @param dto the dto
     * @return the Gst wf action config entity
     */
    @Override
    public GstWfActionConfigEntity toEntity(GstWfActionConfigDto dto) {
    	GstWfActionConfigEntity wfActionConfigEntity = new GstWfActionConfigEntity();
        BeanUtils.copyProperties(dto, wfActionConfigEntity);
        wfActionConfigEntity.setEdpMsMenuEntity(new EDPMsMenuEntity(dto.getMenuId()));
        wfActionConfigEntity.setFromBranchTypeId(dto.getFromBranchTypeId());
        wfActionConfigEntity.setFromOfficeTypeId(dto.getFromOfficeTypeId());
        wfActionConfigEntity.setInitWfRoleId(dto.getInitWfRoleId());
        wfActionConfigEntity.setLocationType(new EDPLuLookUpInfoEntity(dto.getLocationType()));
        wfActionConfigEntity.setWfActionId(dto.getWorkflowActionId());
        wfActionConfigEntity.setTargetMenuId(dto.getTargetMenuId());
        wfActionConfigEntity.setFromWfRoleId(dto.getFromWfRoleId());
        wfActionConfigEntity.setToWorkFlowRoleId(dto.getToWfRoleId());
        wfActionConfigEntity.setToOfficeTypeId(dto.getToOfficeTypeId());
        wfActionConfigEntity.setToBranchTypeId(dto.getToBranchTypeId());
        return wfActionConfigEntity;
    }

    /**
     * To DTO.
     *
     * @param entity the entity
     * @return the Gst wf action config dto
     */
    @Override
    public GstWfActionConfigDto toDTO(GstWfActionConfigEntity entity) {
    	GstWfActionConfigDto dto = new GstWfActionConfigDto();
        BeanUtils.copyProperties(entity, dto);
        dto.setMenuId(entity.getEdpMsMenuEntity().getMenuId());
        dto.setFromBranchTypeId(entity.getFromBranchTypeId());
        dto.setFromOfficeTypeId(entity.getFromOfficeTypeId());
        dto.setInitWfRoleId(entity.getInitWfRoleId());
        dto.setLocationType(entity.getLocationType().getLookUpInfoId());
        dto.setWorkflowActionId(entity.getWfActionId());
        dto.setTargetMenuId(entity.getTargetMenuId());
        dto.setFromWfRoleId(entity.getFromWfRoleId());
        dto.setToWfRoleId(entity.getToWorkFlowRoleId());
        dto.setToOfficeTypeId(entity.getToOfficeTypeId());
        dto.setToBranchTypeId(entity.getToBranchTypeId());
        return dto;
    }

    /**
     * To wf condition dto.
     *
     * @param wfAction the wf action
     * @return the Gst wf action config condition
     */
    public GstWfActionConfigCondition toWfConditionDto(GstWfActionConfigDto wfAction) {
    	GstWfActionConfigCondition dto = new GstWfActionConfigCondition();
        dto.setActionConfigId(wfAction.getActionConfigId());
        dto.setCondition(wfAction.getCondition());
        dto.setWfActionCode(wfAction.getWfActionCode());
        dto.setWfActionName(wfAction.getWfActionName());
        dto.setFromIsFD(wfAction.getFromIsFD());
        dto.setIsToBranchSelReq(wfAction.getIsToBranchSelReq());
        dto.setIsToOfficeSelReq(wfAction.getIsToOfficeSelReq());
        dto.setIsToUserSelReq(wfAction.getIsToUserSelReq());
        dto.setTargetMenuId(wfAction.getTargetMenuId());
        dto.setLocationType(wfAction.getLocationType());
        dto.setLocationTypeName(wfAction.getLocationTypeName());
        dto.setWorkflowActionId(wfAction.getWorkflowActionId());
        dto.setFromWfRoleId(wfAction.getFromWfRoleId());
        dto.setLocationValue(wfAction.getLocationValue());
        dto.setToWfRoleId(wfAction.getToWfRoleId());
        dto.setToBranchTypeId(wfAction.getToBranchTypeId());
        dto.setGroupVersionCode(wfAction.getGroupVersionCode());
        dto.setToIsFd(wfAction.getToIsFd());
        dto.setToOfficeTypeId(wfAction.getToOfficeTypeId());
        return dto;
    }

    /**
     * To wf action DTO.
     *
     * @param entities the entities
     * @return the list
     */
    public List<GstWfActionConfigDto> toWfActionDTO(List<GstWfActionConfigEntity> entities) {
        List<GstWfActionConfigDto> dtos = new ArrayList<>();
        entities.forEach(entity -> {
        	GstWfActionConfigDto dto = new GstWfActionConfigDto();
            dto.setActionConfigId(entity.getActionConfigId());
            dto.setFromWfRoleId(entity.getFromWfRoleId());
            dto.setFromBranchTypeId(entity.getFromBranchTypeId());
            dto.setToBranchTypeId(entity.getToBranchTypeId());
            dto.setFromOfficeTypeId(entity.getFromOfficeTypeId());
            dto.setToWfRoleId(entity.getToWorkFlowRoleId());
            dto.setCondition(entity.getCondition());
            dto.setGroupVersionCode(entity.getGroupVersionCode());
            if (!Utils.isEmpty(entity.getWfActionId())) {
                try {
                    WfActCodeAndNameDto wfActCode = repository.executeSQLQuerySingle(GstQueryConstant.getWfActCodeAndNameQrStr(),
                    		GstQueryConstant.getWfActCodeAndNameQrMap(entity.getWfActionId()), WfActCodeAndNameDto.class);
                    dto.setWorkflowActionId(entity.getWfActionId());
                    dto.setWfActionCode(wfActCode.getWfActionCode());
                    dto.setWfActionName(wfActCode.getWfActionName());
                } catch (CustomException e) {
                    e.printStackTrace();
                }
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
            dto.setToOfficeSubTypeId(entity.getToOfficeSubTypeId());
            dtos.add(dto);
        });
        Map<Long, List<GstWfActionConfigCondition>> collect = dtos.stream().collect(groupingBy(
        		GstWfActionConfigDto::getWorkflowActionId, mapping(this::toWfConditionDto, toList()))
        );
        List<GstWfActionConfigDto> unique = dtos.stream()
                .collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparingLong(GstWfActionConfigDto::getWorkflowActionId))),
                        ArrayList::new));
        for (GstWfActionConfigDto actionConfigDto : unique) {
            if (collect.get(actionConfigDto.getWorkflowActionId()).size() > 1) {
                actionConfigDto.setWfActionConfigDtoList(collect.get(actionConfigDto.getWorkflowActionId()));
            }
        }
        return unique;
    }
}
