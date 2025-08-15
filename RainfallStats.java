/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rainfallstats;

/**
 *
 * @author lab_services_student
 */
import java.util.Scanner;

public class RainfallStats {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 3 towns, 12 months
        double[][] rainfall = new double[3][12];

        // Input rainfall data
        for (int town = 0; town < 3; town++) {
            System.out.println("Enter rainfall data for Town " + (town + 1) + " (in mm):");
            for (int month = 0; month < 12; month++) {
                System.out.print("Month " + (month + 1) + ": ");
                rainfall[town][month] = scanner.nextDouble();
            }
            System.out.println();
        }

        // Calculate and display total annual rainfall for each town
        calculateAnnualRainfall(rainfall);

        // Calculate and display average monthly rainfall across towns
        calculateAverageMonthlyRainfall(rainfall);

        scanner.close();
    }

    // Method to calculate and display total annual rainfall for each town
    public static void calculateAnnualRainfall(double[][] data) {
        System.out.println("\nTotal Annual Rainfall for each Town:");
        for (int town = 0; town < data.length; town++) {
            double total = 0;
            for (int month = 0; month < data[town].length; month++) {
                total += data[town][month];
            }
            System.out.println("Town " + (town + 1) + ": " + total + " mm");
        }
    }

    // Method to calculate and display average monthly rainfall for all towns
    public static void calculateAverageMonthlyRainfall(double[][] data) {
        System.out.println("\nAverage Monthly Rainfall across all towns:");
        for (int month = 0; month < 12; month++) {
            double sum = 0;
            for (int town = 0; town < 3; town++) {
                sum += data[town][month];
            }
            double average = sum / 3;
            System.out.println("Month " + (month + 1) + ": " + average + " mm");
        }
    }
}
