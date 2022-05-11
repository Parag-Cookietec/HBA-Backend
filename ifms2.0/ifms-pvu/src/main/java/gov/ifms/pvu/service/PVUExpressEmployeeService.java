
package gov.ifms.pvu.service;


import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PvuExpEmpView;
import gov.ifms.pvu.dto.response.PVUExpressEmployeeDto;

public interface PVUExpressEmployeeService extends PVUBaseService {
    PVUExpressEmployeeDto saveOrUpdateExpEmp(PVUExpressEmployeeDto dto) throws CustomException;
    PVUExpressEmployeeDto getExpEmpByCaseNo(PVUExpressEmployeeDto dto) throws CustomException;
    PagebleDTO<PvuExpEmpView> getExpEmpSearchList(PageDetails pageDetail) throws CustomException;
    String getExpEmpByPanNo(String panNo) throws CustomException;
    PVUExpressEmployeeDto getExpEmpByEmpId(long id) throws CustomException;
}
