/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tunwashe Daniel
 */
public class NewClass1 {
    public static int sum = 0;
    public static ArrayList<String> store  = new ArrayList<>();
    public static ArrayList<String> storeTwo  = new ArrayList<>();
    public static String input;
    public static String inputs;
    
    
    
    
    public static void powerSet(String str, int index, String curr){
        
        int n = str.length();
        
        if(index == n){
            return;
        }
        
        System.out.println(curr);
        input+=curr;
         
        for(int i = index + 1; i<n; i++){
            
            
            curr += str.charAt(i);
           
            
            powerSet(str,i,curr);
            
            curr = curr.substring(0, curr.length() -1);
            
        }
        
    }
    
    
    
    
    public static void powerSetTwo(String stri, int index2, String curr2){
        
        int n = stri.length();
        
        if(index2 == n){
            return;
        }
        
     
        System.out.println(curr2);
        inputs += curr2;
         
        for(int i = index2 + 1; i<n; i++){
            
            
            curr2 += stri.charAt(i);
           
            
            powerSetTwo(stri,i,curr2);
            
            curr2 = curr2.substring(0, curr2.length() -1);
            
        }
        
        
        
    }
    
    
    
    
    
   public void compare(String dataOne, String dataTwo){
       
       float length;
       float percentage;
       float sum = 0;
       int sumExpected = 1;
       float total;
       
       char [] data;
       char [] datas;
       String [] tbl;
       
       data = dataOne.toCharArray();
       datas = dataTwo.toCharArray();
       
       total = dataOne.length() + dataTwo.length();
       
       if(dataOne.length() > dataTwo.length()){
           length = dataTwo.length();
       }
       else if(dataTwo.length() > dataOne.length()){
           length = dataOne.length();
       }
       else{
           length = ( dataOne.length() | dataTwo.length() ) ;
       }
       
       for(int i =0; i<length; i++){
           
           if(dataOne.charAt(i) == dataTwo.charAt(i)){
               System.out.println(i+1);
               sum += 1 ;
           }
           
           
           
       }
       
       
       if(dataOne.length() == dataTwo.length() ){
           
            System.out.println("hello greater");
            System.out.println(sum);  
           
       }
       else if(!(dataOne.length() == dataTwo.length()) && (sum == 1 || sum > (length/5))){
           
           System.out.println("hello greater");
           System.out.println(sum);
           
          
       }
       else{
           System.out.println("not greater");
           System.out.println(sum);
       }
       
        
   
           
       
      
       
       
       
       //System.out.println("This is sum"+sum);
       //percentage = (sum / length) * 100;
       
      // percentage = (((sum/total) *2) * 100);
       
       
      
       
      // System.out.println(percentage);
       System.out.println(length);
       System.out.println(dataTwo.length());
   }
    
   
    
    
    
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        String str, str2;
        System.out.print("Enter any string: ----->   :     ");
        str = scan.next();
        
        int index = -1;
        int index2 = -1;
        String curr = "";
        String curr2 = "";
        
        
        powerSet(str, index, curr);
        System.out.println("------------------------------");

        
        input = input.substring(4, input.length());
        System.out.println(input);
        
        
        System.out.print("Enter another string: ---------------->   :   ");
        str2 = scan.next();
        
        powerSetTwo(str2,index2,curr2);
        System.out.println("------------------------------");
        inputs = inputs.substring(4, inputs.length());
        System.out.println(inputs);
        
        
        NewClass1 ne = new NewClass1();
        ne.compare(input,inputs);
        
    }
    
    
    
}
