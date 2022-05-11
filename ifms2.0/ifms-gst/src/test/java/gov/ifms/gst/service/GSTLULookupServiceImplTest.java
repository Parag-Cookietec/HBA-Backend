package gov.ifms.gst.service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPLuLookUpEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.gst.repository.LuLookUpInfoRepository;
import gov.ifms.gst.repository.LuLookUpRepository;
import gov.ifms.gst.constant.JunitConstants;
import gov.ifms.gst.converter.GenerateMoeHdrConvertor;
import gov.ifms.gst.dto.GSTLULookupDto;
import gov.ifms.gst.dto.GenerateMoeHdrDto;
import gov.ifms.gst.entity.GenerateMoeHdr;
import gov.ifms.gst.pagination.GstSearchCriteria;
import gov.ifms.gst.pagination.SpecificationImpl;
import gov.ifms.gst.repository.GenerateMoeHdrRepository;
import gov.ifms.gst.service.impl.GSTLULookupServiceImpl;
import gov.ifms.gst.service.impl.GenerateMoeHdrServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

/**
 * The Class GSTLULookupServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class GSTLULookupServiceImplTest {

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
    private GSTLULookupServiceImpl service;

    @Mock
    LuLookUpRepository luLookUpRepository;

    @Mock
    LuLookUpInfoRepository luLookUpInfoRepository;

    @Mock
    private SpecificationImpl<GenerateMoeHdr> spec;

    @Mock
    private Page<GenerateMoeHdr> page;

    @Mock
    private EDPLuLookUpEntity edpLuLookUpEntity;

    @Mock
    private GSTLULookupDto lookUpDto;

    @Mock
    private EDPLuLookUpInfoEntity edpLuLookUpInfoEntity;

    /**
     * The page detail.
     */
    @Mock
    private PageDetails pageDetail;

    @Mock
    private PageRequest pageable;

    @Test
    void testFetchLookUpData() throws CustomException {

        when(lookUpDto.getName()).thenReturn(JunitConstants.STRING_ABC);
        when(luLookUpRepository.findByLookUpName(JunitConstants.STRING_ABC)).thenReturn(edpLuLookUpEntity);
        when(luLookUpInfoRepository
                        .findByEdpLuLookUpEntityLookUpIdAndActiveStatus(JunitConstants.LONG_TYPE, Constant.ACTIVE_STATUS))
                .thenReturn(Arrays.asList(new EDPLuLookUpInfoEntity[]{ edpLuLookUpInfoEntity}));
        when(edpLuLookUpInfoEntity.getLookUpInfoId()).thenReturn(JunitConstants.LONG_TYPE);
        when(edpLuLookUpInfoEntity.getLookUpInfoName()).thenReturn(JunitConstants.STRING_ABC);
        assertNotNull(service.fetchLookUpData(lookUpDto));
    }


}
