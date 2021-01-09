import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;
public class CalendarController implements Serializable{
    private TimetableManager ttm;
    private CourseManager cm;
 public CalendarController(TimetableManager ttm, CourseManager cm){
     this.ttm = ttm;
     this.cm =cm;
 }

    public TimetableManager getTtm() {
        return ttm;
    }

    public void ArrangeCourse(List<List<Course>> listCourse){
     int len = listCourse.size();
     int i = 1;
     List<List<Course>> llc = new ArrayList<>();
     for (Course fCourse: listCourse.get(0)){
         List<Course> lc1 = new ArrayList<>();
         lc1.add(fCourse);
         llc.add(lc1);
     }
     while (i<len) {
         for (List<Course> lc2:llc){
             for (Course c1: listCourse.get(i)){
                 if (this.ableAdd(lc2,c1)){
                     llc.add(this.addCourse(lc2, c1));
                 }
             }
         }
         i+=1;
     }
     for (List<Course> lc3: llc){
         if (lc3.size()== len){
             Timetable tm = new Timetable(lc3);
             ttm.addTable(tm);
         }
     }}
    private Boolean ableAdd(List<Course> listCourse, Course course){
         for (Course c1: listCourse){
             for (List<Object> time1: cm.getTime(c1)){
                 for (List<Object> time2: cm.getTime(course)){
                     LocalTime lt1 = (LocalTime) time1.get(1);
                     LocalTime lt2 = (LocalTime) time1.get(2);
                     if (time1.get(0) == time2.get(0) & !(lt1.isAfter(lt2)||time1.get(1).equals
                         (time2.get(2)) || lt2.isBefore(lt1)||time1.get(2).equals(time2.get(1))))
                    {return false;
                 }
             }
        }
    }return true;

    }
    private List<Course> addCourse(List<Course> listCourse, Course course){
        List<Course> lc = new ArrayList<>();
        for (Course c:listCourse){
         lc.add(c);
        }
        lc.add(course);
     return lc;
    }
    }