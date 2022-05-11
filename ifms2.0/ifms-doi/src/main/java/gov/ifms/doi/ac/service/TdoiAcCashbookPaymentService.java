package gov.ifms.doi.ac.service;
import java.util.List;
import gov.ifms.doi.ac.dto.TdoiAcCashbookPaymentDTO;
public interface TdoiAcCashbookPaymentService{
public List<TdoiAcCashbookPaymentDTO> saveOrUpdate(TdoiAcCashbookPaymentDTO dto);
public List<TdoiAcCashbookPaymentDTO> findAllByCriteria(TdoiAcCashbookPaymentDTO dto);
public List<TdoiAcCashbookPaymentDTO> findAllByStatus(TdoiAcCashbookPaymentDTO dto);
public List<TdoiAcCashbookPaymentDTO> softDeleteById(Long id);
}
