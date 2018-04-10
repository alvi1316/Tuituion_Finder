
package tuition.finder;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class PostCompController implements Initializable {

    @FXML
    private Label areatext;
    @FXML
    private Label timetext;
    @FXML
    private Label salarytext;
    @FXML
    private Label institutetext;
    @FXML
    private Label classtext;
    @FXML
    private Label prefinstext;
    @FXML
    private TextArea subjectext;
    @FXML
    private Label posttimetext;
    @FXML
    private Label postdatetext;
    
   public void hello(){
       System.out.println("Hello");
   }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {            
    }    
    
}
