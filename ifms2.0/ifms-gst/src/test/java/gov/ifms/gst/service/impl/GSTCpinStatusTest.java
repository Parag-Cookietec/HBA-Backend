package gov.ifms.gst.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.gst.pagination.SearchCriteria;
import gov.ifms.gst.pagination.SearchParam;
import gov.ifms.gst.pagination.SpecificationImpl;
import gov.ifms.gst.constant.JunitConstants;
import gov.ifms.gst.converter.GSTCPINStatusConvertor;
import gov.ifms.gst.dto.AmountDto;
import gov.ifms.gst.dto.GSTCPINStatusDto;
import gov.ifms.gst.dto.GetStatusDto;
import gov.ifms.gst.entity.EODCINFileData;
import gov.ifms.gst.entity.GSTCPINStatus;
import gov.ifms.gst.entity.RecordType;
import gov.ifms.gst.repository.GSTCINFileDataRepository;
import gov.ifms.gst.repository.GSTCPINStatusRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class GSTCpinStatusTest {
	@InjectMocks
	private GSTCPINStatusServiceImpl serviceImpl;

	@Mock
	private GSTCPINStatusConvertor convertor;

	@Mock
	private GSTCPINStatusRepository repository;

	@Mock
	private GSTCPINStatus entity;

	@Mock
	private GSTCPINStatusDto basePostDto;

	@Mock
	private GetStatusDto getStatusDto;

	@Mock
	private PageDetails pageDetail;
	@Mock
	private SearchParam searchParam;
	@Mock
	private GSTCINFileDataRepository fileDataRepository;
	@Mock
	private SearchCriteria searchCriteria;
	@Mock
	private EntityManager entityManager;
	@Mock
	private Query query1;
	@Mock
	private Query query;
	@Mock
	private PageRequest pageRequest;
	@Mock
	private Page<GSTCPINStatus> dtlPage;
	@Mock
	private EODCINFileData eodCinFile;
	@Mock
	private SpecificationImpl<GSTCPINStatus> dtlSpec;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test Search cpin and cin")
	void testSearch() {
		basePostDto = new GSTCPINStatusDto();
		basePostDto.setCinNo("ergvf");
		basePostDto.setRecordType(RecordType.CIN);
		if (basePostDto.getRecordType().equals(RecordType.CPIN)) {
			when(fileDataRepository.findByCpinNo(Long.parseLong(basePostDto.getCinNo())))
					.thenReturn(Optional.of(eodCinFile));
			if (Optional.of(eodCinFile).isPresent()) {
				getStatus(getStatusDto, eodCinFile);
			}
		} else if (basePostDto.getRecordType().equals(RecordType.CIN)) {
			EODCINFileData eodCinFile = new EODCINFileData();
			eodCinFile.setCinNo("SBIN3587769875");
			eodCinFile.setGstinTmpidNo("FUVVT56&*876");
			eodCinFile.setCgstFee(12.22);
			eodCinFile.setCgstIntr(12.22);
			eodCinFile.setCgstOth(12.22);
			eodCinFile.setCgstPenalty(12.22);
			eodCinFile.setCgstTax(12.22);
			eodCinFile.setCgstTotal(12.22);
			eodCinFile.setIgstFee(12.22);
			eodCinFile.setIgstIntr(12.22);
			eodCinFile.setIgstOth(12.22);
			eodCinFile.setIgstPenalty(12.22);
			eodCinFile.setIgstTax(12.22);
			eodCinFile.setIgstTotal(12.22);
			eodCinFile.setCessFee(12.22);
			eodCinFile.setCessIntr(12.22);
			eodCinFile.setCessOth(12.22);
			eodCinFile.setCessPenalty(12.22);
			eodCinFile.setCessTax(12.22);
			eodCinFile.setCessTotal(12.22);
			eodCinFile.setSgstFee(12.22);
			eodCinFile.setSgstIntr(12.22);
			eodCinFile.setSgstOth(12.22);
			eodCinFile.setSgstPenalty(12.22);
			eodCinFile.setSgstTax(12.22);
			eodCinFile.setSgstTotal(12.22);
			when(fileDataRepository.findByCinNo(basePostDto.getCinNo())).thenReturn(Optional.of(eodCinFile));
			
			if (Optional.of(eodCinFile).isPresent()) {
				getStatus(getStatusDto, eodCinFile);
			}
		}
		assertNotNull(serviceImpl.getCpinStatus(basePostDto));

	}

	@Test
	@DisplayName("Test Get Cpin Status.")
	void testGetStatus() throws CustomException {
		basePostDto = new GSTCPINStatusDto();
		basePostDto.setCpinNo(11l);
		when(repository.findByCpinNo(basePostDto.getCpinNo())).thenReturn(entity);
		when(convertor.toDTO(entity)).thenReturn(basePostDto);
		assertNotNull(serviceImpl.getStatus(basePostDto));
	}

	@Test
	@DisplayName("Create Get Status ")
	void save() throws CustomException {
		basePostDto.setCinNo("test");
		basePostDto.setCpinNo(11l);
		basePostDto.setCpinAmount(45.00);
		when(convertor.toEntity(basePostDto)).thenReturn(entity);
		when(repository.save(entity)).thenReturn(entity);
		when(convertor.toDTO(entity)).thenReturn(basePostDto);
		basePostDto.setId(1l);
		assertNotNull(serviceImpl.create(basePostDto));
	}

	private void getStatus(GetStatusDto d, EODCINFileData cpin) {
		d.setBankRefNum(5413);
		d.setBrName("dfvsd");
		d.setCinDt(cpin.getCreatedDate());
		d.setCinNo(cpin.getCinNo());
		d.setCpinNo(cpin.getCpinNo());
		d.setCpinDt(cpin.getCpinDt());
		d.setCpinDtTime(cpin.getCpinDtTime());
		d.setFileTypeCd(cpin.getFileTypeCd());
		d.setGstinTmpidNo(cpin.getGstinTmpidNo());
		d.setPaymentModeCd(cpin.getPaymentModeCd());
		d.setStateCd(cpin.getStateCd());
		d.setDto(amountMethod(cpin));
		d.setResponse(true);
		d.setBankCd(cpin.getCinNo().trim().substring(0, 4));
		try {
			when(entityManager.createNativeQuery(serviceImpl.PARTYNAME)).thenReturn(query1);
			query1.setParameter("gstin", cpin.getGstinTmpidNo());
			d.setPartyName((String) (query1.getSingleResult()));
		} catch (Exception ex) {
			d.setPartyName("NA");
		}
		try {
			when(entityManager.createNativeQuery(serviceImpl.QUERY)).thenReturn(query);
			query.setParameter("cin", cpin.getCinNo());
			Object[] object = (Object[]) query.getSingleResult();
			d.setScrollNo((String) (object[0]));
			d.setScrollDate(String.valueOf(object[1]).toString());
		} catch (Exception ex) {
			d.setScrollNo("NA");
			d.setScrollDate(null);
		}
	}

	private List<AmountDto> amountMethod(EODCINFileData resource) {
		List<AmountDto> amountDto = new ArrayList<>();
		AmountDto amountSGST = new AmountDto();
		amountSGST.setDesc("SGST");
		amountSGST.setFees(resource.getSgstFee());
		amountSGST.setInterest(resource.getSgstIntr());
		amountSGST.setOthers(resource.getSgstOth());
		amountSGST.setPenalty(resource.getSgstPenalty());
		amountSGST.setTax(resource.getSgstTax());
		amountSGST.setTotal(resource.getSgstTotal());
		amountDto.add(amountSGST);
		AmountDto amountCGST = new AmountDto();
		amountCGST.setDesc("CGST");
		amountCGST.setFees(resource.getCgstFee());
		amountCGST.setInterest(resource.getCgstIntr());
		amountCGST.setOthers(resource.getCgstOth());
		amountCGST.setPenalty(resource.getCgstPenalty());
		amountCGST.setTax(resource.getCgstTax());
		amountCGST.setTotal(resource.getCgstTotal());
		amountDto.add(amountCGST);
		AmountDto amountCess = new AmountDto();
		amountCess.setDesc("CESS");
		amountCess.setFees(resource.getCessFee());
		amountCess.setInterest(resource.getCessIntr());
		amountCess.setOthers(resource.getCessOth());
		amountCess.setPenalty(resource.getCessPenalty());
		amountCess.setTax(resource.getCessTax());
		amountCess.setTotal(resource.getCessTotal());
		amountDto.add(amountCess);
		AmountDto amountIGST = new AmountDto();
		amountIGST.setDesc("IGST");
		amountIGST.setFees(resource.getIgstFee());
		amountIGST.setInterest(resource.getIgstIntr());
		amountIGST.setOthers(resource.getIgstOth());
		amountIGST.setPenalty(resource.getIgstPenalty());
		amountIGST.setTax(resource.getIgstTax());
		amountIGST.setTotal(resource.getIgstTotal());
		amountDto.add(amountIGST);
		AmountDto amountTtl = new AmountDto();
		amountTtl.setDesc("Total");
		amountTtl
		.setFees(resource.getIgstFee() + resource.getSgstFee() + resource.getCgstFee() + resource.getCessFee());
amountTtl.setInterest(
		resource.getIgstIntr() + resource.getCessIntr() + resource.getCgstIntr() + resource.getSgstIntr());
amountTtl.setOthers(
		resource.getIgstOth() + resource.getCessOth() + resource.getCgstOth() + resource.getSgstOth());
amountTtl.setPenalty(resource.getIgstPenalty() + resource.getCessPenalty() + resource.getCgstPenalty()
		+ resource.getSgstPenalty());
amountTtl.setTax(resource.getIgstTax() + resource.getCessTax() + resource.getCgstTax() + resource.getSgstTax());
amountTtl.setTotal(
		resource.getIgstTotal() + resource.getCessTotal() + resource.getCgstTotal() + resource.getSgstTotal());
		amountDto.add(amountTtl);
		return amountDto;
	}

	@SuppressWarnings("unchecked")
	@Test
	@DisplayName("Test  Get All success.")
	void getAll() throws CustomException {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageRequest);
		List<SearchParam> searchParams = new ArrayList<>();
		searchParams.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(searchParams);
		when(searchCriteria.getSpecificationDetails(dtlSpec, searchParams)).thenReturn(dtlSpec);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class)))
				.thenReturn(dtlPage);
		when(dtlPage.getSize()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(dtlPage.getTotalPages()).thenReturn(JunitConstants.INTEGER_TYPE);
		when(dtlPage.getTotalElements()).thenReturn(JunitConstants.LONG_TYPE);
		List<GSTCPINStatus> dtlEntities = new ArrayList<>();
		dtlEntities.add(entity);
		List<GSTCPINStatusDto> dtos = new ArrayList<>();
		dtos.add(basePostDto);
		when(convertor.toDTO(dtlEntities)).thenReturn(dtos);
		assertNotNull(serviceImpl.getAll(pageDetail));
	}
}
