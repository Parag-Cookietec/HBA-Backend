package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.core.io.InputStreamResource;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Class ClueDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClueDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Long id;

	/** The name. */
	private String name;

	/** The code. */
	private String code;

	/** The code name. */
	private String codeName;

	/** The i S gaid id. */
	private Long iSGaidId;

	/** The is cnm id. */
	private Long isCnmId;

	/** The is brek up needed id. */
	private Integer isBrekUpNeededId;

	/** The is recovery id. */
	private Integer isRecoveryId;

	/** The sector head code. */
	private Long sectorHeadCode;

	/** The sub sector code. */
	private Long subSectorCode;

	/** The sub sub sector code. */
	private Long subSubSectorCode;

	/** The major head sub type. */
	private String majorHeadSubType;

	/** The major head sub type id. */
	private Long majorHeadSubTypeId;

	/** The description. */
	private String description;

	/** The parent id. */
	private Long parentId;

	/** The taluka. */
	private List<ClueDto> taluka;

	/** The tresury type. */
	private List<ClueDto> tresuryType;

	/** The std code. */
	private String stdCode;

	/** The count. */
	private Long count;

	/** The wf branch id. */
	private Long wfBranchId;

	/** The wf role ids. */
	private List<Long> wfRoleIds;

	/** The active post. */
	private List<ClueDto> activePost;

	/** The flag. */
	private Boolean flag;

	/** The attachment type. */
	private Long attachmentType;

	/** The tedp upt id. */
	private Long tedpUptId;

	/** The designation id. */
	private Long designationId;

	/** The trn no. */
	private String trnNo;

	/** The office list. */
	private List<ClueDto> officeList;

	/** The cardex no. */
	private Long cardexNo;

	/** The ddo no. */
	private String ddoNo;

	/** The office id. */
	private Long officeId;

	/** The image. */
	private String image;

	/** The user name. */
	private String userName;

	/** The is update. */
	private Boolean isUpdate;

	/** The active status. */
	private Integer activeStatus;

	/** The is current year. */
	private Integer isCurrentYear;

	/** The financial year. */
	private ClueDto financialYear;

	/** The budget estimate type. */
	private List<ClueDto> budgetEstimateType;

	/** The wf role code. */
	private List<String> wfRoleCode;

	/** The estimation from id. */
	private Long estimationFromId;

	/** The financial year id. */
	private Long financialYearId;

	/** The department id. */
	private Long departmentId;

	/** The majorhead id. */
	private Long majorheadId;

	/** The major head list. */
	private List<ClueDto> majorHeadList;

	/** The status list. */
	private List<ClueDto> statusList;

	/** The department name. */
	private String departmentName;

	/** The office name. */
	private String officeName;

	/** The financial year. */
	private List<ClueDto> financialYears;

	/** The departments. */
	private List<ClueDto> departmentList;

	/** The demands. */
	private List<ClueDto> demandList;

	/** The sub major head list. */
	private List<ClueDto> subMajorHeadList;

	/** The minor head list. */
	private List<ClueDto> minorHeadList;

	/** The sub head list. */
	private List<ClueDto> subHeadList;

	/** The trn ref no list. */
	private List<ClueDto> trnRefNoList;

	/** The rev or cap. */
	private List<ClueDto> revOrCap;

	/** The locality list. */
	private List<ClueDto> localityList;

	/** The division list. */
	private List<ClueDto> divisionList;

	/** The post office id. */
	private Long postOfficeId;

	/** The will be primary. */
	private Boolean willBePrimary;
	/** The fy start. */
	private Integer fyStart;

	/** The module list. */
	private List<ClueDto> moduleList;

	/** The submodule list. */
	private List<ClueDto> submoduleList;

	/** The menu list. */
	private List<ClueDto> menuList;

	/** The submodule list. */
	private List<ClueDto> listValue;

	/** The menu role prm. */
	private String menuRolePrm;

	/** The menu wf role. */
	private String menuWfRole;

	/** The wf role list. */
	private Set<ClueDto> wfRoleList;

	/** The role prm list. */
	private ClueDto rolePrmList;

	/** The role prm. */
	private Set<String> rolePrm;

	/** The lk menu office type id. */
	private Long menuOfficeTypeId;

	/** The is wf role removed. */
	private Boolean isWfRoleRemoved;

	/** The module. */
	private String module;

	/** The module id. */
	private Long moduleId;

	/** The sub module. */
	private String subModule;

	/** The sub module id. */
	private Long subModuleId;

	/** The major head code. */
	private String majorHeadCode;

	/** The minor head code. */
	private String minorHeadCode;

	/** The rev cap id. */
	private Long revCapId;

	/** The menu. */
	private String menu;

	/** The menu id. */
	private Long menuId;

	/** The role name. */
	private String roleName;

	/** The mod office type id. */
	private Long modOfficeTypeId;

	/** The districts. */
	private List<ClueDto> districts;

	/** The trans status list. */
	private List<ClueDto> transStatusList;

	/** The work flow status list. */
	private List<ClueDto> workFlowStatusList;

	/** The status id. */
	private String statusId;

	/** The district list. */
	private List<ClueDto> districtList;
	
	/** The district dto. */
	private ClueDto districtDto;

	/** The is dat user. */
	private Boolean isDatUser;

	/** The hod list. */
	private List<ClueDto> hodList;
	
	/** The districtid. */
	private Long districtid;
	
	/** The level. */
	private List<ClueDto> officeLevel;
	
	/** The office type. */
	private List<ClueDto> officeType;
	
	/** The office designation. */
	private List<ClueDto> officeDesignation;
	
	/** The controlling office. */
	private List<ClueDto> controllingOffice;
	
    /** The bill type. */
    private List<ClueDto> billType;
 
    /** The office status. */
    private List<ClueDto> officeStatus;
    
    /** The pvu office. */
    private List<ClueDto> pvuOffice;
    
    /** The ddo type. */
    private List<ClueDto> ddoType;
    
	/** The request types. */
	private List<ClueDto> requestTypes;

 	
    /** The page index. */
	private Long pageIndex;

	/** The page size. */
	private Long pageSize;
	
	/** The charge voted. */
	private List<ClueDto> chargeVoted;
	
	/** The document id. */
	private String documentId;
	
	/** The document name. */
	private String documentUploadedFilePath;
	
	/** The document. */
	private InputStreamResource document;
	
	/** The wf roles. */
	private Set<String> wfRoles;
		
	/** The logged in dept id. */
	private Long loggedInDeptId;

	/** The district name. */
	private String districtName;

	
 	/**
	  * Gets the logged in dept id.
	  *
	  * @return the logged in dept id
	  */
	 public Long getLoggedInDeptId() {
		return loggedInDeptId;
	}

	/**
	 * Sets the logged in dept id.
	 *
	 * @param loggedInDeptId the new logged in dept id
	 */
	public void setLoggedInDeptId(Long loggedInDeptId) {
		this.loggedInDeptId = loggedInDeptId;
	}

	/** The cheque types. */
	private List<ClueDto> chequeTypes;

	/** The accounts list. */
	private List<ClueDto> accountsList;

	/** The bank id. */
	private Long bankId;

	/** The bank name. */
	private String bankName;

	/** The bank branch id. */
	private Long bankBranchId;

	/** The bank branch name. */
	private String bankBranchName;

	/** The banks list. */
	private List<ClueDto> banksList;

	/** The bank branch list. */
	private List<ClueDto> bankBranchList;

	/** The cheque formats. */
	private List<ClueDto> chequeFormats;

	/** The cheque leaves. */
	private List<ClueDto> chequeLeaves;
	
	
	/** The cheque format. */
	private String  chequeFormat;
	
	/** The cheque type name. */
	private String  chequeTypeName;
	
	/** The cheque type. */
	private Long  chequeType;
	
	/** The yearly required qty. */
	private Long reqNoOfChequeBooks;

	/** The no of cheques per book. */
	private Long  reqNoOfChequePerBook;

	/** The balance quantity. */
	private Long  balanceQuantity;
	
	/** The to wf status. */
	private String  toWfStatus;
	
	/** The to status. */
	private String  toStatus;
	
	
	
 	/**
	  * Gets the charge voted.
	  *
	  * @return the chargeVoted
	  */
	public List<ClueDto> getChargeVoted() {
		return chargeVoted;
	}

	/**
	 * Sets the charge voted.
	 *
	 * @param chargeVoted the chargeVoted to set
	 */
	public void setChargeVoted(List<ClueDto> chargeVoted) {
		this.chargeVoted = chargeVoted;
	}

	/**
	 * Gets the pvu office.
	 *
	 * @return the pvuOffice
	 */
	public List<ClueDto> getPvuOffice() {
		return pvuOffice;
	}

	/**
	 * Sets the pvu office.
	 *
	 * @param pvuOffice the pvuOffice to set
	 */
	public void setPvuOffice(List<ClueDto> pvuOffice) {
		this.pvuOffice = pvuOffice;
	}

	/**
	 * Gets the office status.
	 *
	 * @return the officeStatus
	 */
	public List<ClueDto> getOfficeStatus() {
		return officeStatus;
	}

	/**
	 * Sets the office status.
	 *
	 * @param officeStatus the officeStatus to set
	 */
	public void setOfficeStatus(List<ClueDto> officeStatus) {
		this.officeStatus = officeStatus;
	}

	/**
	 * Gets the bill type.
	 *
	 * @return the billType
	 */
	public List<ClueDto> getBillType() {
		return billType;
	}

	/**
	 * Sets the bill type.
	 *
	 * @param billType the billType to set
	 */
	public void setBillType(List<ClueDto> billType) {
		this.billType = billType;
	}

	/**
	 * Gets the controlling office.
	 *
	 * @return the controllingOffice
	 */
	public List<ClueDto> getControllingOffice() {
		return controllingOffice;
	}

	/**
	 * Sets the controlling office.
	 *
	 * @param controllingOffice the controllingOffice to set
	 */
	public void setControllingOffice(List<ClueDto> controllingOffice) {
		this.controllingOffice = controllingOffice;
	}

	/**
	 * Gets the office designation.
	 *
	 * @return the officeDesignation
	 */
	public List<ClueDto> getOfficeDesignation() {
		return officeDesignation;
	}

	/**
	 * Sets the office designation.
	 *
	 * @param officeDesignation the officeDesignation to set
	 */
	public void setOfficeDesignation(List<ClueDto> officeDesignation) {
		this.officeDesignation = officeDesignation;
	}

	/**
	 * Gets the office type.
	 *
	 * @return the officeType
	 */
	public List<ClueDto> getOfficeType() {
		return officeType;
	}

	/**
	 * Sets the office type.
	 *
	 * @param officeType the officeType to set
	 */
	public void setOfficeType(List<ClueDto> officeType) {
		this.officeType = officeType;
	}

	/** The wf status list. */
	private List<ClueDto> wfStatusList;

	/**
	 * Gets the wf status list.
	 *
	 * @return the wf status list
	 */
	public List<ClueDto> getWfStatusList() {
		return wfStatusList;
	}

	/**
	 * Sets the wf status list.
	 *
	 * @param wfStatusList the new wf status list
	 */
	public void setWfStatusList(List<ClueDto> wfStatusList) {
		this.wfStatusList = wfStatusList;
	}

	/**
	 * Gets the district list.
	 *
	 * @return the district list
	 */
	public List<ClueDto> getDistrictList() {
		return districtList;

	}

	/**
	 * Sets the district list.
	 *
	 * @param districtList the new district list
	 */
	public void setDistrictList(List<ClueDto> districtList) {
		this.districtList = districtList;
	}

	/**
	 * Gets the estimation from id.
	 *
	 * @return the estimation from id
	 */
	public Long getEstimationFromId() {
		return estimationFromId;
	}

	/**
	 * Sets the estimation from id.
	 *
	 * @param estimationFromId the estimationFromId to set
	 */
	public void setEstimationFromId(Long estimationFromId) {
		this.estimationFromId = estimationFromId;
	}

	/** The condition lookup. */
	private List<ClueDto> conditionLookup;

	/** The class lookup. */
	private List<ClueDto> classLookup;

	/** The quality certificate lookup. */
	private List<ClueDto> qualityCertificateLookup;

	/**
	 * Gets the wf role code.
	 *
	 * @return the wf role code
	 */
	public List<String> getWfRoleCode() {
		return wfRoleCode;
	}

	/**
	 * Sets the wf role code.
	 *
	 * @param wfRoleCode the new wf role code
	 */
	public void setWfRoleCode(List<String> wfRoleCode) {
		this.wfRoleCode = wfRoleCode;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the code name.
	 *
	 * @return the code name
	 */
	public String getCodeName() {
		return codeName;
	}

	/**
	 * Sets the code name.
	 *
	 * @param codeName the new code name
	 */
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	/**
	 * Gets the i S gaid id.
	 *
	 * @return the i S gaid id
	 */
	public Long getiSGaidId() {
		return iSGaidId;
	}

	/**
	 * Sets the i S gaid id.
	 *
	 * @param iSGaidId the new i S gaid id
	 */
	public void setiSGaidId(Long iSGaidId) {
		this.iSGaidId = iSGaidId;
	}

	/**
	 * Gets the checks if is cnm id.
	 *
	 * @return the checks if is cnm id
	 */
	public Long getIsCnmId() {
		return isCnmId;
	}

	/**
	 * Sets the checks if is cnm id.
	 *
	 * @param isCnmId the new checks if is cnm id
	 */
	public void setIsCnmId(Long isCnmId) {
		this.isCnmId = isCnmId;
	}

	/**
	 * Gets the checks if is brek up needed id.
	 *
	 * @return the checks if is brek up needed id
	 */
	public Integer getIsBrekUpNeededId() {
		return isBrekUpNeededId;
	}

	/**
	 * Sets the checks if is brek up needed id.
	 *
	 * @param isBrekUpNeededId the new checks if is brek up needed id
	 */
	public void setIsBrekUpNeededId(Integer isBrekUpNeededId) {
		this.isBrekUpNeededId = isBrekUpNeededId;
	}

	/**
	 * Gets the checks if is recovery id.
	 *
	 * @return the checks if is recovery id
	 */
	public Integer getIsRecoveryId() {
		return isRecoveryId;
	}

	/**
	 * Sets the checks if is recovery id.
	 *
	 * @param isRecoveryId the new checks if is recovery id
	 */
	public void setIsRecoveryId(Integer isRecoveryId) {
		this.isRecoveryId = isRecoveryId;
	}

	/**
	 * Gets the sector head code.
	 *
	 * @return the sector head code
	 */
	public Long getSectorHeadCode() {
		return sectorHeadCode;
	}

	/**
	 * Sets the sector head code.
	 *
	 * @param sectorHeadCode the new sector head code
	 */
	public void setSectorHeadCode(Long sectorHeadCode) {
		this.sectorHeadCode = sectorHeadCode;
	}

	/**
	 * Gets the sub sector code.
	 *
	 * @return the sub sector code
	 */
	public Long getSubSectorCode() {
		return subSectorCode;
	}

	/**
	 * Sets the sub sector code.
	 *
	 * @param subSectorCode the new sub sector code
	 */
	public void setSubSectorCode(Long subSectorCode) {
		this.subSectorCode = subSectorCode;
	}

	/**
	 * Gets the sub sub sector code.
	 *
	 * @return the sub sub sector code
	 */
	public Long getSubSubSectorCode() {
		return subSubSectorCode;
	}

	/**
	 * Sets the sub sub sector code.
	 *
	 * @param subSubSectorCode the new sub sub sector code
	 */
	public void setSubSubSectorCode(Long subSubSectorCode) {
		this.subSubSectorCode = subSubSectorCode;
	}

	/**
	 * Gets the major head sub type.
	 *
	 * @return the major head sub type
	 */
	public String getMajorHeadSubType() {
		return majorHeadSubType;
	}

	/**
	 * Sets the major head sub type.
	 *
	 * @param majorHeadSubType the new major head sub type
	 */
	public void setMajorHeadSubType(String majorHeadSubType) {
		this.majorHeadSubType = majorHeadSubType;
	}

	/**
	 * Gets the major head sub type id.
	 *
	 * @return the major head sub type id
	 */
	public Long getMajorHeadSubTypeId() {
		return majorHeadSubTypeId;
	}

	/**
	 * Sets the major head sub type id.
	 *
	 * @param majorHeadSubTypeId the new major head sub type id
	 */
	public void setMajorHeadSubTypeId(Long majorHeadSubTypeId) {
		this.majorHeadSubTypeId = majorHeadSubTypeId;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the taluka.
	 *
	 * @return the taluka
	 */
	public List<ClueDto> getTaluka() {
		return taluka;
	}

	/**
	 * Sets the taluka.
	 *
	 * @param taluka the taluka to set
	 */
	public void setTaluka(List<ClueDto> taluka) {
		this.taluka = taluka;
	}

	/**
	 * Gets the parent id.
	 *
	 * @return the parentId
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}

	/**
	 * Sets the count.
	 *
	 * @param count the count to set
	 */
	public void setCount(Long count) {
		this.count = count;
	}

	/**
	 * Gets the tresury type.
	 *
	 * @return the tresuryType
	 */
	public List<ClueDto> getTresuryType() {
		return tresuryType;
	}

	/**
	 * Sets the tresury type.
	 *
	 * @param tresuryType the tresuryType to set
	 */
	public void setTresuryType(List<ClueDto> tresuryType) {
		this.tresuryType = tresuryType;
	}

	/**
	 * Sets the parent id.
	 *
	 * @param parentId the parentId to set
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * Instantiates a new clue dto.
	 */
	public ClueDto() {
		super();
	}

	/**
	 * Instantiates a new clue dto.
	 *
	 * @param id   the id
	 * @param code the code
	 */
	public ClueDto(long id, String code) {
		super();
		this.id = id;
		this.code = code;
	}

	/**
	 * Sets the flag.
	 *
	 * @param flag the flag to set
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	/**
	 * Instantiates a new clue dto.
	 *
	 * @param id   the id
	 * @param flag the flag
	 */
	public ClueDto(Long id, Boolean flag) {
		super();
		this.id = id;
		this.flag = flag;
	}

	/**
	 * Instantiates a new clue dto.
	 *
	 * @param id       the id
	 * @param name     the name
	 * @param code     the code
	 * @param codeName the code name
	 * @param parentId the parent id
	 */
	public ClueDto(Long id, String name, String code, String codeName, Long parentId) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.codeName = codeName;
		this.parentId = parentId;
	}

	/**
	 * Instantiates a new clue dto.
	 *
	 * @param id   the id
	 * @param name the name
	 * @param code the code
	 */
	public ClueDto(Long id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}

	/**
	 * Instantiates a new clue dto.
	 *
	 * @param id       the id
	 * @param name     the name
	 * @param code     the code
	 * @param codeName the code name
	 */
	public ClueDto(Long id, String name, String code, String codeName) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.codeName = codeName;
	}

	/**
	 * Instantiates a new clue dto.
	 *
	 * @param id       the id
	 * @param name     the name
	 * @param code     the code
	 * @param codeName the code name
	 * @param stdCode  the std code
	 */
	public ClueDto(Long id, String name, String code, String codeName, String stdCode) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.codeName = codeName;
		this.stdCode = stdCode;
	}

	/**
	 * Instantiates a new clue dto.
	 *
	 * @param id       the id
	 * @param name     the name
	 * @param code     the code
	 * @param codeName the code name
	 * @param parentId the parent id
	 * @param stdCode  the std code
	 */
	public ClueDto(Long id, String name, String code, String codeName, Long parentId, String stdCode) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.codeName = codeName;
		this.parentId = parentId;
		this.stdCode = stdCode;
	}

	/**
	 * Instantiates a new clue dto.
	 *
	 * @param id the id
	 */
	public ClueDto(Long id) {
		super();
		this.id = id;
	}

	/**
	 * Instantiates a new clue dto.
	 *
	 * @param tedpUptId     the tedp upt id
	 * @param postOfficeId  the post office id
	 * @param willBePrimary the will be primary
	 */
	public ClueDto(Long tedpUptId, Long postOfficeId, Boolean willBePrimary) {
		super();
		this.tedpUptId = tedpUptId;
		this.postOfficeId = postOfficeId;
		this.willBePrimary = willBePrimary;
	}

	/**
	 * Gets the std code.
	 *
	 * @return the stdCode
	 */
	public String getStdCode() {
		return stdCode;
	}

	/**
	 * Sets the std code.
	 *
	 * @param stdCode the stdCode to set
	 */
	public void setStdCode(String stdCode) {
		this.stdCode = stdCode;
	}

	/**
	 * Instantiates a new clue dto.
	 *
	 * @param id    the id
	 * @param name  the name
	 * @param count the count
	 */
	public ClueDto(Long id, String name, Long count) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
	}

	/**
	 * Gets the wf role ids.
	 *
	 * @return the wfRoleIds
	 */
	public List<Long> getWfRoleIds() {
		return wfRoleIds;
	}

	/**
	 * Sets the wf role ids.
	 *
	 * @param wfRoleIds the wfRoleIds to set
	 */
	public void setWfRoleIds(List<Long> wfRoleIds) {
		this.wfRoleIds = wfRoleIds;
	}

	/**
	 * Gets the wf branch id.
	 *
	 * @return the wfBranchId
	 */
	public Long getWfBranchId() {
		return wfBranchId;
	}

	/**
	 * Sets the wf branch id.
	 *
	 * @param wfBranchId the wfBranchId to set
	 */
	public void setWfBranchId(Long wfBranchId) {
		this.wfBranchId = wfBranchId;
	}

	/**
	 * Gets the active post.
	 *
	 * @return the activePost
	 */
	public List<ClueDto> getActivePost() {
		return activePost;
	}

	/**
	 * Sets the active post.
	 *
	 * @param activePost the activePost to set
	 */
	public void setActivePost(List<ClueDto> activePost) {
		this.activePost = activePost;
	}

	/**
	 * Gets the attachment type.
	 *
	 * @return the attachmentType
	 */
	public Long getAttachmentType() {
		return attachmentType;
	}

	/**
	 * Sets the attachment type.
	 *
	 * @param attachmentType the attachmentType to set
	 */
	public void setAttachmentType(Long attachmentType) {
		this.attachmentType = attachmentType;
	}

	/**
	 * Gets the tedp upt id.
	 *
	 * @return the tedpUptId
	 */
	public Long getTedpUptId() {
		return tedpUptId;
	}

	/**
	 * Sets the tedp upt id.
	 *
	 * @param tedpUptId the tedpUptId to set
	 */
	public void setTedpUptId(Long tedpUptId) {
		this.tedpUptId = tedpUptId;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designationId
	 */
	public Long getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	/**
	 * Gets the flag.
	 *
	 * @return the flag
	 */
	public Boolean getFlag() {
		return flag;
	}

	/**
	 * Gets the trn no.
	 *
	 * @return the trn no
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * Sets the trn no.
	 *
	 * @param trnNo the new trn no
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * Gets the office list.
	 *
	 * @return the office list
	 */
	public List<ClueDto> getOfficeList() {
		return officeList;
	}

	/**
	 * Sets the office list.
	 *
	 * @param officeList the new office list
	 */
	public void setOfficeList(List<ClueDto> officeList) {
		this.officeList = officeList;
	}

	/**
	 * Gets the cardex no.
	 *
	 * @return the cardexNo
	 */
	public Long getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(Long cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * Gets the ddo no.
	 *
	 * @return the ddoNo
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the ddoNo to set
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Sets the image.
	 *
	 * @param image the new image
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the checks if is update.
	 *
	 * @return the isUpdate
	 */
	public Boolean getIsUpdate() {
		return isUpdate;
	}

	/**
	 * Sets the checks if is update.
	 *
	 * @param isUpdate the isUpdate to set
	 */
	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	/**
	 * Gets the active status.
	 *
	 * @return the activeStatus
	 */
	public Integer getActiveStatus() {
		return activeStatus;
	}

	/**
	 * Sets the active status.
	 *
	 * @param activeStatus the activeStatus to set
	 */
	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}

	/**
	 * Gets the checks if is current year.
	 *
	 * @return the isCurrentYear
	 */
	public Integer getIsCurrentYear() {
		return isCurrentYear;
	}

	/**
	 * Sets the checks if is current year.
	 *
	 * @param isCurrentYear the isCurrentYear to set
	 */
	public void setIsCurrentYear(Integer isCurrentYear) {
		this.isCurrentYear = isCurrentYear;
	}

	/**
	 * Instantiates a new clue dto.
	 *
	 * @param id            the id
	 * @param name          the name
	 * @param isCurrentYear the is current year
	 */
	public ClueDto(Long id, String name, Integer isCurrentYear) {
		super();
		this.id = id;
		this.name = name;
		this.isCurrentYear = isCurrentYear;
	}

	/**
	 * Gets the financial year.
	 *
	 * @return the financialYear
	 */
	public ClueDto getFinancialYear() {
		return financialYear;
	}

	/**
	 * Sets the financial year.
	 *
	 * @param financialYear the financialYear to set
	 */
	public void setFinancialYear(ClueDto financialYear) {
		this.financialYear = financialYear;
	}

	/**
	 * Gets the budget estimate type.
	 *
	 * @return the budgetEstimateType
	 */
	public List<ClueDto> getBudgetEstimateType() {
		return budgetEstimateType;
	}

	/**
	 * Sets the budget estimate type.
	 *
	 * @param budgetEstimateType the budgetEstimateType to set
	 */
	public void setBudgetEstimateType(List<ClueDto> budgetEstimateType) {
		this.budgetEstimateType = budgetEstimateType;
	}

	/**
	 * Gets the financial year id.
	 *
	 * @return the financialYearId
	 */
	public Long getFinancialYearId() {
		return financialYearId;
	}

	/**
	 * Sets the financial year id.
	 *
	 * @param financialYearId the financialYearId to set
	 */
	public void setFinancialYearId(Long financialYearId) {
		this.financialYearId = financialYearId;
	}

	/**
	 * Gets the department id.
	 *
	 * @return the departmentId
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * Sets the department id.
	 *
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * Gets the majorhead id.
	 *
	 * @return the majorheadId
	 */
	public Long getMajorheadId() {
		return majorheadId;
	}

	/**
	 * Sets the majorhead id.
	 *
	 * @param majorheadId the majorheadId to set
	 */
	public void setMajorheadId(Long majorheadId) {
		this.majorheadId = majorheadId;
	}

	/**
	 * Gets the major head list.
	 *
	 * @return the majorHeadList
	 */
	public List<ClueDto> getMajorHeadList() {
		return majorHeadList;
	}

	/**
	 * Sets the major head list.
	 *
	 * @param majorHeadList the majorHeadList to set
	 */
	public void setMajorHeadList(List<ClueDto> majorHeadList) {
		this.majorHeadList = majorHeadList;
	}

	/**
	 * Gets the status list.
	 *
	 * @return the statusList
	 */
	public List<ClueDto> getStatusList() {
		return statusList;
	}

	/**
	 * Sets the status list.
	 *
	 * @param statusList the statusList to set
	 */
	public void setStatusList(List<ClueDto> statusList) {
		this.statusList = statusList;
	}

	/**
	 * Gets the department name.
	 *
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * Sets the department name.
	 *
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * Gets the office name.
	 *
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * Gets the post office id.
	 *
	 * @return the post office id
	 */
	public Long getPostOfficeId() {
		return postOfficeId;
	}

	/**
	 * Sets the post office id.
	 *
	 * @param postOfficeId the new post office id
	 */
	public void setPostOfficeId(Long postOfficeId) {
		this.postOfficeId = postOfficeId;
	}

	/**
	 * Gets the will be primary.
	 *
	 * @return the will be primary
	 */
	public Boolean getWillBePrimary() {
		return willBePrimary;
	}

	/**
	 * Sets the will be primary.
	 *
	 * @param willBePrimary the new will be primary
	 */
	public void setWillBePrimary(Boolean willBePrimary) {
		this.willBePrimary = willBePrimary;
	}

	/**
	 * Gets the module list.
	 *
	 * @return the moduleList
	 */
	public List<ClueDto> getModuleList() {
		return moduleList;

	}

	/**
	 * Sets the module list.
	 *
	 * @param moduleList the moduleList to set
	 */
	public void setModuleList(List<ClueDto> moduleList) {
		this.moduleList = moduleList;
	}

	/**
	 * Gets the list value.
	 *
	 * @return the submoduleList
	 */
	public List<ClueDto> getListValue() {
		return listValue;
	}

	/**
	 * Sets the list value.
	 *
	 * @param listValue the new list value
	 */
	public void setListValue(List<ClueDto> listValue) {
		this.listValue = listValue;
	}

	/**
	 * Gets the menu role prm.
	 *
	 * @return the menuRolePrm
	 */
	public String getMenuRolePrm() {
		return menuRolePrm;
	}

	/**
	 * Sets the menu role prm.
	 *
	 * @param menuRolePrm the menuRolePrm to set
	 */
	public void setMenuRolePrm(String menuRolePrm) {
		this.menuRolePrm = menuRolePrm;
	}

	/**
	 * Gets the menu wf role.
	 *
	 * @return the menuWfRole
	 */
	public String getMenuWfRole() {
		return menuWfRole;
	}

	/**
	 * Sets the menu wf role.
	 *
	 * @param menuWfRole the menuWfRole to set
	 */
	public void setMenuWfRole(String menuWfRole) {
		this.menuWfRole = menuWfRole;
	}

	/**
	 * Gets the submodule list.
	 *
	 * @return the submoduleList
	 */
	public List<ClueDto> getSubmoduleList() {
		return submoduleList;
	}

	/**
	 * Sets the submodule list.
	 *
	 * @param submoduleList the submoduleList to set
	 */
	public void setSubmoduleList(List<ClueDto> submoduleList) {
		this.submoduleList = submoduleList;
	}

	/**
	 * Gets the menu list.
	 *
	 * @return the menuList
	 */
	public List<ClueDto> getMenuList() {
		return menuList;
	}

	/**
	 * Sets the menu list.
	 *
	 * @param menuList the menuList to set
	 */
	public void setMenuList(List<ClueDto> menuList) {
		this.menuList = menuList;
	}

	/**
	 * Gets the wf role list.
	 *
	 * @return the wfRoleList
	 */
	public Set<ClueDto> getWfRoleList() {
		return wfRoleList;
	}

	/**
	 * Sets the wf role list.
	 *
	 * @param wfRoleList the wfRoleList to set
	 */
	public void setWfRoleList(Set<ClueDto> wfRoleList) {
		this.wfRoleList = wfRoleList;
	}

	/**
	 * Gets the role prm list.
	 *
	 * @return the rolePrmList
	 */
	public ClueDto getRolePrmList() {
		return rolePrmList;
	}

	/**
	 * Sets the role prm list.
	 *
	 * @param rolePrmList the rolePrmList to set
	 */
	public void setRolePrmList(ClueDto rolePrmList) {
		this.rolePrmList = rolePrmList;
	}

	/**
	 * Gets the role prm.
	 *
	 * @return the rolePrm
	 */
	public Set<String> getRolePrm() {
		return rolePrm;
	}

	/**
	 * Sets the role prm.
	 *
	 * @param rolePrm the rolePrm to set
	 */
	public void setRolePrm(Set<String> rolePrm) {
		this.rolePrm = rolePrm;
	}

	/**
	 * Gets the menu office type id.
	 *
	 * @return the menu office type id
	 */
	public Long getMenuOfficeTypeId() {
		return menuOfficeTypeId;
	}

	/**
	 * Sets the menu office type id.
	 *
	 * @param menuOfficeTypeId the new menu office type id
	 */
	public void setMenuOfficeTypeId(Long menuOfficeTypeId) {
		this.menuOfficeTypeId = menuOfficeTypeId;
	}

	/**
	 * Gets the checks if is wf role removed.
	 *
	 * @return the isWfRoleRemoved
	 */
	public Boolean getIsWfRoleRemoved() {
		return isWfRoleRemoved;
	}

	/**
	 * Sets the checks if is wf role removed.
	 *
	 * @param isWfRoleRemoved the isWfRoleRemoved to set
	 */
	public void setIsWfRoleRemoved(Boolean isWfRoleRemoved) {
		this.isWfRoleRemoved = isWfRoleRemoved;
	}

	/**
	 * Gets the module.
	 *
	 * @return the module
	 */
	public String getModule() {
		return module;
	}

	/**
	 * Sets the module.
	 *
	 * @param module the new module
	 */
	public void setModule(String module) {
		this.module = module;
	}

	/**
	 * Gets the module id.
	 *
	 * @return the module id
	 */
	public Long getModuleId() {
		return moduleId;
	}

	/**
	 * Sets the module id.
	 *
	 * @param moduleId the new module id
	 */
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * Gets the sub module.
	 *
	 * @return the sub module
	 */
	public String getSubModule() {
		return subModule;
	}

	/**
	 * Sets the sub module.
	 *
	 * @param subModule the new sub module
	 */
	public void setSubModule(String subModule) {
		this.subModule = subModule;
	}

	/**
	 * Gets the sub module id.
	 *
	 * @return the sub module id
	 */
	public Long getSubModuleId() {
		return subModuleId;
	}

	/**
	 * Sets the sub module id.
	 *
	 * @param subModuleId the new sub module id
	 */
	public void setSubModuleId(Long subModuleId) {
		this.subModuleId = subModuleId;
	}

	/**
	 * Gets the menu.
	 *
	 * @return the menu
	 */
	public String getMenu() {
		return menu;
	}

	/**
	 * Sets the menu.
	 *
	 * @param menu the new menu
	 */
	public void setMenu(String menu) {
		this.menu = menu;
	}

	/**
	 * Gets the menu id.
	 *
	 * @return the menu id
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * Sets the menu id.
	 *
	 * @param menuId the new menu id
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * Gets the role name.
	 *
	 * @return the role name
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * Sets the role name.
	 *
	 * @param roleName the new role name
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * Gets the mod office type id.
	 *
	 * @return the mod office type id
	 */
	public Long getModOfficeTypeId() {
		return modOfficeTypeId;
	}

	/**
	 * Sets the mod office type id.
	 *
	 * @param modOfficeTypeId the new mod office type id
	 */
	public void setModOfficeTypeId(Long modOfficeTypeId) {
		this.modOfficeTypeId = modOfficeTypeId;
	}

	/**
	 * Gets the financial years.
	 *
	 * @return the financial years
	 */
	public List<ClueDto> getFinancialYears() {
		return financialYears;
	}

	/**
	 * Sets the financial years.
	 *
	 * @param financialYears the new financial years
	 */
	public void setFinancialYears(List<ClueDto> financialYears) {
		this.financialYears = financialYears;
	}

	/**
	 * Gets the department list.
	 *
	 * @return the department list
	 */
	public List<ClueDto> getDepartmentList() {
		return departmentList;
	}

	/**
	 * Sets the department list.
	 *
	 * @param departmentList the new department list
	 */
	public void setDepartmentList(List<ClueDto> departmentList) {
		this.departmentList = departmentList;
	}

	/**
	 * Gets the demand list.
	 *
	 * @return the demand list
	 */
	public List<ClueDto> getDemandList() {
		return demandList;
	}

	/**
	 * Sets the demand list.
	 *
	 * @param demandList the new demand list
	 */
	public void setDemandList(List<ClueDto> demandList) {
		this.demandList = demandList;
	}

	/**
	 * Gets the sub major head list.
	 *
	 * @return the sub major head list
	 */
	public List<ClueDto> getSubMajorHeadList() {
		return subMajorHeadList;
	}

	/**
	 * Sets the sub major head list.
	 *
	 * @param subMajorHeadList the new sub major head list
	 */
	public void setSubMajorHeadList(List<ClueDto> subMajorHeadList) {
		this.subMajorHeadList = subMajorHeadList;
	}

	/**
	 * Gets the minor head list.
	 *
	 * @return the minor head list
	 */
	public List<ClueDto> getMinorHeadList() {
		return minorHeadList;
	}

	/**
	 * Sets the minor head list.
	 *
	 * @param minorHeadList the new minor head list
	 */
	public void setMinorHeadList(List<ClueDto> minorHeadList) {
		this.minorHeadList = minorHeadList;
	}

	/**
	 * Gets the sub head list.
	 *
	 * @return the sub head list
	 */
	public List<ClueDto> getSubHeadList() {
		return subHeadList;
	}

	/**
	 * Sets the sub head list.
	 *
	 * @param subHeadList the new sub head list
	 */
	public void setSubHeadList(List<ClueDto> subHeadList) {
		this.subHeadList = subHeadList;
	}

	/**
	 * Gets the trn ref no list.
	 *
	 * @return the trn ref no list
	 */
	public List<ClueDto> getTrnRefNoList() {
		return trnRefNoList;
	}

	/**
	 * Sets the trn ref no list.
	 *
	 * @param trnRefNoList the new trn ref no list
	 */
	public void setTrnRefNoList(List<ClueDto> trnRefNoList) {
		this.trnRefNoList = trnRefNoList;
	}

	/**
	 * Gets the rev or cap.
	 *
	 * @return the rev or cap
	 */
	public List<ClueDto> getRevOrCap() {
		return revOrCap;
	}

	/**
	 * Sets the rev or cap.
	 *
	 * @param revOrCap the new rev or cap
	 */
	public void setRevOrCap(List<ClueDto> revOrCap) {
		this.revOrCap = revOrCap;
	}

	/**
	 * Gets the locality list.
	 *
	 * @return the locality list
	 */
	public List<ClueDto> getLocalityList() {
		return localityList;
	}

	/**
	 * Sets the locality list.
	 *
	 * @param localityList the new locality list
	 */
	public void setLocalityList(List<ClueDto> localityList) {
		this.localityList = localityList;
	}

	/**
	 * Gets the division list.
	 *
	 * @return the division list
	 */
	public List<ClueDto> getDivisionList() {
		return divisionList;
	}

	/**
	 * Sets the division list.
	 *
	 * @param divisionList the new division list
	 */
	public void setDivisionList(List<ClueDto> divisionList) {
		this.divisionList = divisionList;
	}

	/**
	 * Gets the fy start.
	 *
	 * @return the fy start
	 */
	public Integer getFyStart() {
		return fyStart;
	}

	/**
	 * Sets the fy start.
	 *
	 * @param fyStart the new fy start
	 */
	public void setFyStart(Integer fyStart) {
		this.fyStart = fyStart;
	}


	/**
	 * Gets the major head code.
	 *
	 * @return the major head code
	 */
	public String getMajorHeadCode() {
		return majorHeadCode;
	}

	/**
	 * Sets the major head code.
	 *
	 * @param majorHeadCode the new major head code
	 */
	public void setMajorHeadCode(String majorHeadCode) {
		this.majorHeadCode = majorHeadCode;
	}

	/**
	 * Gets the minor head code.
	 *
	 * @return the minor head code
	 */
	public String getMinorHeadCode() {
		return minorHeadCode;
	}

	/**
	 * Sets the minor head code.
	 *
	 * @param minorHeadCode the new minor head code
	 */
	public void setMinorHeadCode(String minorHeadCode) {
		this.minorHeadCode = minorHeadCode;
	}

	/**
	 * Gets the rev cap id.
	 *
	 * @return the rev cap id
	 */
	public Long getRevCapId() {
		return revCapId;
	}

	/**
	 * Sets the rev cap id.
	 *
	 * @param revCapId the new rev cap id
	 */
	public void setRevCapId(Long revCapId) {
		this.revCapId = revCapId;
	}

	/**
	 * Gets the condition lookup.
	 *
	 * @return the condition lookup
	 */
	public List<ClueDto> getConditionLookup() {
		return conditionLookup;
	}

	/**
	 * Sets the condition lookup.
	 *
	 * @param conditionLookup the new condition lookup
	 */
	public void setConditionLookup(List<ClueDto> conditionLookup) {
		this.conditionLookup = conditionLookup;
	}

	/**
	 * Gets the class lookup.
	 *
	 * @return the class lookup
	 */
	public List<ClueDto> getClassLookup() {
		return classLookup;
	}

	/**
	 * Sets the class lookup.
	 *
	 * @param classLookup the new class lookup
	 */
	public void setClassLookup(List<ClueDto> classLookup) {
		this.classLookup = classLookup;
	}

	/**
	 * Gets the quality certificate lookup.
	 *
	 * @return the quality certificate lookup
	 */
	public List<ClueDto> getQualityCertificateLookup() {
		return qualityCertificateLookup;
	}

	/**
	 * Sets the quality certificate lookup.
	 *
	 * @param qualityCertificateLookup the new quality certificate lookup
	 */
	public void setQualityCertificateLookup(List<ClueDto> qualityCertificateLookup) {
		this.qualityCertificateLookup = qualityCertificateLookup;
	}

	/**
	 * Gets the districts.
	 *
	 * @return the districts
	 */
	public List<ClueDto> getDistricts() {
		return districts;
	}

	/**
	 * Sets the districts.
	 *
	 * @param districts the new districts
	 */
	public void setDistricts(List<ClueDto> districts) {
		this.districts = districts;
	}

	/**
	 * Gets the trans status list.
	 *
	 * @return the trans status list
	 */
	public List<ClueDto> getTransStatusList() {
		return transStatusList;
	}

	/**
	 * Sets the trans status list.
	 *
	 * @param transStatusList the new trans status list
	 */
	public void setTransStatusList(List<ClueDto> transStatusList) {
		this.transStatusList = transStatusList;
	}

	/**
	 * Gets the work flow status list.
	 *
	 * @return the work flow status list
	 */
	public List<ClueDto> getWorkFlowStatusList() {
		return workFlowStatusList;
	}

	/**
	 * Sets the work flow status list.
	 *
	 * @param workFlowStatusList the new work flow status list
	 */
	public void setWorkFlowStatusList(List<ClueDto> workFlowStatusList) {
		this.workFlowStatusList = workFlowStatusList;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public String getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the district dto.
	 *
	 * @return the districtDto
	 */
	public ClueDto getDistrictDto() {
		return districtDto;
	}

	/**
	 * Sets the district dto.
	 *
	 * @param districtDto the districtDto to set
	 */
	public void setDistrictDto(ClueDto districtDto) {
		this.districtDto = districtDto;
	}

	/**
	 * Gets the checks if is dat user.
	 *
	 * @return the isDatUser
	 */
	public Boolean getIsDatUser() {
		return isDatUser;
	}

	/**
	 * Sets the checks if is dat user.
	 *
	 * @param isDatUser the isDatUser to set
	 */
	public void setIsDatUser(Boolean isDatUser) {
		this.isDatUser = isDatUser;
	}

	/**
	 * Gets the hod list.
	 *
	 * @return the hodList
	 */
	public List<ClueDto> getHodList() {
		return hodList;
	}

	/**
	 * Sets the hod list.
	 *
	 * @param hodList the hodList to set
	 */
	public void setHodList(List<ClueDto> hodList) {
		this.hodList = hodList;
	}

	/**
	 * Gets the districtid.
	 *
	 * @return the districtid
	 */
	public Long getDistrictid() {
		return districtid;
	}

	/**
	 * Sets the districtid.
	 *
	 * @param districtid the districtid to set
	 */
	public void setDistrictid(Long districtid) {
		this.districtid = districtid;
	}

	/**
	 * Gets the office level.
	 *
	 * @return the officeLevel
	 */
	public List<ClueDto> getOfficeLevel() {
		return officeLevel;
	}

	/**
	 * Sets the office level.
	 *
	 * @param officeLevel the officeLevel to set
	 */
	public void setOfficeLevel(List<ClueDto> officeLevel) {
		this.officeLevel = officeLevel;
	}

	
	/**
	 * Gets the ddo type.
	 *
	 * @return the ddoType
	 */
	public List<ClueDto> getDdoType() {
		return ddoType;
	}

	/**
	 * Sets the ddo type.
	 *
	 * @param ddoType the ddoType to set
	 */
	public void setDdoType(List<ClueDto> ddoType) {
		this.ddoType = ddoType;
	}
	
	/**
	 * Gets the request types.
	 *
	 * @return the request types
	 */
	public List<ClueDto> getRequestTypes() {
		return requestTypes;
	}

	/**
	 * Sets the request types.
	 *
	 * @param requestTypes the new request types
	 */
	public void setRequestTypes(List<ClueDto> requestTypes) {
		this.requestTypes = requestTypes;
	}
	
	/**
	 * Gets the page index.
	 *
	 * @return the pageIndex
	 */
	public Long getPageIndex() {
		return pageIndex;
	}

	/**
	 * Sets the page index.
	 *
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(Long pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * Gets the page size.
	 *
	 * @return the pageSize
	 */
	public Long getPageSize() {
		return pageSize;
	}

	/**
	 * Sets the page size.
	 *
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * Instantiates a new clue dto.
	 *
	 * @param name the name
	 */
	/*
	 * Instantiates a new clue dto.
	 *
	 * @param name the name
	 */
	public ClueDto(String name) {
		super();
		this.name = name;
	}

	/**
	 * Gets the document id.
	 *
	 * @return the documentId
	 */
	public String getDocumentId() {
		return documentId;
	}

	/**
	 * Sets the document id.
	 *
	 * @param documentId the documentId to set
	 */
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	
	/**
	 * Gets the document uploaded file path.
	 *
	 * @return the documentUploadedFilePath
	 */
	public String getDocumentUploadedFilePath() {
		return documentUploadedFilePath;
	}

	/**
	 * Sets the document uploaded file path.
	 *
	 * @param documentUploadedFilePath the documentUploadedFilePath to set
	 */
	public void setDocumentUploadedFilePath(String documentUploadedFilePath) {
		this.documentUploadedFilePath = documentUploadedFilePath;
	}
	
	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * Gets the document.
	 *
	 * @return the document
	 */
	public InputStreamResource getDocument() {
		return document;
	}

	/**
	 * Sets the document.
	 *
	 * @param document the document to set
	 */
	public void setDocument(InputStreamResource document) {
		this.document = document;
	}
	

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(activePost, activeStatus, attachmentType, billType, budgetEstimateType, cardexNo,
				chargeVoted, classLookup, code, codeName, conditionLookup, controllingOffice, count, ddoNo, ddoType,
				demandList, departmentId, departmentList, departmentName, description, designationId, districtDto,
				districtList, districtid, districts, divisionList, document, documentId, documentUploadedFilePath,
				estimationFromId, financialYear, financialYearId, financialYears, flag, fyStart, hodList, iSGaidId, id,
				image, isBrekUpNeededId, isCnmId, isCurrentYear, isDatUser, isRecoveryId, isUpdate, isWfRoleRemoved,
				listValue, localityList, majorHeadCode, majorHeadList, majorHeadSubType, majorHeadSubTypeId,
				majorheadId, menu, menuId, menuList, menuOfficeTypeId, menuRolePrm, menuWfRole, minorHeadCode,
				minorHeadList, modOfficeTypeId, module, moduleId, moduleList, name, officeDesignation, officeId,
				officeLevel, officeList, officeName, officeStatus, officeType, pageIndex, pageSize, parentId,
				postOfficeId, pvuOffice, qualityCertificateLookup, requestTypes, revCapId, revOrCap, roleName, rolePrm,
				rolePrmList, sectorHeadCode, statusId, statusList, stdCode, subHeadList, subMajorHeadList, subModule,
				subModuleId, subSectorCode, subSubSectorCode, submoduleList, taluka, tedpUptId, transStatusList,
				tresuryType, trnNo, trnRefNoList, userName, wfBranchId, wfRoleCode, wfRoleIds, wfRoleList, wfRoles,
				wfStatusList, willBePrimary, workFlowStatusList, accountsList, chequeTypes, bankId, bankName, bankBranchId, bankBranchId,
				banksList, bankBranchList, chequeFormats, chequeLeaves);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ClueDto)) {
			return false;
		}
		ClueDto other = (ClueDto) obj;
		return Objects.equals(activePost, other.activePost) && Objects.equals(activeStatus, other.activeStatus)
				&& Objects.equals(attachmentType, other.attachmentType) && Objects.equals(billType, other.billType)
				&& Objects.equals(budgetEstimateType, other.budgetEstimateType)
				&& Objects.equals(cardexNo, other.cardexNo) && Objects.equals(chargeVoted, other.chargeVoted)
				&& Objects.equals(classLookup, other.classLookup) && Objects.equals(code, other.code)
				&& Objects.equals(codeName, other.codeName) && Objects.equals(conditionLookup, other.conditionLookup)
				&& Objects.equals(controllingOffice, other.controllingOffice) && Objects.equals(count, other.count)
				&& Objects.equals(ddoNo, other.ddoNo) && Objects.equals(ddoType, other.ddoType)
				&& Objects.equals(demandList, other.demandList) && Objects.equals(departmentId, other.departmentId)
				&& Objects.equals(departmentList, other.departmentList)
				&& Objects.equals(departmentName, other.departmentName)
				&& Objects.equals(description, other.description) && Objects.equals(designationId, other.designationId)
				&& Objects.equals(districtDto, other.districtDto) && Objects.equals(districtList, other.districtList)
				&& Objects.equals(districtid, other.districtid) && Objects.equals(districts, other.districts)
				&& Objects.equals(divisionList, other.divisionList) && Objects.equals(document, other.document)
				&& Objects.equals(documentId, other.documentId)
				&& Objects.equals(documentUploadedFilePath, other.documentUploadedFilePath)
				&& Objects.equals(estimationFromId, other.estimationFromId)
				&& Objects.equals(financialYear, other.financialYear)
				&& Objects.equals(financialYearId, other.financialYearId)
				&& Objects.equals(financialYears, other.financialYears) && Objects.equals(flag, other.flag)
				&& Objects.equals(fyStart, other.fyStart) && Objects.equals(hodList, other.hodList)
				&& Objects.equals(iSGaidId, other.iSGaidId) && Objects.equals(id, other.id)
				&& Objects.equals(image, other.image) && Objects.equals(isBrekUpNeededId, other.isBrekUpNeededId)
				&& Objects.equals(isCnmId, other.isCnmId) && Objects.equals(isCurrentYear, other.isCurrentYear)
				&& Objects.equals(isDatUser, other.isDatUser) && Objects.equals(isRecoveryId, other.isRecoveryId)
				&& Objects.equals(isUpdate, other.isUpdate) && Objects.equals(isWfRoleRemoved, other.isWfRoleRemoved)
				&& Objects.equals(listValue, other.listValue) && Objects.equals(localityList, other.localityList)
				&& Objects.equals(majorHeadCode, other.majorHeadCode)
				&& Objects.equals(majorHeadList, other.majorHeadList)
				&& Objects.equals(majorHeadSubType, other.majorHeadSubType)
				&& Objects.equals(majorHeadSubTypeId, other.majorHeadSubTypeId)
				&& Objects.equals(majorheadId, other.majorheadId) && Objects.equals(menu, other.menu)
				&& Objects.equals(menuId, other.menuId) && Objects.equals(menuList, other.menuList)
				&& Objects.equals(menuOfficeTypeId, other.menuOfficeTypeId)
				&& Objects.equals(menuRolePrm, other.menuRolePrm) && Objects.equals(menuWfRole, other.menuWfRole)
				&& Objects.equals(minorHeadCode, other.minorHeadCode)
				&& Objects.equals(minorHeadList, other.minorHeadList)
				&& Objects.equals(modOfficeTypeId, other.modOfficeTypeId) && Objects.equals(module, other.module)
				&& Objects.equals(moduleId, other.moduleId) && Objects.equals(moduleList, other.moduleList)
				&& Objects.equals(name, other.name) && Objects.equals(officeDesignation, other.officeDesignation)
				&& Objects.equals(officeId, other.officeId) && Objects.equals(officeLevel, other.officeLevel)
				&& Objects.equals(officeList, other.officeList) && Objects.equals(officeName, other.officeName)
				&& Objects.equals(officeStatus, other.officeStatus) && Objects.equals(officeType, other.officeType)
				&& Objects.equals(pageIndex, other.pageIndex) && Objects.equals(pageSize, other.pageSize)
				&& Objects.equals(parentId, other.parentId) && Objects.equals(postOfficeId, other.postOfficeId)
				&& Objects.equals(pvuOffice, other.pvuOffice)
				&& Objects.equals(qualityCertificateLookup, other.qualityCertificateLookup)
				&& Objects.equals(requestTypes, other.requestTypes) && Objects.equals(revCapId, other.revCapId)
				&& Objects.equals(revOrCap, other.revOrCap) && Objects.equals(roleName, other.roleName)
				&& Objects.equals(rolePrm, other.rolePrm) && Objects.equals(rolePrmList, other.rolePrmList)
				&& Objects.equals(sectorHeadCode, other.sectorHeadCode) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(statusList, other.statusList) && Objects.equals(stdCode, other.stdCode)
				&& Objects.equals(subHeadList, other.subHeadList)
				&& Objects.equals(subMajorHeadList, other.subMajorHeadList)
				&& Objects.equals(subModule, other.subModule) && Objects.equals(subModuleId, other.subModuleId)
				&& Objects.equals(subSectorCode, other.subSectorCode)
				&& Objects.equals(subSubSectorCode, other.subSubSectorCode)
				&& Objects.equals(submoduleList, other.submoduleList) && Objects.equals(taluka, other.taluka)
				&& Objects.equals(tedpUptId, other.tedpUptId) && Objects.equals(transStatusList, other.transStatusList)
				&& Objects.equals(tresuryType, other.tresuryType) && Objects.equals(trnNo, other.trnNo)
				&& Objects.equals(trnRefNoList, other.trnRefNoList) && Objects.equals(userName, other.userName)
				&& Objects.equals(wfBranchId, other.wfBranchId) && Objects.equals(wfRoleCode, other.wfRoleCode)
				&& Objects.equals(wfRoleIds, other.wfRoleIds) && Objects.equals(wfRoleList, other.wfRoleList)
				&& Objects.equals(wfRoles, other.wfRoles) && Objects.equals(wfStatusList, other.wfStatusList)
				&& Objects.equals(willBePrimary, other.willBePrimary)
				&& Objects.equals(workFlowStatusList, other.workFlowStatusList)
				&& Objects.equals(chequeTypes, other.chequeTypes)
				&& Objects.equals(chequeLeaves, other.chequeLeaves)
				&& Objects.equals(chequeFormats, other.chequeFormats)
				&& Objects.equals(accountsList, other.accountsList)
				&& Objects.equals(bankId, other.bankId)
				&& Objects.equals(bankName, other.bankName)
				&& Objects.equals(bankBranchId, other.bankBranchId)
				&& Objects.equals(bankBranchName, other.bankBranchName)
				&& Objects.equals(bankBranchList, other.bankBranchList)
				&& Objects.equals(banksList, other.banksList);
	}

	/**
	 * Gets the wf roles.
	 *
	 * @return the wf roles
	 */
	public Set<String> getWfRoles() {
		return wfRoles;
	}

	/**
	 * Sets the wf roles.
	 *
	 * @param wfRoles the new wf roles
	 */
	public void setWfRoles(Set<String> wfRoles) {
		this.wfRoles = wfRoles;
	}

	/**
	 * Gets the cheque types.
	 *
	 * @return the cheque types
	 */
	public List<ClueDto> getChequeTypes() {
		return chequeTypes;
	}

	/**
	 * Sets the cheque types.
	 *
	 * @param chequeTypes the new cheque types
	 */
	public void setChequeTypes(List<ClueDto> chequeTypes) {
		this.chequeTypes = chequeTypes;
	}

	/**
	 * Gets the accounts list.
	 *
	 * @return the accounts list
	 */
	public List<ClueDto> getAccountsList() {
		return accountsList;
	}

	/**
	 * Sets the accounts list.
	 *
	 * @param accountsList the new accounts list
	 */
	public void setAccountsList(List<ClueDto> accountsList) {
		this.accountsList = accountsList;
	}

	/**
	 * Gets the bank id.
	 *
	 * @return the bank id
	 */
	public Long getBankId() {
		return bankId;
	}

	/**
	 * Sets the bank id.
	 *
	 * @param bankId the new bank id
	 */
	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	/**
	 * Gets the bank name.
	 *
	 * @return the bank name
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * Sets the bank name.
	 *
	 * @param bankName the new bank name
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * Gets the bank branch id.
	 *
	 * @return the bank branch id
	 */
	public Long getBankBranchId() {
		return bankBranchId;
	}

	/**
	 * Sets the bank branch id.
	 *
	 * @param bankBranchId the new bank branch id
	 */
	public void setBankBranchId(Long bankBranchId) {
		this.bankBranchId = bankBranchId;
	}

	/**
	 * Gets the bank branch name.
	 *
	 * @return the bank branch name
	 */
	public String getBankBranchName() {
		return bankBranchName;
	}

	/**
	 * Sets the bank branch name.
	 *
	 * @param bankBranchName the new bank branch name
	 */
	public void setBankBranchName(String bankBranchName) {
		this.bankBranchName = bankBranchName;
	}

	/**
	 * Gets the banks list.
	 *
	 * @return the banks list
	 */
	public List<ClueDto> getBanksList() {
		return banksList;
	}

	/**
	 * Sets the banks list.
	 *
	 * @param banksList the new banks list
	 */
	public void setBanksList(List<ClueDto> banksList) {
		this.banksList = banksList;
	}

	/**
	 * Gets the bank branch list.
	 *
	 * @return the bank branch list
	 */
	public List<ClueDto> getBankBranchList() {
		return bankBranchList;
	}

	/**
	 * Sets the bank branch list.
	 *
	 * @param bankBranchList the new bank branch list
	 */
	public void setBankBranchList(List<ClueDto> bankBranchList) {
		this.bankBranchList = bankBranchList;
	}

	/**
	 * Gets the cheque formats.
	 *
	 * @return the cheque formats
	 */
	public List<ClueDto> getChequeFormats() {
		return chequeFormats;
	}

	/**
	 * Sets the cheque formats.
	 *
	 * @param chequeFormats the new cheque formats
	 */
	public void setChequeFormats(List<ClueDto> chequeFormats) {
		this.chequeFormats = chequeFormats;
	}

	/**
	 * Gets the cheque leaves.
	 *
	 * @return the cheque leaves
	 */
	public List<ClueDto> getChequeLeaves() {
		return chequeLeaves;
	}

	/**
	 * Sets the cheque leaves.
	 *
	 * @param chequeLeaves the new cheque leaves
	 */
	public void setChequeLeaves(List<ClueDto> chequeLeaves) {
		this.chequeLeaves = chequeLeaves;
	}

	/**
	 * Gets the cheque format.
	 *
	 * @return the cheque format
	 */
	public String getChequeFormat() {
		return chequeFormat;
	}

	/**
	 * Sets the cheque format.
	 *
	 * @param chequeFormat the new cheque format
	 */
	public void setChequeFormat(String chequeFormat) {
		this.chequeFormat = chequeFormat;
	}

	/**
	 * Gets the cheque type name.
	 *
	 * @return the cheque type name
	 */
	public String getChequeTypeName() {
		return chequeTypeName;
	}

	/**
	 * Sets the cheque type name.
	 *
	 * @param chequeTypeName the new cheque type name
	 */
	public void setChequeTypeName(String chequeTypeName) {
		this.chequeTypeName = chequeTypeName;
	}

	/**
	 * Gets the cheque type.
	 *
	 * @return the cheque type
	 */
	public Long getChequeType() {
		return chequeType;
	}

	/**
	 * Sets the cheque type.
	 *
	 * @param chequeType the new cheque type
	 */
	public void setChequeType(Long chequeType) {
		this.chequeType = chequeType;
	}

	/**
	 * Gets the req no of cheque books.
	 *
	 * @return the req no of cheque books
	 */
	public Long getReqNoOfChequeBooks() {
		return reqNoOfChequeBooks;
	}

	/**
	 * Sets the req no of cheque books.
	 *
	 * @param reqNoOfChequeBooks the new req no of cheque books
	 */
	public void setReqNoOfChequeBooks(Long reqNoOfChequeBooks) {
		this.reqNoOfChequeBooks = reqNoOfChequeBooks;
	}

	/**
	 * Gets the req no of cheque per book.
	 *
	 * @return the req no of cheque per book
	 */
	public Long getReqNoOfChequePerBook() {
		return reqNoOfChequePerBook;
	}

	/**
	 * Sets the req no of cheque per book.
	 *
	 * @param reqNoOfChequePerBook the new req no of cheque per book
	 */
	public void setReqNoOfChequePerBook(Long reqNoOfChequePerBook) {
		this.reqNoOfChequePerBook = reqNoOfChequePerBook;
	}

	/**
	 * Gets the balance quantity.
	 *
	 * @return the balance quantity
	 */
	public Long getBalanceQuantity() {
		return balanceQuantity;
	}

	/**
	 * Sets the balance quantity.
	 *
	 * @param balanceQuantity the new balance quantity
	 */
	public void setBalanceQuantity(Long balanceQuantity) {
		this.balanceQuantity = balanceQuantity;
	}

	/**
	 * Gets the to wf status.
	 *
	 * @return the to wf status
	 */
	public String getToWfStatus() {
		return toWfStatus;
	}

	/**
	 * Sets the to wf status.
	 *
	 * @param toWfStatus the new to wf status
	 */
	public void setToWfStatus(String toWfStatus) {
		this.toWfStatus = toWfStatus;
	}

	/**
	 * Gets the to status.
	 *
	 * @return the to status
	 */
	public String getToStatus() {
		return toStatus;
	}

	/**
	 * Sets the to status.
	 *
	 * @param toStatus the new to status
	 */
	public void setToStatus(String toStatus) {
		this.toStatus = toStatus;
	}

	/**
	 * Gets the district name.
	 *
	 * @return the district name
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * Sets the district name.
	 *
	 * @param districtName the new district name
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	/**
	 * Instantiates a new clue dto.
	 *
	 * @param officeId the office id
	 * @param districtid the districtid
	 * @param officeName the office name
	 * @param districtName the district name
	 */
	public ClueDto(Long officeId, Long districtid, String officeName,  String districtName) {
		this.officeId = officeId;
		this.officeName = officeName;
		this.districtid = districtid;
		this.districtName = districtName;
	}
		
}