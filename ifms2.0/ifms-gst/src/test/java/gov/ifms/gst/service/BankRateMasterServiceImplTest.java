package gov.ifms.gst.service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.pagination.SearchParam;
import gov.ifms.gst.constant.JunitConstants;
import gov.ifms.gst.converter.GSTBankRateMasterConverter;
import gov.ifms.gst.converter.GenerateMoeHdrConvertor;
import gov.ifms.gst.dto.GSTBankRateMasterDto;
import gov.ifms.gst.dto.GenerateMoeHdrDto;
import gov.ifms.gst.entity.GSTBankRateMaster;
import gov.ifms.gst.entity.GenerateMoeHdr;
import gov.ifms.gst.pagination.GstSearchCriteria;
import gov.ifms.gst.pagination.SpecificationImpl;
import gov.ifms.gst.repository.GSTBankRateMasterRepository;
import gov.ifms.gst.repository.GenerateMoeHdrRepository;
import gov.ifms.gst.service.impl.GSTBankRateMasterServiceImpl;
import gov.ifms.gst.service.impl.GenerateMoeHdrServiceImpl;
import gov.ifms.gst.workflow.dto.WfUserReqSDDto;
import gov.ifms.gst.workflow.service.GstWfActionConfigService;
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
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.when;

/**
 * The Class BankRateMasterServiceImplTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class BankRateMasterServiceImplTest {

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
    private GSTBankRateMasterServiceImpl service;

    @Mock
    private GSTBankRateMasterConverter bankRateMasterConverter;

    @Mock
    private GSTBankRateMasterRepository bankRateMasterRepository;

    @Mock
    private GstWfActionConfigService gstWfActionConfigService;

    @Mock
    private GstSearchCriteria searchCriteria;

    @Mock
    private SpecificationImpl<GSTBankRateMaster> spec;

    @Mock
    private Page<GSTBankRateMaster> page;

    @Mock
    private GSTBankRateMaster bankRateMaster;

    @Mock
    private GSTBankRateMasterDto gstBankRateMasterDto;

    @Mock
    private WfUserReqSDDto wfUserReqSDDto;

    /**
     * The page detail.
     */
    @Mock
    private PageDetails pageDetail;

    @Mock
    private PageRequest pageable;

    @Test
    void testGetBankRateMasters() throws CustomException {

        when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
        SearchParam searchParam = new SearchParam();
        searchParam.setKey(JunitConstants.STRING_TYPE);
        searchParam.setValue(JunitConstants.STRING_TYPE);
        List<SearchParam> list = new ArrayList<>();
        list.add(searchParam);

        when(pageDetail.getJsonArr()).thenReturn(list);
        when(searchCriteria.getGenerateMoe(any(SpecificationImpl.class), anyList())).thenReturn(spec);
        List<GSTBankRateMaster> gstBankRateMasters = new ArrayList<>();
        gstBankRateMasters.add(bankRateMaster);
        when(bankRateMasterRepository.findAll(spec, pageable)).thenReturn(page);
        when(page.getContent()).thenReturn(gstBankRateMasters);

        when(page.getTotalPages()).thenReturn(JunitConstants.INT_TYPE);
        when(page.getSize()).thenReturn(JunitConstants.INT_TYPE);
        when(page.getTotalElements()).thenReturn(JunitConstants.LONG_TYPE);

        assertNotNull(service.getBankRateMasters(pageDetail));
    }

    @Test
    void testGetBankRateMaster() throws CustomException {

        when(bankRateMasterRepository.getOne(JunitConstants.LONG_TYPE)).thenReturn(bankRateMaster);
        when(bankRateMasterConverter.toDTO(bankRateMaster)).thenReturn(gstBankRateMasterDto);

        assertNotNull(service.getBankRateMaster(JunitConstants.LONG_TYPE));

    }

    @Test
    void testUpdateBankRateMaster() throws CustomException {

        when(gstBankRateMasterDto.getBankRate()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(gstBankRateMasterDto.getAdditionalRate()).thenReturn(JunitConstants.DOUBLE_VAL);

        when(bankRateMasterConverter.toEntity(gstBankRateMasterDto)).thenReturn(bankRateMaster);
        when(bankRateMasterRepository.save(bankRateMaster)).thenReturn(bankRateMaster);
        when(bankRateMasterConverter.toDTO(bankRateMaster)).thenReturn(gstBankRateMasterDto);

        assertNotNull(service.updateBankRateMaster(gstBankRateMasterDto));
    }

    @Test
    void testCreateBankRateMaster() throws CustomException {

        when(gstBankRateMasterDto.getId()).thenReturn(JunitConstants.LONG_TYPE);
        when(gstBankRateMasterDto.getBankRate()).thenReturn(JunitConstants.DOUBLE_VAL);
        when(gstBankRateMasterDto.getAdditionalRate()).thenReturn(JunitConstants.DOUBLE_VAL);

        List<Object[]> transSeq = Arrays.asList(new String[][]{new String[]{JunitConstants.STRING_ABC}});
        when(bankRateMasterRepository.callStoredProcedure(anyString(), anyMap())).thenReturn(transSeq);

        when(bankRateMasterConverter.toEntity(gstBankRateMasterDto)).thenReturn(bankRateMaster);
        when(bankRateMasterRepository.save(bankRateMaster)).thenReturn(bankRateMaster);
        when(bankRateMasterConverter.toDTO(bankRateMaster)).thenReturn(gstBankRateMasterDto);

        when(gstBankRateMasterDto.getMenuId()).thenReturn(JunitConstants.LONG_TYPE);
        when(gstBankRateMasterDto.getId()).thenReturn(JunitConstants.LONG_TYPE);

        when(gstWfActionConfigService.saveWfActConfigTrn(wfUserReqSDDto)).thenReturn(JunitConstants.INTEGER_TYPE);

        assertNotNull(service.createBankRateMaster(gstBankRateMasterDto));
    }

}
