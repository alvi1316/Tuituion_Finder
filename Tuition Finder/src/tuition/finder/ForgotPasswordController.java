
package tuition.finder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


public class ForgotPasswordController implements Initializable {

    @FXML
    private Button recover;
    
    TuitionFinder tuitionFinder;
    @FXML
    private Text recovertxt;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void recoverPressed(ActionEvent event) throws IOException {
        if("Login Page".equals(recover.getText())){
            tuitionFinder.logInStage();
        }
        recover.setText("Login Page");
        recovertxt.setVisible(true);
        
    }

    public void setTuitionFinder(TuitionFinder tuitionFinder) {
        this.tuitionFinder = tuitionFinder;
    }
    
    
}
