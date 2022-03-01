package br.com.anisberto.hrworker.repositories;

import br.com.anisberto.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRespository extends JpaRepository<Worker, Long> {
	Worker getById(long id);
}