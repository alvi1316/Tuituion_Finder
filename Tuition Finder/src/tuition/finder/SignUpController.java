package tuition.finder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;


public class SignUpController implements Initializable {

    TuitionFinder tuitionfinder;
    @FXML
    private MenuButton agebutton;
    @FXML
    private MenuButton sex;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gotoLogin(ActionEvent event) throws IOException {
        tuitionfinder.logInStage();
    }

    public void setTuitionfinder(TuitionFinder tuitionfinder) {
        this.tuitionfinder = tuitionfinder;
    }

    @FXML
    private void ageOne(ActionEvent event) {
        agebutton.setText("18-22");
    }

    @FXML
    private void ageTwo(ActionEvent event) {
        agebutton.setText("23-27");
    }

    @FXML
    private void ageThree(ActionEvent event) {
        agebutton.setText("28-35");
    }

    @FXML
    private void malePressed(ActionEvent event) {
        sex.setText("Male");
    }

    @FXML
    private void femailPressed(ActionEvent event) {
        sex.setText("Female");
    }

    @FXML
    private void finishPressed(ActionEvent event) throws IOException {
        tuitionfinder.homePage();
    }
    
    
    
}
