package co.edu.usco.pw.parcial2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.edu.usco.pw.parcial2.model.Vehicle;
import co.edu.usco.pw.parcial2.service.IVehicleService;


@Controller
public class UserController {
	@Autowired
	private IVehicleService vehicleService;
	
	 private String getLoggedInUserName() {
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        if (principal instanceof UserDetails) {
	            return ((UserDetails) principal).getUsername();
	        }
	        return principal.toString();
	    }

	@GetMapping("/user/vehicles")
	public String listUserTodos(Model model) {
	    String username = getLoggedInUserName();
	    List<Vehicle> vehicles = vehicleService.getVehicleByPlaca(username);
	    model.addAttribute("vehicles", vehicles);
	    return "user-vehicle"; 
	}

	@GetMapping("/user/todo/{id}")
	public String viewUserTodo(@PathVariable Long id, Model model) {
	    Optional<Vehicle> vehicle = vehicleService.getVehicleById(id);
	    model.addAttribute("todo", vehicle.orElse(new Vehicle()));
	    return "user-vehicle-view"; 	}
}
