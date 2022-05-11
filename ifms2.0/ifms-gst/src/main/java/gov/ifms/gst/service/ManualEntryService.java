package gov.ifms.gst.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.dto.HeadDto;
import gov.ifms.gst.dto.HeadwiseDetailDto;
import gov.ifms.gst.dto.ManualEntryDto;
import gov.ifms.gst.dto.ManualEntryLstResDto;
import gov.ifms.gst.dto.ManualEntryTypeDto;

import java.util.List;

public interface ManualEntryService {

	public List<ManualEntryTypeDto> getTypeList();

	public List<HeadDto> getMajorHeadList();

	public List<HeadDto> getSubMajorHeadList(HeadwiseDetailDto headwiseDetailDto);

	public List<HeadDto> getMinorHeadList(HeadwiseDetailDto headwiseDetailDto);

	public List<HeadDto> getSubHeadList(HeadwiseDetailDto headwiseDetailDto);

	public List<HeadDto> getDetailsHeadList(HeadwiseDetailDto headwiseDetailDto);

	public List<HeadDto> getObjectHeadList();

    public ManualEntryDto saveOrUpdate(ManualEntryDto dto) throws CustomException;

	PagebleDTO<ManualEntryDto> getManualEntryList(PageDetails pageDetail) throws CustomException;

    ManualEntryDto getById(Long id);

	void deleteById(Long id);

	PagebleDTO<ManualEntryLstResDto> getManualEntryWfList(PageDetails pageDetail) throws CustomException;
}
