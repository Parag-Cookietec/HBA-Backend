package gov.ifms.doi.db.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the TDOI_DB_POL_ELEC_EQUIP database table.
 * 
 */

@Data
@Getter
@Setter
public class TdoiDbPolElecEquipDTO extends BaseDto {
	private static final long serialVersionUID = 1L;
	private long dbElecEquipId;
	private double aggrIndemLmt;
	private String anyFireInsrPol;
	private String anyPrevPolicy;
	private String anyStaffDiscount;
	private long bankId;
	private String bankName;
	private long branchId;
	private String branchName;
	private long businessTypeId;
	private double challanAmount;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date challanDt;
	private String challanNo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date chequeDdDt;
	private String chequeDdNo;
	private String codeSelected;
	private long codeTypeId;
	private long coinsurnceTypeId;
	private long complAccssIndemId;
	private String equipLocation;
	private String failEquipName;
	private String fireInsurerName;
	private String firePolicyNo;
	private String hasPrevCompDecl;
	private double indemInsurWeek;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date insrFrmDt;
	private double insrncPremium;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date insurToDt;
	private short insuranceMnths;
	private long insuranceTypeId;
	private String isEquipPartFail;
	private String isEquipUnderMaint;
	private String isOpStaffTrain;
	private String isRiReqd;
	private String maintEquipName;
	private String officeCodeNia;
	private String officeCodeOic;
	private String officeCodeOthr;
	private String officeCodeUii;
	private double payablePremAmt;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date paymentDate;
	private long paymentModeId;
	private double personalExpenses;
	private String policyStatus;
	private long policyTypeId;
	private double premDiscAmt;
	private double premDiscPc;
	private double premGstAmt;
	private double premGstPc;
	private String prevDeclDtls;
	private String prevInsrCompany;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date prevInsrExprDt;
	private long prevPolTypeId;
	private String prevPolicyNo;
	private short prevPolicyYear;
	private long propslPoliciesId;
	private long propslTypeId;
	private double rateOfIntrst;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;
	private String referenceNo;
	private long salaryRollNo;
	private double sharePcNiaAmt;
	private double sharePcOicAmt;
	private double sharePcOthrAmt;
	private double sharePcUiiAmt;
	private double substEquipRent;
	private double sumInsured;
	private double totAddonPrem;
	private double totRiAmt;
	private double totSumInsured;
	private double totalPremium;
	private double transportCost;
	private double uppLmtPerOccur;
	private TdoiDbProposalDTO tdoiDbProposal;
	private List<TdoiDbPolElecWfDTO> tdoiDbPolElecWfs;
	private List<TdoiDbPolEquipDtlDTO> tdoiDbPolEquipDtls;


}
