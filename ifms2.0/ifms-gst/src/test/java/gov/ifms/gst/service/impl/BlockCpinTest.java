package gov.ifms.gst.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
import gov.ifms.gst.converter.GSTBlockCPINConvertor;
import gov.ifms.gst.dto.GSTBlockCPINDto;
import gov.ifms.gst.entity.GSTBlockCPIN;
import gov.ifms.gst.repository.GSTBlockCPINRepository;

public class BlockCpinTest {

	@InjectMocks
	private GSTBlockCPINServiceImpl serviceImpl;

	@Mock
	private GSTBlockCPINConvertor convertor;

	@Mock
	private GSTBlockCPINRepository repository;
	@Mock
	private GSTBlockCPIN entity;

	@Mock
	private GSTBlockCPINDto basePostDto;
	@Mock
	private PageDetails pageDetail;
	@Mock
	private SearchParam searchParam;
	@Mock
	private SearchCriteria searchCriteria;
	@Mock
	private PageRequest pageRequest;
	@Mock
	private Page<GSTBlockCPIN> dtlPage;
	@Mock
	private SpecificationImpl<GSTBlockCPIN> dtlSpec;
	@Mock
	private EntityManager entityManager;
	@Mock
	private CriteriaBuilder criteriaBuilder;
	@Mock
	private CriteriaQuery<GSTBlockCPIN> cb;
	@Mock
	private Root<GSTBlockCPIN> root;
	@Mock
	private Predicate predicate;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
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
		List<GSTBlockCPIN> dtlEntities = new ArrayList<>();
		dtlEntities.add(entity);
		List<GSTBlockCPINDto> dtos = new ArrayList<>();
		dtos.add(basePostDto);
		when(convertor.toDTO(dtlEntities)).thenReturn(dtos);
		assertNotNull(serviceImpl.getAll(pageDetail));
	}

	@Test
	@DisplayName("Test Search")
	void testSearch() {
		basePostDto = new GSTBlockCPINDto();
		basePostDto.setReferenceNo("test");
		basePostDto.setFileName("Distributed");
		basePostDto.setCinNo("test");
		basePostDto.setGovtCreditDt(new Date());
		basePostDto.setCpinAmount(1.00);
		basePostDto.setCpinNo(1l);
		basePostDto.setReferenceDt(LocalDateTime.now());
		basePostDto.setCpinDt(new Date());
		when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
		when(criteriaBuilder.createQuery(GSTBlockCPIN.class)).thenReturn(cb);
		when(cb.from(GSTBlockCPIN.class)).thenReturn(root);
		List<Predicate> predicates = new ArrayList<>();

		if (null != basePostDto.getCinNo() && isNotEmpty(basePostDto.getCinNo())) {
			Path<String> exp = root.get("cinNo");
			when(criteriaBuilder.like(criteriaBuilder.upper(exp), "%" + basePostDto.getCinNo() + "%"))
					.thenReturn(predicate);
			predicates.add(predicate);
		}

		if (null != basePostDto.getGovtCreditDt()) {
			Path<Date> exp = root.get("govtCreditDt");
			when(criteriaBuilder.equal(exp, basePostDto.getGovtCreditDt())).thenReturn(predicate);
			predicates.add(predicate);
		}

		if (null != basePostDto.getCpinAmount()) {
			Path<String> exp = root.get("cpinAmount");
			when(criteriaBuilder.equal(exp, basePostDto.getCpinAmount())).thenReturn(predicate);
			predicates.add(predicate);
		}

		if (null != basePostDto.getCpinNo()) {
			Path<Long> exp = root.get("cpinNo");
			when(criteriaBuilder.equal(exp, basePostDto.getCpinNo())).thenReturn(predicate);
			predicates.add(predicate);
		}

		if (null != basePostDto.getCpinDt()) {
			Path<Date> exp = root.get("cpinDt");
			when(criteriaBuilder.equal(exp, basePostDto.getCpinDt())).thenReturn(predicate);
			predicates.add(predicate);
		}

		if (null != basePostDto.getReferenceDt()) {
			Path<Date> exp = root.get("referenceDt");
			predicates.add(predicate);
		}

		/**
		 * when(criteriaBuilder.and(predicates.toArray(new
		 * Predicate[predicates.size()]))).thenReturn(predicate);
		 * cb.select(root).where(predicate);
		 * convertor.toDTO(entityManager.createQuery(cb).getResultList());
		 **/
		assertNotNull(serviceImpl.list(0,0, basePostDto));
	}

	public static boolean isNotEmpty(String value) {
		return !isEmpty(value);
	}

	public static boolean isEmpty(String value) {
		return (value == null || value.trim().length() == 0);
	}
	@Test
	@DisplayName("Create Get Status ")
	void save() throws CustomException {
		entity = new GSTBlockCPIN();
		entity.setCinNo("test");
		entity.setCpinNo(11l);
		entity.setCpinAmount(45.00);
		entity.setRecStatus("NOT_PAID");
		if (entity.getRecStatus().equalsIgnoreCase("NOT_PAID")) {
			if (repository.findByCpinNo(entity.getCpinNo()) == null) {
				entity.setFileName("CN17012500000014");
				entity.setReferenceNo("21-22/EPAO/BCL/00002");
				entity.setReferenceDt(LocalDateTime.now());
				when(repository.save(entity));
			}
		}
		assertNotNull(serviceImpl.create(entity));

	}
}
