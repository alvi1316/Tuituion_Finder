
package tuition.finder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class HomeController implements Initializable {

    TuitionFinder tuitionFinder;
    @FXML
    private Hyperlink usernametext;
    @FXML
    private CheckMenuItem bangla1;
    @FXML
    private CheckMenuItem bangla2;
    @FXML
    private CheckMenuItem english1;
    @FXML
    private CheckMenuItem english2;
    @FXML
    private CheckMenuItem phy;
    @FXML
    private CheckMenuItem chem;
    @FXML
    private CheckMenuItem bio;
    @FXML
    private CheckMenuItem ict;
    @FXML
    private TextArea subtext;
    @FXML
    private CheckMenuItem math;
    @FXML
    private MenuButton stuclass;
    @FXML
    private MenuItem class1;
    @FXML
    private MenuItem class2;
    @FXML
    private MenuItem class3;
    @FXML
    private MenuItem class4;
    @FXML
    private MenuItem class5;
    @FXML
    private MenuItem class6;
    @FXML
    private MenuItem class7;
    @FXML
    private MenuItem class8;
    @FXML
    private MenuButton area;
    @FXML
    private MenuItem area1;
    @FXML
    private MenuItem area2;
    @FXML
    private MenuItem area3;
    @FXML
    private MenuItem area4;
    @FXML
    private MenuItem area5;
    @FXML
    private MenuItem area6;
    @FXML
    private MenuButton time;
    @FXML
    private MenuItem time1;
    @FXML
    private MenuItem time2;
    @FXML
    private MenuItem time3;
    @FXML
    private Button search;
    @FXML
    private MenuButton subject;
    @FXML
    private MenuButton ins;
    @FXML
    private MenuItem ins1;
    @FXML
    private MenuItem ins2;
    @FXML
    private MenuButton prefins;
    @FXML
    private MenuItem prefins1;
    @FXML
    private MenuItem prefins2;
    @FXML
    private MenuButton salary;
    @FXML
    private MenuItem salary1;
    @FXML
    private MenuItem salary2;
    @FXML
    private MenuItem salary3;
    @FXML
    private MenuItem salary4;
    @FXML
    private MenuItem salary5;
    @FXML
    private AnchorPane scrollpane;
    @FXML
    private Button loadmore;
    @FXML
    private Label errorlbl;

    
    
    
    public void setUsernametext() {
        usernametext.setText(TuitionFinder.username);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        FileInputStream input = null;
        try {
            input = new FileInputStream("Icons/favicon.jpg");
            Image image = new Image(input);
            search.setGraphic(new ImageView(image));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }    

    public void setTutionFinder(TuitionFinder tuitionFinder) {
        this.tuitionFinder = tuitionFinder;
    }

    @FXML
    private void logoutPressed(ActionEvent event) throws IOException {
        tuitionFinder.logInStage();
    }

    @FXML
    private void userNamePressed(ActionEvent event) throws IOException {
        
        tuitionFinder.selfStatusScreen();
       
    }

    @FXML
    private void searchEnterPressed(KeyEvent event) throws IOException {
        if(event.getCode() == KeyCode.ENTER){
            tuitionFinder.profileScreen(usernametext.getText());
        }
    }

    @FXML
    private void postPressed(ActionEvent event) {
        if(area.getText().equals("Area") || ins.getText().equals("Institute") || time.getText().equals("Time") || stuclass.getText().equals("Class") || salary.getText().equals("Salary") || subtext.getText().equals("") || prefins.getText().equals("Prefered Institute"))
        {    
            errorlbl.setVisible(true);
        }
        else{
            errorlbl.setVisible(false);
            try {
                DateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
                DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();

                PostInfo p = new PostInfo();
                p.setArea(area.getText());
                p.setIns(ins.getText());
                p.setPrefins(prefins.getText());
                p.setTime(time.getText());
                p.setSalary(salary.getText());
                p.setStuclass(stuclass.getText());
                p.setSubtext(subtext.getText());
                p.setPostdate(dateformat.format(date));
                p.setPosttime(timeformat.format(date));

                Database.writePost(usernametext.getText(), p);
            } catch (SQLException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @FXML
    private void bangla1Pressed(ActionEvent event) {
        if(!subtext.getText().contains(bangla1.getText())){
                subtext.setText(subtext.getText()+bangla1.getText()+" ");
            }
            else if(subtext.getText().contains(bangla1.getText())){
                
                subtext.setText(subtext.getText().replace(bangla1.getText()+" ",""));
            }
    }

    @FXML
    private void bangla2Pressed(ActionEvent event) {
        if(!subtext.getText().contains(bangla2.getText())){
                subtext.setText(subtext.getText()+bangla2.getText()+" ");
            }
            else if(subtext.getText().contains(bangla2.getText())){
                
                subtext.setText(subtext.getText().replace(bangla2.getText()+" ",""));
            }
    }

    @FXML
    private void english1Pressed(ActionEvent event) {
        if(!subtext.getText().contains(english1.getText())){
                subtext.setText(subtext.getText()+english1.getText()+" ");
            }
            else if(subtext.getText().contains(english1.getText())){
                
                subtext.setText(subtext.getText().replace(english1.getText()+" ",""));
            }
    }

    @FXML
    private void english2Pressed(ActionEvent event) {
        if(!subtext.getText().contains(english2.getText())){
                subtext.setText(subtext.getText()+english2.getText()+" ");
            }
            else if(subtext.getText().contains(english2.getText())){
                
                subtext.setText(subtext.getText().replace(english2.getText()+" ",""));
            }
    }

    @FXML
    private void phyPressed(ActionEvent event) {
        if(!subtext.getText().contains(phy.getText())){
                subtext.setText(subtext.getText()+phy.getText()+" ");
            }
            else if(subtext.getText().contains(phy.getText())){
                
                subtext.setText(subtext.getText().replace(phy.getText()+" ",""));
            }
    }

    @FXML
    private void chemPressed(ActionEvent event) {
        if(!subtext.getText().contains(chem.getText())){
                subtext.setText(subtext.getText()+chem.getText()+" ");
            }
            else if(subtext.getText().contains(chem.getText())){
                
                subtext.setText(subtext.getText().replace(chem.getText()+" ",""));
            }
    }

    @FXML
    private void boiPressed(ActionEvent event) {
        if(!subtext.getText().contains(bio.getText())){
                subtext.setText(subtext.getText()+bio.getText()+" ");
            }
            else if(subtext.getText().contains(bio.getText())){
                
                subtext.setText(subtext.getText().replace(bio.getText()+" ",""));
            }
    }

    @FXML
    private void ictPressed(ActionEvent event) {
        if(!subtext.getText().contains(ict.getText())){
                subtext.setText(subtext.getText()+ict.getText()+" ");
            }
            else if(subtext.getText().contains(ict.getText())){
                
                subtext.setText(subtext.getText().replace(ict.getText()+" ",""));
            }
    }

    @FXML
    private void mathPressed(ActionEvent event) {
        if(!subtext.getText().contains(math.getText())){
                subtext.setText(subtext.getText()+math.getText()+" ");
            }
            else if(subtext.getText().contains(math.getText())){
                
                subtext.setText(subtext.getText().replace(math.getText()+" ",""));
            }
    }

    @FXML
    private void class1Pressed(ActionEvent event) {
        stuclass.setText(class1.getText());
    }

    @FXML
    private void class2Pressed(ActionEvent event) {
        stuclass.setText(class2.getText());
    }

    @FXML
    private void class3Pressed(ActionEvent event) {
        stuclass.setText(class3.getText());
    }

    @FXML
    private void class4Pressed(ActionEvent event) {
        stuclass.setText(class4.getText());
    }

    @FXML
    private void class5Pressed(ActionEvent event) {
        stuclass.setText(class5.getText());
    }

    @FXML
    private void class6Pressed(ActionEvent event) {
        stuclass.setText(class6.getText());
    }

    @FXML
    private void class7Pressed(ActionEvent event) {
        stuclass.setText(class7.getText());
    }

    @FXML
    private void class8Pressed(ActionEvent event) {
        stuclass.setText(class8.getText());
    }

    @FXML
    private void area1Pressed(ActionEvent event) {
        area.setText(area1.getText());
    }

    @FXML
    private void area2Pressed(ActionEvent event) {
        area.setText(area2.getText());
    }

    @FXML
    private void area3Pressed(ActionEvent event) {
        area.setText(area3.getText());
    }

    @FXML
    private void area4Pressed(ActionEvent event) {
        area.setText(area4.getText());
    }

    @FXML
    private void area5Pressed(ActionEvent event) {
        area.setText(area5.getText());
    }

    @FXML
    private void area6Pressed(ActionEvent event) {
        area.setText(area6.getText());
    }

    @FXML
    private void time1Pressed(ActionEvent event) {
        time.setText(time1.getText());
    }

    @FXML
    private void time2Pressed(ActionEvent event) {
        time.setText(time2.getText());
    }

    @FXML
    private void time3Pressed(ActionEvent event) {
        time.setText(time3.getText());
    }

    @FXML
    private void ins1Pressed(ActionEvent event) {
        ins.setText(ins1.getText());
    }

    @FXML
    private void ins2Pressed(ActionEvent event) {
        ins.setText(ins2.getText());
    }

    @FXML
    private void prefins1Pressed(ActionEvent event) {
        prefins.setText(prefins1.getText());
    }

    @FXML
    private void prefins2Pressed(ActionEvent event) {
        prefins.setText(prefins2.getText());
    }

    @FXML
    private void salary1Pressed(ActionEvent event) {
        salary.setText(salary1.getText());
    }

    @FXML
    private void salary2Pressed(ActionEvent event) {
        salary.setText(salary2.getText());
    }

    @FXML
    private void salary3Pressed(ActionEvent event) {
        salary.setText(salary3.getText());
    }

    @FXML
    private void salary4Pressed(ActionEvent event) {
        salary.setText(salary4.getText());
    }

    @FXML
    private void salary5Pressed(ActionEvent event) {
        salary.setText(salary5.getText());
    }

    @FXML
    private void loadmorePressed(ActionEvent event) {
        scrollpane.setMinHeight(scrollpane.getHeight()+1011);
        loadmore.setLayoutY(scrollpane.getMinHeight()-50);
    }

    
    
}
