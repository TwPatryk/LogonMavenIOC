package root;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import root.gui.GUI;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        GUI gui = context.getBean(GUI.class);

        gui.showMainMenu();
    }
}
