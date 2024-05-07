package co.edu.usco.pw.parcial2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usco.pw.parcial2.model.Vehicle;
import co.edu.usco.pw.parcial2.repository.VehicleRepository;

@Service
public class VehicleService implements IVehicleService{
	@Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> getVehicleByPlaca(Integer placa) {
        return vehicleRepository.findByPlaca(placa);
    }

    @Override
    public Optional<Vehicle>getVehicleById(long id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
    	vehicleRepository.save(vehicle);
    }

    @Override
    public void addVehicles( Integer placa, Integer hora_entrada, Integer hora_salida, String ubicacion, String status) {
    	Vehicle vehicle = new Vehicle(placa, hora_entrada, hora_salida, ubicacion, status);
        vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicle(long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        vehicle.ifPresent(vehicleRepository::delete);
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {
    	vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

	

	
	
}
