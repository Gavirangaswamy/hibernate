package com.grs.airlines.dao;

import com.grs.airlines.dto.AirlinesDTO;

public interface AirlinesDAO {
	
	public void save(AirlinesDTO dto);
	
	public AirlinesDTO getByName(String name);
	
	public AirlinesDTO UpdateFleetSizeByName(int fleet,String name);
	
	public AirlinesDTO deleteByName(String name);
}
