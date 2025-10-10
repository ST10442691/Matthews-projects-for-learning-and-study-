/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package writestudentmarks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */

public class ReadStudentMarks {
    public static void main(String[] args) {
        String filename = "student_marks.txt";

        try (Scanner reader = new Scanner(new File(filename))) {
            String studentNumber = reader.nextLine();
            int[] marks = new int[4];

            for (int i = 0; i < 4 && reader.hasNextInt(); i++) {
                marks[i] = reader.nextInt();
            }

            System.out.println("Student Number – " + studentNumber);
            System.out.print("Mark 1 – " + marks[0] + " ");
            System.out.print("Mark 2 – " + marks[1] + " ");
            System.out.print("Mark 3 – " + marks[2] + " ");
            System.out.println("Mark 4 - " + marks[3]);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }
}