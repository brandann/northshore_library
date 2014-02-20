/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package northshore.library.two;

import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author brandan
 */
public class Searchable {
    Detail[] matches;
    Detail[] databaseArray;
    String[] array;
    Driver driver;
    Database database;
    
    public Searchable(String list) throws IOException
    {
        
        driver = new Driver();
        database = new Database();
        if (list.contains(","))
        {
            array = setArray(list);
            matches = new Search().SearchEverything(array, database.getDatabase(), driver.EXCLUSIVE);
        }
        else
        {
            list = list.toUpperCase();
            list = list.trim();
            matches = new Search().SearchEverything(list, database.getDatabase());
        } 
        
        if(matches.length > 0 && matches.length < driver.MAX_SEARCH_RESULTS){
            Random r = new Random();
            HtmlOut h = new HtmlOut(matches, r.nextLong() + ".html");
            matches = database.getDatabase();
        }
        else if(matches.length <= 0){
            driver.infoBox("No Matches Found, Please Revise Your Search Criteria", "No Matches");
        }
        else if(matches.length >= driver.MAX_SEARCH_RESULTS){
            driver.infoBox(matches.length + " Matches Found, Please Narrow Down Your Search Criteria To Under " + driver.MAX_SEARCH_RESULTS, "Too Many Matches");
        }
    }
    
    public String[] setArray(String list)
    {
        list = list.toUpperCase();
        String[] temp;
        if (list.contains(","))
        {
            temp = list.split(",");
            for (int i = 0; i < temp.length; i++)
            {
                temp[i] = temp[i].trim();
            }
        }
        else
        {
            temp = new String[0];
            temp[0] = list.trim();
        }
        return temp;
    }
}
