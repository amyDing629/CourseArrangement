import java.util.List;
import java.io.Serializable;
public class TimetableManager implements Serializable{
    private List<Timetable> tableList;
    public TimetableManager(List<Timetable> tableList){
        this.tableList = tableList; }

    public List<Timetable> getTableList() {
        return tableList;
    }

    public void setTableList(List<Timetable> tableList) {
        this.tableList = tableList;
    }

    public void addTable(Timetable timetable){
        tableList.add(timetable);
    }

    public void removeTable(Timetable timetable){
        tableList.remove(timetable);
    }
}