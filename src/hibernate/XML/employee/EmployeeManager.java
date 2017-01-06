package hibernate.XML.employee;

import java.util.Iterator;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import hibernate.XML.employee.util.HibernateUtil;

public class EmployeeManager {
    final static Logger logger =  Logger.getLogger(EmployeeManager.class);

    public void insert(Employee employee){
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
    }

    public void update(Employee employee){
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(employee);
        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
    }

    public void delete(Employee employee){
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(employee);
        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
    }

    public void query(){

        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Iterator iter = session.createQuery("select id,firstname,lastname,age from Employee").iterate();
        while(iter.hasNext()){
            Object[] tuple = (Object[]) iter.next();
            logger.info("Id " + tuple[0]);
            logger.info("Firstname " + tuple[1]);
            logger.info("Surname "+ tuple[2]);
            logger.info("Age "+tuple[3]);

        }
        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
    }
    public static void main(String[] args) {
        Employee user1 = new Employee();
        Employee user2 = new Employee();

        user1.setFirstname("FirstName1");
        user1.setLastname("SurName1");
        user1.setAge(10);


        user2.setFirstname("FirstName2");
        user2.setLastname("SurName2");
        user2.setAge(20);


        String strAction = "Insert Record";
		System.out.println("============" + strAction + "============");
        EmployeeManager mgr = new EmployeeManager();
        mgr.insert(user1);
        mgr.insert(user2);

//		strAction = "Query Record";
//		System.out.println("============" + strAction + "============");
//		mgr.query();
//
		strAction = "Update Record";
		System.out.println("============" + strAction + "============");
		user2.setFirstname("ChangedFirstName2");
		mgr.update(user2);
//
//        strAction = "Delete Record";
//        System.out.println("============" + strAction + "============");
//        mgr.delete(user1);

        strAction = "Query Record";
        System.out.println("============" + strAction + "============");
        mgr.query();



    }


}
