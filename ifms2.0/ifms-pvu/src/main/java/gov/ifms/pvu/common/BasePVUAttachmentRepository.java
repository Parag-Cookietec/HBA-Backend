package gov.ifms.pvu.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BasePVUAttachmentRepository<E extends BasePVUAttachmentEntity> extends JpaRepository<E, Long> {

}
