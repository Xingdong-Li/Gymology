package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import util.ControllerKeeper;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    private Parent scene;

    @FXML
    private BorderPane mainPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void homeScene(){
        ControllerKeeper.get(MainController.class).getMainPane().setCenter(scene);
    }




    public Parent getScene() {
        return scene;
    }

    public void setScene(Parent scene) {
        this.scene = scene;
    }

}
