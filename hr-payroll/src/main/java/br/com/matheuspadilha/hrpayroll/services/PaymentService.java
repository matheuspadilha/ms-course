package br.com.matheuspadilha.hrpayroll.services;

import br.com.matheuspadilha.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, int days) {
        return new Payment("Bob", 200.0, days);
    }
}
