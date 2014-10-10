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
public class Search {
    
    ArrayList<Detail> details;
    private final String databasePath = "data\\database.dat";
    
    public Search() throws FileNotFoundException{
        if(!loadDetails()){
            details = null;
        }
        System.out.println("Database size: " + details.size());
    }
    
    public boolean search(String str){
        ArrayList<Detail> DetailList = new ArrayList<>();
        DetailList = (ArrayList<Detail>) details.clone();
        
        String[] terms = str.split(",");
        for(String s : terms){
            
            s = s.toUpperCase();
            System.out.println("Search code: " + s.charAt(0));
            System.out.println("Search term: " + s.substring(1));
            
            if(s.startsWith("T")){
                DetailList = findTagIncludes(s.substring(1), DetailList);
            }
            else if(s.startsWith("D")){
                DetailList = findJobNumber(s.substring(1), DetailList);
            }
            else if(s.startsWith("N")){
                DetailList = findJobName(s.substring(1), DetailList);
            }
            else if(s.startsWith("C")){
                DetailList = findCompany(s.substring(1), DetailList);
            }
        }
        
        ArrayList<Detail> keep = new ArrayList<>();
        for(String s : terms){
            s = s.toUpperCase();
            if(s.startsWith("-")){
                for (int i = 0; i < DetailList.size()-1; i++){
                    if(!DetailList.get(i).getTags().contains(s.substring(1))){
                        print("found");
                        keep.add(DetailList.get(i));
                    }
                }
            }
        }
        
        export(keep);
        
        return true;
    }
    
    private void print(String s){
        System.out.println(s);
    }
    
    private void export(ArrayList<Detail> DetailList){
        print("export size: " + DetailList.size());
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
    
    private ArrayList<Detail> findTagIncludes(String str, ArrayList<Detail> DetailList){
        ArrayList<Detail> det = new ArrayList<>();
        for(Detail d : DetailList){
            if(d.getTags().contains(str)){
                det.add(d);
            }
        }
        return det;
    }
    
    private ArrayList<Detail> findJobNumber(String str, ArrayList<Detail> DetailList){
        ArrayList<Detail> Det = new ArrayList<>();
        
        for(Detail d : DetailList){
            if(d.getJobNumber() == str){
                Det.add(d);
            }
        }
        
        return Det;
    }
    
    private ArrayList<Detail> findJobName(String str, ArrayList<Detail> DetailList){
        ArrayList<Detail> Det = new ArrayList<>();
        
        for(Detail d : DetailList){
            if(d.getJobName() == str){
                Det.add(d);
            }
        }
        
        return Det;
    }
    
    private ArrayList<Detail> findCompany(String str, ArrayList<Detail> DetailList){
        ArrayList<Detail> Det = new ArrayList<>();
        
        for(Detail d : DetailList){
            if(d.getCompany() == str){
                Det.add(d);
            }
        }
        
        return Det;
    }
}
