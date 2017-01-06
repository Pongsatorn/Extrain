package hibernate.hql;

import hibernate.Annotation.util.HibernateUtil;
import hibernate.criteria.dao.CustomerDAO;
import hibernate.criteria.model.Address;
import hibernate.criteria.model.Customer;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;


public class ClientTest {
    final static Logger logger = Logger.getLogger(ClientTest.class);
    public static void main(String[] args) throws ParseException {
        logger.info("HQL!!!");
        hibernate.criteria.ClientTest clientTest = new hibernate.criteria.ClientTest();
        clientTest.addCustomer();

        hql_insert();
        hql_update();

        hql_query();

        hql_subquery();

    }
    public static void hql_query(){
        logger.info("Query...");
        Session session = HibernateUtil.getSession();
        String hql = "select cust.firstname,cust.lastname " +
                "from Customer cust ";
        Query q = session.createQuery(hql);
        List<Object[]> list = q.list();
        for (Object[] arr : list){
            logger.info(Arrays.toString(arr));
        }
    }

    public static void hql_insert(){
        logger.info("Insert...");
        Session session = HibernateUtil.getSession();
        String hql = "insert into Customer(firstname,lastname,age) select firstname,lastname,age from Employee ";
        Query q = session.createQuery(hql);
        int result = q.executeUpdate();
        logger.info("Rows affected: " + result);
    }

    public static void hql_update(){
        logger.info("Update...");
        Session session = HibernateUtil.getSession();
        String hql = "update Customer set firstname = 'test' where firstname='FirstName1'";
        Query q = session.createQuery(hql);
        int result = q.executeUpdate();
        logger.info("Rows affected: " + result);
    }

    public static void hql_delte(){
        Session session = HibernateUtil.getSession();
        String hql = "delete Customer where id=1";
        Query q = session.createQuery(hql);
        int result = q.executeUpdate();
        logger.info("Rows affected: " + result);
    }

    public static void hql_subquery(){
        logger.info("Subquery...");
        Session session = HibernateUtil.getSession();
        String hql = "select firstname,lastname from Customer " +
                     "where firstname in (select firstname from Employee)";
        Query q = session.createQuery(hql);
        List<Object[]> list = q.list();
        for (Object[] arr : list){
            logger.info(Arrays.toString(arr));
        }
    }


}
