package com.alura;
// Swing

import com.alura.type.length.Meter;
import com.alura.type.length.utils.LengthSlugs;
import com.alura.type.length.utils.LengthUnits;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.*;

public class Main extends JFrame {

    // Variables declaration
    private JComboBox<String> unit1ComboBox;
    private JComboBox<String> unit2ComboBox;
    private JTextField input1TextField;
    private JTextField input2TextField;
    private JButton convertButton;
    private JButton clearInputButton;
    private JButton clearResultButton;
    private JTextArea resultTextArea;

    // End of variables declaration

    public Main() {
        setTitle("Unit Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLayout(new FlowLayout());

        String[] units =new String[LengthUnits.values().length];
        // get the length of the enum
        LengthUnits[] lengthUnits = LengthUnits.values();
        for (int i = 0; i < lengthUnits.length; i++) {
            // Uppercase the first letter
            String unit = lengthUnits[i].name().substring(0, 1).toUpperCase() + lengthUnits[i].name().substring(1).toLowerCase();
            units[i] = unit;
        }
        unit1ComboBox = new JComboBox<>(units);
        unit2ComboBox = new JComboBox<>(units);

        input1TextField = new JTextField(10);
        input2TextField = new JTextField(10);
        input2TextField.setEditable(false);

        convertButton = new JButton("Convert");
        clearInputButton = new JButton("Clear Input");
        clearResultButton = new JButton("Clear Result");

        resultTextArea = new JTextArea(3, 30);
        resultTextArea.setEditable(false);

        add(input1TextField);
        add(unit1ComboBox);
        add(new JLabel("to"));
        add(input2TextField);
        add(unit2ComboBox);
        add(convertButton);
        add(resultTextArea);
        add(clearInputButton);
        add(clearResultButton);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the value from the input field
                    LengthUnits unit1 = LengthUnits.values()[unit1ComboBox.getSelectedIndex()];
                    LengthUnits unit2 = LengthUnits.values()[unit2ComboBox.getSelectedIndex()];


                    double inputValue = Double.parseDouble(input1TextField.getText());
                    double convertedValue = convert(inputValue,unit1,unit2);
                    input2TextField.setText(formatResult(convertedValue));
                    resultTextArea.setText("Converted successfully.");
                } catch (NumberFormatException ex) {
                    resultTextArea.setText("Invalid input. Please enter a valid number.");
                }
            }
        });

        clearInputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input1TextField.setText("");
                input2TextField.setText("");
                resultTextArea.setText("");
            }
        });

        clearResultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input2TextField.setText("");
                resultTextArea.setText("");
            }
        });

    }

    private String formatResult(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##########");
        return decimalFormat.format(value);
    }

    private double convert(double value, LengthUnits fromUnit, LengthUnits toUnit) {
        Meter meter = new Meter();
        double valueInMeters = meter.getValueInMeters(value,fromUnit);
        return meter.setValueFromMeters(valueInMeters, toUnit);
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
    }
}