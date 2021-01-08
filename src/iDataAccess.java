import java.util.List;
import java.util.UUID;

public interface iDataAccess {

    List<Object> getList();

    Object getObject(UUID uuid);

    Object getObject(String code);

    void addObject(Object o);

    boolean hasObject(Object o);

    void removeObject(String o);

    void removeObject(UUID o);

    void updateSer(); // write list to ser

    void deSerialize(); // write ser to list



}
