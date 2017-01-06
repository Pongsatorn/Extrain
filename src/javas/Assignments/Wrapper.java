package javas.Assignments;

public class Wrapper {
    /*  Primitive Data Type   Wrapper Class
     1   byte	                Byte
     2   short	                Short
     3   int	                Integer
     4   long	                Long
     5   float	                Float
     6   double	                Double
     7   char	                Character
     8   boolean	            Boolean
    * */
    public static void main(String[] args) {

        Integer intObject = new Integer ( "33");
        System.out.println(intObject);
        Double douObject =new Double("33");
//
//        int x = intObject.intValue();
//        System.out.println(x);


    }
    /*
    Boxing	        int x = 5;
                    Integer y = new Integer(x);

    Unboxing	    Integer x = new Integer("5");
                    int y = x.intValue();

    Autoboxing	    int x = 5;
                    Integer y = x;

    Autounboxing	Integer x = new Integer("5");
                    int y = x;
    * */
}
