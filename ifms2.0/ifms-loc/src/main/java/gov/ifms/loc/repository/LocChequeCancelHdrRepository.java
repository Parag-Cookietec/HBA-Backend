package gov.ifms.loc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocChequeCancelHdrEntity;
import gov.ifms.loc.util.LocDBConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class LocChequeCancelHdrController.
 * 
 * @version v 1.0
 * @created 2021/03/05 17:12:26
 */

@Repository
@Transactional
public interface LocChequeCancelHdrRepository
		extends JpaRepository<LocChequeCancelHdrEntity, Long>, JpaSpecificationExecutor<LocChequeCancelHdrEntity>,GenericDao {

	/**
	 * Search cheque detail.
	 *
	 * @param chequeNo     the cheque no
	 * @param activeStatus the active status
	 * @return the list
	 */
	@Query(value =  LocDBConstants.GET_HEDER_CHECK_DATA, nativeQuery = true)
	List<Object[]> searchChequeDetail(@Param("chqNo") String chequeNo, @Param("activeStatus") int activeStatus);

	/**
	 * Deletes the LocChequeCancelHdrEntity with the given id.
	 *
	 * @param id must not be {@literal null}.
	 * @param activeStatus the active status
	 * @return the header advice list
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	

	@Query(value = LocDBConstants.GET_HEDER_CHECK_CANCEl_DATA, nativeQuery = true)
	List<Object[]> getHeaderAdviceList(Long id, int activeStatus);

	
	/**
	 * Gets the search param.
	 *
	 * @return the search param
	 */
	@Query(value = LocDBConstants.GET_CHECK_CANCEL_SRCH_PARAM, nativeQuery = true)
	List<Object[]> getSearchParam();


	/**
	 * Find by id and active status.
	 *
	 * @param hdrId the hdr id
	 * @param activeStatus the active status
	 * @return the loc cheque cancel hdr entity
	 */
	LocChequeCancelHdrEntity findByHdrIdAndActiveStatus(Long hdrId,int activeStatus);

	/**
	 * Find by active status and id.
	 *
	 * @param activeStatus the active status
	 * @param hdrId the hdr id
	 * @return the optional
	 */
	Optional<LocChequeCancelHdrEntity> findByActiveStatusAndHdrId(int activeStatus, Long hdrId);
	
	/**
	 * Search chq detail.
	 *
	 * @param lcID the lc ID
	 * @param activeStatus the active status
	 * @return the list
	 */
	@Query(value = LocDBConstants.GET_CHECK_CANCEL_LIST, nativeQuery = true)
	List<Object[]> searchChqDetail(@Param("lcId") Long lcID,@Param("activeStatus") int activeStatus);

	/**
	 * Gets the chq cncl hdr data.
	 *
	 * @param hdrId the hdr id
	 * @param activeStatus the active status
	 * @return the chq cncl hdr data
	 */
	@Query(value = LocDBConstants.GET_CHECK_CNCL_HDR_DATA, nativeQuery = true)
	List<Object[]> getChqCnclHdrData(Long hdrId, int activeStatus);
	
	/**
	 * Check chq cncl in process.
	 *
	 * @param chqNo the chq no
	 * @return the list
	 */
	@Query(value = LocDBConstants.GET_CHECK_CNCL_IN_PROCESS, nativeQuery = true)
	List<Object[]> checkChqCnclInProcess (@Param ("chqNo") String chqNo );

}
