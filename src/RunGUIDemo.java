import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class RunGUIdemo extends JFrame{


    public static void main(String[] args){



        JFrame f = new RunGUIdemo();
        f.setTitle("This is the Title of my Application Window");
        Container contentPane = f.getContentPane();
        contentPane.add( new GUIdemo());
        f.pack();
        f.setVisible(true);

    }// end main
}// end class RunGUIdemo