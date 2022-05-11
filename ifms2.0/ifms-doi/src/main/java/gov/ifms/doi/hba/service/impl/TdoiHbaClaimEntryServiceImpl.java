package gov.ifms.doi.hba.service.impl;

import java.util.ArrayList;
import java.util.List;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.doi.hba.dto.TdoiHbaClaimEntryListingDTO;
import gov.ifms.doi.hba.dto.TdoiHbaProposalListingDTO;
import gov.ifms.doi.hba.entity.TdoiHbaClaimEntryEntity;
import gov.ifms.doi.hba.entity.TdoiHbaProposalEntity;
import gov.ifms.doi.hba.utils.DoiConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import gov.ifms.doi.hba.converter.TdoiHbaClaimEntryConverter;
import gov.ifms.doi.hba.dto.TdoiHbaClaimEntryDTO;
import gov.ifms.doi.hba.repository.TdoiHbaClaimEntryRepository;
import gov.ifms.doi.hba.service.TdoiHbaClaimEntryService;

@Service
public class TdoiHbaClaimEntryServiceImpl implements TdoiHbaClaimEntryService {

	@Autowired
	TdoiHbaClaimEntryRepository repository;

	@Autowired
	TdoiHbaClaimEntryConverter converter;

	@Autowired
	DoiConverter doiConverter;

	@Override
	public List<TdoiHbaClaimEntryDTO> saveOrUpdate(TdoiHbaClaimEntryDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria();
	}


	@Override
	public List<TdoiHbaClaimEntryDTO> findAllByCriteria() {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiHbaClaimEntryDTO> findAllByStatus(TdoiHbaClaimEntryDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiHbaClaimEntryDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}

	@Override
	public PagebleDTO<TdoiHbaClaimEntryListingDTO> getClaimEntryListing(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SpecificationImpl<TdoiHbaClaimEntryEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<TdoiHbaClaimEntryEntity> dataSpec = getClaimEntrySpecificationDetail(spec,
					pageDetail.getJsonArr());
			List<TdoiHbaClaimEntryEntity> tdoiHbaProposalEntityList = repository.findAll(dataSpec);
			Page<TdoiHbaClaimEntryEntity> page = new PageImpl<>(tdoiHbaProposalEntityList,pageable,tdoiHbaProposalEntityList.size());
			List<TdoiHbaClaimEntryListingDTO> dtos = convertEntityToClaimEntryDto(page.getContent());
			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),dtos);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public <TdoiHbaClaimEntryEntity> Specification<TdoiHbaClaimEntryEntity> getClaimEntrySpecificationDetail(
			SpecificationImpl<TdoiHbaClaimEntryEntity> spec, List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			if (searchParam.getKey().equals("claimId") ) {
				spec.with("hbaClaimId", Constant.COLON,
						Integer.valueOf(searchParam.getValue()));
			}else if(searchParam.getKey().equals("policyNo")) {
				spec.with("hbaPolicyNo", Constant.COLON,searchParam.getValue());
			}else if(searchParam.getKey().equals("employeeName")) {
				spec.with("insuredName", Constant.COLON,searchParam.getValue());
			}else if(searchParam.getKey().equals("district")) {
				spec.with("tdoiHbaProposal.districtId", Constant.COLON,Long.parseLong(searchParam.getValue()));
			}else if(searchParam.getKey().equals("taluka")) {
				spec.with("tdoiHbaProposal.talukaId", Constant.COLON,Long.parseLong(searchParam.getValue()));
			}else if(searchParam.getKey().equals("month")) {
				spec.with("claimMonthId", Constant.COLON,Long.parseLong(searchParam.getValue()));
			}else if(searchParam.getKey().equals("year")) {
				spec.with("claimYearId", Constant.COLON,Long.parseLong(searchParam.getValue()));
			} else {
				spec.with(String.valueOf(searchParam.getKey()), Constant.COLON, String.valueOf(searchParam.getValue()));

			}
		}

		return spec.build();
	}

	private List<TdoiHbaClaimEntryListingDTO> convertEntityToClaimEntryDto(List<TdoiHbaClaimEntryEntity> tdoiHbaProposalEntityList) {
		List<TdoiHbaClaimEntryListingDTO> tdoiHbaClaimEntryListingDTOSList = new ArrayList<>();
		for (TdoiHbaClaimEntryEntity tdoiHbaClaimEntryEntity : tdoiHbaProposalEntityList) {
			TdoiHbaClaimEntryListingDTO tdoiHbaClaimEntryListingDTO = new TdoiHbaClaimEntryListingDTO();
			tdoiHbaClaimEntryListingDTO.setClaimId(tdoiHbaClaimEntryEntity.getHbaClaimId());
			tdoiHbaClaimEntryListingDTO.setCreatedDate(tdoiHbaClaimEntryEntity.getCreatedDate());
			tdoiHbaClaimEntryListingDTO.setEmployeeName(tdoiHbaClaimEntryEntity.getInsuredName());
			tdoiHbaClaimEntryListingDTO.setOfficeAddress(tdoiHbaClaimEntryEntity.getInsuredAddress());
			tdoiHbaClaimEntryListingDTO.setStatus("Status");
			tdoiHbaClaimEntryListingDTO.setUpdatedDate(tdoiHbaClaimEntryEntity.getUpdatedDate());
			tdoiHbaClaimEntryListingDTO.setInwardNo(tdoiHbaClaimEntryEntity.getInwardNo());
			tdoiHbaClaimEntryListingDTO.setPolicyNo(tdoiHbaClaimEntryEntity.getHbaPolicyNo());
			tdoiHbaClaimEntryListingDTO.setRiskCoveredId(tdoiHbaClaimEntryEntity.getTdoiHbaProposal().getRiskCoveredId());
			tdoiHbaClaimEntryListingDTOSList.add(tdoiHbaClaimEntryListingDTO);
		}
		return tdoiHbaClaimEntryListingDTOSList;
	}
}

