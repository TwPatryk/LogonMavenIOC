package root.database;

import root.model.User;

import java.util.List;

public interface IUserRepository {
    boolean authenticate (String login, String pass);
    List<User> getUserList();
    boolean checkIfUserExists (String login);
}
