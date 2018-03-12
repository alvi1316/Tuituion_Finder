
package tuition.finder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class HomeController implements Initializable {

    TuitionFinder tuitionFinder;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setTutionFinder(TuitionFinder tuitionFinder) {
        this.tuitionFinder = tuitionFinder;
    }

    @FXML
    private void logoutPressed(ActionEvent event) throws IOException {
        tuitionFinder.logInStage();
    }
    
}
