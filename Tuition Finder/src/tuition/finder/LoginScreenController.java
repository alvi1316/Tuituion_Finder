package tuition.finder;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginScreenController implements Initializable {

    private TuitionFinder tuitionFinder;
    @FXML
    private Label wrongpassword;
    @FXML
    private Label mainLabel;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                mainLabel.requestFocus();

    }    

    @FXML
    private void showSignupPage(ActionEvent event) throws IOException{
            tuitionFinder.signUpStage();
    }


    void setTuitionFinder(TuitionFinder tuitionFinder) {
        this.tuitionFinder = tuitionFinder;
        
    }

    @FXML
    private void forgotPasswordPressed(ActionEvent event) throws IOException {
        
        tuitionFinder.recoverScreen();
    }

    @FXML
    private void loginButton(ActionEvent event) throws IOException {
        try{
            try {
                
                Boolean a = Database.checkUsernamePassword(username.getText(), password.getText());
                if(a==true){
                    tuitionFinder.alt(username.getText());
                }
                else{
                    wrongpassword.setVisible(true);
                }
                
                
            } catch (SQLException ex) {
                wrongpassword.setVisible(true);
                System.out.println(ex);
            }
            
        }
        catch(IOException e){
            wrongpassword.setVisible(true);
            System.out.println(e);
        }
        
    }
    
}
