package za.co.multiply.shoppe.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "name", nullable = false)
    private String name;
	
	@Column(name = "points", nullable = false)
    private double points;

	public Customer() {
		super();
	}

	public Customer(String name, double points) {
		super();
		setName(name);
		setPoints(points);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}
	
}
