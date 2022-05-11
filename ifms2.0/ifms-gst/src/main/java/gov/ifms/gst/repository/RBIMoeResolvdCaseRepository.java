package gov.ifms.gst.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.RBIMoeReslvdCase;

@Transactional
@Repository
public interface RBIMoeResolvdCaseRepository
		extends JpaRepository<RBIMoeReslvdCase, Long>, JpaSpecificationExecutor<RBIMoeReslvdCase>, GenericDao {

}
