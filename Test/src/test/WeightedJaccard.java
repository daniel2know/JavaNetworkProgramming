/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.*;
import static java.lang.System.in;
import java.text.DecimalFormat;
import java.util.*;

public class WeightedJaccard {
    
    static Scanner scan = new Scanner(System.in);
    static String nameOne, nameTwo;
    static float minRes;
    static float maxRes;
    static String difference = "";
    static String differencetwo;
    static String differencethree;
    static float totalRes;
    static String totalResFormatted;
    
    
    
    public void min(String input1, String input2){
        
        WeightedJaccard wj = new WeightedJaccard();
        differencetwo = wj.getdifference(input1, input2);
        
        
        minRes = ((input1.length() + input2.length()) - differencetwo.length())/2;
        System.out.println(minRes);
        
    }
    
    public String getdifference(String input1, String input2){ 
        char[] c = input1.toCharArray();
        
        for (char ch: c){
            if(!input2.contains("" + ch)) {
                difference+=ch;
            }
        }
        
        System.out.println(difference);
        return difference;
    }
    
    public void max(String input1, String input2){
       
        maxRes = ((input1.length() + input2.length()) + differencetwo.length())/2;
        System.out.println(maxRes);
    } 
    
    
    public void getSimilarity(float min, float max){
        
        totalRes = ((min/max));
        DecimalFormat df = new DecimalFormat("#.##");
        totalResFormatted = df.format(totalRes * 100);
        System.out.println(totalResFormatted);
        
    }
    public static void main(String[] args){
        
        WeightedJaccard wj = new WeightedJaccard();
        
        System.out.print("Enter the first string: ");
        nameOne = scan.next();
        System.out.print("Enter the Second string: ");
        nameTwo = scan.next();
        
        wj.min(nameOne,nameTwo);
        wj.max(nameOne,nameTwo);
        wj.getSimilarity(minRes,maxRes);
        
    }
    
}
