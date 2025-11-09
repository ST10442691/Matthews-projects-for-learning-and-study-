/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package movieappexam;

/**
 *
 * @author lab_services_student
 */
public class MovieAppExam {
    public static void main(String[] args) {
       
        String[] months = {"Jan", "Feb", "Mar", "Apr"};
        String[] movies = {"Avatar 2", "Sonic 3", "Batman 2", "The Marvels"};
        int[][] sales = {
            {5000, 4800, 5200, 5100},
            {2500, 2300, 2800, 2600},
            {4200, 3900, 4100, 4300},
            {3000, 3100, 2900, 3050}
        };

        MovieTickets mt = new MovieTickets();
        int[] totals = new int[movies.length];

        System.out.printf("%-12s", "Movie");
        for (String m : months) System.out.printf("%-8s", m);
        System.out.println("Total");

        for (int i = 0; i < movies.length; i++) {
            totals[i] = mt.TotalMovieSales(sales[i]);
            System.out.printf("%-12s", movies[i]);
            for (int j = 0; j < sales[i].length; j++)
                System.out.printf("%-8d", sales[i][j]);
            System.out.println(totals[i]);
        }

        System.out.println("\nTop Performing Movie: " + mt.TopMovie(movies, totals));
    }
}