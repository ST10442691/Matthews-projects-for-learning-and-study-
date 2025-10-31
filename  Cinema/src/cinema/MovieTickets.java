/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema;

/**
 *
 * @author lab_services_student
 */
public class MovieTickets implements IMovieTickets {

    @Override
    public int TotalMovieSales(int[] movieTicketSales) {
        int total = 0;
        for (int sale : movieTicketSales) {
            total += sale;
        }
        return total;
    }

    @Override
    public String TopMovie(String[] movies, int[] totalSales) {
        int max = totalSales[0];
        int index = 0;
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > max) {
                max = totalSales[i];
                index = i;
            }
        }
        return movies[index];
    }
}
