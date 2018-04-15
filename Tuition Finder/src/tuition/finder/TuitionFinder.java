package tuition.finder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;


public class TuitionFinder extends Application {
    Stage stage;
    static String username;
    static String search;
    @Override
    public void start(Stage primaryStage) throws IOException{
        this.stage=primaryStage;
        logInStage();
    }

    public void logInStage() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("LoginScreen.fxml"));
        Parent root = loader.load();
        
        LoginScreenController controller=loader.getController();
        controller.setTuitionFinder(this);
        
        
        stage.setTitle("Tuition Finder");
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }
    
    
    public void signUpStage() throws IOException {
        
        
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("SignUp.fxml"));
        AnchorPane root = loader.load();
        
        SignUpController controller = loader.getController();
        controller.setTuitionfinder(this);
        
        stage.setTitle("Sign Up");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
    
    public void homePage() throws IOException{
        
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("Home.fxml"));
        AnchorPane root = loader.load();
        HomeController controller = loader.getController();
        controller.setUsernametext();
        controller.setTutionFinder(this);
        controller.setFollow();
        stage.setMaximized(true);
        stage.setTitle("Home");
        stage.setScene(new Scene(root));
        stage.setX(0);
        stage.setY(0);
        stage.setMaximized(true);
        stage.show();
    }
    
    public void recoverScreen() throws IOException {
        
        
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("ForgotPassword.fxml"));
        AnchorPane root = loader.load();
        
        ForgotPasswordController controller = loader.getController();
        controller.setTuitionFinder(this);
        
        stage.setTitle("Recover Password");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    public void profileScreen(String name) throws IOException {
        
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("ProfileInformation.fxml"));
        AnchorPane root = loader.load();
        
        ProfileInformationController controller = loader.getController();
        controller.setName(name);
        controller.setEverything();
        controller.setTuitionFinder(this);
        
        stage.setTitle("Profile");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
    
    public void viewProfileScreen(String name) throws IOException {
        
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("ViewUserInformation.fxml"));
        AnchorPane root = loader.load();
        
        ViewUserInformationController controller = loader.getController();
        controller.setName(name);
        controller.setEverything();
        controller.setTuitionFinder(this);
        
        stage.setTitle("Profile");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
    
    public void editProfileScreen(String name) throws IOException {
        
        
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("EditProfileInformation.fxml"));
        AnchorPane root = loader.load();
        
        
        
        EditProfileInformationController controller = loader.getController();
        controller.setN(name);
        controller.setTuitionFinder(this);
        
        stage.setTitle("Edit Profile");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
    
    public void selfStatusScreen() throws IOException {
        
        
        
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("SelfStatusPage.fxml"));
        AnchorPane root = loader.load();
        SelfStatusPageController controller = loader.getController();
        controller.setTuitionFinder(this);
        controller.setFollow();
        stage.setTitle(username);
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
    
    public void searchPage() throws IOException {

        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("SearchPage.fxml"));
        AnchorPane root = loader.load();
        SearchPageController controller = loader.getController();        
        controller.setTuitionFinder(this);
        controller.init();
        controller.setFollow();
        stage.setTitle("Search");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
