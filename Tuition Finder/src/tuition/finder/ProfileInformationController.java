
package tuition.finder;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ProfileInformationController implements Initializable {


    public ProfileInformationController() {
    }
    
    
    
    
    TuitionFinder tuitionFinder;

    

    @FXML
    private Text name;
    @FXML
    private Text userEmail;
    @FXML
    private Text userInstitute;
    @FXML
    private Text userPhone;
    @FXML
    private Text userName;
    @FXML
    private Text userAge;
    @FXML
    private Text userSex;
    @FXML
    private Text userCGPA;
    @FXML
    private Text userSscCg;
    @FXML
    private Text userHscCg;
    @FXML
    private TextArea userDescription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setTuitionFinder(TuitionFinder tuitionFinder) {
        this.tuitionFinder = tuitionFinder;
    }

    public void setName(String name) {
        this.name.setText(name);
        
    }
    public void setEverything(){
        try {
            ProInfo p = Database.getProfile(name.getText());
            name.setText(p.getName());
            userEmail.setText(p.getUserEmail());       
            userInstitute.setText(p.getUserInstitute());
            userPhone.setText(Integer.toString(p.getUserPhone()));
            userName.setText(p.getUserName());
            userAge.setText(p.getUserAge());
            userSex.setText(p.getUserSex());
            userCGPA.setText(Double.toString(p.getUserCGPA()));
            userSscCg.setText(Double.toString(p.getUserSscCg()));
            userHscCg.setText(Double.toString(p.getUserHscCg()));
            userDescription.setText(p.getUserDescription());
        } catch (SQLException ex) {
            Logger.getLogger(ProfileInformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void homePressed(ActionEvent event) throws IOException {
        tuitionFinder.homePage();
    }

    @FXML
    private void editButtonPressed(ActionEvent event) throws IOException {
        tuitionFinder.editProfileScreen(name.getText());
    }
    
}
