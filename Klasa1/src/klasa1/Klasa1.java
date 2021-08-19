
package klasa1;
// TO CONNECT TO  SERVER TO DATABASE YOU HAVE TO IMPORT THE FOLLOWING LIBEARY
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// TO USE RESULT STATEMENT TO RUN OUR RESULT SET IN ORDER TO EXECUTE QUERY
import java.sql.Statement;

// LIBRERY TO HOLD SQL STATEMENT
import java.sql.ResultSet;

// LIBRARY YO DISPLAY MESAGE
import javax.swing.JOptionPane;

public class Klasa1 {

    
    
    public static void main(String[] args) {
       
        
        // TO CONNECT THREEE THINGS ARE REQUIRED
        //1) HOST 2) SERVER 2) PORT NUMBER 3) DATABASE USERNAME AND PASSWORD
        
        // default ip address = 127:0:0:1;
        // FOR HOST WE NEED SERVER PORT NUMBER AND DATABASE NAME
        
        
        //TRY AND CATCH FORMAT
        try{
        String host = "jdbc:derby://localhost:1527/STUD";
        String uName = "Daniel";
        String uPass = "12345";
        
        
        // WE WILL THEN USE CONNECTION TO CONNECT AND PICK THE CONNECTION THAT WILL CONTAIN THREE VARIABLE AS SPECIFIED IN THE 
        Connection con = DriverManager.getConnection(host, uName, uPass);
        
        // CREATE STATEMENT TO WRITE QUERY
        Statement stm = con.createStatement();
        String sql = "SELECT * FROM STUD";
        
        //SELECT MUST SHOW US RESULT AND TO SEE RESULT WE HAVE A CLASS THAT HOLDS RESULT AND IT MUST BE IMPORTED 
        //THEN WE CREATE AN OBJECT OF THE RESULT SET AND SET THE STATEMENT TO EXECUTE OUR QUERY
        //RESULT SET IS A POINTER TO A TABLE AND CAN HELP TO MOVE FROM ONE RECORD TO ANOTHER USING "NEXT", "FIRST", "LAST", "PREVIOUS", "ABSOLUTE"(a Particular record)
        ResultSet rs = stm.executeQuery(sql);
        
        
        //TO LOOP THROUGH ALL THE RECORDS IN THE TABLE
        while(rs.next()  ){
        int mat1 = rs.getInt("MAT");
        String sur = rs.getString("SURNAME");
        String dept1 = rs.getString("DEPT");
        float gpa1 = rs.getFloat("GPA");
        
        //TO PRINT NOW WE USE
        String p = mat1 + " " + sur + " " + dept1 + " " + gpa1;
        
        System.out.println(p);
        
        }
        
        }catch(SQLException err){
           // JOptionPane.showMessageDialog(Klasa1.this, err.getMessage());
           
           System.out.println(err.getMessage());
        }
        
    }
    
}
