package com.grs.excel.dao;

import java.util.List;

import com.grs.excel.dto.ExcelDTO;

public interface ExcelDAO {
	
	public List<ExcelDTO> mapMovieDetails(List<ExcelDTO> list);
	public void saveMovieDetails(List<ExcelDTO> list);

}
