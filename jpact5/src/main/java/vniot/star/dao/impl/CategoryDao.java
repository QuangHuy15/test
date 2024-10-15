package vniot.star.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import vniot.star.configs.JPAConfig;
import vniot.star.dao.ICategoryDao;
import vniot.star.entity.Category;

public class CategoryDao implements ICategoryDao {

	@Override
	public void insert(Category category) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
		    trans.begin();
		    
		    // Gọi phương thức để insert, update, delete
		    enma.persist(category);
		    
		    trans.commit();
		} catch (Exception e) {
		    e.printStackTrace();
		    trans.rollback();
		    throw e;
		} finally {
		    enma.close();
		}
	}
	
	@Override
	public void update(Category category) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
		    trans.begin();
		    
		    // Gọi phương thức để insert, update, delete
		    enma.merge(category);
		    
		    trans.commit();
		} catch (Exception e) {
		    e.printStackTrace();
		    trans.rollback();
		    throw e;
		} finally {
		    enma.close();
		}
	}
	
	@Override
	public void delete(int cateid) throws Exception {
	    EntityManager enma = JPAConfig.getEntityManager();
	    EntityTransaction trans = enma.getTransaction();
	    try {
	        trans.begin();
	        // Call method to insert, update, delete
	        Category category = enma.find(Category.class, cateid);
	        if (category != null) {
	            enma.remove(category);
	        } else {
	            throw new Exception("Không tìm thấy"); // "Category not found"
	        }
	        trans.commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	        trans.rollback();
	        throw e;
	    } finally {
	        enma.close();
	    }
	}

	
	@Override
	public Category findById(int cateid) {
	    EntityManager enma = JPAConfig.getEntityManager();
	    Category category = enma.find(Category.class, cateid);
	    return category;
	}

	@Override
	public List<Category> findAll() {
	    EntityManager enma = JPAConfig.getEntityManager();
	    TypedQuery<Category> query = enma.createNamedQuery("category.findAll", Category.class);
	    return query.getResultList();
	}

	@Override
	public List<Category> findByCategoryname(String catname) {
	    EntityManager enma = JPAConfig.getEntityManager();
	    String jpql = "SELECT c FROM Category c WHERE c.catename like :catname";
	    TypedQuery<Category> query = enma.createQuery(jpql, Category.class);
	    query.setParameter("catname", "%" + catname + "%");
	    return query.getResultList();
	}

	@Override
	public List<Category> findAll(int page, int pagesize) {
	    EntityManager enma = JPAConfig.getEntityManager();
	    TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
	    query.setFirstResult(page * pagesize);
	    query.setMaxResults(pagesize);
	    return query.getResultList();
	}

	@Override
	public int count() {
	    EntityManager enma = JPAConfig.getEntityManager();
	    String jpql = "SELECT count(c) FROM Category c";
	    Query query = enma.createQuery(jpql);
	    return ((Long) query.getSingleResult()).intValue();
	}

	public static void main(String[] args) {
		ICategoryDao cate = new CategoryDao();
		
		List<Category> list = cate.findAll();

		for (Category user : list) {
			System.out.println(user);
		}
	}
}
