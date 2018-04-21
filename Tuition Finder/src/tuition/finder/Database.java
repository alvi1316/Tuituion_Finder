package tuition.finder;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

public class Database {
    
    public static void makeFolder(String str){
        
        File file = new File("Users\\"+str);
        if(!file.exists()){
            file.mkdir();
        }
    }
    public static void deleteTable(String username){
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Users\\"+username+"\\"+username+".db");
            String sql = "DELETE FROM profile";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
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
            conn.close();
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
            conn.close();
            
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
        boolean b=rs.getString("password").equals(password);
        conn.close();
        return b;
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
            conn.close();
        } catch (SQLException ex) {
            
        }
        
        return s.equals(username);
    }
    public static ProInfo getProfile(String username) throws SQLException{
        
        Connection conn = DriverManager.getConnection("jdbc:sqlite:Users\\"+username+"\\"+username+".db");
        Statement stmt = conn.createStatement();
        String query = String.format("select * from profile where username = '%s'",username);
        ResultSet rs = stmt.executeQuery(query);
        ProInfo p = new ProInfo();
        p.setName(rs.getString("name"));
        p.setPassword(rs.getString("password"));
        p.setUserEmail(rs.getString("email"));
        p.setUserName(rs.getString("username")); 
        p.setUserPhone(rs.getInt("mobileNum"));
        p.setParentNum(rs.getInt("ParentNum"));
        p.setUserAge(rs.getString("age"));
        p.setUserSex(rs.getString("sex"));
        p.setAddress(rs.getString("address"));
        p.setUserInstitute(rs.getString("institute"));
        p.setUserCGPA(rs.getDouble("cgpa"));
        p.setUserSscCg(rs.getDouble("ssccg"));
        p.setUserHscCg(rs.getDouble("hsccg"));
        p.setUserDescription(rs.getString("description"));
        conn.close();
        return p;
    }
    public static void writePost(String username,PostInfo p) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:sqlite:Users\\"+username+"\\"+username+".db");
        Connection conn2 = DriverManager.getConnection("jdbc:sqlite:Users\\Usernames\\usernames.db");
        String sql = "CREATE TABLE IF NOT EXISTS post " + "(" 
                    + "area string,"
                    + "time string,"
                    + "salary string,"
                    + "subtext string,"
                    + "ins string,"
                    + "class string,"
                    + "prefins string,"
                    + "posttime time,"
                    + "postdate date" 
                    + ");";
         String sql2 = "CREATE TABLE IF NOT EXISTS allpost " + "("
                    + "username string,"
                    + "area string,"
                    + "time string,"
                    + "salary string,"
                    + "subtext string,"
                    + "ins string,"
                    + "class string,"
                    + "prefins string,"
                    + "posttime time,"
                    + "postdate date" 
                    + ");";
        
        Statement stmt = conn.createStatement();
        Statement stmt2 = conn2.createStatement();
        stmt.execute(sql);
        stmt2.execute(sql2);
        String insertQuery = String.format("INSERT INTO post(area,time,salary,subtext,ins,class,prefins,posttime,postdate) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s')",p.getArea(),p.getTime(),p.getSalary(),p.getSubtext(),p.getIns(),p.getStuclass(),p.getPrefins(),p.getPosttime(),p.getPostdate());
        String insertQuery2 = String.format("INSERT INTO allpost(username,area,time,salary,subtext,ins,class,prefins,posttime,postdate) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",username,p.getArea(),p.getTime(),p.getSalary(),p.getSubtext(),p.getIns(),p.getStuclass(),p.getPrefins(),p.getPosttime(),p.getPostdate());
        stmt.executeUpdate(insertQuery);
        stmt2.executeUpdate(insertQuery2);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Post Successfull");
        alert.setHeaderText("");
        alert.setContentText("your post has been successfully posted");
        alert.showAndWait();
        conn.close();
        conn2.close();
    }
    
    public static List<PostInfo> getPostInfo(String username) throws SQLException {
		List<PostInfo> postinfo = new ArrayList<>();
		Connection conn = DriverManager.getConnection("jdbc:sqlite:Users\\"+username+"\\"+username+".db");
		try {
			String query = "select * from post order by postdate";
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				PostInfo p = new PostInfo();
				p.setArea(rs.getString("area"));
                                p.setTime(rs.getString("time"));
                                p.setSalary(rs.getString("salary"));
                                p.setSubtext(rs.getString("subtext"));
                                p.setIns(rs.getString("ins"));
                                p.setStuclass(rs.getString("class"));
                                p.setPrefins(rs.getString("prefins"));
                                p.setPosttime(rs.getString("posttime"));
                                p.setPostdate(rs.getString("postdate"));
				postinfo.add(p);
			}
		} catch (SQLException e) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("No Posts");
                        alert.setHeaderText("");
                        alert.setContentText("User Haven't Even Posted Anything Yet!");
                        alert.showAndWait();
		} finally {
			conn.close();
		}
                
		return postinfo;
	}
    public static List<FollowInfo> getFollowInfo() throws SQLException {
		List<FollowInfo> followinfo = new ArrayList<>();
		Connection conn = DriverManager.getConnection("jdbc:sqlite:Users\\"+TuitionFinder.username+"\\"+TuitionFinder.username+".db");
		try {
			String query = "select username from following";
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				FollowInfo p = new FollowInfo();
				p.setName(rs.getString("username"));
                                followinfo.add(p);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			conn.close();
		}
		return followinfo;
	}
    
    
    public static List<FollowInfo> searchResult(String search) throws SQLException{ 
        Connection con = DriverManager.getConnection("jdbc:sqlite:Users\\Usernames\\usernames.db");
        String query;
        if(search.length()<4){
            query = "SELECT username FROM usernames WHERE username LIKE '" + search + "%'";
        }else{
            query = "SELECT username FROM usernames WHERE username LIKE '%" + search + "%'";
        }
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        List<FollowInfo> searchinfo = new ArrayList<>();
        if(!rs.next()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Failed");
            alert.setHeaderText("Sorry could't find User");
            alert.setContentText("Search Again Using Valid Name!");
            alert.showAndWait();
        }else{
            do{
                FollowInfo p = new FollowInfo();
                p.setName(rs.getString("username"));
                searchinfo.add(p);
            }while(rs.next());
        }
        return searchinfo;
        
    }
    public static void writeFollow(String follow,String username) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:sqlite:Users\\"+username+"\\"+username+".db");
        String sql = "CREATE TABLE IF NOT EXISTS following " + "(" 
                    + "username string"
                    + ");";
        String insertQuery = String.format("INSERT INTO following(username)Values('%s')",follow);
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
        stmt.executeUpdate(insertQuery);
        conn.close();
    }
    
    public static boolean checkFollow(String follow,String username) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:sqlite:Users\\"+username+"\\"+username+".db");
        String query = "SELECT username FROM following WHERE username = '"+follow+"'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs.getString("username").equals(follow);
        
    }
    public static List<FollowInfo> getFollow(String username) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:sqlite:Users\\"+username+"\\"+username+".db");
        String query = "SELECT * FROM following";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        List<FollowInfo> followinfo = new ArrayList<>();
        while(rs.next()){
            FollowInfo p = new FollowInfo();
            p.setName(rs.getString("username"));
            followinfo.add(p);
        }
        conn.close();
        return followinfo;
        
    }
    public static List<PostInfo> getFollowPost(String username) throws SQLException{
        List<PostInfo> fp = new ArrayList<>();
        List<FollowInfo> followinfo = Database.getFollow(username);
        Connection conn = DriverManager.getConnection("jdbc:sqlite:Users\\Usernames\\usernames.db");
        String query = "SELECT * FROM allpost WHERE";
        int i=0;
        for (FollowInfo p : followinfo) {
            if(i==0){
                query = query + " username='"+p.getName()+"'";
            }
            else{
                query = query + " OR username='"+p.getName()+"'";
            }
            i++;
        }
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) 
        {
            PostInfo p = new PostInfo();
            p.setUsername(rs.getString("username"));
            p.setArea(rs.getString("area"));
            p.setTime(rs.getString("time"));
            p.setSalary(rs.getString("salary"));
            p.setSubtext(rs.getString("subtext"));
            p.setIns(rs.getString("ins"));
            p.setStuclass(rs.getString("class"));
            p.setPrefins(rs.getString("prefins"));
            p.setPosttime(rs.getString("posttime"));
            p.setPostdate(rs.getString("postdate"));
            fp.add(p);
	}
        conn.close();
        return fp;
    }
    
    public static List<PostInfo> customSearch(PostInfo p) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:sqlite:Users\\Usernames\\usernames.db");
        String query = "SELECT * FROM allpost WHERE";
        if(!p.getArea().equals("Area")){
            query = query + " area = '"+p.getArea()+"' OR";
        }
        if(!p.getIns().equals("Institute")){
            query = query + " ins = '"+p.getIns()+"' OR";
        }
        if(!p.getTime().equals("Time")){
            query = query + " time = '"+p.getTime()+"' OR";
        }
        if(!p.getStuclass().equals("Class")){
            query = query + " class = '"+p.getStuclass()+"' OR";
        }
        if(!p.getSalary().equals("Salary")){
            query = query + " salary = '"+p.getSalary()+"' OR";
        }
        if(!p.getSubtext().equals("")){
            query = query + " subtext = '"+p.getSubtext()+"' OR";
        }
        query = query.substring(0, query.length()-2);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        List<PostInfo> fp = new ArrayList<>();
        while (rs.next()) 
        {
            PostInfo pb = new PostInfo();
            pb.setUsername(rs.getString("username"));
            pb.setArea(rs.getString("area"));
            pb.setTime(rs.getString("time"));
            pb.setSalary(rs.getString("salary"));
            pb.setSubtext(rs.getString("subtext"));
            pb.setIns(rs.getString("ins"));
            pb.setStuclass(rs.getString("class"));
            pb.setPrefins(rs.getString("prefins"));
            pb.setPosttime(rs.getString("posttime"));
            pb.setPostdate(rs.getString("postdate"));
            fp.add(pb);
	}
        conn.close();
        return fp;
    }
    
    public static void deletePost(String username,String date,String time){
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Users\\Usernames\\usernames.db");
            Connection conn2 = DriverManager.getConnection("jdbc:sqlite:Users\\"+username+"\\"+username+".db");
            String del = "DELETE FROM allpost WHERE username = '"+username+"' AND postdate = '"+date+"' AND posttime = '"+time+"'";
            String del2 = "DELETE FROM post WHERE postdate = '"+date+"' AND posttime = '"+time+"'";
            Statement stmt = conn.createStatement();
            Statement stmt2 = conn2.createStatement();
            stmt.executeUpdate(del);
            stmt2.executeUpdate(del2);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Post Delete Successfull");
            alert.setHeaderText("");
            alert.setContentText("The post has been successfully deleted!");
            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
