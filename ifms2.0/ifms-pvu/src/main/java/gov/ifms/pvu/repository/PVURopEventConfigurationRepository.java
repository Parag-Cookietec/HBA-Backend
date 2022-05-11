package gov.ifms.pvu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.pvu.dto.response.RopConfigurationDto;
import gov.ifms.pvu.entity.PVURopEventConfigurationEntity;

public interface PVURopEventConfigurationRepository extends JpaRepository<PVURopEventConfigurationEntity, Long>,
		JpaSpecificationExecutor<PVURopEventConfigurationEntity> {

	@Query(value = "SELECT new gov.ifms.pvu.dto.response.RopConfigurationDto(ropConfig.ropType, ropConfig.effectiveDate) FROM "
			+ " PVURopEventConfigurationEntity ropConfig WHERE ropConfig.activeStatus = 1 ") 
	public List<RopConfigurationDto> ropConfigurationList();
	
	@Query(value = "from PVURopEventConfigurationEntity ropConfig WHERE ropConfig.activeStatus = :activeStatus") 
	public List<PVURopEventConfigurationEntity> findByActiveStatus(@Param("activeStatus") int activeStatus);
	
	@Query(value = "from PVURopEventConfigurationEntity ropConfig WHERE ropConfig.ropType = :ropType") 
	public PVURopEventConfigurationEntity findByRopType(@Param("ropType") Long ropType);
}
