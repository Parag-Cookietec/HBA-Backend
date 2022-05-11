package gov.ifms.gst.service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.pagination.SearchParam;
import gov.ifms.gst.constant.JunitConstants;
import gov.ifms.gst.converter.GenerateMoeHdrConvertor;
import gov.ifms.gst.dto.GSTBankWisePenalInterestDto;
import gov.ifms.gst.dto.GenerateMoeHdrDto;
import gov.ifms.gst.entity.*;
import gov.ifms.gst.pagination.GstSearchCriteria;
import gov.ifms.gst.pagination.SpecificationImpl;
import gov.ifms.gst.repository.GenerateMoeHdrRepository;
import gov.ifms.gst.service.impl.GenerateMoeHdrServiceImpl;
import gov.ifms.gst.util.DateUtil;
import gov.ifms.gst.util.GSTUtility;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

/**
 * The Class GenerateMoeHdrServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class GenerateMoeHdrServiceImplTest {

    /**
     * Sets the up.
     */
    @BeforeAll
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * The service impl.
     */

    @InjectMocks
    private GenerateMoeHdrServiceImpl service;

    @Mock
    private GenerateMoeHdrConvertor convertor;

    @Mock
    private GenerateMoeHdrRepository repository;

    @Mock
    private GstSearchCriteria searchCriteria;

    @Mock
    private SpecificationImpl<GenerateMoeHdr> spec;

    @Mock
    private Page<GenerateMoeHdr> page;

    @Mock
    private GenerateMoeHdr generateMoeHdr;

    @Mock
    private GenerateMoeHdrDto generateMoeHdrDto;

    /**
     * The page detail.
     */
    @Mock
    private PageDetails pageDetail;

    @Mock
    private PageRequest pageable;

    @Test
    void testGetAll() throws CustomException {

        when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
        SearchParam searchParam = new SearchParam();
        searchParam.setKey(JunitConstants.STRING_TYPE);
        searchParam.setValue(JunitConstants.STRING_TYPE);
        List<SearchParam> list = new ArrayList<>();
        list.add(searchParam);

        when(pageDetail.getJsonArr()).thenReturn(list);
        when(searchCriteria.getGenerateMoe(any(SpecificationImpl.class), anyList())).thenReturn(spec);
        List<GenerateMoeHdr> generateMoeHdrList = new ArrayList<>();
        generateMoeHdrList.add(generateMoeHdr);
        when(repository.findAll(spec, pageable)).thenReturn(page);
        when(page.getContent()).thenReturn(generateMoeHdrList);

        when(page.getTotalPages()).thenReturn(JunitConstants.INT_TYPE);
        when(page.getSize()).thenReturn(JunitConstants.INT_TYPE);
        when(page.getTotalElements()).thenReturn(JunitConstants.LONG_TYPE);

        assertNotNull(service.getAll(pageDetail));
    }

    @Test
    void testGetById() throws CustomException {

        when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(generateMoeHdr);
        when(convertor.toDTO(generateMoeHdr)).thenReturn(generateMoeHdrDto);

        assertNotNull(service.getById(JunitConstants.LONG_TYPE));

    }

    @Test
    void testUpdate() throws CustomException {

        List<GenerateMoeHdr> generateMoeHdrList = new ArrayList<>();
        generateMoeHdrList.add(generateMoeHdr);
        List<GenerateMoeHdrDto> generateMoeHdrDtos = new ArrayList<>();
        generateMoeHdrDtos.add(generateMoeHdrDto);
        when(convertor.toEntity(generateMoeHdrDtos)).thenReturn(generateMoeHdrList);

        when(generateMoeHdr.getMOE_STATUS()).thenReturn("created");

        assertNull(service.update(generateMoeHdrDtos));
    }

    @Test
    void testCreate() throws CustomException {

        when(convertor.toEntity(generateMoeHdrDto)).thenReturn(generateMoeHdr);
        when(repository.save(generateMoeHdr)).thenReturn(generateMoeHdr);
        when(convertor.toDTO(generateMoeHdr)).thenReturn(generateMoeHdrDto);
        assertNotNull(service.create(generateMoeHdrDto));

    }

}
