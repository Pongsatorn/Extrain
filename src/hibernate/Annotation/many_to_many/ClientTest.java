package hibernate.Annotation.many_to_many;

import hibernate.Annotation.many_to_many.dao.AddressDAO;
import hibernate.Annotation.many_to_many.dao.CustomerDAO;
import hibernate.Annotation.many_to_many.model.Address;
import hibernate.Annotation.many_to_many.model.Customer;
import hibernate.Annotation.util.HibernateUtil;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.Iterator;

public class ClientTest {
	final static Logger logger = Logger.getLogger(ClientTest.class);
	public static void main(String[] args) throws ParseException{
		Address addr1 = new Address("111", "Latphroa", "BKK", "10310");
		Customer cust1 = new Customer("JON", "SNOW", 30);
		cust1.getAddresses().add(new Address("222", "Pahonyothin", "BKK", "11111"));
		cust1.getAddresses().add(addr1);

		Customer cust2 = new Customer("ARYA", "STARK",20);
		cust2.getAddresses().add(new Address("333", "Rama6", "BKK", "22222"));
		cust2.getAddresses().add(addr1);
		try{
			HibernateUtil.beginTransaction();
			CustomerDAO custdao = new CustomerDAO();
			custdao.insert(cust1);
			custdao.insert(cust2);
			HibernateUtil.commitTransaction();
			System.out.println("DONE");

		}catch(Exception ex){

			System.out.println("ERROR");
			System.out.println(ex);
			HibernateUtil.rollbackTransaction();
		}finally{
			HibernateUtil.closeSession();
		}


		try	{
			HibernateUtil.beginTransaction();
			AddressDAO addrdao = new AddressDAO();
			Address addr = addrdao.findByPK(3);
			System.out.println("Addr: "+addr.getRoad());
			java.util.Iterator<Customer> custs = addr.getCustomer().iterator();

			while(custs.hasNext()){
				Customer cust = (Customer)custs.next();
				System.out.println("FirstName: "+cust.getFirstname());
			}

			//addrdao.delete(addr);
			HibernateUtil.commitTransaction();

		}catch(Exception ex){

			System.out.println("ERROR");
			System.out.println(ex);
			HibernateUtil.rollbackTransaction();

		}finally{

			HibernateUtil.closeSession();
		}


		try	{
			HibernateUtil.beginTransaction();
			CustomerDAO customerDAO = new CustomerDAO();
			Customer customer = customerDAO.findByPK(1);
//			customerDAO.delete(customer);
//


			//addrdao.delete(addr);
			HibernateUtil.commitTransaction();

		}catch(Exception ex){

			System.out.println("ERROR");
			System.out.println(ex);
			HibernateUtil.rollbackTransaction();

		}finally{

			HibernateUtil.closeSession();
		}




	}


}
