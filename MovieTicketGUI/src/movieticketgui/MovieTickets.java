/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movieticketgui;

/**
 *
 * @author lab_services_student
 */
public class MovieTickets implements IMovieTickets {


    @Override
    public boolean ValidateData(MovieTicketData data) {
        return data.getMovieName() != null && !data.getMovieName().isEmpty()
            && data.getNumberOfTickets() > 0
            && data.getTicketPrice() > 0;
    }

    @Override
    public double CalculateTotalTicketPrice(int tickets, double price) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
