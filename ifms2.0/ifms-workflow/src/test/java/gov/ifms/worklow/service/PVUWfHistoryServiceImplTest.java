package gov.ifms.worklow.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.workflow.dto.PVUWFReqHistoryDto;
import gov.ifms.workflow.dto.PVUWfHSTDto;
import gov.ifms.workflow.entity.LkMenuTblInfoEntity;
import gov.ifms.workflow.repository.LkMenuTblInfoRepository;
import gov.ifms.workflow.repository.WfRepository;
import gov.ifms.workflow.service.PVUWfHistoryServiceImpl;

/**
 * 
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
class PVUWfHistoryServiceImplTest {

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Mock
    private PVUWFReqHistoryDto dto;

    @Mock
    private PVUWFReqHistoryDto dto1;

    @InjectMocks
    private PVUWfHistoryServiceImpl service;

    @Mock
    List<PVUWfHSTDto> pvuWfHSTDtos;

    @Mock
    private LkMenuTblInfoRepository repository;

    @Mock
    private WfRepository wfRepo;


    @Mock
    private LkMenuTblInfoEntity lkMenuTblInfoEntity;
    @Mock
    private LkMenuTblInfoEntity lkMenuTblInfoEntity1;

    /**
     * @throws CustomException
     */
    @Test
    void getWFHistory() throws CustomException {
        when(dto.getTrnId()).thenReturn(1l);
        when(dto.getMenuId()).thenReturn(46l);
        when(dto.getOfficeId()).thenReturn(1l);
        when(dto.getEventId()).thenReturn(null);
        when(repository.findByMenuIdAndActiveStatusAndEventIdIsNull(dto.getMenuId(),Constant.ACTIVE_STATUS)).thenReturn(lkMenuTblInfoEntity);
        List<Object[]> arraylst = new ArrayList<>();
        Object[] obj = new Object[11];
        obj[0] = 1L;
        obj[1] = "ABV";
        obj[2] = "ABV";
        obj[3] = new Date();
        obj[4] = "ABV";
        obj[5] = "ABV";
        obj[6] = "ABV";
        obj[7] = "ABV";
        obj[8] = "ABV";
        obj[9] = "ABV";
        obj[10] = "ABV";
        arraylst.add(obj);
        when(wfRepo.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(arraylst);
        assertNotNull(service.getWFHistory(dto));
        when(dto.getEventId()).thenReturn(2l);
        when(repository.findByMenuIdAndActiveStatusAndEventId(dto.getMenuId(),Constant.ACTIVE_STATUS, dto.getEventId())).thenReturn(lkMenuTblInfoEntity1);
        when(wfRepo.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(arraylst);
        assertNotNull(service.getWFHistory(dto));
        List<Object[]> arraylst1 = new ArrayList<>();
        when(wfRepo.executeSQLQuery(Mockito.anyString(), Mockito.anyMap())).thenReturn(arraylst1);
        
    }

}