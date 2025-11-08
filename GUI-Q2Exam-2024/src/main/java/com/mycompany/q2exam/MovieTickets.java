
package com.mycompany.q2exam;


public class MovieTickets implements IMovieTickets {

    private static final double VAT_RATE = 0.14;

    @Override
    public double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {
        double total = numberOfTickets * ticketPrice;
        double vat = total * VAT_RATE;
        return total + vat;
    }

    @Override
    public boolean ValidateData(MovieTicketData data) {
        if (data.getMovieName() == null || data.getMovieName().isEmpty()) return false;
        if (data.getNumberOfTickets() <= 0) return false;
        if (data.getTicketPrice() <= 0) return false;
        return true;
    }
}

