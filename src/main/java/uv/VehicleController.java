package uv;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	@Autowired
	private VehicleRepo vr;
	
	@PostMapping
	public Vehicle saveVehicle(@RequestBody Vehicle vehicle) {
		return vr.save(vehicle);
	}
	
	@GetMapping
	public List<Vehicle> getAllVehicles() {
		return vr.findAll();
	}
	
	@GetMapping("/{id}")
	public Vehicle getVehicle(@PathVariable("id") int id) {
		Optional<Vehicle> vehicle = vr.findById(id);
		return vehicle.orElse(null);
	}
	
	@PutMapping("/{id}")
	public Vehicle updateVehicle(@PathVariable("id") int id, @RequestBody Vehicle updateVehicle) {
		Optional<Vehicle> e = vr.findById(id);
		if(e.isPresent()) {
			Vehicle o = e.get();
		    o.setYear(updateVehicle.getYear());
		    o.setModel(updateVehicle.getModel());
		    o.setName(updateVehicle.getName());
			return vr.save(o);
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public String deleteVehicle(@PathVariable("id") int id) {
		if(vr.findById(id).isPresent()) {
			vr.deleteById(id);
			return "Vehicle Deleted";
		}
		return "No Such Vehicle";
	}
}

