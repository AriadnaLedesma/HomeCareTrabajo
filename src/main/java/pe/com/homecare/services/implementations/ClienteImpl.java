package pe.com.homecare.services.implementations;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.homecare.dtos.ClienteDTO;
import pe.com.homecare.entities.Cliente;
import pe.com.homecare.repositories.IClienteRepository;
import pe.com.homecare.services.interfaces.IClienteService;
import pe.com.homecare.utils.MHelpers;

@Service
public class ClienteImpl implements IClienteService{

	@Autowired
	private IClienteRepository clienteRepo;
	
	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		clienteRepo.deleteById(id);
	}
	
	
	@Override
	public List<ClienteDTO> listarCliente() {
		
		  List<ClienteDTO> dto = new ArrayList<>();

	      Iterable<Cliente> clientes = this.clienteRepo.findAll();

	      for(Cliente cliente : clientes){
	    	  ClienteDTO clienteDTO = MHelpers.modelMapper().map(cliente,ClienteDTO.class);
	        dto.add(clienteDTO);
	      }
	      return dto;
		// TODO Auto-generated method stub
		
	}

	@Override	
	public Cliente registroCliente(ClienteDTO clienteDTO) {
		// TODO Auto-generated method stub
		Cliente cliente = MHelpers.modelMapper().map(clienteDTO, Cliente.class);

//validar en repository		  
	     return clienteRepo.save(cliente);
		//return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(int id) {
		// TODO Auto-generated method stub 
		return clienteRepo.findById(id).orElse(null);
	}
}
