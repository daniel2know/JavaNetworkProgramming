


package test;

import java.util.Scanner;




public class Test {
    String [] arr;
    char [] stringToChar;
    
public void powerset(String nam){
    
     stringToChar = nam.toCharArray();
    
    for(char output : stringToChar)
        System.out.println(output + " " + stringToChar.length);
    
   for(int i =0; i<stringToChar.length -1; i++){
       
       System.out.println(stringToChar[i]);
       
   }
   
   
    
}
   
    public static void main(String[] args) {
        
//        String name;
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter your name....");
//        name = scan.next();
//        
//        Test t = new Test();
//        t.powerset(name);
        
        String input = "abc";
        
        for(int i =1; i < (int) Math.pow(2, input.length()); i++ ){
            
            String element = "";
            int arrayIndex = 0;
            
            for(int k = input.length() - 1; k>0; k--){
                String index = ((i >> k) & 1) == 1 ? "1" : "0";
                
                if(index == "1"){
                    element +=input.charAt(arrayIndex);
                }
                
                arrayIndex++;
            }
            System.out.println(element);
        }
        
    }
    
}
