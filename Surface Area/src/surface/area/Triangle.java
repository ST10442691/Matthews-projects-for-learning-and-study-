/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package surface.area;

/**
 *
 * @author lab_services_student
 */
public class Triangle extends GeometricFigure {

    public Triangle(double height, double width) {
        super(height, width, "Triangle");
    }

    @Override
    public void determineArea() {
        area = 0.5 * height * width;
    }
}
