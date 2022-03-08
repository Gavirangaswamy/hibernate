package com.grs.onetoone.runner;

import com.grs.onetoone.dao.EngineDAOImpl;
import com.grs.onetoone.dto.EngineDTO;
import com.grs.onetoone.dto.VehicleDTO;

public class RunnerClass {

	public static void main(String[] args) {

		VehicleDTO dto = new VehicleDTO();
		dto.setCompany("GRS");
		dto.setModel("Luna");
		dto.setPrice(755000);
		
		
		EngineDTO engineDTO = new EngineDTO();
		engineDTO.setNoOfCylinder(2);
		engineDTO.setNoOfStroke(2);
		engineDTO.setCapacity(350);
		
		engineDTO.setVehicle(dto);
		
		EngineDAOImpl impl = new EngineDAOImpl();
		impl.saveEngine(engineDTO);
	
	}

}
