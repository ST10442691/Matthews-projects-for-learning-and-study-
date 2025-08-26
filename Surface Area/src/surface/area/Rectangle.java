/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package surface.area;

/**
 *
 * @author lab_services_student
 */
public class Rectangle extends GeometricFigure {

    public Rectangle(double height, double width) {
        super(height, width, "Rectangle");
    }

    @Override
    public void determineArea() {
        area = height * width;
    }
}
