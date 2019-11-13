package AssignmentEight.Calculator;

import javax.swing.*;
import java.awt.*;

class Calculator extends BaseFrame {

    private JLabel firstLabel, secondLabel, operationLabel, resultLabel;
    private JTextField firstText, secondText;
    private JComboBox operation;
    private JButton resultsButton;

    @Override
    public void add(Container con) {
        GridLayout gl = new GridLayout(5, 2);
        con.setLayout(gl);
        addFirstComponent(con);
        addOperations(con);
        addSecondComponent(con);
        addResultButton(con);
        addResultLabel(con);
    }

    private void addResultLabel(Container con) {
        con.add(resultLabel);
    }

    private void addResultButton(Container con) {
        con.add(resultsButton);
    }

    private void addOperations(Container con) {
        addComponents(con, operationLabel, operation);
    }

    private void addSecondComponent(Container con) {
        addComponents(con, secondLabel, secondText);
    }

    private void addFirstComponent(Container con) {
        addComponents(con, firstLabel, firstText);
    }

    private void addComponents(Container con, Container m, Container n) {
        JPanel panel = new JPanel();
        panel.add(m);
        panel.add(n);
        con.add(panel);
    }

    @Override
    protected void addListeners() {
        resultsButton.addActionListener((e) -> calculateAndStoreRes());
    }

    private void calculateAndStoreRes() {
        int a = 0;
        try {
            a = Integer.parseInt(firstText.getText());
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, "Please Enter Number In the First Text Field");
            throw e;
        }
        int b = Integer.parseInt(secondText.getText());
        String option = operation.getSelectedItem().toString();
        int result = getResult(a, b, option);
        String answer = a + " " + option + " " + b + " = " + result;
        resultLabel.setText(answer);
    }

    private int getResult(int a, int b, String option) {
        if (option.equals("+"))
            return a + b;
        if (option.equals("-"))
            return a - b;
        if (option.equals("*"))
            return a * b;
        return a / b;
    }

    @Override
    protected void create() {
        firstLabel = new JLabel("First Number : ");
        secondLabel = new JLabel("Second Number : ");
        operationLabel = new JLabel("Operation : ");
        resultLabel = new JLabel("Result : ");

        firstText = new JTextField(12);
        secondText = new JTextField(12);

        operation = new JComboBox(new String[]{"+", "-", "*", "/"});
        resultsButton = new JButton("** Compute **");
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
