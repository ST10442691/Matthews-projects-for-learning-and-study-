/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coffeegui;

/**
 *
 * @author lab_services_student
 */
public interface ICoffeeOrder {
    double CalculateTotalPrice(int numberOfCups, double pricePerCup);
    boolean ValidateData(CoffeeData data);
}
