package gov.ifms.edp.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPMsUserToken;

/**
 * The Class EdpMsUserTokenRepository.
 * 
 * @version 1.0
 * @created 2019/12/26 05:02:01
 */
@Repository
@Transactional
public interface EDPMsUserTokenRepository
		extends JpaRepository<EDPMsUserToken, Long>, JpaSpecificationExecutor<EDPMsUserToken> {

	/**
	 * Checks if is otp valid.
	 *
	 * @param userId the user id
	 * @param tokenNo the token no
	 * @param currentDate the current date
	 * @return the list
	 */
	@Query(value = "SELECT * FROM "+Constant.EDP_MASTER_SCHEMA+".MS_USER_TOKEN  WHERE USER_ID =:userId AND TOKEN_NO = :tokenNo AND VALIDITY_PERIOD > :currentDate " , nativeQuery = true)
	Optional<EDPMsUserToken> isOtpValid(long userId, String tokenNo , Date currentDate);

	/**
	 * Checks if is otp valid.
	 *
	 * @param userId the user id
	 * @param isValid the token no
	 * @param activeStatus the current date
	 * @return the list
	 */
	@Query(value = "SELECT * FROM "+Constant.EDP_MASTER_SCHEMA+".MS_USER_TOKEN  WHERE USER_ID =:userId AND IS_VALID = :isValid AND ACTIVE_STATUS= :activeStatus" , nativeQuery = true)
	Optional<EDPMsUserToken> isOtpValidatedForUser(long userId, int isValid , int activeStatus);
}
