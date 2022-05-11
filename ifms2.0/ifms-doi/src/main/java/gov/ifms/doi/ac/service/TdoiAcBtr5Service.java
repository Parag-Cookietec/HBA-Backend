package gov.ifms.doi.ac.service;
import java.util.List;
import gov.ifms.doi.ac.dto.TdoiAcBtr5DTO;
public interface TdoiAcBtr5Service{
public List<TdoiAcBtr5DTO> saveOrUpdate(TdoiAcBtr5DTO dto);
public List<TdoiAcBtr5DTO> findAllByCriteria(TdoiAcBtr5DTO dto);
public List<TdoiAcBtr5DTO> findAllByStatus(TdoiAcBtr5DTO dto);
public List<TdoiAcBtr5DTO> softDeleteById(Long id);
}
