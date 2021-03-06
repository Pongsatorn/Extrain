package hibernate.Annotation.many_to_many.dao;

import hibernate.Annotation.many_to_many.model.Customer;
import hibernate.Annotation.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.List;


public class CustomerDAO {

	
	public void insert(Customer customer) throws Exception {
	     try{
	    	 Session session = HibernateUtil.getSession();
	    	 session.save(customer);
	    	
	     }catch(Exception ex){	   
	    	 throw ex;
	     }
	 }
	
	 public void delete(Customer customer) throws Exception {
	     try{
	    	 Session session = HibernateUtil.getSession();
	    	 session.delete(customer);
	    	
	     }catch(Exception ex){
	    	 throw ex;
	     }
	 }
	 
	 public void update(Customer customer) throws Exception {
	     try{
	    	 Session session = HibernateUtil.getSession();
	    	 session.update(customer);
	    	
	     }catch(Exception ex){
	    	 throw ex;
	     }
	 }
	 
	 public Customer findByPK(long customerId)throws Exception {
		 
		 Customer customer = null;
		 try{
	    	 Session session = HibernateUtil.getSession();
	    	 customer = (Customer)session.get(Customer.class, customerId);
	    	
	     }catch(Exception ex){
	    	 throw ex;
	     }
	     return customer;
	 }
	 


	 public List<Customer> findByName(String name) throws Exception {
		 
		 List<Customer> list = null;
		 try{
			 
	    	 Session session = HibernateUtil.getSession();
	    	 org.hibernate.Query q = session.createQuery("from customer cust where cust.firstname = :firstname");
	    	 q.setString("firstname",name);
	    	 list = toList(q.list());
	    	
	     }catch(Exception ex){
	    	 throw ex;
	     }
	     return list;
	 }
	 
	 public List<Customer> findAll() throws Exception {
		 
		 List<Customer> list = null;
		 try{
			 
	    	 Session session = HibernateUtil.getSession();
	    	 Criteria crit = session.createCriteria(Customer.class);
	    	 list = toList(crit.list());
	    	
	     }catch(Exception ex){
	    	 throw ex;
	     }
	     return list;
	 }
	 
	 public static List<Customer> toList(final List<?> beans){

	    if ( beans == null )  return null;
	    if ( beans.isEmpty())  return null;
	    int size = beans.size();
	    Customer[] list = new Customer[size];
	    list = (Customer[]) beans.toArray(list);
	    return Arrays.asList(list);
	  
	  }
}

