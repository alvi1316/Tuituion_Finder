
package tuition.finder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
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
    
    TuitionFinder tuitionFinder;

    

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
        try{
            
            ProInfo p = Database.getProfile(TuitionFinder.search);
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
            root.setLayoutY(0);
            scrollpane.getChildren().add(root);
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Failed");
            alert.setHeaderText("Sorry could't find User");
            alert.setContentText("Search Again Using Valid Name!");
            alert.showAndWait();
            System.out.println(e);
            System.out.println(e);
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
    
}
