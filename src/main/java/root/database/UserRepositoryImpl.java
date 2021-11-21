package root.database;

import org.apache.commons.codec.digest.DigestUtils;
import root.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements IUserRepository {

    private List<User> userList = new ArrayList<>();

    private UserRepositoryImpl() {
        this.userList.add(new User("admin", DigestUtils.md5Hex("admin")));
    }


    public boolean authenticate(String login, String pass) {
        for (User currentUser : this.userList) {
            if (currentUser instanceof User) {
                if (currentUser.getLogin().equals(login) && currentUser.getPass().equals(DigestUtils.md5Hex(pass))) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<User> getUserList() {
        return this.userList;
    }

    public boolean checkIfUserExists(String login) {
        for (User currentUser : this.userList) {
            if (currentUser instanceof User) {
                if (currentUser.getLogin().equals(login)) {
                    return true;
                }
            }
        }
        return false;
    }
}
