package co.edu.usco.pw.parcial2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private Integer placa;
    private Integer hora_entrada;
    private Integer hora_salida;
    private String ubicacion;
    private String status;
    
	public Vehicle() {
		super();
	}

	public Vehicle( Integer placa, Integer hora_entrada, Integer hora_salida, String ubicacion,
			String status) {
		
		
		this.placa = placa;
		this.hora_entrada = hora_entrada;
		this.hora_salida = hora_salida;
		this.ubicacion = ubicacion;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public Integer getPlaca() {
		return placa;
	}

	public void setPlaca(Integer placa) {
		this.placa = placa;
	}

	public Integer getHora_entrada() {
		return hora_entrada;
	}

	public void setHora_entrada(Integer hora_entrada) {
		this.hora_entrada = hora_entrada;
	}

	public Integer getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(Integer hora_salida) {
		this.hora_salida = hora_salida;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    
}
