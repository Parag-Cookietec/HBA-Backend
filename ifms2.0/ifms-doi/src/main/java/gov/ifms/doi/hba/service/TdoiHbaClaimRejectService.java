package gov.ifms.doi.hba.service;
import java.util.List;
import gov.ifms.doi.hba.dto.TdoiHbaClaimRejectDTO;
public interface TdoiHbaClaimRejectService{
public List<TdoiHbaClaimRejectDTO> saveOrUpdate(TdoiHbaClaimRejectDTO dto);
public List<TdoiHbaClaimRejectDTO> findAllByCriteria(TdoiHbaClaimRejectDTO dto);
public List<TdoiHbaClaimRejectDTO> findAllByStatus(TdoiHbaClaimRejectDTO dto);
public List<TdoiHbaClaimRejectDTO> softDeleteById(Long id);
}
