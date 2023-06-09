package pe.com.homecare.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name="clientes")

public class Cliente {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
	@Column(name = "dni")
    private String dni;
    
	@Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido")
    private String apellido; 
    
    @Column(name = "direccion")
    private String direccion; 
    
    @Column(name = "numero")
    private String numero; 
    
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "numerotarjeta")
    private String numeroTarjeta;
    
    @Column(name = "ccvtarjeta")
    private String ccvTarjeta;
    
    @Column(name = "mesanioexpiracion")
    private String mesAnioExpiracion; 
}
