package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Class PvuWFOutWardWrapperDto.
 */
public class PvuWFOutWardWrapperDto extends PvuWFWrapperDto implements Serializable {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The pvu trn emp cr wf id.
     */
    private String postConsignmentNumber;

    /**
     * The pvu trn emp cr wf id.
     */
    private String status;

    public String getPostConsignmentNumber() {
        return postConsignmentNumber;
    }

    public void setPostConsignmentNumber(String postConsignmentNumber) {
        this.postConsignmentNumber = postConsignmentNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static PvuWFWrapperDto createSuper(PvuWFOutWardWrapperDto dto) {
        PvuWFWrapperDto wrapperDto = new PvuWFWrapperDto();
        wrapperDto.setPvuTrnEmpCrWfId(dto.getPvuTrnEmpCrWfId());
        wrapperDto.setTrnId(dto.getTrnId());
        wrapperDto.setCurrentWorkflowId(dto.getCurrentWorkflowId());
        wrapperDto.setWfActionId(dto.getWfActionId());
        wrapperDto.setAssignToWfRoleId(dto.getAssignToWfRoleId());
        wrapperDto.setAssignToUserId(dto.getAssignToUserId());
        wrapperDto.setAssignToPostId(dto.getAssignToPostId());
        wrapperDto.setAssignToOfficeId(dto.getAssignToOfficeId());
        wrapperDto.setTrnStatus(dto.getTrnStatus());
        wrapperDto.setWfStatus(dto.getWfStatus());
        wrapperDto.setRemarks(dto.getRemarks());
        wrapperDto.setAssignByWfRoleId(dto.getAssignByWfRoleId());
        wrapperDto.setAssignByPostId(dto.getAssignByPostId());
        wrapperDto.setAssignByUserId(dto.getAssignByUserId());
        wrapperDto.setAssignByOfficeId(dto.getAssignByOfficeId());
        wrapperDto.setMenuId(dto.getMenuId());
        wrapperDto.setWfAttachmentIds(dto.getWfAttachmentIds());
        wrapperDto.setAssignByPOUId(dto.getAssignByPOUId());
        wrapperDto.setAssignToPOUId(dto.getAssignToPOUId());
        wrapperDto.setEventId(dto.getEventId());
        wrapperDto.setAssignByActionLevel(dto.getAssignByActionLevel());
        wrapperDto.setAssignToActionLevel(dto.getAssignToActionLevel());
        return wrapperDto;
    }

    public static List<PvuWFWrapperDto> createSuper(List<PvuWFOutWardWrapperDto> dto) {
        return dto.stream().map(PvuWFOutWardWrapperDto::createSuper).collect(Collectors.toList());
    }


}
