package br.com.patrickalmeida.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.patrickalmeida.hrworker.entities.Worker;
import br.com.patrickalmeida.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping("/workers")
public class WorkerResource {
	
	private static Logger loggger = org.slf4j.LoggerFactory.getLogger(WorkerResource.class);

	@Autowired
	private Environment environment;
	
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> getAll() {
		List<Worker> workers = workerRepository.findAll();
		return ResponseEntity.ok(workers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> getById(@PathVariable Long id) {
		loggger.info("PORT=" + environment.getProperty("local.server.port"));
		
		Worker worker = workerRepository.findById(id).get();
		return ResponseEntity.ok(worker);
	}
}
