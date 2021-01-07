import java.io.Serializable;
import java.util.List;

public class CalendarController implements Serializable{
    private TimetableManager ttm;
    private CourseManager cm;
 public CalendarController(TimetableManager ttm, CourseManager cm){
     this.ttm = ttm;
     this.cm =cm;
 }
 public void ArrangeCourse(List<Course> listCourse){

 }
}