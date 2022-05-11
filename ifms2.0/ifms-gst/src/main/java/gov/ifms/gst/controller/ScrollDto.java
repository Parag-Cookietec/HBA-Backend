package gov.ifms.gst.controller;

import gov.ifms.gst.dto.BankDto;
import gov.ifms.gst.dto.ChallanDistributionSADADto;
import gov.ifms.gst.dto.LoadBalancerAODto;
import gov.ifms.gst.dto.LoadBalancerHADto;

import java.util.ArrayList;
import java.util.List;

public class ScrollDto {
	private List<ChallanDistributionSADADto> challan = new ArrayList<>();
	private List<BankDto> bankNames = new ArrayList<>();
	private List<SadaDto> sadaName = new ArrayList<>();
	private List<LoadBalancerHADto> loadBalancerHa = new ArrayList<>();
	private List<LoadBalancerAODto> loadBalancerAo = new ArrayList<>();

	public List<SadaDto> getSadaName() {
		return sadaName;
	}

	public void setSadaName(List<SadaDto> sadaName) {
		this.sadaName = sadaName;
	}

	public List<ChallanDistributionSADADto> getChallan() {
		return challan;
	}

	public void setChallan(List<ChallanDistributionSADADto> challan) {
		this.challan = challan;
	}

	public List<BankDto> getBankNames() {
		return bankNames;
	}

	public void setBankNames(List<BankDto> bankNames) {
		this.bankNames = bankNames;
	}

	public List<LoadBalancerHADto> getLoadBalancerHa() {
		return loadBalancerHa;
	}

	public void setLoadBalancerHa(List<LoadBalancerHADto> loadBalancerHa) {
		this.loadBalancerHa = loadBalancerHa;
	}

	public List<LoadBalancerAODto> getLoadBalancerAo() {
		return loadBalancerAo;
	}

	public void setLoadBalancerAo(List<LoadBalancerAODto> loadBalancerAo) {
		this.loadBalancerAo = loadBalancerAo;
	}

}
