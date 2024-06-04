package uv;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstname,lastname;
	@OneToMany
	@JoinColumn(name="vehicle_id")
	private Set<Vehicle> vehicles;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Set<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", vehicles=" + vehicles
				+ "]";
	}
	
}
