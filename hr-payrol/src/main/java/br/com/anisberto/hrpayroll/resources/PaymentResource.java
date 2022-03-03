package br.com.anisberto.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.anisberto.hrpayroll.entities.Payment;
import br.com.anisberto.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
	@Autowired
	private PaymentService paymentService;

	@GetMapping
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	public ResponseEntity<String> getStatusServer() {
		return ResponseEntity.ok().body(new String("Servidor Rodando..."));
	}

	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		Payment payment = paymentService.getPayment(workerId, days);
		return ResponseEntity.ok().body(payment);
	}

	public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days) {
		Payment pay = Payment.builder().name("Dado Mocado").dailyIncome(0.00).days(days).build();
		return ResponseEntity.ok().body(pay);
	}
}
