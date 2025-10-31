/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import cinema.MovieTickets;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MovieTicketsTest {

    @Test
    public void CalculateTotalSales_ReturnsExpectedTotalSales() {
        MovieTickets mt = new MovieTickets();
        int[] sales = {3000, 1500, 1700};
        int result = mt.TotalMovieSales(sales);
        assertEquals(6200, result);
    }

    @Test
    public void TopMovieSales_ReturnsTopMovie() {
        MovieTickets mt = new MovieTickets();
        String[] movies = {"Napoleon", "Oppenheimer"};
        int[] totals = {6200, 6300};
        String result = mt.TopMovie(movies, totals);
        assertEquals("Oppenheimer", result);
    }
}
