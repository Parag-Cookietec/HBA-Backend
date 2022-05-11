package gov.ifms.edp.service;

import java.util.List;
import java.util.stream.Collectors;

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
import gov.ifms.edp.converter.EDPMsBillConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsBillDto;
import gov.ifms.edp.entity.EDPMsBillEntity;
import gov.ifms.edp.repository.EDPMsBillRepository;

/**
 * The Class EDPMsBillController.
 * 
 * @version 1.0
 * @created 2020/01/29 17:03:45
 */
@Service
public class EDPMsBillServiceImpl implements EDPMsBillService {

	/** The EDPMsBillAsMethodName repository. */
	@Autowired
	private EDPMsBillRepository repository;

	/** The EDPMsBillAsMethodName helper. */
	@Autowired
	private EDPMsBillConverter converter;

	/**
	 * Retrieves an EDPMsBillEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsBillEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsBillEntity getMsBill(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPMsBillEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsBillEntity
	 */
	@Override
	public EDPMsBillEntity saveOrUpdateMsBill(EDPMsBillEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Deletes the EDPMsBillEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public void deleteMsBill(long id, int isDelete) {
		//deleted
	}

	/**
	 * Fetch all the EDPMsBill items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsBillDto>
	 */
	@Override
	public PagebleDTO<EDPMsBillDto> getMsBills(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<EDPMsBillEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<EDPMsBillEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<EDPMsBillEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Find all bills.
	 *
	 * @return the list
	 */
	@Override
	public List<ClueDto> findAllBills() {
		List<EDPMsBillEntity> billEntities = repository.findByActiveStatus(Constant.ACTIVE_STATUS);
		return billEntities.stream().map(billEntity -> {
			ClueDto billDto = new ClueDto();
			billDto.setId(billEntity.getBillId());
			billDto.setName(billEntity.getBillName());
			billDto.setCode(billEntity.getBillTypeId()!=null ? billEntity.getBillTypeId().getLookUpInfoName() : "");
			billDto.setCodeName(billEntity.getBillTypeId()!=null ? billEntity.getBillTypeId().getLookUpInfoName() + " : " + billEntity.getBillName() : billEntity.getBillName());
			return billDto;
		}).collect(Collectors.toList());
	}

}
