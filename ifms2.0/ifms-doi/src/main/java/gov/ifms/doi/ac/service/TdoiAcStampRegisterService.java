package gov.ifms.doi.ac.service;
import java.util.List;
import gov.ifms.doi.ac.dto.TdoiAcStampRegisterDTO;
public interface TdoiAcStampRegisterService{
public List<TdoiAcStampRegisterDTO> saveOrUpdate(TdoiAcStampRegisterDTO dto);
public List<TdoiAcStampRegisterDTO> findAllByCriteria(TdoiAcStampRegisterDTO dto);
public List<TdoiAcStampRegisterDTO> findAllByStatus(TdoiAcStampRegisterDTO dto);
public List<TdoiAcStampRegisterDTO> softDeleteById(Long id);
}
