package gov.ifms.doi.db.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.exception.BadRequestException;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.exception.GlobalExceptionHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import gov.ifms.doi.db.converter.TdoiDbClaimEntryConverter;
import gov.ifms.doi.db.converter.TdoiDbProposalConverter;
import gov.ifms.doi.db.dto.TdoiDbClaimEntryDTO;
import gov.ifms.doi.db.entity.TdoiDbClaimEntryEntity;
import gov.ifms.doi.db.entity.TdoiDbProposalEntity;
import gov.ifms.doi.db.repository.TdoiDbClaimEntryRepository;
import gov.ifms.doi.db.repository.TdoiDbProposalRepository;
import gov.ifms.doi.db.service.TdoiDbClaimEntryService;

@Service
public class TdoiDbClaimEntryServiceImpl implements TdoiDbClaimEntryService {

	@Autowired
	TdoiDbClaimEntryRepository repository;

	@Autowired
	TdoiDbProposalRepository proposalRepository;
	
	@Autowired
	TdoiDbClaimEntryConverter converter;
	@Autowired
	TdoiDbProposalConverter  proposalConverter;

	@Override
	public TdoiDbClaimEntryDTO saveOrUpdate(TdoiDbClaimEntryDTO dto)  {

	  
     	TdoiDbClaimEntryEntity tdoiDbClaimEntryEntity =converter.toEntity(dto);
    
     	repository.save(tdoiDbClaimEntryEntity);
     	return dto;
		
	}


	@Override
	public List<TdoiDbClaimEntryDTO> findAllByCriteria() {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


	@Override
	public List<TdoiDbClaimEntryDTO> findAllByStatus(TdoiDbClaimEntryDTO dto) {
		return converter.toDtoListFromEntityList(repository.findAllByStatus());
	}


	@Override
	public List<TdoiDbClaimEntryDTO> softDeleteById(Long id) {
		Optional<TdoiDbClaimEntryEntity> tdoiDbClaimEntryEntity =repository.findById(id);
		List<TdoiDbClaimEntryDTO> tdoiDbClaimEntryDTOs = new ArrayList<TdoiDbClaimEntryDTO>();
		if (tdoiDbClaimEntryEntity.isPresent()) {
			
			repository.delete(tdoiDbClaimEntryEntity.get());
	
			tdoiDbClaimEntryDTOs= converter.toDtoListFromEntityList(repository.findAllByStatus());
			
		}
		

		return tdoiDbClaimEntryDTOs;
		
	}

	@Override
	public TdoiDbClaimEntryDTO addClaim(TdoiDbClaimEntryDTO dto) {
		repository.save(converter.toEntity(dto));
		return dto;
	}

	@Override
	public List<TdoiDbClaimEntryDTO> fetchClaims() {
		return converter.toDtoListFromEntityList(repository.findAll());
	}


}

