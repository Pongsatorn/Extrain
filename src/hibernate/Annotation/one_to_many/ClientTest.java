package hibernate.Annotation.one_to_many;

import hibernate.Annotation.one_to_many.dao.AddressDAO;
import hibernate.Annotation.one_to_many.dao.CustomerDAO;
import hibernate.Annotation.one_to_many.model.Address;
import hibernate.Annotation.one_to_many.model.Customer;
import hibernate.Annotation.util.HibernateUtil;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

public class ClientTest {
	final static Logger logger = Logger.getLogger(ClientTest.class);
	public static void main(String[] args) throws ParseException{
		ClientTest test = new ClientTest();
		Customer cust1 = new Customer("JON", "SNOW", 30);
		cust1.getAddresses().add(new Address("111", "Latphroa", "BKK", "10310"));
		cust1.getAddresses().add(new Address("222", "Pahonyothin", "BKK", "11111"));
		try{
			HibernateUtil.beginTransaction();
			CustomerDAO custdao = new CustomerDAO();

			custdao.insert(cust1);

			HibernateUtil.commitTransaction();
			System.out.println("DONE");
		}catch(Exception ex){
			System.out.println("ERROR");
			System.out.println(ex);
			HibernateUtil.rollbackTransaction();
		}finally{
			HibernateUtil.closeSession();
		}

		try{
			HibernateUtil.beginTransaction();
			AddressDAO addrdao = new AddressDAO();

			Address addr = addrdao.findByPK(1);
			System.out.println("First Name: "+ addr.getCustomer().getFirstname());

			CustomerDAO custdao = new CustomerDAO();
			Customer cust = custdao.findByPK(1);

			java.util.Iterator<Address> addresses = cust.getAddresses().iterator();

			while(addresses.hasNext()){
				Address addrtemp = (Address)addresses.next();
				System.out.println("Address Road: "+addrtemp.getRoad());
			}
			//test delete
			custdao.delete(cust);
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
