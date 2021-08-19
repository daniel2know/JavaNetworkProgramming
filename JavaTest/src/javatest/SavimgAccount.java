/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatest;

/**
 *
 * @author Tunwashe Daniel
 */
public class SavimgAccount {
    
    
    static int annualIntrestRate;
   
   public void monthlyIntrest(double saveBalance){
       
         double savingBalance = saveBalance;
         double monthlyIntrest = (savingBalance * annualIntrestRate)/12;
         savingBalance = monthlyIntrest;
         
        System.out.println("the saver for "+ saveBalance + " is " + savingBalance); 
    }
   
   public static void modifyIntrestRate(int newRate){
       annualIntrestRate = newRate;
   }
    
    public static  void main(String[] args) {
        
        SavimgAccount saver1 = new SavimgAccount();
        SavimgAccount saver2 = new SavimgAccount();
        
        modifyIntrestRate(4);
        saver1.monthlyIntrest(2000.00);
        saver2.monthlyIntrest(3000.00);
        
        System.out.println("----------------------");
        modifyIntrestRate(5);
        saver1.monthlyIntrest(2000.00);
        saver2.monthlyIntrest(3000.00);
        
        
        
        
    }
    
}
