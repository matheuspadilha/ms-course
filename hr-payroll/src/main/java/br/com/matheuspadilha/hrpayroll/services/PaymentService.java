package br.com.matheuspadilha.hrpayroll.services;

import br.com.matheuspadilha.hrpayroll.entities.Payment;
import br.com.matheuspadilha.hrpayroll.entities.Worker;
import br.com.matheuspadilha.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PaymentService {
    
    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, int days) {
        
        Worker worker = workerFeignClient.findById(workerId).getBody();
        
        Objects.requireNonNull(worker);
        
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
