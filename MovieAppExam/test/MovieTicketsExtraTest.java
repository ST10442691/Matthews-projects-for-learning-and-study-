/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import movieappexam.MovieTickets;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieTicketsExtraTest {

    @Test
    public void testTotalMovieSales_MultipleMonths() {
        MovieTickets mt = new MovieTickets();
        int[] sales = {2800, 3500, 3200};
        assertEquals(9500, mt.TotalMovieSales(sales));
    }

    @Test
    public void testTopMovie_FindsCorrectOne() {
        MovieTickets mt = new MovieTickets();
        String[] movies = {"Dune 2", "Barbie", "Wonka"};
        int[] totals = {9500, 12200, 4800};
        assertEquals("Barbie", mt.TopMovie(movies, totals));
    }

    @Test
    public void testAverageSales_ReturnsAccurateValue() {
        MovieTickets mt = new MovieTickets();
        int[] sales = {3000, 2500, 2200, 2800, 2700, 3100};
        assertEquals(2716.67, mt.AverageSales(sales), 0.01);
    }
}
