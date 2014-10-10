/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarysearch;

import java.io.FileNotFoundException;

/**
 *
 * @author brandan
 */
public class LibrarySearch {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        System.out.println("Arg[0]: " + args[0]);
        System.out.println("Arg[1]: " + args[1]);
        if(null != args[0])switch (args[0]) {
            case "a":
                SimpleSearch ss = new SimpleSearch();
                ss.search(args[1]);
                break;
            case "b":
                Search s = new Search();
                s.search(args[1]);
                break;
        }
        
        System.out.println("done");
    }
    
}
