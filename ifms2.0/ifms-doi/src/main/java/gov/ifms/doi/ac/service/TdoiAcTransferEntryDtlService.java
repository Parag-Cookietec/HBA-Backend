package gov.ifms.doi.ac.service;
import java.util.List;
import gov.ifms.doi.ac.dto.TdoiAcTransferEntryDtlDTO;
public interface TdoiAcTransferEntryDtlService{
public List<TdoiAcTransferEntryDtlDTO> saveOrUpdate(TdoiAcTransferEntryDtlDTO dto);
public List<TdoiAcTransferEntryDtlDTO> findAllByCriteria(TdoiAcTransferEntryDtlDTO dto);
public List<TdoiAcTransferEntryDtlDTO> findAllByStatus(TdoiAcTransferEntryDtlDTO dto);
public List<TdoiAcTransferEntryDtlDTO> softDeleteById(Long id);
}
