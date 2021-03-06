package br.com.anisberto.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.anisberto.hrpayroll.entities.Payment;
import br.com.anisberto.hrpayroll.entities.Worker;

@Service
public class PaymentService {

	@Value("${hr-worker.host}")
	private String workerHost;

	@Autowired
	private RestTemplate restTemplate;

	public Payment getPayment(Long workerId, int days) {
		Map<String, String> uriVariable = new HashMap();
		uriVariable.put("id", workerId + "");
		Worker worker = restTemplate.getForObject(workerHost + "/worker/{id}", Worker.class, uriVariable);
		return new Payment(worker.getName(), worker.getDailyIcome(), days);
	}
}
