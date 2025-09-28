/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package road.accidents;

import java.util.Scanner;

public class RoadAccidentReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1D arrays
        String[] cities = {"Cape Town", "Johannesburg", "Port Elizabeth"};
        String[] vehicles = {"CAR", "MOTOR BIKE"};

        // 2D array [3 cities][2 vehicle types]
        int[][] accidents = new int[3][2];

        // Input data
        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < vehicles.length; j++) {
                System.out.print("Enter the number of " + vehicles[j] + " accidents for " + cities[i] + ": ");
                accidents[i][j] = sc.nextInt();
            }
        }

        System.out.println("=========================================");
        System.out.println("ROAD ACCIDENT REPORT");
        System.out.println("=========================================");
        System.out.printf("%-15s %-10s %-10s\n", "", vehicles[0], vehicles[1]);

        // Print accident details
        for (int i = 0; i < cities.length; i++) {
            System.out.printf("%-15s", cities[i]);
            for (int j = 0; j < vehicles.length; j++) {
                System.out.printf("%-10d", accidents[i][j]);
            }
            System.out.println();
        }

        System.out.println("=========================================");
        System.out.println("ROAD ACCIDENT TOTALS FOR EACH CITY");
        System.out.println("=========================================");

        int maxTotal = 0;
        String maxCity = "";

        // Print totals per city
        for (int i = 0; i < cities.length; i++) {
            int total = accidents[i][0] + accidents[i][1];
            System.out.printf("%-15s %-10d\n", cities[i], total);

            // Track city with most accidents
            if (total > maxTotal) {
                maxTotal = total;
                maxCity = cities[i];
            }
        }

        System.out.println("=========================================");
        System.out.println("CITY WITH THE MOST VEHICLE ACCIDENTS: " + maxCity);
    }
}
