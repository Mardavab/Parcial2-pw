package co.edu.usco.pw.parcial2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usco.pw.parcial2.model.Vehicle;


public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
	List<Vehicle> findByPlaca(Integer placa);
}