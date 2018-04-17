
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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ViewUserInformationController implements Initializable {

    @FXML
    private Button followButton;

    


    public ViewUserInformationController() {
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
    @FXML
    private Text useraddress;
    private String follow;
    
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
            follow=p.getUserName();
            userAge.setText(p.getUserAge());
            userSex.setText(p.getUserSex());
            useraddress.setText(p.getAddress());
            userCGPA.setText(Double.toString(p.getUserCGPA()));
            userSscCg.setText(Double.toString(p.getUserSscCg()));
            userHscCg.setText(Double.toString(p.getUserHscCg()));
            userDescription.setText(p.getUserDescription());
            if(follow.equals(TuitionFinder.username)){
                followButton.setVisible(false);
            }
            if(Database.checkFollow(follow,TuitionFinder.username)){
                followButton.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileInformationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void homePressed(ActionEvent event) throws IOException {
        tuitionFinder.homePage();
    }

    @FXML
    private void followPressed(ActionEvent event) {
        if(followButton.getText().equals("Follow"));{
            try {
                Database.writeFollow(follow, TuitionFinder.username);
            } catch (SQLException e) {
                System.out.println(e);
            }finally{
                followButton.setText("Followed");
            }
        }
    }

    @FXML
    private void viewPostPressed(ActionEvent event) throws IOException {
        tuitionFinder.otherStatusScreen(userName.getText());
    }
    
}
