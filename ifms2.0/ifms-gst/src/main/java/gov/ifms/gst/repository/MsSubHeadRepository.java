package gov.ifms.gst.repository;

import gov.ifms.gst.entity.MsSubHeadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MsSubHeadRepository
		extends JpaRepository<MsSubHeadEntity, Long>, JpaSpecificationExecutor<MsSubHeadEntity> {

	public List<MsSubHeadEntity> findByMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadIdAndMinorHeadEntityMinorHeadIdOrderBySubHeadCodeAsc(
			Long majorHeadId, Long subMajorHjeadId, Long minorHeadId);

}
