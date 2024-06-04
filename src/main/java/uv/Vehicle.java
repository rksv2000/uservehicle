package uv;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int year;
	private String model,name;
	@ManyToOne
    @JoinColumn(name = "user_id")
	@JsonBackReference
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", year=" + year + ", model=" + model + ", name=" + name + "]";
	}
	
}
