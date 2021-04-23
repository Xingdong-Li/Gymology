import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.ControllerKeeper;



/**
 * @author Cheese
 */
public class Main extends Application {



    @Override
    public void start(Stage stage) throws Exception{

        FXMLLoader loader = new FXMLLoader(MainController.class.getResource("/fxml/main.fxml"));
        Parent parent = loader.load();
        MainController mainController = loader.getController();
        ControllerKeeper.put(mainController.getClass(),mainController);
        stage.setTitle("Gymology");
        stage.setScene(new Scene(parent));
        stage.show();
        mainController.homeScene();



    }

    public static void main(String[] args) { launch(args); }

}
