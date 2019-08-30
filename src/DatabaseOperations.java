
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DatabaseOperations 
{
    Connection conn = null;
    Statement statement = null;
    PreparedStatement preStatement = null;
    
    private String filePath = "C:/sqlite/";
    private String dbFileName = "exams";
    private String extension = ".db";
    
    public DatabaseOperations() {
      
        File file = new File("C:\\sqlite");        
        if (!file.exists()) 
            file.mkdir();             
            
        
        String url = "jdbc:sqlite://" + filePath + dbFileName + extension;
        
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        }
        
        try {
            conn = DriverManager.getConnection(url);     
            //System.out.println("Connection Successful");
        } catch (SQLException ex) {
            ex.getMessage();
        }
               
    }
    
    public void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS 'exams'('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'examName' TEXT,'examDate' TEXT)";
        
        try {
            statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
     
    public void addData(String examName , String date) {
       
        String query = "INSERT INTO 'exams'(examName,examDate) VALUES('"+examName+"','"+date+"')"; //('examName','date')       
        
        try {
            statement =  conn.createStatement();
            
            statement.executeUpdate(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    public ArrayList<Data> getData() {
        
        String query = "SELECT * FROM exams";
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
    
    
    public void deleteData(String examName)
    {
        String query = "DELETE FROM 'exams' where examName = ?";
        
        try {
            
            preStatement = conn.prepareStatement(query);
            preStatement.setString(1, examName);
            preStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
          
    
    public void updateData(String examName , String examDate,String currentExamName)
    {
        String query = "UPDATE 'exams' SET examName = ? , examDate = ? where examName = ?";
       
        try {
            
            preStatement = conn.prepareStatement(query);
            
            preStatement.setString(1, examName);
            preStatement.setString(2, examDate);
            preStatement.setString(3, currentExamName);
            
            preStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        DatabaseOperations databaseOperations = new DatabaseOperations();
    }
}
