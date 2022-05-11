package gov.ifms.dmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.dmo.entity.DMOLoanGuarantorEntity;
@Repository
public interface DMOGuarantorOrganizationsRepositry extends JpaRepository<DMOLoanGuarantorEntity, Long>,
JpaSpecificationExecutor<DMOLoanGuarantorEntity>, GenericDao
{

}
