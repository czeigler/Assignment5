
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: chris
 * Date: 3/8/13
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Application implements ActionListener {

    public static final String BUTTON_TEXT_ADD = "Add";
    public static final String BUTTON_TEXT_SUBTRACT = "Subtract";
    public static final String BUTTON_TEXT_MULTIPLY = "Multiply";
    public static final String BUTTON_TEXT_DIVIDE = "Divide";
    JTextField resultsField;
    JTextField num1Field;
    JTextField num2Field;
    private JLabel num1Label;
    private JLabel num2Label;
    private JLabel resultsLabel;

    public void run() {

        JFrame frame = new JFrame("My Calculator");

        frame.setSize(550,100);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel buttonsPanel = doTheLayout();
        JPanel fieldsPanel = getFieldsPanel();
        BorderLayout calculatorLayout = new BorderLayout();
        frame.setLayout(calculatorLayout);

        frame.add(fieldsPanel, BorderLayout.NORTH);
        frame.add(buttonsPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

    }

    private JPanel getFieldsPanel() {
        JPanel fieldsPanel = new JPanel();
        FlowLayout gridLayout = new FlowLayout();
        fieldsPanel.setLayout(gridLayout);
        makeTheObjects();

        fieldsPanel.add(num1Label);
        fieldsPanel.add(num1Field);
        fieldsPanel.add(num2Label);
        fieldsPanel.add(num2Field);
        fieldsPanel.add(resultsLabel);
        fieldsPanel.add(resultsField);


        return fieldsPanel;
    }

    private void makeTheObjects() {
        num1Label = new JLabel("Number 1:");
        num2Label = new JLabel("Number 2:");
        resultsLabel = new JLabel("Results:");
        num1Field = new JTextField(5);
        num2Field = new JTextField(5);
        resultsField = new JTextField(15);
        resultsField.setEditable(false);
    }


    // create the buttons for the calculator
    private JPanel doTheLayout() {
        JPanel numbersPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(1, 4);
        numbersPanel.setLayout(gridLayout);


        addCalculatorButton(numbersPanel, BUTTON_TEXT_ADD);
        addCalculatorButton(numbersPanel, BUTTON_TEXT_SUBTRACT);
        addCalculatorButton(numbersPanel, BUTTON_TEXT_MULTIPLY);
        addCalculatorButton(numbersPanel, BUTTON_TEXT_DIVIDE);
        return numbersPanel;

    }

    private void addCalculatorButton(JPanel numbersPanel, String buttonText) {
        JButton button = new JButton(buttonText);
        button.addActionListener(this);
        numbersPanel.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (validateNumberFields()) {
            double number1 = Double.parseDouble(num1Field.getText());
            double number2 = Double.parseDouble(num2Field.getText());

            if(actionEvent.getActionCommand().equals(BUTTON_TEXT_ADD)) {
                    resultsField.setText(String.valueOf(number1 + number2));

            } else if(actionEvent.getActionCommand().equals(BUTTON_TEXT_SUBTRACT)) {
                resultsField.setText(String.valueOf(number1 - number2));

            } else if(actionEvent.getActionCommand().equals(BUTTON_TEXT_MULTIPLY)) {
                resultsField.setText(String.valueOf(number1 * number2));

            } else if(actionEvent.getActionCommand().equals(BUTTON_TEXT_DIVIDE)) {
                if(number2 != 0) {
                    resultsField.setText(String.valueOf(number1 / number2));
                } else {
                    JOptionPane.showMessageDialog(null, "Number 2 cannot be zero if you are dividing.", "Error", JOptionPane.ERROR_MESSAGE);

                }

            }
        }

    }

    private boolean validateNumberFields() {
        Pattern regexPattern = Pattern.compile("[0-9.]+");
        Matcher matcher = regexPattern.matcher(num1Field.getText());
        if(! matcher.matches()) {
            JOptionPane.showMessageDialog(null, "Number 1 must be a whole or decimal number.  Do not include any other symbols or punctuation ", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        matcher = regexPattern.matcher(num2Field.getText());
        if(! matcher.matches()) {
            JOptionPane.showMessageDialog(null, "Number 2 must be a whole or decimal number.  Do not include any other symbols or punctuation", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;

    }

}



