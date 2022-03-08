package com.grs.airlines.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="airline_details")
public class AirlinesDTO {
	
	private int fid;
	@Id
	private String name;
	@Column(name="owner")
	private String Owner;
	@Column(name="no_of_employees")
	private int noOfEmployees;
	private int revenue;
	@Column(name="fleet_size")
	private int fleetSize;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner() {
		return Owner;
	}
	public void setOwner(String owner) {
		Owner = owner;
	}
	public int getNoOfEmployees() {
		return noOfEmployees;
	}
	public void setNoOfEmployees(int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}
	public int getRevenue() {
		return revenue;
	}
	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	public int getFleetSize() {
		return fleetSize;
	}
	public void setFleetSize(int fleetSize) {
		this.fleetSize = fleetSize;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+"[name=" + name + ", Owner=" + Owner + ", noOfEmployees=" + noOfEmployees
				+ ", revenue=" + revenue + ", fleetSize=" + fleetSize + "]";
	}
}
