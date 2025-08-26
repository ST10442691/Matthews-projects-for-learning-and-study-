/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package surface.area;

/**
 *
 * @author lab_services_student
 */
import javax.swing.JOptionPane;

public class SurfaceArea {
    public static void main(String[] args) {
        // Input for triangles
        double triHeight = Double.parseDouble(
            JOptionPane.showInputDialog("Enter the height of the triangular sides:")
        );

        double triWidth = Double.parseDouble(
            JOptionPane.showInputDialog("Enter the width (base) of the triangular sides:")
        );

        // Input for rectangle
        double rectHeight = Double.parseDouble(
            JOptionPane.showInputDialog("Enter the height of the rectangular base:")
        );

        double rectWidth = Double.parseDouble(
            JOptionPane.showInputDialog("Enter the width of the rectangular base:")
        );

        // Create figures for a tent (2 triangular sides + 1 rectangular base)
        GeometricFigure[] figures = new GeometricFigure[3];

        figures[0] = new Triangle(triHeight, triWidth);
        figures[1] = new Triangle(triHeight, triWidth);
        figures[2] = new Rectangle(rectHeight, rectWidth);

        double totalArea = 0;
        StringBuilder result = new StringBuilder("--- Calculating Areas ---\n");

        for (GeometricFigure fig : figures) {
            fig.determineArea();
            result.append(fig.getFigureType())
                  .append(" area = ")
                  .append(fig.getArea())
                  .append("\n");
            totalArea += fig.getArea();
        }

        result.append("\nTotal surface area of the tent = ").append(totalArea);

        // Show result in a message dialog
        JOptionPane.showMessageDialog(null, result.toString(), "Surface Area Results", JOptionPane.INFORMATION_MESSAGE);
    }
}
