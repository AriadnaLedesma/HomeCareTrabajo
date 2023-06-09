package pe.com.homecare.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.homecare.dtos.EmpleadoDTO;
import pe.com.homecare.entities.Empleado;
import pe.com.homecare.repositories.IEmpleadoRepository;
import pe.com.homecare.services.interfaces.IEmpleadoService;
import pe.com.homecare.utils.MHelpers;

@Service
public class EmpleadoImpl implements IEmpleadoService{

	@Autowired
	private IEmpleadoRepository empleadoRepo;
	
	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		empleadoRepo.deleteById(id);
	}
	
	
	@Override
	public List<EmpleadoDTO> listarEmpleado() {
		
		  List<EmpleadoDTO> dto = new ArrayList<>();

	      Iterable<Empleado> empleados = this.empleadoRepo.findAll();

	      for(Empleado empleado : empleados){
	    	  EmpleadoDTO empleadoDTO = MHelpers.modelMapper().map(empleado,EmpleadoDTO.class);
	        dto.add(empleadoDTO);
	      }
	      return dto;
		// TODO Auto-generated method stub
		
	}

	@Override	
	public Empleado registroEmpleado(EmpleadoDTO empleadoDTO) {
		// TODO Auto-generated method stub
		  Empleado empleado = MHelpers.modelMapper().map(empleadoDTO, Empleado.class);

//validar en repository		  
	     return empleadoRepo.save(empleado);
		//return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findById(int id) {
		// TODO Auto-generated method stub 
		return empleadoRepo.findById(id).orElse(null);
	}
}
