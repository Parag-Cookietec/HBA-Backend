package gov.ifms.doi.ac.service;
import java.util.List;
import gov.ifms.doi.ac.dto.TdoiAcTeExpenditureDtlDTO;
public interface TdoiAcTeExpenditureDtlService{
public List<TdoiAcTeExpenditureDtlDTO> saveOrUpdate(TdoiAcTeExpenditureDtlDTO dto);
public List<TdoiAcTeExpenditureDtlDTO> findAllByCriteria(TdoiAcTeExpenditureDtlDTO dto);
public List<TdoiAcTeExpenditureDtlDTO> findAllByStatus(TdoiAcTeExpenditureDtlDTO dto);
public List<TdoiAcTeExpenditureDtlDTO> softDeleteById(Long id);
}
