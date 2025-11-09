/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flightgui;

/**
 *
 * @author lab_services_student
 */
public interface IFlightTicket {
    double CalculateTotalTicketPrice(int tickets,double price);
    boolean ValidateData(FlightData data);

    
}
