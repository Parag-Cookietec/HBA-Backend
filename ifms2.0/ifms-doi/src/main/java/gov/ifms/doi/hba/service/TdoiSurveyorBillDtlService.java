package gov.ifms.doi.hba.service;
import java.util.List;
import gov.ifms.doi.hba.dto.TdoiSurveyorBillDtlDTO;
public interface TdoiSurveyorBillDtlService{
public List<TdoiSurveyorBillDtlDTO> saveOrUpdate(TdoiSurveyorBillDtlDTO dto);
public List<TdoiSurveyorBillDtlDTO> findAllByCriteria(TdoiSurveyorBillDtlDTO dto);
public List<TdoiSurveyorBillDtlDTO> findAllByStatus(TdoiSurveyorBillDtlDTO dto);
public List<TdoiSurveyorBillDtlDTO> softDeleteById(Long id);
}
