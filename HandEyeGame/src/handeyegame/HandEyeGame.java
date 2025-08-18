/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package handeyegame;

/**
 *
 * @author lab_services_student
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class HandEyeGame extends JFrame {
    private final JPanel boardPanel;
    private final JButton[][] squares;
    private final JLabel instructionsLabel;
    private final JLabel titleLabel;
    private int score = 0;
    private final int rows = 5;
    private final int cols = 4;
    private final Random random;
    private int xRow = -1, xCol = -1; // Track current X position

    public HandEyeGame() {
        super("Hand-Eye Coordination Game");

        // Title label
        titleLabel = new JLabel("Hand-Eye Coordination Game", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Instructions label
        instructionsLabel = new JLabel("Click on the square with the 'X' ten times to win!", JLabel.CENTER);

        // Game board setup
        boardPanel = new JPanel(new GridLayout(rows, cols));
        squares = new JButton[rows][cols];
        random = new Random();

        // Initialize squares
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JButton btn = new JButton();
                btn.setFont(new Font("Arial", Font.BOLD, 24));
                btn.setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.BLACK);
                btn.setForeground(Color.RED);

                int row = i, col = j;
                btn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (row == xRow && col == xCol) {
                            score++;
                            if (score == 10) {
                                JOptionPane.showMessageDialog(null, "Congratulations!");
                                resetGame();
                            } else {
                                moveX();
                            }
                        }
                    }
                });

                squares[i][j] = btn;
                boardPanel.add(btn);
            }
        }

        // Add components to JFrame
        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER);
        add(instructionsLabel, BorderLayout.SOUTH);

        // Show first X
        moveX();

        // Frame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void moveX() {
        // Clear previous X
        if (xRow >= 0 && xCol >= 0) {
            squares[xRow][xCol].setText("");
        }
        // Place new X randomly
        xRow = random.nextInt(rows);
        xCol = random.nextInt(cols);
        squares[xRow][xCol].setText("X");
    }

    private void resetGame() {
        score = 0;
        moveX();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HandEyeGame());
    }
}
