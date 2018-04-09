
package tuition.finder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class EditProfileInformationController implements Initializable {
    
    TuitionFinder tuitionFinder;

    public void setTuitionFinder(TuitionFinder tuitionFinder) {
        this.tuitionFinder = tuitionFinder;
    }
    private String n;

    public void setN(String n) {
        this.n = n;
    }
    

    @FXML
    private TextArea userDescription;
    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;
    @FXML
    private TextField name;
    @FXML
    private TextField userName;
    @FXML
    private TextField userPhone;
    @FXML
    private TextField userEmail;
    @FXML
    private TextField userInstitute;
    @FXML
    private TextField userCGPA;
    @FXML
    private TextField userSscCg;
    @FXML
    private TextField userHscCg;
    @FXML
    private MenuButton userAge;
    @FXML
    private MenuButton userSex;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void homePressed(ActionEvent event) throws IOException {
        tuitionFinder.homePage(n);
    }
    
}
