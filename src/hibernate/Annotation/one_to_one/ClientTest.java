package hibernate.Annotation.one_to_one;

import java.text.ParseException;
import hibernate.Annotation.one_to_one.dao.CustomerDAO;
import hibernate.Annotation.one_to_one.model.Customer;
import hibernate.Annotation.one_to_one.dao.AddressDAO;
import hibernate.Annotation.one_to_one.model.Address;
import hibernate.Annotation.util.HibernateUtil;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

public class ClientTest {
	final static Logger logger = Logger.getLogger(ClientTest.class);
	public static void main(String[] args) throws ParseException{
		ClientTest test = new ClientTest();
		test.insertCustomer();
		test.displayCustomer();

	}

	public void insertCustomer(){
		Customer cust1 = new Customer("JON", "SNOW", 30);
		Customer cust2 = new Customer("ARYA", "STARK",20 );
		cust1.setAddress(new Address("111", "Latphroa", "BKK", "10310"));
		cust2.setAddress(new Address("222", "Pahonyothin", "BKK", "11111"));

		try{
			HibernateUtil.beginTransaction();
			CustomerDAO custdao = new CustomerDAO();
			custdao.insert(cust1);
			custdao.insert(cust2);
			HibernateUtil.commitTransaction();
		}catch(Exception ex){
			HibernateUtil.rollbackTransaction();
		}
		finally{

			HibernateUtil.closeSession();
		}
	}


	public void displayCustomer(){
		try{
			HibernateUtil.beginTransaction();
			logger.debug("-------Table: Customer-------");
			CustomerDAO customerdao = new CustomerDAO();
			AddressDAO addressDAO = new AddressDAO();
			List <Customer> customerlist = customerdao.findAll();

			if(customerlist != null){
			 	Iterator<Customer> customeriter = customerlist.iterator();
				while(customeriter.hasNext()) {
					Customer customer = (Customer)customeriter.next();
					logger.info("CustomerId: "+ customer.getId()+ ", " +
						"CustomerName: "+customer.getFirstname()+
						" "+ customer.getLastname() +
						", Address: ");

					Address address = addressDAO.findByPK(customer.getAddress().getId());
					logger.info(address.getHomeno()+" " +
									"Road: "+ address.getRoad()+ " "+
									"Province: "+ address.getProvince()+" "+
									"Zipcode: "+address.getZipcode());
				}
			}else{
				logger.info("There is no data in Customer Table");
			}
			HibernateUtil.commitTransaction();
		 }catch(Exception ex){
			 ex.printStackTrace();
			 HibernateUtil.rollbackTransaction();
			logger.error("Can not display Data");
		 }finally {
			HibernateUtil.closeSession();
		 }
	}



	//use bidirection


//	public void findCustomer_ByAddrPK_eq_2(){
//		AddressDAO addrdao = new AddressDAO();
//		try{
//			HibernateUtil.beginTransaction();
//			Address addr = addrdao.findByPK(2);
//			logger.info(addr.getCustomer().getFirstname());
//			HibernateUtil.commitTransaction();
//
//		}catch(Exception ex){
//			HibernateUtil.rollbackTransaction();
//
//		}finally{
//
//			HibernateUtil.closeSession();
//		}
//	}

}
