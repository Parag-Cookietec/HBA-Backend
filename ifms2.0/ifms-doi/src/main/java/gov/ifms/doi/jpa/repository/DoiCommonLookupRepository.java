package gov.ifms.doi.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.ifms.doi.jpa.entity.DoiCommonLookUp;

/**
 * 
 * @author Sagar Jadhav
 *
 */
public interface DoiCommonLookupRepository extends JpaRepository<DoiCommonLookUp, Long> {

}
