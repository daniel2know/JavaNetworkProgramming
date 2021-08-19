
package oopexam;

import java.util.Scanner;


public class Power {
    static Scanner scan = new Scanner(System.in);
    
    public void integerPower(int base, int exponent){
        long result = 1;
        while(exponent!=0){
            result *= base;
            --exponent;
        }
        System.out.println("The answer is: "+ result);
    }
    
    public static void main(String[] args) {
        
        int base, exponent;
        
        System.out.println("Enter the value for the base  ");
        base = scan.nextInt();
        
        System.out.println("Enter the value for the exponent  ");
        exponent = scan.nextInt();
        
        
        Power p = new Power();
        p.integerPower(base, exponent);
        
        
    }
    
}
