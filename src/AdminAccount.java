import java.io.Serializable;

public class AdminAccount extends Account implements Serializable {
    public AdminAccount(String email, String password, boolean isAdmin) {
        super(email, password, isAdmin);
    }

}