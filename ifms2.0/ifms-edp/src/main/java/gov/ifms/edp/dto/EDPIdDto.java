package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The Class EDPIdDto.
 */
public class EDPIdDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private long id;

	/** The is from. */
	private boolean isFrom;

	/** The lk po off id. */
	private long lkPoOffId;

	/** The user id. */
	private long userId;

	/** The user code. */
	private String userCode;

	/** The office id. */
	private Long officeId;

	/** The edp usr trn header id. */
	private Long edpUsrTrnHeaderId;

	/** The lk po off user id. */
	private List<Long> postOfficeIds;

	/** The alias. */
	private String alias;

	/**  The Menu Id. */
	private Long menuId;

	/** The district id. */
	private Long districtId;

	/** The cardex no. */
	private Long cardexNo;

	/** The ddo no. */
	private String ddoNo;

	/** The office name. */
	private String officeName;

	/** The post office user id. */
	private Long postOfficeUserId;
	
	/** The from pou id. */
	private Long fromPouId;

	/** The to pou id. */
	private Long toPouId;

	/**
	 * Instantiates a new EDP id dto.
	 */
	public EDPIdDto() {
	}

	/**
	 * Instantiates a new EDP id dto.
	 *
	 * @param id the id
	 */
	public EDPIdDto(long id) {
		super();
		this.id = id;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Checks if is from.
	 *
	 * @return the isFrom
	 */
	public boolean isFrom() {
		return isFrom;
	}

	/**
	 * Sets the from.
	 *
	 * @param isFrom the isFrom to set
	 */
	public void setFrom(boolean isFrom) {
		this.isFrom = isFrom;
	}

	/**
	 * Gets the lk po off id.
	 *
	 * @return the lkPoOffId
	 */
	public long getLkPoOffId() {
		return lkPoOffId;
	}

	/**
	 * Sets the lk po off id.
	 *
	 * @param lkPoOffId the lkPoOffId to set
	 */
	public void setLkPoOffId(long lkPoOffId) {
		this.lkPoOffId = lkPoOffId;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * Gets the user code.
	 *
	 * @return the userCode
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * Sets the user code.
	 *
	 * @param userCode the userCode to set
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
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
	 * Gets the edp usr trn header id.
	 *
	 * @return the edpUsrTrnHeaderId
	 */
	public Long getEdpUsrTrnHeaderId() {
		return edpUsrTrnHeaderId;
	}

	/**
	 * Sets the edp usr trn header id.
	 *
	 * @param edpUsrTrnHeaderId the edpUsrTrnHeaderId to set
	 */
	public void setEdpUsrTrnHeaderId(Long edpUsrTrnHeaderId) {
		this.edpUsrTrnHeaderId = edpUsrTrnHeaderId;
	}

	/**
	 * Gets the post office ids.
	 *
	 * @return the post office ids
	 */
	public List<Long> getPostOfficeIds() {
		return postOfficeIds;
	}

	/**
	 * Sets the post office ids.
	 *
	 * @param postOfficeIds the new post office ids
	 */
	public void setPostOfficeIds(List<Long> postOfficeIds) {
		this.postOfficeIds = postOfficeIds;
	}
	
	/**
	 * Gets the alias.
	 *
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * Sets the alias.
	 *
	 * @param alias the new alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
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
	 * Gets the district id.
	 *
	 * @return the district id
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the new district id
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(edpUsrTrnHeaderId, id, isFrom, lkPoOffId, officeId, userCode, userId, postOfficeIds, alias, menuId, cardexNo, ddoNo, officeName, fromPouId, toPouId);
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
		if (!(obj instanceof EDPIdDto)) {
			return false;
		}
		EDPIdDto other = (EDPIdDto) obj;
		return Objects.equals(edpUsrTrnHeaderId, other.edpUsrTrnHeaderId) && id == other.id && isFrom == other.isFrom
				&& lkPoOffId == other.lkPoOffId && Objects.equals(officeId, other.officeId)
				&& Objects.equals(userCode, other.userCode) && userId == other.userId && postOfficeIds == other.postOfficeIds && alias == other.alias
				&& menuId == other.menuId && Objects.equals(ddoNo, other.ddoNo) && Objects.equals(cardexNo, other.cardexNo) && Objects.equals(officeName, other.officeName)
				&& Objects.equals(fromPouId, other.fromPouId) && Objects.equals(toPouId, other.toPouId); 
	}

	/**
	 * Gets the cardex no.
	 *
	 * @return the cardex no
	 */
	public Long getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the new cardex no
	 */
	public void setCardexNo(Long cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * Gets the ddo no.
	 *
	 * @return the ddo no
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the new ddo no
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * Gets the office name.
	 *
	 * @return the office name
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the new office name
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * Gets the post office user id.
	 *
	 * @return the post office user id
	 */
	public Long getPostOfficeUserId() {
		return postOfficeUserId;
	}

	/**
	 * Sets the post office user id.
	 *
	 * @param postOfficeUserId the new post office user id
	 */
	public void setPostOfficeUserId(Long postOfficeUserId) {
		this.postOfficeUserId = postOfficeUserId;
	}

	/**
	 * Gets the from pou id.
	 *
	 * @return the from pou id
	 */
	public Long getFromPouId() {
		return fromPouId;
	}

	/**
	 * Sets the from pou id.
	 *
	 * @param fromPouId the new from pou id
	 */
	public void setFromPouId(Long fromPouId) {
		this.fromPouId = fromPouId;
	}

	/**
	 * Gets the to pou id.
	 *
	 * @return the to pou id
	 */
	public Long getToPouId() {
		return toPouId;
	}

	/**
	 * Sets the to pou id.
	 *
	 * @param toPouId the new to pou id
	 */
	public void setToPouId(Long toPouId) {
		this.toPouId = toPouId;
	}
	
}
