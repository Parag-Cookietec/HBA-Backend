/**
 * 
 */
package gov.ifms.doi.coinsurance.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


import gov.ifms.doi.coinsurance.dto.DoiCoinsChequeRegisterDTO;
import gov.ifms.doi.coinsurance.dto.DoiCoinsClaimHdrDTO;
import gov.ifms.doi.coinsurance.dto.DoiCoinsClaimRiDtlDTO;
import gov.ifms.doi.coinsurance.dto.DoiCoinsPolicyHdrDTO;
import gov.ifms.doi.coinsurance.dto.DoiCoinsPolicyRiDTO;
import gov.ifms.doi.coinsurance.dto.DoiCoinsPremiumRefundDTO;
import gov.ifms.doi.coinsurance.dto.DoiCoinsPremiumRegisterDTO;
import gov.ifms.doi.coinsurance.entity.DoiCoinsChequeRegisterEntity;
import gov.ifms.doi.coinsurance.entity.DoiCoinsClaimHdrEntity;
import gov.ifms.doi.coinsurance.entity.DoiCoinsClaimRiDtlEntity;
import gov.ifms.doi.coinsurance.entity.DoiCoinsPolicyHdrEntity;
import gov.ifms.doi.coinsurance.entity.DoiCoinsPolicyRiEntity;
import gov.ifms.doi.coinsurance.entity.DoiCoinsPremiumRefundEntity;
import gov.ifms.doi.coinsurance.entity.DoiCoinsPremiumRegisterEntity;
import gov.ifms.doi.jpa.pagination.PageDetails;
import gov.ifms.doi.jpa.pagination.SearchParam;

/**
 * @author Rudra
 *
 */
@Component
public class DoiCoInsuranceConverter {

