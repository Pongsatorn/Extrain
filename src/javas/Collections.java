package javas;

import org.apache.log4j.Logger;
import java.util.*;

public class Collections {
    private final static Logger logger = Logger.getLogger(Collections.class);
    public static void main(String[] args) {
        list();
        set();
        map();

    }

    private static void list(){
        List<String> list = new ArrayList<>();

        list.add("c");
        list.add("a");
        list.add("b");
        list.add("b");
        logger.info("---List---");
        logger.debug(list);



    }
    private static void set(){
        Set<String> set = new HashSet<>();
        set.add("c");
        set.add("a");
        set.add("b");
        set.add("b");
        logger.info("---Set---");
        logger.debug(set);


    }
    private static void map(){
        System.out.println("---Map---");
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "Jan");
        map.put("2", "Feb");
        map.put("3", "Mar");
        map.put("4", "Apr");
        map.put("5", "May");
        map.put("6", "Jun");

        System.out.println(map);




//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            logger.debug("Key : " + entry.getKey() + " Value : " + entry.getValue());
//        }



    }
}
