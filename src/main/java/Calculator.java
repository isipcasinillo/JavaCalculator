import javax.swing.*; // Creating buttons and scrollbars.
import java.awt.*; // API for Creating and Managing GUI
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textfield;

    // create button for numbers 0-9
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];

    // create function buttons
    JButton addButton, subButton, multiplyButton, divButton;
    JButton decimalButton, equalsButton, delButton, clearButton;
    JPanel panel;

    //num1 is for the first value of the equation while num2 is the second value
    double num1 = 0, num2=0, result=0;

    // Constructor for the Calculator
    Calculator(){

    }

    public static void main(String[] args) {

        // Instance of the Calculator Object
    Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
