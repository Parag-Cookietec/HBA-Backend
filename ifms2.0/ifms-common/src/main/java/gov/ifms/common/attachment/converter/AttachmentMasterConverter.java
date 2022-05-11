package gov.ifms.common.attachment.converter;

import gov.ifms.common.attachment.dto.AttachmentMasterDto;
import gov.ifms.common.attachment.dto.MsAttachmentDto;
import gov.ifms.common.attachment.entity.AttachmentMasterEntity;
import gov.ifms.common.attachment.entity.MsAttachmentEntity;
import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AttachmentMasterConverter implements BaseConverter<AttachmentMasterEntity, AttachmentMasterDto> {

    /**
     * To entity.
     *
     * @param dto the dto
     * @return the DOIAttachmentMaster entity
     */
    @Override
    public AttachmentMasterEntity toEntity(AttachmentMasterDto dto) {
        AttachmentMasterEntity entity = new AttachmentMasterEntity();
        BeanUtils.copyProperties(dto, entity);
        if (dto.getAttTypeId() != null) {
            MsAttachmentEntity type = new MsAttachmentEntity();
            type.setAttachmentId(dto.getAttTypeId().getId());
            entity.setAttTypeId(type);
        }
        return entity;
    }

    /**
     * To DTO.
     *
     * @param entity the entity
     * @return the DOIAttachmentMaster  dto
     */
    @Override
    public AttachmentMasterDto toDTO(AttachmentMasterEntity entity) {
        AttachmentMasterDto dto = new AttachmentMasterDto();
        BeanUtils.copyProperties(entity, dto);
        if (entity.getAttTypeId() != null) {
            dto.setAttTypeId(this.toAttachmentDTO(entity.getAttTypeId() ,entity));
        }
        return dto;
    }

    public MsAttachmentDto toAttachmentDTO(MsAttachmentEntity entity ,AttachmentMasterEntity attachmentMasterEntity) {
        Long isMandatory = entity.getIsMandatory();
        return new MsAttachmentDto(entity.getAttachmentId(), entity.getAttachmentName(), isMandatory == 1 ? Constant.LOOKUP_NO : Constant.LOOKUP_YES ,attachmentMasterEntity.getAttCtegryId());
    }

}
