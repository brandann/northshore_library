/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package northshore.library.two;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author brandan
 */
public class HtmlOut {
    
    public HtmlOut(Detail[] myArray, String name)
    {
        driver = new Driver();
        myFile = name;
        myOutputArray = myArray; 
        print();
    }
    
    private void print()
    {
        try
        {
            fileOutput = new PrintWriter(new FileOutputStream(myFile));
            fileOutput.println(header());
            for(Detail e : myOutputArray){
                fileOutput.println(item(String.valueOf(e.getEntry()), e.getDetailDescription(), e.getJPG(), e.getPDF(), e.getDWG()));
            }
            fileOutput.println(tail());
            fileOutput.close( );
            
            try
            {
                //Executes a file
                Desktop d = Desktop.getDesktop();
                d.open(new File(myFile));
            }
            catch(Exception e)
                {}
        }
        catch(IOException e){}
    }
    
    private String header(){
        return "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n" +
"<html>\n" +
"	<head>\n" +
"		<meta charset=ISO-8859-1\" http-equiv=\"Content-Type\">\n" +
"		<title>Library Search Results</title>\n" +
"		<meta content=\"Brandan Haertel\" name=\"author\">\n" +
"	</head>\n" +
"	<body \n" +
"		alink=\"#EE0000\" \n" +
"		bgcolor=\"#C6C6C6\" \n" +
"		link=\"#0000EE\" \n" +
"		text=\"#000000\" \n" +
"		vlink=\"#551A8B\" \n" +
"		background=\"stripe.png\"\n" +
"		>\n" +
"		<div align=\"center\">\n" +
"		<b><font size=\"24\" color=\""+ driver.colorString +"\">Northshore Library Search Results</font></b><br>\n" +
"		<br>";
    }
    
    private String tail(){
        return "<br>\n" +
"			<font color=\"#666666\">brandan@northshoresheetmetal.com</font><br>\n" +
"		</div>\n" +
"	</body>\n" +
"</html>";
    }
    
    private String item(String entry, String title, String jpg, String pdf, String dwg){
        return "<b><font size=\"6\" color=\"#000000\">" + title + "</font></b><br>\n" +
"		<br>\n" +
"			<img src=\"" + jpg + "\" border=\"2\" style=\"border:2px solid black;max-width:30%;\"/>\n" +
"			<br>\n" +
"			<a href=\"" + pdf + "\"> <font size=\"24\" color=\""+ driver.colorString +"\">PDF</font></a>\n" +
"			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
"			<a href=\"" + dwg + "\"> <font size=\"24\" color=\""+ driver.colorString +"\">AutoCad</font></a>\n" +
"			<br>\n" +
"			<font color=\"#666666\">Click PDF or Autocad to download detail.        [" + entry + "] </font><br>\n" +
"			<hr size=\"3\" width=\"60%\">";
        
    }
    
    private Driver driver;
    private PrintWriter fileOutput;
    private String myFile;
    private Detail[] myOutputArray;
}
