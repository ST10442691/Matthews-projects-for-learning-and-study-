
package com.mycompany.q2exam;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author dengovender
 */
public class MovieTicketsTest {
    
   @Test
    public void CalculateTotalTicketPrice_CalculatedSuccessfully() {
        MovieTickets mt = new MovieTickets();
        double result = mt.CalculateTotalTicketPrice(2, 100);
        assertEquals(228, result, 0.01);
    }

    @Test
    public void ValidationTest_InvalidMovieName_ReturnsFalse() {
        MovieTickets mt = new MovieTickets();
        MovieTicketData invalid = new MovieTicketData("", 2, 100);
        assertFalse(mt.ValidateData(invalid));
    }

    @Test
    public void ValidationTest_ValidData_ReturnsTrue() {
        MovieTickets mt = new MovieTickets();
        MovieTicketData valid = new MovieTicketData("Napoleon", 3, 120);
        assertTrue(mt.ValidateData(valid));
    }
    
}
