/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopexam;

/**
 *
 * @author Tunwashe Daniel
 */
public class SavingsAccount {
    
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
    
    public static void main(String[] args) {

        
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();
        
        modifyIntrestRate(4);
        saver1.monthlyIntrest(2000.00);
        saver2.monthlyIntrest(3000.00);
        
        System.out.println("----------------------");
        modifyIntrestRate(5);
        saver1.monthlyIntrest(2000.00);
        saver2.monthlyIntrest(3000.00);
        

    }
    
}
