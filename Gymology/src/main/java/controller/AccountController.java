package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import model.User;
import util.ControllerKeeper;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Cheese
 */
public class AccountController implements Initializable {

    private Parent scene;

    @FXML
    private Label label;

    public void status(User user){
        ControllerKeeper.get(MainController.class).getMainPane().setCenter(scene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    public Parent getScene() {
        return scene;
    }

    public void setScene(Parent scene) {
        this.scene = scene;
    }
}
