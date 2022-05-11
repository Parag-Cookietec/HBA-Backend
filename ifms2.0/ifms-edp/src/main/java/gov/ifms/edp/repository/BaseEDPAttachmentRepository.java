/**
 * 
 */
package gov.ifms.edp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import gov.ifms.edp.entity.EDPBaseAttachmentEntity;

/**
 * @author SA20077427
 *
 */
@NoRepositoryBean
public interface BaseEDPAttachmentRepository <E extends EDPBaseAttachmentEntity> extends JpaRepository<E, Long> {

}

