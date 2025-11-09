/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movieticketgui;

/**
 *
 * @author lab_services_student
 */
public class MovieTicketData {
    private String movieName;
    private int numberOfTickets;
    private double ticketPrice;

    public MovieTicketData(String movieName, int numberOfTickets, double ticketPrice) {
        this.movieName = movieName;
        this.numberOfTickets = numberOfTickets;
        this.ticketPrice = ticketPrice;
    }

    public String getMovieName() { return movieName; }
    public int getNumberOfTickets() { return numberOfTickets; }
    public double getTicketPrice() { return ticketPrice; }
}
