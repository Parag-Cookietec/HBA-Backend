package gov.ifms.edp.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.edp.entity.EDPTedpUptTrnDataEntity;

/**
 * The Class EDPTedpUptTrnDataController.
 * 
 * @version 1.0
 * @created 2020/07/08 13:14:11
 */

@Repository
@Transactional
public interface EDPTedpUptTrnDataRepository
		extends JpaRepository<EDPTedpUptTrnDataEntity, Long>, JpaSpecificationExecutor<EDPTedpUptTrnDataEntity>,GenericDao {
	/**
	 * Deletes the EDPTedpUptTrnDataEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Modifying
	@Query(value = "update EDPTedpUptTrnDataEntity set activeStatus= :activeStatus , updatedBy=:updatedBy , "
			+ "updatedDate=:updatedDate where id = :id")
	public int deleteTedpUptTrnData(@Param("id") Long id, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") Long updatedBy, @Param("updatedDate") Date updatedDate);

	/**
	 * Update active status by header id.
	 *
	 * @param activeStatus  the active status
	 * @param updatedBy     the updated by
	 * @param updatedDate   the updated date
	 * @param tedpUptHdrId  the tedp upt hdr id
	 * @param updatedByPost the updated by post
	 * @return the int
	 */
	@Modifying
	@Query(value = "update EDPTedpUptTrnDataEntity set activeStatus= :activeStatus , updatedBy=:updatedBy, "
			+ "updatedDate=:updatedDate,updatedByPost=:updatedByPost  where tedpUptHdrId = :tedpUptHdrId")
	public int updateActiveStatusByHeaderId(@Param("activeStatus") int activeStatus, @Param("updatedBy") Long updatedBy,
			@Param("updatedDate") Date updatedDate, @Param("tedpUptHdrId") Long tedpUptHdrId,
			@Param("updatedByPost") Long updatedByPost);
	

}
