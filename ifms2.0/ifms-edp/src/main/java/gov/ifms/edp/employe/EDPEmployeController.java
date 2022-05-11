package gov.ifms.edp.employe;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPEmployeController.
 */
@RestController
@RequestMapping("/edp/employee")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPEmployeController {

   /** The repo. */
   @Autowired
   private EDPEmployeRepository repo;
   
    /**
     * Gets the employe.
     *
     * @param id the id
     * @return the employe
     */
    @Trace
    @PostMapping(URLConstant.URL_GET_BY_ID)
    public ResponseEntity<ApiResponse> getEmploye(@RequestBody IdDto id) {
    	Optional<EDPEmployeEntity> entity = repo.findByEmployeeCodeAndActiveStatus(id.getId(),Constant.ACTIVE_STATUS);
    	ClueDto clue = new ClueDto();
    	if(entity.isPresent())
    	{
    		clue.setId(entity.get().getEmpId());
    		clue.setName(EDPUtility.getEmployeeNameFromEmployeeEntity(entity.get()));
    		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,clue);
    	}else {
    		return ResponseUtil.getResponse(HttpStatus.INTERNAL_SERVER_ERROR,OAuthConstant.USER_CODE_NOT_FOUND);
    	}
    	
    }
    
}
