package gov.ifms.doi.jpa.service.imp;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.itextpdf.text.log.SysoCounter;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.doi.jpa.converter.DoiJPAClaimEntryConverter;
import gov.ifms.doi.jpa.dto.DoiJPAClaimEntryDTO;
import gov.ifms.doi.jpa.dto.DoiJpaClaimEntryListingDTO;
import gov.ifms.doi.jpa.entity.DoiJPAClaimEntryEntity;
import gov.ifms.doi.jpa.entity.DoiJPAMasterPolicy;
import gov.ifms.doi.jpa.pagination.Utility;
import gov.ifms.doi.jpa.repository.DoiJPAClaimEntryRepository;
import gov.ifms.doi.jpa.repository.DoiJPAMasterPolicyRepository;
import gov.ifms.doi.jpa.service.DoiJPAClaimEntryService;
import javassist.NotFoundException;

/**
 * 
 * @author Sagar Patil
 *
 */



@Service
public class DoiJPAClaimEntryServiceImpl implements DoiJPAClaimEntryService {
	//private static final Logger LOGGER = LoggerFactory.getLogger(DoiJPAClaimEntryServiceImpl.class);
	@Autowired
	private DoiJPAClaimEntryRepository doiJPAClaimEntryRepository;
	@Autowired
	private DoiJPAClaimEntryConverter converter;
	
	@Autowired 
	private DoiJPAMasterPolicyRepository masterPolicyRepo;
	
	@Autowired
	Utility utility;


	/**
	 * Convert given DoiJPAClaimEntryDTO to DoiJPAClaimEntryEntity Saves a given
	 * DoiJPAClaimEntryEntity. Use the returned instance for further operations as
	 * the save operation might have changed the entity instance completely.
	 *
	 * @param dto the dto
	 * @return the saved DoiJPAClaimEntryEntity
	 * @throws CustomException 
	 */
	
	@Override
	public DoiJPAClaimEntryDTO saveOrUpdate(DoiJPAClaimEntryDTO dto) throws CustomException {
		LocalDate date=LocalDate.now();
		//is Applicant Same
		if(dto.getAadharNum().equals(dto.getApplAadharNum())) {
			dto.setIsApplicantSame(1);
		}else {
			dto.setIsApplicantSame(0);
		}
		if(dto.getClaimMonthId()==null || dto.getClaimMonthId()<=0)
			dto.setClaimMonthId((long)date.getMonthValue());
		if(dto.getClaimYearId()==null || dto.getClaimYearId()<=0)
			dto.setClaimYearId((long)date.getYear());
		if(dto.getClaimGenerateDt()==null)
			dto.setClaimGenerateDt(new Date());
		
		if(StringUtils.isEmpty(dto.getClaimNumber())) {
			dto.setClaimNumber(utility.getClaimNumber());
		}
		
		DoiJPAMasterPolicy policyEntity = masterPolicyRepo.findByPolicyNumber(dto.getPolicyNum());
		if(policyEntity!=null)
		{
			
			Date currentDate = new Date(System.currentTimeMillis());
			
		if(policyEntity.getPolicyStartDate().compareTo(currentDate)<0   && policyEntity.getPolicyEndDate().compareTo(currentDate)>0  )
		{
		doiJPAClaimEntryRepository.save(converter.toEntity(dto));
		return dto;
		}
		else
		{ 
			
			throw new CustomException(HttpStatus.BAD_REQUEST, "Policy has been expired");
		}

		}else
		{
			throw new CustomException(HttpStatus.BAD_REQUEST, "Policy Number Invalid");
		}
		


	}

	@Override
	public List<DoiJPAClaimEntryDTO> findAllByCriteria(DoiJPAClaimEntryDTO dto) {
		List<DoiJPAClaimEntryEntity> entityList = doiJPAClaimEntryRepository.findAll();
		if(dto!=null) {
			entityList = entityList.stream().filter(entity -> filterData(dto, entity)).collect(Collectors.toList());
		}
		return converter.toDTOList(entityList);
	}
	
	@Override
	public List<DoiJpaClaimEntryListingDTO> findAllByClaimStatus(String claimStatus) {
		List<DoiJPAClaimEntryEntity> entityList = doiJPAClaimEntryRepository.findAllByClaimStatus(claimStatus);
		return converter.toResponseDTOList(entityList);
	}

	private boolean filterData(DoiJPAClaimEntryDTO claimData, DoiJPAClaimEntryEntity entity) {
		return (claimData.getPersonTypeId() == null || entity.getPersonTypeId().equals(claimData.getPersonTypeId())
				&& (claimData.getDistrictId() == null || entity.getDistrictId().equals(claimData.getDistrictId()))
				&& (claimData.getSchemeName() == null || entity.getSchemeName().equals(claimData.getSchemeName()))
				&& (claimData.getClaimMonthId() == null || entity.getClaimMonthId().equals(claimData.getClaimMonthId()))
				&& (claimData.getClaimYearId() == null || entity.getClaimYearId().equals(claimData.getClaimYearId()))
				);
	}

	/*
	 * private boolean fromDateToDate(DoiJPAClaimEntryDTO claimData,
	 * DoiJPAClaimEntryEntity entity) { try { LocalDate toDate =
	 * claimData.getToDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(
	 * ); LocalDate fromDate =
	 * claimData.getFromDate().toInstant().atZone(ZoneId.systemDefault()).
	 * toLocalDate(); LocalDate claimDate =
	 * entity.getClaimGenerateDt().toInstant().atZone(ZoneId.systemDefault()).
	 * toLocalDate();
	 * 
	 * return claimDate.isAfter(toDate) && claimDate.isBefore(fromDate);
	 * 
	 * } catch (Exception e) { LOGGER.error("fromDate and toDate not valid"); }
	 * return false; }
	 */

	@Override
	public DoiJPAClaimEntryDTO findClaimById(Long claimId) throws NotFoundException {
		Optional<DoiJPAClaimEntryEntity> optionlEntity = doiJPAClaimEntryRepository.findById(claimId);
		if(optionlEntity.isPresent()) {
			return converter.toDTO(optionlEntity.get());
		} else {
			throw new NotFoundException("Entered Claim numer is not valid");
		}
	}

	
}
