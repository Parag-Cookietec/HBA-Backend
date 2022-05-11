package gov.ifms.edp.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.converter.EDPMsRolePermissionsConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.entity.EDPMsRolePermissionsEntity;
import gov.ifms.edp.repository.EDPMsRolePermissionsRepository;

/**
 * The Class EDPMsRolePermissionsServiceImpl.
 *
 * @author db2admin
 */
@Service
public class EDPMsRolePermissionsServiceImpl implements EDPMsRolePermissionsService {

	/** The edp ms role permissions repository. */
	@Autowired
	private EDPMsRolePermissionsRepository edpMsRolePermissionsRepository;

	@Autowired
	private EDPMsRolePermissionsConverter edpMsRolePermissionsConverter;

	/**
	 * Gets the EDP ms R ole activity by role activity id in.
	 *
	 * @param idList the id list
	 * @return the EDP ms R ole activity by role activity id in
	 */
	public List<EDPMsRolePermissionsEntity> getEDPMsROleActivityByRoleActivityIdIn(Set<Long> idList) {
		return edpMsRolePermissionsRepository.findByRolePrmIdIn(idList);
	}

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	@Override
	public List<ClueDto> getAll() {
		List<EDPMsRolePermissionsEntity> prmList = edpMsRolePermissionsRepository.findByActiveStatus(Constant.ACTIVE_STATUS);
		prmList.removeIf(n -> n.getRoleName().contains(","));
		return prmList.stream().filter(n -> !n.getRoleName().contains(","))
				.map(n -> edpMsRolePermissionsConverter.toClueDTO(n)).collect(Collectors.toList());
	}

}
