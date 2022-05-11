package gov.ifms.doi.hba.service;
import java.util.List;
import gov.ifms.doi.hba.dto.TdoiHbaClaimLossDtlDTO;
public interface TdoiHbaClaimLossDtlService{
public List<TdoiHbaClaimLossDtlDTO> saveOrUpdate(TdoiHbaClaimLossDtlDTO dto);
public List<TdoiHbaClaimLossDtlDTO> findAllByCriteria(TdoiHbaClaimLossDtlDTO dto);
public List<TdoiHbaClaimLossDtlDTO> findAllByStatus(TdoiHbaClaimLossDtlDTO dto);
public List<TdoiHbaClaimLossDtlDTO> softDeleteById(Long id);
}
