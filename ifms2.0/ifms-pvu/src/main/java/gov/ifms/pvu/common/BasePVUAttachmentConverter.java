package gov.ifms.pvu.common;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;

/**
 * The Class BasePVUAttachmentConverter.
 *
 * @param <E> the element type
 * @param <D> the generic type
 */
public abstract class BasePVUAttachmentConverter<E extends BasePVUAttachmentEntity, D extends BasePVUAttachmentDto> {

    /**
     * Creates the entity.
     *
     * @return the e
     */
    public abstract E createEntity();

    /**
     * Creates the DTO.
     *
     * @return the d
     */
    public abstract D createDTO();

    /**
     * To entity.
     *
     * @param dtos the dtos
     * @return the list
     */
    public List<E> toEntity(List<D> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    /**
     * To entity.
     *
     * @param dto the dto
     * @return the e
     */
    public E toEntity(D dto) {
        E e = this.createEntity();
        BeanUtils.copyProperties(dto, e, "uploadedBy");
        D newDto = createDTO();
        BeanUtils.copyProperties(dto, newDto);
        if (dto.getStatusId() != null) {
            e.setStatus(new EDPLuLookUpInfoEntity(dto.getStatusId()));
        }
        if ((dto.getId() == null && (e.getUploadedBy() == null))) {
            EDPMsUserEntity uploadedBy = new EDPMsUserEntity(OAuthUtility.getCurrentUserUserId());
            e.setUploadedBy(uploadedBy);
        }
        if(dto.getPouId() == null) {
			e.setEdpLkPoOffUserId(new EDPLkPoOffUserEntity(OAuthUtility.getCurrentUserLkPOUId()));
		}
        return this.toEntity(e, newDto);
    }

    /**
     * To DTO.
     *
     * @param entity the entity
     * @return the list
     */
    public List<D> toDTO(List<E> entity) {
        return entity.stream().map(this::toDTO).collect(Collectors.toList());
    }


    /**
     * To DTO.
     *
     * @param entity the entity
     * @return the d
     */
    public D toDTO(E entity) {
        D dto = this.createDTO();
        BeanUtils.copyProperties(entity, dto, "uploadedBy");
        if (entity.getStatus() != null) {
            dto.setStatusId(entity.getStatus().getLookUpInfoId());
        }
        if (entity.getUploadedBy() != null) {
            dto.setUploadedBy(entity.getUploadedBy().getUserName());
        }
        if(entity.getEdpLkPoOffUserId() != null && OAuthUtility.getCurrentUserLkPOUId().equals(entity.getEdpLkPoOffUserId().getLkPoOffUserId())) {
        	dto.setDelete(Boolean.TRUE);
		}
        return this.toDTO(entity, dto);
    }

    /**
     * To entity.
     *
     * @param e the e
     * @param d the d
     * @return the e
     */
    protected abstract E toEntity(E e, D d);

    /**
     * To DTO.
     *
     * @param e the e
     * @param d the d
     * @return the d
     */
    protected abstract D toDTO(E e, D d);
}
