package br.com.anisberto.hrworker.repositories;

import br.com.anisberto.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRespository extends JpaRepository<Worker, Long> {
}