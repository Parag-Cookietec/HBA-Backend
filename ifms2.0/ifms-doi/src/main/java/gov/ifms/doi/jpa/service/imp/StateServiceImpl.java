package gov.ifms.doi.jpa.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.doi.jpa.converter.StateConverter;
import gov.ifms.doi.jpa.dto.StateDTO;
import gov.ifms.doi.jpa.repository.StateRepository;
import gov.ifms.doi.jpa.service.StateService;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@Service
public class StateServiceImpl implements StateService {

	@Autowired
	StateRepository stateRepository;

	@Autowired
	StateConverter stateConverter;

	@Override
	public List<StateDTO> getStateList() {
		return stateConverter.toDtoListFromEntityList(stateRepository.findAllActive());
	}

	@Override
	public StateDTO getStateByName(String stateName) {
		List<StateDTO> stateDTOList = stateConverter
				.toDtoListFromEntityList(stateRepository.findByStateName(stateName));
		if (!stateDTOList.isEmpty()) {
			return stateDTOList.get(0);
		}
		return null;
	}

}
