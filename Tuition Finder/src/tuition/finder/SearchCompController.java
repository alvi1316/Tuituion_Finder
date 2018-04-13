
package tuition.finder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.text.Text;


public class SearchCompController implements Initializable {

    @FXML
    private Hyperlink usernametext;
    @FXML
    private Text institutetext;
    @FXML
    private Text locationtext;
    @FXML
    private Text sextext;
    @FXML
    private Text phonetext;
    @FXML
    private Text emailtext;
    
    TuitionFinder tuitionfinder;

    

    public void setTuitionfinder(TuitionFinder tuitionfinder) {
        this.tuitionfinder = tuitionfinder;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    public String getEmailtext() {
        return emailtext.getText();
    }

    public void setEmailtext(String emailtext) {
        this.emailtext.setText(emailtext);
    }
    
    
    public String getInstitutetext() {
        return institutetext.getText();
    }

    public void setInstitutetext(String institutetext) {
        this.institutetext.setText(institutetext);
    }
    
    public String getLocationtext() {
        return locationtext.getText();
    }

    public void setLocationtext(String locationtext) {
        this.locationtext.setText(locationtext);
    }
    
    public String getSextext() {
        return sextext.getText();
    }

    public void setSextext(String sextext) {
        this.sextext.setText(sextext);
    }
    
    public String getPhonetext() {
        return phonetext.getText();
    }

    public void setphonetext(String phonetext) {
        this.phonetext.setText(phonetext);
    }
    public String getUsernametext() {
        return usernametext.getText();
    }

    public void setUsernametext(String usernametext) {
        this.usernametext.setText(usernametext);
    }

    @FXML
    private void usernamePressed(ActionEvent event) throws IOException {
        tuitionfinder.viewProfileScreen(usernametext.getText());
    }
    
}
