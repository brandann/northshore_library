/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package northshore.library.two;

import java.awt.Color;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static northshore.library.two.ManageLibrary.errorBox;

/**
 *
 * @author brandan
 */
public class Driver {
    public Driver(){

    }
    public String[] getSystemsArray(){
        return SystemsStringArray;
    }
    
    public boolean tagExist(String tag, String cat){
        return false;
    }
    
    public void createTag(String tag, String cat){
        PrintWriter fileOutput;
        String[] arrayIn = readTextFile(cat + ".txt", SORT);
        ArrayList<String> arrayOut = new ArrayList();
        for(String s : arrayIn){arrayOut.add(s);}
        arrayOut.add(tag);
        try{
            fileOutput = new PrintWriter(new FileOutputStream(
                    new File(cat + ".txt")));
            for(String s : arrayOut){fileOutput.println(s);}
            fileOutput.close();
        }
        catch(IOException e){
            System.out.println("Error: getEntry/write");
        }
    }
    
    public String[] readTextFile(String file, boolean sort){
        Scanner fileInputScanner;
        ArrayList<String> list = new ArrayList();
        String[] array;
        try{
            fileInputScanner = new Scanner(new File(file));
            while(fileInputScanner.hasNextLine()){
                String a = fileInputScanner.nextLine();
                list.add(a);
            }
            fileInputScanner.close();
        }
        catch(IOException e){
            System.out.println("Error: readTextFile");
        }
        if(sort){
            Collections.sort(list);
        }
            
        array = new String[list.size()];
        array = list.toArray(array);
        return array;
    }
    
    public String moveFile(String from, String to){
        File tempFile = new File(from);
        try{
            if(tempFile.renameTo(new File(to))){
                return to;
            }
            else{
                return "";
            }
        }
        catch(Exception e){e.printStackTrace();}
        return "";
    }

    
    
    public ArrayList<String> removeDuplicates(ArrayList<String> list){
        ArrayList<String> newList = new ArrayList<>();
        for(String list_string : list){
            if(!newList.contains(list_string)){
                newList.add(list_string);
            }
        }
        return newList;
    }
    
    public String getDate(){
        GregorianCalendar gCal = new GregorianCalendar();
        String y = String.valueOf(gCal.get(GregorianCalendar.YEAR));
        String m = String.valueOf((gCal.get(GregorianCalendar.MONTH) + 1));
        String d = String.valueOf(gCal.get(GregorianCalendar.DAY_OF_MONTH));
        if(m.length() < 2){m = "0" + m;}
        if(d.length() < 2){d = "0" + d;}
        return y + m + d;
    }
    
    public void FNI(){
        errorBox("Sorry, This Feature is not yet implemented","Oops");
    }
    
    public void brandanMessage(){
        infoBox("(c) Brandan Haertel: brandan@northshoresheetmetal.com", "Easter Egg");
    }
    
    public static void infoBox(String infoMessage, String title)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "Info: " 
                + title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public final int MAX_SEARCH_RESULTS = 300;
    public final String entryFilePath = "entry.num";
    public final String databaseFilePath = "database.dat";
    public final String databaseBackupFilePath = "database.backup";
    public String[] companyStringArray = {"Northshore", "Northclad", "Standard"};
    public String[] SystemsStringArray = {"Systems", "Substrate", "Panels", "Conditions", "Misc", "Others", "Components"};
    public final Color colorColor = new Color(0x495ED);
    public final String colorString = "#495ED";
    public final String ICON = "/northshore/library/two/LibraryIcon.png";
    public final String PROGRAM_NAME = "Northshore Library";
    public final String PROGRAM_VERSION = "2.4 Beta";
    public final String SEARCH_FORM_TITLE = PROGRAM_NAME + " - Search - " + PROGRAM_VERSION;
    public final String EDIT_FORM_TITLE = PROGRAM_NAME + " - Manager - " + PROGRAM_VERSION;
    public final boolean SORT = true;
    public final boolean EXCLUSIVE = true;
}


