/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quickadd;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author brandan
 */
public class QuickAdd {

    static String name;
    static String number;
    static String company;
    static String date;
    static String previmage = null;
    static String prevpdf = null;
    static String prevdwg = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // get job name from keyboard
        print("Enter Job Name: ");
        name = read();
        //name = "brandan";
        
        // get job name from keyboard
        print("Enter Job Number: ");
        number = read();
        //number = "6789";
        
        print("Enter Northshore or Northclad or Standard: ");
        company = read();
        //company = "Northshore";
        
        print("Enter Date (YYYYMMDD): ");
        date = read();
        //date = "20140617";
        
        String image;
        String pdf;
        String dwg;
        
        for(;;){
            image = getImage();     // get image file path
            pdf = getPdf();         // get pdf file path
            dwg = getDwg();         // get dwg file path
            if(image == null || pdf == null || dwg == null){
                kill();
                return;
            }
            write(image, pdf, dwg);
        }
    }
    
    static private void print(String s){
        System.out.print(s);
    }
    
    static private String read(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    
    static private String getImage(){
        if(previmage != null){
            return getNext(previmage);
        }
        
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("C:\\Desktop\\Library Add Files\\01.dwg"));
        final FileNameExtensionFilter pngFilter = new FileNameExtensionFilter("JPEG Image (*.jpg)", "jpg");
        chooser.addChoosableFileFilter(pngFilter);
        chooser.setFileFilter(pngFilter);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            //System.out.println(chooser.getSelectedFile().getName().toUpperCase());
            if(chooser.getSelectedFile().getName().toUpperCase().contains(".JPG") 
                    || chooser.getSelectedFile().getName().toUpperCase().contains(".PNG")){
                return chooser.getSelectedFile().getPath();
            }
        }
        return null;
    }
    
    static private String getPdf(){
        if(previmage != null){
            return getNext(prevpdf);
        }
        
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("C:\\Desktop\\Library Add Files\\01.dwg"));
        final FileNameExtensionFilter pdfFilter = new FileNameExtensionFilter("PDF document (*.pdf)", "pdf");
        chooser.addChoosableFileFilter(pdfFilter);
        chooser.setFileFilter(pdfFilter);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            //System.out.println(chooser.getSelectedFile().getName().toUpperCase());
            if(chooser.getSelectedFile().getName().toUpperCase().contains(".PDF")){
                return chooser.getSelectedFile().getPath();
            }
        }
        return null;
    }
    
    static private String getDwg(){
        if(previmage != null){
            return getNext(prevdwg);
        }
        
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("C:\\Desktop\\Library Add Files\\01.dwg"));
        final FileNameExtensionFilter dwgFilter = new FileNameExtensionFilter("Autocad Drawing (*.dwg)", "dwg");
        chooser.addChoosableFileFilter(dwgFilter);
        chooser.setFileFilter(dwgFilter);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            //System.out.println(chooser.getSelectedFile().getName().toUpperCase());
            if(chooser.getSelectedFile().getName().toUpperCase().contains(".DWG")){
                return chooser.getSelectedFile().getPath();
            }
        }
        return null;
    }
    
    static private String getNext(String prev) {
        Pattern pattern = Pattern.compile("\\d*\\d");
        Matcher matcher = pattern.matcher(prev);
        String prefix = ""; String suffex = "";
        int filenumber;
        String buffer = "";
        
        if(matcher.find()){
            prefix = prev.substring(0, matcher.start());
            filenumber = Integer.parseInt(prev.substring(matcher.start(), matcher.end()));
            suffex = prev.substring(matcher.end(), prev.length());
            filenumber++;
            int matchlength = matcher.end() - matcher.start();
            matchlength = matchlength - String.valueOf(filenumber).length();
            //for(int i = 0; i < matchlength; i++)
                //buffer += "0";
            prev = prefix + buffer + filenumber + suffex;
            if(! (new File(prev).exists())){
                return null;
            }
            //System.out.println("Next: " + prev);
            return prev;
        }
        return null;
    }
    
    static private void kill() {
        
    }
    
    static private void write(String i, String p, String d){
        previmage = i; prevpdf = p; prevdwg = d;
        String entry = getLatestEntry();
        
        String image = moveFileI(i);
        String pdf = moveFileP(p);
        String dwg = moveFileD(d);
        String EntryString = 
                entry                   + "$" + 
                company.toUpperCase()   + "$" +
                name.toUpperCase()      + "$" + 
                number.toUpperCase()    + "$" +
                ""                      + "$" +
                date                    + "$" +
                "description"           + "$" +
                pdf                     + "$" + 
                dwg                     + "$" + 
                image                   + "$" +
                "item";
        append(EntryString);
    }
    
    static private String getLatestEntry(){
        Scanner fileInputScanner;
        ArrayList<String> list = new ArrayList();
        String randNumber;
        int lastEntry;
        
        try{
            fileInputScanner = new Scanner(new File("database.dat"));
            randNumber = fileInputScanner.nextLine();
            lastEntry = Integer.parseInt(fileInputScanner.nextLine());
            
            while(fileInputScanner.hasNextLine()){
                String a = fileInputScanner.nextLine();
                //System.out.println(a);
                list.add(a);
            }
            fileInputScanner.close();
        }
        catch(IOException e){
            System.out.println("Error: readTextFile");
            return null;
        }
        System.out.println("last Entry: " + lastEntry + 1);
        lastEntry++;
        return "" + lastEntry;
    }
    
    static private String moveFileP(String path){
        try{
                return moveFile(path, "files\\" + getLatestEntry() + ".pdf");
        }
        catch(Exception e){e.printStackTrace();}
        return null;
    }
    
    static private String moveFileD(String path){
        try{
                return moveFile(path, "files\\" + getLatestEntry() + ".dwg");
        }
        catch(Exception e){e.printStackTrace();}
        return null;
    }
    
    static private String moveFileI(String path){
        try{
                return moveFile(path, "files\\" + getLatestEntry() + ".jpg");
        }
        catch(Exception e){e.printStackTrace();}
        return null;
    }
    
    static private String moveFile(String from, String to){
        System.out.println("Move From: " + from);
        System.out.println("Move To: " + to);
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
    
    static private boolean append(String item){
        Scanner fileInputScanner;
        ArrayList<String> list = new ArrayList();
        String randNumber;
        int lastEntry;
        
        try{
            fileInputScanner = new Scanner(new File("database.dat"));
            System.out.println(new File("database.dat").getPath());
            randNumber = fileInputScanner.nextLine();
            lastEntry = Integer.parseInt(fileInputScanner.nextLine());
            
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
        
        lastEntry++;
        
        
        PrintWriter fileOutput;
        try{
            Random rand = new Random();
            fileOutput = new PrintWriter(new FileOutputStream("database.dat"));
            fileOutput.println(randNumber);
            fileOutput.println(lastEntry);
            
            for(String s : list)
                if(s != null)
                    fileOutput.println(s);
            fileOutput.println(item);
            fileOutput.close();
            return true;
        }
        catch(IOException e){
            System.out.println("Error: write");
            return false;
        }
    }
}
