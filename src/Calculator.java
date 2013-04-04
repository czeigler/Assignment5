import javax.swing.*;

/**
 * User: chris
 * Date: 3/8/13
 * Time: 4:01 PM
 * CIS 611 Assignment #5
 *
 * A calculator class that is the main entry point for the application
 */
public class Calculator {

    public static void main(String[] args) {

        JFrame f = new Application();
        // set the desired size for the frame
        f.setSize(550,120);

        // set the window in relation to nothing - center it
        f.setLocationRelativeTo(null);

        // what to do with the application when this frame is closed - exit the application
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setTitle("My Calculator");

        // size the frame so that all the components are the desired size
        f.pack();

        f.setVisible(true);
    }
}
