package gov.ifms.edp.repository;

import gov.ifms.edp.entity.EDPSignInMsgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * The Interface EDPUserRoleMappingRepository.
 */
@Repository
@Transactional
public interface EDPSignInMsgRepository extends JpaRepository<EDPSignInMsgEntity, Long>,
		JpaSpecificationExecutor<EDPSignInMsgEntity> {

	public Optional<EDPSignInMsgEntity> findTop1ByEnableMsgDsplAndActiveStatusOrderBySignInMsgIdDesc(int enableMsgDspl, int activeStatus);

}
