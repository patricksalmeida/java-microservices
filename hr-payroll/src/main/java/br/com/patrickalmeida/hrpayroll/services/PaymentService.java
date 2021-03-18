package br.com.patrickalmeida.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.patrickalmeida.hrpayroll.clients.WorkerClient;
import br.com.patrickalmeida.hrpayroll.entities.Payment;
import br.com.patrickalmeida.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerClient workerClient;

	public Payment getPayment(long workerId, int days) {
		
		Worker worker = workerClient.getById(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
