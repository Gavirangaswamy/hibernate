package com.grs.socialmedia.dao;

import java.util.List;

import com.grs.socialmedia.dto.SocialMediaDTO;

public interface SocialMediaDAO {
	
	void saveMedia(SocialMediaDTO dto);
	
	SocialMediaDTO getByRevenue(float revenue);
	
	SocialMediaDTO getByName(String name);

	void getDetails(int id);

	List<SocialMediaDTO> getAll();

	List<String> getAllAppNAme();

	int updateRatingByName(String name, double rating);

	int deleteByrating(double rating);

	List<SocialMediaDTO> getAppNameAndAppId();

	List<?> getAppNameAndRevenueByRatings(double rating);

}
