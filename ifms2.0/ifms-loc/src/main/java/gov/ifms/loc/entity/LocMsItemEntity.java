package gov.ifms.loc.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


/**
 * The Class BudgetItemEntity.
 *
 * @version 1.0
 * @created 2019/08/21 17:06:04
 */
@Entity
@Table(name = "MS_ITEM", schema = Constant.GRANT_MASTER_SCHEMA)
public class LocMsItemEntity extends BaseEntity implements Serializable {

    /**
     * The serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /** The item id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private long itemId;

    /** The item name. */
    @Column(name = "ITEM_NAME")
    private String itemName;

    /** The item name guj. */
    @Column(name = "ITEM_NAME_GUJ")
    private String itemNameGuj;

    /** The item desc. */
    @Column(name = "ITEM_DESC")
    private String itemDesc;


    /** The item code. */
    @Column(name = "ITEM_CODE")
    private String itemCode;

    /** The item code name. */
    @Column(name = "ITEM_CODE_NAME")
    private String itemCodeName;

    /**
     * Gets the item code name.
     *
     * @return the item code name
     */
    public String getItemCodeName() {
        return itemCodeName;
    }

    /**
     * Sets the item code name.
     *
     * @param itemCodeName the new item code name
     */
    public void setItemCodeName(String itemCodeName) {
        this.itemCodeName = itemCodeName;
    }

    /** The item desc guj. */
    @Column(name = "ITEM_DESC_GUJ")
    private String itemDescGuj;


    /** The item type id. */
    @Column(name = "ITEM_TYPE_ID")
    private int itemTypeId;

    /** The parent item id. */
    @Column(name = "PARENT_ITEM_ID")
    private int parentItemId;

    /**
     * Gets the item id.
     *
     * @return the itemId
     */
    public long getItemId() {
        return itemId;
    }

    /**
     * Gets the item type id.
     *
     * @return the item type id
     */
    public int getItemTypeId() {
        return itemTypeId;
    }

    /**
     * Sets the item type id.
     *
     * @param itemTypeId the new item type id
     */
    public void setItemTypeId(int itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    /**
     * Sets the item id.
     *
     * @param itemId the itemId to set
     */
    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    /**
     * Gets the item name.
     *
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Sets the item name.
     *
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the itemNameGuj
     */
    public String getItemNameGuj() {
        return itemNameGuj;
    }

    /**
     * @param itemNameGuj the itemNameGuj to set
     */
    public void setItemNameGuj(String itemNameGuj) {
        this.itemNameGuj = itemNameGuj;
    }

    /**
     * @return the itemDesc
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * @param itemDesc the itemDesc to set
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    /**
     * @return the itemDescGuj
     */
    public String getItemDescGuj() {
        return itemDescGuj;
    }

    /**
     * @param itemDescGuj the itemDescGuj to set
     */
    public void setItemDescGuj(String itemDescGuj) {
        this.itemDescGuj = itemDescGuj;
    }


    /**
     * @return the parentItemId
     */
    public int getParentItemId() {
        return parentItemId;
    }

    /**
     * @param parentItemId the parentItemId to set
     */
    public void setParentItemId(int parentItemId) {
        this.parentItemId = parentItemId;
    }

    /**
     *
     */
    public LocMsItemEntity() {
        super();
    }

    public LocMsItemEntity(long itemId) {
        this.itemId = itemId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemDesc, itemDescGuj, itemId, itemName, itemNameGuj, itemTypeId, parentItemId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocMsItemEntity)) {
            return false;
        }
        LocMsItemEntity other = (LocMsItemEntity) obj;
        return Objects.equals(itemDesc, other.itemDesc) && Objects.equals(itemDescGuj, other.itemDescGuj)
                && itemId == other.itemId && Objects.equals(itemName, other.itemName)
                && Objects.equals(itemNameGuj, other.itemNameGuj) && Objects.equals(itemTypeId, other.itemTypeId)
                && parentItemId == other.parentItemId;
    }

    /**
     * Gets the item code.
     *
     * @return the item code
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * Sets the item code.
     *
     * @param itemCode the new item code
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }


}
