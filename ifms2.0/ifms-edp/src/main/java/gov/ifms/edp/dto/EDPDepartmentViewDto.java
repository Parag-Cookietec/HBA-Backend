package gov.ifms.edp.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class EDPDepartmentViewDto {
	
		/** The department id. */
		@NativeQueryResultColumn(index = 0)
		private String departmentId;
		
		/** The department name. */
		@NativeQueryResultColumn(index = 1)
		private String departmentName;

		public String getDepartmentId() {
			return departmentId;
		}

		public void setDepartmentId(String departmentId) {
			this.departmentId = departmentId;
		}

		public String getDepartmentName() {
			return departmentName;
		}

		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}
		
}
