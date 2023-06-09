package pe.com.homecare.dtos;

import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class ClienteDTO implements Serializable {

	private int id;
	 
	private int dni;
	
    private String nombre;
	 
	private String apellido; 
	    
	private String direccion; 
	    
    private String numero; 
	
    private String correo;
   
    private String numeroTarjeta;
    
    private String ccvTarjeta ; 
    
    private String mesAnioExpiracion ; 
}