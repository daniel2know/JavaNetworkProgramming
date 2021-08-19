
package hashset;
import java.util.HashSet;
import java.util.*;


public class Hashset {
public static HashSet<HashSet<Character>> store = new HashSet<>();
public static HashSet<HashSet<Character>> query = new HashSet<>();
public static HashSet<HashSet<Character>> dbstring = new HashSet<>();
public static Scanner scan = new Scanner(System.in);
    
    public void powerSet(String str, int index, String curr) {
        int n = str.length();

        if (index == n) {
            System.out.println(curr);
            HashSet<Character> set = new HashSet<>();
            for(char c: curr.toCharArray()) {
                set.add(c);
            }
            if (set.size() > 0)
                store.add(set);
            return;
        }

        powerSet(str, index + 1, curr + str.charAt(index));
        powerSet(str, index + 1, curr);
    }
    
    public void clearHashSet(){
        store.clear();
    }
    
    public void compare(HashSet<HashSet<Character>> Q, HashSet<HashSet<Character>> DBS){
        HashSet<HashSet<Character>> intersection = new HashSet<>(Q);
        HashSet<HashSet<Character>> union = new HashSet<>(Q);
        intersection.retainAll(DBS);
        union.addAll(DBS);
        
        float ic = intersection.size();
        // float uc = union.size();
        
        System.out.println(ic/Q.size());
    }
    
    public static void main(String[] args) {
        System.out.print("Enter query string: ----->   :     ");
         String str = scan.next();
         int index = 0;
         String curr = "";
         Hashset set = new Hashset();
         set.powerSet(str, index, curr);
         query = new HashSet<>(store);
         System.out.println(query);
        
        set.clearHashSet();
        
        System.out.print("Enter dbstring string: ----->   :     ");
         String str1 = scan.next();
         int index1 = 0;
         String curr1 = "";
         set.powerSet(str1, index1, curr1);
         dbstring = new HashSet<>(store);
        System.out.println(dbstring);  
        
        set.compare(query, dbstring);
    }
    
}
