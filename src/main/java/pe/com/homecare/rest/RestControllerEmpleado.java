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
import pe.com.homecare.dtos.EmpleadoDTO;
import pe.com.homecare.entities.Cliente;
import pe.com.homecare.entities.Empleado;
import pe.com.homecare.services.interfaces.IClienteService;
import pe.com.homecare.services.interfaces.IEmpleadoService;

@RestController
@RequestMapping ("/empleado")
public class RestControllerEmpleado {

	@Autowired
    private IEmpleadoService empleadoService;
	
	@GetMapping (value = "/listarEmpleado")
	 public  List <EmpleadoDTO> listaEmpleado() {	      
	       return empleadoService.listarEmpleado();	        
	}
	
	 
	@PostMapping("/crearEmpleado")
	public Empleado registroEmpleado (@RequestBody EmpleadoDTO empleadoDTO) {	    	
			return empleadoService.registroEmpleado(empleadoDTO);
	}
	
	 @DeleteMapping("/eliminarEmpleado/{id}")
		public void delete (@PathVariable(name = "id") int id) {
		 empleadoService.delete(id);
		}
	 
	 
	 @PutMapping
		public Empleado actualizaEstudiante (@RequestBody EmpleadoDTO empleadoDTO){	
			
			return empleadoService.registroEmpleado(empleadoDTO);	
		}
			
	 }
