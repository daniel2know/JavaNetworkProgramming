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
public class JavaTest {

    /**
     * @param args the command line arguments
     */
    
    abstract class IPAddressChecked{
        
        
        public abstract  void checkifIPCorrect(String ip);
        
    }
    
    
   static class check extends IPAddressChecked{
        


        @Override
        public  void checkifIPCorrect(String ip) {

            String IPAddress = "100.0.5.3";
            boolean access;
            
            if(ip.equals(ip)){
                access = true;
  
            }
            else{
                access = false;
                
            }
            
            if(access){
                System.out.println(ip + " is correct");
            }
            else{
                System.out.println(ip +" Is not correct");
            }
        }
        
      
  
    }
    
    
    
    
    public static  void main(String[] args) {
        
        String userInput;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an IP Address ro check if its correct:   ---->  ");
        userInput = scan.next();
        
        
        //checkifIPCorrect ch1 = new checkifIPCorrect();
        
        check  check = new check();
        check.checkifIPCorrect(userInput);
  
    }
    
}




