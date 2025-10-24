/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package musiclessonapp;

/**
 *
 * @author lab_services_student
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MusicLessonApp extends JFrame implements ActionListener {

    private JComboBox<String> instrumentBox, levelBox;
    private JButton submitButton, reportButton;
    private JLabel resultLabel;

    // Instrument and level data
    private final String[] instruments = {"Guitar", "Piano", "Violin"};
    private final String[] levels = {"Beginner", "Intermediate", "Advanced"};

    // Prices table [level][instrument]
    private final int[][] prices = {
        {150, 250, 280}, // Beginner
        {215, 232, 280}, // Intermediate
        {130, 185, 310}  // Advanced
    };

    public MusicLessonApp() {
        setTitle("Music Lesson Cost Calculator");
        setSize(450, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Combo boxes
        instrumentBox = new JComboBox<>(instruments);
        levelBox = new JComboBox<>(levels);

        // Buttons
        submitButton = new JButton("Submit");
        reportButton = new JButton("Show Average Report");

        // Label
        resultLabel = new JLabel("Select instrument and level.");

        // Add components
        add(new JLabel("Select Instrument:"));
        add(instrumentBox);
        add(new JLabel("Select Musical Level:"));
        add(levelBox);
        add(submitButton);
        add(reportButton);
        add(new JLabel("Lesson Cost:"));
        add(resultLabel);

        // Add listeners
        submitButton.addActionListener(this);
        reportButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            showLessonCost();
        } else if (e.getSource() == reportButton) {
            showAverageReport();
        }
    }

    private void showLessonCost() {
        int instrumentIndex = instrumentBox.getSelectedIndex();
        int levelIndex = levelBox.getSelectedIndex();
        int cost = prices[levelIndex][instrumentIndex];
        resultLabel.setText("R" + cost);
    }

    private void showAverageReport() {
        StringBuilder report = new StringBuilder();
        double totalSum = 0;
        int totalCount = 0;

        // Calculate average per level
        for (int i = 0; i < levels.length; i++) {
            int sum = 0;
            for (int j = 0; j < instruments.length; j++) {
                sum += prices[i][j];
            }
            double avg = sum / (double) instruments.length;
            totalSum += sum;
            totalCount += instruments.length;
            report.append(levels[i]).append(" average: R").append(String.format("%.2f", avg)).append("\n");
        }

        // Overall average
        double overallAvg = totalSum / totalCount;
        report.append("\nOverall average cost: R").append(String.format("%.2f", overallAvg));

        JOptionPane.showMessageDialog(this, report.toString(), "Average Lesson Report", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new MusicLessonApp();
    }
}
