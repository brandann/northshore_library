/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package northshore.library.two;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author brandan
 */
public class Database {
    public Database() throws IOException {
        initialize();
    }

    public Detail get(int index) {
        if(!isCurrent())
            load();
        if(database[index] != null){
            currentDetail = database[index];
            return currentDetail;
        }
        return getNext(index);
    }
    
    public Detail getNext() {
        return getNext(currentDetail.getEntry() + 1);
        
    }
    
    public Detail getPrevious() {
        return getPrevious(currentDetail.getEntry() - 1);
    }
    
    public Detail getFirst() {
        return getNext(0);
        
    }
    
    public Detail getLast() {
        return get(lastEntry);
    }
    
    public void remove(int index) {
        if(!isCurrent())
            load();
        if(index < 0 || index >= database.length)
            return;
        database[index] = null;
        save();
    }
    
    public void remove(Detail item) {
        remove(item.getEntry());
    }
    
    public void replace(int index, Detail item) {
        if(!isCurrent())
            load();
        if(index < 0 || index >= database.length)
            return;
        item.setPDF(setPDF(item));
        item.setJPG(setJPG(item));
        item.setDWG(setDWG(item));
        database[index] = item;
        save();
    }
    
    public void replace(Detail item) {
        replace(item.getEntry(), item);
    }
    
    public void add(Detail item) {
        if(!isCurrent())
            load();
        Detail[] newDatabase = new Detail[database.length + 1];
        for(int i = 0; i < database.length; i++)
            newDatabase[i] = database[i];
        lastEntry++;
        item.setEntry(lastEntry);
        item.setPDF(setPDF(item));
        item.setJPG(setJPG(item));
        item.setDWG(setDWG(item));
        newDatabase[database.length] = item;
        database = newDatabase;
        currentDetail = item;
        save();
    }
    
    public Detail[] getDatabase() {
        return database;
    }
    
    public Detail getCurrentDetail() {
        return currentDetail;
    }
    
    public int size() {
        return lastEntry + 1;
    }
    
    public int getItems() {
        return items;
    }
    
    private void initialize() throws IOException {
        database = null;
        databaseFile = new File(DATABASE_STRING);
        if(!databaseFile.exists())
        {
            databaseFile.createNewFile();
        }
        load();
    }
    
    private Detail getNext(int index) {
        if(!isCurrent())
            load();
        if(index < 0)
            index = 0;
        if(index >= database.length)
            index = database.length - 1;
        if(doesDatabaseItemExist(index)){
            currentDetail = database[index];
            return currentDetail;
        }
        for(int i = index; i < database.length; i++){
            if(database[i] != null){
                currentDetail = database[i];
                return currentDetail;
            }
        }
        return currentDetail;
    }
    
    private Detail getPrevious(int index) {
        if(!isCurrent())
            load();
        if(index < 0)
            index = 0;
        if(index > database[database.length - 1].getEntry())
            index = database[database.length - 1].getEntry();
        if(doesDatabaseItemExist(index)){
            currentDetail = database[index];
            return currentDetail;
        }
        if(currentDetail == null){
            getNext(0);
            return currentDetail;
        }
        for(int i = index; i > 0; i--){
            if(database[i] != null){
                currentDetail = database[i];
                return currentDetail;
            }
        }
        getNext(0);
        return currentDetail;
    }
    
    private boolean doesDatabaseItemExist(int index){
        if(database[index] != null)
            return true;
        return false;
    }
    
    private boolean save() {
        boolean pass = true;
        pass = logDatabase();
        pass = logNumbers();
        pass = logNames();
        //pass = logTags();
        return pass;
    }
    
    private boolean logNumbers(){
        PrintWriter fileOutput;
        try{
            fileOutput = new PrintWriter(new FileOutputStream("numbers.log"));
            for(Detail d : database)
                if(d != null)
                    fileOutput.println(d.getJobNumber());
            fileOutput.close();
            return true;
        }
        catch(IOException e){
            System.out.println("Error: write logNuumbers");
            return false;
        }
    }
    
    private boolean logNames(){
        PrintWriter fileOutput;
        try{
            fileOutput = new PrintWriter(new FileOutputStream("names.log"));
            for(Detail d : database)
                if(d != null)
                    fileOutput.println(d.getJobName());
            fileOutput.close();
            return true;
        }
        catch(IOException e){
            System.out.println("Error: write logNames");
            return false;
        }
    }
    
    private boolean logTags(){
        return false;
    }
    
    private boolean logDatabase(){
        PrintWriter fileOutput;
        try{
            Random rand = new Random();
            fileOutput = new PrintWriter(new FileOutputStream(DATABASE_STRING));
            fileOutput.println(rand.nextLong());
            fileOutput.println(lastEntry);
            for(Detail d : database)
                if(d != null)
                    fileOutput.println(d.toString());
            fileOutput.close();
            return true;
        }
        catch(IOException e){
            System.out.println("Error: write");
            return false;
        }
    }
    
    private boolean load() {
        Scanner fileInputScanner;
        items = 0;
        ArrayList<Detail> list = new ArrayList();
        try{
            fileInputScanner = new Scanner(databaseFile);
            date = fileInputScanner.nextLine();
            lastEntry = Integer.parseInt(fileInputScanner.nextLine());
            while(fileInputScanner.hasNextLine()){
                String a = fileInputScanner.nextLine();
                //System.out.println(a);
                list.add(new Detail(a));
                items++;
            }
            fileInputScanner.close();
        }
        catch(IOException e){
            System.out.println("Error: readTextFile");
            return false;
        }
        
        database = new Detail[lastEntry + 1];
        for(Detail d : list)
            if(d != null)
                database[d.getEntry()] = d;
        return true;
    }
    
    private boolean isCurrent() {
        Scanner fileInputScanner;
        try{
            fileInputScanner = new Scanner(databaseFile);
            String date = fileInputScanner.nextLine();
            fileInputScanner.close();
        }
        catch(IOException e){
            System.out.println("Error: isCurrent");
        }
        if(this.date.equals(date))
            return true;
        return false;
    }
    
    private String setPDF(Detail item){
        Driver driver = new Driver();
        File file;
        String path = item.getPDF();
        try{
            if(!item.getPDF().contains("files\\")){
                file = new File("files\\" + item.getEntry() + ".pdf");
                if(file.exists())
                    file.delete();
                path = (driver.moveFile(item.getPDF(), "files\\" + item.getEntry() + ".pdf"));
            }
            
        }
        catch(Exception e){e.printStackTrace();}
        return path;
    }
    
    private String setJPG(Detail item){
        Driver driver = new Driver();
        File file;
        String path = item.getJPG();
        try{
            if(!item.getJPG().contains("files\\")){
                file = new File("files\\" + item.getEntry() + ".png");
                if(file.exists())
                    file.delete();
                path = (driver.moveFile(item.getJPG(), "files\\" + item.getEntry() + ".png"));
            }
        }
        catch(Exception e){e.printStackTrace();}
        return path;
    }
    
    private String setDWG(Detail item){
        Driver driver = new Driver();
        File file;
        String path = item.getDWG();
        try{
            if(!item.getDWG().contains("files\\")){
                file = new File("files\\" + item.getEntry() + ".dwg");
                if(file.exists())
                    file.delete();
                path = (driver.moveFile(item.getDWG(), "files\\" + item.getEntry() + ".dwg"));
            }
        }
        catch(Exception e){e.printStackTrace();}
        return path;
    }
    
    
    private Detail[] database;
    private Detail currentDetail;
    private String date;
    private int lastEntry;
    private final String DATABASE_STRING = "database.dat";
    private File databaseFile; 
    private int items;
}
