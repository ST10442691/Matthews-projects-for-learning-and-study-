

package com.mycompany.cinemabookingsystem;


import java.util.Scanner;

public class CinemaBookingSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create the 2D array representing the cinema seats
        String[][] seats = {
            {"O", "O", "O", "O", "O"},
            {"O", "O", "O", "O", "O"},
            {"O", "O", "O", "O", "O"}
        };

        // Display initial seating layout
        displaySeats(seats);

        // Ask user to choose a seat
        System.out.print("Enter row number (0 to 2): ");
        int row = input.nextInt();

        System.out.print("Enter column number (0 to 4): ");
        int col = input.nextInt();

        //Check seat status and book if available
        if (seats[row][col].equals("O")) 
        {
            seats[row][col] = "X";
            System.out.println("Seat booked successfully!");
        } 
        
        else 
        {
            System.out.println("That seat is already booked. Please choose another one.");
        }

        //Display updated seating layout
        displaySeats(seats);
    }

    // Method to display current seat layout
    public static void displaySeats(String[][] layout) 
    {
        System.out.println("\n Cinema Seat Layout:");
        
        for (int i = 0; i < layout.length; i++) 
        {
            for (int j = 0; j < layout[i].length; j++) 
            {
                System.out.print(layout[i][j] + " ");
            }
           
            System.out.println(); // Move to next row
        }
        
        System.out.println(); // Add space after the layout
    }
}

