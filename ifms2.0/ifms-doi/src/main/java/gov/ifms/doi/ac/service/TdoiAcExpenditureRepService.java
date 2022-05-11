package gov.ifms.doi.ac.service;
import java.util.List;
import gov.ifms.doi.ac.dto.TdoiAcExpenditureRepDTO;
public interface TdoiAcExpenditureRepService{
public List<TdoiAcExpenditureRepDTO> saveOrUpdate(TdoiAcExpenditureRepDTO dto);
public List<TdoiAcExpenditureRepDTO> findAllByCriteria(TdoiAcExpenditureRepDTO dto);
public List<TdoiAcExpenditureRepDTO> findAllByStatus(TdoiAcExpenditureRepDTO dto);
public List<TdoiAcExpenditureRepDTO> softDeleteById(Long id);
}
