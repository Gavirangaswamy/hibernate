package com.grs.onetomany.dto;

import lombok.Data;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name="vehicle")
public class VehicleDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="v_id")
	private int vehicleID;
	@Column(name="v_type")
	private String vehicleType;
	@Column(name="v_price")
	private int vehiclePrice;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private UserDTO user;

	
	
}
