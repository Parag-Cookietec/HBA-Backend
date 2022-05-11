package gov.ifms.doi.hba.service;
import java.util.List;
import gov.ifms.doi.hba.dto.TdoiHbaProposlWfDTO;
public interface TdoiHbaProposlWfService{
public List<TdoiHbaProposlWfDTO> saveOrUpdate(TdoiHbaProposlWfDTO dto);
public List<TdoiHbaProposlWfDTO> findAllByCriteria(TdoiHbaProposlWfDTO dto);
public List<TdoiHbaProposlWfDTO> findAllByStatus(TdoiHbaProposlWfDTO dto);
public List<TdoiHbaProposlWfDTO> softDeleteById(Long id);
}
