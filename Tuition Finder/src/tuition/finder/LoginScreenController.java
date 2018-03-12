package tuition.finder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class LoginScreenController implements Initializable {

    private TuitionFinder tuitionFinder;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showSignupPage(ActionEvent event) throws IOException{
            tuitionFinder.signUpStage();
    }


    void setTuitionFinder(TuitionFinder tuitionFinder) {
        this.tuitionFinder = tuitionFinder;
    }

    @FXML
    private void showHome(ActionEvent event) throws IOException {
        tuitionFinder.homePage();
    }

    @FXML
    private void forgotPasswordPressed(ActionEvent event) throws IOException {
        tuitionFinder.recoverScreen();
    }
    
}
