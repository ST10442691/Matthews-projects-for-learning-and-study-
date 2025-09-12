/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package runapplication;


import java.util.Scanner;
/**
 *
 * @author lab_services_student
 */


public class RunApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        
        //Prompt the user to input Accident  details

        
      System.out.print("Enter the accident vehicle type: ");
        String vehicleType = input.nextLine();

        System.out.print("Enter the city for the vehicle accidents: ");
        String city = input.nextLine();

        System.out.print("Enter the total " + vehicleType + " accidents for " + city + ": ");
        int total = input.nextInt();

        // Create report object
        RoadAccidentReport report = new RoadAccidentReport(vehicleType, city, total);

        // Print the report
        report.printAccidentReport();

        input.close();
    }
}
