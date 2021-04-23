package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import model.Course;


import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * @author Cheese
 */
public class CourseItemController implements Initializable {

    private Parent scene;
    private Course course;

    @FXML private ImageView coursePic;
    @FXML private Label courseSort;
    @FXML private Label courseTime;
    @FXML private Label courseName;
    @FXML private Label courseVip;
    @FXML private Button functionBtn;

    private final String editIcon  = Objects.requireNonNull(getClass().getResource("/img/edit.png")).toString();
    //private final String likeIcon  = Objects.requireNonNull(getClass().getResource("/img/like.png")).toString();


    public void setScene(Parent scene) {
        this.scene = scene;
    }
    public Parent getScene() {
        return scene;
    }
    //TODO 身份识别的方法
    public void setCourseData(Course course){
        this.course = course;
        courseName.setText(course.getCourseName());
        courseSort.setText(course.getCourseSort());
        courseTime.setText(course.getCourseTime());
        courseVip.setText(course.getCourseVip());
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(course.getCoursePicture())));
        coursePic.setImage(image);
    }
    private void setButtonIcon(Button button, String path){
        Image icon = new Image(path);
        ImageView imageView = new ImageView(icon);
        imageView.setFitWidth(25);
        imageView.setFitHeight((int)(25 * icon.getHeight() / icon.getWidth()));
        button.setGraphic(imageView);


        ColorAdjust colorAdjust = new ColorAdjust();
        button.setOnMousePressed(event ->  {
            colorAdjust.setBrightness(0.5);
            button.setEffect(colorAdjust);
        });
        button.setOnMouseReleased(event -> {
            colorAdjust.setBrightness(0);
            button.setEffect(colorAdjust);
        });
    }
    @FXML private void clickCourse(){
        BorderPane mainPane = util.ControllerKeeper.get(MainController.class).getMainPane();
        Parent scene = util.ControllerKeeper.get(CoursePlayerController.class).getScene();
        util.ControllerKeeper.get(CoursePlayerController.class).mediaPlayerOnLoad(course);
        mainPane.setCenter(scene);


    }
    @FXML void  clickButton(){
        Parent scene = util.ControllerKeeper.get(CourseEditController.class).getScene();
        BorderPane mainPane = util.ControllerKeeper.get(MainController.class).getMainPane();
        CourseEditController courseEditController = util.ControllerKeeper.get(CourseEditController.class);

        courseEditController.unLoad();
        courseEditController.onLoad(course);
        courseEditController.setFlag(true);

        mainPane.setCenter(scene);

    }
    @FXML private void mouseIn(){
        //TODO 身份
        setButtonIcon(functionBtn,editIcon);
        functionBtn.setOpacity(100);
    }
    @FXML private void mouseOut(){
        functionBtn.setOpacity(0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) { }
}
