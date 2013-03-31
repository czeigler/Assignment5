import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIdemo extends JPanel implements ActionListener {


    private JLabel label1;
    private JLabel label2;
    private JTextField field1;
    private JTextField field2;
    private JButton TransferButton;
    private JButton CloseButton;

    public GUIdemo() {

        makeTheObjects();
        doTheLayout();
        TransferButton.addActionListener( new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){
                transfer_actionPerformed(e);
            }
        });
        CloseButton.addActionListener( new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){
                close_actionPerformed(e);
            }
        });

    } // end of constructor

    private void makeTheObjects(){
        label1 = new JLabel("Type some text here:");
        label2 = new JLabel("Your text will appear here:");
        field1 = new JTextField("This is the default text", 30);
        field2 = new JTextField(30);
        TransferButton = new JButton("Transfer");
        CloseButton = new JButton("Close");
        field2.setEditable(false);

    }// end of creating objects method

    private void doTheLayout(){

        JPanel top = new JPanel();
        JPanel center = new JPanel();
        JPanel bottom = new JPanel();

        top.setLayout( new FlowLayout());
        top.add(label1);
        top.add(field1);

        center.setLayout( new FlowLayout());
        center.add(label2);
        center.add(field2);

        bottom.setLayout( new FlowLayout());
        bottom.add(TransferButton);
        bottom.add(CloseButton);

        setLayout( new BorderLayout());
        add(top, "North");
        add(center, "Center");
        add(bottom, "South");

    }// end of Layout method

    public void actionPerformed(ActionEvent e){}

    void transfer_actionPerformed(ActionEvent e){
        String mytext = field1.getText();
        field2.setText(mytext);
    }// end of transfer action event method

    void close_actionPerformed(ActionEvent e){
        System.exit(0);
    }// end of transfer action event method

}