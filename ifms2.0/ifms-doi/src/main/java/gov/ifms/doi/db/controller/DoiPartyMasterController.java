package gov.ifms.doi.db.controller;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.doi.db.dto.MdoiDbPartyMstDTO;
import gov.ifms.doi.db.service.MdoiDbPartyMstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.*;

@RestController
@RequestMapping(DOI_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DoiPartyMasterController {

    @Autowired
    MdoiDbPartyMstService service;


    @Trace
    @PostMapping(value =DOI_PARTY_MASTER_ENTRY , produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
    public ResponseEntity<ApiResponse> saveOrUpdate(@RequestBody MdoiDbPartyMstDTO dto) {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.saveOrUpdate(dto));
    }

    @Trace
    @PostMapping(value = DOI_PARTY_MASTER_LISTING, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
    public ResponseEntity<ApiResponse> getPartyMasters(@RequestBody PageDetails pageDetails) {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DOI_FETCH, service.findAll(pageDetails));
    }


    @Trace
    @DeleteMapping(value = DOI_PARTY_MASTER_DELETE, produces = CONTENT_TYPE_APP_JSON)
    public ResponseEntity<ApiResponse> softDeleteById(@RequestParam(name = "id") Long id) {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_DELETE, service.softDeleteById(id));
    }


    @Trace
    @PostMapping(value = DOI_PARTY_MASTER_LISTING_BY_STATUS, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
    public ResponseEntity<ApiResponse> getAllByStatus(@RequestBody MdoiDbPartyMstDTO dto) {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, service.findAllByStatus(dto));
    }
}
