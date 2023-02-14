import javax.swing.*;

public class Calculator {
    public static void main(String[] args) {
        double number1, number2;
        int option;
        boolean condition = true;

        while (condition){
            option = Integer.parseInt(JOptionPane.showInputDialog("""
                    WELCOME TO THE CALCULATOR
                    ENTER THE OPTION TO PERFORM
                    1- SUM\s
                    2- SUBTRACT\s 
                    3- MULTIPLY\s
                    4- DIVIDE\s
                    5- MODULE\s  
                    6- EXIT"""
            ));
            switch (option) {
                case 1->{
                    number1 = Double.parseDouble(JOptionPane.showInputDialog("ENTER THE FIRST NUMBER: "));
                    number2 = Double.parseDouble(JOptionPane.showInputDialog("ENTER THE SECOND NUMBER:"));
                    double sum = number1 + number2;
                    JOptionPane.showMessageDialog(null,"THE SUM IS:" + sum);
                }
                case 2->{
                    number1 = Double.parseDouble(JOptionPane.showInputDialog("ENTER THE FIRST NUMBER: "));
                    number2 = Double.parseDouble(JOptionPane.showInputDialog("ENTER THE SECOND NUMBER: "));
                    double subtract = number1 - number2;
                    JOptionPane.showMessageDialog(null,"THE REMAINDER IS: " + subtract);
                }
                case 3->{
                    number1 = Double.parseDouble(JOptionPane.showInputDialog("ENTER THE FIRST NUMBER: "));
                    number2 = Double.parseDouble(JOptionPane.showInputDialog("ENTER THE SECOND NUMBER: "));
                    double multiply = number1 * number2;
                    JOptionPane.showMessageDialog(null,"THE MULTIPLICATION IS: " + multiply);
                }
                case 4->{
                    number1 = Double.parseDouble(JOptionPane.showInputDialog("ENTER THE FIRST NUMBER: "));
                    number2 = Double.parseDouble(JOptionPane.showInputDialog("ENTER THE SECOND NUMBER: "));
                    if (number2==0) {
                        JOptionPane.showMessageDialog(null,"CANNOT DIVIDE BY ZERO, ENTER ANOTHER NUMBER: ");
                    } else {
                        double divide = number1 / number2;
                        JOptionPane.showMessageDialog(null,"THE DIVISION IS: " + divide);
                    }

                }
                case 5->{ // es el resto de la division del dividendo por el divisor
                    number1 = Double.parseDouble(JOptionPane.showInputDialog("ENTER THE FIRST NUMBER: "));
                    number2 = Double.parseDouble(JOptionPane.showInputDialog("ENTER THE SECOND NUMBER: "));
                    Double module = number1 % number2;
                    JOptionPane.showMessageDialog(null,"THE MODULE IS: " + module);
                }
                case 6->{
                    condition = false;
                    JOptionPane.showMessageDialog(null,"YOU CAME OUT OF THE CALCULATOR");
                }
            }
        }
    }
}
