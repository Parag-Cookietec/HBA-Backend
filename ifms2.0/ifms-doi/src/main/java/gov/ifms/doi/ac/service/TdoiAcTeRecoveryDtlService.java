package gov.ifms.doi.ac.service;
import java.util.List;
import gov.ifms.doi.ac.dto.TdoiAcTeRecoveryDtlDTO;
public interface TdoiAcTeRecoveryDtlService{
public List<TdoiAcTeRecoveryDtlDTO> saveOrUpdate(TdoiAcTeRecoveryDtlDTO dto);
public List<TdoiAcTeRecoveryDtlDTO> findAllByCriteria(TdoiAcTeRecoveryDtlDTO dto);
public List<TdoiAcTeRecoveryDtlDTO> findAllByStatus(TdoiAcTeRecoveryDtlDTO dto);
public List<TdoiAcTeRecoveryDtlDTO> softDeleteById(Long id);
}
