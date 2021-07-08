package br.com.anisberto.hrpayroll.services;

import org.springframework.stereotype.Service;

import br.com.anisberto.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	public Payment getPayment(long workerId, int days) {
		return new Payment("Anisberto", 200.0, days);
	}
}
