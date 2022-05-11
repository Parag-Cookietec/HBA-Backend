package gov.ifms.gst.repository;

import gov.ifms.gst.entity.MsDetailHeadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MsDetailHeadRepository
		extends JpaRepository<MsDetailHeadEntity, Long>, JpaSpecificationExecutor<MsDetailHeadEntity> {


	List<MsDetailHeadEntity> findByMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadIdAndMinorHeadEntityMinorHeadIdAndSubHeadEntitySubHeadIdOrderByDetailHeadCode(
			 Long majorHeadId, Long subMajorHeadId, Long minorHeadId, Long subHeadId);
	
}
