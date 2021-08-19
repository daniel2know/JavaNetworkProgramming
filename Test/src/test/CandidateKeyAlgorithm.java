/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tunwashe Daniel
 */
public class CandidateKeyAlgorithm {
    
    static DecimalFormat df = new DecimalFormat("#.#");
    
    public static Scanner scan = new Scanner(System.in);
    public static String input;
    public static String input1;
    public static String input2;
    public static ArrayList <String> one = new ArrayList<String>();
    public static ArrayList <String> inputOneArray = new ArrayList<String>();
    public static ArrayList <String> inputTwoArray = new ArrayList<String>();
   
    
     public static void powerSet(String str, int index, String curr){
        
        int n = str.length();
        
        if(index == n){
            return;
        }
        
        System.out.println(curr);
        one.add(curr);
        input+=curr;
         
        for(int i = index + 1; i<n; i++){
            
            
            curr += str.charAt(i);
           
            
            powerSet(str,i,curr);
            
            curr = curr.substring(0, curr.length() -1);
            
        }
        
    }
     
     
     
     
     public static void compare(String textone, ArrayList<String> textoneArray, String initialtextone,  String texttwo, ArrayList<String> texttwoArray,String initialtexttwo ){
         
         double length = textoneArray.size();
         double lengthtwo = texttwoArray.size();
         double sum = 0;
         double res =0;
         double restotal = 0;
         String restotally;
         boolean isComplete = false;
         boolean isCompletetwo = false;
         
         for(int i=0; i < (textoneArray.size()); i++){
             if(textoneArray.size() <= texttwoArray.size()){
                 if(textoneArray.get(i).equals(texttwoArray.get(i))){
                     sum = sum + 1;
                     System.out.println("hello");
                     isComplete = true;
                 }
                
             }
             
             else{
                 
                 break;
             }
             
         }
         
         for(int j=0; j < (texttwoArray.size()); j++){
                 if(textoneArray.size() > texttwoArray.size()){
                     if(textoneArray.get(j).equals(texttwoArray.get(j))){
                         sum+=1;
                         System.out.println("Hello");
                         isCompletetwo = true;
                     }
                 }
             }
         
         if(isComplete){
             res = (sum/length);
             restotal = (res*100);
             DecimalFormat df = new DecimalFormat("#.#");
             restotally = df.format(restotal);
             System.out.println(restotally);
         }
         
         if(isCompletetwo){
             res = (sum/lengthtwo);
             restotal = (res*100);
             DecimalFormat df = new DecimalFormat("#.#");
             restotally = df.format(restotal);
             System.out.println(restotally);
         }
         
     }
    
    public static void main(String[] args){
        
        
        String str, str2;
        System.out.print("Enter any string: ----->   :     ");
        str = scan.next();
        
        int index = -1;
        int index2 = -1;
        String curr = "";
        String curr2 = "";
        // first string powerset generator
        powerSet(str, index, curr);
        System.out.println("------------------------------");
        
        
         
        for(int i=1; i<one.size(); i++){
            inputOneArray.add(one.get(i));
        }
        input = input.substring(4, input.length());
        input1 = input;
        
        
        //second string powerset generator
        System.out.print("Enter any string: ----->   :     ");
        str2 = scan.next();
//       
        one.clear();
        input = "";
        
         
        powerSet(str2, index2, curr2);
        System.out.println("------------------------------");
        
        for(int i=1; i<one.size(); i++){
            inputTwoArray.add(one.get(i));
        }
        
        input = input.substring(0, input.length());
        input2 = input;
        
        System.out.println("------------------------- first array list --------------------");
        for(int i=0; i<inputOneArray.size(); i++){
            System.out.println(inputOneArray.get(i));
        }
         System.out.println("------------------------- first array list end --------------------");
        
        System.out.println("------------------------- second array list --------------------");
        for(int i=0; i<inputTwoArray.size(); i++){
            System.out.println(inputTwoArray.get(i));
        }
        System.out.println("------------------------- second array list end --------------------");
        
        compare(input1, inputOneArray, str, input2, inputTwoArray, str2);
        
    }
    
    
    
}
