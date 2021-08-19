
package deenassignment;
import java.util.*;
import java.net.*;
import java.io.*;

public class Server {
    
    static Scanner scan = new Scanner(System.in);
    static int myselectedColourtwo;
    static int mySelectedColourIndex;
    static int pointCorrect;
    static int pointNotCorrect;
    static int totalAmountOFTimePlayed;
    static String s9 = "---------------------------------";
    static String s10 = "Game is over and here is the statistics of the game";
    static String s11 = "--------------------------------------";

    
    public static ArrayList<String> colours = new ArrayList<>();
    public static ArrayList<String> coloursHint = new ArrayList<>();
    public static ArrayList<String> coloursAns = new ArrayList<>();
    
    public  String colour( int selectedIndex){
        colours.add("TMAE");
        colours.add("ESOL");
        
        
      
        
        myselectedColourtwo = mySelectedColourIndex ;
        
        
        String colourResult = colours.get(myselectedColourtwo);
        return colourResult;
        
     }
    
    private String gamestat(){
        String res;
        res = " You answered "+ pointCorrect + " correctly and "+ pointNotCorrect + " wrongly Out of " + totalAmountOFTimePlayed;
        return res;
    }
    
    public  void colourAnswer(){
        coloursAns.add("TEAM");
        coloursAns.add("EAT");
        coloursAns.add("AT");
        coloursAns.add("MAT");
        coloursAns.add("TEA");
        coloursAns.add("ME");
        coloursAns.add("MEAT"); 
        coloursAns.add("LOSE");
        coloursAns.add("SOLE");
        coloursAns.add("SOEL");
        coloursAns.add("SO");
        coloursAns.add("SOE");
         
        
     }
    
    
    public String colourHint( int selectedIndex){
        coloursHint.add(" Something you eat and it has a nigeria colour in it");
        coloursHint.add(" just think of the colour........");
        
        
        String colourResultHint = coloursHint.get(myselectedColourtwo);
        
        
        return colourResultHint;
        
     }
    
    public static void main(String[] args) {
        
        try{
            
            
            Server s = new Server();
            ServerSocket ss = new ServerSocket(6928);
            Socket sc = ss.accept();
            
            DataInputStream dis = new DataInputStream(sc.getInputStream());
            DataOutputStream dos = new DataOutputStream(sc.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            
            
            String s1 = "Lets play a colour name, enter the number of times of you want to play if you get above average the number of times you played then you can move on to the next stage else you will repeat this stage";
                     dos.writeUTF(s1);

                     String s2 = dis.readUTF();
                     totalAmountOFTimePlayed = Integer.parseInt(s2);
                     System.out.println("message form client: " + s2);
                     String s3;
                     String s4;
                     String s5;
                     String s6;
                     String Ans;
                     String s7;
                     String s8;

                     for (int i = 0; i < Integer.parseInt(s2); i++) {

                         Random x = new Random();
                         mySelectedColourIndex = x.nextInt(1);

                         s3 = s.colour(mySelectedColourIndex);
                         s4 = s.colourHint(mySelectedColourIndex);
                         dos.writeUTF(s3);
                         dos.writeUTF(s4);
                         s5 = dis.readUTF();
                         System.out.println("message form client: " + s5);
                         
                         s.colourAnswer();

                         for(int j = 0; j<coloursAns.size(); j++){
                             if(s5.equals(coloursAns.get(j))){
                                 s6 = " Message form client:  Correct you have a point";
                             dos.writeUTF(s6);
                             pointCorrect += 1;
                             }
                             else{
                                 s6 = " Message form server: Wrong you lost a point";
                             dos.writeUTF(s6);
                             pointNotCorrect += 1;
                             }
                         }

//                        s6 = " Message form client:  Correct you have a point";
//                        dos.writeUTF(s6);

                     }

                     s7 = s.gamestat();

                     dos.writeUTF(s9);
                     dos.writeUTF(s10);
                     dos.writeUTF(s11);
                     dos.writeUTF(s7);

                     if (pointCorrect > (totalAmountOFTimePlayed / 2)) {
                         s8 = "Welcome to the next stage....";
                         dos.writeUTF(s8);
                     } else {
                         s8 = "Oh no you are not qualified for the next stage...";
                         dos.writeUTF(s8);
                     }
            
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
}
