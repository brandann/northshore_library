/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package northshore.library.two;

import java.util.ArrayList;

/**
 *
 * @author brandan
 */
public class Search {
    public Detail[] SearchTag(ArrayList<String> tags, Detail[] database, boolean exclusive){
        database = cleanDatabase(database);
        //exclusive will only find tags that match all items in the arraylist
        ArrayList<Detail> matches = new ArrayList<>();
        boolean matched = true;
        if(exclusive){
            for(int i = 0; i < database.length; i++){
                for(int j = 0; j < tags.size(); j++){
                    if(!database[i].getTags().contains(tags.get(j))){ //if(!database[i].getTags().contains(">>" + tags.get(j) + ">>")){
                        matched = false;
                    }
                }
                if(matched){
                    matches.add(database[i]);
                }
                else{
                    matched = true;
                }
            }
        }
        else if(!exclusive){
            for(int i = 0; i < database.length; i++){
                for(int j = 0; j < tags.size(); j++){
                    if(database[i].getTags().contains(tags.get(j))){ //if(database[i].getTags().contains(">>" + tags.get(j) + ">>")){
                        matches.add(database[i]);
                        j = tags.size();
                    }
                }
            }
        }
        Detail[] matchArray;
        if(matches.size() > 0){
            matchArray = new Detail[matches.size()];
            matchArray = matches.toArray(matchArray);
        }
        else{
            matchArray = new Detail[0];
        }
        return matchArray;
    }
    
    public Detail[] SearchJobName(String name, Detail[] database){
        database = cleanDatabase(database);
        ArrayList<Detail> matches = new ArrayList<>();
        for(int i = 0; i < database.length; i++){
            if(database[i].getJobName().contains(name))
                matches.add(database[i]);
        }
        Detail[] matchArray;
        if(matches.size() > 0){
            matchArray = new Detail[matches.size()];
            matchArray = matches.toArray(matchArray);
        }
        else{
            matchArray = new Detail[0];
        }
        return matchArray;
    }
    
    public Detail[] SearchJobNumber(String number, Detail[] database){
        database = cleanDatabase(database);
        ArrayList<Detail> matches = new ArrayList<>();
        for(int i = 0; i < database.length; i++){
            if(database[i].getJobNumber().equals(number))
                matches.add(database[i]);
        }
        Detail[] matchArray;
        if(matches.size() > 0){
            matchArray = new Detail[matches.size()];
            matchArray = matches.toArray(matchArray);
        }
        else{
            matchArray = new Detail[0];
        }
        return matchArray;
    }
    
    public Detail[] SearchJobDescriptions(String des, Detail[] database){
        database = cleanDatabase(database);
        ArrayList<Detail> matches = new ArrayList<>();
        for(int i = 0; i < database.length; i++){
            if(database[i].getDetailDescription().contains(des))
                matches.add(database[i]);
        }
        Detail[] matchArray;
        if(matches.size() > 0){
            matchArray = new Detail[matches.size()];
            matchArray = matches.toArray(matchArray);
        }
        else{
            matchArray = new Detail[0];
        }
        return matchArray;
    }
    
    public Detail[] SearchEverything(String[] terms, Detail[] database, boolean exclusive){
        database = cleanDatabase(database);
        ArrayList<Detail> matches = new ArrayList<>();
        if(exclusive){
            boolean matched = true;
            for(int i = 0; i < database.length; i++){
                for(int j = 0; j < terms.length; j++){
                    if(!database[i].toString().contains(terms[j])){
                        matched = false;
                    }
                }
                if(matched){
                    matches.add(database[i]);
                }
                else{
                    matched = true;
                }
            }
        }
        else{
            for(Detail e : database){
                for(String s : terms){
                    if(e.toString().contains(s))
                    matches.add(e);
                }
            }
        }
        
        Detail[] matchArray;
        if(matches.size() > 0){
            matchArray = new Detail[matches.size()];
            matchArray = matches.toArray(matchArray);
        }
        else{
            matchArray = new Detail[0];
        }
        return matchArray;
    }
    
    public Detail[] SearchEverything(String term, Detail[] database){
        database = cleanDatabase(database);
        ArrayList<Detail> matches = new ArrayList<>();
        for(Detail e : database){
            if(e.toString().contains(term))
                matches.add(e);
        }
        
        Detail[] matchArray;
        if(matches.size() > 0){
            matchArray = new Detail[matches.size()];
            matchArray = matches.toArray(matchArray);
        }
        else{
            matchArray = new Detail[0];
        }
        return matchArray;
    }
    
    private Detail[] cleanDatabase(Detail[] old) {
        ArrayList<Detail> matches = new ArrayList<>();
        for(Detail e : old){
            if(e != null)
                matches.add(e);
        }
        Detail[] newdatabase = new Detail[matches.size()];
        newdatabase = matches.toArray(newdatabase);
        return newdatabase;
    }
}
