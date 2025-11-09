/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coffeegui;

/**
 *
 * @author lab_services_student
 */
public class CoffeeOrder implements ICoffeeOrder {

    public CoffeeOrder() {
    }

    private static final double VAT = 0.15;

    @Override
    public double CalculateTotalPrice(int numberOfCups, double pricePerCup) {
        return (numberOfCups * pricePerCup) * (1 + VAT);
    }

    @Override
    public boolean ValidateData(CoffeeData data) {
        if (data.coffeeName == null || data.coffeeName.isEmpty()) return false;
        if (data.numberOfCups <= 0) return false;
        if (data.pricePerCup <= 0) return false;
        return true;
    }
}
