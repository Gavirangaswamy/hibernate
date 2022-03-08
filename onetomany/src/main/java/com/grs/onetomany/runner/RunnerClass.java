package com.grs.onetomany.runner;

import com.grs.onetomany.dao.UserDAOImpl;
import com.grs.onetomany.dto.UserDTO;
import com.grs.onetomany.dto.VehicleDTO;

public class RunnerClass {

	public static void main(String[] args) {

		VehicleDTO dto = new VehicleDTO();
		dto.setVehicleType("Car");
		dto.setVehiclePrice(1785223);
		
		VehicleDTO dto2 = new VehicleDTO();
		dto2.setVehicleType("Bike");
		dto2.setVehiclePrice(185223);
		
		UserDTO userDTO= new UserDTO();
		userDTO.setUserName("GRS");
		userDTO.setUserCity("Tiptur");
		userDTO.getVehicles().add(dto);
		userDTO.getVehicles().add(dto2);
		
		dto.setUser(userDTO);
		dto2.setUser(userDTO);
		
		UserDAOImpl impl = new UserDAOImpl();
		impl.saveUser(userDTO);	
	
	}

}
