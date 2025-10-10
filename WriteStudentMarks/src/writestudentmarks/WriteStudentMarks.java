/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package writestudentmarks;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class WriteStudentMarks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String filename = "student_marks.txt";

        try (FileWriter writer = new FileWriter(filename, false)) {
            System.out.print("Enter Student Number: ");
            String studentNumber = input.nextLine();

            int[] marks = new int[4];
            for (int i = 0; i < 4; i++) {
                System.out.print("Enter Mark " + (i + 1) + ": ");
                marks[i] = input.nextInt();
            }

            // Write to file
            writer.write(studentNumber + "\n");
            for (int mark : marks) {
                writer.write(mark + " ");
            }

            System.out.println("\nData saved successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        input.close();
    }
}