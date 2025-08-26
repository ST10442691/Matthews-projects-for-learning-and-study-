/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package surface.area;

/**
 *
 * @author lab_services_student
 */
public abstract class GeometricFigure {
    protected double height;
    protected double width;
    protected String figureType;
    protected double area;

    public GeometricFigure(double height, double width, String figureType) {
        this.height = height;
        this.width = width;
        this.figureType = figureType;
    }

    // Abstract method to be implemented by subclasses
    public abstract void determineArea();

    public double getArea() {
        return area;
    }

    public String getFigureType() {
        return figureType;
    }
}
