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
public class JaccardSim {
    static Scanner scan = new Scanner(System.in);
    static String nameOne, nameTwo, resultUnion, resultIntersection;
    float intersection, union;
    float jIndexValue;
    
    public String Union(String nameOne, String nameTwo){
        
        String s = (nameOne + nameTwo).toLowerCase();
        int i =0;
        while(i < s.length()){
            char c = s.charAt(i);
            if( i != s.lastIndexOf(c))
                s = s.substring(0, i) + s.substring(i+1, s.length());
            else i++;
        }
        return s;
    }
    
    public String intersection (String nameOne, String nameTwo){
        String s = "";
        nameTwo = nameTwo.toLowerCase();
        for(char c : nameOne.toLowerCase().toCharArray()){
            if(nameTwo.indexOf(c) != -1 && s.indexOf(c) == -1)
                s+=c;
        }
        return s;
    }
    
    
    private void comparison(){
        
        JaccardSim js = new JaccardSim();
        resultUnion  = js.Union(nameOne, nameTwo);
        resultIntersection = js.intersection(nameOne, nameTwo);
        
        intersection = resultIntersection.length();
        union = resultUnion.length();
        
        jIndexValue = ((intersection / union) * 100);
        System.out.println(jIndexValue);
        
        
    }
    
    
    public static void main(String[] args){
        JaccardSim js = new JaccardSim();
               
        System.out.print("Enter the first string: ");
        nameOne = scan.next();
        System.out.print("Enter the Second string: ");
        nameTwo = scan.next();
        
        resultUnion  = js.Union(nameOne, nameTwo);
        resultIntersection = js.intersection(nameOne, nameTwo);
        
        System.out.println(resultUnion);
        System.out.println(resultIntersection);
        System.out.println(resultIntersection.length());
        System.out.println(resultUnion.length());
        
        js.comparison();
        
        
        
    }
    
}
