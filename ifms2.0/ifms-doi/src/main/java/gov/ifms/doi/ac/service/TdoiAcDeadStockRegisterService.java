package gov.ifms.doi.ac.service;
import java.util.List;
import gov.ifms.doi.ac.dto.TdoiAcDeadStockRegisterDTO;
public interface TdoiAcDeadStockRegisterService{
public List<TdoiAcDeadStockRegisterDTO> saveOrUpdate(TdoiAcDeadStockRegisterDTO dto);
public List<TdoiAcDeadStockRegisterDTO> findAllByCriteria(TdoiAcDeadStockRegisterDTO dto);
public List<TdoiAcDeadStockRegisterDTO> findAllByStatus(TdoiAcDeadStockRegisterDTO dto);
public List<TdoiAcDeadStockRegisterDTO> softDeleteById(Long id);
}
