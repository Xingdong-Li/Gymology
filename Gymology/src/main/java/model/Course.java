package model;

/**
 * @author Cheese
 */
public class Course {
    private String courseId;
    private String courseName;
    private String courseSort;
    private String courseTime;
    private String courseVip;
    private String coursePicture;
    private String courseLocation;


    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseSort() {
        return courseSort;
    }

    public void setCourseSort(String courseSort) {
        this.courseSort = courseSort;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getCourseVip() {
        return courseVip;
    }

    public void setCourseVip(String courseVip) {
        this.courseVip = courseVip;
    }

    public String getCoursePicture() {
        return coursePicture;
    }

    public void setCoursePicture(String coursePicture) {
        this.coursePicture = coursePicture;
    }

    public String getCourseLocation() {
        return courseLocation;
    }

    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }


    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseSort='" + courseSort + '\'' +
                ", courseTime='" + courseTime + '\'' +
                ", courseVip='" + courseVip + '\'' +
                ", coursePicture='" + coursePicture + '\'' +
                ", courseLocation='" + courseLocation + '\'' +
                '}';
    }
}
