package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TPAO_NONRECON_HEADS_DATA", schema = GSTConstant.GST_SCHEMA)
public class NonReconHeadsData extends BaseEntity implements Serializable {

	public static final String TRN_SCREEN_NHD = "NHD";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NONRECON_HEADS_ID")
	private long id;

	@Column(name = "PAO_FILE_HDR_ID")
	private long paoFileHdrId;

	@Column(name = "STATE_CD")
	private short stateCd;

	@Column(name = "NER_RECON_DT")
	private Date nerReconDt;

	@Column(name = "OTHR_MODE_RECON_DT")
	private Date othrModeReconDt;

	@Column(name = "RECON_TYPE_CD")
	private String reconTypeCd;

	@Column(name = "PAYMENT_MODE_CD")
	private String paymentModeCd;

	@Column(name = "IS_GSTIN_TMPId")
	private String isGstinTmpid;

	@Column(name = "GSTIN_TMPID_NO")
	private String gstinTmpidNo;

	@Column(name = "CPIN_NO")
	private long cpinNo;

	@Column(name = "CIN_NO")
	private String cinNo;

	@Column(name = "E_SCROLL_NUM")
	private long eScrollNum;

	@Column(name = "RBI_CGST_TOTAL")
	private Double rbiCgstTotal;

	@Column(name = "RBI_IGST_TOTAL")
	private Double rbiIgstTotal;

	@Column(name = "RBI_SGST_TOTAL")
	private Double rbiSgstTotal;

	@Column(name = "RBI_CESS_TOTAL")
	private Double rbiCessTotal;

	@Column(name = "GST_CGST_TOTAL")
	private Double gstCgstTotal;

	@Column(name = "GST_IGST_TOTAL")
	private Double gstIgstTotal;

	@Column(name = "GST_SGST_TOTAL")
	private Double gstSgstTotal;

	@Column(name = "GST_CESS_TOTAL")
	private Double gstCessTotal;

	public NonReconHeadsData(Long id) {
		super();
		this.id = id;
	}

	public NonReconHeadsData() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
