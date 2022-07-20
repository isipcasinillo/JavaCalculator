import javax.swing.*; // Creating buttons and scrollbars.
import java.awt.*; // API for Creating and Managing GUI
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textfield;

    // create button for numbers 0-9
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];

    // create function buttons
    JButton addButton, subButton, multiplyButton, divButton;
    JButton decimalButton, equalsButton, delButton, clearButton, negativeButton;
    JPanel panel;

    //num1 is for the first value of the equation while num2 is the second value
    double num1 = 0, num2=0, result=0;
    char operator;
    // Constructor for the Calculator
    Calculator(){
    frame = new JFrame("Calculator");
    // close on exit
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    // size of the application tab
    frame.setSize(420, 550);
    frame.setLayout(null);
    textfield = new JTextField();
    textfield.setBounds(50, 25, 300, 50);
    // disables any input on the text field itself
    textfield.setEditable(false);

    addButton = new JButton("+");
    subButton = new JButton("-");
    multiplyButton = new JButton("*");
    divButton = new JButton("/");
    decimalButton = new JButton(".");
    equalsButton = new JButton("=");
    delButton = new JButton("Delete");
    clearButton = new JButton("Clear");
    negativeButton = new JButton("(-)");

    functionButtons[0] = addButton;
    functionButtons[1] = subButton;
    functionButtons[2] = multiplyButton;
    functionButtons[3] = divButton;
    functionButtons[4] = decimalButton;
    functionButtons[5] = equalsButton;
    functionButtons[6] = delButton;
    functionButtons[7] = clearButton;
    functionButtons[8] = negativeButton;

    // loop to bind actionListener to function buttons
    for(int i = 0; i<9; i++) {
        functionButtons[i].addActionListener(this);
        functionButtons[i].setFocusable(false);
    }

    // loop to bind actionListner to number button
    for(int i = 0; i<10; i++) {
        numberButtons[i] = new JButton(String.valueOf(i));
        numberButtons[i].addActionListener(this);
        numberButtons[i].setFocusable(false);
    }

    // places both buttons on the frame in respect to their x and y position
    delButton.setBounds(150,430, 100, 50);
    clearButton.setBounds(250,430, 100, 50);
    negativeButton.setBounds(50,430,100,50);
    // Panel is a container for components
    panel = new JPanel();
    // the panel is crated with the width and height to specifically store the components
    panel.setBounds(50,100,300,300);
    panel.setLayout(new GridLayout(4,4,10,10));

    panel.add(numberButtons[1]);
    panel.add(numberButtons[2]);
    panel.add(numberButtons[3]);
    panel.add(addButton);
    panel.add(numberButtons[4]);
    panel.add(numberButtons[5]);
    panel.add(numberButtons[6]);
    panel.add(subButton);
    panel.add(numberButtons[7]);
    panel.add(numberButtons[8]);
    panel.add(numberButtons[9]);
    panel.add(multiplyButton);
    panel.add(decimalButton);
    panel.add(numberButtons[0]);
    panel.add(equalsButton);
    panel.add(divButton);

    frame.add(panel);
    // appends the buttons to the frame
    frame.add(negativeButton);
    frame.add(delButton);
    frame.add(clearButton);
    // adds the text field to the window
    frame.add(textfield);

    // minimize
    frame.setVisible(true);

    }



    public static void main(String[] args) {

        // Instance of the Calculator Object
    Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i =0; i<10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decimalButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource()==addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator= '+';
            textfield.setText("");
        }
        if(e.getSource()==subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator= '-';
            textfield.setText("");
        }
        if(e.getSource()==multiplyButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator= '*';
            textfield.setText("");
        }
        if(e.getSource()==divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator= '/';
            textfield.setText("");
        }
        if(e.getSource() == equalsButton){
            num2 = Double.parseDouble(textfield.getText());

            switch(operator) {
                case'+':
                    result = num1 + num2;
                    break;
                case'-':
                    result = num1 - num2;
                    break;
                case'*':
                    result = num1 * num2;
                    break;
                case'/':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource()==clearButton) {
            textfield.setText("");
        }
        if(e.getSource()==delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
        if(e.getSource() == negativeButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp*= -1;
            textfield.setText(String.valueOf(temp));
        }

    }
}
