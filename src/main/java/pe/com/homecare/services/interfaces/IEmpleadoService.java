package pe.com.homecare.services.interfaces;

import java.util.List;

import pe.com.homecare.dtos.EmpleadoDTO;
import pe.com.homecare.entities.Empleado;


public interface IEmpleadoService {

	public void delete (int id) ;
	
	public List<EmpleadoDTO> listarEmpleado() ; 
	
	public Empleado registroEmpleado(EmpleadoDTO empleadoDTO);	

	public Empleado findById(int id);
	
}
