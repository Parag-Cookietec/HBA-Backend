package gov.ifms.dmo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.dmo.entity.DMOWMATypesEntity;

@Repository
@Transactional
public interface DMOWMATypeRepositry
		extends JpaRepository<DMOWMATypesEntity, Long>, JpaSpecificationExecutor<DMOWMATypesEntity>, GenericDao {

}
