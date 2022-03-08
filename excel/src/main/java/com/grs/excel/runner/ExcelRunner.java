package com.grs.excel.runner;

import java.util.ArrayList;
import java.util.List;

import com.grs.excel.dao.ExcelDAOImpl;
import com.grs.excel.dto.ExcelDTO;

public class ExcelRunner {

	public static void main(String[] args) {

		List<ExcelDTO> dto = new ArrayList<>(); 
		ExcelDAOImpl daoImpl = new ExcelDAOImpl();

		daoImpl.mapMovieDetails(dto);
		
		daoImpl.saveMovieDetails(dto);

	}

}
