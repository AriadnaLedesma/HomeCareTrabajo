package pe.com.homecare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.homecare.dtos.EmpleadoDTO;
import pe.com.homecare.entities.Empleado;
import pe.com.homecare.services.interfaces.IEmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	@Autowired
    private IEmpleadoService empleadoService;

    @GetMapping(value = "/listado", produces = MediaType.APPLICATION_JSON_VALUE)
    public String listadoEmpleado(Model model) {
      
        List <EmpleadoDTO> listaEmpleado = empleadoService.listarEmpleado();
        
        model.addAttribute("listado", listaEmpleado);
        return "listadoEmpleado";
        
    }
    
    @RequestMapping("/crear")
	public String nuevoEmpleado(Model model) {
		EmpleadoDTO empleado = new EmpleadoDTO();
		model.addAttribute("empleado", empleado);
		return "registro-empleado";
		
	}
    
    @PostMapping("/creaEmpleado")
	public String creaEmpleado (EmpleadoDTO empleadoDTO) {
    	empleadoService.registroEmpleado(empleadoDTO);
		return "redirect:/empleado/listado";
	}

    @RequestMapping("/editar/{id}")
	public String modificarXId(Model model, @PathVariable("id") int id) {
		
		Empleado empleado = empleadoService.findById(id);
		
		model.addAttribute("empleado", empleado);
		
		return "editar-empleado";		
	}
    
    @RequestMapping("/eliminar/{id}")
	public String eliminarEmpleado(@PathVariable(name = "id") int id) {
		empleadoService.delete(id);
		return "redirect:/empleado/listado";
	}
    
    @PostMapping("/modificaEmpleado")
	public String actualizaEmpleado(EmpleadoDTO empleadoDTO) {		
    	empleadoService.registroEmpleado(empleadoDTO);
		return "redirect:/empleado/listado";		
	}
}
