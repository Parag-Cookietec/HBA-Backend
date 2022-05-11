/**
 * 
 */
package gov.ifms.doi.jpa.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.converter.DoJpaDocumentConverter;
import gov.ifms.doi.jpa.dto.DoiJpaCommonDocumentDTO;
import gov.ifms.doi.jpa.dto.DoiJpaDocumentResponseDTO;
import gov.ifms.doi.jpa.dto.DoiJpaLossCauseDocumentDTO;
import gov.ifms.doi.jpa.dto.DoiJpaSchemeDocumentDTO;
import gov.ifms.doi.jpa.entity.DoiJpaCommonDocumentEntity;
import gov.ifms.doi.jpa.entity.DoiJpaLossCauseDocumentEntity;
import gov.ifms.doi.jpa.entity.DoiJpaSchemeDocumentEntity;
import gov.ifms.doi.jpa.pagination.Utility;
import gov.ifms.doi.jpa.repository.DoiJpaCommonDocumentRepository;
import gov.ifms.doi.jpa.repository.DoiJpaLossCauseDocumentRepository;
import gov.ifms.doi.jpa.repository.DoiJpaSchemeDocumentRepository;
import gov.ifms.doi.jpa.service.DoiJpaDocumentService;

/**
 * @author Rudra
 *
 */
@Service
public class DoiJpaDocumentServiceImpl implements DoiJpaDocumentService {

	@Autowired
	DoiJpaCommonDocumentRepository commonDocRepositoy;

	@Autowired
	DoiJpaSchemeDocumentRepository schemeDocRepositoy;

	@Autowired
	DoiJpaLossCauseDocumentRepository lossCauseRepositoy;

	@Autowired
	DoJpaDocumentConverter converter;

	@Autowired
	Utility utility;

	@Override
	public List<DoiJpaCommonDocumentDTO> jpaCommonDocument() {
		return converter.commonDocEntityListToDTOList(commonDocRepositoy.findAllByStatus());
	}

	@Override
	public List<DoiJpaSchemeDocumentDTO> jpaSchemeDocument() {
		return converter.schemeEntityListToDTOList(schemeDocRepositoy.findAllByStatus());
	}

	@Override
	public List<DoiJpaLossCauseDocumentDTO> jpaLossCauseDocument() {
		return converter.lossCauseEntityListToDTOList(lossCauseRepositoy.findAllByStatus());
	}

	@Override
	public List<DoiJpaCommonDocumentDTO> jpaCommonDocumentSaveOrUpdate(DoiJpaCommonDocumentDTO dto) {
		DoiJpaCommonDocumentEntity entity = converter.toCommonDocumentEntity(dto);
		if (StringUtils.isEmpty(dto.getRefNo())) {
			entity.setRefNo(utility.getRefrenceNumber());
		}
		if (dto.getId() != null) {
			commonDocRepositoy.softDeleteById(dto.getId());
			entity.setId(null);
		}
		commonDocRepositoy.save(entity);
		return jpaCommonDocument();
	}

	@Override
	public List<DoiJpaSchemeDocumentDTO> jpaSchemeDocumentSaveOrUpdate(DoiJpaSchemeDocumentDTO dto) {
		DoiJpaSchemeDocumentEntity entity = converter.toSchemeDocumentEntity(dto);
		if (StringUtils.isEmpty(dto.getRefNo())) {
			entity.setRefNo(utility.getRefrenceNumber());
		}
		if (dto.getId() != null) {
			schemeDocRepositoy.softDeleteById(dto.getId());
			entity.setId(null);
		}
		schemeDocRepositoy.save(entity);
		return jpaSchemeDocument();
	}

	@Override
	public List<DoiJpaLossCauseDocumentDTO> jpaLossCauseDocumentSaveOrUpdate(DoiJpaLossCauseDocumentDTO dto) {
		DoiJpaLossCauseDocumentEntity entity = converter.toLossCauseDocumentEntity(dto);
		if (StringUtils.isEmpty(dto.getRefNo())) {
			entity.setRefNo(utility.getRefrenceNumber());
		}
		if (dto.getId() != null) {
			lossCauseRepositoy.softDeleteById(dto.getId());
			entity.setId(null);
		}
		entity.setStatus(DoiJPAConstants.ACTIVE_STATUS_VALUE);
		lossCauseRepositoy.save(entity);
		return jpaLossCauseDocument();
	}

	@Override
	public List<DoiJpaCommonDocumentDTO> jpaCommonDocumentDelete(Long commonDocID) {
		commonDocRepositoy.softDeleteById(commonDocID);
		return jpaCommonDocument();
	}

	@Override
	public List<DoiJpaSchemeDocumentDTO> jpaSchemeDocumentDelete(Long schemeDocID) {
		schemeDocRepositoy.softDeleteById(schemeDocID);
		return jpaSchemeDocument();
	}

	@Override
	public List<DoiJpaLossCauseDocumentDTO> jpaLossCauseDocumentDelete(Long lossCauseDocID) {
		lossCauseRepositoy.softDeleteById(lossCauseDocID);
		return jpaLossCauseDocument();
	}

	@Override
	public List<DoiJpaDocumentResponseDTO> jpaLossCauseDocumentList(Long lossCauseId, Long schemeId) {
		List<DoiJpaDocumentResponseDTO> response = new ArrayList<>();
		List<DoiJpaCommonDocumentEntity> commonDoc=commonDocRepositoy.findAllByStatus();
		Long id=(long) 1;
		for(DoiJpaCommonDocumentEntity entity: commonDoc) {
			DoiJpaDocumentResponseDTO dto=new DoiJpaDocumentResponseDTO();
			dto.setId(id);
			dto.setDocument(entity.getDocument());		
			dto.setStatus(entity.getStatus());
			dto.setRequirement(entity.isRequirement());
			dto.setSchemeDoc(false);			
			dto.setLossCauseDoc(false);
			response.add(dto);
			id++;
		}
		List<DoiJpaSchemeDocumentEntity> schemeDoc=schemeDocRepositoy.findAllActiveBySchemeId(schemeId);
		
		for(DoiJpaSchemeDocumentEntity entity: schemeDoc) {
			DoiJpaDocumentResponseDTO dto=new DoiJpaDocumentResponseDTO();
			dto.setId(id);
			dto.setDocument(entity.getSchemeDocument());		
			dto.setStatus(entity.getStatus());
			dto.setRequirement(entity.isDocumentRequirement());
			dto.setSchemeDoc(true);			
			dto.setLossCauseDoc(false);
			response.add(dto);
			id++;
		}
		List<DoiJpaLossCauseDocumentEntity> lossCause=lossCauseRepositoy.findAllActiveByCauseTypeId(lossCauseId);
		
		for(DoiJpaLossCauseDocumentEntity entity: lossCause) {
			DoiJpaDocumentResponseDTO dto=new DoiJpaDocumentResponseDTO();
			dto.setId(id);
			dto.setDocument(entity.getCauseDocument());		
			dto.setStatus(entity.getStatus());
			dto.setRequirement(entity.isCauseRequirement());
			dto.setSchemeDoc(false);			
			dto.setLossCauseDoc(true);
			response.add(dto);
			id++;
		}
		return response;
	}
}
