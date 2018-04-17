
package tuition.finder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class EditProfileInformationController implements Initializable {
    
    TuitionFinder tuitionFinder;
    @FXML
    private TextField addresstext;

    public void setTuitionFinder(TuitionFinder tuitionFinder) {
        this.tuitionFinder = tuitionFinder;
    }

    
    

    @FXML
    private TextArea userDescription;
    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;
    @FXML
    private TextField name;
    String userName;
    String password;
    int parentnum;
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

    public void setEverything(ProInfo p){
        userDescription.setText(p.getUserDescription());
        name.setText(p.getName());
        userName=p.getUserName();
        password=p.getPassword();
        parentnum=p.getParentNum();
        userPhone.setText(Integer.toString(p.getUserPhone()));
        userEmail.setText(p.getUserEmail());
        userInstitute.setText(p.getUserInstitute());
        userCGPA.setText(Double.toString(p.getUserCGPA()));
        userSscCg.setText(Double.toString(p.getUserSscCg()));
        userHscCg.setText(Double.toString(p.getUserHscCg()));
        userAge.setText(p.getUserAge());
        userSex.setText(p.getUserSex());
        addresstext.setText(p.getAddress());
        
    }
    
    @FXML
    private void ageOne(ActionEvent event) {
        userAge.setText("18-22");
    }

    @FXML
    private void ageTwo(ActionEvent event) {
        userAge.setText("23-27");
    }

    @FXML
    private void ageThree(ActionEvent event) {
        userAge.setText("28-35");
    }

    @FXML
    private void malePressed(ActionEvent event) {
        userSex.setText("Male");
    }

    @FXML
    private void femailPressed(ActionEvent event) {
        userSex.setText("Female");
    }

    @FXML
    private void homePressed(ActionEvent event) throws IOException {
        tuitionFinder.homePage();
    }

    @FXML
    private void savePressed(ActionEvent event) throws IOException {
        Database.deleteTable(userName);
        Database.makeDb(name.getText(),password,userEmail.getText(),userName,Integer.parseInt(userPhone.getText()),parentnum,userAge.getText(),userSex.getText(),addresstext.getText(),userInstitute.getText(),Double.parseDouble(userCGPA.getText()),Double.parseDouble(userSscCg.getText()),Double.parseDouble(userHscCg.getText()),userDescription.getText());
        tuitionFinder.homePage();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Edit Successfull");
        alert.setHeaderText("");
        alert.setContentText("You Edited Your Profile Successfully");
        alert.showAndWait();
    }
    
}
