package gov.ifms.gst.repository;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.gst.entity.PenalIntrestDTL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface PanelIntrestDTLRepository
		extends JpaRepository<PenalIntrestDTL, Long>, JpaSpecificationExecutor<PenalIntrestDTL>, GenericDao {

	public Optional<PenalIntrestDTL> findTopByReceivedYearIdAndReceivedMonthIdAndPenalIntrestEntryBankIdOrderByCreatedDateDesc(Long receivedYearId, Long receivedMonthId, Long bankId);

	@Query("SELECT SUM(p.currRecvAmount) FROM PenalIntrestDTL p")
	public Double getSumOfCurrRecvAmount(Long receivedYearId, Long receivedMonthId, Long bankId);
}
