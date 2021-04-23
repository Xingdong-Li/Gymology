package controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import util.ControllerKeeper;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Cheese
 */
public class MainController implements Initializable {
    @FXML private BorderPane mainPane;
    @FXML public void homeScene() {
        ControllerKeeper.get(HomeController.class).homeScene();
    }
    @FXML private void courseScene() { ControllerKeeper.get(CourseController.class).courseScene(); }
    @FXML private void loginScene() {
        ControllerKeeper.get(LoginController.class).loginScene();
    }
    public BorderPane getMainPane() {
        return mainPane;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            FXMLLoader accountLoader = new FXMLLoader(AccountController.class.getResource("/fxml/account.fxml"));
            FXMLLoader homeLoader = new FXMLLoader(HomeController.class.getResource("/fxml/home.fxml"));
            FXMLLoader loginLoader = new FXMLLoader(LoginController.class.getResource("/fxml/login.fxml"));
            FXMLLoader registerLoader = new FXMLLoader(RegisterController.class.getResource("/fxml/register.fxml"));
            FXMLLoader courseLoader = new FXMLLoader(RegisterController.class.getResource("/fxml/course.fxml"));
            FXMLLoader courseItemLoader = new FXMLLoader(RegisterController.class.getResource("/fxml/courseItem.fxml"));
            FXMLLoader coursePlayerLoader = new FXMLLoader(RegisterController.class.getResource("/fxml/coursePlayer.fxml"));
            FXMLLoader courseEditLoader = new FXMLLoader(RegisterController.class.getResource("/fxml/courseEdit.fxml"));
            Parent load;

            load = accountLoader.load();
            AccountController accountController = accountLoader.getController();
            accountController.setScene(load);

            load = homeLoader.load();
            HomeController homeController = homeLoader.getController();
            System.out.println(homeController);
            homeController.setScene(load);

            load = loginLoader.load();
            LoginController loginController = loginLoader.getController();
            loginController.setScene(load);

            load = registerLoader.load();
            RegisterController registerController = registerLoader.getController();
            registerController.setScene(load);

            load = courseLoader.load();
            CourseController courseController = courseLoader.getController();
            courseController.setScene(load);

            load = courseItemLoader.load();
            CourseItemController courseItemController = courseItemLoader.getController();
            courseItemController.setScene(load);

            load = coursePlayerLoader.load();
            CoursePlayerController coursePlayerController = coursePlayerLoader.getController();
            coursePlayerController.setScene(load);


            load = courseEditLoader.load();
            CourseEditController courseEditController = courseEditLoader.getController();
            courseEditController.setScene(load);


            ControllerKeeper.put(accountController.getClass(), accountController);
            ControllerKeeper.put(homeController.getClass(), homeController);
            ControllerKeeper.put(loginController.getClass(), loginController);
            ControllerKeeper.put(registerController.getClass(), registerController);
            ControllerKeeper.put(courseController.getClass(), courseController);
            ControllerKeeper.put(courseItemController.getClass(),courseItemController);
            ControllerKeeper.put(coursePlayerController.getClass(),coursePlayerController);
            ControllerKeeper.put(courseEditController.getClass(),courseEditController);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
