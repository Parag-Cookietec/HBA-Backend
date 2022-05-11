package gov.ifms.doi.hba.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.GenericDao;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.doi.hba.dto.EmployeeDetailsDTO;
import gov.ifms.doi.hba.dto.TdoiHbaProposalListingDTO;
import gov.ifms.doi.hba.entity.TdoiHbaProposalEntity;
import gov.ifms.doi.hba.utils.QueryConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import gov.ifms.doi.hba.converter.TdoiHbaProposalConverter;
import gov.ifms.doi.hba.dto.TdoiHbaProposalDTO;
import gov.ifms.doi.hba.repository.TdoiHbaProposalRepository;
import gov.ifms.doi.hba.service.TdoiHbaProposalService;

@Service
public class TdoiHbaProposalServiceImpl implements TdoiHbaProposalService {

	@Autowired
	TdoiHbaProposalRepository repository;

	@Autowired
	TdoiHbaProposalConverter converter;

	@Override
	public List<TdoiHbaProposalDTO> saveOrUpdate(TdoiHbaProposalDTO dto) {
		repository.save(converter.toEntity(dto));
		return this.findAllByCriteria();
	}


	@Override
	public List<TdoiHbaProposalDTO> findAllByCriteria() {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiHbaProposalDTO> findAllByStatus(TdoiHbaProposalDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiHbaProposalDTO> softDeleteById(Long id) {
			repository.softDeleteById(id);
			return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}

	@Override
	public TdoiHbaProposalDTO getEmployeeDetails(String loanAccountNo) throws CustomException {
		EmployeeDetailsDTO employeeDetailsDTO = repository.executeSQLQuerySingle(QueryConstant.getEmployeeDetailsQrString(),
				QueryConstant.getEmployeeDetailsQrStringParamMap(loanAccountNo),EmployeeDetailsDTO.class);
		TdoiHbaProposalDTO tdoiHbaProposalDTO = new TdoiHbaProposalDTO();
		tdoiHbaProposalDTO.setLoanAccountNo(employeeDetailsDTO.getHbaMcaAccNum());
		tdoiHbaProposalDTO.setLoanAmount(employeeDetailsDTO.getLoanAmt());
		String employeeName = employeeDetailsDTO.getFirstName() + " " + employeeDetailsDTO.getMiddleName() + " " + employeeDetailsDTO.getLastName();
		tdoiHbaProposalDTO.setEmployeeName(employeeName);
		tdoiHbaProposalDTO.setEmployeeNo(employeeDetailsDTO.getEmployeeNum());
		tdoiHbaProposalDTO.setOfficeName(employeeDetailsDTO.getOfficeName());
		tdoiHbaProposalDTO.setOfficeAddress(employeeDetailsDTO.getOfficeAdd());

		String designationName = repository.executeSQLQuerySingle(QueryConstant.getDesignationDetailsQrString(),
				QueryConstant.getDesignationDetailsQrStringParamMap(employeeDetailsDTO.getDesignationId()),String.class);
		tdoiHbaProposalDTO.setDesignation(designationName);
		return tdoiHbaProposalDTO;
	}

	@Override
	public PagebleDTO<TdoiHbaProposalListingDTO> getPolicyProposalListing(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SpecificationImpl<TdoiHbaProposalEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<TdoiHbaProposalEntity> dataSpec = getHbaSpecificationDetail(spec,
					pageDetail.getJsonArr());
			List<TdoiHbaProposalEntity> tdoiHbaProposalEntityList = repository.findAll(dataSpec);
			Page<TdoiHbaProposalEntity> page = new PageImpl<>(tdoiHbaProposalEntityList,pageable,tdoiHbaProposalEntityList.size());
			List<TdoiHbaProposalListingDTO> dtos = convertEntityToProposalDto(page.getContent());
			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),dtos);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}


	public <TdoiHbaProposalEntity> Specification<TdoiHbaProposalEntity> getHbaSpecificationDetail(
			SpecificationImpl<TdoiHbaProposalEntity> spec, List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			if (searchParam.getKey().equals("proposalNo") ) {
				spec.with("hbaProposalId", Constant.COLON,
						Integer.valueOf(searchParam.getValue()));
			}else if(searchParam.getKey().equals("dppfLoanNo")) {
				spec.with("loanAccountNo", Constant.COLON,searchParam.getValue());
			}else if(searchParam.getKey().equals("employeeNumber")) {
				spec.with("employeeNo", Constant.COLON,searchParam.getValue());
			}else if(searchParam.getKey().equals("employeeName")) {
				spec.with("employeeName", Constant.COLON,searchParam.getValue());
			}else if(searchParam.getKey().equals("district")) {
				spec.with("districtId", Constant.COLON,Long.parseLong(searchParam.getValue()));
			}else if(searchParam.getKey().equals("taluka")) {
				spec.with("talukaId", Constant.COLON,Long.parseLong(searchParam.getValue()));
			} else {
				spec.with(String.valueOf(searchParam.getKey()), Constant.COLON, String.valueOf(searchParam.getValue()));

			}
		}

		return spec.build();
	}

	private List<TdoiHbaProposalListingDTO> convertEntityToProposalDto(List<TdoiHbaProposalEntity> tdoiHbaProposalEntityList){
		List<TdoiHbaProposalListingDTO> tdoiHbaProposalListingDTOS = new ArrayList<>();
		for (TdoiHbaProposalEntity tdoiHbaProposalEntity : tdoiHbaProposalEntityList){
			TdoiHbaProposalListingDTO tdoiHbaProposalListingDTO = new TdoiHbaProposalListingDTO();
			tdoiHbaProposalListingDTO.setHbaProposalId(tdoiHbaProposalEntity.getHbaProposalId());
			tdoiHbaProposalListingDTO.setProposalDate(tdoiHbaProposalEntity.getCreatedDate());
			tdoiHbaProposalListingDTO.setLoanAccountNo(tdoiHbaProposalEntity.getLoanAccountNo());
			tdoiHbaProposalListingDTO.setEmployeeName(tdoiHbaProposalEntity.getEmployeeName());
			tdoiHbaProposalListingDTO.setEmployeeNo(tdoiHbaProposalEntity.getEmployeeNo());
			tdoiHbaProposalListingDTO.setOfficeAddress(tdoiHbaProposalEntity.getOfficeAddress());
			tdoiHbaProposalListingDTO.setHouseAddress(tdoiHbaProposalEntity.getHouseAddress());
			tdoiHbaProposalListingDTO.setTermInsYrs(tdoiHbaProposalEntity.getTermInsYrs());
			tdoiHbaProposalListingDTO.setSumInsured(tdoiHbaProposalEntity.getSumInsured());
			tdoiHbaProposalListingDTO.setCreatedDate(tdoiHbaProposalEntity.getCreatedDate());
			tdoiHbaProposalListingDTO.setCreatedBy(tdoiHbaProposalEntity.getCreatedBy());
			tdoiHbaProposalListingDTO.setCreatedBy(tdoiHbaProposalEntity.getCreatedBy());
			tdoiHbaProposalListingDTO.setUpdatedBy(tdoiHbaProposalEntity.getUpdatedBy());
			tdoiHbaProposalListingDTO.setUpdatedDate(tdoiHbaProposalEntity.getUpdatedDate());
			tdoiHbaProposalListingDTO.setStatus("Success");
			tdoiHbaProposalListingDTOS.add(tdoiHbaProposalListingDTO);
		}
		return tdoiHbaProposalListingDTOS;
	}
}

