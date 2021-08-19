
package profassignmentudp;
import java.net.DatagramSocket;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.*;
import java.io.*;
import java.util.*;


public class ServerUDP {
    public static int N = 1024;
    
    
    
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
    
    public static   String colour( int selectedIndex){
        colours.add("_ P P _ _  _ R _ _ N");
        colours.add("A _ _ I _ O T");
        colours.add("A _ U _ R _ M _ N _");
        colours.add("P _ A _ _ ");
        colours.add("G _ L _");
        colours.add("P _ N _");
        colours.add("_ _ O _ _ T");
        colours.add("L _ _ _ I _ O _");
        colours.add("R _ _ Y");
        colours.add("B _ _ _ N");
        
      
        
        myselectedColourtwo = mySelectedColourIndex ;
        
        
        String colourResult = colours.get(myselectedColourtwo);
        return colourResult;
        
     }
    
    private static  String gamestat(){
        String res;
        res = " You answered "+ pointCorrect + " correctly and "+ pointNotCorrect + " wrongly Out of " + totalAmountOFTimePlayed;
        return res;
    }
    
    public static  String colourAnswer( int selectedIndex){
        coloursAns.add("APPLEGREEN");
        coloursAns.add("APRICOT");
        coloursAns.add("AQUAMARINE");
        coloursAns.add("PEACH");
        coloursAns.add("GOLD");
        coloursAns.add("PINK");
        coloursAns.add("VIOLET"); 
        coloursAns.add("LOLLIPOP");
        coloursAns.add("RUBY");
        coloursAns.add("BROWN");
        
      
        
        String colourAnswerHint = coloursAns.get(myselectedColourtwo);
        return colourAnswerHint;
        
     }
    
    
    public static String colourHint( int selectedIndex){
        coloursHint.add(" Something you eat and it has a nigeria colour in it");
        coloursHint.add(" just think of the colour........");
        coloursHint.add(" Lyk water and a machine inside water with its first three letters removed");
        coloursHint.add(" Lyk a thing used for sport games between two teams");
        coloursHint.add(" Lyk a thing given to an athlete that came first");
        coloursHint.add("Just think of what the colour is.........");
        coloursHint.add(" Just think of what the colour is.......");
        coloursHint.add(" Lyk one of the names of an android version....");
        coloursHint.add(" Lyk one of the name of a programming language");
        coloursHint.add(" Just think of the colour.........");
        
        String colourResultHint = coloursHint.get(myselectedColourtwo);
        
        
        return colourResultHint;
        
     }
    
    public static void main(String[] args) {
     
         byte[] sendPacket = new byte[N];
         byte[] recievePacket = new byte[N];
        
        
        try{
            
            DatagramSocket ds = new DatagramSocket(4567);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // first we get the port number from the client and we get the inet address using the get address function
            
            
            DatagramPacket dp1 = new DatagramPacket(recievePacket, recievePacket.length);
            ds.receive(dp1);
            InetAddress ip1 = dp1.getAddress();
            int port1 = dp1.getPort();
            System.out.println("Client ip = "+ ip1 + "client port number = "+port1);
            String s1 = new String(dp1.getData());
            System.out.println("Message from client : "+ s1);
            
            
            
            
            String s2 = "Lets play a colour name, enter the number of times of you want to play if you get above average the number of times you played then you can move on to the next stage else you will repeat this stage";
            sendPacket = s2.getBytes();
            
            DatagramPacket dp2 = new DatagramPacket(sendPacket,sendPacket.length,ip1,port1);
            ds.send(dp2);
            byte[] recievePackettwo = new byte[N];
            DatagramPacket dp3 = new DatagramPacket(recievePackettwo, recievePackettwo.length);
            ds.receive(dp3);
            String s3 = new String(dp3.getData());
            System.out.println(s3);
            int num = Integer.parseInt(s3);
            System.out.println(s3.length());
            
            String s4;
            String s5;
            String s6;
            String Ans;
            String s7;
            String s8;
            String s12;
            
            for (int i = 0; i < num; i++) {

                         Random x = new Random();
                         mySelectedColourIndex = x.nextInt(9);

                         s4 = colour(mySelectedColourIndex);
                         s5 = colourHint(mySelectedColourIndex);
                       
                         sendPacket = s4.getBytes();
                         DatagramPacket dp4 = new DatagramPacket(sendPacket, sendPacket.length, ip1, port1);
                         ds.send(dp4);
                         
                         sendPacket = s5.getBytes();
                         DatagramPacket dp5 = new DatagramPacket(sendPacket, sendPacket.length, ip1, port1);
                         ds.send(dp5);
                         
                         DatagramPacket dp6 = new DatagramPacket(recievePacket, recievePacket.length);
                         ds.receive(dp6);
                         s6 = new String(dp1.getData());

                         System.out.println("message form client: " + s6);

                         Ans = colourAnswer(mySelectedColourIndex);

                         if (s6.equals(Ans)) {
                             s7 = " Message form client:  Correct you have a point";
                             sendPacket = s7.getBytes();
                             DatagramPacket dp7 = new DatagramPacket(sendPacket, sendPacket.length, ip1, port1);
                             ds.send(dp7);
                             pointCorrect += 1;
                         } else {
                             s7 = " Message form server: Wrong you lost a point";
                             sendPacket = s7.getBytes();
                             DatagramPacket dp7 = new DatagramPacket(sendPacket, sendPacket.length, ip1, port1);
                             ds.send(dp7);
                             pointNotCorrect += 1;
                         }

                     }
            
                     s8 = gamestat();
                     
                             sendPacket = s9.getBytes();
                             DatagramPacket dp8 = new DatagramPacket(sendPacket, sendPacket.length, ip1, port1);
                             ds.send(dp8);
                             
                             sendPacket = s10.getBytes();
                             DatagramPacket dp9 = new DatagramPacket(sendPacket, sendPacket.length, ip1, port1);
                             ds.send(dp9);
                             
                             sendPacket = s11.getBytes();
                             DatagramPacket dp10 = new DatagramPacket(sendPacket, sendPacket.length, ip1, port1);
                             ds.send(dp10);
                             
                             sendPacket = s8.getBytes();
                             DatagramPacket dp11 = new DatagramPacket(sendPacket, sendPacket.length, ip1, port1);
                             ds.send(dp11);
                     
                     
                     if (pointCorrect > (totalAmountOFTimePlayed / 2)) {
                         s12 = "Welcome to the next stage....";
                         sendPacket = s8.getBytes();
                         DatagramPacket dp12 = new DatagramPacket(sendPacket, sendPacket.length, ip1, port1);
                         ds.send(dp12);
                     } else {
                         s12 = "Oh no you are not qualified for the next stage...";
                         sendPacket = s12.getBytes();
                         DatagramPacket dp13 = new DatagramPacket(sendPacket, sendPacket.length, ip1, port1);
                         ds.send(dp13);
                     }
            
            
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
}
