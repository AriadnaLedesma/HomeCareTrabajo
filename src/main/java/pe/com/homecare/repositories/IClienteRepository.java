package pe.com.homecare.repositories;

import org.springframework.data.repository.CrudRepository;

import pe.com.homecare.dtos.ClienteDTO;
import pe.com.homecare.entities.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente, Integer>{

	
}


