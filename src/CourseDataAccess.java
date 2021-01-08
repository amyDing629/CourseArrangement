import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CourseDataAccess implements iDataAccess{
    private final String serFilePath = "src/courses.ser";
    private List<Course> courseList;

    public CourseDataAccess() {
        courseList = new ArrayList<>();

        try {
            File serFile = new File(serFilePath);
            if (serFile.exists()) {
                deSerialize();
            } else {
                serFile.createNewFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Object> getList() {
        deSerialize();
        return new ArrayList<>(courseList);
    }

    @Override
    public Object getObject(UUID uuid) {
        return null;
    }


    @Override
    public Object getObject(String courseID) {
        deSerialize();
        for (Course c : courseList) {
            if (c.getCourseID().equals(courseID))
                return c;
        }
        return null;
    }

    @Override
    public void addObject(Object o) {
        deSerialize();
        courseList.add((Course) o);
        updateSer();

    }

    @Override
    public boolean hasObject(Object o) {
        deSerialize();
        for (Course i: courseList){
            if (i.getCourseID().equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeObject(String o) {
        deSerialize();
        courseList.removeIf(i -> i.getCourseID().equals(o));
        updateSer();
    }

    @Override
    public void removeObject(UUID o) {

    }

    @Override
    public void updateSer() {
        File file = new File(serFilePath);
        file.delete();
        try {
            if(!file.exists()) {
                boolean result = file.createNewFile();
                if (!result){
                    System.out.println("the new file is not created");
                }
            }
            FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        serialize();

    }

    @Override
    @SuppressWarnings("unchecked")
    public void deSerialize() {
        try {
            File file = new File(serFilePath);
            if (!(file.length() == 0)){
                FileInputStream fileIn = new FileInputStream(serFilePath);
                InputStream buffer = new BufferedInputStream(fileIn);
                ObjectInputStream in = new ObjectInputStream(buffer);

                courseList = (List<Course>) in.readObject();
                in.close();
                fileIn.close();
            }

        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }

    }

    /**
     * write to file
     */
    private void serialize() {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(serFilePath);
            OutputStream buffer = new BufferedOutputStream(fileOut);
            ObjectOutputStream out = new ObjectOutputStream(buffer);

            out.writeObject(courseList);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}