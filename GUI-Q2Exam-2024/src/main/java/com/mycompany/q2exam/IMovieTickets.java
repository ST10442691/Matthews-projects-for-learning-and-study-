
package com.mycompany.q2exam;


public interface IMovieTickets {
    double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice);
    boolean ValidateData(MovieTicketData movieTicketData); 
}
