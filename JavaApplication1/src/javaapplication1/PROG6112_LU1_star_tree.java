/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author lab_services_student
 */
// PROG6112_LU1_star_tree.java
public class PROG6112_LU1_star_tree {
    public static void main(String[] args) {
        int rows = 5; // You can adjust this number for a larger or smaller tree

        for (int i = 1; i <= rows; i++) {      // Outer loop: number of rows
            for (int j = 1; j <= i; j++) {     // Inner loop: number of stars per row
                System.out.print("*");         // Print one star only
            }
            System.out.println();              // Move to the next line
        }
    }
}
