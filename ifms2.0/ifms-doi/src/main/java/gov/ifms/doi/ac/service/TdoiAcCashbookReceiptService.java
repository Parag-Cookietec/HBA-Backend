package gov.ifms.doi.ac.service;
import java.util.List;
import gov.ifms.doi.ac.dto.TdoiAcCashbookReceiptDTO;
public interface TdoiAcCashbookReceiptService{
public List<TdoiAcCashbookReceiptDTO> saveOrUpdate(TdoiAcCashbookReceiptDTO dto);
public List<TdoiAcCashbookReceiptDTO> findAllByCriteria(TdoiAcCashbookReceiptDTO dto);
public List<TdoiAcCashbookReceiptDTO> findAllByStatus(TdoiAcCashbookReceiptDTO dto);
public List<TdoiAcCashbookReceiptDTO> softDeleteById(Long id);
}
