/*
 * 
 */
package gov.ifms.gst.repository;

import gov.ifms.gst.entity.MsMajorHeadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MsMajorHeadRepository
		extends JpaRepository<MsMajorHeadEntity, Long>, JpaSpecificationExecutor<MsMajorHeadEntity> {

	List<MsMajorHeadEntity> findAll();

	MsMajorHeadEntity findByMajorHeadCode(String majorHeadCode);

}
