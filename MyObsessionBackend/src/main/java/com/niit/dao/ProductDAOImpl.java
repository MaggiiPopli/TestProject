package com.niit.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;



@Repository
public class ProductDAOImpl implements ProductDAO{
	
	
	private static Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);
  
	@Autowired
	SessionFactory sessionFactory; 
	
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		
	} 
	
	/*public Session getSession()
	{
		return sessionFactory.openSession();
		
	}*/

	public List<Product> viewProduct() {
		// TODO Auto-generated method stub
		log.debug("starting of method viewproduct");

		Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		String hql="from Product";
		System.out.println("After from product");
	  Query q=sess.createQuery(hql);
		
		List<Product> l=q.list();
		System.out.println("LIST PRODUCT"+l);
		log.debug("ending of method viewproduct");

		return l;
	
	}
	
	
	public List<Product> viewProductByCategory(String category_name) {
		// TODO Auto-generated method stub
		Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		String hql="from Product where category_name=:category_name";
		System.out.println("After from product");
	  Query q=sess.createQuery(hql);
	  q.setParameter("category_name", category_name);
		
		List<Product> l=q.list();
		System.out.println("LIST PRODUCT"+l);
		
		return l;
	
	}

	public boolean saveProduct(Product p) {
		// TODO Auto-generated method stub
		try{
		Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		sess.save(p);
		tx.commit();
		//sess.close();
		return true;
		}
		catch(Exception ex)
		{
			System.out.println("Exception"+ex);
			return false;
		}
		
	}

	public void editProduct(String product_id) {
		// TODO Auto-generated method stub
		Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		Product p=(Product) sess.get(Product.class, product_id);
		sess.update(p);
		tx.commit();
		sess.close();
	}

	public boolean deleteProduct(String product_id) {
		// TODO Auto-generated method stub
		try{
		Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		Product p=(Product) sess.get(Product.class, product_id);
		sess.delete(p);
		tx.commit();
		sess.close();
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occurred"+e);
			return false;
		}
	}

	public Product getProductById(String product_id) {
		// TODO Auto-generated method stub
		Session sess=sessionFactory.openSession();
		Product p=(Product)sess.get(Product.class, product_id);
		System.out.println("get id by product"+p);
		return p;
	}

	public boolean updateProduct(Product p) {
		// TODO Auto-generated method stub
		
		try{
		Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		sess.update(p);
		tx.commit();
		sess.close();
		return true;
		}
		
		catch(Exception ex)
		{
			System.out.println("Exception occurred"+ex);
			return false;
		}
		
	}

	public List<Category> getCategoryname() {
		// TODO Auto-generated method stub
		Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		String hql="select category_name from Category";
	  Query q=sess.createQuery(hql);
		
		List<Category> l=q.list();
		
		return l;
	}

	public List<Supplier> getSuppliername() {
		// TODO Auto-generated method stub
		Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		String hql="select supplier_name from Supplier";
	  Query q=sess.createQuery(hql);
		
		List<Supplier> l=q.list();
	
		return l;
	}

 }
