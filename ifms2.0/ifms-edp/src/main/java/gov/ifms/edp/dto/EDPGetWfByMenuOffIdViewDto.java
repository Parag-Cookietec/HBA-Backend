package gov.ifms.edp.dto;

	import gov.ifms.common.dao.NativeQueryResultColumn;
	import gov.ifms.common.dao.NativeQueryResultEntity;

	/**
	 * The Class EDPUserRightsGivenRemovalDto.
	 */
	@NativeQueryResultEntity
	public class EDPGetWfByMenuOffIdViewDto {

		/** The employee id. */
		@NativeQueryResultColumn(index = 0)
		private String employeeNumber;
		
		/** The employee number. */
		@NativeQueryResultColumn(index = 1)
		private String wfRoleId;
		
		/** The employee name. */
		@NativeQueryResultColumn(index = 2)
		private String wfRoleName;
		/** The post id. */
		@NativeQueryResultColumn(index = 3)
		private String postId;
		
		/** The post name. */
		@NativeQueryResultColumn(index = 4)
		private String officeId;
		
		
		/** The post type. */
		@NativeQueryResultColumn(index = 5)
		private String menuName;
		
		/** The post type. */
		@NativeQueryResultColumn(index = 6)
		private String status;
		
		
		public String getEmployeeNumber() {
			return employeeNumber;
		}

		public void setEmployeeNumber(String employeeNumber) {
			this.employeeNumber = employeeNumber;
		}

		public String getWfRoleId() {
			return wfRoleId;
		}

		public void setWfRoleId(String wfRoleId) {
			this.wfRoleId = wfRoleId;
		}

		public String getWfRoleName() {
			return wfRoleName;
		}

		public void setWfRoleName(String wfRoleName) {
			this.wfRoleName = wfRoleName;
		}

		public String getPostId() {
			return postId;
		}

		public void setPostId(String postId) {
			this.postId = postId;
		}

		public String getOfficeId() {
			return officeId;
		}

		public void setOfficeId(String officeId) {
			this.officeId = officeId;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getMenuName() {
			return menuName;
		}

		public void setMenuName(String menuName) {
			this.menuName = menuName;
		}

		
		
		
	}


