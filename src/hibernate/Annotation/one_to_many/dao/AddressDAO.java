package hibernate.Annotation.one_to_many.dao;

import hibernate.Annotation.one_to_many.model.Address;
import hibernate.Annotation.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Arrays;
import java.util.List;

public class AddressDAO{
	
	public void insert(Address addr) throws Exception {
	     try{
	    	 Session session = HibernateUtil.getSession();
	    	 session.save(addr);
	    	
	     }catch(Exception ex){	   
	    	 throw ex;
	     }
	 }
	
	public void delete(Address addr) throws Exception {
	     try{
	    	 Session session = HibernateUtil.getSession();
	    	 session.delete(addr);
	    	
	     }catch(Exception ex){
	    	 throw ex;
	     }
	 }
	
	public void update(Address addr) throws Exception {
	     try{
	    	 Session session = HibernateUtil.getSession();
	    	 session.update(addr);
	    	
	     }catch(Exception ex){
	    	 throw ex;
	     }
	 }
	 
	 public Address findByPK(long addrId)throws Exception {
		 
	 Address address = null;
		 try{
	    	 Session session = HibernateUtil.getSession();
	    	 address = (Address)session.get(Address.class, addrId);
	    	
	     }catch(Exception ex){
	    	 throw ex;
	     }
	     return address;
	 }
 
	 public List<Address> findByCustNam(String name) throws Exception{
		 
		 List<Address> list = null;
		 try{			 
			 Session session = HibernateUtil.getSession();
			 Criteria crit = session.createCriteria(Address.class);
			 Criteria custCrit = crit.createCriteria("customer");
			 custCrit.add(Restrictions.eq("firstname",name));			 
			 if((!crit.list().isEmpty())){
				 list = toList(crit.list());
			 }
	     }catch(Exception ex){
	    	 throw ex;
	     }		
	     return list;
	 }
	 
	 public List<Address> findByCustId(long id) throws Exception{
		 
		 List<Address> list = null;
		 try{
			 
			 Session session = HibernateUtil.getSession();
			 Criteria crit = session.createCriteria(Address.class);
			 Criteria usrCrit = crit.createCriteria("customer");
			 usrCrit.add(Restrictions.eq("id",id));
			 if((!crit.list().isEmpty())){
				 list = toList(crit.list());
			 }
			 
	     }catch(Exception ex){
	    	 throw ex;
	     }
	     return list;		 
	 }
	public List<Address> findAll() throws Exception {

		List<Address> list = null;
		try{

			Session session = HibernateUtil.getSession();
			Criteria crit = session.createCriteria(Address.class);
			list = toList(crit.list());

		}catch(Exception ex){
			throw ex;
		}
		return list;
	}
	 
	 public static List<Address> toList(final List<?> beans){
		 
	   if ( beans == null )  return null;
	   if ( beans.isEmpty())  return null;
	   int size = beans.size();
	   Address[] list = new Address[size];
	   list = (Address[]) beans.toArray(list);
	   return Arrays.asList(list);
	 }

}
