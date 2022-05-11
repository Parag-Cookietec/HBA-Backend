package gov.ifms.doi.hba.service;
import java.util.List;
import gov.ifms.doi.hba.dto.TdoiHbaOthrCompClaimDTO;
public interface TdoiHbaOthrCompClaimService{
public List<TdoiHbaOthrCompClaimDTO> saveOrUpdate(TdoiHbaOthrCompClaimDTO dto);
public List<TdoiHbaOthrCompClaimDTO> findAllByCriteria(TdoiHbaOthrCompClaimDTO dto);
public List<TdoiHbaOthrCompClaimDTO> findAllByStatus(TdoiHbaOthrCompClaimDTO dto);
public List<TdoiHbaOthrCompClaimDTO> softDeleteById(Long id);
}
