package gov.ifms.gst.repository;

import gov.ifms.gst.entity.MsObjectHeadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MsObjectHeadRepository
		extends JpaRepository<MsObjectHeadEntity, Long>, JpaSpecificationExecutor<MsObjectHeadEntity> {

}
