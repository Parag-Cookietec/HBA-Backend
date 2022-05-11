package gov.ifms.pvu.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import gov.ifms.pvu.dto.response.PVUPairView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.pvu.converter.PVUEmployeDepartmentConverter;
import gov.ifms.pvu.converter.PVUEmployeHistoryConverter;
import gov.ifms.pvu.dto.EmployeeChangeType;
import gov.ifms.pvu.dto.PVUEmployeDepartmentDto;
import gov.ifms.pvu.dto.PVUEmployeDepartmentDtos;
import gov.ifms.pvu.dto.PVUEmployeDepartmentUpdateDtos;
import gov.ifms.pvu.dto.PVUEmployeHistoryEditFormdataDto;
import gov.ifms.pvu.dto.PVUEmployeeDepartmentView;
import gov.ifms.pvu.dto.PVUEmployeeHistoryView;
import gov.ifms.pvu.dto.PVUEmployeeSqlQueries;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeHistoryEntity;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeHistoryRepository;
import gov.ifms.pvu.util.PvuUtils;


/**
 * The Class PVUEmployeDepartmentServiceImpl.
 *
 * @version v 1.0
 * @created 2019/11/21 14:17:25
 */
@Service
public class PVUEmployeDepartmentServiceImpl implements PVUEmployeDepartmentService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The PVUEmployeeDepartmentAsMethodName repository. */
	@Autowired
	private PVUEmployeDepartmentRepository repository;

	/** The PVUEmployeeDepartmentAsMethodName helper. */
	@Autowired
	private PVUEmployeDepartmentConverter converter;

	/** The pvu employe history repositary. */
	@Autowired
	private PVUEmployeHistoryRepository pvuEmployeHistoryRepositary;

	/** The pvu employe history converter. */
	@Autowired
	private PVUEmployeHistoryConverter pvuEmployeHistoryConverter;


	/**
	 * Saves a given PVUEmployeeDepartmentEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param dto the dto
	 * @return the saved PVUEmployeeDepartmentEntity
	 */
	@Override
	public PVUEmployeDepartmentDtos saveOrUpdateEmployeeDepartment(PVUEmployeDepartmentDtos dto) {
		PVUEmployeDepartmentDtos dtos = new PVUEmployeDepartmentDtos();
		PVUEmployeDepartmentEntity entity = null;
		try {
			entity = repository.findOneByPvuEmployeEntityEmpId(dto.getPvuEmployeDepartmentDto().getEmpId());
			if(entity != null) {
				dto.getPvuEmployeDepartmentDto().setDepartmentId(entity.getDepartmentId());
			}
			entity = repository.save(converter.toEntity(dto.getPvuEmployeDepartmentDto()));
			if (!CollectionUtils.isEmpty(dto.getPvuEmployeHistoryDto())) {
				List<PVUEmployeHistoryEntity> historyEntitys = pvuEmployeHistoryRepositary
						.saveAll(pvuEmployeHistoryConverter.toEntity(dto.getPvuEmployeHistoryDto()));
				dtos.setPvuEmployeHistoryDto(pvuEmployeHistoryConverter.toDTO(historyEntitys));
			}
			dtos.setPvuEmployeDepartmentDto(converter.toDTO(entity));
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return dtos;
	}

	/**
	 * Fetch all the PVUEmployeeDepartment items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeeDepartmentDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUEmployeDepartmentDto> getEmployeDepartments(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUEmployeDepartmentEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<PVUEmployeDepartmentEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<PVUEmployeDepartmentEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the employee department.
	 *
	 * @param empId the empId
	 * @return the employee department
	 */

	public PVUEmployeDepartmentDtos getEmployeeDepartment(Long empId) {
		PVUEmployeDepartmentDtos dtos = new PVUEmployeDepartmentDtos();
		try {
			List<PVUEmployeHistoryEntity> pvuEmployehistoryEntity = null;
			PVUEmployeDepartmentEntity pvuEmployedepartmentEntity = getEmployeDepartmentEntityByEmpId(empId);
			if (!StringUtils.isEmpty(pvuEmployedepartmentEntity)) {
				dtos.setPvuEmployeDepartmentDto(converter.toDTO(pvuEmployedepartmentEntity));
				pvuEmployehistoryEntity = pvuEmployeHistoryRepositary
						.findPVUEmployeHistoryEntityBypvuEmployeEntityEmpId(
								pvuEmployedepartmentEntity.getPvuEmployeEntity().getEmpId())
						.stream().filter(e -> e.getActiveStatus() == Constant.ACTIVE_STATUS)
						.collect(Collectors.toList());
				dtos.setPvuEmployeHistoryDto(pvuEmployeHistoryConverter.toDTO(pvuEmployehistoryEntity));
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return dtos;
	}

	/**
	 * Gets the class id by emp id.
	 *
	 * @param empId the emp id
	 * @return the class id by emp id
	 */
	public long getClassIdByEmpId(Long empId) {
		PVUEmployeDepartmentEntity pvuEmployedepartmentEntity = repository.findOneByPvuEmployeEntityEmpId(empId);
		return pvuEmployedepartmentEntity.getEmpClass() != null
				? pvuEmployedepartmentEntity.getEmpClass().getLookUpInfoId()
				: 0;
	}
	
	/**
	 * Gets the employe department entity by emp id.
	 *
	 * @param empId the emp id
	 * @return the employe department entity by emp id
	 */
	@Override
	public PVUEmployeDepartmentEntity getEmployeDepartmentEntityByEmpId(Long empId) {
		PVUEmployeDepartmentEntity pvuEmployedepartmentEntity = repository.findOneByPvuEmployeEntityEmpId(empId);
		return pvuEmployedepartmentEntity;
	}
	
	/**
	 * Save employee department.
	 *
	 * @param pvuEmployedepartmentEntity the pvu employedepartment entity
	 * @return the PVU employe department entity
	 */
	@Override
	public PVUEmployeDepartmentEntity saveEmployeeDepartment(PVUEmployeDepartmentEntity pvuEmployedepartmentEntity) {
		PVUEmployeDepartmentEntity entity = repository.save(pvuEmployedepartmentEntity);
		return entity;
	}
	
	@Override
	public PVUEmployeDepartmentUpdateDtos editEmployeeDepartment(PVUEmployeDepartmentUpdateDtos dto,EmployeeChangeType type) {
		PVUEmployeDepartmentUpdateDtos dtos = new PVUEmployeDepartmentUpdateDtos();
		PVUEmployeDepartmentEntity entity = null;
		try {
			if (dto.getPvuEmployeDepartmentDto() != null) {
				entity = repository.findOneByPvuEmployeEntityEmpId(dto.getPvuEmployeDepartmentDto().getEmpId());
				if (entity != null && PvuUtils.getChangeType(dto.getPvuEmployeDepartmentDto().getChangeType())) {
					dto.getPvuEmployeDepartmentDto().setDepartmentId(entity.getDepartmentId());
					repository.save(converter.toEditEntity(entity , dto.getPvuEmployeDepartmentDto()));
					type.setEmpDpttype(entity.getChangeType());
				}
				if (!CollectionUtils.isEmpty(dto.getPvuEmployeHistoryDto())) {
					List<PVUEmployeHistoryEntity>  list = new ArrayList<>();
					for (PVUEmployeHistoryEditFormdataDto hDto : dto.getPvuEmployeHistoryDto()) {
						validateHistoryofEmployee(type, list, hDto);
					}
					pvuEmployeHistoryRepositary.saveAll(list);
				}
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return dtos;
	}

	private void validateHistoryofEmployee(EmployeeChangeType type, List<PVUEmployeHistoryEntity> list, PVUEmployeHistoryEditFormdataDto hDto) {
		if (hDto != null) {
			Optional<PVUEmployeHistoryEntity> historyEntity = pvuEmployeHistoryRepositary
					.findById(hDto.getEmployeHistroyId());
			if (hDto.getChangeType() == 1 && historyEntity.isPresent()) {
					type.setEmpHis(hDto.getChangeType());
					list.add(pvuEmployeHistoryConverter.toEntityUpdate(historyEntity.get(), hDto));
			}
			if ( hDto.getChangeType() == 3 && historyEntity.isPresent()) {
					type.setEmpHis(hDto.getChangeType());
					PVUEmployeHistoryEntity hentity = historyEntity.get();
					hentity.setActiveStatus(Constant.IN_ACTIVE_STATUS);
					list.add(hentity);
			}
			if (hDto.getChangeType() == 2) {
				type.setEmpHis(hDto.getChangeType());
				PVUEmployeHistoryEntity hentity = new PVUEmployeHistoryEntity();
				list.add(pvuEmployeHistoryConverter.toEntityUpdate(hentity, hDto));
			}
		}
	}


	@Override
	public List<PVUEmployeeHistoryView> getQuerieOfHistoryOfEmpPRVHistByEmpId(IdDto idDtod) throws CustomException {
		StringBuilder sb = new StringBuilder();
		PVUEmployeeSqlQueries.getQuerieOfHistoryOfEmpPRVHistByEmpId(idDtod, sb);
		List<Object[]> objectPvuSp = repository.executeSQLQueryOnly(sb.toString());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeeHistoryView.class)
				: Collections.emptyList();
	}

	@Override
	public List<PVUEmployeeDepartmentView> getQuerieOfHistoryOfEmpDepartmentByEmpId(IdDto idDtod) throws CustomException {
		StringBuilder sb = new StringBuilder();
		PVUEmployeeSqlQueries.getQuerieOfHistoryOfEmpDepartmentByEmpId(idDtod, sb); 
		List<Object[]> objectPvuSp = repository.executeSQLQueryOnly(sb.toString());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeeDepartmentView.class)
				: Collections.emptyList();
	}

	public List<PVUPairView> getOfficeDetailsByCardexAndDDOAndDId(long districtId, long dooNo , long cardexNo) throws CustomException {
		StringBuilder sb = new StringBuilder();
		if(dooNo == 0 || cardexNo == 0){
			return null;
		}
		PVUEmployeeSqlQueries.getOfficeDetailsByCardexAndDDOAndDId( districtId,  dooNo ,  cardexNo ,sb);
		List<Object[]> objectPvuSp = repository.executeSQLQueryOnly(sb.toString());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUPairView.class)
				: Collections.emptyList();
	}
	
}
