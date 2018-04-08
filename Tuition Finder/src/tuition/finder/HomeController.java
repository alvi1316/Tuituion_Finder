
package tuition.finder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class HomeController implements Initializable {

    TuitionFinder tuitionFinder;
    @FXML
    private Hyperlink usernametext;

    public void setUsernametext(String usernametext) {
        this.usernametext.setText(usernametext);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Todo
    }    

    public void setTutionFinder(TuitionFinder tuitionFinder) {
        this.tuitionFinder = tuitionFinder;
    }

    @FXML
    private void logoutPressed(ActionEvent event) throws IOException {
        tuitionFinder.logInStage();
    }

    @FXML
    private void userNamePressed(ActionEvent event) throws IOException {
       
        tuitionFinder.profileScreen(usernametext.getText());
       
    }

    @FXML
    private void searchEnterPressed(KeyEvent event) throws IOException {
        if(event.getCode() == KeyCode.ENTER){
            tuitionFinder.profileScreen(usernametext.getText());
        }
    }

    
    
    
}
