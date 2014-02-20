package northshore.library.two;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import static northshore.library.two.ManageLibrary.errorBox;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brandan
 */
public class Import {
    private File newDatabaseFile;
    private String newDatabaseFilesPath;
    private ArrayList<String> existingDatabase_String;
    private int greatestEntry = 0;
    
    public Import()
    {
        if (getPath())
        {
            if(loadExistingDatabase())
            {
                greatestEntry = Integer.parseInt(existingDatabase_String.get(1));
                if ( loadNewDatabase() )
                {
                    if (saveDatabase())
                    {
                        clean();
                    }
                }
            }
        }

    }
    
    private boolean getPath()
    {
        JFileChooser chooser = new JFileChooser();
            final FileNameExtensionFilter pngFilter = new FileNameExtensionFilter("Database (*.dat)", "dat");
            chooser.addChoosableFileFilter(pngFilter);
            chooser.setFileFilter(pngFilter);
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                System.out.println(chooser.getSelectedFile().getName().toUpperCase());
                if(chooser.getSelectedFile().getName().contains("database.dat"))
                {
                    if (chooser.getSelectedFile().exists() && chooser.getSelectedFile().canRead())
                    {
                        newDatabaseFile = chooser.getSelectedFile();
                        newDatabaseFilesPath = newDatabaseFile.getParent() + "\\";
                        System.out.println(newDatabaseFilesPath);
                        return true;
                    }
                }
                else{
                    errorBox("File Choosen Is Not Database File", "File Format Error");
                }
            }
            return false;
    }
    
    private boolean loadNewDatabase()
    {
        Scanner fileInputScanner;
        ArrayList<Detail> list = new ArrayList();
        try{
            fileInputScanner = new Scanner(newDatabaseFile);
            String date = fileInputScanner.nextLine();
            int lastEntry = Integer.parseInt(fileInputScanner.nextLine());
            String notused = fileInputScanner.nextLine();
            while(fileInputScanner.hasNextLine()){
                greatestEntry++;
                String a = fileInputScanner.nextLine();
                Detail temp = new Detail(a);
                
                File tempFile;
                String newPath;
                
                newPath = "files\\" + greatestEntry + ".png";
                tempFile = new File(newDatabaseFilesPath + temp.getJPG());
                System.out.println(tempFile.getName());
                if (tempFile.getName().contains(".jpg"))
                    newPath = "files\\" + greatestEntry + ".jpg";
                temp.setJPG(newPath);
                tempFile.renameTo(new File(newPath));
                
                newPath = "files\\" + greatestEntry + ".pdf";
                tempFile = new File(newDatabaseFilesPath + temp.getPDF());
                temp.setPDF(newPath);
                tempFile.renameTo(new File(newPath));
                
                newPath = "files\\" + greatestEntry + ".dwg";
                tempFile = new File(newDatabaseFilesPath + temp.getDWG());
                temp.setDWG(newPath);
                tempFile.renameTo(new File(newPath));
                
                temp.setEntry(greatestEntry);
                
                existingDatabase_String.add(temp.toString());
            }
            fileInputScanner.close();
        }
        catch(IOException e){
            System.out.println("Error: readTextFile");
            return false;
        }
        
        return true;
    }

    private boolean loadExistingDatabase()
    {
        Scanner fileInputScanner;
        ArrayList<String> list = new ArrayList();
        try{
            fileInputScanner = new Scanner(new File("database.dat"));
            
            while(fileInputScanner.hasNextLine()){
                String a = fileInputScanner.nextLine();
                //System.out.println(a);
                list.add(a);
            }
            fileInputScanner.close();
        }
        catch(IOException e){
            System.out.println("Error: readTextFile");
            return false;
        }
        
        existingDatabase_String = list;
        
        return true;
    }
    
    
    private boolean saveDatabase()
    {
        PrintWriter fileOutput;
        try{
           
            fileOutput = new PrintWriter(new FileOutputStream("database.dat"));
            fileOutput.println(existingDatabase_String.get(0));
            fileOutput.println(greatestEntry);
            for(int i = 2; i < existingDatabase_String.size(); i++)
                fileOutput.println(existingDatabase_String.get(i));
            fileOutput.close();
            return true;
        }
        catch(IOException e){
            System.out.println("Error: write");
            return false;
        }
    }
    
    private void clean()
    {
        Scanner fileInputScanner;
        ArrayList<Detail> list = new ArrayList();
        String date = "";
        int lastEntry = 0;
        String notused = "";
        try{
            fileInputScanner = new Scanner(newDatabaseFile);
            date = fileInputScanner.nextLine();
            lastEntry = Integer.parseInt(fileInputScanner.nextLine());
            notused = fileInputScanner.nextLine();
            fileInputScanner.close();
        }
        catch(IOException e){
            System.out.println("Error: readTextFile");
            return;
        }
        
        PrintWriter fileOutput;
        try{
           
            fileOutput = new PrintWriter(new FileOutputStream(newDatabaseFile));
            fileOutput.println(date);
            fileOutput.println(0);
            fileOutput.println(notused);
            fileOutput.close();
        }
        catch(IOException e){
            System.out.println("Error: write");
            return;
        }
    }
    
}
