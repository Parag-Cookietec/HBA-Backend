package gov.ifms.edp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPMsSubModuleEntity;
import gov.ifms.edp.repository.EDPMsSubModuleRepository;

/**
 * The Class EDPMsSubModuleServiceImpl.
 */
@Service
public class EDPMsSubModuleServiceImpl implements EDPMsSubModuleService {

	/** The EDPMsModuleAsMethodName repository. */
	@Autowired
	private EDPMsSubModuleRepository repository;

	/**
	 *  The EDPMsModuleAsMethodName helper.
	 *
	 * @return the ms sub modules
	 */
	
	@Override
	public List<EDPMsSubModuleEntity> getMsSubModules() {
		return repository.findAll();
	}

	/**
	 * Gets the ms sub module.
	 *
	 * @param id the id
	 * @return the ms sub module
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPMsSubModuleEntity> getMsSubModule(Long id) throws CustomException {
		return repository.findByModuleIdModuleIDAndActiveStatus(id ,Constant.ACTIVE_STATUS);
	}


}
