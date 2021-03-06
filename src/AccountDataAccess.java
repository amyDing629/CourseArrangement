import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AccountDataAccess implements iDataAccess {
    private final String serFilePath = "src/accounts.ser";
    private List<Account> accountList;

    @Override
    public List<Object> getList() {
        deSerialize();
        return new ArrayList<>(accountList);
    }


    @Override
    public Object getObject(UUID uuid) {
        deSerialize();
        for (Account c : accountList) {
            if (c.getID().equals(uuid))
                return c;
        }
        return null;
    }

    @Override
    public Object getObject(String code) {
        return null;
    }

    /**
     * add trade to file
     * @param o
     */
    @Override
    public void addObject(Object o) {
        deSerialize();
        accountList.add((Account) o);
        updateSer();
    }

    @Override
    public boolean hasObject(Object o) {
        deSerialize();
        for (Account i: accountList){
            if (i.getID().equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeObject(String o) {

    }

    @Override
    public void removeObject(UUID o) {
        deSerialize();
        accountList.removeIf(i -> i.getID().equals(o));
        updateSer();

    }

    /**
     * update info from temporary ist to file
     */
    @Override @SuppressWarnings("ALL")
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

                accountList = (List<Account>) in.readObject();
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

            out.writeObject(accountList);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}
