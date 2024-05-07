package co.edu.usco.pw.parcial2.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.usco.pw.parcial2.model.Vehicle;
import co.edu.usco.pw.parcial2.service.IVehicleService;
import co.edu.usco.pw.parcial2.service.VehicleService;


@Controller
public class VehicleController {
	
	@Autowired
    private IVehicleService vehicleService;

    @GetMapping("/list-vehicles")
    public String showVehicles(ModelMap model) {
        List<Vehicle> vehicle = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicle);

        boolean isAdmin = isAdmin();
        model.addAttribute("isAdmin", isAdmin);

        String userRole = isAdmin ? "admin" : "user";
        model.addAttribute("userRole", userRole);

        return "list-vehicles";
    }
    
    private String getLoggedInUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }

    private boolean isAdmin() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            Collection<? extends GrantedAuthority> authorities = ((UserDetails) principal).getAuthorities();
            return authorities.stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));
        }

        return false;
    }

    @GetMapping("/add-vehicle")
    public String showAddVehiclePage(ModelMap model) {
        model.addAttribute("vehicle", new Vehicle());
        return "vehicle";
    }

    @PostMapping("/add-vehicle")
    public String  addVehicles(ModelMap model, @Valid Vehicle vehicle, BindingResult result) {

        if (result.hasErrors()) {
            return "vehicle";
        }

        vehicle.setPlaca(getLoggedInUserName(model));
        vehicleService.saveVehicle(vehicle);
        return "redirect:/list-vehicles";
    }

    @GetMapping("/delete-vehicle")
    public String deleteTodo(@RequestParam long id) {
        vehicleService.deleteVehicle(id);
        return "redirect:/list-vehicles";
    }

    @GetMapping("/update-vehicle")
    public String showUpdateTodoPage(@RequestParam long id, ModelMap model) {
        Vehicle vehicle = vehicleService.getVehicleById(id).get();
        model.addAttribute("vehicle", vehicle);
        return "vehicle";
    }

    @PostMapping("/update-vehicle")
    public String updateTodo(ModelMap model, @Valid Vehicle vehicle, BindingResult result) {

        if (result.hasErrors()) {
            return "vehicle";
        }

        vehicle.setPlaca(getLoggedInUserName(model));
        vehicleService.updateVehicle(vehicle);
        return "redirect:/list-vehicles";
    }
}
