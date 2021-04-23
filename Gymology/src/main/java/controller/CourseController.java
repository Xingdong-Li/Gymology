package controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model.Course;
import util.ControllerKeeper;

import java.net.URL;
import java.util.*;

import static util.OperateJsonFile.readJsonFile;

/**
 * @author Cheese
 */
public class CourseController implements Initializable {

    private Parent scene;

    @FXML private TextField courseSearchTxt;
    @FXML private Button courseSearchBtn;
    @FXML private Button courseUploadBtn;
    @FXML private ChoiceBox<?> courseSortBox;
    @FXML private ScrollPane courseScrollPane;
    @FXML private GridPane courseGridPane;


    public void setScene(Parent scene) {
        this.scene = scene;
    }
    public Parent getScene() {
        return scene;
    }
    @FXML public void courseScene() {
        BorderPane mainPane = ControllerKeeper.get(MainController.class).getMainPane();
        mainPane.setCenter(ControllerKeeper.get(CourseController.class).getScene());
    }

    private void isAdmin(Boolean identity){
        //TODO 身份识别的方法
        //设置上传视频的按钮
        //把收藏视频换为编辑视频
        courseUploadBtn.setVisible(identity);

    }
    private JSONObject loadCourseJson(String sort){
        String str = readJsonFile(Objects.requireNonNull(CourseController.class.getClassLoader().getResource("data/Course.json")).getPath());
        JSONObject jsonObj = JSON.parseObject(str);
        JSONObject jsonSubObj = new JSONObject();
        if ("Default" .equals(sort)){
            return jsonObj;
        }else if ("Keywords".equals(sort)){
            System.out.println(courseSearchTxt.getText());
            return jsonSubObj;
        }else{
            for (Map.Entry<String, Object> entry: jsonObj.entrySet()){
                if (sort.equals(jsonObj.getJSONObject(entry.getKey()).get("sort"))){
                    jsonSubObj.put(entry.getKey(),entry.getValue());
                }
            }
            return jsonSubObj;
        }
    }
    private List<Course> setCoursesData(String sort) {
        Course course;
        List<Course> courses = new ArrayList<>();
        JSONObject courseJsonObj = loadCourseJson(sort);

        for (Map.Entry<String, Object> entry: courseJsonObj.entrySet()){
            course = new Course();
            course.setCourseId(entry.getKey());
            course.setCourseName((String) courseJsonObj.getJSONObject(entry.getKey()).get("name"));
            course.setCoursePicture((String) courseJsonObj.getJSONObject(entry.getKey()).get("picLocation"));
            course.setCourseLocation((String) courseJsonObj.getJSONObject(entry.getKey()).get("videoLocation"));
            course.setCourseSort((String) courseJsonObj.getJSONObject(entry.getKey()).get("sort"));
            course.setCourseTime((String) courseJsonObj.getJSONObject(entry.getKey()).get("time"));
            course.setCourseVip((String) courseJsonObj.getJSONObject(entry.getKey()).get("vip"));
            courses.add(course);
        }

        return courses;

    }
    private void setCourseScene() throws Exception {

        //接口: 课程的分类,或是搜索
        List<Course> courses = new ArrayList<>(setCoursesData("lose-weight"));

        int column = 0;
        int row = 1;
        for (Course course : courses) {
            FXMLLoader courseItemLoader = new FXMLLoader();
            courseItemLoader.setLocation(getClass().getClassLoader().getResource("fxml/courseItem.fxml"));
            Pane courseItemPane = courseItemLoader.load();
            CourseItemController courseItemController = courseItemLoader.getController();
            courseItemController.setCourseData(course);
            if (column == 3) {
                column = 0;
                row++;
            }
            courseGridPane.add(courseItemPane, column++, row);
            GridPane.setMargin(courseItemPane, new Insets(10));
        }


    }
    public void uploadCourse(){

        Parent scene = util.ControllerKeeper.get(CourseEditController.class).getScene();
        BorderPane mainPane = util.ControllerKeeper.get(MainController.class).getMainPane();
        CourseEditController courseEditController = util.ControllerKeeper.get(CourseEditController.class);

        courseEditController.unLoad();
        courseEditController.setFlag(false);

        mainPane.setCenter(scene);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            isAdmin(true);
            setCourseScene();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
