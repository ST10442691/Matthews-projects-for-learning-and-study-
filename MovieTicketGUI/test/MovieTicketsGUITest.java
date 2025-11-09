/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import movieticketgui.MovieTicketData;
import movieticketgui.MovieTickets;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MovieTicketsGUITest {

    @Test
    public void CalculateTotalTicketPrice_CalculatedSuccessfully() {
        MovieTickets mt = new MovieTickets();
        double result = mt.CalculateTotalTicketPrice(2, 100.0);
        assertEquals(228.0, result, 0.01); // 2 * 100 * 1.14 = 228
    }

    @Test
    public void ValidationTest_InvalidPrice_ReturnsFalse() {
        MovieTickets mt = new MovieTickets();
        MovieTicketData data = new MovieTicketData("Napoleon", 2, 0);
        assertFalse(mt.ValidateData(data));
    }
}
