/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarysearch;

import Detail.Detail;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author brandan
 */
public class SimpleSearch {
    
    ArrayList<Detail> details;
    private final String databasePath = "data\\database.dat";
    
    public SimpleSearch() throws FileNotFoundException{
        if(!loadDetails()){
            details = null;
        }
    }
    
    public boolean search(String str){
        System.out.println("search string: " + str);
        System.out.println("database size: " + details.size());
        ArrayList<Detail> DetailList = new ArrayList<>();
        String[] terms = str.split(",");
        for(String s : terms){
            System.out.println("searching: " + str);
            for(Detail d : details){
                if(d.toString().contains(s.toUpperCase())){
                    DetailList.add(d);
                }
            }
        }
        
        System.out.println("Database found size: " + DetailList.size());
        if(DetailList.size() > 0){
            export(DetailList);
            return true;
        }
        return false;
    }
    
    private void export(ArrayList<Detail> DetailList){
        Detail[] detailArray = new Detail[DetailList.size()];
        detailArray = DetailList.toArray(detailArray);
        Random r = new Random();
        HtmlOut h = new HtmlOut(detailArray, "data\\search\\LS-" + r.nextLong() + ".html");
    }
    
    private boolean loadDetails() throws FileNotFoundException{
        details = new ArrayList<>();
        Scanner fileInputScanner = new Scanner(new File(databasePath));
        String date = fileInputScanner.nextLine();
        int lastEntry = Integer.parseInt(fileInputScanner.nextLine());
        while(fileInputScanner.hasNextLine()){
            String a = fileInputScanner.nextLine();
            //System.out.println(a);
            details.add(new Detail(a));
        }
        fileInputScanner.close();
        return true;
    }
}
