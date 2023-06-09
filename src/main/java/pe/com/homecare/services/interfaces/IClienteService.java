package pe.com.homecare.services.interfaces;


import java.util.List;

import pe.com.homecare.dtos.ClienteDTO;
import pe.com.homecare.entities.Cliente;

public interface IClienteService {

	public void delete (int id) ;
	
	public List<ClienteDTO> listarCliente() ; 
	
	public Cliente registroCliente(ClienteDTO clienteDTO);	

	public Cliente findById(int id);
	
}