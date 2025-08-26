/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bubblesortheights;

/**
 *
 * @author lab_services_student
 */

     import java.util.Scanner;

public class BubbleSortHeights {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for number of players
        System.out.print("Enter the number of team members: ");
        int numPlayers = scanner.nextInt();

        // Create array for heights
        double[] heights = new double[numPlayers];

        // Input heights
        for (int i = 0; i < numPlayers; i++) { // FIXED: < instead of <=
            System.out.print("Enter height of player " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
        }

        // Bubble sort in descending order
        for (int pass = 0; pass < numPlayers - 1; pass++) {
            for (int j = 0; j < numPlayers - pass - 1; j++) { // FIXED: -1 at the end
                if (heights[j] < heights[j + 1]) {
                    double temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                }
            }
        }

        // Display sorted heights
        System.out.println("\nTeam members' heights in descending order:");
        for (int i = 0; i < numPlayers; i++) { // FIXED: start from 0
            System.out.println(heights[i]);
        }

        scanner.close();
    }
}
