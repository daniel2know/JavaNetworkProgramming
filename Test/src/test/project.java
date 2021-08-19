/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;


/**
 *
 * @author Tunwashe Daniel
 */
public class project {
    static Scanner scan = new Scanner(System.in);
    public static ArrayList<String> store = new ArrayList<>();
    public static ArrayList<String> store1 = new ArrayList<>();
    public static ArrayList<String> store2 = new ArrayList<>();
    public static String [] store3;
    
     public static void powerSet(String str, int index, String curr){
        int n = str.length();
        if(index == n){
            return;
        }
        System.out.println(curr);
        store.add(curr);
        for(int i = index + 1; i<n; i++){
            curr += str.charAt(i);
            powerSet(str,i,curr);
            curr = curr.substring(0, curr.length() -1);  
        }  
    }
     
     
     
     public void saveIntoAnother(ArrayList<String> save){
         for (int i=0; i<store.size(); i++){
             if(i == 0)
                 continue;
            save.add(store.get(i));     
        } 
     }
     
     
     public void printArray(ArrayList<String> savedList){
         System.out.println("--------------------------------");
         for(int i=0; i<savedList.size(); i++){
             System.out.println(savedList.get(i));
         }
         System.out.println("--------------------------------");
     }
     
     
     
     public void clearArrayList(){
         store.clear();
     }
     
     
     public void compare(ArrayList<String> A, ArrayList<String> B){
         int size =  A.size();
         int length;
         int match = 0;
         if(A.size() > B.size()){
             length = A.size();
         }
         else if(B.size() > A.size()){
             length = B.size();
         }
         else
             length = A.size();
         
         for(int i=0; i<A.size(); i++){
             for (int j =0; j< B.size(); j++){
                 if(A.get(i).matches(B.get(j))){
                     match+=1;
                 }
             }
         }
         
         System.out.println(match);
         System.out.println(size);
         if(match >= size)
             System.out.println("Good to go....... Match");
           else
             System.out.println("Not good to go...... Does not match");
     }
    
    
     public static void main(String[] args){
        project p = new project();
        Scanner scan = new Scanner(System.in);
        String str;
        System.out.print("Enter any string: ----->   :     ");
        str = scan.next();
        
        
        int index = -1;
        String curr = "";
        
        powerSet(str, index, curr);
        p.saveIntoAnother(store1);
        p.printArray(store1);
        
        p.clearArrayList();
        
        String strTwo;
        System.out.print("Enter any string: ----->   :     ");
        strTwo = scan.next();
        
        powerSet(strTwo,index,curr);
        p.saveIntoAnother(store2);
        p.printArray(store2);
        
        
        p.compare(store1, store2);
     }  
}
