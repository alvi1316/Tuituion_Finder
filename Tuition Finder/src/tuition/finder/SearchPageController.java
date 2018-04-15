
package tuition.finder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;


public class SearchPageController implements Initializable {

    @FXML
    private Button search;
    @FXML
    private Hyperlink usernametext;
    @FXML
    private AnchorPane scrollpane;
    @FXML
    private Button loadmore;
    @FXML
    private AnchorPane root;
    @FXML
    private AnchorPane followScrollPane;
    private AnchorPane temppane;
    
    TuitionFinder tuitionFinder;
    @FXML
    private TextField searchtext;

    public void setTuitionFinder(TuitionFinder tuitionFinder) {
        this.tuitionFinder = tuitionFinder;
    }


    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        
        
        usernametext.setText(TuitionFinder.username);
        
        FileInputStream input = null;
        try {
            input = new FileInputStream("Icons/favicon.jpg");
            Image image = new Image(input);
            search.setGraphic(new ImageView(image));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    public void init(){
        int y=0;
        try {
            List<FollowInfo> followinfo = Database.searchResult(TuitionFinder.search);
            for(FollowInfo q : followinfo ){
                ProInfo p = Database.getProfile(q.getName());
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource("SearchComp.fxml"));
                AnchorPane root = loader.load();
                SearchCompController con = loader.getController();
                con.setTuitionfinder(tuitionFinder);
                con.setUsernametext(p.getUserName());
                con.setEmailtext(p.getUserEmail());
                con.setInstitutetext(p.getUserInstitute());
                con.setLocationtext(p.getAddress());
                con.setphonetext(Integer.toString(p.getUserPhone()));
                con.setSextext(p.getUserSex());
                root.setLayoutX(0);
                root.setLayoutY(0+y);
                scrollpane.getChildren().add(root);
                y=y+101;
                
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        
        
        
        
    }
    public void setFollow(){
        try {
            int y = 0;
            List<FollowInfo> followinfo = Database.getFollowInfo();
            for (int i=followinfo.size()-1;i>=0;i--){
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource("FollowComp.fxml"));
                
                try {
                    temppane = loader.load();
                    temppane.setLayoutX(0);
                    temppane.setLayoutY(5+y);
                    FollowCompController con = loader.getController();
                    con.setTuitionfinder(tuitionFinder);
                    con.setFollowCompText(followinfo.get(i).getName());
                    followScrollPane.getChildren().add(temppane);
                    y=y+48;
                } catch (IOException ex) {
                    Logger.getLogger(SelfStatusPageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        } catch (SQLException ex) {
            Logger.getLogger(SelfStatusPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searchEnterPressed(KeyEvent event) {
    }

    @FXML
    private void userNamePressed(ActionEvent event) throws IOException {
        tuitionFinder.selfStatusScreen();
    }

    @FXML
    private void homePressed(ActionEvent event) throws IOException {
        tuitionFinder.homePage();
    }

    @FXML
    private void logoutPressed(ActionEvent event) {
    }

    @FXML
    private void loadmorePressed(ActionEvent event) {
        scrollpane.setMinHeight(scrollpane.getHeight()+1011);
        loadmore.setLayoutY(scrollpane.getMinHeight()-50);
    }

    @FXML
    private void searchButtonPressed(ActionEvent event) throws IOException {
        TuitionFinder.search = searchtext.getText();
        tuitionFinder.searchPage();
    }

    @FXML
    private void settingsPressed(ActionEvent event) throws IOException {
        tuitionFinder.profileScreen(TuitionFinder.username);
    }
    
}
