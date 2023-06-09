package pe.com.homecare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.homecare.dtos.ClienteDTO;
import pe.com.homecare.entities.Cliente;
import pe.com.homecare.services.interfaces.IClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
    private IClienteService clienteService;

    @GetMapping(value = "/listado")
    public String listadoCliente(Model model) {
      
        List <ClienteDTO> listaCliente = clienteService.listarCliente();
        
        model.addAttribute("listado", listaCliente);
        return "listadoCliente";
        
    }
    
    @RequestMapping("/crear")
	public String nuevoCliente(Model model) {
		ClienteDTO cliente = new ClienteDTO();
		model.addAttribute("cliente", cliente);
		return "registro-cliente";
		
	}
    
    @PostMapping("/creaCliente")
	public String creaCliente (ClienteDTO clienteDTO) {
    	clienteService.registroCliente(clienteDTO);
		return "redirect:/cliente/listado";
	}

    @RequestMapping("/editarCliente/{id}")
	public String modificarXId(Model model, @PathVariable("id") int id) {
		
		Cliente cliente = clienteService.findById(id);
		
		model.addAttribute("cliente", cliente);
		
		return "editar-cliente";		
	}
    
    @RequestMapping("/eliminarCliente/{id}")
	public String eliminarCliente (@PathVariable(name = "id") int id) {
		clienteService.delete(id);
		return "redirect:/cliente/listado";
	}
    
    @PostMapping("/modificaCliente")
	public String actualizaEstudiante(ClienteDTO clienteDTO) {
		System.out.print("hola");
    	clienteService.registroCliente(clienteDTO);
		return "redirect:/cliente/listado";		
	}
}
