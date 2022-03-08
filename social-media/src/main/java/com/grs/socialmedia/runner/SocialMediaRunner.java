package com.grs.socialmedia.runner;

import java.util.List;

import com.grs.socialmedia.dao.SocialMediaDAOImpl;
import com.grs.socialmedia.dto.SocialMediaDTO;

public class SocialMediaRunner {

	public static void main(String[] args) {

		SocialMediaDTO dto = new SocialMediaDTO();
		dto.setId(3);
		dto.setName("wechat");
		dto.setRevenue(2.9f);
		dto.setVersion(2.1);
		dto.setRatings(1.5);
		
		//System.out.println("gitdesktop");
		
		SocialMediaDAOImpl impl = new SocialMediaDAOImpl();
		
		//impl.saveMedia(dto);
		
//		SocialMediaDTO sm1 = impl.getByRevenue(78.6f);
//		System.out.println(sm1);
//		
//		SocialMediaDTO sm2 = impl.getByName("snapchat");
//		System.out.println(sm2);
		
		//impl.getDetails(2);
		
		
		
//		List<String> appNames = impl.getAllAppNAme();
//		
//		for (String string : appNames) {
//			System.out.println(string);
//		}
//		
//		List<SocialMediaDTO> apps = impl.getAll();
//		
//		for (SocialMediaDTO socialMediaDTO : apps) {
//			System.out.println(socialMediaDTO);
//		}
		
//		int rowsAffected = impl.updateRatingByName("GRS", 10);
//		System.out.println(rowsAffected);
		
//		int rowsAffected = impl.deleteByrating(1.5);
//		System.out.println(rowsAffected);
		
		List<Object[]> appNameAndAppId = (List<Object[]>) impl.getAppNameAndRevenueByRatings(10);
		
		for (Object[] object : appNameAndAppId) {
			System.out.println(object[0]+"   "+object[1]);
		}
		
		
	}

}
