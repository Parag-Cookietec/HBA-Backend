package gov.ifms.pvu.service;

import java.util.List;

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
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.pvu.converter.PVUEmployeHistoryConverter;
import gov.ifms.pvu.dto.PVUEmployeHistoryDto;
import gov.ifms.pvu.entity.PVUEmployeHistoryEntity;
import gov.ifms.pvu.repository.PVUEmployeHistoryRepository;

/**
 * The Class PVUEmployeHistoryServiceImpl.
 * 
 * @version v 1.0
 * @created 2019/11/29 17:29:29
 */
@Service
public class PVUEmployeHistoryServiceImpl implements PVUEmployeHistoryService {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The PVUEmployeHistoryAsMethodName repository. */
	@Autowired
	private PVUEmployeHistoryRepository repository;

	/** The PVUEmployeHistoryAsMethodName helper. */
	@Autowired
	private PVUEmployeHistoryConverter converter;

	/**
	 * Fetch all the PVUEmployeHistory items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeHistoryDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUEmployeHistoryDto> getEmployeHistorys(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUEmployeHistoryEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<PVUEmployeHistoryEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<PVUEmployeHistoryEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * +.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 */
	@Override
	public void deleteStatus(Long id, Integer activeStatus) {
		repository.setDeleteStatus(id, activeStatus);
	}

	/**
	 * Gets the employe history.
	 *
	 * @param id the id
	 * @return the employe history
	 */
	@Override
	public PVUEmployeHistoryEntity getEmployeHistory(Long id) {
		return null;
	}

	/**
	 * Save or update employe history.
	 *
	 * @param entity the entity
	 * @return the PVU employe history entity
	 */
	@Override
	public PVUEmployeHistoryEntity saveOrUpdateEmployeHistory(List<PVUEmployeHistoryEntity> entity) {

		return null;
	}

}
