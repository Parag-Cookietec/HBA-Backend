/**
 * 
 */
package gov.ifms.pvu.dto.enumration;

import gov.ifms.pvu.dto.PVUEmployeeEventStatusDto;

/**
 * @author
 *
 *to be used from PVUEmployeeEventStatusServiceImpl.getInProgressFlage()
 *
 */
public enum PVUEmployeeEventStatusEnum {

	EOL
	{
		@Override
		public String applyInProgressFlag(PVUEmployeeEventStatusDto statusDto) {
			if (statusDto.getEol() == 1) {
	            return "EOL";
	        }
			return null;
		}
	},
	SUS
	{
		@Override
		public String applyInProgressFlag(PVUEmployeeEventStatusDto statusDto) {
			if (statusDto.getSuspension() == 1) {
	            return "SUS";
	        }
			return null;
		}
	},
	PROMOTION
	{
		@Override
		public String applyInProgressFlag(PVUEmployeeEventStatusDto statusDto) {
			if (statusDto.getPromotion() == 1) {
	            return "PROMOTION";
	        }
			return null;
		}
	};	
	
	
	public String applyInProgressFlag(PVUEmployeeEventStatusDto statusDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
