/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package home.makeover;



/**
 *
 * @author lab_services_student
 */

   public class HomeMakeoverReport {
    public static void main(String[] args) {
        // 1D arrays
        String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN"};
        String[] categories = {"Bathrooms", "Kitchens", "Garden"};

        // 2D array (rows = months, cols = categories)
        int[][] jobs = {
            {8, 2, 5},   // JAN
            {7, 4, 5},   // FEB
            {5, 5, 2},   // MAR
            {2, 2, 3},   // APR
            {7, 7, 9},   // MAY
            {7, 8, 5}    // JUN
        };

        // Print header
        System.out.println("=========================================");
        System.out.println("HOME MAKEOVER REPORT");
        System.out.println("=========================================");
        System.out.printf("%-6s %-10s %-10s %-10s\n", "", categories[0], categories[1], categories[2]);

        // Print monthly details
        for (int i = 0; i < jobs.length; i++) {
            System.out.printf("%-6s", months[i]);
            for (int j = 0; j < jobs[i].length; j++) {
                System.out.printf("%-10d", jobs[i][j]);
            }
            System.out.println();
        }

        System.out.println("=========================================");
        System.out.println("MONTHLY TOTALS");
        System.out.println("=========================================");

        // Calculate totals and display stars if >= 15
        for (int i = 0; i < jobs.length; i++) {
            int total = 0;
            for (int j = 0; j < jobs[i].length; j++) {
                total += jobs[i][j];
            }
            if (total >= 15) {
                System.out.printf("%-6s %-3d ***\n", months[i], total);
            } else {
                System.out.printf("%-6s %-3d\n", months[i], total);
            }
        }
    }
}
