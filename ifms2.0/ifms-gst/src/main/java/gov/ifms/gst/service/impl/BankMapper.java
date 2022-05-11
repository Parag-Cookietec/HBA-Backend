package gov.ifms.gst.service.impl;

import gov.ifms.gst.controller.SadaDto;
import gov.ifms.gst.dto.ChallanDistributionSADADto;
import gov.ifms.gst.dto.LoadBalancerHADto;
import gov.ifms.gst.entity.SADAChallanMapping;
import gov.ifms.gst.repository.ScrollDistributeRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

public class BankMapper {


	static List<ChallanDistributionSADADto> mapper(List<Object[]> results) {
		return results.stream().map(o -> {
			ChallanDistributionSADADto e = new ChallanDistributionSADADto();
			e.setBankName((String) o[1]);
			e.setTotalChallans(Short.parseShort(String.valueOf(o[0])));
			e.setAvailableChallans((short) (e.getTotalChallans() - e.getTotalDitributed()));
			e.setFileProcessId(Long.parseLong(String.valueOf(o[2])));
			e.setBankId(Long.parseLong(String.valueOf(o[3])));
			e.setBankCd((String) o[4]);
			return e;
		}).collect(Collectors.toList());
	}

	static List<SadaDto> mappers(List<Object[]> results) {
		return results.stream().map(o -> {
			SadaDto e = new SadaDto();
			e.setSadaName((String) o[1]);
			e.setSadaId(((java.math.BigInteger) o[0]).longValue());
			return e;
		}).collect(Collectors.toList());
	}

	static List<LoadBalancerHADto> mapperForBalancer(List<Object[]> results) {
		return results.stream().map(o -> {
			LoadBalancerHADto e = new LoadBalancerHADto();
			e.setBankName((String) o[0]);
			e.setFromSaDaName((String) o[1]);
			e.setTotalAmount((Double.parseDouble(String.valueOf(o[3]) ) ));
			e.setTotalChallans(Short.parseShort(String.valueOf(o[2])));
			e.setFileProcessId(Long.parseLong(String.valueOf(o[5])));
			e.setFromSaDaId(Long.parseLong(String.valueOf(o[4])));
			e.setBankId(Long.parseLong(String.valueOf(o[6])));
			return e;
		}).collect(Collectors.toList());
	}

	static List<SADAChallanMapping> mapperForMapping(List<Object[]> results) {
		return results.stream().map(o -> {
			SADAChallanMapping e = new SADAChallanMapping();
			e.setFileProcessId(Long.parseLong(String.valueOf(o[0])));
			e.setRbiFileTranxnId(Long.parseLong(String.valueOf(o[1])));
			e.setBankId(Long.parseLong(String.valueOf(o[2])));
			return e;
		}).collect(Collectors.toList());
	}

}