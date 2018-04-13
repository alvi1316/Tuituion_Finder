
package tuition.finder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;


public class FollowCompController implements Initializable {

    @FXML
    private Hyperlink followCompText;
    TuitionFinder tuitionfinder;

    public void setTuitionfinder(TuitionFinder tuitionfinder) {
        this.tuitionfinder = tuitionfinder;
    }
    

    public String getFollowCompText() {
        return followCompText.getText();
    }

    public void setFollowCompText(String followCompText) {
        this.followCompText.setText(followCompText);
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void userNamePressed(ActionEvent event) throws IOException {
        tuitionfinder.viewProfileScreen(followCompText.getText());
    }
    
}
