package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import model.User;
import util.ControllerKeeper;
import util.UserDataBase;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Dong
 */
public class LoginController implements Initializable {


    private Parent scene;
    private boolean loginStatus = false;
    @FXML
    private TextField email;

    @FXML
    private Label prompt;

    @FXML
    private PasswordField password;

    @FXML
    private void login() {
        User user = new User();
        user.setEmail(email.getText());
        user.setPassword(password.getText());
        int index = UserDataBase.contains(user);
        if (UserDataBase.exists(index, user)) {
            loginStatus = true;
            prompt.setText("");
            user = UserDataBase.get(index);
            ControllerKeeper.get(AccountController.class).status(user);
        } else {
            password.setText("");
            prompt.setText("Login failed!");
        }
    }


    @FXML
    public void loginScene() {
        BorderPane mainPane = ControllerKeeper.get(MainController.class).getMainPane();
        mainPane.setCenter(loginStatus ? ControllerKeeper.get(AccountController.class).getScene() : scene);
    }

    public void loginScene(String prompt)  {
        MainController mainController = ControllerKeeper.get(MainController.class);
        try {
            ControllerKeeper.reload(RegisterController.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.prompt.setText(prompt);
        mainController.getMainPane().setCenter(scene);
    }

    @FXML
    public void register() {
        BorderPane mainPane = ControllerKeeper.get(MainController.class).getMainPane();
        Parent scene = ControllerKeeper.get(RegisterController.class).getScene();
        mainPane.setCenter(scene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public Parent getScene() {
        return scene;
    }

    public void setScene(Parent scene) {
        this.scene = scene;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }


}
