package gov.ifms.doi.ac.service;
import java.util.List;
import gov.ifms.doi.ac.dto.TdoiAcChallanDtlDTO;
public interface TdoiAcChallanDtlService{
public List<TdoiAcChallanDtlDTO> saveOrUpdate(TdoiAcChallanDtlDTO dto);
public List<TdoiAcChallanDtlDTO> findAllByCriteria(TdoiAcChallanDtlDTO dto);
public List<TdoiAcChallanDtlDTO> findAllByStatus(TdoiAcChallanDtlDTO dto);
public List<TdoiAcChallanDtlDTO> softDeleteById(Long id);
}
