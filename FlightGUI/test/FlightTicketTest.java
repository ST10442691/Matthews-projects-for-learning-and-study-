/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import flightgui.FlightData;
import flightgui.FlightTicket;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FlightTicketTest {
    FlightTicket flight;
    @BeforeEach void init(){flight=new FlightTicket();}

    @Test
    void CalculateTotalTicketPrice_CalculatedSuccessfully(){
        double result=flight.CalculateTotalTicketPrice(2,500);
        assertEquals(1140.0,result,0.01);
    }

    @Test
    void ValidationTests(){
        FlightData invalid=new FlightData("",0,-1);
        assertFalse(flight.ValidateData(invalid));
        FlightData valid=new FlightData("Durban",2,750);
        assertTrue(flight.ValidateData(valid));
    }
}
