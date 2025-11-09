/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package movieticketgui;

/**
 *
 * @author lab_services_student
 */
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MovieTicketGUI extends JFrame {
    private final JComboBox<String> cmbMovies;
    private JTextField txtTickets, txtPrice;
    private JTextArea txtReport;
    private final JMenuItem mnuProcess;
    private final JMenuItem mnuClear;
    private final JMenuItem mnuExit;
    private final MovieTickets mt = new MovieTickets();

    public MovieTicketGUI() {
        setTitle("Movie Ticket Sales");
        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel for inputs
        JPanel pnlInput = new JPanel(new GridLayout(3, 2, 5, 5));
        pnlInput.add(new JLabel("Select Movie:"));
        cmbMovies = new JComboBox<>(new String[]{"Napoleon", "Oppenheimer", "Damsel"});
        pnlInput.add(cmbMovies);

        pnlInput.add(new JLabel("Number of Tickets:"));
        txtTickets = new JTextField();
        pnlInput.add(txtTickets);

        pnlInput.add(new JLabel("Ticket Price:"));
        txtPrice = new JTextField();
        pnlInput.add(txtPrice);

        add(pnlInput, BorderLayout.NORTH);

        // Text area
        txtReport = new JTextArea();
        txtReport.setEditable(false);
        add(new JScrollPane(txtReport), BorderLayout.CENTER);

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        mnuExit = new JMenuItem("Exit");
        mnuProcess = new JMenuItem("Process");
        mnuClear = new JMenuItem("Clear");

        fileMenu.add(mnuExit);
        toolsMenu.add(mnuProcess);
        toolsMenu.add(mnuClear);
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // Event handlers
        mnuExit.addActionListener(e -> System.exit(0));

        mnuClear.addActionListener(e -> {
            txtTickets.setText("");
            txtPrice.setText("");
            txtReport.setText("");
        });

        mnuProcess.addActionListener(e -> processTicket());

        setVisible(true);
    }

    private void processTicket() {
        String movie = cmbMovies.getSelectedItem().toString();
        try {
            int tickets = Integer.parseInt(txtTickets.getText());
            double price = Double.parseDouble(txtPrice.getText());

            MovieTicketData data = new MovieTicketData(movie, tickets, price);

            if (!mt.ValidateData(data)) {
                JOptionPane.showMessageDialog(this, "Invalid input data!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double totalWithVat = mt.CalculateTotalTicketPrice(tickets, price);

            String report = String.format(
                "Movie: %s%nTickets: %d%nTicket Price: %.2f%nTotal (incl. VAT): %.2f%n",
                movie, tickets, price, totalWithVat
            );

            txtReport.setText(report);
            saveReport(report);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveReport(String report) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("report.txt", true))) {
            writer.println(report);
            JOptionPane.showMessageDialog(this, "Report saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving report: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new MovieTicketGUI();
    }
}
