package br.com.patrickalmeida.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.patrickalmeida.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
