package gov.ifms.workflow.converter;


import org.springframework.stereotype.Component;

import gov.ifms.workflow.dto.WfConfigTrnDto;



/**
 * The Class PvuTrnEmpCrWfConverter.
 */
@Component
public class WfConfigTrnConverter {
	
	/**
	 * To view.
	 *
	 * @param trnId
	 * @return the trn edp wf dto
	 */
	public WfConfigTrnDto toView(Long trnId) {
		WfConfigTrnDto dto = new WfConfigTrnDto();
		dto.setEntityPrimaryKeyId(trnId);
		return dto; 
		
	}
	
}
