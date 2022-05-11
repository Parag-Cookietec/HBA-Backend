package gov.ifms.doi.ac.service;
import java.util.List;
import gov.ifms.doi.ac.dto.TdoiAcChequeRegisterDTO;
public interface TdoiAcChequeRegisterService{
public List<TdoiAcChequeRegisterDTO> saveOrUpdate(TdoiAcChequeRegisterDTO dto);
public List<TdoiAcChequeRegisterDTO> findAllByCriteria(TdoiAcChequeRegisterDTO dto);
public List<TdoiAcChequeRegisterDTO> findAllByStatus(TdoiAcChequeRegisterDTO dto);
public List<TdoiAcChequeRegisterDTO> softDeleteById(Long id);
}
