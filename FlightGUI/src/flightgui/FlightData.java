/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flightgui;

/**
 *
 * @author lab_services_student
 */
public class FlightData {
    public String destination;
    public int tickets;
    public double price;
    public FlightData(String dest,int t,double p){
        this.destination=dest; this.tickets=t; this.price=p;
    }
}
