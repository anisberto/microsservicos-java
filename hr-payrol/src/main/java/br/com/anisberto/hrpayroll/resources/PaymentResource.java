package br.com.anisberto.hrpayroll.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.anisberto.hrpayroll.entities.Payment;
import br.com.anisberto.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "payments")
public class PaymentResource {
	@Autowired
	private PaymentService paymentService;

	@GetMapping
	public ResponseEntity<String> getStatusServer(){
		return ResponseEntity.ok().body(new String("Servidor Rodando..."));
	}
	
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		Payment payment = paymentService.getPayment(workerId, days);
		return ResponseEntity.ok().body(payment);
	}
}
