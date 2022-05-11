package gov.ifms.pvu.converter;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Optional;

import gov.ifms.pvu.repository.PVUIncrementEmpSDRepository;
import gov.ifms.pvu.repository.PVUIncrementSTPSDRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.pvu.dto.PVUIncrementSTPSDDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUIncrementEmpSDEntity;
import gov.ifms.pvu.entity.PVUIncrementEventEntity;
import gov.ifms.pvu.entity.PVUIncrementSTPSDEntity;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUIncrementEventConverter class.
 * 
 * @version v 1.0
 * @created 2020/01/09 19:28:39
 *
 */
@Component
public class PVUIncrementSTPSDConverter implements BaseConverter<PVUIncrementSTPSDEntity, PVUIncrementSTPSDDto>
{

	public static final String MONTH = "Month";
	public static final String YEAR = "Year";
	public static final Character charYear = 'Y';
	public static final Character charMonth = 'M';


	@Autowired
	private PVUIncrementSTPSDRepository pvuIncrementSTPSDRepository;
	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUIncrementEvent entity
	 */
	@Override
	public PVUIncrementSTPSDEntity toEntity(PVUIncrementSTPSDDto dto) {
		PVUIncrementSTPSDEntity entity = new PVUIncrementSTPSDEntity();
		if((dto.getId()==0))
		{
			pvuIncrementSTPSDRepository.deleteByEmployeeSdid(dto.getInEventId());
		}
		else {
			Optional<PVUIncrementSTPSDEntity> sdEntity = pvuIncrementSTPSDRepository.findById(dto.getId());
			if (sdEntity.isPresent()) {
				entity = sdEntity.get();
			}
		}
		BeanUtils.copyProperties(dto, entity);

		if(dto.getResionForStop()!=null)
		{
			dto = dateCalculation(dto);
		}
		BeanUtils.copyProperties(dto, entity);
		if (!Utils.isEmpty(dto.getEmpId())) {
			entity.setEmpId(new PVUEmployeEntity(dto.getEmpId()));
		}
		if (!Utils.isEmpty(dto.getStatusId())) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if (!Utils.isEmpty(dto.getInEventId())) {
			entity.setInEventId(new PVUIncrementEventEntity(dto.getInEventId()));
		}

		if (!Utils.isEmpty(dto.getResionForStop())) {
			entity.setResionForStop(new EDPLuLookUpInfoEntity(dto.getResionForStop()));

		}
		if (dto.getStopIncrementDurationValue()!=null && dto.getStopIncrementDurationValue().equals(YEAR))
		{
			entity.setUnitYearMonth(charYear);
			entity.setDurationOfSTPIn(Long.valueOf(dto.getStopIncYearValue()));

		}
		else {
			if (dto.getStopIncrementDurationValue() != null && dto.getStopIncrementDurationValue().equals(MONTH)) {
				entity.setUnitYearMonth(charMonth);
				entity.setDurationOfSTPIn(Long.valueOf(dto.getStopIncMonthValue()));
			}
		}
		/*else
		{
			if (dto.getStopIncNumberValue()!=null)
			{
				entity.setUnitYearMonth(charYear);
				entity.setDurationOfSTPIn(Long.valueOf(dto.getStopIncNumberValue()));
			}
		}*/
		if (dto.getStopIncNumberValue()!=null)
		{
			entity.setNoOfSTPIn(Long.valueOf(dto.getStopIncNumberValue()));
		}



		entity.setPvuIncrementEmpSDEntity(new PVUIncrementEmpSDEntity(dto.getPvuIncrementEmpSDId()));
		return entity;
	}
	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUIncrementEvent dto
	 */
	@Override
	public PVUIncrementSTPSDDto toDTO(PVUIncrementSTPSDEntity entity) {
		PVUIncrementSTPSDDto dto = new PVUIncrementSTPSDDto();
		dto.setPvuIncrementEmpSDId(entity.getPvuIncrementEmpSDEntity().getIdEmpSDId());
		BeanUtils.copyProperties(entity, dto);
		if (!Utils.isEmpty(entity.getEmpId())) {
			dto.setEmpId(entity.getEmpId().getEmpId());
		}
		if (!Utils.isEmpty(entity.getStatusId())) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}
		if (!Utils.isEmpty(entity.getInEventId())) {
			dto.setInEventId(entity.getInEventId().getInEventId());
		}

