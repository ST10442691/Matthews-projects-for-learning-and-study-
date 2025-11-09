/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flightgui;

/**
 *
 * @author lab_services_student
 */
public class FlightTicket implements IFlightTicket {
    private static final double VAT=0.14;

    @Override
    public double CalculateTotalTicketPrice(int tickets,double price){
        return tickets*price*(1+VAT);
    }

    @Override
    public boolean ValidateData(FlightData data){
        if(data.destination==null||data.destination.isEmpty())return false;
        if(data.tickets<=0)return false;
        if(data.price<=0)return false;
        return true;
    }

    public double CalculateTotalTicketPrice(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
