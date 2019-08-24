
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DatabaseOperations 
{
    Connection conn = null;
    Statement statement = null;
    
    private String filePath = "C:/sqlite/";
    private String dbFileName = "dates";
    private String extension = ".db";
    
    
    
    public DatabaseOperations() {
        
        String url = "jdbc:sqlite://" + filePath + dbFileName + extension;
        
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        }
        
        try {
            conn = DriverManager.getConnection(url);     
            System.out.println("Connection Successful");
        } catch (SQLException ex) {
            ex.getMessage();
        }
               
    }
    
    public void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS 'data'('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'examName' TEXT,'examDate' TEXT)";
        
        try {
            statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
     
    public void addData(String examName , String date) {
       
        String query = "INSERT INTO 'data'(examName,examDate) VALUES('"+examName+"','"+date+"')"; //('examName','date')       
        
        try {
            statement =  conn.createStatement();
            
            statement.executeUpdate(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    public ArrayList<Data> getData() {
        
        String query = "SELECT * FROM data";
        ArrayList<Data> dataList = new ArrayList<>();
        
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next())
            {
                String examName = rs.getString("examName");
                String examDate = rs.getString("examDate");
                
                dataList.add(new Data(examName,examDate));
            }
            
            return dataList;
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
       
    }
}
