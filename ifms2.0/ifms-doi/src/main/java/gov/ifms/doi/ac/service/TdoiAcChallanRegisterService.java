package gov.ifms.doi.ac.service;
import java.util.List;
import gov.ifms.doi.ac.dto.TdoiAcChallanRegisterDTO;
public interface TdoiAcChallanRegisterService{
public List<TdoiAcChallanRegisterDTO> saveOrUpdate(TdoiAcChallanRegisterDTO dto);
public List<TdoiAcChallanRegisterDTO> findAllByCriteria(TdoiAcChallanRegisterDTO dto);
public List<TdoiAcChallanRegisterDTO> findAllByStatus(TdoiAcChallanRegisterDTO dto);
public List<TdoiAcChallanRegisterDTO> softDeleteById(Long id);
}
