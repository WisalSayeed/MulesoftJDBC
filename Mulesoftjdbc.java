import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class Mulesoftjdbc {
   static final String DB_URL = "jdbc:sqlite:moviedb.db";
   static final String QUERY = "SELECT mname, actor, actress, director, yearofrel FROM Movies";

   public static void main(String[] args) {
      try{
        Class.forName("org.sqlite.JDBC");
          Connection conn = DriverManager.getConnection(DB_URL);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);
         System.out.println("Inserting records into the table...");          
         String sql = "INSERT INTO Movies VALUES ('Batman','Christian Bale','Anne Hatheway','Christopher Nolan',2012)";
         stmt.executeUpdate(sql);
         sql = "INSERT INTO Movies VALUES ('The Batman','Robert Pattison','Seline Kyle','Matt Reeves',2022)";
         stmt.executeUpdate(sql);
         sql = "INSERT INTO Movies VALUES ('KGF 2', 'Yash', 'Sreenidhi','Prashant',2022)";
         stmt.executeUpdate(sql);
         System.out.println("Inserted records into the table..."); 
         
         while(rs.next()){
            System.out.print("Movie: " + rs.getString("mname"));
            System.out.print(", Actor " + rs.getString("actor"));
            System.out.print(", Actress " + rs.getString("actress"));
            System.out.println(", Director " + rs.getString("director"));
            System.out.println(", Year Of Release "+ rs.getInt("yearofrel"));
         }

        }catch (Exception e) {
         e.printStackTrace();
      } 
   }
}