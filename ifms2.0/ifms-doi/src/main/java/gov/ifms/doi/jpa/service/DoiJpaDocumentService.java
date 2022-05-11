/**
 * 
 */
package gov.ifms.doi.jpa.service;

import java.util.List;

import gov.ifms.doi.jpa.dto.DoiJpaCommonDocumentDTO;
import gov.ifms.doi.jpa.dto.DoiJpaDocumentResponseDTO;
import gov.ifms.doi.jpa.dto.DoiJpaLossCauseDocumentDTO;
import gov.ifms.doi.jpa.dto.DoiJpaSchemeDocumentDTO;

/**
 * @author Rudra
 *
 */
public interface DoiJpaDocumentService {

	List<DoiJpaCommonDocumentDTO> jpaCommonDocumentSaveOrUpdate(DoiJpaCommonDocumentDTO dto);

	List<DoiJpaSchemeDocumentDTO> jpaSchemeDocumentSaveOrUpdate(DoiJpaSchemeDocumentDTO dto);

	List<DoiJpaLossCauseDocumentDTO> jpaLossCauseDocumentSaveOrUpdate(DoiJpaLossCauseDocumentDTO dto);

	List<DoiJpaCommonDocumentDTO> jpaCommonDocumentDelete(Long commonDocID);

	List<DoiJpaSchemeDocumentDTO> jpaSchemeDocumentDelete(Long schemeDocID);

	List<DoiJpaLossCauseDocumentDTO> jpaLossCauseDocumentDelete(Long lossCauseDocID);

	List<DoiJpaCommonDocumentDTO> jpaCommonDocument();

	List<DoiJpaSchemeDocumentDTO> jpaSchemeDocument();

	List<DoiJpaLossCauseDocumentDTO> jpaLossCauseDocument();
	
	List<DoiJpaDocumentResponseDTO> jpaLossCauseDocumentList(Long lossCauseId, Long schemeId);
}
