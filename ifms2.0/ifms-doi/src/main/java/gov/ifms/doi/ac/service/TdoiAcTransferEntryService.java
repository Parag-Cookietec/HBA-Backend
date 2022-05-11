package gov.ifms.doi.ac.service;
import java.util.List;
import gov.ifms.doi.ac.dto.TdoiAcTransferEntryDTO;
public interface TdoiAcTransferEntryService{
public List<TdoiAcTransferEntryDTO> saveOrUpdate(TdoiAcTransferEntryDTO dto);
public List<TdoiAcTransferEntryDTO> findAllByCriteria(TdoiAcTransferEntryDTO dto);
public List<TdoiAcTransferEntryDTO> findAllByStatus(TdoiAcTransferEntryDTO dto);
public List<TdoiAcTransferEntryDTO> softDeleteById(Long id);
}
