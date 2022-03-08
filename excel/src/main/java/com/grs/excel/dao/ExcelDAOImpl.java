package com.grs.excel.dao;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.grs.excel.dto.ExcelDTO;

public class ExcelDAOImpl implements ExcelDAO {
	
	
	public List<ExcelDTO> mapMovieDetails(List<ExcelDTO> list) {
		Workbook workbook = null;
		Session session = null; 
		try {
			workbook = new XSSFWorkbook("./file/movies.xlsx");
			Sheet sheet = workbook.getSheet("movies_details");
			int rows = sheet.getLastRowNum();
			for(int r = 1;r<=rows;r++) {
				Row row = sheet.getRow(r);
				ExcelDTO dto = new ExcelDTO();
				int movieID = (int) row.getCell(0).getNumericCellValue();
				dto.setMovieId(movieID);
				int year = (int) row.getCell(1).getNumericCellValue();
				dto.setYear(year);
				String movieName = row.getCell(2).getStringCellValue();
				dto.setMovieName(movieName);
				String directorName = row.getCell(3).getStringCellValue();
				dto.setDirectorName(directorName);
				String lang = row.getCell(4).getStringCellValue();
				dto.setLanguage(lang);
				String platform = row.getCell(5).getStringCellValue();
				dto.setPlatform(platform);
				double budget = row.getCell(6).getNumericCellValue();
				dto.setBudget((long) budget);
				double collection = row.getCell(7).getNumericCellValue();
				dto.setCollection((long) collection);
				float rating = (float) row.getCell(8).getNumericCellValue();
				dto.setRating((int) rating);
				list.add(dto);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null)
					workbook.close();
				if (session!=null)
					session.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Data Mapped successfully");
		return list;
	}
	
	public void saveMovieDetails(List<ExcelDTO> dto) {
		Session session = null;
		try {
			Configuration configuration = new Configuration();
			configuration.configure();

			SessionFactory factory = configuration.buildSessionFactory();

			session = factory.openSession();

			Transaction transaction = session.beginTransaction();
			for(int i = 0;i<dto.size();i++) {
				session.save(dto.get(i));
			}
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("Data Saved successfully");
 	}

}