/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bookguiexam;

/**
 *
 * @author lab_services_student
 */
public interface IBookSales {
    double CalculateTotalSale(int quantity, double price);
    boolean ValidateData(BookData data);

    
}
