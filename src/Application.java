
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**=====================================================================================================================
 * User: chris
 * Date: 3/8/13
 * Time: 4:01 PM
 * CIS 611 Assignment #5
 *
 * The GUI for the calculator application
 =====================================================================================================================*/

public class Application extends JFrame implements ActionListener {

    public static final String BUTTON_TEXT_ADD = "Add";
    public static final String BUTTON_TEXT_SUBTRACT = "Subtract";
    public static final String BUTTON_TEXT_MULTIPLY = "Multiply";
    public static final String BUTTON_TEXT_DIVIDE = "Divide";
    private JTextField resultsField;
    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel num1Label;
    private JLabel num2Label;
    private JLabel resultsLabel;

    //==================================================================================================================
    // the constructor is the main method for setting up the GUI
    public Application() {

        // call our method to create and add all the controls to the window
        makeTheObjects();
        doTheLayout(this);

    }

    //==================================================================================================================
    private void doTheLayout(JFrame frame) {
        // create a panel with the buttons on it the panels allow me to
        // layout the controls at a more granular level add the panel to the frame
        JPanel buttonsPanel = getButtonsPanel();

        // create a panel with the fields on it
        JPanel fieldsPanel = getFieldsPanel();

        // this layout lets you put components around the outside of the frame
        BorderLayout calculatorLayout = new BorderLayout();
        frame.setLayout(calculatorLayout);

        // the north position is just at the top of the layout
        frame.add(fieldsPanel, BorderLayout.NORTH);
        // center puts the panel in the frame and allows it to expand to fit the available space
        frame.add(buttonsPanel, BorderLayout.CENTER);
    }

    //==================================================================================================================
    private JPanel getFieldsPanel() {
        JPanel fieldsPanel = new JPanel();
        // create a layout for the fields that will just place them left to right
        FlowLayout flowLayout = new FlowLayout();
        fieldsPanel.setLayout(flowLayout);


        // add the fields that we created to the panel in the correct order
        fieldsPanel.add(num1Label);
        fieldsPanel.add(num1Field);
        fieldsPanel.add(num2Label);
        fieldsPanel.add(num2Field);
        fieldsPanel.add(resultsLabel);
        fieldsPanel.add(resultsField);

        return fieldsPanel;
    }

    //==================================================================================================================
    // create the form controls
    private void makeTheObjects() {
        // this method creates the labels and the text fields for the input
        num1Label = new JLabel("Number 1:");
        num2Label = new JLabel("Number 2:");
        resultsLabel = new JLabel("Results:");
        // create and set the sizes of the text fields
        num1Field = new JTextField(5);
        num2Field = new JTextField(5);
        // create the results field and make it read only
        resultsField = new JTextField(15);
        resultsField.setEditable(false);
    }

    //==================================================================================================================
    // create the buttons for the calculator
    private JPanel getButtonsPanel() {
        JPanel numbersPanel = new JPanel();

        // make a layout that is one component high and four wide
        GridLayout gridLayout = new GridLayout(1, 4);
        numbersPanel.setLayout(gridLayout);

        // put the buttons in the panel in the order that they should
        // be displayed left to right
        addCalculatorButton(numbersPanel, BUTTON_TEXT_ADD);
        addCalculatorButton(numbersPanel, BUTTON_TEXT_SUBTRACT);
        addCalculatorButton(numbersPanel, BUTTON_TEXT_MULTIPLY);
        addCalculatorButton(numbersPanel, BUTTON_TEXT_DIVIDE);
        return numbersPanel;

    }

    //==================================================================================================================
    // create a button and set up the action listener for it
    private void addCalculatorButton(JPanel numbersPanel, String buttonText) {
        JButton button = new JButton(buttonText);
        // make the first letter of the caption a keyboard shortcut
        button.setMnemonic(buttonText.charAt(0));
        // the Application class implements ActionListener so add this as
        // the listener
        button.addActionListener(this);
        numbersPanel.add(button);
    }

    //==================================================================================================================
    // the action listener will be called when an action on a control that is associated
    // with the listener takes place
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        // make sure that the user typed in a valid number for our purposes
        if (validateNumberFields()) {

            // parse the string that's in the text field to a double precision floating point number
            double number1 = Double.parseDouble(num1Field.getText());
            double number2 = Double.parseDouble(num2Field.getText());

            // do the correct operation and display the results in the appropriate field
            if(actionEvent.getActionCommand().equals(BUTTON_TEXT_ADD)) {
                    resultsField.setText(String.valueOf(number1 + number2));

            } else if(actionEvent.getActionCommand().equals(BUTTON_TEXT_SUBTRACT)) {
                resultsField.setText(String.valueOf(number1 - number2));

            } else if(actionEvent.getActionCommand().equals(BUTTON_TEXT_MULTIPLY)) {
                resultsField.setText(String.valueOf(number1 * number2));

            } else if(actionEvent.getActionCommand().equals(BUTTON_TEXT_DIVIDE)) {
                // we definitely don't want to divide by zero!
                if(number2 != 0) {
                    resultsField.setText(String.valueOf(number1 / number2));
                } else {
                    JOptionPane.showMessageDialog(null, "Number 2 cannot be zero if you are dividing.", "Error"
                            , JOptionPane.ERROR_MESSAGE);

                }

            }
        }
    }

    //==================================================================================================================
    // use a regular expression to validate that the number is in the correct format.
    // display an error message if it is not
    private boolean validateNumberFields() {


        Pattern regexPattern = Pattern.compile("[\\-0-9.]+");
        Matcher matcher = regexPattern.matcher(num1Field.getText());
        if(! matcher.matches()) {
            JOptionPane.showMessageDialog(null, "Number 1 must be a whole or decimal number.  Do not include" +
                    " any other symbols or punctuation ", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        matcher = regexPattern.matcher(num2Field.getText());
        if(! matcher.matches()) {
            JOptionPane.showMessageDialog(null, "Number 2 must be a whole or decimal number.  Do not include" +
                    " any other symbols or punctuation", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;

    }

}



