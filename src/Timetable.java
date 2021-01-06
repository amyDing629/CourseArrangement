import java.util.List;
import java.util.UUID;

public class Timetable{
    private UUID TimeTableID;
    private List<Course> courseList;

    public Timetable(List<Course> courseList){
        TimeTableID = UUID.randomUUID();
        this.courseList = courseList;
    }

    public UUID getTimeTableID() {
        return TimeTableID;
    }

    public List<Course> getCourseList() {
        return courseList;
    }
    public void addCourse(Course course){
        courseList.add(course);
    }
    public void removeCourse(Course course){
        courseList.remove(course);
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}