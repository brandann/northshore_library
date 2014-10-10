/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarysearch;

import Detail.Detail;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class HtmlOut
{
  private PrintWriter fileOutput;
  private String myFile;
  private Detail[] myOutputArray;
  
  public HtmlOut(Detail[] myArray, String name)
  {
    this.myFile = name;
    this.myOutputArray = myArray;
    print();
  }
  
  private void print()
  {
    try
    {
      this.fileOutput = new PrintWriter(new FileOutputStream(this.myFile));
      
      // print header
      this.fileOutput.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 "
              + "Transitional//EN\">\n<html>\n\t<head>\n\t\t<meta "
              + "charset=ISO-8859-1\" http-equiv=\"Content-Type\">\n\t\t<title>Library "
              + "Search Results</title>\n\t\t<meta content=\"Brandan Haertel\" "
              + "name=\"author\">\n\t</head>\n\t<body \n\t\talink=\"#EE0000\" "
              + "\n\t\tbgcolor=\"#C6C6C6\" \n\t\tlink=\"#0000EE\" "
              + "\n\t\ttext=\"#000000\" \n\t\tvlink=\"#551A8B\" "
              + "\n\t\tbackground=\"stripe.png\"\n\t\t>\n\t\t<div "
              + "align=\"center\">\n\t\t<b><font size=\"24\" color=\""
              + "#495ED" 
              + "\">Northshore Library Search Results</font></b><br>\n" 
              + "\t\t<br>");
      
      // print items
      for (Detail e : this.myOutputArray) {
        this.fileOutput.println(item(String.valueOf(e.getEntry()), 
                                    e.getDetailDescription(), 
                                    e.getJPG(), 
                                    e.getPDF(), 
                                    e.getDWG()
        ));
      }
      
      // print tail
      this.fileOutput.println("<br>\n\t\t\t<font "
              + "color=\"#666666\">brandan@northshoresheetmetal.com</font><br>"
              + "\n\t\t</div>\n\t</body>\n</html>");
      
      this.fileOutput.close();
      try
      {
        Desktop d = Desktop.getDesktop();
        d.open(new File(this.myFile));
      }
      catch (Exception e) {}
    }
    catch (IOException e) {}
  }
  
  private String item(String entry, String title, String jpg, String pdf, String dwg)
  {
    return "<b><font size=\"6\" color=\"#000000\">" 
            + title 
            + "</font></b><br>\n" + "\t\t<br>\n" + "\t\t\t<img src=\"..\\" 
            + jpg 
            + "\" border=\"2\" style=\"border:2px solid black;max-width:30%;\"/>\n" + "\t\t\t<br>\n" + "\t\t\t<a href=\"..\\" 
            + pdf 
            + "\"> <font size=\"24\" color=\"" + "#495ED" + "\">PDF</font></a>\n" + "\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" + "\t\t\t<a href=\"..\\" 
            + dwg 
            + "\"> <font size=\"24\" color=\"" + "#495ED" + "\">AutoCad</font></a>\n" + "\t\t\t<br>\n" + "\t\t\t<font color=\"#666666\">Click PDF or Autocad to download detail.        [" 
            + entry 
            + "] </font><br>\n" + "\t\t\t<hr size=\"3\" width=\"60%\">";
  }
}
