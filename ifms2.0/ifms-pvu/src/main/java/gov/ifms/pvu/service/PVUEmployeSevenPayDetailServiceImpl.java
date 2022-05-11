package gov.ifms.pvu.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.pvu.converter.PVUEmployeSevenPayDetailConverter;
import gov.ifms.pvu.dto.PVUCommonResponse;
import gov.ifms.pvu.dto.PVUEmployeSevenPayDetailDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeSevenPayDetailEntity;
import gov.ifms.pvu.repository.PVUEmployeSevenPayDetailRepository;


/**
 * The Class PVUEmployeSevenPayDetailServiceImpl.
 * 
 * @version v 1.0
 * @created 2019/11/26 14:21:09
 */
@Service
public class PVUEmployeSevenPayDetailServiceImpl implements PVUEmployeSevenPayDetailService {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The PVUEmploye7PayDetailAsMethodName repository. */
	@Autowired
	private PVUEmployeSevenPayDetailRepository repository;

	/** The PVUEmploye7PayDetailAsMethodName helper. */
	@Autowired
	private PVUEmployeSevenPayDetailConverter converter;

	/**
	 * Retrieves an PVUEmploye7PayDetailEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmploye7PayDetailEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUEmployeSevenPayDetailEntity getEmploye7PayDetail(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUEmploye7PayDetailEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmploye7PayDetailEntity
	 */
	@Override
	public PVUEmployeSevenPayDetailEntity saveOrUpdateEmploye7PayDetail(PVUEmployeSevenPayDetailEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Deletes the PVUEmploye7PayDetailEntity with the given id.
	 *
	 * @param pageDetail the page detail
	 * @return the employe 7 pay details
	 * @throws CustomException          the custom exception
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */

	/**
	 * Fetch all the PVUEmploye7PayDetail items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmploye7PayDetailDto>
	 */
	@Override
	public PagebleDTO<PVUEmployeSevenPayDetailDto> getEmploye7PayDetails(PageDetails pageDetail)
			throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUEmployeSevenPayDetailEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<PVUEmployeSevenPayDetailEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<PVUEmployeSevenPayDetailEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
	/**
	 * Gets the emp by emp number.
	 *
	 * @param id the id
	 * @return the emp by emp number
	 * @throws CustomException the custom exception
	 */
	@Override
	public PVUEmployeSevenPayDetailDto getEmpByEmpId(Long id) throws CustomException {
		Optional<PVUEmployeSevenPayDetailEntity> employeeEntity = repository.findOneByPvuEmployeEntityEmpIdAndActiveStatus(id,Constant.ACTIVE_STATUS);
	       return converter.toDTO(employeeEntity.get());
	}

	@Override
	public Optional<PVUEmployeSevenPayDetailEntity> getEmployee7PayDetails(PVUEmployeEntity employeeEntity) {
		return repository.findByPvuEmployeEntity(employeeEntity);

	}

}
