/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatest;

import java.util.Scanner;

/**
 *
 * @author Tunwashe Daniel
 */
public class javaTest2 {
    
    private static int x;
    
    static class IPAddress{
        String ipaddress = "1.2.3.4";
        public  IPAddress(){
            System.out.println(ipaddress);
        }
        
        protected int x;
        private int y;
        
    }
    
    static class IPAddressChecked1 extends IPAddress{
         boolean IsCorrect;
         public IPAddressChecked1(String userInput){
             
             if(!(userInput.equals(ipaddress))){
                 IsCorrect = false;
             }
             if((IsCorrect == false)){
                 System.out.println(userInput + " -  Not Correct ");
             }
             
         }

           
    }
    
    
    static class  IPAddressChecked2 extends IPAddress{
        
        boolean IsCorrect;
        
  
        public IPAddressChecked2(String userInput){
            if(ipaddress.equals(userInput)){
                IsCorrect = true;    
        }
            
            if(IsCorrect){
                System.out.println(userInput + " -  Correct ");
            }
            
            
    }  
        
        
    }
    
    
    public static  void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter an IP address to know if it's correct....");
        String userInput  = scan.next();
        IPAddress ip = new  IPAddress();
        IPAddressChecked1 ipch1 = new IPAddressChecked1(userInput);
        IPAddressChecked2 ipch2 = new IPAddressChecked2(userInput);
        
        x = 5;
    }
    
}
