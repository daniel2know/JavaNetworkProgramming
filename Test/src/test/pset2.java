package test;
import java.util.*;

public class pset2 {

    static String res;
    public static ArrayList<String> store = new ArrayList<>();
    public static ArrayList<String> store1 = new ArrayList<>();
    public static ArrayList<String> store2 = new ArrayList<>();
    public static Set<String> set1;
    public static int length = 0;
    
    static Scanner scan = new Scanner(System.in);

    public void powerSet(String str, int index, String curr) {
        int n = str.length();

        if (index == n) {
            System.out.println(curr);
            store.add(curr);
            return;
        }

        powerSet(str, index + 1, curr + str.charAt(index));
        powerSet(str, index + 1, curr);
    }

    public void saveIntoAnother(ArrayList<String> save) {
         
        for (int i = 0; i < store.size(); i++) {
            if (i == (store.size() - 1)) {
                continue;
            }
            save.add(store.get(i));
        }
         set1 = new HashSet<>(save);
         save.clear();
         save.addAll(set1);
    }

    public void printArray(ArrayList<String> savedList) {
        System.out.println("--------------------------------");
        for (int i = 0; i < savedList.size(); i++) {
            System.out.println(savedList.get(i));
        }
        System.out.println("--------------------------------");
    }

    public void clearArrayList() {
        store.clear();
    }
    
    public void compare(ArrayList<String> Aone, ArrayList<String> Atwo) {
        try {
            int sum = 0;
            float total = 0;
//             float res = (float) 0.0;
//             boolean isOut = false;
//             if (Aone.size() < Atwo.size()) {
//
//                 for (int i = 0; i < Aone.size(); i++) {
//                     for (int j = 0; j < Atwo.size(); j++) {
//                         if (i ==0 ) {
//                             if (Aone.get(i).matches(Atwo.get(j))) {
//                                 sum = sum + 1;
//                                 System.out.println(Aone.get(i));
//                                 length = Aone.size();
//                             }
//
//                         } else {
//                             break;
//                         }
//
//                     }
//
//                 }
//
//             } else if (Aone.size() > Atwo.size()) {
//                 for (int i = 0; i < Atwo.size(); i++) {
//                     for (int j = 0; j < Aone.size(); j++) {
//                         if (i == 0) {
//                             if (Atwo.get(i).matches(Aone.get(j))) {
//                                 sum = sum + 1;
//                                 length = Atwo.size();
//                             }
//
//                         } else {
//                             break;
//                         }
//
//                     }
//
//                 }
//             } else {
//                 for (int i = 0; i < Atwo.size(); i++) {
//                     for (int j = 0; j < Aone.size(); j++) {
//                         if (i == 0) {
//                             if (Atwo.get(i).matches(Aone.get(j))) {
//                                 sum = sum + 1;
//                                 length = Atwo.size();
//                             }
//
//                         } else {
//                             break;
//                         }
//
//                     }
//
//                 }
//             }
//
//             if (sum == 0) {
//                 System.out.println("Nothing found...........");
//             }

//             res = sum / length;
//             System.out.println(sum);
//             System.out.println(length);
//             double total = (Math.round(res * 100.0)/100.0) * 100;
//             System.out.println(total);
            

                if(Atwo.size() == Aone.size()){
                    for(int i =0; i< Aone.size(); i++){
                        for(int j =0; j< Atwo.size(); j++){
                            if(i != Aone.size() +1){
                                if(Aone.get(i).equals(Atwo.get(j))){
                                    sum+=1;
                                }
                            }
                        }
                    }
                    length = Aone.size();
                }
                
                
                
                if(Atwo.size() > Aone.size()){
                    for(int i =0; i< Aone.size(); i++){
                        for(int j =0; j< Atwo.size(); j++){
                            if(i != Aone.size() +1){
                                if(Aone.get(i).equals(Atwo.get(j))){
                                    sum+=1;
                                }
                            }
                        }
                    }
                    length = Atwo.size() - Aone.size();
                }
                

        System.out.println(sum);
        System.out.println(length);
        System.out.println(Aone.size());
        System.out.println(Atwo.size());
        total = (float) sum / length;
        System.out.println(total);

    }
    catch (Exception ex) {
             System.out.println(ex.getMessage());
    }
}



public static void main(String[] args) {
         System.out.print("Enter any string: ----->   :     ");
         String str = scan.next();
         int index = 0;
         String curr = "";
         pset2 pset = new pset2();
         pset.powerSet(str, index, curr);
         
         System.out.println("--------------------------");
//         res = res.substring(4, res.length());
//         System.out.println(res);

           pset.saveIntoAnother(store1);
           pset.printArray(store1);
           
           pset.clearArrayList();
           
         String strTwo;
         System.out.print("Enter any string: ----->   :     ");
         strTwo = scan.next();
         
         pset.powerSet(strTwo, index, curr);
         pset.saveIntoAnother(store2);
         pset.printArray(store2);


         pset.compare(store1, store2);
     }
    

}

