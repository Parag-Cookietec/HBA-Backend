package gov.ifms.gst.repository;

import gov.ifms.gst.entity.MsSubMajorHeadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MsSubMajorHeadRepository
		extends JpaRepository<MsSubMajorHeadEntity, Long>, JpaSpecificationExecutor<MsSubMajorHeadEntity> {

	List<MsSubMajorHeadEntity> findByMajorHeadEntityMajorHeadIdOrderBySubMajorHeadCode(Long majorHeadId);

}
