package gov.ifms.pvu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.pvu.converter.PVUEmployeFixPayDetailsConverter;
import gov.ifms.pvu.dto.PVUEmployeFixPayDetailsDto;
import gov.ifms.pvu.entity.PVUEmployeFixPayDetailsEntity;
import gov.ifms.pvu.repository.PVUEmployeFixPayDetailsRepository;

/**
 * The Class PVUEmployeFixPayDetailsController.
 *
 * @version v 1.0
 * @created 2020/01/08 20:46:39
 */
@Service
public class PVUEmployeFixPayDetailsServiceImpl implements PVUEmployeFixPayDetailsService {

	/**
	 * The PVUEmployeFixPayDetailsAsMethodName repository.
	 */
	@Autowired
	private PVUEmployeFixPayDetailsRepository repository;

	/**
	 * The PVUEmployeFixPayDetailsAsMethodName helper.
	 */
	@Autowired
	private PVUEmployeFixPayDetailsConverter converter;

	/**
	 * Retrieves an PVUEmployeFixPayDetailsEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeFixPayDetailsEntity with the given id or
	 *         {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUEmployeFixPayDetailsEntity getEmployeFixPayDetails(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUEmployeFixPayDetailsEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeFixPayDetailsEntity
	 */
	@Override
	public PVUEmployeFixPayDetailsEntity saveOrUpdateEmployeFixPayDetails(PVUEmployeFixPayDetailsEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Gets the employe fix pay.
	 *
	 * @param id the id
	 * @return the employe fix pay
	 */
	@Override
	public PVUEmployeFixPayDetailsDto getEmployeFixPay(Long id) {
		Optional<PVUEmployeFixPayDetailsEntity> oneByEmpIdEmpId = repository.findOneByEmpIdEmpId(id);
		return oneByEmpIdEmpId.map(pvuEmployeFixPayDetailsEntity -> converter.toDTO(pvuEmployeFixPayDetailsEntity))
				.orElse(null);
	}

}
