package gov.ifms.pvu.edp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.exception.CustomException;

/**
 * The Class EDPMsHeadDepartmentController.
 * 
 * @version v 1.0
 * @created 2020/01/15 15:35:39
 */
@Service
public class EDPMsHeadDepartmentServiceImpl implements EDPMsHeadDepartmentService {

	/** The EDPMsHeadDepartmentAsMethodName repository. */
	@Autowired
	private EDPMsHeadDepartmentRepository repository;

	/** The EDPMsHeadDepartmentAsMethodName helper. */
	@Autowired
	private EDPMsHeadDepartmentConverter converter;
	@Autowired
	EDPMsHeadDepartmentRepository edpMsHeadDepartmentRepository;

	/**
	 * Retrieves an EDPMsHeadDepartmentEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsHeadDepartmentEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsHeadDepartmentEntity getMsHeadDepartment(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPMsHeadDepartmentEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsHeadDepartmentEntity
	 */
	@Override
	public EDPMsHeadDepartmentEntity saveOrUpdateMsHeadDepartment(EDPMsHeadDepartmentEntity entity) {
		return repository.save(entity);
	}

	@Override
	public List<EDPMsHeadDepartmentDto> getMsHeadDepartments(long id) throws CustomException {
		return converter.toDTO(edpMsHeadDepartmentRepository.findByDepartmentIdDepartmentId(id));
	}

	/**
	 * Deletes the EDPMsHeadDepartmentEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	/*
	 * // uncomment method when require delete api
	 * 
	 * @Override public void deleteMsHeadDepartment(long id,int isDelete) {
	 * repository.deleteMsHeadDepartment(id, isDelete ,
	 * OAuthUtility.getCurrentUserUserId(),new java.util.Date()); }
	 */
	/**
	 * Fetch all the EDPMsHeadDepartment items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsHeadDepartmentDto>
	 */

}
