
 
package javaapplication1;

public class JavaApplication1 {
    static int[] a  = {1,2,3,4,5,6,7};
    static int [] b = {5,4,3,8,9,1,0};
    static int [] c = new int[4];
    
     
    public static void main(String[] args) {
        // TODO code application logic here
        
        for(int i=0; i<a.length; i++){
            for(int j=0; j<b.length; j++){
                if(a[i] == b[j]){
                    c[j] = a[i];
                }
            }
        }
        
        for(int d=0; d<c.length; d++){
        System.out.println("The intersection of the two numbers is:  " + c[d]);
        }
    }
    
}
