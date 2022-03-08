package com.grs.onetoone.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="engine")
public class EngineDTO {
	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name="engine_id")
	private int id;
	private int capacity;
	@Column(name="no_of_cylinder")
	private int noOfCylinder;
	@Column(name="no_of_stroke")
	private int noOfStroke;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="v_id")
	private VehicleDTO vehicle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setNoOfCylinder(int noOfCylinder) {
		this.noOfCylinder = noOfCylinder;
	}

	public int getNoOfStroke() {
		return noOfStroke;
	}

	public void setNoOfStroke(int noOfStroke) {
		this.noOfStroke = noOfStroke;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public VehicleDTO getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleDTO vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "EngineDTO [id=" + id + ", capacity=" + capacity + ", noOfCylinder=" + noOfCylinder + ", noOfStroke="
				+ noOfStroke + ", vehicle=" + vehicle + "]";
	}
	
	
}