		if (!Utils.isEmpty(entity.getResionForStop())) {
			dto.setResionForStop(entity.getResionForStop().getLookUpInfoId());
			dto.setResionForStopValue(entity.getResionForStop().getLookUpInfoName());
		}

		if (entity.getUnitYearMonth()==charYear)
		{
			dto.setStopIncrementDurationValue(YEAR);
			dto.setStopIncYearValue(String.valueOf(entity.getDurationOfSTPIn()));
		}
		else if(entity.getUnitYearMonth()==charMonth)
		{
			dto.setStopIncrementDurationValue(MONTH);
			dto.setStopIncMonthValue(String.valueOf(entity.getDurationOfSTPIn()));
		}
		if(entity.getNoOfSTPIn()!=null) {
 			dto.setStopIncNumberValue(String.valueOf(entity.getNoOfSTPIn()));
		}

		return dto;
	}

	public PVUIncrementSTPSDDto dateCalculation(PVUIncrementSTPSDDto dto){
		/*LocalDate pdate = LocalDate.of(2020, 1, 1);
		public static void main(String[] args) {
			 LocalDate pdate = LocalDate.of(2019, 03, 01);
				  long noOfYear=  3;
		long noOfInc 			=  2;*/
		LocalDate stopStartDate = PvuUtils.convertLocalDate(dto.getStpStartDate());
		long noOfYear  =0l;
		if(dto.getStopIncYearValue()!=null) {
			noOfYear = Long.parseLong(dto.getStopIncYearValue());
		}
		long noOfInc=0l;
		if(dto.getStopIncNumberValue()!=null) {
			 noOfInc = Long.parseLong(dto.getStopIncNumberValue());
			 if(noOfYear==0l)
			 {
			 	noOfYear=noOfInc;
			 }
		}

					LocalDate stopEndDate =  null;
					LocalDate witheldStartDate =  null;
					LocalDate witheldEndDate =  null;
					if(noOfYear  ==noOfInc) {
						witheldStartDate  =stopStartDate.plusYears(noOfYear);
						stopEndDate  =witheldStartDate.minusDays(1);
						witheldEndDate  =witheldStartDate.plusYears(noOfYear).minusDays(1);  
					}else if (noOfYear < noOfInc  ) {
						stopEndDate  =stopStartDate.plusYears(noOfInc).minusDays(1);
						witheldStartDate  =stopStartDate.plusYears(noOfYear);
						witheldEndDate  =witheldStartDate.plusYears(noOfInc).minusDays(1); 
					}
					else {
						stopEndDate  =stopStartDate.plusYears(noOfInc).minusDays(1);
						witheldStartDate  =  stopStartDate.plusYears(noOfYear);
						witheldEndDate =  witheldStartDate.plusYears(noOfInc).minusDays(1);
					}
					dto.setStpStartDate(dto.getStpStartDate());
					dto.setStpEndDate(PvuUtils.convertLocalDateToDate(stopEndDate));
					dto.setWhStartDate(PvuUtils.convertLocalDateToDate(witheldStartDate));
					dto.setWhEndDate(PvuUtils.convertLocalDateToDate(witheldEndDate));
					
		/*
		 * System.out.println("Effective Date:::"+stopStartDate);
		 * System.out.println("Without Future Effect");
		 * System.out.println("stop increment start date::::"+stopStartDate);
		 * System.out.println("stop increment end Date::::"+stopEndDate);
		 * System.out.println("withheld start date::::"+witheldStartDate);
		 * System.out.println("withheld end date::::"+witheldEndDate );
		 */
	    
		return dto;
	}

}
