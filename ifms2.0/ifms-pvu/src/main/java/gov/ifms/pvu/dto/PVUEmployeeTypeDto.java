package gov.ifms.pvu.dto;

public interface PVUEmployeeTypeDto {

	Long getEmpNo();

	String getEmpName();

	Long getOfficeId();

	String getOfficeName();

	Long getEmpTypeId();

	String getEmpTypeName();

	Long getDesigId();

	String getDesigName();

	Long getEmpClassId();

	String getEmpClassName();

	String getDoj();
	
	String getEmpPayTypeName();
	
	Long getCurrentPayType();
	
	Long getEOL();
	
	Long getSuspension();
	
	Long getTransfer();
	
	String getTransNo();
	
	Long getIncremnt();
	
}
