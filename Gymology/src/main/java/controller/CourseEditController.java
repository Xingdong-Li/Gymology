package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Course;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Cheese
 */
public class CourseEditController implements Initializable {

    private Parent scene;
    private Boolean flag;
    private Course oldCourse;

    @FXML private Pane courseEditPane;
    @FXML private ChoiceBox<?> courseEditSortChoiceBox;
    @FXML private CheckBox courseEditVipCheckBox;
    @FXML private Button courseEditPicBtn;
    @FXML private Button courseEditVideoBtn;
    @FXML private TextField courseEditNameTxt;
    @FXML private Button courseSaveBtn;
    @FXML private Button courseDeleteBtn;
    @FXML private Label videoLocationLabel;
    @FXML private Label picLocationLabel;


    public void setScene(Parent scene) {
        this.scene = scene;
    }
    public Parent getScene() {
        return scene;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
        courseDeleteBtn.setDisable(!flag);
    }
    public void unLoad() {
        courseEditNameTxt.setText("");
        courseEditVipCheckBox.setSelected(false);
        videoLocationLabel.setText("");
        picLocationLabel.setText("");
    }
    public void onLoad(Course course) {
        oldCourse = course;
        courseEditNameTxt.setText(course.getCourseName());
        picLocationLabel.setText(course.getCoursePicture());
        videoLocationLabel.setText(course.getCourseLocation());


    }
    public void chooseVideoFile() {
        Stage stage = (Stage) courseEditPane.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose MP4 File");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("MP4 files (*.mp4)", "*.mp4");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            videoLocationLabel.setText(file.toString());
        }



    }
    public void choosePictureFile() {
        Stage stage = (Stage) courseEditPane.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image File");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png"),
                new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.jpg")
        );

        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            picLocationLabel.setText(file.toString());
        }


    }
    public void save(){
        if (flag) {
            System.out.println(oldCourse);
        }else {
            System.out.println("Null");
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) { }
}
