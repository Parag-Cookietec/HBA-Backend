package gov.ifms.gst.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TPAO_ACC_MANUAL_ENTRY_CR", schema = GSTConstant.GST_SCHEMA)
public class AccManualEntryCr extends BaseEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACC_MANUAL_CR_ID")
	public Long id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACC_MANUAL_HDR_ID", referencedColumnName = "ACC_MANUAL_HDR_ID")
	public AccManualEntryHdr accManualHdr;

	@Column(name = "CR_MAJORHEAD_ID")
	public Long majorHeadId;

	@Column(name = "CR_MAJORHEAD")
	public String majorHead;

	@Column(name = "CR_SUBMAJORHEAD_ID")
	public Long subMajorHeadId;

	@Column(name = "CR_SUBMAJORHEAD")
	public String subMajorHead;

	@Column(name = "CR_MINORHEAD_ID")
	public Long minorHeadId;

	@Column(name = "CR_MINORHEAD")
	public String minorHead;

	@Column(name = "CR_SUBHEAD_ID")
	public Long subHeadId;

	@Column(name = "CR_SUBHEAD")
	public String subHead;

	@Column(name = "CR_DETAILHEAD_ID")
	public Long detailHeadId;

	@Column(name = "CR_DETAILHEAD")
	public String detailHead;

	@Column(name = "CR_OBJECTHEAD_ID")
	public Long objectHeadId;

	@Column(name = "CR_OBJECTHEAD")
	public String objectHead;

	@Column(name = "CREDIT_AMOUNT")
	public Double creditAmt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AccManualEntryHdr getAccManualHdr() {
		return accManualHdr;
	}

	public void setAccManualHdr(AccManualEntryHdr accManualHdr) {
		this.accManualHdr = accManualHdr;
	}

	public Long getMajorHeadId() {
		return majorHeadId;
	}

	public void setMajorHeadId(Long majorHeadId) {
		this.majorHeadId = majorHeadId;
	}

	public String getMajorHead() {
		return majorHead;
	}

	public void setMajorHead(String majorHead) {
		this.majorHead = majorHead;
	}

	public Long getSubMajorHeadId() {
		return subMajorHeadId;
	}

	public void setSubMajorHeadId(Long subMajorHeadId) {
		this.subMajorHeadId = subMajorHeadId;
	}

	public String getSubMajorHead() {
		return subMajorHead;
	}

	public void setSubMajorHead(String subMajorHead) {
		this.subMajorHead = subMajorHead;
	}

	public Long getMinorHeadId() {
		return minorHeadId;
	}

	public void setMinorHeadId(Long minorHeadId) {
		this.minorHeadId = minorHeadId;
	}

	public String getMinorHead() {
		return minorHead;
	}

	public void setMinorHead(String minorHead) {
		this.minorHead = minorHead;
	}

	public Long getSubHeadId() {
		return subHeadId;
	}

	public void setSubHeadId(Long subHeadId) {
		this.subHeadId = subHeadId;
	}

	public String getSubHead() {
		return subHead;
	}

	public void setSubHead(String subHead) {
		this.subHead = subHead;
	}

	public Long getDetailHeadId() {
		return detailHeadId;
	}

	public void setDetailHeadId(Long detailHeadId) {
		this.detailHeadId = detailHeadId;
	}

	public String getDetailHead() {
		return detailHead;
	}

	public void setDetailHead(String detailHead) {
		this.detailHead = detailHead;
	}

	public Long getObjectHeadId() {
		return objectHeadId;
	}

	public void setObjectHeadId(Long objectHeadId) {
		this.objectHeadId = objectHeadId;
	}

	public String getObjectHead() {
		return objectHead;
	}

	public void setObjectHead(String objectHead) {
		this.objectHead = objectHead;
	}

	public Double getCreditAmt() {
		return creditAmt;
	}

	public void setCreditAmt(Double creditAmt) {
		this.creditAmt = creditAmt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accManualHdr, creditAmt, detailHead, detailHeadId, id, majorHead, majorHeadId, minorHead,
				minorHeadId, objectHead, objectHeadId, subHead, subHeadId, subMajorHead, subMajorHeadId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccManualEntryCr other = (AccManualEntryCr) obj;
		return Objects.equals(accManualHdr, other.accManualHdr) && Objects.equals(creditAmt, other.creditAmt)
				&& Objects.equals(detailHead, other.detailHead) && Objects.equals(detailHeadId, other.detailHeadId)
				&& Objects.equals(id, other.id) && Objects.equals(majorHead, other.majorHead)
				&& Objects.equals(majorHeadId, other.majorHeadId) && Objects.equals(minorHead, other.minorHead)
				&& Objects.equals(minorHeadId, other.minorHeadId) && Objects.equals(objectHead, other.objectHead)
				&& Objects.equals(objectHeadId, other.objectHeadId) && Objects.equals(subHead, other.subHead)
				&& Objects.equals(subHeadId, other.subHeadId) && Objects.equals(subMajorHead, other.subMajorHead)
				&& Objects.equals(subMajorHeadId, other.subMajorHeadId);
	}

}


