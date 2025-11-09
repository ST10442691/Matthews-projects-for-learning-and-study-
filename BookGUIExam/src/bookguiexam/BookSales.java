/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookguiexam;

/**
 *
 * @author lab_services_student
 */
public class BookSales implements IBookSales {
    private static final double VAT=0.14;

    @Override
    public double CalculateTotalSale(int quantity, double price){
        return quantity*price*(1+VAT);
    }

    @Override
    public boolean ValidateData(BookData data){
        if(data.bookName==null||data.bookName.isEmpty())return false;
        if(data.quantity<=0)return false;
        if(data.price<=0)return false;
        return true;
    }

    public double CalculateTotalSale(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
