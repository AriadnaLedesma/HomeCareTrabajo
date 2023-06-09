package pe.com.homecare.dtos;

import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class EmpleadoDTO implements Serializable {

	private int id;
	 
	private String dni;
	
    private String nombre;
	 
	private String apellido; 
	    
	private String direccion; 
	    
    private String numero; 
	
    private String correo;

}
