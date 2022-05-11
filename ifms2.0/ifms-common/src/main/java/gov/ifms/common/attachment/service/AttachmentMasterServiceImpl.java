package gov.ifms.common.attachment.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.attachment.converter.AttachmentMasterConverter;
import gov.ifms.common.attachment.dto.AttachmentCommonDto;
import gov.ifms.common.attachment.dto.AttachmentMasterDto;
import gov.ifms.common.attachment.dto.MasterAttachmentDto;
import gov.ifms.common.attachment.entity.AttachmentMasterEntity;
import gov.ifms.common.attachment.repository.AttachmentMasterRepository;
import gov.ifms.common.constant.CommonConstant;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.CommonQueryConstant;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;

/**
 * The Class AttachmentMasterServiceImpl.
 *
 * @version v 1.0
 * @created 2019/12/07 14:21:42
 */
@Service
public class AttachmentMasterServiceImpl implements AttachmentMasterService {

	/**
	 * The AttachmentMasterAsMethodName repository.
	 */

	@Autowired
	private AttachmentMasterRepository repository;

	/**
	 * The AttachmentMasterConverter converter.
	 */

	@Autowired
	private AttachmentMasterConverter converter;

	@Autowired
	private AttachmentService attachmentService;

	/**
	 * Retrieves an AttachmentMasterEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the AttachmentMasterEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public AttachmentMasterEntity getAttachmentMaster(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given AttachmentMasterEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved AttachmentMasterEntity
	 */
	@Override
	public AttachmentMasterEntity saveOrUpdateAttachmentMaster(AttachmentMasterEntity entity) {
		return repository.save(entity);

	}

	/**
	 * Retrieves an AttachmentMasterEntity by menuId.
	 *
	 * @param id must not be {@literal null}.
	 * @return the AttachmentMasterEntity with the given menuId or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public List<AttachmentMasterEntity> getAttachmentMasterByMenuId(Long id) {
		return repository.findByMenuId(id);
	}

	public List<AttachmentMasterEntity> toAttachmentMaster(Long id) {
		List<AttachmentMasterEntity> byMenuId = repository.findByMenuId(id);
		List<AttachmentMasterDto> dtos = converter.toDTO(byMenuId);
		dtos.forEach(e -> {

		});
		return byMenuId;
	}

	/**
	 * @param masterAttachmentDto
	 * @return
	 */
	@Override

	public List<AttachmentMasterEntity> getAttachmentMasterByMenuIdAndCategory(MasterAttachmentDto masterAttachmentDto)
			throws CustomException {
		Object objects = getAttachmentCategory(masterAttachmentDto.getCategoryName());
		Long categoryId = Long.valueOf(String.valueOf(objects));
		return repository.findByMenuIdAndAttCtegryIdAndActiveStatus(masterAttachmentDto.getMenuId(), categoryId,
				Constant.ACTIVE_STATUS);
	}

	/**
	 * @param masterAttachmentDto
	 * @return
	 * @throws CustomException
	 */
	@Override
	public List<AttachmentCommonDto> getAllAttachmentByMenuIdAndTrnIdAndCategory(
			MasterAttachmentDto masterAttachmentDto) throws CustomException {
		final Object[] tableName = attachmentService.getTableData(masterAttachmentDto.getMenuId(),
				masterAttachmentDto.getEventId());

		if (Objects.nonNull(tableName)) {
			Map<String, Object> map = new HashMap<>();
			Object categoryObject = getAttachmentCategory(masterAttachmentDto.getCategoryName());
			long categoryId = Long.valueOf(String.valueOf(categoryObject));
			map.put("category", categoryId);
			map.put("trnId", masterAttachmentDto.getTrnId());
			if (CommonConstant.WORKFLOW_ATTACH_CAT_ID == categoryId) {
				map.put("lkPOUId", masterAttachmentDto.getLkPOUId());
			}
			List<Object[]> objects = repository
					.executeSQLQuery(CommonQueryConstant.getWorkflowAttachmentByTrnId(tableName,categoryId), map);
			if (!Utils.isEmpty(objects)) {
				return NativeQueryResultsMapper.map(objects, AttachmentCommonDto.class);
			}
		}
		return Collections.emptyList();
	}

	@Override
	public Object getAttachmentCategory(String categoryName) throws CustomException {
		Object objects = repository.executeNativeSQLQuerySingle(
				CommonQueryConstant.getAttachmentCategoryIdByCategoryName(),
				CommonQueryConstant.getAttachmentCategoryFilterMap(categoryName));
		if (Objects.isNull(objects)) {
			throw new CustomException(ErrorResponse.ERROR_COMMON_ATTACHMENT_CATEGORY);
		}
		return objects;
	}
}
