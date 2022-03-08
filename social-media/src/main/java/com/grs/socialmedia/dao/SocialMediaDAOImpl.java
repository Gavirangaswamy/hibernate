package com.grs.socialmedia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.grs.socialmedia.dto.SocialMediaDTO;
import com.grs.socialmedia.util.HibernateUtil;

public class SocialMediaDAOImpl implements SocialMediaDAO {

	private EntityManagerFactory factory = HibernateUtil.getSessionFactory();

	@Override
	public void saveMedia(SocialMediaDTO dto) {
		EntityManager manager = null;

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(dto);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
	}

	@Override
	public SocialMediaDTO getByRevenue(float revenue) {
		EntityManager manager = null;
		SocialMediaDTO dto = null;

		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("fetchByRevenue");
			query.setParameter("rvn", revenue);

			dto = (SocialMediaDTO) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		return dto;
	}

	@Override
	public SocialMediaDTO getByName(String name) {
		EntityManager manager = null;
		SocialMediaDTO dto = null;

		try {
			manager = factory.createEntityManager();
			Query query = manager.createQuery("from SocialMediaDTO where name=:naam");
			query.setParameter("naam", name);

			dto = (SocialMediaDTO) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		return dto;
	}

	@Override
	public void getDetails(int id) {
		EntityManager manager = null;
		EntityManager manager1 = null;

		try {
			manager = factory.createEntityManager();
			manager1 = factory.createEntityManager();
			System.out.println(manager.find(SocialMediaDTO.class, id));
			System.out.println(manager1.find(SocialMediaDTO.class, id));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
				if (manager1 != null) {
					manager.close();
				}
			}
		}

	}

	@Override
	public List<SocialMediaDTO> getAll() {

		List<SocialMediaDTO> result = null;
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("fetchAll");
			result = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		return result;
	}

	@Override
	public List<String> getAllAppNAme() {
		List<String> result = null;
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("fetchAppName");
			result = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		return result;
	}

	@Override
	public int updateRatingByName(String name, double rating) {
		EntityManager manager = null;
		int rows = 0;
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Query query = manager.createNamedQuery("updateRatingByName");
			query.setParameter("rate", rating);
			query.setParameter("appName", name);
			rows = query.executeUpdate();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		return rows;
	}

	@Override
	public int deleteByrating(double rating) {
		EntityManager manager = null;
		int rows = 0;
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Query query = manager.createQuery("delete from SocialMediaDTO where ratings =:rating");
			query.setParameter("rating", rating);
			rows = query.executeUpdate();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		return rows;
	}


	@Override
	public List getAppNameAndAppId() {
		List list = null;
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			Query query = manager.createQuery("select id,name from SocialMediaDTO");
			 list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		return list;
	}
	
	@Override
	public List<?> getAppNameAndRevenueByRatings(double rating) {
		List<?> list = null;
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			Query query = manager.createQuery("select name,revenue from SocialMediaDTO where ratings=:rating");
			query.setParameter("rating", rating);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		return list;
	}
	
	
}
