import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {

    private String courseID;
    private List<List<Object>> time;
    private String instructor;
    private List<String> prerequisite;
    private List<String> exclusion;
    private String department;

    /**
     * @param courseID the id of the course, such as "CSC108"
     * @param time a list contains lists of String, the nested lists includes day of week(such as "Monday"),
     *             start time(String format, such as "10:15") and end time(String format, such as "10:15").
     * @param instructor the name of instructor
     * @param prerequisite the prerequisite to enter the course
     * @param exclusion the exclusion of the course
     * @param department the department of the course
     */
    public Course(String courseID, List<List<String>> time, String instructor, List<String>
            prerequisite, List<String> exclusion, String department){
        this.courseID = courseID;
        this.instructor = instructor;
        this.prerequisite = prerequisite;
        this.exclusion = exclusion;
        this.department = department;
        this.time = new ArrayList<>();
        for (List<String> lecture: time){
            List<Object> classTime = new ArrayList<>();
            classTime.add(lecture.get(0));
            LocalTime startTime = LocalTime.parse(lecture.get(1));
            classTime.add(startTime);
            LocalTime endTime = LocalTime.parse(lecture.get(2));
            classTime.add(endTime);
            this.time.add(classTime);
        } }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public List<List<Object>> getTime() {
        return time;
    }

    public void setTime(List<List<String>> time) {
        this.time.clear();
        for (List<String> lecture: time){
            List<Object> classTime = new ArrayList<>();
            classTime.add(lecture.get(0));
            LocalTime startTime = LocalTime.parse(lecture.get(1));
            classTime.add(startTime);
            LocalTime endTime = LocalTime.parse(lecture.get(2));
            classTime.add(endTime);
            this.time.add(classTime);
        }
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public List<String> getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(List<String> prerequisite) {
        this.prerequisite = prerequisite;
    }

    public List<String> getExclusion() {
        return exclusion;
    }

    public void setExclusion(List<String> exclusion) {
        this.exclusion = exclusion;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}