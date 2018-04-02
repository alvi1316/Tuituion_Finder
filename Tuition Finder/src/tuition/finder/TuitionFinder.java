package tuition.finder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TuitionFinder extends Application {
    Stage stage;
    
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
        Parent root = loader.load();
        
        SignUpController controller = loader.getController();
        controller.setTuitionfinder(this);
        
        stage.setTitle("Sign Up");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
    
    public void homePage(String username) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Home.fxml"));
        Parent root = loader.load();
        
        HomeController controller = loader.getController();
        controller.setUsernametext(username);
        controller.setTutionFinder(this);
        
        
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
        Parent root = loader.load();
        
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
        Parent root = loader.load();
        
        ProfileInformationController controller = loader.getController();
        controller.setName(name);
        controller.setEverything();
        controller.setTuitionFinder(this);
        
        stage.setTitle("Profile");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
