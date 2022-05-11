package gov.ifms.doi.hba.service;
import java.util.List;
import gov.ifms.doi.hba.dto.TdoiSurveyorBillWfDTO;
public interface TdoiSurveyorBillWfService{
public List<TdoiSurveyorBillWfDTO> saveOrUpdate(TdoiSurveyorBillWfDTO dto);
public List<TdoiSurveyorBillWfDTO> findAllByCriteria(TdoiSurveyorBillWfDTO dto);
public List<TdoiSurveyorBillWfDTO> findAllByStatus(TdoiSurveyorBillWfDTO dto);
public List<TdoiSurveyorBillWfDTO> softDeleteById(Long id);
}
