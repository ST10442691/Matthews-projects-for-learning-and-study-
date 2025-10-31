/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cinema;

import java.util.Scanner;

public class MovieTicketApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MovieTickets mt = new MovieTickets();

        System.out.print("Enter the number of movies: ");
        int numMovies = input.nextInt();
        input.nextLine(); // consume newline

        String[] movies = new String[numMovies];

        System.out.print("Enter the number of months: ");
        int numMonths = input.nextInt();
        input.nextLine(); // consume newline

        String[] months = new String[numMonths];
        System.out.println("Enter the names of the months:");
        for (int i = 0; i < numMonths; i++) {
            System.out.print("Month " + (i + 1) + ": ");
            months[i] = input.nextLine();
        }

        int[][] sales = new int[numMovies][numMonths];

        // Get movie names and sales
        for (int i = 0; i < numMovies; i++) {
            System.out.print("\nEnter name of movie " + (i + 1) + ": ");
            movies[i] = input.nextLine();

            for (int j = 0; j < numMonths; j++) {
                System.out.print("Enter tickets sold for " + movies[i] + " in " + months[j] + ": ");
                sales[i][j] = input.nextInt();
            }
            input.nextLine(); // consume newline
        }

        // Calculate totals
        int[] totalSales = new int[numMovies];
        for (int i = 0; i < numMovies; i++) {
            totalSales[i] = mt.TotalMovieSales(sales[i]);
        }

        // Display report
        System.out.println("\n===== MOVIE SALES REPORT =====");
        System.out.print(String.format("%-15s", "Movie"));
        for (String month : months) {
            System.out.print(String.format("%-10s", month));
        }
        System.out.println("Total");

        for (int i = 0; i < numMovies; i++) {
            System.out.print(String.format("%-15s", movies[i]));
            for (int j = 0; j < numMonths; j++) {
                System.out.print(String.format("%-10d", sales[i][j]));
            }
            System.out.println(totalSales[i]);
        }

        String topMovie = mt.TopMovie(movies, totalSales);
        System.out.println("\nTop Performing Movie: " + topMovie);
    }
}
