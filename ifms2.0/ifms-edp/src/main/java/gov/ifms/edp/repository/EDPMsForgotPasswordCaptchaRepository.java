package gov.ifms.edp.repository;

import gov.ifms.edp.entity.EDPMsForgotPassCaptchaEntity;
import gov.ifms.edp.entity.EDPSignInMsgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * The Interface EDPUserRoleMappingRepository.
 */
@Repository
@Transactional
public interface EDPMsForgotPasswordCaptchaRepository extends JpaRepository<EDPMsForgotPassCaptchaEntity, Long>,
		JpaSpecificationExecutor<EDPMsForgotPassCaptchaEntity> {

	Optional<EDPMsForgotPassCaptchaEntity> findByCaptchaIdAndCaptcha(long captchaId, String captcha);

}
