package co.edu.usco.pw.parcial2.service;

import java.util.List;
import java.util.Optional;

import co.edu.usco.pw.parcial2.model.Vehicle;


public interface IVehicleService {

	List<Vehicle> getVehicleByPlaca(Integer placa);

    Optional<Vehicle> getVehicleById(long id);

    void updateVehicle(Vehicle vehicle);

    void deleteVehicle(long id);

    void saveVehicle(Vehicle vehicle);

    List<Vehicle> getVehicles();

    void addVehicles( Integer placa, Integer hora_entrada, Integer hora_salida, String ubicacion, String status);
}