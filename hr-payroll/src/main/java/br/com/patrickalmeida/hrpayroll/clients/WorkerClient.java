package br.com.patrickalmeida.hrpayroll.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.patrickalmeida.hrpayroll.entities.Worker;

@Component
@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/workers")
public interface WorkerClient {

	@GetMapping("/{id}")
	ResponseEntity<Worker> getById(@PathVariable Long id);
	
}
