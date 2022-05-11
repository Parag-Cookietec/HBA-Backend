package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Class EDPSDTDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EDPSDTDto implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    private Long id = null;

    /** The name. */
    private String name = null;

    /** The code. */
    private String code = null;
    
    /** The address. */
    private String address = null;
    
    /** The parent id. */
    private Long parentId = null;

    /** The is CCC exempted. */
    private int isCCCExempted;
    
    /** The districts. */
    private transient List<EDPSDTDto> districts = null;

    /** The taluka. */
    private transient List<EDPSDTDto> taluka = null;

    /**
     * Instantiates a new EDPSDT dto.
     *
     * @param id the id
     * @param name the name
     * @param code the code
     */
    public EDPSDTDto(Long id, String name, String code) {
        super();
        this.id = id;
        this.name = name;
        this.code = code;
    }

    /**
     * Instantiates a new EDPSDT dto.
     *
     * @param id the id
     * @param name the name
     */
    public EDPSDTDto(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    /**
     * Instantiates a new EDPSDT dto.
     *
     * @param id the id
     * @param name the name
     * @param code the code
     * @param address the address
     */
    public EDPSDTDto(Long id, String name, String code,String address) {
        super();
        this.id = id;
        this.name = name;
        this.code = code;
        this.address = address;
    }
    
    /**
     * Instantiates a new EDPSDT dto.
     *
     * @param id the id
     * @param name the name
     * @param code the code
     * @param parentId the parent id
     */
    public EDPSDTDto(Long id, String name, String code,Long parentId) {
        super();
        this.id = id;
        this.name = name;
        this.code = code;
        this.setParentId(parentId);
    }
    
	public EDPSDTDto(Long id, String name, String code, Long parentId, int isCCCExempted) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.setParentId(parentId);
		this.setIsCCCExempted(isCCCExempted);
	}
    
    /**
     * Instantiates a new EDPSDT dto.
     */
    public EDPSDTDto() {
    	
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
     * @param id the id to set
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
     * @param name the name to set
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
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the districts.
     *
     * @return the districts
     */
    public List<EDPSDTDto> getDistricts() {
        return districts;
    }

    /**
     * Sets the districts.
     *
     * @param districts the districts to set
     */
    public void setDistricts(List<EDPSDTDto> districts) {
        this.districts = districts;
    }

    /**
     * Gets the taluka.
     *
     * @return the taluka
     */
    public List<EDPSDTDto> getTaluka() {
        return taluka;
    }

    /**
     * Sets the taluka.
     *
     * @param taluka the taluka to set
     */
    public void setTaluka(List<EDPSDTDto> taluka) {
        this.taluka = taluka;
    }

	/**
	 * @return the parentId
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * Gets the checks if is CCC exempted.
	 *
	 * @return the checks if is CCC exempted
	 */
	public int getIsCCCExempted() {
		return isCCCExempted;
	}

	/**
	 * Sets the checks if is CCC exempted.
	 *
	 * @param isCCCExempted the new checks if is CCC exempted
	 */
	public void setIsCCCExempted(int isCCCExempted) {
		this.isCCCExempted = isCCCExempted;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}
