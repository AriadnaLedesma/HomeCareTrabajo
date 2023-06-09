package pe.com.homecare.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.homecare.dtos.ClienteDTO;
import pe.com.homecare.entities.Cliente;
import pe.com.homecare.services.interfaces.IClienteService;

@RestController
@RequestMapping ("/cliente")
public class RestControllerCliente {

	@Autowired
    private IClienteService clienteService;
	
	@GetMapping (value = "/listarCliente")
	 public  List <ClienteDTO> listaCliente() {	      
	       return clienteService.listarCliente();	        
	}
	
	 
	@PostMapping("/crearCliente")
	public Cliente registroCliente (@RequestBody ClienteDTO clienteDTO) {	    	
			return clienteService.registroCliente(clienteDTO);
	}
	
	 @DeleteMapping("/eliminarCliente/{id}")
		public void delete (@PathVariable(name = "id") int id) {
			 clienteService.delete(id);
		}
	 
	 
	 @PutMapping
		public Cliente actualizaEstudiante (@RequestBody ClienteDTO clienteDTO){	
			
			return clienteService.registroCliente(clienteDTO);	
		}
			
	 }
