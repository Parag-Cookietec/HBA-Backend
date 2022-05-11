package gov.ifms.doi.hba.service;
import java.util.List;
import gov.ifms.doi.hba.dto.TdoiHbaClaimWfDTO;
public interface TdoiHbaClaimWfService{
public List<TdoiHbaClaimWfDTO> saveOrUpdate(TdoiHbaClaimWfDTO dto);
public List<TdoiHbaClaimWfDTO> findAllByCriteria(TdoiHbaClaimWfDTO dto);
public List<TdoiHbaClaimWfDTO> findAllByStatus(TdoiHbaClaimWfDTO dto);
public List<TdoiHbaClaimWfDTO> softDeleteById(Long id);
}
