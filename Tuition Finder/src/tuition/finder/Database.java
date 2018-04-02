package tuition.finder;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    
    public static void makeFolder(String str){
        
        File file = new File("Users\\"+str);
        if(!file.exists()){
            file.mkdir();
        }
    }
    public static void makeDb(String name,String password,String email,String username,int mobileNum,int parentNum,String age,String sex,String address,String institute,double cgpa,double ssccg,double hsccg,String description){    
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Users\\"+username+"\\"+username+".db");
            String sql = "CREATE TABLE IF NOT EXISTS profile " + "(" 
                    + "name string,"
                    + "password string,"
                    + "email string,"
                    + "username string,"
                    + "mobileNum integer,"
                    + "parentNum integer,"
                    + "age string,"
                    + "sex string,"
                    + "address string," 
                    + "institute string,"
                    + "cgpa double,"
                    + "ssccg double,"
                    + "hsccg double,"
                    + "description string"
                    + ");";
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            String insertQuery = String.format("INSERT INTO profile(name,password,email,username,mobileNum,parentNum,age,sex,address,institute,cgpa,ssccg,hsccg,description) VALUES ('%s','%s','%s','%s',%d,%d,'%s','%s','%s','%s',%f,%f,%f,'%s')",name,password,email,username,mobileNum,parentNum,age,sex,address,institute,cgpa,ssccg,hsccg,description);
            stmt.executeUpdate(insertQuery);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void makeUsernamePassword(String username,String password){
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Users\\Usernames\\usernames.db");
            Statement stmt = conn.createStatement();
            String str = "create table if not exists usernames (username string,password string);";
            stmt.execute(str);
            String insertQuery = String.format("INSERT INTO usernames(username,password)Values('%s','%s')",username,password);
            stmt.executeUpdate(insertQuery);
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    public static boolean checkUsernamePassword(String username,String password) throws SQLException{
        
        Connection conn = DriverManager.getConnection("jdbc:sqlite:Users\\Usernames\\usernames.db");
        Statement stmt = conn.createStatement();
        String str = String.format("SELECT password FROM usernames WHERE username = '%s'",username);
        ResultSet rs = stmt.executeQuery(str);
        return rs.getString("password").equals(password);
    }
    
    public static boolean checkUsername(String username){
        
        String s = new String();
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Users\\Usernames\\usernames.db");
            Statement stmt = conn.createStatement();
            String str = String.format("SELECT username FROM usernames WHERE username = '%s'",username);
            ResultSet rs = stmt.executeQuery(str);
            s = rs.getString("username");
            System.out.println(s);
        } catch (SQLException ex) {
            
        }
        return s.equals(username);
    }
}