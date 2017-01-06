package hibernate.criteria;


import hibernate.criteria.dao.*;
import hibernate.criteria.model.*;
import hibernate.Annotation.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ClientTest {

	final static Logger logger = Logger.getLogger(ClientTest.class);
	public static void main(String[] args) throws ParseException {
		logger.info("Criteria!!!");
		ClientTest test = new ClientTest();
		test.addCustomer();
		critiria_query();




	}
	public static void critiria_query(){ //Criteria
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(Customer.class);
		logger.info(criteria.list());
		Iterator<Customer> cust = criteria.list().iterator();
		while (cust.hasNext()){
			Customer customer = (Customer)cust.next();
			logger.info("Customer : " + customer.getFirstname());
		}
	}



	public static void detachQuery(){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		Session session = HibernateUtil.getSession();
		List<Customer> results = detachedCriteria.getExecutableCriteria(session).list();
		for (Customer c : results){
			logger.info(c.getFirstname()+c.getLastname());
		}
	}
	public static void critiria_join(){ //Projections -> Join
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.createAlias("addresses","addr");
		criteria.add(Restrictions.eq("addr.road","Rama6"));
		Iterator<Customer> cust = criteria.list().iterator();
		while (cust.hasNext()){
			Customer customer = (Customer)cust.next();
			logger.info("Customer : " + customer.getFirstname());
		}
	}

	public static void critiria_function(){ //Projections
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(Customer.class);
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.avg("age"));
		projectionList.add(Projections.max("age"));
		projectionList.add(Projections.min("age"));
		criteria.setProjection(projectionList);

		List<Object[]> list = criteria.list();
		for (Object[] arr : list){
			logger.info(Arrays.toString(arr));
		}
	}

	public static void critiria_restriction(){ //Restrictions
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.ilike("firstname","%a%"));
		criteria.add(Restrictions.eq("age",20));
		logger.info(criteria.list());
		Iterator<Customer> cust = criteria.list().iterator();
		while (cust.hasNext()){
			Customer customer = (Customer)cust.next();
			logger.info("Customer : " + customer.getFirstname());
		}
	}


	public void addCustomer(){
		Customer customer1 = new Customer("JON","SNOW",30);
		customer1.getAddresses().add(new Address("111","Latphroa","BKK","10310"));
		customer1.getAddresses().add(new Address("222","Pahonyothin","BKK","11111"));
		Customer customer2 = new Customer("ARYA","STARK",20);
		customer2.getAddresses().add(new Address("333","Rama6","BKK","22222"));
		try{
			HibernateUtil.beginTransaction();
			CustomerDAO customerdao = new CustomerDAO();

			customerdao.insert(customer1);
			customerdao.insert(customer2);

			HibernateUtil.commitTransaction();

	 	 }catch(Exception ex){
	 		ex.printStackTrace ();
	 		HibernateUtil.rollbackTransaction();
	 		logger.error("Can not add records into customer tables");
	 	 }finally {
			HibernateUtil.closeSession();
		 }
	}
	public void deleteCustomer(){
		try{
			HibernateUtil.beginTransaction();
			CustomerDAO customerdao = new CustomerDAO();
			customerdao.delete(customerdao.findByPK(1));
			HibernateUtil.commitTransaction();

		}catch(Exception ex){
			ex.printStackTrace ();
			HibernateUtil.rollbackTransaction();
			logger.error("Can not add records into customer tables");
		}finally {
			HibernateUtil.closeSession();
		}
	}


}
