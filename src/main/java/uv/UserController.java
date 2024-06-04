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
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepo ur;
	
	@PostMapping
	public User saveUser(@RequestBody User user) {
		return ur.save(user);
	}
	
	@GetMapping
	public List<User> getAllUsers() {
		return ur.findAll();
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") int id) {
		Optional<User> user = ur.findById(id);
		return user.orElse(null);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable("id") int id, @RequestBody User updateuser) {
		Optional<User> euser = ur.findById(id);
		if(euser.isPresent()) {
			User ouser = euser.get();
			ouser.setFirstname(updateuser.getFirstname());
			ouser.setLastname(updateuser.getLastname());
			return ur.save(ouser);
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		if(ur.findById(id).isPresent()) {
			ur.deleteById(id);
			return "User Deleted";
		}
		return "No Such User";
	}
}
