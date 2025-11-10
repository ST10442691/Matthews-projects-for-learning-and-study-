/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;

/**
 *
 * @author lab_services_student
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[][] cars = {
    {"Camaro", "Corvette", "Silverado"},
    {"Mustang", "Ranger", "F-150"},
    {"Ferrari", "Lambo", "Tesla"}
};

cars[0][0] = "Camaro";
cars[0][1] = "Corvette";
// ...
for (int i = 0; i < cars.length; i++) {
    for (int j = 0; j < cars[i].length; j++) {
        System.out.print(cars[i][j] + " ");
    }
    System.out.println();
}

    }
    
}
