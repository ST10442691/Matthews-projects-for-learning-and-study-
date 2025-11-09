/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package musiclessonapp;

/**
 *
 * @author lab_services_student
 */
// MusicLessonApp.java
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MusicLessonApp extends JFrame {
    private final IMovieTickets pricingModel;

    private final JComboBox<String> instrumentBox;
    private final JComboBox<String> levelBox;
    private final JButton submitButton;
    private final JButton reportButton;
    private final JButton saveButton;
    private final JLabel resultLabel;

    public MusicLessonApp(IMovieTickets pricingModel) {
        super("Music Lesson Cost Calculator");
        this.pricingModel = pricingModel;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 260);
        setLocationRelativeTo(null);

        // Components
        instrumentBox = new JComboBox<>(pricingModel.getInstruments());
        levelBox = new JComboBox<>(pricingModel.getLevels());
        submitButton = new JButton("Calculate Cost");
        reportButton = new JButton("Show Average Report");
        saveButton = new JButton("Save Selection to File...");
        resultLabel = new JLabel("Select instrument and level.", SwingConstants.LEFT);

        // Layout
        setLayout(new BorderLayout(10, 10));
        JPanel center = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        center.add(new JLabel("Instrument:"), gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        center.add(instrumentBox, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.EAST;
        center.add(new JLabel("Level:"), gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        center.add(levelBox, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.anchor = GridBagConstraints.EAST;
        center.add(new JLabel("Lesson Cost:"), gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        center.add(resultLabel, gbc);

        JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 10));
        south.add(submitButton);
        south.add(saveButton);
        south.add(reportButton);

        add(center, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);

        // Listeners
        submitButton.addActionListener(e -> onCalculate());
        reportButton.addActionListener(e -> onReport());
        saveButton.addActionListener(e -> onSave());

        setVisible(true);
    }

    private void onCalculate() {
        try {
            String instrument = (String) instrumentBox.getSelectedItem();
            String level = (String) levelBox.getSelectedItem();
            if (instrument == null || level == null) {
                JOptionPane.showMessageDialog(this, "Please select both instrument and level.", "Validation error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int price = pricingModel.getPrice(instrument, level);
            resultLabel.setText(LessonPricing.formatRand(price));
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Invalid selection: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Unexpected error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onReport() {
        StringBuilder sb = new StringBuilder();
        for (String level : pricingModel.getLevels()) {
            double avg = pricingModel.getAverageForLevel(level);
            sb.append(String.format("%s average: R%.2f%n", level, avg));
        }
        sb.append(String.format("%nOverall average: R%.2f", pricingModel.getOverallAverage()));
        JTextArea ta = new JTextArea(sb.toString());
        ta.setEditable(false);
        ta.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JOptionPane.showMessageDialog(this, new JScrollPane(ta), "Average Lesson Report", JOptionPane.INFORMATION_MESSAGE);
    }

    private void onSave() {
        String instrument = (String) instrumentBox.getSelectedItem();
        String level = (String) levelBox.getSelectedItem();
        if (instrument == null || level == null) {
            JOptionPane.showMessageDialog(this, "Please select instrument and level before saving.", "Validation error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save selection (CSV)");
        int choice = chooser.showSaveDialog(this);
        if (choice != JFileChooser.APPROVE_OPTION) return;

        File file = chooser.getSelectedFile();
        try {
            pricingModel.saveSelection(file, instrument, level);
            JOptionPane.showMessageDialog(this, "Saved selection to: " + file.getAbsolutePath(), "Saved", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Validation error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Failed to save: " + ex.getMessage(), "IO Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Use Swing thread
        SwingUtilities.invokeLater(() -> new MusicLessonApp(new LessonPricing()));
    }
}
