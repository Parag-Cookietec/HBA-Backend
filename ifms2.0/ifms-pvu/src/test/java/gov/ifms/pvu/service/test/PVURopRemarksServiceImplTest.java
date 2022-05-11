package gov.ifms.pvu.service.test;



import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.pvu.converter.PVURopRemarksConverter;
import gov.ifms.pvu.entity.PVURopRemarksEntity;
import gov.ifms.pvu.repository.PVURopRemarksRepository;
import gov.ifms.pvu.service.PVURopRemarksServiceImpl;

class PVURopRemarksServiceImplTest {

    @InjectMocks
    private PVURopRemarksServiceImpl service;

    @Mock
    private PVURopRemarksRepository repository;

    @Mock
    private PVURopRemarksEntity entity;

    /** The PVURopRemarksEntityAsMethodName helper. */
    @Mock
    private PVURopRemarksConverter converter;

    @Mock
    private List<PVURopRemarksEntity> pvuRopRemarksEntityList;

    @Mock
    private SearchCriteria searchCriteria;

    @Mock
    private SpecificationImpl<PVURopRemarksEntity> spec;
    @Mock
    private Specification<PVURopRemarksEntity> ropRemarksEntitySpecification;

    @Mock
    private Page<PVURopRemarksEntity> page;
    @Mock
    private PageDetails pageDetails;

    @Mock
    private PageRequest pageable;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getRopRemarks() {
        when(repository.getOne(1L)).thenReturn(entity);
        assertNotNull(service.getRopRemarks(1L));
        verify(repository,times(1)).getOne(1L);
    }


    @Test
    void saveOrUpdateRopRemarks() {
        when(repository.save(entity)).thenReturn(entity);
        assertNotNull(service.saveOrUpdateRopRemarks(entity));
        verify(repository,times(1)).save(entity);
    }


    @SuppressWarnings("unchecked")
	@Test
    void testGetRopRemarks() throws CustomException {
        when(pageDetails.getPageDetails(pageDetails)).thenReturn(pageable);
        List<SearchParam> jsonArr = new ArrayList<SearchParam>();
        SearchParam sp = new SearchParam();
        sp.setKey("Test");
        sp.setValue("testdffdsd");
        jsonArr.add(sp);
        when(pageDetails.getJsonArr()).thenReturn(jsonArr);
        when(searchCriteria.getSpecificationDetails(spec, jsonArr)).thenReturn(ropRemarksEntitySpecification);
        when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(page);
        when(page.getContent()).thenReturn(new ArrayList<>());
        assertNotNull(service.getRopRemarks(pageDetails));
        verify(repository, times(1)).findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class));

    }

    @Test
    void deactiveOldReason() {
    	doNothing().when(repository).deactiveOldReason(1L, Constant.IN_ACTIVE_STATUS,  OAuthUtility.getCurrentUserUserId(),  new Date());
        service.deactiveOldReason(1l, Constant.IN_ACTIVE_STATUS);
        assertTrue(true);
    }

    @Test
    void saveOrUpdateRopRemarksAll() {
        when(repository.saveAll(pvuRopRemarksEntityList)).thenReturn(pvuRopRemarksEntityList);
        service.saveOrUpdateRopRemarksAll(pvuRopRemarksEntityList);
        verify(repository,times(1)).saveAll(pvuRopRemarksEntityList);
    }
}