package com.grs.onetomany.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class UserDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="u_id")
	private int userID;
	@Column(name="u_name")
	private String userName;
	@Column(name="u_city")
	private String userCity;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<VehicleDTO> vehicles = new ArrayList<VehicleDTO>();


}
