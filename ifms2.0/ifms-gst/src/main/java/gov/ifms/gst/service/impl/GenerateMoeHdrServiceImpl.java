package gov.ifms.gst.service.impl;

import java.sql.SQLException;
import java.util.*;

import gov.ifms.gst.workflow.dto.*;
import gov.ifms.gst.workflow.service.GstWfActionConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.pagination.SpecificationImpl;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.gst.converter.GenerateMoeHdrConvertor;
import gov.ifms.gst.dto.GSTMoeListingDTO;
import gov.ifms.gst.dto.GenerateMoeHdrDto;
import gov.ifms.gst.entity.GenerateMoeHdr;
import gov.ifms.gst.pagination.GstSearchCriteria;
import gov.ifms.gst.pagination.SpecificationImpl;
import gov.ifms.gst.repository.GSTBankRateMasterRepository;
import gov.ifms.gst.repository.GenerateMoeHdrRepository;
import gov.ifms.gst.util.GstDBConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerateMoeHdrServiceImpl {
	@Autowired
	private GenerateMoeHdrConvertor convertor;

	@Autowired
	private GenerateMoeHdrRepository repository;

	@Autowired
	private GstSearchCriteria searchCriteria;

	@Autowired
	private GstWfActionConfigService service;

	public GenerateMoeHdrDto getById(Long id) {
		return convertor.toDTO(repository.getOne(id));
	}

	public GenerateMoeHdrDto create(GenerateMoeHdrDto dto) {
		return convertor.toDTO(repository.save(convertor.toEntity(dto)));
	}

	public GenerateMoeHdrDto update(List<GenerateMoeHdrDto> dtos) {
		List<GenerateMoeHdr> generateMoeHdrList = convertor.toEntity(dtos);
		repository.saveAll(generateMoeHdrList);
		return null;
	}

	public PagebleDTO<GenerateMoeHdrDto> getAll(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SpecificationImpl<GenerateMoeHdr> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<GenerateMoeHdr> dataSpec = searchCriteria.getGenerateMoe(spec, pageDetail.getJsonArr());
			Page<GenerateMoeHdr> page = repository.findAll(dataSpec, pageable);
			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					convertor.toDTO(page.getContent()));
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	public PagebleDTO<GSTMoeListingDTO> getMoeListing(PageDetails pageDetail) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams
					.forEach(search -> map.put(GstDBConstants.getMoeListing().get(search.getKey()), search.getValue()));
		}
		GstDBConstants.getMoeListing().entrySet().stream().filter(e -> !map.containsKey(e.getValue()))
				.forEach(e -> map.put(e.getValue(), null));
		String procName = GstDBConstants.GST_SCHEMA.concat(Constant.DOT.concat(GstDBConstants.SP_GENERATE_MOE_LISTING));
		List<GSTMoeListingDTO> objectSp = null;
		try {
			objectSp = this.callStoreProc(procName, map, GSTMoeListingDTO.class);
		} catch (CustomException e1) {
			e1.printStackTrace();
		}
		long totalPages = !objectSp.isEmpty() ? objectSp.size() : 0;
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objectSp);
	}

	/**
	 * Call store proc.
	 *
	 * @param <T>      the generic type
	 * @param procName the proc name
	 * @param map      the map
	 * @param view     the view
	 *
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	private <T> List<T> callStoreProc(String procName, Map<String, Object> map, Class<T> view) throws CustomException {
		List<Object[]> objectSp = repository.callStoredProcedure(procName, map);
		return !objectSp.isEmpty() ? NativeQueryResultsMapper.map(objectSp, view) : Collections.emptyList();
	}

	public List<WfActionConfigSubmitTrnResDto> submitMOEWFAction(WfActionSubmitDto wfActionSubmitDto) throws SQLException, CustomException {
		List<WfActionConfigSubmitTrnResDto> responseList = new ArrayList<>();
		for (TrnDto trnDto : wfActionSubmitDto.getTrnDto()) {
			WfActionConfigSubmitTrnDto dto = new WfActionConfigSubmitTrnDto();
			List<WfActionConfigTrnDto> wfDetails = new ArrayList<>();
			WfActionConfigTrnDto wfActionConfigTrnDto = new WfActionConfigTrnDto();
			wfActionConfigTrnDto.setActionConfigId(wfActionSubmitDto.getActionConfigId());
			wfActionConfigTrnDto.setAssignedTo(wfActionSubmitDto.getAssignedTo());
			wfActionConfigTrnDto.setAssignedBy(wfActionSubmitDto.getAssignedBy());
			wfActionConfigTrnDto.setTrnId(trnDto.getTrnId());
			wfActionConfigTrnDto.setRemarks(trnDto.getRemarks());
			wfDetails.add(wfActionConfigTrnDto);
			dto.setWfDetails(wfDetails);
			List<WfActionConfigSubmitTrnResDto> returnList = service.submitWfActConfigTrn(dto);
			responseList.addAll(returnList);
		}

		return responseList;
	}

}
