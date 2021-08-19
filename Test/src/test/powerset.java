
package test;
import java.util.*;

public class powerset {
    
    public static void main(String[] args){
        
        String st[] = {"x", "y", "z"};
        LinkedHashSet hashSet = new LinkedHashSet();
        int len = st.length;
        int element = (int) Math.pow(2, len);
        for(int i =0; i<element; i++){
            String str = Integer.toBinaryString(i);
            int value = str.length();
            String pset = str;
            for(int k = value; k< len; k++){
                pset = "0" + pset;
            }
            LinkedHashSet Set = new LinkedHashSet();
            for(int j =0; j < pset.length(); j++){
                if(pset.charAt(j) == '1')
                    Set.add(st[j]);
            }
            hashSet.add(Set);
        }
        System.out.println(hashSet.toString());
        
    }
    
}
