package com.grs.airlines.runner;

import com.grs.airlines.dao.AirlinesDAOImpl;
import com.grs.airlines.dto.AirlinesDTO;

public class AirlinesRunner {

	public static void main(String[] args) {
		AirlinesDTO dto1 = new AirlinesDTO();
		dto1.setName("Indigo");
		dto1.setNoOfEmployees(23711);
		dto1.setFleetSize(282);
		dto1.setRevenue(5000);
		dto1.setOwner("Rahul batia");
		
		AirlinesDTO dto2 = new AirlinesDTO();
		dto2.setName("AirIndia");
		dto2.setNoOfEmployees(9000);
		dto2.setFleetSize(123);
		dto2.setRevenue(4000);
		dto2.setOwner("TATA");
		System.out.println("git desktop");
		AirlinesDAOImpl daoImpl = new AirlinesDAOImpl();
		
		//daoImpl.save(dto1);
		//daoImpl.save(dto2);
		
		AirlinesDTO dto = daoImpl.getByName("Indigo");
		System.out.println(dto);
		
		AirlinesDTO airline = daoImpl.UpdateFleetSizeByName(5896,"Indigo");
		System.out.println(airline);
		
		//AirlinesDTO airline1 = daoImpl.deleteByName("Indigo");
		//System.out.println(airline);

	}

}
