/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coffeegui;

/**
 *
 * @author lab_services_student
 */
public class CoffeeData {
    public String coffeeName;
    public int numberOfCups;
    public double pricePerCup;

    public CoffeeData(String name, int cups, double price) {
        this.coffeeName = name;
        this.numberOfCups = cups;
        this.pricePerCup = price;
    }
}
