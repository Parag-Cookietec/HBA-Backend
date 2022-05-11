package gov.ifms.dmo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;


@Entity
@Table(name = "MDMO_DPS_TRANSACTION_TYPES", schema = Constant.DMO_SCHEMA)
public class DMODPSTransactionTypeEntity extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRANS_TYPE_ID")
	private Long id;
	
	@Column(name = "TRANSACTION_TYPE")
	private String transactionType;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "TRANS_TYPE_ID")
	private List<DMODPSTransactionSubTypeEntity> subTransactions = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public List<DMODPSTransactionSubTypeEntity> getSubTransactions() {
		if (subTransactions == null) {
			subTransactions = new ArrayList<>(0);
		}
		return subTransactions;
	}

	public void setSubTransactions(List<DMODPSTransactionSubTypeEntity> subTransactions) {
		this.subTransactions = subTransactions;
	}
	
	
}
