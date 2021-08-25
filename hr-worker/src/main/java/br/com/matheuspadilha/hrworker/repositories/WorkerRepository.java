package br.com.matheuspadilha.hrworker.repositories;

import br.com.matheuspadilha.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
