package gov.ifms.gst.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.ScrollDistribute;

@Transactional
@Repository
public interface ScrollDistributeRepository
		extends JpaRepository<ScrollDistribute, Long>, JpaSpecificationExecutor<ScrollDistribute>, GenericDao {

	List<ScrollDistribute> findByScrollDtBetween(LocalDateTime fromDate, LocalDateTime toDate);

	Optional<ScrollDistribute> findByScrollNo(String scrollNo);

	Optional<ScrollDistribute> findByReferenceNo(String referenceNo);

	@Query(nativeQuery = true, value = "SELECT MAX(REFERENCE_NO)  FROM EPAO.TPAO_SCROLL_DISTRIBUTE  ")
	String findByReferenceNo();
}
