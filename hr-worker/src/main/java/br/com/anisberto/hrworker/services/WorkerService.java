package br.com.anisberto.hrworker.services;

import br.com.anisberto.hrworker.entities.Worker;
import br.com.anisberto.hrworker.repositories.WorkerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

	@Autowired
	private WorkerRespository workerRespository;

	public List<Worker> findAll() {
		return workerRespository.findAll();
	}

	public Optional<Worker> findById(Long id) {
		return workerRespository.findById(id);
	}
}
