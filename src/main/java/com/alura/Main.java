package com.alura;
// Swing

import com.alura.type.currency.Coin;
import com.alura.type.length.Meter;
import com.alura.type.length.utils.LengthUnits;
import com.alura.type.tempeture.Temperature;
import com.alura.type.tempeture.utils.TemperatureTypes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class Main extends JFrame {

    Map<String, Double> currencyRates = new HashMap<>();
    public Main() {
        setTitle("Unit Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Currency", createCurrencyConverterPanel());
        tabbedPane.addTab("Length Units", createLengthConverterPanel());
        tabbedPane.addTab("Temperature Units", createTemperatureConverterPanel());
        add(tabbedPane, BorderLayout.CENTER);

    }

    private JPanel createLengthConverterPanel() {

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        String[] units =new String[LengthUnits.values().length];
        // get the length of the enum
        LengthUnits[] lengthUnits = LengthUnits.values();
        for (int i = 0; i < lengthUnits.length; i++) {
            // Uppercase the first letter
            String unit = lengthUnits[i].name().substring(0, 1).toUpperCase() + lengthUnits[i].name().substring(1).toLowerCase();
            units[i] = unit;
        }
        JComboBox<String> unit1ComboBox = new JComboBox<>(units);
        JComboBox<String> unit2ComboBox = new JComboBox<>(units);

        JTextField input1TextField = new JTextField(10);
        JTextField input2TextField = new JTextField(10);
        input2TextField.setEditable(false);

        JButton convertButton = new JButton("Convert");
        JButton clearInputButton = new JButton("Clear Input");
        JButton clearResultButton = new JButton("Clear Result");

        JTextArea resultTextArea = new JTextArea(3, 30);
        resultTextArea.setEditable(false);

        panel.add(input1TextField);
        panel.add(unit1ComboBox);
        panel.add(new JLabel("to"));
        panel.add(input2TextField);
        panel.add(unit2ComboBox);
        panel.add(convertButton);
        panel.add(resultTextArea);
        panel.add(clearInputButton);
        panel.add(clearResultButton);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double inputValue = Double.parseDouble(input1TextField.getText());
                    double convertedValue = unitConvert(inputValue,unit1ComboBox.getSelectedIndex(),unit2ComboBox.getSelectedIndex());
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

        return panel;
    }
    private JPanel createTemperatureConverterPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        String[] temperatureUnits = {"Celsius", "Fahrenheit", "Kelvin"};

        JComboBox<String> tempUnit1ComboBox = new JComboBox<>(temperatureUnits);
        JComboBox<String> tempUnit2ComboBox = new JComboBox<>(temperatureUnits);

        JTextField tempInput1TextField = new JTextField(10);
        JTextField tempInput2TextField = new JTextField(10);
        tempInput2TextField.setEditable(false);

        JButton tempConvertButton = new JButton("Convert");
        JTextArea tempResultTextArea = new JTextArea(3, 30);
        tempResultTextArea.setEditable(false);

        panel.add(tempInput1TextField);
        panel.add(tempUnit1ComboBox);
        panel.add(new JLabel("to"));
        panel.add(tempInput2TextField);
        panel.add(tempUnit2ComboBox);
        panel.add(tempConvertButton);
        panel.add(tempResultTextArea);

        tempConvertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double inputValue = Double.parseDouble(tempInput1TextField.getText());

                    double convertedValue = temperatureConvert(inputValue,
                            tempUnit1ComboBox.getSelectedIndex(),
                            tempUnit2ComboBox.getSelectedIndex());
                    tempInput2TextField.setText(formatResult(convertedValue));
                    tempResultTextArea.setText("Converted successfully.");
                } catch (NumberFormatException ex) {
                    tempResultTextArea.setText("Invalid input. Please enter a valid number.");
                }
            }
        });

        return panel;
    }

    private JPanel createCurrencyConverterPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        String[] currencyUnits = {"Dollar", "Mexican Peso", "British Pound", "Euro", "Yen"};

        JComboBox<String> currencyUnit1ComboBox = new JComboBox<>(currencyUnits);
        JComboBox<String> currencyUnit2ComboBox = new JComboBox<>(currencyUnits);

        JTextField currencyInput1TextField = new JTextField(10);
        JTextField currencyInput2TextField = new JTextField(10);
        currencyInput2TextField.setEditable(false);

        JButton currencyConvertButton = new JButton("Convert");
        JButton updateRatesButton = new JButton("Update Rates");
        JTextArea currencyResultTextArea = new JTextArea(3, 30);
        currencyResultTextArea.setEditable(false);

        panel.add(currencyInput1TextField);
        panel.add(currencyUnit1ComboBox);
        panel.add(new JLabel("to"));
        panel.add(currencyInput2TextField);
        panel.add(currencyUnit2ComboBox);
        panel.add(currencyConvertButton);
        panel.add(currencyResultTextArea);
        panel.add(updateRatesButton);
        try {
            Coin coin = new Coin();
            currencyRates = coin.updateCurrencyRates();

        } catch (Exception e) {
            System.err.println("Error fetching initial currency rates. Please try updating rates manually.");
        }
        currencyConvertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Coin coin = new Coin();

                    double inputValue = Double.parseDouble(currencyInput1TextField.getText());
                    double convertedValue = coin.convertCurrency(inputValue,currencyRates,
                            currencyUnit1ComboBox.getSelectedIndex(),
                            currencyUnit2ComboBox.getSelectedIndex());
                    currencyInput2TextField.setText(formatResult(convertedValue));
                    currencyResultTextArea.setText("Converted successfully.");
                } catch (NumberFormatException ex) {
                    currencyResultTextArea.setText("Invalid input. Please enter a valid number.");
                }
            }
        });

        updateRatesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Coin coin = new Coin();
                    coin.updateCurrencyRates();
                    currencyResultTextArea.setText("Currency rates updated successfully.");
                } catch (Exception ex) {
                    currencyResultTextArea.setText("Error updating rates. Please try again.");
                }
            }
        });

        return panel;
    }

    private String formatResult(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##########");
        return decimalFormat.format(value);
    }

    private double unitConvert(double value, int fromUnit, int toUnit) {
        Meter meter = new Meter();
        // Get the value from the input field
        LengthUnits unit1 = LengthUnits.values()[fromUnit];
        LengthUnits unit2 = LengthUnits.values()[toUnit];

        return meter.convert(value,unit1, unit2);
    }

    private double temperatureConvert(double value, int fromUnit, int toUnit) {
        Temperature temperature = new Temperature();

        // Get the value from the input field
        TemperatureTypes unit1 = TemperatureTypes.values()[fromUnit];
        TemperatureTypes unit2 = TemperatureTypes.values()[toUnit];
        return temperature.convert(value,unit1, unit2);
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
    }
}