package gov.ifms.gst.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.NonReconErrorData;

@Transactional
@Repository
public interface NonReconErrroDataRepository
		extends JpaRepository<NonReconErrorData, Long>, JpaSpecificationExecutor<NonReconErrorData>, GenericDao {

}
