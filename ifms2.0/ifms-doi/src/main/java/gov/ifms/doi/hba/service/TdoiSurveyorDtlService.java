package gov.ifms.doi.hba.service;
import java.util.List;
import gov.ifms.doi.hba.dto.TdoiSurveyorDtlDTO;
public interface TdoiSurveyorDtlService{
public List<TdoiSurveyorDtlDTO> saveOrUpdate(TdoiSurveyorDtlDTO dto);
public List<TdoiSurveyorDtlDTO> findAllByCriteria(TdoiSurveyorDtlDTO dto);
public List<TdoiSurveyorDtlDTO> findAllByCriteria();
public List<TdoiSurveyorDtlDTO> findAllByStatus(TdoiSurveyorDtlDTO dto);
public List<TdoiSurveyorDtlDTO> softDeleteById(Long id);
}
