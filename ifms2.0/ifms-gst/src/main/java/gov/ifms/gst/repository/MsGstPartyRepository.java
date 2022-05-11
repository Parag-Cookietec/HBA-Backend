/*
 * 
 */
package gov.ifms.gst.repository;

import gov.ifms.gst.entity.MsGstParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MsGstPartyRepository
		extends JpaRepository<MsGstParty, Long>, JpaSpecificationExecutor<MsGstParty> {

		MsGstParty findByGstin(String gstin);
}
