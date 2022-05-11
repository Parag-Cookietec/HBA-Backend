/**
 * 
 */
package gov.ifms.doi.jpa.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.DoiJpaClaimListingRequestDTO;
import gov.ifms.doi.jpa.entity.DoiJPAClaimEntryEntity;

/**
 * @author Rudra
 *
 */
public class DoiJPAClaimEntryEntitySpecification implements Specification<DoiJPAClaimEntryEntity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8535878931516551885L;

	private DoiJpaClaimListingRequestDTO entityFilter;

	public DoiJPAClaimEntryEntitySpecification(DoiJpaClaimListingRequestDTO doiJPAClaimEntryEntityFilter) { 
		this.entityFilter = doiJPAClaimEntryEntityFilter;
	}

	@Override
	public Predicate toPredicate(Root<DoiJPAClaimEntryEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if(entityFilter.getClaimListingCriteria().equalsIgnoreCase(DoiJPAConstants.ACCEPTED_APPLICATION_LISTING)) {
        	return criteriaBuilder
        			.and(
        					criteriaBuilder.equal(root.get("personTypeId"), entityFilter.getDisabledDied()),
        					criteriaBuilder.equal(root.get("districtId"), entityFilter.getDistrict()), 
        					criteriaBuilder.equal(root.get("schemeId"), entityFilter.getSchemeType()),
        					criteriaBuilder.equal(root.get("claimMonthId"), entityFilter.getSchemeType()),
        					criteriaBuilder.equal(root.get("claimYearId"), entityFilter.getSchemeType()),
        					criteriaBuilder.between(root.get("claimGenerateDt"), entityFilter.getFromDate(), entityFilter.getEndDate())
        					); 
        } else {
        	return criteriaBuilder
        			.and(
        					criteriaBuilder.equal(root.get("districtId"), entityFilter.getDistrict()), 
        					criteriaBuilder.equal(root.get("schemeId"), entityFilter.getSchemeType()),
        					criteriaBuilder.equal(root.get("claimMonthId"), entityFilter.getSchemeType()),
        					criteriaBuilder.equal(root.get("claimYearId"), entityFilter.getSchemeType()),
        					criteriaBuilder.between(root.get("claimGenerateDt"), entityFilter.getFromDate(), entityFilter.getEndDate())
        					);
        } 
	}

}
