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
public class AbstractTut {
    
    class Calculation{
        int z;
        public void addition(int x, int y){
            z = x+y;
            System.out.println("Z is "+ z);
            System.out.println(x +" "+ y);
        }
        
        public void subtraction(int x, int y){
            z = x - y;
            System.out.println("Z Now is "+ z);
            System.out.println(x +" "+ y);
        }
    }
    
    static class Mycalculation extends Calculation{
        
        public void multiplication(int x, int y){
            z = x*y;
            System.out.println("Z again now is "+ z);
            System.out.println(x +" "+ y);
        }
    }
    
   
    public static  void main(String[] args) {
        
        Mycalculation calculate = new Mycalculation();
        int a = 30;
        int b = 10;
        
        calculate.addition(a,b);
        calculate.subtraction(a, b);
        calculate.multiplication(a, b);
       
        
        
    }
    
    
    
}
