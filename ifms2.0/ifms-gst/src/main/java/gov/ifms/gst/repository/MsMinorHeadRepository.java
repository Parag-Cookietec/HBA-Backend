package gov.ifms.gst.repository;

import gov.ifms.gst.entity.MsMinorHeadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * The Class BudgetMsMinorHeadController.
 * 
 * @version 1.0
 * @created 2019/08/29 16:00:31
 */
public interface MsMinorHeadRepository
		extends JpaRepository<MsMinorHeadEntity, Long>, JpaSpecificationExecutor<MsMinorHeadEntity> {

	public List<MsMinorHeadEntity> findByMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadIdOrderByMinorHeadCode(
			Long majorHeadId, Long subMajorHeadId);

}
