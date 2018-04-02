package tuition.finder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class SignUpController implements Initializable {

    TuitionFinder tuitionfinder;
    @FXML
    private TextField username;
    @FXML
    private TextField mobileNum;
    @FXML
    private TextField parentNum;
    @FXML
    private TextField address;
    @FXML
    private TextField institute;
    @FXML
    private TextField cgpa;
    @FXML
    private TextField ssccg;
    @FXML
    private TextField hsccg;
    @FXML
    private MenuButton age;
    @FXML
    private MenuButton sex;
    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextArea description;
    @FXML
    private Text infotext;
    @FXML
    private Text usernametaken;
    
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
        age.setText("18-22");
    }

    @FXML
    private void ageTwo(ActionEvent event) {
        age.setText("23-27");
    }

    @FXML
    private void ageThree(ActionEvent event) {
        age.setText("28-35");
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
        
        if(name.getText().equals("") || password.getText().equals("") || username.getText().equals("") || institute.getText().equals("")|| username.getText().equals("")){
            infotext.setVisible(true);
        }
        else if(Database.checkUsername(username.getText())){
            usernametaken.setVisible(true);
        }
        else{
            try{
                Integer.parseInt(mobileNum.getText());
                Integer.parseInt(parentNum.getText());
                Double.parseDouble(cgpa.getText());
                Double.parseDouble(ssccg.getText());
                Double.parseDouble(hsccg.getText());
                Database.makeFolder(username.getText());
                Database.makeDb(name.getText(),password.getText(),email.getText(),username.getText(),Integer.parseInt(mobileNum.getText()),Integer.parseInt(parentNum.getText()),age.getText(),sex.getText(),address.getText(),institute.getText(),Double.parseDouble(cgpa.getText()),Double.parseDouble(ssccg.getText()),Double.parseDouble(hsccg.getText()),description.getText());
                Database.makeUsernamePassword(username.getText(), password.getText());
                tuitionfinder.homePage(username.getText());

            }
            catch(NumberFormatException e){
                System.out.println(e);
                infotext.setVisible(true);
            }
        }
        
    }
    
    
    
}
