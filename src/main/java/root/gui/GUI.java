package root.gui;

import root.database.IUserRepository;
import root.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class GUI {
    private Scanner scanner = new Scanner(System.in);

    @Autowired
    private IUserRepository usersRepository;

    public void showMainMenu() {
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");


        switch (scanner.nextLine()) {
            case "1" :
                showLoginScreen();
                showMainMenu();
                break;
            case "2" :
                showRegisterScreen();
                showMainMenu();
                break;
            case "3":
                System.exit(0);
            default :
                System.out.println("Incorrect, try again");
                showMainMenu();
                break;
        }
    }
    private void showLoginScreen() {
        System.out.println("Enter login: ");
        String login = scanner.nextLine();
        System.out.println("Enter password: ");
        String pass = scanner.nextLine();

        boolean success = usersRepository.authenticate(login, pass);
        if (success) {
            System.out.println("Authorization granted! ");
        } else {
            System.out.println("Authorization unsuccessfull, try again");
        }
    }
    private void showRegisterScreen() {
        System.out.println("Enter new username: ");
        String username = scanner.nextLine();
        System.out.println("Enter new password");
        String pass = scanner.nextLine();
        boolean authenticationResult = usersRepository.checkIfUserExists(username);
        if (authenticationResult) {
            System.out.println("User already exists, try again");
            showRegisterScreen();
        } else {
            usersRepository.getUserList().add(new User(username, DigestUtils.md5Hex(pass)));
            System.out.println("New user created successfully");
        }
    }
}
