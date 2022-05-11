package gov.ifms.gst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.gst.converter.RBIFileTranxnConvertor;
import gov.ifms.gst.dto.RBIFileTranxnDto;
import gov.ifms.gst.repository.RBIFileTranxnRepository;

@Service
public class RBIFileTranxnServiceImpl {
	@Autowired
	private RBIFileTranxnConvertor convertor;

	@Autowired
	private RBIFileTranxnRepository repository;

	public List<RBIFileTranxnDto> searchByDate(RBIFileTranxnDto dto) {
		return convertor.toDTO(repository.findByRbiFileHdrId(dto.getRbiFileHdrId()));
	}

}
