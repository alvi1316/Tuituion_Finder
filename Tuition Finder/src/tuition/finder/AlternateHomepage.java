package tuition.finder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;



public class AlternateHomepage {
    
    TuitionFinder tuitionfinder;

    public void setTuitionfinder(TuitionFinder tuitionfinder) {
        this.tuitionfinder = tuitionfinder;
    }
    
    
    
    
    public void homepage(String usernameText) throws IOException{
        
        
        
        Label tuitionlbl = new Label("Tuition Finder!");
        tuitionlbl.setFont(new Font("Arial", 45));
        tuitionlbl.setTextFill(Color.WHITE);
        tuitionlbl.setUnderline(true);
        tuitionlbl.setLayoutX(10);
        tuitionlbl.setLayoutY(10);
        
        
        
        TextField search = new TextField();
        search.setFont(new Font("Arial",25));
        search.setPromptText("Serach");
        search.setFocusTraversable(false);
        search.setMinSize(500, 45);
        search.setLayoutX(500);
        search.setLayoutY(15);
        
        
        
        Button searchbtn = new Button();
        FileInputStream input = new FileInputStream("Icons/favicon.jpg");
        Image image = new Image(input);
        searchbtn.setGraphic(new ImageView(image));
        searchbtn.setLayoutX(1020);
        searchbtn.setLayoutY(15);
        
        
        
        Hyperlink username = new Hyperlink(usernameText);
        username.setTextFill(Color.WHITE);
        username.setFont(new Font("Arial",25));
        username.setLayoutX(1500);
        username.setLayoutY(18);
        
        
        username.setOnAction((ActionEvent event) -> {
            try {
                tuitionfinder.profileScreen(username.getText());
            } catch (IOException ex) {
                Logger.getLogger(AlternateHomepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        
        
        
        MenuItem itemSettings = new MenuItem("Settings");
        MenuItem itemLogout = new MenuItem("Logout");
        
        
        
        
        
        itemLogout.setOnAction((ActionEvent event) -> {
            try {
                tuitionfinder.logInStage();
            } catch (IOException ex) {
                Logger.getLogger(AlternateHomepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        
        
        
        MenuButton menu = new MenuButton("Menu");
        menu.getItems().addAll(itemSettings,itemLogout);
        menu.setLayoutX(1750);
        menu.setLayoutY(25);
        
        
        MenuButton time = new MenuButton("Time");
        time.setLayoutX(200);
        time.setLayoutY(100);
        MenuItem time1 = new MenuItem("8-12 AM");
        MenuItem time2 = new MenuItem("12-6 PM");
        MenuItem time3 = new MenuItem("6-10 PM");
        time.getItems().addAll(time1,time2,time3);
        
        
        
        
        
        
        time1.setOnAction((ActionEvent event) -> {
            time.setText(time1.getText());
        });
        time2.setOnAction((ActionEvent event) -> {
            time.setText(time2.getText());
        });
        time3.setOnAction((ActionEvent event) -> {
            time.setText(time3.getText());
        });
        
        
        
        
        MenuButton stuclass = new MenuButton("Class");
        stuclass.setLayoutX(350);
        stuclass.setLayoutY(100);
        MenuItem class1 = new MenuItem("Class 5");
        MenuItem class2 = new MenuItem("Class 6");
        MenuItem class3 = new MenuItem("Class 7");
        MenuItem class4 = new MenuItem("Class 8");
        MenuItem class5 = new MenuItem("Class 9");
        MenuItem class6 = new MenuItem("Class 10");
        stuclass.getItems().addAll(class1,class2,class3,class4,class5,class6);
        
        
        
        class1.setOnAction((ActionEvent event) -> {
            stuclass.setText(class1.getText());
        });
        class2.setOnAction((ActionEvent event) -> {
            stuclass.setText(class2.getText());
        });
        class3.setOnAction((ActionEvent event) -> {
            stuclass.setText(class3.getText());
        });
        class4.setOnAction((ActionEvent event) -> {
            stuclass.setText(class4.getText());
        });
        class5.setOnAction((ActionEvent event) -> {
            stuclass.setText(class5.getText());
        });
        class6.setOnAction((ActionEvent event) -> {
            stuclass.setText(class6.getText());
        });
        
        
        
        
        MenuButton subject = new MenuButton("Subjects");
        subject.setLayoutX(500);
        subject.setLayoutY(100);
        CheckMenuItem bangla1 = new CheckMenuItem("Bangla-1st");        
        CheckMenuItem bangla2 = new CheckMenuItem("Bangla-2nd");        
        CheckMenuItem english1 = new CheckMenuItem("English-1st");        
        CheckMenuItem english2 = new CheckMenuItem("English-2nd");
        CheckMenuItem math = new CheckMenuItem("math");
        CheckMenuItem phy = new CheckMenuItem("Physics");
        CheckMenuItem chem = new CheckMenuItem("Chemestry");
        CheckMenuItem bio = new CheckMenuItem("Biology");
        CheckMenuItem ict = new CheckMenuItem("ICT");
        subject.getItems().addAll(bangla1,bangla2,english1,english2,math,phy,chem,bio,ict);
        
        
        
        TextArea subtext = new TextArea();
        subtext.setPromptText("Selected Subjects");
        subtext.setMaxSize(120, 120);
        subtext.setEditable(false);
        subtext.setWrapText(true);
        subtext.setLayoutX(600);
        subtext.setLayoutY(100);
        
        
        
        bangla1.setOnAction((ActionEvent event) -> {
            if(!subtext.getText().contains(bangla1.getText())){
                subtext.setText(subtext.getText()+bangla1.getText()+"\n");
            }
            else if(subtext.getText().contains(bangla1.getText())){
                
                subtext.setText(subtext.getText().replace(bangla1.getText()+"\n",""));
            }
        });
        bangla2.setOnAction((ActionEvent event) -> {
            if(!subtext.getText().contains(bangla2.getText())){
                subtext.setText(subtext.getText()+bangla2.getText()+"\n");
            }
            else if(subtext.getText().contains(bangla2.getText())){
                
                subtext.setText(subtext.getText().replace(bangla2.getText()+"\n",""));
            }
        });
        english1.setOnAction((ActionEvent event) -> {
            if(!subtext.getText().contains(english1.getText())){
                subtext.setText(subtext.getText()+english1.getText()+"\n");
            }
            else if(subtext.getText().contains(english1.getText())){
                
                subtext.setText(subtext.getText().replace(english1.getText()+"\n",""));
            }
        });
        english2.setOnAction((ActionEvent event) -> {
            if(!subtext.getText().contains(english2.getText())){
                subtext.setText(subtext.getText()+english2.getText()+"\n");
            }
            else if(subtext.getText().contains(english2.getText())){
                
                subtext.setText(subtext.getText().replace(english2.getText()+"\n",""));
            }
        });
        math.setOnAction((ActionEvent event) -> {
            if(!subtext.getText().contains(math.getText())){
                subtext.setText(subtext.getText()+math.getText()+"\n");
            }
            else if(subtext.getText().contains(math.getText())){
                
                subtext.setText(subtext.getText().replace(math.getText()+"\n",""));
            }
        });
        phy.setOnAction((ActionEvent event) -> {
            if(!subtext.getText().contains(phy.getText())){
                subtext.setText(subtext.getText()+phy.getText()+"\n");
            }
            else if(subtext.getText().contains(phy.getText())){
                
                subtext.setText(subtext.getText().replace(phy.getText()+"\n",""));
            }
        });
        chem.setOnAction((ActionEvent event) -> {
            if(!subtext.getText().contains(chem.getText())){
                subtext.setText(subtext.getText()+chem.getText()+"\n");
            }
            else if(subtext.getText().contains(chem.getText())){
                
                subtext.setText(subtext.getText().replace(chem.getText()+"\n",""));
            }
        });
        bio.setOnAction((ActionEvent event) -> {
            if(!subtext.getText().contains(bio.getText())){
                subtext.setText(subtext.getText()+bio.getText()+"\n");
            }
            else if(subtext.getText().contains(bio.getText())){
                
                subtext.setText(subtext.getText().replace(bio.getText()+"\n",""));
            }
        });
        ict.setOnAction((ActionEvent event) -> {
            if(!subtext.getText().contains(ict.getText())){
                subtext.setText(subtext.getText()+ict.getText()+"\n");
            }
            else if(subtext.getText().contains(ict.getText())){
                
                subtext.setText(subtext.getText().replace(ict.getText()+"\n",""));
            }
        });
        
        
        MenuButton salary = new MenuButton("Salary");
        salary.setLayoutX(800);
        salary.setLayoutY(100);
        MenuItem salary1 = new MenuItem("1000+ Taka");
        MenuItem salary2 = new MenuItem("3000+ Taka");
        MenuItem salary3 = new MenuItem("5000+ Taka");
        MenuItem salary4 = new MenuItem("7000+ Taka");
        MenuItem salary5 = new MenuItem("10,000+ Taka");
        salary.getItems().addAll(salary1,salary2,salary3,salary4,salary5);
        
        
        salary1.setOnAction((ActionEvent event) ->{
            salary.setText(salary1.getText());
        });
        salary2.setOnAction((ActionEvent event) ->{
            salary.setText(salary2.getText());
        });
        salary3.setOnAction((ActionEvent event) ->{
            salary.setText(salary3.getText());
        });
        salary4.setOnAction((ActionEvent event) ->{
            salary.setText(salary4.getText());
        });
        salary5.setOnAction((ActionEvent event) ->{
            salary.setText(salary5.getText());
        });
        
        
        
        
        
        MenuButton ins = new MenuButton("Institute");
        ins.setLayoutX(200);
        ins.setLayoutY(170);
        ins.setMinWidth(250);
        MenuItem ins1 = new MenuItem("Uttara Rajuk School And College");
        MenuItem ins2 = new MenuItem("Uttara Life Preparatory School");
        MenuItem ins3 = new MenuItem("Uttara High School");
        MenuItem ins4 = new MenuItem("Kids Campus");
        MenuItem ins5 = new MenuItem("Turkish Hope International School");
        MenuItem ins6 = new MenuItem("Aga khan School");
        ins.getItems().addAll(ins1,ins2,ins3,ins4,ins5,ins6);
        
        
        ins1.setOnAction((ActionEvent event) ->{
            ins.setText(ins1.getText());
        });
        ins2.setOnAction((ActionEvent event) ->{
            ins.setText(ins2.getText());
        });
        ins3.setOnAction((ActionEvent event) ->{
            ins.setText(ins3.getText());
        });
        ins4.setOnAction((ActionEvent event) ->{
            ins.setText(ins4.getText());
        });
        ins5.setOnAction((ActionEvent event) ->{
            ins.setText(ins5.getText());
        });
        ins6.setOnAction((ActionEvent event) ->{
            ins.setText(ins6.getText());
        });
        
        
        
        
        Button post = new Button("POST!");
        post.setFont(new Font("Arial",30));
        post.setMinSize(100, 100);
        post.setLayoutX(950);
        post.setLayoutY(110);
        
        
        
        
        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: #8c151e");
        root.getChildren().addAll(tuitionlbl,search,searchbtn,username,menu,time,stuclass,subject,subtext,salary,ins,post);
        
        
        
        Scene scene = new Scene(root,1920,1080);
        tuitionfinder.stage.setScene(scene);
        
    }
}