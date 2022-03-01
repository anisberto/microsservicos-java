package br.com.anisberto.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.anisberto.hrpayroll.entities.Payment;
import br.com.anisberto.hrpayroll.entities.Worker;
import br.com.anisberto.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(long workerId, int days) {
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return Payment.builder()
				.name(worker.getName())
				.dailyIncome(worker.getDailyIncome())
				.days(days)
				.build();
	}
}
