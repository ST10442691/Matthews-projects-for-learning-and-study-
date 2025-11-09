/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movieappexam;

/**
 *
 * @author lab_services_student
 */
public class MovieTickets implements IMovieTickets {
    @Override
    public int TotalMovieSales(int[] sales) {
        int total = 0;
        for (int s : sales) total += s;
        return total;
    }

    @Override
    public String TopMovie(String[] movies, int[] totals) {
        int max = 0;
        for (int i = 1; i < totals.length; i++)
            if (totals[i] > totals[max]) max = i;
        return movies[max];
    }

    @Override
    public double AverageSales(int[] sales) {
        return (double) TotalMovieSales(sales) / sales.length;
    }
}
