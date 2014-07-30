/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Detail;

/**
 *
 * @author brandan
 */
public class Test {
    public Test()
    {
        constructor();
        constructorA();
    }
    
    public void constructor()
    {
        Detail d = new Detail();
        String str = d.toString();
        if (str.equals("-1$$$$$$$$$$"))
            return;
        System.out.println("TEST FAILED: CONSTRUCTOR");
        System.out.println("\tCONSTRUCTOR: EXPECTED: -1$$$$$$$$$$");
        System.out.println("\tCONSTRUCTOR: ACTUAL: " + str);
    }
    
    public void constructorA()
    {
        String make = "100$NORTHSHORE$FIRE STATION 12$5099$1$20131212$COPING TEST FILE$FILES/100.PDF$FILES/100.DWG$FILES/100.PNG$COPING>>TESTING";
        //String make = "100$Northshore$Fire Station 12$5099$1$20131212$Coping Test File$files/100.pdf$files/100.dwg$files/100.png$Coping>>Testing";
        Detail d = new Detail(make);
        String str = d.toString();
        if (str.equals(make))
            return;
        System.out.println("TEST FAILED: CONSTRUCTOR-A");
        System.out.println("\tCONSTRUCTOR: EXPECTED:\t" + make);
        System.out.println("\tCONSTRUCTOR: ACTUAL:\t" + str);
    }
}