	public DoiCoinsChequeRegisterEntity toCoinsChequeRegisterEntity(DoiCoinsChequeRegisterDTO dto) {
		DoiCoinsChequeRegisterEntity entity = new DoiCoinsChequeRegisterEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public List<DoiCoinsChequeRegisterDTO> toCoinsChequeRegisterDTOList(List<DoiCoinsChequeRegisterEntity> entityList) {
		List<DoiCoinsChequeRegisterDTO> dtoList = new ArrayList<>();
		entityList.forEach(entity -> dtoList.add(toCoinsChequeRegisterDTO(entity)));
		return dtoList;
	}

	public DoiCoinsChequeRegisterDTO toCoinsChequeRegisterDTO(DoiCoinsChequeRegisterEntity entity) {
		DoiCoinsChequeRegisterDTO dto = new DoiCoinsChequeRegisterDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public DoiCoinsPremiumRegisterEntity toCoinsPremiumRegisterEntity(DoiCoinsPremiumRegisterDTO dto) {
		DoiCoinsPremiumRegisterEntity entity = new DoiCoinsPremiumRegisterEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public DoiCoinsPolicyHdrEntity toCoinsPolicyHdrEntity(DoiCoinsPolicyHdrDTO dto) {
		DoiCoinsPolicyHdrEntity entity = new DoiCoinsPolicyHdrEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	public PageDetails convertMonthintoDate(PageDetails pageDetail)
	{
		 
		List<SearchParam> ls =pageDetail.getJsonArr();
	
		 SearchParam month = ls.stream().filter(l->l.getKey().equals("month")).findAny().orElse(null);
		 SearchParam Year = ls.stream().filter(l->l.getKey().equals("year")).findAny().orElse(null);
			 if(month.getValue().equals("Jan"))
			 {    SearchParam from = new SearchParam();
			    from.setKey("createdDate");
			    from.setValue("01/01/"+Year.getValue());
			    from.setOperation(">=");
			 SearchParam to = new SearchParam();
			 to.setKey("createdDate");
			 to.setValue("31/01/"+Year.getValue());
			 to.setOperation("<=");
				 ls.add(from);	 
				 ls.add(to);
				 
			 }else if(month.getValue().equals("Feb"))
			 {
				  SearchParam from = new SearchParam();
					 from.setKey("createdDate");
					 from.setValue("01/02/"+Year.getValue());
					 from.setOperation(">=");
					 SearchParam to = new SearchParam();
					 to.setKey("createdDate");
					 to.setValue("28/02/"+Year.getValue());
					 to.setOperation("<=");
						 ls.add(from);	 
						 ls.add(to);
					
				 
			 }else if(month.getValue().equals("Mar"))
			 {
				  SearchParam from = new SearchParam();
					 from.setKey("createdDate");
					 from.setValue("01/03/"+Year.getValue());
					 from.setOperation(">=");
					 SearchParam to = new SearchParam();
					 to.setKey("createdDate");
					 to.setValue("31/03/"+Year.getValue());
					 to.setOperation("<=");
						 ls.add(from);	 
						 ls.add(to);
					
				 
			 }else if(month.getValue().equals("Apr"))
			 {  SearchParam from = new SearchParam();
			 from.setKey("createdDate");
			 from.setValue("01/04/"+Year.getValue());
			 from.setOperation(">=");
			 SearchParam to = new SearchParam();
			 to.setKey("createdDate");
			 to.setValue("30/04/"+Year.getValue());
			 to.setOperation("<=");
				 ls.add(from);	 
				 ls.add(to);
			
				 
			 }else if(month.getValue().equals("May"))
			 {
				  SearchParam from = new SearchParam();
					 from.setKey("createdDate");
					 from.setValue("01/05/"+Year.getValue());
					 from.setOperation(">=");
					 SearchParam to = new SearchParam();
					 to.setKey("createdDate");
					 to.setValue("31/05/"+Year.getValue());
					 to.setOperation("<=");
						 ls.add(from);	 
						 ls.add(to);
					
			 }else if(month.getValue().equals("Jun"))
			 {
				  SearchParam from = new SearchParam();
					 from.setKey("createdDate");
					 from.setValue("01/06/"+Year.getValue());
					 from.setOperation(">=");
					 SearchParam to = new SearchParam();
					 to.setKey("createdDate");
					 to.setValue("30/06/"+Year.getValue());
					 to.setOperation("<=");
						 ls.add(from);	 
						 ls.add(to);
					 
			 }else if(month.getValue().equals("Jul"))
			 {  SearchParam from = new SearchParam();
			 from.setKey("createdDate");
			 from.setValue("01/07/"+Year.getValue());
			 from.setOperation(">=");
			 SearchParam to = new SearchParam();
			 to.setKey("createdDate");
			 to.setValue("31/07/"+Year.getValue());
			 to.setOperation("<=");
				 ls.add(from);	 
				 ls.add(to);
			
				 
			 }else if(month.getValue().equals("Aug"))
			 {
				  SearchParam from = new SearchParam();
					 from.setKey("createdDate");
					 from.setValue("01/08/"+Year.getValue());
					 from.setOperation(">=");
					 SearchParam to = new SearchParam();
					 to.setKey("createdDate");
					 to.setValue("31/08/"+Year.getValue());
					 to.setOperation("<=");
						 ls.add(from);	 
						 ls.add(to);
					
			 }else if(month.getValue().equals("Sept"))
			 {  SearchParam from = new SearchParam();
			 from.setKey("createdDate");
			 from.setValue("01/09/"+Year.getValue());
			 from.setOperation(">=");
			 SearchParam to = new SearchParam();
			 to.setKey("createdDate");
			 to.setValue("30/09/"+Year.getValue());
			 to.setOperation("<=");
				 ls.add(from);	 
				 ls.add(to);
			
				 
			 }else if(month.getValue().equals("Oct"))
			 {
				  SearchParam from = new SearchParam();
					 from.setKey("createdDate");
					 from.setValue("01/10/"+Year.getValue());
					 from.setOperation(">=");
					 SearchParam to = new SearchParam();
					 to.setKey("createdDate");
					 to.setValue("31/10/"+Year.getValue());
					 to.setOperation("<=");
						 ls.add(from);	 
						 ls.add(to);
						 
			 }else if(month.getValue().equals("Nov"))
			 {
				  SearchParam from = new SearchParam();
					 from.setKey("createdDate");
					 from.setValue("01/11/"+Year.getValue());
					 from.setOperation(">=");
					 SearchParam to = new SearchParam();
					 to.setKey("createdDate");
					 to.setValue("30/11/"+Year.getValue());
					 to.setOperation("<=");
						 ls.add(from);	 
						 ls.add(to);
					
			 }else if(month.getValue().equals("Dec"))
			 {
				  SearchParam from = new SearchParam();
					 from.setKey("createdDate");
					 from.setValue("01/12/"+Year.getValue());
					 from.setOperation(">=");
					 SearchParam to = new SearchParam();
					 to.setKey("createdDate");
					 to.setValue("31/12/"+Year.getValue());
					 to.setOperation("<=");
						 ls.add(from);	 
						 ls.add(to);
					
			 }
			 
		List<SearchParam> list =	 ls.stream().filter(l->!l.getKey().equals("month") && ! l.getKey().equals("year")).collect(Collectors.toList());
			 pageDetail.setJsonArr(list);

		return pageDetail;
		
		
		
	}

	public PageDetails convertCheqMonthintoDate(PageDetails pageDetail)
	{
		 
		List<SearchParam> ls =pageDetail.getJsonArr();
	
		 SearchParam month = ls.stream().filter(l->l.getKey().equals("month")).findAny().orElse(null);
		 SearchParam Year = ls.stream().filter(l->l.getKey().equals("year")).findAny().orElse(null);
			 if(month.getValue().equals("Jan"))
			 {    SearchParam from = new SearchParam();
			    from.setKey("createdDate");
			    from.setValue("01/01/"+Year.getValue());
			    from.setOperation(">=");
			 SearchParam to = new SearchParam();
			 to.setKey("createdDate");
			 to.setValue("31/01/"+Year.getValue());
			 to.setOperation("<=");
				 ls.add(from);	 
				 ls.add(to);
				 
			 }else if(month.getValue().equals("Feb"))
			 {
				  SearchParam from = new SearchParam();
					 from.setKey("createdDate");
					 from.setValue("01/02/"+Year.getValue());
					 from.setOperation(">=");
					 SearchParam to = new SearchParam();
					 to.setKey("createdDate");
					 to.setValue("28/02/"+Year.getValue());
					 to.setOperation("<=");
						 ls.add(from);	 
						 ls.add(to);
					
				 
			 }else if(month.getValue().equals("Mar"))
			 {
				  SearchParam from = new SearchParam();
					 from.setKey("createdDate");
					 from.setValue("01/03/"+Year.getValue());
					 from.setOperation(">=");
					 SearchParam to = new SearchParam();
					 to.setKey("createdDate");
					 to.setValue("31/03/"+Year.getValue());
					 to.setOperation("<=");
						 ls.add(from);	 
						 ls.add(to);
					
				 
			 }else if(month.getValue().equals("Apr"))
			 {  SearchParam from = new SearchParam();
			 from.setKey("createdDate");
			 from.setValue("01/04/"+Year.getValue());
			 from.setOperation(">=");
			 SearchParam to = new SearchParam();
			 to.setKey("createdDate");
			 to.setValue("30/04/"+Year.getValue());
			 to.setOperation("<=");
				 ls.add(from);	 
				 ls.add(to);
			
				 
			 }else if(month.getValue().equals("May"))
			 {
				  SearchParam from = new SearchParam();
					 from.setKey("createdDate");
					 from.setValue("01/05/"+Year.getValue());
					 from.setOperation(">=");
					 SearchParam to = new SearchParam();
					 to.setKey("createdDate");
					 to.setValue("31/05/"+Year.getValue());
					 to.setOperation("<=");
						 ls.add(from);	 
						 ls.add(to);
					
			 }else if(month.getValue().equals("Jun"))
			 {
				  SearchParam from = new SearchParam();
					 from.setKey("createdDate");
					 from.setValue("01/06/"+Year.getValue());
					 from.setOperation(">=");
					 SearchParam to = new SearchParam();
					 to.setKey("createdDate");
					 to.setValue("30/06/"+Year.getValue());
					 to.setOperation("<=");
						 ls.add(from);	 
						 ls.add(to);
					 
			 }else if(month.getValue().equals("Jul"))
			 {  SearchParam from = new SearchParam();
			 from.setKey("createdDate");
			 from.setValue("01/07/"+Year.getValue());
			 from.setOperation(">=");
			 SearchParam to = new SearchParam();
			 to.setKey("createdDate");
			 to.setValue("31/07/"+Year.getValue());
			 to.setOperation("<=");
				 ls.add(from);	 
				 ls.add(to);
			
				 
			 }else if(month.getValue().equals("Aug"))
			 {
				  SearchParam from = new SearchParam();
					 from.setKey("createdDate");
					 from.setValue("01/08/"+Year.getValue());
					 from.setOperation(">=");
					 SearchParam to = new SearchParam();
					 to.setKey("createdDate");
					 to.setValue("31/08/"+Year.getValue());
					 to.setOperation("<=");
						 ls.add(from);	 
						 ls.add(to);
					
			 }else if(month.getValue().equals("Sept"))
			 {  SearchParam from = new SearchParam();
			 from.setKey("createdDate");
			 from.setValue("01/09/"+Year.getValue());
			 from.setOperation(">=");
			 SearchParam to = new SearchParam();
			 to.setKey("createdDate");
			 to.setValue("30/09/"+Year.getValue());
			 to.setOperation("<=");
				 ls.add(from);	 
				 ls.add(to);
			
				 
			 }else if(month.getValue().equals("Oct"))
			 {
				  SearchParam from = new SearchParam();
					 from.setKey("createdDate");
					 from.setValue("01/10/"+Year.getValue());
					 from.setOperation(">=");
					 SearchParam to = new SearchParam();
					 to.setKey("createdDate");
					 to.setValue("31/10/"+Year.getValue());
					 to.setOperation("<=");
						 ls.add(from);	 
						 ls.add(to);
						 
			 }else if(month.getValue().equals("Nov"))
			 {
				  SearchParam from = new SearchParam();
					 from.setKey("createdDate");
					 from.setValue("01/11/"+Year.getValue());
					 from.setOperation(">=");
					 SearchParam to = new SearchParam();
					 to.setKey("createdDate");
					 to.setValue("30/11/"+Year.getValue());
					 to.setOperation("<=");
						 ls.add(from);	 
						 ls.add(to);
					
			 }else if(month.getValue().equals("Dec"))
			 {
				  SearchParam from = new SearchParam();
					 from.setKey("createdDate");
					 from.setValue("01/12/"+Year.getValue());
					 from.setOperation(">=");
					 SearchParam to = new SearchParam();
					 to.setKey("createdDate");
					 to.setValue("31/12/"+Year.getValue());
					 to.setOperation("<=");
						 ls.add(from);	 
						 ls.add(to);
					
			 }
			 
		List<SearchParam> list =	 ls.stream().filter(l->!l.getKey().equals("month") && ! l.getKey().equals("year")).collect(Collectors.toList());
			 pageDetail.setJsonArr(list);

		return pageDetail;
		
		
		
	}

	public DoiCoinsClaimHdrEntity toCoinsClaimHdrEntity(DoiCoinsClaimHdrDTO dto) {
		DoiCoinsClaimHdrEntity entity = new DoiCoinsClaimHdrEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public  List<DoiCoinsPolicyHdrDTO> toCoinsPolicyListing(List<DoiCoinsPolicyHdrEntity> entityList) {
		List<DoiCoinsPolicyHdrDTO> dtoList = new ArrayList<>();
		entityList.forEach(entity -> dtoList.add(toCoinsPolicyDTO(entity)));
		return dtoList;
	}

	private DoiCoinsPolicyHdrDTO toCoinsPolicyDTO(DoiCoinsPolicyHdrEntity entity) {
		DoiCoinsPolicyHdrDTO dto = new DoiCoinsPolicyHdrDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public List<DoiCoinsPremiumRefundDTO> toCoinsPremiumRefundList(List<DoiCoinsPremiumRefundEntity> entityList) {
		List<DoiCoinsPremiumRefundDTO> dtoList = new ArrayList<>();
		entityList.forEach(entity -> dtoList.add(toCoinsPremiumRefundDTO(entity)));
		return dtoList;
	}

	private DoiCoinsPremiumRefundDTO toCoinsPremiumRefundDTO(DoiCoinsPremiumRefundEntity entity) {
		DoiCoinsPremiumRefundDTO dto = new DoiCoinsPremiumRefundDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public DoiCoinsPremiumRefundEntity toCoinsPremiumRefundEntity(DoiCoinsPremiumRefundDTO dto) {
		DoiCoinsPremiumRefundEntity entity = new DoiCoinsPremiumRefundEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public List<DoiCoinsClaimHdrDTO> toCoinsClaimEntryListing(List<DoiCoinsClaimHdrEntity> entityList) {
		List<DoiCoinsClaimHdrDTO> dtoList = new ArrayList<>();
		entityList.forEach(entity -> dtoList.add(toCoinsClaimHdrDTO(entity)));
		return dtoList;
	}

	private DoiCoinsClaimHdrDTO toCoinsClaimHdrDTO(DoiCoinsClaimHdrEntity entity) {
		DoiCoinsClaimHdrDTO dto = new DoiCoinsClaimHdrDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public List<DoiCoinsPolicyRiEntity> toCoinsPolicyRiList(List<DoiCoinsPolicyRiDTO> dtoList) {
		List<DoiCoinsPolicyRiEntity> entityList = new ArrayList<>();
		dtoList.forEach(dto -> entityList.add(toCoinsPolicyRi(dto)));
		return entityList;
	}

	private DoiCoinsPolicyRiEntity toCoinsPolicyRi(DoiCoinsPolicyRiDTO dto) {
		DoiCoinsPolicyRiEntity entity = new DoiCoinsPolicyRiEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	public List<DoiCoinsClaimRiDtlEntity> toCoinsClaimRiList(List<DoiCoinsClaimRiDtlDTO> dtoList) {
		List<DoiCoinsClaimRiDtlEntity> entityList = new ArrayList<>();
		dtoList.forEach(dto -> entityList.add(toCoinsClaimRi(dto)));
		return entityList;
	}

	private DoiCoinsClaimRiDtlEntity toCoinsClaimRi(DoiCoinsClaimRiDtlDTO dto) {
		DoiCoinsClaimRiDtlEntity entity = new DoiCoinsClaimRiDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public List<DoiCoinsClaimHdrDTO> toClaimDtofromEntity(List<DoiCoinsClaimHdrEntity> entity) {
		List<DoiCoinsClaimHdrDTO> dto = new ArrayList<DoiCoinsClaimHdrDTO>();
		entity.forEach(e->dto.add(toCoinsClaimHdrDTO(e)));
		return dto;
	}
	
}
